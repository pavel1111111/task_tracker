package ru.kiselev.boot.task_tracker.storage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class PresonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long person_id;

    private String username;

    private String password;

    private String email;


}
