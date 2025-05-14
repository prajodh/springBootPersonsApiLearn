package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Persons;
import com.example.repository.PersonsRepository;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping(path = "/persons")
public class PersonsController {
    
    @Autowired
    private PersonsRepository personsRepository;

    @PostMapping("/add")
    public @ResponseBody String addPersons(@RequestParam String name, @RequestParam Integer age, @RequestParam String sex){
        Persons person = new Persons();
        person.setName(name);
        person.setAge(age);
        person.setSex(sex);
        personsRepository.save(person);
        return "Person saved sucessfully";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Persons> getAllPersons(){
        return personsRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deletePerson(@PathVariable Integer id){
        personsRepository.deleteById(id);
        return "deleted person";    
    }
}
