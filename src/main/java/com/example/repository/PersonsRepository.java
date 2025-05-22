package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.example.model.Persons;
import java.util.List;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, Integer>{
   @Query("select p from Persons p where p.age > 18")
   List<Persons> findAllAboveAge();
}
