package se.alex.lexicon.g51todoapi.service;

import se.alex.lexicon.g51todoapi.domain.dto.UserDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOView;

public interface UserService {
    // Registers a new user
    UserDTOView register(UserDTOForm userDTOForm);

    // Retrieves a user by their email
    UserDTOView getByEmail(String email);

    // Disables a user by their email
    void disableByEmail(String email);

    // Enables a user by their email
    void enableByEmail(String email);
}
