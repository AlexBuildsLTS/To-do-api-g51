package se.alex.lexicon.g51todoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.alex.lexicon.g51todoapi.domain.dto.RoleDTOView;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOView;
import se.alex.lexicon.g51todoapi.domain.entity.Role;
import se.alex.lexicon.g51todoapi.domain.entity.User;
import se.alex.lexicon.g51todoapi.exception.DataDuplicateException;
import se.alex.lexicon.g51todoapi.exception.DataNotFoundException;
import se.alex.lexicon.g51todoapi.repository.RoleRepository;
import se.alex.lexicon.g51todoapi.repository.UserRepository;
import se.alex.lexicon.g51todoapi.service.UserService;
import se.alex.lexicon.g51todoapi.util.CustomPasswordEncoder;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CustomPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, CustomPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTOView register(UserDTOForm userDTOForm) {
        if (userDTOForm == null) throw new IllegalArgumentException("User form cannot be null");

        boolean doesExistEmail = userRepository.existsByEmail(userDTOForm.getEmail());
        if (doesExistEmail) throw new DataDuplicateException("Email already exists");

        Set<Role> roles = userDTOForm.getRoles().stream()
                .map(roleDTOForm -> roleRepository.findById(roleDTOForm.getId())
                        .orElseThrow(() -> new DataNotFoundException("Role not found")))
                .collect(Collectors.toSet());

        User user = User.builder()
                .email(userDTOForm.getEmail())
                .password(passwordEncoder.encode(userDTOForm.getPassword()))
                .roles(roles)
                .build();

        User savedUser = userRepository.save(user);

        Set<RoleDTOView> roleDTOViews = savedUser.getRoles().stream()
                .map(role -> new RoleDTOView(role.getId(), role.getName()))
                .collect(Collectors.toSet());

        return UserDTOView.builder()
                .email(savedUser.getEmail())
                .roles(roleDTOViews)
                .build();
    }

    @Override
    public UserDTOView getByEmail(String email) {
        User user = userRepository.findById(email)
                .orElseThrow(() -> new DataNotFoundException("Email not found"));

        Set<RoleDTOView> roleDTOViews = user.getRoles().stream()
                .map(role -> new RoleDTOView(role.getId(), role.getName()))
                .collect(Collectors.toSet());

        return UserDTOView.builder()
                .email(user.getEmail())
                .roles(roleDTOViews)
                .build();
    }

    @Override
    public void disableByEmail(String email) {
        if (!userRepository.existsByEmail(email)) throw new DataNotFoundException("Email not found");
        userRepository.updateExpiredByEmail(email, true);
    }

    @Override
    public void enableByEmail(String email) {
        if (!userRepository.existsByEmail(email)) throw new DataNotFoundException("Email not found");
        userRepository.updateExpiredByEmail(email, false);
    }
}
