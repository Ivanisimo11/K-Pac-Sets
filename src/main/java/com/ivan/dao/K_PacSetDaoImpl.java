package com.ivan.dao;


import com.ivan.entity.K_Pac;
import com.ivan.entity.K_PacSet;
import com.ivan.mapper.K_PacMapper;
import com.ivan.mapper.K_PacSetMapper;
import com.ivan.mapper.SetMapper;
import com.ivan.service.K_PacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class K_PacSetDaoImpl implements K_PacSetDao{

    @Autowired
    private K_PacService k_pacService;

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_K_PAC_AND_SET = "select * from k_pac_in_set where id_set = ?";
//    private final String SQL_GET_ALL_K_PAC = "select * from k_pac where id_set = ?";
    private final String SQL_DELETE_K_PAC = "delete from k_pac_in_set where id_k_pac = ?";
    private final String SQL_GET_ALL = "select * from k_pac_set";
    private final String SQL_INSERT_K_PAC_IN_SET = "insert into k_pac_in_set(id_set, id_k_pac) values(?,?)";

    public K_PacSetDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<K_Pac> getKPacsFromSetById(int id) {
        List<K_PacSet> k_pacSets = jdbcTemplate.query(SQL_FIND_K_PAC_AND_SET, new Object[] { id }, new K_PacSetMapper());
        List<Integer> k_pacSetsId = new ArrayList<>();
        for (K_PacSet k_pacSet : k_pacSets) {
            k_pacSetsId.add(k_pacSet.getId_k_pac());
        }
        List<K_Pac> k_pacs = new ArrayList<>();
        for (int i = 0; i < k_pacSetsId.size(); i++) {
            k_pacs.add(k_pacService.getK_PacById(k_pacSetsId.get(i)));
        }
        return k_pacs;
    }

    @Override
    public boolean deleteKPacFromSet(int id) {
        return jdbcTemplate.update(SQL_DELETE_K_PAC, id) > 0;
    }

    @Override
    public boolean addKPacToSet(K_PacSet k_pacSet) {
        return jdbcTemplate.update(SQL_INSERT_K_PAC_IN_SET,k_pacSet.getId_set(), k_pacSet.getId_k_pac()) > 0;
    }

}
