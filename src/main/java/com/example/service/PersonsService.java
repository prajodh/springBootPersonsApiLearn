package com.example.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Persons;
import com.example.repository.PersonsRepository;

@Service
public class PersonsService {

    @Autowired
    private PersonsRepository personsRepository;

    public Persons savePerson(Persons person){
        return personsRepository.save(person);
    }

    public Optional<Persons> findPersonById(Integer id){
        return personsRepository.findById(id);
    }

    public Page<Persons> findAllPerson(Integer page, Integer pageSize){
        Pageable pageable = PageRequest.of(pageSize, pageSize);
        return personsRepository.findAll(pageable);
    }

    public String deletePerson(Integer id){
        personsRepository.deleteById(id);
        return "Deleted person";
    }

    public Persons updatePersonById(Persons person, Integer id){
        return personsRepository.findById(id).map(per->{
            per.setName(person.getName());
            per.setAge(person.getAge());
            per.setSex(person.getSex());
            return personsRepository.save(per);
        })
        .orElseGet(()->{
            return personsRepository.save(person);
    });
    }
}
