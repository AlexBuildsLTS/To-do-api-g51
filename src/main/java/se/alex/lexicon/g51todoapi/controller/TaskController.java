package se.alex.lexicon.g51todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.alex.lexicon.g51todoapi.dto.TaskDto;
import se.alex.lexicon.g51todoapi.entity.Task;
import se.alex.lexicon.g51todoapi.entity.Person;
import se.alex.lexicon.g51todoapi.service.TaskService;
import se.alex.lexicon.g51todoapi.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final PersonService personService;

    @Autowired
    public TaskController(TaskService taskService, PersonService personService) {
        this.taskService = taskService;
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
        Person person = personService.findById(taskDto.getPersonId());
        Task newTask = taskService.createTask(taskDto.getTitle(), taskDto.getDescription(), person);
        return ResponseEntity.ok(newTask);
    }

    @PutMapping("/{id}/done")
    public ResponseEntity<Void> markTaskAsDone(@PathVariable Long id) {
        Task task = taskService.findById(id);
        taskService.markTaskAsDone(task);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<Task>> getTasksByPerson(@PathVariable Long personId) {
        Person person = personService.findById(personId);
        List<Task> tasks = taskService.findByPerson(person);
        return ResponseEntity.ok(tasks);
    }
}
