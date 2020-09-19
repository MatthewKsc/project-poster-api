package com.matthewksc.projectposterapi.services;

import com.matthewksc.projectposterapi.entity.Developer;
import com.matthewksc.projectposterapi.repositories.DeveloperRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeveloperService {

    private DeveloperRepo developerRepo;

    public DeveloperService(DeveloperRepo developerRepo) {
        this.developerRepo = developerRepo;
    }

    public Iterable<Developer> findAll() {
        return developerRepo.findAll();
    }

    public Developer findById(Long id) {
        return developerRepo
                .findById(id)
                .orElseThrow(()-> new RuntimeException("No such Developer with id: " +id));
    }

    public Iterable<Developer> saveAll(Iterable<Developer> developers) {
        return developerRepo.saveAll(developers);
    }

    public Developer save(Optional<Developer> developer) {
        if (developer.isPresent()){
            return developerRepo.save(developer.get());
        }else{
            throw new RuntimeException("No object of developer were presented ");
        }
    }

    public void deleteById(Long id) {
        developerRepo
                .findById(id)
                .ifPresent(developer -> developerRepo.delete(developer));
    }
}
