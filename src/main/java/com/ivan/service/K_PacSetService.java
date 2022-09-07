package com.ivan.service;

import com.ivan.entity.K_Pac;
import com.ivan.entity.K_PacSet;

import java.util.List;

public interface K_PacSetService {
    List<K_Pac> getKPacsFromSetById(int id);

    boolean deleteKPacFromSet(int id);

    boolean addKPacToSet(K_PacSet k_pacSet);
}
