package se.alex.lexicon.g51todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.alex.lexicon.g51todoapi.entity.Person;
import se.alex.lexicon.g51todoapi.entity.Task;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // You can add custom methods if needed

    interface TaskRepository extends JpaRepository<Task, Long> {
    }
}
