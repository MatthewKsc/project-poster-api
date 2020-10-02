package com.matthewksc.projectposterapi.repositories;

import com.matthewksc.projectposterapi.entity.ProjectOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectOwnerRepo extends JpaRepository<ProjectOwner, Long> {
}
