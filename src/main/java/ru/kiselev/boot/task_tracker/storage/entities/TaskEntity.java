package ru.kiselev.boot.task_tracker.storage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kiselev.boot.task_tracker.util.TaskBaseEntity;

import java.util.List;

@Entity
@Table(name = "EpicTask")
@Getter
@Setter
@NoArgsConstructor
public class TaskEntity extends TaskBaseEntity {
    @OneToMany(mappedBy = "parentTask")
    private List<TaskEntity> children;
}
