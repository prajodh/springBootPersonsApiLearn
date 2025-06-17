package com.example.service;

import com.example.model.Persons;
import com.example.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonsService {

    @Autowired
    private PersonsRepository personsRepository;

    // Create
    public Persons createPerson(Persons person) {
        return personsRepository.save(person);
    }

    // Read all
    public List<Persons> getAllPersons() {
        Iterable<Persons> iterable = personsRepository.findAll();
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    // Read by ID
    public Optional<Persons> getPersonById(String id) {
        return personsRepository.findById(id);
    }

    // Update
    public Persons updatePerson(String id, Persons updatedPerson) {
        return personsRepository.findById(id)
            .map(existing -> {
                if (updatedPerson.getName() != null) {
                    existing.setName(updatedPerson.getName());
                }
                if (updatedPerson.getAge() != null) {
                    existing.setAge(updatedPerson.getAge());
                }
                if (updatedPerson.getSex() != null) {
                    existing.setSex(updatedPerson.getSex());
                }
                return personsRepository.save(existing);
            })
            .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
    }

    // Delete
    public void deletePerson(String id) {
        personsRepository.deleteById(id);
    }

    // Custom query example
    public List<Persons> getPersonsAboveAge(int age) {
        return personsRepository.findByAgeGreaterThan(age);
    }
}
