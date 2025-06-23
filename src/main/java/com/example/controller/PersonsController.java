package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.PersonsDto;
import com.example.mapper.PersonsMapper;
import com.example.model.Persons;
import com.example.service.PersonsService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;



@Controller
@RequestMapping(path = "v1/persons")
public class PersonsController {
    @Autowired
    private PersonsService personsService;

    private PersonsMapper personsMapper;

    @PostMapping
    @Operation(summary = "api to create a new person record")
    public @ResponseBody ResponseEntity<Persons> addPersons(@RequestBody PersonsDto persondto){
        Persons persons = personsMapper.toEntity(persondto);
        return ResponseEntity.ok().body(personsService.savePerson(persons));
    }

    @GetMapping("/{id}")
    @Operation(summary = "api to get a person using their unique")
    public @ResponseBody ResponseEntity<Persons> getPersonById(@PathVariable Integer id) {
        Optional<Persons> persons = personsService.findPersonById(id);
        if (persons.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(persons.get());
    }

   @PutMapping("/{id}")
   @Operation(summary = "api to update a persons record using their unique id")
   public ResponseEntity<Persons> updatePersonsById(@RequestBody Persons persons,@PathVariable Integer id) {
       
       return ResponseEntity.ok().body(personsService.updatePersonById(persons, id));
   } 

    @GetMapping
    @Operation(summary = "api to get all persons")
    public @ResponseBody ResponseEntity<Page<Persons>> getAllPersons(@RequestParam Integer page, @RequestParam Integer pageSize){
        return ResponseEntity.ok().body(personsService.findAllPerson(page, pageSize));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "api to delete a person by their unique id")
    public @ResponseBody ResponseEntity<String> deletePerson(@PathVariable Integer id){
        return ResponseEntity.ok().body(personsService.deletePerson(id));    
    }

    @GetMapping("/above-age")
    @Operation(summary = "api to get all users above the drinking age")
    public @ResponseBody ResponseEntity<List<Persons>> getAllAboveAge(){
        return ResponseEntity.ok().body(personsService.getAllAboveAge());
    }
}
