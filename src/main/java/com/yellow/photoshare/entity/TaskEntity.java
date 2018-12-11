package com.yellow.photoshare.entity;

import org.hibernate.search.annotations.Field;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TaskEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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
