package com.example.repository;

import com.example.model.Persons;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonsRepository extends CosmosRepository<Persons, String> {
    List<Persons> findByAgeGreaterThan(int age);
}
