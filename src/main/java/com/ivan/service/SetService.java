package com.ivan.service;

import com.ivan.entity.Set;

import java.util.List;

public interface SetService {
    Set getSetById(int id);

    List<Set> getAllSets();

    boolean deleteSet(int id);

    boolean createSet(Set set);
}
