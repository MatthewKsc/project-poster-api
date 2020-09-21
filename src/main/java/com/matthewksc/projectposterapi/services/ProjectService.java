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

    public Iterable<Project> findAllByCity(City city) {
        return projectRepo.findAllByCity(city);
    }

    public Iterable<Project> findAllByDeveloperType(DeveloperType developerType) {
        return projectRepo.findAllByDeveloperType(developerType);
    }

    public Iterable<Project> findAllByRequiredExperience(LevelOfExperience levelOfExperience) {
        return projectRepo.findAllByRequiredExperience(levelOfExperience);
    }

    public Iterable<Project> findByTitle(String searchTitle) {
        return projectRepo.findByTitle(searchTitle);
    }

    public Project findById(Long id) {
        return projectRepo
                .findById(id)
                .orElseThrow(()-> new RuntimeException("No such project with id: "+ id));
    }

    public Iterable<Project> findAll() {
        return projectRepo.findAll();
    }

    public Iterable<Project> saveAll(List<Project> projects) {
        return projectRepo.saveAll(projects);
    }

    public Project save(Optional<Project> project) {
        if (project.isPresent()){
            return projectRepo.save(project.get());
        }else {
            throw new RuntimeException("No object of Project were presented");
        }
    }

    public void deleteById(Long id) {
        if (projectRepo.findById(id).isPresent()){
            projectRepo.deleteById(id);
        }else{
            throw new RuntimeException("No such project with: "+id);
        }
    }
}
