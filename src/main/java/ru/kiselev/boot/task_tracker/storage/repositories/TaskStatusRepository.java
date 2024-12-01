package ru.kiselev.boot.task_tracker.storage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kiselev.boot.task_tracker.storage.entities.TaskStatusEntity;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatusEntity, Long> {
}
