package com.matthewksc.projectposterapi.repositories;

import com.matthewksc.projectposterapi.entity.Project;
import com.matthewksc.projectposterapi.entity.enums.City;
import com.matthewksc.projectposterapi.entity.enums.DeveloperType;
import com.matthewksc.projectposterapi.entity.enums.LevelOfExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long> {

    List<Project> findAllByCity(City city);

    List<Project> findAllByDeveloperType(DeveloperType developerType);

    List<Project> findAllByRequiredExperience(LevelOfExperience levelOfExperience);


}
