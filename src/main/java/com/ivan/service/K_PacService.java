package com.ivan.service;

import com.ivan.entity.K_Pac;

import java.util.List;

public interface K_PacService {

    K_Pac getK_PacById(int id);

    List<K_Pac> getAllK_Paces();

    boolean deleteK_Pac(int id);

    boolean createK_Pac(K_Pac k_pac);
}
