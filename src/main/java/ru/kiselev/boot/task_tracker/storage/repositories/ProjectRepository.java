package ru.kiselev.boot.task_tracker.storage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kiselev.boot.task_tracker.storage.entities.ProjectEntity;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    List<ProjectEntity> findByOwnerPersonId(Long ownerPersonId);
}
