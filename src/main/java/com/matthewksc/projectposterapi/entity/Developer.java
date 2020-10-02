package com.matthewksc.projectposterapi.entity;

import com.matthewksc.projectposterapi.entity.enums.DeveloperType;
import com.matthewksc.projectposterapi.entity.enums.LevelOfExperience;
import com.matthewksc.projectposterapi.entity.enums.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developer extends AbstractEntity {

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeveloperType developerType;

    @Enumerated(EnumType.STRING)
    private LevelOfExperience levelOfExperience;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "developers_projects",
            joinColumns = @JoinColumn(name = "developers_id"),
            inverseJoinColumns = @JoinColumn(name = "projects_id"))
    private List<Project> projects = new ArrayList<>();

    public Developer(String firstName, String surName, String username, String password, String email, Role role,
                     DeveloperType developerType, LevelOfExperience levelOfExperience) {
        super(firstName, surName, username, password, email, role);
        this.developerType = developerType;
        this.levelOfExperience = levelOfExperience;
    }

    public Developer() {
        super();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DeveloperType getDeveloperType() {
        return developerType;
    }

    public void setDeveloperType(DeveloperType developerType) {
        this.developerType = developerType;
    }

    public LevelOfExperience getLevelOfExperience() {
        return levelOfExperience;
    }

    public void setLevelOfExperience(LevelOfExperience levelOfExperience) {
        this.levelOfExperience = levelOfExperience;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
