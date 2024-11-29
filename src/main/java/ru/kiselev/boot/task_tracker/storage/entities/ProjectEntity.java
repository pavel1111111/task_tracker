package ru.kiselev.boot.task_tracker.storage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ru.kiselev.boot.task_tracker.util.ProjectStatus;

import java.sql.Date;
import java.time.LocalDate;

@Table(name="Project")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long project_id;

    private String project_name;

    private Date created_at;

    private Date last_updated_at;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private PersonEntity owner;

    @Transient
    private Long owner_id;

    public ProjectEntity(String project_name, Date last_updated_at, ProjectStatus projectStatus, PersonEntity owner) {
        this.project_name = project_name;
        this.created_at = Date.valueOf(LocalDate.now());
        this.last_updated_at = Date.valueOf(LocalDate.now());
        this.projectStatus = projectStatus;
        this.owner = owner;
        this.owner_id = owner.getPerson_id();
    }
}
