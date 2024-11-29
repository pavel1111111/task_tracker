package ru.kiselev.boot.task_tracker.storage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ru.kiselev.boot.task_tracker.util.ProjectStatus;

import java.time.LocalDateTime;

@Entity
@Table(name="project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime lastUpdatedAt;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity owner;

    public ProjectEntity(String name, ProjectStatus projectStatus, PersonEntity owner) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAt = LocalDateTime.now();
        this.projectStatus = projectStatus;
        this.owner = owner;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdatedAt = LocalDateTime.now();
    }
}
