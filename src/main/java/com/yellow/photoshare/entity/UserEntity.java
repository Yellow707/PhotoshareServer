package com.yellow.photoshare.entity;


import org.hibernate.search.annotations.Field;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "UserEntity")
@Indexed
@Table(name="Users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Field
    @Column(name = "Name", nullable = false)
    private String name;

    @Field
    @Column(name = "Surname", nullable = false)
    private String surname;

    @Column(name = "Username", nullable = false)
    @Field
    private String username;

    @Field
    @Column(name = "Age", nullable = false)
    private Integer age;

    @Field
    @Column(name = "Email", nullable = false)
    private String email;

    UserEntity() {

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
