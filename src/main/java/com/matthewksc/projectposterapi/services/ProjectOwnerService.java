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

    public ProjectOwner findById(Long id) {
        return projectOwnerRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("No such Project Owner with id: " +id));
    }

    public Iterable<ProjectOwner> saveAll(Iterable<ProjectOwner> projectOwners) {
        return projectOwnerRepo.saveAll(projectOwners);
    }

    public ProjectOwner save(Optional<ProjectOwner> projectOwner) {
        if (projectOwner.isPresent()){
            return projectOwnerRepo.save(projectOwner.get());
        }else{
            throw new RuntimeException("No object of ProjectOwner were presented");
        }
    }

    public void deleteById(Long id) {
        if (projectOwnerRepo.findById(id).isPresent()){
            projectOwnerRepo.deleteById(id);
        }else{
            throw new RuntimeException("No such Project Owner with id: "+id);
        }
    }
}
