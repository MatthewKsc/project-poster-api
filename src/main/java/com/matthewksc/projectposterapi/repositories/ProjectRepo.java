package com.matthewksc.projectposterapi.repositories;

import com.matthewksc.projectposterapi.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {

}
