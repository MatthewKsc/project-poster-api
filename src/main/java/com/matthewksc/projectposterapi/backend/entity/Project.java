package com.matthewksc.projectposterapi.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matthewksc.projectposterapi.backend.entity.enums.City;
import com.matthewksc.projectposterapi.backend.entity.enums.DeveloperType;
import com.matthewksc.projectposterapi.backend.entity.enums.LevelOfExperience;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Enumerated(EnumType.STRING)
    private City city;

    @Enumerated(EnumType.STRING)
    private DeveloperType developerType;

    @Enumerated(EnumType.STRING)
    private LevelOfExperience requiredExperience;

    private String Title;
    private String Salary;
    private String description;
    private Date dateOfStart;

    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    private List<Developer> developers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "project_owners_id")
    @JsonIgnore
    private ProjectOwner projectOwner;

    public Project(String Title, City city, DeveloperType developerType, LevelOfExperience requiredExperience,
                   String salary, String description, Date dateOfStart,
                   List<Developer> developers, ProjectOwner projectOwner) {
        this.city = city;
        this.developerType = developerType;
        this.requiredExperience = requiredExperience;
        this.Salary = salary;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.developers = developers;
        this.projectOwner = projectOwner;
        this.Title = Title;
    }

    public Project(String Title, City city, DeveloperType developerType, LevelOfExperience requiredExperience,
                   String salary, String description, Date dateOfStart, ProjectOwner projectOwner) {
        this.city = city;
        this.developerType = developerType;
        this.requiredExperience = requiredExperience;
        this.Salary = salary;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.projectOwner = projectOwner;
        this.Title = Title;
    }

    public Project() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public DeveloperType getDeveloperType() {
        return developerType;
    }

    public void setDeveloperType(DeveloperType developerType) {
        this.developerType = developerType;
    }

    public LevelOfExperience getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(LevelOfExperience requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public ProjectOwner getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(ProjectOwner projectOwner) {
        this.projectOwner = projectOwner;
    }
}
