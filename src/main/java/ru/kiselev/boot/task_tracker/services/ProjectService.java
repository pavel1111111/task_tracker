package ru.kiselev.boot.task_tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kiselev.boot.task_tracker.dto.ProjectCreationDTO;
import ru.kiselev.boot.task_tracker.storage.entities.ProjectEntity;
import ru.kiselev.boot.task_tracker.storage.repositories.ProjectRepository;
import ru.kiselev.boot.task_tracker.util.ProjectStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final PersonService personService;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, PersonService personService) {
        this.projectRepository = projectRepository;
        this.personService = personService;
    }

    public ProjectEntity createProject(ProjectCreationDTO projectCreationDTO, Long ownerId) {
        ProjectEntity projectEntity = ProjectEntity.builder()
                .owner(personService.getById(ownerId))
                .projectStatus(ProjectStatus.CREATED)
                .createdAt(LocalDateTime.now())
                .lastUpdatedAt(LocalDateTime.now())
                .name(projectCreationDTO.getName()).build();
        this.projectRepository.save(projectEntity);
        return projectEntity;
    }

    public void deleteProject(Long projectId) {
        this.projectRepository.deleteById(projectId);
    }

    public List<ProjectEntity> getAllPersonsProjects(Long ownerId) {
        return projectRepository.findByOwnerPersonId(ownerId);
    }

    public ProjectEntity updateStatus(Long projectId, ProjectStatus status) {
        Optional<ProjectEntity> project = this.projectRepository.findById(projectId);
        if (project.isEmpty()) {
            return null;
        }
        project.get().setProjectStatus(status);
        return this.projectRepository.save(project.get());
    }
}
