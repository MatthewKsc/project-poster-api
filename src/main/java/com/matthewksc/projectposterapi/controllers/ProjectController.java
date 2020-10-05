package com.matthewksc.projectposterapi.controllers;

import com.matthewksc.projectposterapi.entity.Project;
import com.matthewksc.projectposterapi.entity.enums.City;
import com.matthewksc.projectposterapi.entity.enums.DeveloperType;
import com.matthewksc.projectposterapi.entity.enums.LevelOfExperience;
import com.matthewksc.projectposterapi.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Project>> GetAllProjects(){
        return ResponseEntity
                .ok()
                .body(projectService.findAll());
    }

    @GetMapping("/")
    public ResponseEntity<Project> GetAllById(@RequestParam(name = "id") Long id){
        return ResponseEntity
                .ok()
                .body(projectService.findById(id));
    }

    @GetMapping("/city")
    public ResponseEntity<Iterable<Project>> GetAllByCity(@RequestParam(name = "city") String city){
        return ResponseEntity
                .ok()
                .body(projectService.findAllByCity(City.valueOf(city.toUpperCase())));
    }

    @GetMapping("/developers")
    public ResponseEntity<Iterable<Project>> GetAllByDevType(@RequestParam(name = "type") String type){
        return ResponseEntity
                .ok()
                .body(projectService.findAllByDeveloperType(DeveloperType.valueOf(type.toUpperCase())));
    }

    @GetMapping("/experience")
    public ResponseEntity<Iterable<Project>> GetAllByExperience(@RequestParam(name = "experience") String experience){
        return ResponseEntity
                .ok()
                .body(projectService.
                        findAllByRequiredExperience(LevelOfExperience.valueOf(experience.toUpperCase()))
                );
    }

    @GetMapping("/title/{searchItem}")
    public ResponseEntity<Iterable<Project>> GetByTittle(@PathVariable String searchItem){
        return ResponseEntity
                .ok()
                .body(projectService.findByTitle(searchItem));
    }

    @PostMapping("/design")
    public ResponseEntity<Project> saveProject(@RequestBody Project project){
        return ResponseEntity
                .ok()
                .body(projectService.save(Optional.ofNullable(project)));
    }

    @DeleteMapping("")
    public void DeleteById(@RequestParam(name = "id") Long id){
        projectService.deleteById(id);
    }
}
