package com.matthewksc.projectposterapi.backend;

import com.matthewksc.projectposterapi.backend.entity.Address;
import com.matthewksc.projectposterapi.backend.entity.Developer;
import com.matthewksc.projectposterapi.backend.entity.Project;
import com.matthewksc.projectposterapi.backend.entity.ProjectOwner;
import com.matthewksc.projectposterapi.backend.entity.enums.City;
import com.matthewksc.projectposterapi.backend.entity.enums.DeveloperType;
import com.matthewksc.projectposterapi.backend.entity.enums.LevelOfExperience;
import com.matthewksc.projectposterapi.backend.entity.enums.Role;
import com.matthewksc.projectposterapi.backend.services.AddressService;
import com.matthewksc.projectposterapi.backend.services.DeveloperService;
import com.matthewksc.projectposterapi.backend.services.ProjectOwnerService;
import com.matthewksc.projectposterapi.backend.services.ProjectService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class Init {

    private ProjectService projectService;
    private ProjectOwnerService projectOwnerService;
    private DeveloperService developerService;
    private AddressService addressService;

    public Init(ProjectService projectService, ProjectOwnerService projectOwnerService,
                DeveloperService developerService, AddressService addressService) {
        this.projectService = projectService;
        this.projectOwnerService = projectOwnerService;
        this.developerService = developerService;
        this.addressService = addressService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start(){
        List<Address> addresses = Arrays.asList(
                new Address(City.POZNAŃ, "ul. Ostatnia", "5", "60-001"),
                new Address(City.WARSZAWA, "ul. Anieli Krzywoń", "2/144", "01-391"),
                new Address(City.OTHER, "ul. Tadeusza", "6", "41-709"),
                new Address(City.ŚLĄSK, "ul. Katowicka", "4/40", "40-720"),
                new Address(City.KRAKÓW, "ul. Krakowska", "10", "31-210"),
                new Address(City.ŚLĄSK, "ul. Ligocka", "5/20", "40-500")
        );
        addressService.saveAll(addresses);

        List<ProjectOwner> projectOwners = Arrays.asList(
                new ProjectOwner("Pete", "Savanus", "pete123",
                        "123", "pete@savanus.pl", Role.USER),
                new ProjectOwner("Matthew", "Simple", "matt123",
                        "123", "matthew@simple.pl", Role.USER),
                new ProjectOwner("Alice", "Smith", "alice123",
                        "123", "alice@smith.pl", Role.USER)
        );

        for (int i=0; i<projectOwners.size(); i++){
            projectOwners.get(i).setAddress(addresses.get(i));
        }

        List<Developer> developers = Arrays.asList(
                new Developer("Alice", "Wilstion", "alice123", "123",
                        "alice@wilstion.pl", Role.USER, DeveloperType.BACKEND, LevelOfExperience.JUNIOR),
                new Developer("George", "Clown", "george123", "123",
                        "george@clown.pl", Role.USER, DeveloperType.FULLSTACK, LevelOfExperience.SENIOR),
                new Developer("Samanta", "Tree", "samanta123", "123",
                        "samanta@tree.pl", Role.USER, DeveloperType.FRONTEND, LevelOfExperience.MID)
        );

        for (int i=0; i<developers.size(); i++){
            developers.get(i).setAddress(addresses.get(i+3));
        }

        List<Project> projects = Arrays.asList(
                new Project("Junior Java Project to gain some experience  Software Program", City.REMOTE,
                        DeveloperType.BACKEND, LevelOfExperience.JUNIOR,
                        "4000 - 5000 PLN",
                        "Simple project for junior developers to see how to work with living product",
                        Date.valueOf(LocalDate.now().plusWeeks(3)),
                        Arrays.asList(developers.get(0)),
                        projectOwners.get(2)),
                new Project("Java Software Program", City.KRAKÓW, DeveloperType.FULLSTACK, LevelOfExperience.SENIOR,
                        "Undefined Salary",
                        "Backend Rest api with AWS",
                        Date.valueOf(LocalDate.now().plusDays(5)),
                        Arrays.asList(developers.get(1)),
                        projectOwners.get(2)),
                new Project("Java Software Program", City.ŚLĄSK, DeveloperType.FULLSTACK, LevelOfExperience.MID,
                        "Undefined Salary",
                        "Backend Rest api with connection to GooglePay and view in Angular",
                        Date.valueOf(LocalDate.now().plusWeeks(2)),
                        Arrays.asList(developers.get(2)),
                        projectOwners.get(1)),
                new Project("JavaScript Project", City.WARSZAWA, DeveloperType.FRONTEND, LevelOfExperience.MID,
                        "Undefined Salary",
                        "Working in modern project with JS/HTML/CSS and React.js",
                        Date.valueOf(LocalDate.now().plusWeeks(3)),
                        projectOwners.get(1)),
                new Project("C# Game", City.REMOTE, DeveloperType.BACKEND, LevelOfExperience.MID,
                        "8000 - 10000 PLN",
                        "Creating Indiana game in c# with usage of C# and Unity Engine",
                        Date.valueOf(LocalDate.now().plusMonths(1)),
                        projectOwners.get(0))
        );
        for (int i=0; i<3; i++){
            developers.get(i).setProjects(Arrays.asList(projects.get(i)));
        }

        projectOwners.get(2).setProjects(Arrays.asList(projects.get(0), projects.get(1)));
        projectOwners.get(1).setProjects(Arrays.asList(projects.get(2), projects.get(3)));
        projectOwners.get(0).setProjects(Arrays.asList(projects.get(4)));

        projectOwnerService.saveAll(projectOwners);
        developerService.saveAll(developers);
        projectService.saveAll(projects);
    }
}
