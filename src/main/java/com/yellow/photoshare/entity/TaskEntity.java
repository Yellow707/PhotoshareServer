package com.yellow.photoshare.entity;

import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;



@Entity(name = "TaskEntity")
@Table(name="Task")
public class TaskEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Title", nullable = false)
    @Field
    @NotNull
    @NotEmpty
    private String title;

    @Column(name = "Description", nullable = false)
    @Field
    @NotNull
    @NotEmpty
    private String description;

    @Column(name = "Date", nullable = false)
    @Field
    @NotNull
    @NotEmpty
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
