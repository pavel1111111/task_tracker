package ru.kiselev.boot.task_tracker.storage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
