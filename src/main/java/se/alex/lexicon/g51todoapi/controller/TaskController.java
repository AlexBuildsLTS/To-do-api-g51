package se.alex.lexicon.g51todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.alex.lexicon.g51todoapi.entity.Person;
import se.alex.lexicon.g51todoapi.entity.Task;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServiceImpl taskService;

    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task newTask = taskService.createTask(task.getTitle(), task.getDescription(), task.getPerson());
        return ResponseEntity.ok(newTask);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<Task>> getTasksByPerson(@PathVariable Long personId) {
        List<Task> tasks = taskService.findByPerson(new Person(personId, null, null, null));
        return ResponseEntity.ok(tasks);
    }
}
