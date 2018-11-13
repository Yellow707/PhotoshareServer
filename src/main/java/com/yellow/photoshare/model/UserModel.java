package com.yellow.photoshare.model;

import java.awt.*;
import java.util.ArrayList;

public class UserModel {
    private String name;
    private String surname;
    private String username;
    private Integer age;
    private String email;
    private ArrayList<Image> imagesArray;

    public UserModel(String name, String surname, String username, Integer age, String email) {
        this.name = name;
        this.surname = surname;
        this.username= username;
        this.age = age;
        this.email = email;
        this.imagesArray = new ArrayList<>();
    }

    public UserModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
