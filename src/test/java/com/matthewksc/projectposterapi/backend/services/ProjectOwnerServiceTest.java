package com.matthewksc.projectposterapi.backend.services;

import com.matthewksc.projectposterapi.backend.entity.ProjectOwner;
import com.matthewksc.projectposterapi.backend.repositories.ProjectOwnerRepo;
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
public class ProjectOwnerServiceTest {

    @Mock
    ProjectOwnerRepo projectOwnerRepo;

    @InjectMocks
    ProjectOwnerService projectOwnerService;

    @Test
    void findAll() {
        List<ProjectOwner> projectOwners = initData();
        given(projectOwnerRepo.findAll()).willReturn(projectOwners);

        List<ProjectOwner> result = (List<ProjectOwner>) projectOwnerService.findAll();

        assertAll(
                ()-> assertEquals(projectOwners.size(), result.size()),
                ()-> assertEquals(projectOwners.get(0), result.get(0)),
                ()-> assertEquals(projectOwners.get(1), result.get(1)),
                ()-> assertEquals(2, result.size()),
                ()-> assertNotNull(result)
        );
    }

    @Test
    void findById() {
        List<ProjectOwner> projectOwners = initData();
        given(projectOwnerRepo.findById(1L)).willReturn(Optional.of(projectOwners.get(0)));
        given(projectOwnerRepo.findById(3L)).willReturn(Optional.of(projectOwners.get(1)));

        ProjectOwner result = projectOwnerService.findById(1L);
        ProjectOwner result2 = projectOwnerService.findById(3L);

        assertAll(
                ()-> assertSame(projectOwners.get(0), result),
                ()-> assertSame(projectOwners.get(1), result2),
                ()-> assertNotSame(projectOwners.get(0), result2),
                ()-> assertNotSame(projectOwners.get(1), result),
                ()-> assertThrows(RuntimeException.class, ()->projectOwnerService.findById(2L))
        );
    }

    @Test
    void saveAll() {
        List<ProjectOwner> projectOwners = initData();
        given(projectOwnerRepo.saveAll(projectOwners)).willReturn(projectOwners);

        List<ProjectOwner> result = (List<ProjectOwner>) projectOwnerService.saveAll(projectOwners);
        List<ProjectOwner> fake = new ArrayList<>();

        assertAll(
                ()-> assertEquals(projectOwners.size(), result.size()),
                ()-> assertSame(projectOwners.get(0), result.get(0)),
                ()-> assertSame(projectOwners.get(1), result.get(1)),
                ()-> assertSame(projectOwners, result),
                ()-> assertNotSame(fake, result),
                ()-> verify(projectOwnerRepo, times(1)).saveAll(projectOwners)
        );
    }

    @Test
    void save() {
        ProjectOwner projectOwner = new ProjectOwner();
        given(projectOwnerRepo.save(projectOwner)).willReturn(projectOwner);

        ProjectOwner result = projectOwnerService.save(Optional.of(projectOwner));
        ProjectOwner fake = new ProjectOwner();

        assertAll(
                ()-> assertSame(projectOwner, result),
                ()-> assertNotSame(fake, result),
                ()-> verify(projectOwnerRepo, times(1)).save(projectOwner),
                ()-> assertThrows(RuntimeException.class, ()-> projectOwnerService.save(null))
        );
    }

    @Test
    void deleteById() {
        ProjectOwner projectOwner = new ProjectOwner();
        given(projectOwnerRepo.findById(1L)).willReturn(Optional.of(projectOwner));

        projectOwnerService.deleteById(1L);

        assertAll(
                ()->verify(projectOwnerRepo, times(1)).deleteById(1L),
                ()->verify(projectOwnerRepo, times(0)).deleteById(2L),
                ()->assertThrows(RuntimeException.class, ()-> projectOwnerService.deleteById(3L))
        );
    }

    public List<ProjectOwner> initData(){
        return Arrays.asList(
                new ProjectOwner(),
                new ProjectOwner()
        );
    }
}
