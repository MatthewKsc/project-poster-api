package com.matthewksc.projectposterapi.entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ID;

    @Enumerated(EnumType.STRING)
    private City city;

    private String street;
    private String houseNumber;
    private String postalCode;

    @OneToOne
    private Developer developer;

    @OneToOne
    private ProjectOwner projectOwner;

    public Address(City city, String street, String houseNumber, String postalCode, Developer developer, ProjectOwner projectOwner) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.developer = developer;
        this.projectOwner = projectOwner;
    }

    public Address() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public ProjectOwner getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(ProjectOwner projectOwner) {
        this.projectOwner = projectOwner;
    }
}
