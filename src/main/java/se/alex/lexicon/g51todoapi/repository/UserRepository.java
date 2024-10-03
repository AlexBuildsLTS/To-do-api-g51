package se.alex.lexicon.g51todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.alex.lexicon.g51todoapi.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);
}
