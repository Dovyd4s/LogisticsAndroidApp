package com.vgtu.cargoapp.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate birthDate;
    private LocalDate employedSinceDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEmployedSinceDate() {
        return employedSinceDate;
    }

    public void setEmployedSinceDate(LocalDate employedSinceDate) {
        this.employedSinceDate = employedSinceDate;
    }
}
