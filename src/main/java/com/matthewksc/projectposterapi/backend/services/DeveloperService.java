package com.matthewksc.projectposterapi.backend.services;

import com.matthewksc.projectposterapi.backend.entity.Developer;
import com.matthewksc.projectposterapi.backend.exceptions.Developer.NotFoundDeveloperException;
import com.matthewksc.projectposterapi.backend.repositories.DeveloperRepo;
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
                .orElseThrow(()-> new NotFoundDeveloperException(id));
    }

    public Iterable<Developer> saveAll(Iterable<Developer> developers) {
        return developerRepo.saveAll(developers);
    }

    public Developer save(Optional<Developer> developer) {
        if (developer.isPresent()){
            return developerRepo.save(developer.get());
        }else{
            throw new NotFoundDeveloperException();
        }
    }

    public void deleteById(Long id) {
        if (developerRepo.findById(id).isPresent()){
            developerRepo.deleteById(id);
        }else{
            throw new NotFoundDeveloperException(id);
        }
    }
}
