package se.alex.lexicon.g51todoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.alex.lexicon.g51todoapi.domain.entity.Person;
import se.alex.lexicon.g51todoapi.domain.entity.Task;
import se.alex.lexicon.g51todoapi.repository.TaskRepository;
import se.alex.lexicon.g51todoapi.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String title, String description, Person person) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setPerson(person);
        task.setDone(false);

        return taskRepository.save(task);
    }

    @Override
    public List<Task> findByPerson(Person person) {
        return taskRepository.findByPerson(person);
    }

    @Override
    public void markTaskAsDone(Task task) {
        task.setDone(true);
        taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }
}
