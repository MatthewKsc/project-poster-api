package com.matthewksc.projectposterapi.controllers;

import com.matthewksc.projectposterapi.entity.ProjectOwner;
import com.matthewksc.projectposterapi.services.ProjectOwnerService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Iterable<ProjectOwner>> getAllProjectOwners(){
        return ResponseEntity
                .ok()
                .body(projectOwnerService.findAll());
    }

    @GetMapping("/")
    public ResponseEntity<ProjectOwner> getProjectOwnerById(@RequestParam(name = "id") Long id){
        return ResponseEntity
                .ok()
                .body(projectOwnerService.findById(id));
    }

    @PostMapping("/design")
    public ResponseEntity<ProjectOwner> saveProjectOwner(@RequestBody ProjectOwner projectOwner){
        return ResponseEntity
                .ok()
                .body(projectOwnerService.save(Optional.ofNullable(projectOwner)));
    }

    @DeleteMapping("")
    public void deleteProjectOwnerById(@RequestParam(name = "id") Long id){
        projectOwnerService.deleteById(id);
    }
}
