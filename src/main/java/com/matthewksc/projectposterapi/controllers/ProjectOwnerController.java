package com.matthewksc.projectposterapi.controllers;

import com.matthewksc.projectposterapi.entity.ProjectOwner;
import com.matthewksc.projectposterapi.services.ProjectOwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/project_owners")
public class ProjectOwnerController {

    private ProjectOwnerService projectOwnerService;

    public ProjectOwnerController(ProjectOwnerService projectOwnerService) {
        this.projectOwnerService = projectOwnerService;
    }

    @GetMapping("")
    public Iterable<ProjectOwner> getAllProjectOwners(){
        return projectOwnerService.findAll();
    }

    @GetMapping("/")
    public ProjectOwner getProjectOwnerById(@RequestParam(name = "id") Long id){
        return projectOwnerService.findById(id);
    }

    @PostMapping("/design")
    public ProjectOwner saveProjectOwner(@RequestBody ProjectOwner projectOwner){
        return projectOwnerService.save(Optional.ofNullable(projectOwner));
    }

    @DeleteMapping("")
    public void deleteProjectOwnerById(@RequestParam(name = "id") Long id){
        projectOwnerService.deleteById(id);
    }
}
