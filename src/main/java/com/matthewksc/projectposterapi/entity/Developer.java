package com.matthewksc.projectposterapi.entity;

import com.matthewksc.projectposterapi.entity.enums.DeveloperType;
import com.matthewksc.projectposterapi.entity.enums.LevelOfExperience;
import com.matthewksc.projectposterapi.entity.enums.Role;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
public class Developer extends AbstractEntity {

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeveloperType developerType;

    @Enumerated(EnumType.STRING)
    private LevelOfExperience levelOfExperience;

    //TODO manytomany to project


    public Developer(String firstName, String surName, String username, String password, String email,
                     Role role, Address address, DeveloperType developerType, LevelOfExperience levelOfExperience) {
        super(firstName, surName, username, password, email, role);
        this.address = address;
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

}
