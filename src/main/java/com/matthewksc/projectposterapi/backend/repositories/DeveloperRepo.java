package com.matthewksc.projectposterapi.backend.repositories;

import com.matthewksc.projectposterapi.backend.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepo extends JpaRepository<Developer, Long> {
}
