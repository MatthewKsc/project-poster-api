package com.matthewksc.projectposterapi.entity;

import com.matthewksc.projectposterapi.entity.enums.Role;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project_owners")
public class ProjectOwner extends AbstractEntity {

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "projectOwner")
    private List<Project> projects = new ArrayList<>();

    public ProjectOwner(String firstName, String surName, String username,
                        String password, String email, Role role) {
        super(firstName, surName, username, password, email, role);
    }

    public ProjectOwner() {
        super();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
