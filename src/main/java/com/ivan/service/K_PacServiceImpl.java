package com.ivan.service;

import com.ivan.dao.K_PacDAO;
import com.ivan.entity.K_Pac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class K_PacServiceImpl implements K_PacService{
    @Autowired
    private K_PacDAO k_pacDAO;

    @Override
    @Transactional
    public K_Pac getK_PacById(int id) {
        return k_pacDAO.getK_PacById(id);
    }

    @Override
    @Transactional
    public List<K_Pac> getAllK_Paces() {
        return k_pacDAO.getAllK_Paces();
    }

    @Override
    @Transactional
    public boolean deleteK_Pac(int id) {
        return k_pacDAO.deleteK_Pac(id);
    }

    @Override
    @Transactional
    public boolean createK_Pac(K_Pac k_pac) {
        return k_pacDAO.createK_Pac(k_pac);
    }
}
