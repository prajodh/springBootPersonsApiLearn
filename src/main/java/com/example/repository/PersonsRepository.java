package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Persons;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, Integer>{
    
}
