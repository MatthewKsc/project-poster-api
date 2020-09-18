package com.matthewksc.projectposterapi.services;

import com.matthewksc.projectposterapi.entity.Project;
import com.matthewksc.projectposterapi.entity.enums.City;
import com.matthewksc.projectposterapi.entity.enums.DeveloperType;
import com.matthewksc.projectposterapi.entity.enums.LevelOfExperience;
import com.matthewksc.projectposterapi.repositories.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<Project> findAllByCity(City city) {
        return projectRepo.findAllByCity(city);
    }

    public List<Project> findAllByDeveloperType(DeveloperType developerType) {
        return projectRepo.findAllByDeveloperType(developerType);
    }

    public List<Project> findAllByRequiredExperience(LevelOfExperience levelOfExperience) {
        return projectRepo.findAllByRequiredExperience(levelOfExperience);
    }

    public List<Project> findByTitle(String searchTitle) {
        return projectRepo.findByTitle(searchTitle);
    }

    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    public List<Project> saveAll(List<Project> projects) {
        return projectRepo.saveAll(projects);
    }

    public Project save(Project project) {
        return projectRepo.save(project);
    }

    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    public void deleteById(Long id) {
        projectRepo.deleteById(id);
    }
}
