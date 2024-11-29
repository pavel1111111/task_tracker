package ru.kiselev.boot.task_tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kiselev.boot.task_tracker.dto.ProjectDTO;
import ru.kiselev.boot.task_tracker.storage.entities.ProjectEntity;
import ru.kiselev.boot.task_tracker.storage.repositories.ProjectRepository;
import ru.kiselev.boot.task_tracker.util.ProjectStatus;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final PersonService personService;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, PersonService personService) {
        this.projectRepository = projectRepository;
        this.personService = personService;
    }

    public List<ProjectEntity> getAllProjects() {
        return this.projectRepository.findAll();
    }

    public ProjectEntity createProject(ProjectDTO projectDTO, Long ownerId) {
        ProjectEntity projectEntity = ProjectEntity.builder()
                .owner(personService.getById(ownerId))
                .projectStatus(ProjectStatus.CREATED)
                .created_at(Date.valueOf(LocalDate.now()))
                .last_updated_at(Date.valueOf(LocalDate.now()))
                .project_name(projectDTO.getName()).build();
        this.projectRepository.save(projectEntity);
        return projectEntity;
    }
}
