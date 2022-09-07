package com.ivan.service;

import com.ivan.dao.K_PacSetDao;
import com.ivan.entity.K_Pac;
import com.ivan.entity.K_PacSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class K_PacSetServiceImpl implements K_PacSetService{
    @Autowired
    K_PacSetDao k_pacSetDao;

    @Override
    @Transactional
    public List<K_Pac> getKPacsFromSetById(int id) {
        return k_pacSetDao.getKPacsFromSetById(id);
    }

    @Override
    @Transactional
    public boolean deleteKPacFromSet(int id) {
        return k_pacSetDao.deleteKPacFromSet(id);
    }

    @Override
    @Transactional
    public boolean addKPacToSet(K_PacSet k_pacSet) {
        return k_pacSetDao.addKPacToSet(k_pacSet);
    }

}
