package com.matthewksc.projectposterapi.controllers;


import com.matthewksc.projectposterapi.entity.Project;
import com.matthewksc.projectposterapi.entity.enums.City;
import com.matthewksc.projectposterapi.entity.enums.DeveloperType;
import com.matthewksc.projectposterapi.entity.enums.LevelOfExperience;
import com.matthewksc.projectposterapi.services.ProjectService;
import org.springframework.web.bind.annotation.*;

//TODO its test class in future change to Vaadin Router's
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public Iterable<Project> GetAllProjects(){
        return projectService.findAll();
    }

    @GetMapping("/")
    public Project GetAllById(@RequestParam(name = "id") Long id){
        return projectService.findById(id);
    }

    @GetMapping("/city")
    public Iterable<Project> GetAllByCity(@RequestParam(name = "city") String city){
        return projectService.findAllByCity(City.valueOf(city.toUpperCase()));
    }

    @GetMapping("/developers")
    public Iterable<Project> GetAllByDevType(@RequestParam(name = "type") String type){
        return projectService.findAllByDeveloperType(DeveloperType.valueOf(type.toUpperCase()));
    }

    @GetMapping("/experience")
    public Iterable<Project> GetAllByExperience(@RequestParam(name = "experience") String experience){
        return projectService.findAllByRequiredExperience(LevelOfExperience.valueOf(experience.toUpperCase()));
    }

    @GetMapping("/title/{searchItem}")
    public Iterable<Project> GetByTittle(@PathVariable String searchItem){
        return projectService.findByTitle(searchItem);
    }

    @PostMapping("/design")
    public Project saveProject(@RequestBody Project project){
        return projectService.save(project);
    }

    @DeleteMapping("")
    public void DeleteById(@RequestParam(name = "id") Long id){
        projectService.deleteById(id);
    }
}
