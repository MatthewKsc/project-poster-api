package com.matthewksc.projectposterapi.repositories;

import com.matthewksc.projectposterapi.entity.Project;
import com.matthewksc.projectposterapi.entity.enums.City;
import com.matthewksc.projectposterapi.entity.enums.DeveloperType;
import com.matthewksc.projectposterapi.entity.enums.LevelOfExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long> {

    List<Project> findAllByCity(City city);

    List<Project> findAllByDeveloperType(DeveloperType developerType);

    List<Project> findAllByRequiredExperience(LevelOfExperience levelOfExperience);

    @Query("select p from Project as p " +
            "where lower(p.Title) like lower(concat('%', :searchTitle, '%' ))")
    List<Project> findByTitle(@Param("searchTitle") String searchTitle);
}
