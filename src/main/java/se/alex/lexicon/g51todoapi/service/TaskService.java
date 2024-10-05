package se.alex.lexicon.g51todoapi.service;

import se.alex.lexicon.g51todoapi.domain.entity.Person;
import se.alex.lexicon.g51todoapi.domain.entity.Task;

import java.util.List;

public interface TaskService {
    // Create a new task
    Task createTask(String title, String description, Person person);

    // Find tasks by person
    List<Task> findByPerson(Person person);

    // Mark a task as done
    void markTaskAsDone(Task task);

    // Find task by ID
    Task findById(Long id);
}
