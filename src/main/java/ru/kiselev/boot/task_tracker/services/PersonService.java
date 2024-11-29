package ru.kiselev.boot.task_tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kiselev.boot.task_tracker.storage.entities.PersonEntity;
import ru.kiselev.boot.task_tracker.storage.entities.ProjectEntity;
import ru.kiselev.boot.task_tracker.storage.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

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

    public PersonEntity getById(Long id){
        Optional<PersonEntity> person = personRepository.findById(id);
        return person.orElse(null);
    }

    public PersonEntity getByName(String username){
        Optional<PersonEntity> person = personRepository.findByUsername(username);
        return person.orElse(null);
    }

    public PersonEntity getByEmail(String email){
        Optional<PersonEntity> person = personRepository.findByEmail(email);
        return person.orElse(null);
    }

    public PersonEntity createPerson(PersonEntity person){
        return personRepository.save(person);
    }

//    public List<ProjectEntity> getAllPersonsProjects(PersonEntity person){
//        return person.getProjects();
//    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
