package com.matthewksc.projectposterapi.backend.services;

import com.matthewksc.projectposterapi.backend.entity.Project;
import com.matthewksc.projectposterapi.backend.entity.enums.City;
import com.matthewksc.projectposterapi.backend.entity.enums.DeveloperType;
import com.matthewksc.projectposterapi.backend.entity.enums.LevelOfExperience;
import com.matthewksc.projectposterapi.backend.repositories.ProjectRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    ProjectRepo projectRepo;

    @InjectMocks
    ProjectService projectService;

    @Test
    void findAllByCity(){
        List<Project> projects = initData();
        given(projectRepo.findAllByCity(City.ŚLĄSK))
                .willReturn(Arrays.asList(
                        projects.get(1),
                        projects.get(3)
                ));

        List<Project> result = (List<Project>) projectService.findAllByCity(City.ŚLĄSK);

        assertAll(
                ()-> assertEquals(2, result.size()),
                ()-> assertNotEquals(20, result.size()),
                ()-> assertNotEquals(projects.size(), result.size()),
                ()-> assertSame(projects.get(1), result.get(0)),
                ()-> assertSame(projects.get(3), result.get(1)),
                ()-> assertNotSame(projects, result)
        );
    }
    @Test
    void findAllByDeveloperType(){
        List<Project> projects = initData();
        given(projectRepo.findAllByDeveloperType(DeveloperType.FULLSTACK))
                .willReturn(Arrays.asList(
                        projects.get(1),
                        projects.get(3)
                ));

        List<Project> result =
                (List<Project>) projectService.findAllByDeveloperType(DeveloperType.FULLSTACK);

        assertAll(
                ()-> assertEquals(2, result.size()),
                ()-> assertNotEquals(20, result.size()),
                ()-> assertNotEquals(projects.size(), result.size()),
                ()-> assertSame(projects.get(1), result.get(0)),
                ()-> assertSame(projects.get(3), result.get(1)),
                ()-> assertNotSame(projects, result)
        );
    }
    @Test
    void findAllByRequiredExperience(){
        List<Project> projects = initData();
        given(projectRepo.findAllByRequiredExperience(LevelOfExperience.JUNIOR))
                .willReturn(Arrays.asList(
                        projects.get(1),
                        projects.get(3)
                ));

        List<Project> result =
                (List<Project>) projectService.findAllByRequiredExperience(LevelOfExperience.JUNIOR);

        assertAll(
                ()-> assertEquals(2, result.size()),
                ()-> assertNotEquals(20, result.size()),
                ()-> assertNotEquals(projects.size(), result.size()),
                ()-> assertSame(projects.get(1), result.get(0)),
                ()-> assertSame(projects.get(3), result.get(1)),
                ()-> assertNotSame(projects, result)
        );
    }
    @Test
    void findByTitle(){
        List<Project> projects = initData();
        given(projectRepo.findByTitle("Pro"))
                .willReturn(Arrays.asList(
                        projects.get(1),
                        projects.get(3)
                ));

        List<Project> result = (List<Project>) projectService.findByTitle("Pro");

        assertAll(
                ()-> assertEquals(2, result.size()),
                ()-> assertNotEquals(20, result.size()),
                ()-> assertNotEquals(projects.size(), result.size()),
                ()-> assertSame(projects.get(1), result.get(0)),
                ()-> assertSame(projects.get(3), result.get(1)),
                ()-> assertNotSame(projects, result)
        );

    }
    @Test
    void  findById(){
        List<Project> projects = initData();
        given(projectRepo.findById(1L)).willReturn(Optional.of(projects.get(0)));

        Project result = projectService.findById(1L);

        assertAll(
                ()-> assertSame(projects.get(0), result),
                ()-> assertNotSame(projects.get(1), result),
                ()-> assertNotSame(projects.get(2), result),
                ()-> assertThrows(RuntimeException.class, ()->projectService.deleteById(2L))
        );
    }
    @Test
    void findAll(){
        List<Project> projects = initData();
        given(projectRepo.findAll()).willReturn(projects);

        List<Project> result = (List<Project>) projectService.findAll();

        assertAll(
                ()-> assertSame(projects, result),
                ()-> assertEquals(4, result.size()),
                ()-> assertNotNull(result)
        );
    }
    @Test
    void saveAll(){
        List<Project> projects = initData();
        given(projectRepo.saveAll(projects)).willReturn(projects);

        List<Project> result = (List<Project>) projectService.saveAll(projects);
        List<Project> fake = new ArrayList<>();
        assertAll(
                ()-> assertEquals(projects.size(), result.size()),
                ()-> assertSame(projects, result),
                ()-> assertNotSame(fake, result),
                ()-> verify(projectRepo, times(1)).saveAll(projects)
        );
    }
    @Test
    void save(){
        Project project = new Project();
        given(projectRepo.save(project)).willReturn(project);

        Project result = projectService.save(Optional.of(project));
        Project fake = new Project();

        assertAll(
                ()-> assertEquals(project, result),
                ()-> assertNotSame(fake, result),
                ()-> verify(projectRepo, times(1)).save(project),
                ()-> assertThrows(RuntimeException.class, ()-> projectService.save(null))
        );
    }
    @Test
    void deleteById(){
        Project project = new Project();
        given(projectRepo.findById(1L)).willReturn(Optional.of(project));

        projectService.deleteById(1L);

        assertAll(
                ()->verify(projectRepo, times(1)).deleteById(1L),
                ()->verify(projectRepo, times(0)).deleteById(2L),
                ()->assertThrows(RuntimeException.class, ()-> projectService.deleteById(3L))
        );
    }

    public List<Project> initData(){
        return Arrays.asList(
                new Project(),
                new Project(),
                new Project(),
                new Project()
        );
    }
}
