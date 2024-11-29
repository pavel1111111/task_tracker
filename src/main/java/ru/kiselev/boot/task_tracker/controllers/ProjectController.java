package ru.kiselev.boot.task_tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kiselev.boot.task_tracker.dto.ProjectDTO;
import ru.kiselev.boot.task_tracker.services.ProjectService;
import ru.kiselev.boot.task_tracker.storage.entities.ProjectEntity;
import ru.kiselev.boot.task_tracker.util.ProjectStatus;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectEntity> getProjects(@RequestParam(required = true) Long ownerId) {
        return projectService.getAllPersonsProjects(ownerId);
    }

    @PostMapping
    public ProjectEntity createProjectByPersonId(@RequestParam(required = true) Long ownerId,
                                                 @RequestBody ProjectDTO projectDTO){
        return projectService.createProject(projectDTO, ownerId);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }

    @PutMapping("/{id}")
    public ProjectEntity updateStatus(@PathVariable Long id, @RequestParam ProjectStatus projectStatus){
        return projectService.updateStatus(id, projectStatus);
    }
}
