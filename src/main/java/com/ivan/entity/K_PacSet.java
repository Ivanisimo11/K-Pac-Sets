package com.ivan.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

public class K_PacSet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_set;
    private int id_k_pac;

    @Override
    public String toString() {
        return "K_PacSet{" +
                "id_set=" + id_set +
                ", id_k_pac=" + id_k_pac +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        K_PacSet k_pacSet = (K_PacSet) o;
        return id_set == k_pacSet.id_set &&
                id_k_pac == k_pacSet.id_k_pac;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_set, id_k_pac);
    }

    public int getId_set() {
        return id_set;
    }

    public void setId_set(int id_set) {
        this.id_set = id_set;
    }

    public int getId_k_pac() {
        return id_k_pac;
    }

    public void setId_k_pac(int id_k_pac) {
        this.id_k_pac = id_k_pac;
    }

    public K_PacSet() {
    }

    public K_PacSet(int id_k_pac) {
        this.id_k_pac = id_k_pac;
    }
}
