package com.ivan.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

public class K_Pac {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private Date dateCreated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        K_Pac k_pac = (K_Pac) o;
        return id == k_pac.id &&
                Objects.equals(title, k_pac.title) &&
                Objects.equals(description, k_pac.description) &&
                Objects.equals(dateCreated, k_pac.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dateCreated);
    }

    @Override
    public String toString() {
        return "K_Pac{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public K_Pac() {
    }

    public K_Pac(String title, String description, Date dateCreated) {
        this.title = title;
        this.description = description;
        this.dateCreated = dateCreated;
    }
}
