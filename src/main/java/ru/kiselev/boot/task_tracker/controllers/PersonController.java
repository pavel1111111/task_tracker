package ru.kiselev.boot.task_tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kiselev.boot.task_tracker.services.PersonService;
import ru.kiselev.boot.task_tracker.services.ProjectService;
import ru.kiselev.boot.task_tracker.storage.entities.PersonEntity;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService, ProjectService projectService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonEntity> getAllPersons(@RequestParam(name="name", required = false) String name,
                                            @RequestParam(name="email", required = false) String email){
        if(name != null){
            return Collections.singletonList(personService.getByName(name));
        }
        if(email != null){
            return Collections.singletonList(personService.getByEmail(email));
        }
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public PersonEntity getPersonById(@PathVariable(name = "id") Long id){
        return personService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable(name = "id") Long id){
        personService.deletePerson(id);
    }

    @PostMapping
    public PersonEntity createPerson(@RequestBody PersonEntity person){
        return personService.createPerson(person);
    }
}
