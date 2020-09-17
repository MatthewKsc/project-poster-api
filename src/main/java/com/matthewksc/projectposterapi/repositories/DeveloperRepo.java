package com.matthewksc.projectposterapi.repositories;

import com.matthewksc.projectposterapi.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepo extends JpaRepository<Developer, Long> {
}
