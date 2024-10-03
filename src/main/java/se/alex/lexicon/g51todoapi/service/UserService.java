package se.alex.lexicon.g51todoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.alex.lexicon.g51todoapi.entity.User;
import se.alex.lexicon.g51todoapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String email, String password) {
        User user = new User(email, password, false, null);
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findById(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
