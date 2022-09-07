package com.ivan.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class Set {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        return id == set.id &&
                Objects.equals(title, set.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    public Set(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Set{" +
                "id=" + id +
                ", title='" + title + '\'' +
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

    public Set() {
    }
}
