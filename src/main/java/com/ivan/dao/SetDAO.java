package com.ivan.dao;

import com.ivan.entity.Set;

import java.util.List;

public interface SetDAO {
    Set getSetById(int id);

    List<Set> getAllSets();

    boolean deleteSet(int id);

    boolean createSet(Set k_pac_set);
}
