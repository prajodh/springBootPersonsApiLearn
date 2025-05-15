package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.model.Persons;
import com.example.service.PersonsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping(path = "v1/persons")
public class PersonsController {
    @Autowired
    private PersonsService personsService;

    @PostMapping
    public @ResponseBody Persons addPersons(@RequestBody Persons person){
        return personsService.savePerson(person);
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Persons> getPersonById(@PathVariable Integer id) {
        return personsService.findPersonById(id);
    }
    

    @GetMapping
    public @ResponseBody Page<Persons> getAllPersons(@RequestParam Integer page, @RequestParam Integer pageSize){
        return personsService.findAllPerson(page, pageSize);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deletePerson(@PathVariable Integer id){
        return personsService.deletePerson(id);    
    }
}
