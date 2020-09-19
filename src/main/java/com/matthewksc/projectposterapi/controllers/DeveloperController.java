package com.matthewksc.projectposterapi.controllers;

import com.matthewksc.projectposterapi.entity.Developer;
import com.matthewksc.projectposterapi.services.DeveloperService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping("")
    public Iterable<Developer> getAllDevelopers(){
        return developerService.findAll();
    }

    @GetMapping("/")
    public Optional<Developer> getDevById(@RequestParam(name = "id") Long id){
        return developerService.findById(id);
    }

    @PostMapping("/design")
    public Developer saveDev(@RequestBody Developer developer){
        return developerService.save(developer);
    }

    @DeleteMapping("")
    public void deleteDevById(@RequestParam(name = "id") Long id){
        developerService.deleteById(id);
    }
}
