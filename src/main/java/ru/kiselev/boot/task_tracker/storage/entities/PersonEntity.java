package ru.kiselev.boot.task_tracker.storage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Person", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long person_id;

    private String username;

    private String password;

    private String email;

    private Date birthday;

    @Transient
    private int age;

    public PersonEntity(String username, String password, String email, Date birthday){
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.age = LocalDate.now().getYear() - birthday.toLocalDate().getYear();
    }
}
