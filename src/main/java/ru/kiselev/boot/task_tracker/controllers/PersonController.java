package ru.kiselev.boot.task_tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kiselev.boot.task_tracker.services.PersonService;
import ru.kiselev.boot.task_tracker.storage.entities.PersonEntity;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<PersonEntity> getAllPersons(){
        return personService.getAll();
    }
}
