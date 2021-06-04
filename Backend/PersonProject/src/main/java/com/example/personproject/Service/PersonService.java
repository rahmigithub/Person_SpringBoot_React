package com.example.personproject.Service;


import com.example.personproject.Model.Person;
import com.example.personproject.Repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    public void Save(Person person) {
        log.info("----- PersonService paketi içerisindeki save metodu çalıştırıldı.");
        person.setDeleted(false);
        personRepository.save(person);
        log.info("-----Verinin veritabanına kaydı gerçekleşti.");
    }
    public void Update(Person person){

        Person tempPerson= FindById(person.getId());
        tempPerson.setName(person.getName());
        tempPerson.setSurname(person.getSurname());
        tempPerson.setEmail(person.getEmail());
        tempPerson.setDeleted(person.getDeleted());
        personRepository.save(tempPerson);

    }

    public void Delete(int  id) {
        Person person = FindById(id);
        person.setDeleted(true);

        personRepository.save(person);
    }

    public Person FindById(int id) {
     //  Person tempPerson= personRepository.findById(id).get();

        return personRepository.findById(id).get();
    }

    public List<Person> FindAll() {

        return personRepository.findAll();
    }

}
