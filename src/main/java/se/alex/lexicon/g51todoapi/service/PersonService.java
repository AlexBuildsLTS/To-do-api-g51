package se.alex.lexicon.g51todoapi.service;

import se.alex.lexicon.g51todoapi.entity.Person;

public interface PersonService {
    // Finds a person by ID
    Person findById(Long id);
}
