package se.alex.lexicon.g51todoapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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
}
