package ru.kiselev.boot.task_tracker.storage.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TaskStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskStatusId;

    private String taskStatusName;

    private int taskStatusOrdinal;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectEntity projectEntity;

    @OneToMany
    private List<TaskEntity> tasks;
}
