package se.alex.lexicon.g51todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.alex.lexicon.g51todoapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
