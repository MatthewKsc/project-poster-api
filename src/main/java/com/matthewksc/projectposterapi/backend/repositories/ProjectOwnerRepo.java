package com.matthewksc.projectposterapi.backend.repositories;

import com.matthewksc.projectposterapi.backend.entity.ProjectOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectOwnerRepo extends JpaRepository<ProjectOwner, Long> {
}
