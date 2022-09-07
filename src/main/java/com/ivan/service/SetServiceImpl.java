package com.ivan.service;

import com.ivan.dao.SetDAO;
import com.ivan.entity.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SetServiceImpl implements SetService {
    @Autowired
    private SetDAO setDAO;

    @Override
    @Transactional
    public Set getSetById(int id) {
        return setDAO.getSetById(id);
    }

    @Override
    @Transactional
    public List<Set> getAllSets() {
        return setDAO.getAllSets();
    }

    @Override
    @Transactional
    public boolean deleteSet(int id) {
        return setDAO.deleteSet(id);
    }

    @Override
    @Transactional
    public boolean createSet(Set set) {
        return setDAO.createSet(set);
    }
}