package com.matthewksc.projectposterapi.services;

import com.matthewksc.projectposterapi.entity.Developer;
import com.matthewksc.projectposterapi.repositories.DeveloperRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    private DeveloperRepo developerRepo;

    public DeveloperService(DeveloperRepo developerRepo) {
        this.developerRepo = developerRepo;
    }

    public List<Developer> findAll() {
        return developerRepo.findAll();
    }

    public Optional<Developer> findById(Long id) {
        return developerRepo.findById(id);
    }

    public Iterable<Developer> saveAll(Iterable<Developer> developers) {
        return developerRepo.saveAll(developers);
    }

    public Developer save(Developer developer) {
        return developerRepo.save(developer);
    }

    public void deleteById(Long id) {
        developerRepo.deleteById(id);
    }
}
