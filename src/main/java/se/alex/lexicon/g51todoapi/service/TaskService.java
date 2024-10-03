package se.alex.lexicon.g51todoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.alex.lexicon.g51todoapi.entity.Task;
import se.alex.lexicon.g51todoapi.entity.Person;
import se.alex.lexicon.g51todoapi.repository.TaskRepository;
import se.alex.lexicon.g51todoapi.repository.PersonRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final PersonRepository personRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, PersonRepository personRepository) {
        this.taskRepository = taskRepository;
        this.personRepository = personRepository;
    }

    public Task createTask(String title, String description, Person person) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setPerson(person);
        return taskRepository.save(task);
    }

    public List<Task> findByPerson(Person person) {
        return taskRepository.findByPerson(person);
    }

    public void markTaskAsDone(Task task) {
        task.setDone(true);
        taskRepository.save(task);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
}
