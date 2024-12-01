package ru.kiselev.boot.task_tracker.storage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kiselev.boot.task_tracker.util.TaskBaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SubTaskEntity extends TaskBaseEntity {
    @ManyToOne
    @JoinColumn(name = "epic_id")
    public TaskEntity parentTask;
}
