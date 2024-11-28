package ru.kiselev.boot.task_tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kiselev.boot.task_tracker.storage.entities.PersonEntity;
import ru.kiselev.boot.task_tracker.storage.repositories.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<PersonEntity> getAll(){
        return personRepository.findAll();
    }
}
