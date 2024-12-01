package ru.kiselev.boot.task_tracker.storage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kiselev.boot.task_tracker.storage.entities.SubTaskEntity;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTaskEntity, Long> {
}
