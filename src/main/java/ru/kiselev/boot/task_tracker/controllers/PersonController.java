package ru.kiselev.boot.task_tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kiselev.boot.task_tracker.services.PersonService;
import ru.kiselev.boot.task_tracker.storage.entities.PersonEntity;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<PersonEntity> getAllPersons(@RequestParam(name="name", required = false) String name){
        if(name != null){
            return Collections.singletonList(personService.getByName(name));
        }
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public PersonEntity getPersonById(@PathVariable(name = "id") Long id){
        return personService.getById(id);
    }

    @PostMapping
    public PersonEntity createPerson(@RequestBody PersonEntity person){
        return personService.createPerson(person);
    }
}
