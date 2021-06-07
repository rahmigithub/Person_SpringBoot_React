package com.example.personproject.Controller;


import com.example.personproject.Model.Person;
import com.example.personproject.Service.PersonService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @CrossOrigin
    @PostMapping("api/1.0/Person/Add")
    public List<String> AddPerson(@Valid @RequestBody Person person, BindingResult result) {

        log.info("----- PersonController paketi içindeki AddPerson metodu çalıştırıldı. ");
        log.info("----- Client tarafından gelen veriler : " +person.toString());

        List<String> errorMessages = new ArrayList<>();
        if (result.hasErrors()) {

            log.info("----- Client tarafından gelen @Valid hataları veya eksikleri mevcut");
            log.info("Hatalar veya Eksikler: ");

            for (FieldError error : result.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info(error.getDefaultMessage());
            }
            log.info("----- Client tarafından gelen isteğe bağlı uygun olumsuz mesaj dönderildi. ");
            return errorMessages;
        }

        log.info("----- Client tarafından gelen veri kayıt işlemi için personService.Save metoduna gitmeye uygundur.");

        personService.Save(person);
        String message="Person Created";
        errorMessages.add(message);

        log.info("----- Client tarafından gelen isteğe bağlı uygun olumlu mesaj dönderildi. ");
        return errorMessages;

    }


    @CrossOrigin
    @PostMapping("/api/1.0/api/1.0/Person/Update")
    public List<String> UpdatePerson(@Valid @RequestBody Person person, BindingResult result) {

        List<String> errorMessages = new ArrayList<>();
        if (result.hasErrors()) {

            for (FieldError error : result.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
                System.out.println(error.getDefaultMessage());
            }
            return errorMessages;
        }
        System.out.println(person.getId());
        personService.Update(person);
        String message="Person Updated";
        errorMessages.add(message);

        return errorMessages;

    }

    @CrossOrigin
    @PostMapping("api/1.0/Person/Delete/{id}")
    public Boolean DeletePerson(@PathVariable Integer id) {

        if(personService.FindById(id).getDeleted()==true){
            return false;
        }

        personService.Delete(id);

        return true;
    }

    @CrossOrigin
    @GetMapping("api/1.0/Person/GetAll")
    public List<Person> GetAllPerson() {

        List<Person> personList = personService.FindAll();
       // System.out.println(personList.get(0).getName());
        return personList;
    }

    @CrossOrigin
    @GetMapping("api/1.0/Person/GetId/{id}")
    public Person GetIdPerson(@PathVariable Integer id) {
        
        return personService.FindById(id);
    }

}
