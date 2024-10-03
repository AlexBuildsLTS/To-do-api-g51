package se.alex.lexicon.g51todoapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String title;

    private LocalDate deadline;

    private boolean done;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    // Removed static createTask method and replaced with a proper constructor
    public Task(String title, String description, Person person) {
        this.title = title;
        this.description = description;
        this.person = person;
        this.done = false; // Default done status
    }

    public Task() {
        // Default constructor
    }
}
