package se.alex.lexicon.g51todoapi.dto;

import lombok.Getter;
import lombok.Setter;
import se.alex.lexicon.g51todoapi.entity.Person;

import java.time.LocalDate;

@Setter
@Getter
public class TaskDto {

    // Getters and Setters
    private String title;
    private String description;
    private LocalDate deadline;
    private Long personId;  // To link a Task to a person
    private Long id;
    private boolean done;
    private Person person;

    // Constructors
    public TaskDto() {}

    public TaskDto(String title, String description, LocalDate deadline, Long personId,
                   Long id,
                   boolean done,
                   Person person) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.personId = personId;
        this.id = id;
        this.done = done;
        this.person = person;
    }

}
