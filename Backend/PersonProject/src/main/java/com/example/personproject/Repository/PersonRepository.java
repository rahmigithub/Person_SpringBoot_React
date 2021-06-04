package com.example.personproject.Repository;

import com.example.personproject.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer>  {
}
