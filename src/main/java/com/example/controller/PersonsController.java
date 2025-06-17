package com.example.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.model.Persons;
import com.example.service.PersonsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "v1/persons")
public class PersonsController {
    @Autowired
    private PersonsService personsService;

    @PostMapping
    @Operation(summary = "API to create a new person record")
    public ResponseEntity<Persons> addPersons(@RequestBody Persons person){
        return ResponseEntity.ok().body(personsService.createPerson(person));
    }

    @GetMapping("/{id}")
    @Operation(summary = "API to get a person using their unique id")
    public ResponseEntity<Persons> getPersonById(@PathVariable String id) {
        Optional<Persons> persons = personsService.getPersonById(id);
        return persons.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "API to update a person's record using their unique id")
    public ResponseEntity<Persons> updatePersonsById(@RequestBody Persons persons, @PathVariable String id) {
        return ResponseEntity.ok().body(personsService.updatePerson(id, persons));
    }

    @GetMapping
    @Operation(summary = "API to get all persons")
    public ResponseEntity<List<Persons>> getAllPersons() {
        return ResponseEntity.ok().body(personsService.getAllPersons());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "API to delete a person by their unique id")
    public ResponseEntity<Void> deletePerson(@PathVariable String id){
        personsService.deletePerson(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/above-age")
    @Operation(summary = "API to get all users above a certain age")
    public ResponseEntity<List<Persons>> getAllAboveAge(@RequestParam int age){
        return ResponseEntity.ok().body(personsService.getPersonsAboveAge(age));
    }
}
