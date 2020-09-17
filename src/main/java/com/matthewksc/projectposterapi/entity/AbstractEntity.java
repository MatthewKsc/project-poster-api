package com.matthewksc.projectposterapi.entity;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String firstName;
    private String surName;
    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public AbstractEntity(String firstName, String surName, String username,
                          String password, String email, Role role) {
        this.firstName = firstName;
        this.surName = surName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public AbstractEntity() {
    }

    public Long getId() {
        return ID;
    }

    public void setId(Long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractEntity that = (AbstractEntity) obj;
        return Objects.equals(ID, that.ID) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(surName, that.surName) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, surName, username, password, email, role);
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
