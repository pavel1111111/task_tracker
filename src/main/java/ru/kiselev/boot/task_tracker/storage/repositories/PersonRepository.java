package ru.kiselev.boot.task_tracker.storage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kiselev.boot.task_tracker.storage.entities.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    PersonEntity findByEmail(String email);
    PersonEntity findByUsername(String username);
}
