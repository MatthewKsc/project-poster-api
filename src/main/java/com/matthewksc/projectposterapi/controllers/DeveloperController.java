package com.matthewksc.projectposterapi.controllers;

import com.matthewksc.projectposterapi.entity.Developer;
import com.matthewksc.projectposterapi.services.DeveloperService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Iterable<Developer>> getAllDevelopers(){
        return ResponseEntity
                .ok()
                .body(developerService.findAll());
    }

    @GetMapping("/")
    public ResponseEntity<Developer> getDevById(@RequestParam(name = "id") Long id){
        return ResponseEntity
                .ok()
                .body(developerService.findById(id));
    }

    @PostMapping("/design")
    public ResponseEntity<Developer> saveDev(@RequestBody Developer developer){
        return ResponseEntity
                .ok()
                .body(developerService.save(Optional.ofNullable(developer)));
    }

    @DeleteMapping("")
    public void deleteDevById(@RequestParam(name = "id") Long id){
        developerService.deleteById(id);
    }
}
