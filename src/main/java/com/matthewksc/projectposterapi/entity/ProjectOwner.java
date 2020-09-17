package com.matthewksc.projectposterapi.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ProjectOwner extends AbstractEntity {

    @OneToOne
    private Address address;

    //TODO onetomany to projects


    public ProjectOwner() {
        super();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
