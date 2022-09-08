package com.ivan.dao;

import com.ivan.entity.K_Pac;
import com.ivan.mapper.K_PacMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class K_PacDAOImpl implements K_PacDAO {
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_K_PAC = "select * from k_pac where id = ?";
    private final String SQL_DELETE_K_PAC = "delete from k_pac where id = ? ";
    private final String SQL_DELETE_IN_K_PAC = "delete from k_pac_in_set where id_k_pac = ?";
    private final String SQL_UPDATE_K_PAC = "update k_pac set title = ?, description = ?, date_created = ? where id = ?";
    private final String SQL_GET_ALL = "select * from k_pac";
    private final String SQL_INSERT_K_PAC = "insert into k_pac(id, title, description, date_created) values(?,?,?,CURDATE())";

    public K_PacDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public K_Pac getK_PacById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_K_PAC, new Object[] { id }, new K_PacMapper());
    }

    @Override
    public List<K_Pac> getAllK_Paces() {
        return jdbcTemplate.query(SQL_GET_ALL, new K_PacMapper());
    }

    @Override
    public boolean deleteK_Pac(int id) {
        jdbcTemplate.update(SQL_DELETE_IN_K_PAC, id);
        return jdbcTemplate.update(SQL_DELETE_K_PAC, id) > 0;
    }

    @Override
    public boolean createK_Pac(K_Pac k_pac) {
        return jdbcTemplate.update(SQL_INSERT_K_PAC, k_pac.getId(), k_pac.getTitle(), k_pac.getDescription()) > 0;
    }
}
