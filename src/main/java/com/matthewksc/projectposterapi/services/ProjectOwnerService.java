package com.matthewksc.projectposterapi.services;

import com.matthewksc.projectposterapi.entity.ProjectOwner;
import com.matthewksc.projectposterapi.repositories.ProjectOwnerRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectOwnerService {

    private ProjectOwnerRepo projectOwnerRepo;

    public ProjectOwnerService(ProjectOwnerRepo projectOwnerRepo) {
        this.projectOwnerRepo = projectOwnerRepo;
    }

    public Iterable<ProjectOwner> findAll() {
        return projectOwnerRepo.findAll();
    }

    public Optional<ProjectOwner> findById(Long id) {
        return projectOwnerRepo.findById(id);
    }

    public Iterable<ProjectOwner> saveAll(Iterable<ProjectOwner> projectOwners) {
        return projectOwnerRepo.saveAll(projectOwners);
    }

    public ProjectOwner save(ProjectOwner projectOwner) {
        return projectOwnerRepo.save(projectOwner);
    }

    public void deleteById(Long id) {
        projectOwnerRepo.deleteById(id);
    }
}
