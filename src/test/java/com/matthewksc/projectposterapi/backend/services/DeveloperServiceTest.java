package com.matthewksc.projectposterapi.backend.services;

import com.matthewksc.projectposterapi.backend.entity.Developer;
import com.matthewksc.projectposterapi.backend.repositories.DeveloperRepo;
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
public class DeveloperServiceTest {

    @Mock
    DeveloperRepo developerRepo;

    @InjectMocks
    DeveloperService developerService;

    @Test
    void findAll(){
        List<Developer> developers = initData();
        given(developerRepo.findAll()).willReturn(developers);

        List<Developer> result = (List<Developer>) developerService.findAll();

        assertAll(
                ()-> assertEquals(developers, result),
                ()-> assertEquals(developers.get(0), result.get(0)),
                ()-> assertEquals(developers.get(1), result.get(1)),
                ()-> assertEquals(2, result.size()),
                ()-> assertNotNull(result)
        );
    }

    @Test
    void findById(){
        List<Developer> developers = initData();

        given(developerRepo.findById(1L)).willReturn(Optional.of(developers.get(0)));
        given(developerRepo.findById(3L)).willReturn(Optional.of(developers.get(1)));

        Developer result = developerService.findById(1L);
        Developer result2 = developerService.findById(3L);

        assertAll(
                ()-> assertSame(developers.get(0), result),
                ()-> assertSame(developers.get(1), result2),
                ()-> assertNotSame(developers.get(0), result2),
                ()-> assertNotSame(developers.get(1), result),
                ()-> assertThrows(RuntimeException.class, ()->developerService.findById(2L))
        );
    }

    @Test
    void saveAll(){
        List<Developer> developers = initData();
        given(developerRepo.saveAll(developers)).willReturn(developers);

        List<Developer> result = (List<Developer>) developerService.saveAll(developers);
        List<Developer> fake = new ArrayList<>();

        assertAll(
                ()-> assertEquals(developers.size(), result.size()),
                ()-> assertSame(developers.get(0), result.get(0)),
                ()-> assertSame(developers.get(1), result.get(1)),
                ()-> assertSame(developers, result),
                ()-> assertNotSame(fake, result),
                ()-> verify(developerRepo, times(1)).saveAll(developers)
        );
    }

    @Test
    void save(){
        Developer developer = new Developer();
        given(developerRepo.save(developer)).willReturn(developer);

        Developer result = developerService.save(Optional.of(developer));
        Developer fake = new Developer();

        assertAll(
                ()-> assertSame(developer, result),
                ()-> assertNotSame(fake, result),
                ()-> verify(developerRepo, times(1)).save(developer),
                ()-> assertThrows(RuntimeException.class, ()-> developerService.save(null))
        );
    }

    @Test
    void deleteById(){
        Developer developer = new Developer();
        given(developerRepo.findById(1L)).willReturn(Optional.of(developer));

        developerService.deleteById(1L);

        assertAll(
                ()->verify(developerRepo, times(1)).deleteById(1L),
                ()->verify(developerRepo, times(0)).deleteById(2L),
                ()->assertThrows(RuntimeException.class, ()-> developerService.deleteById(3L))
        );
    }


    public List<Developer> initData(){
        return Arrays.asList(
                new Developer(),
                new Developer()
        );
    }
}
