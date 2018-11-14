package com.yellow.photoshare.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name="Users")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;

    @Column(name = "Surname", length = 50, nullable = false)
    private String surname;

    @Column(name = "Username", length = 50, nullable = false)
    private String username;

    @Column(name = "Age", nullable = false)
    private Integer age;

    @Column(name = "Email", length = 128, nullable = false)
    private String email;

    public UserEntity(String name, String surname, String username, Integer age, String email) {
        this.name = name;
        this.surname = surname;
        this.username= username;
        this.age = age;
        this.email = email;
//        this.imagesArray = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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