package com.ivan.dao;

import com.ivan.entity.Set;
import com.ivan.mapper.SetMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SetDAOImpl implements SetDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_K_PAC = "select * from k_pac_set where id = ?";
    private final String SQL_DELETE_K_PAC = "delete from k_pac_set where id = ?";
    private final String SQL_GET_ALL = "select * from k_pac_set";
    private final String SQL_INSERT_K_PAC = "insert into k_pac_set(id, title) values(?,?)";

    public SetDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Set getSetById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_K_PAC, new Object[] { id }, new SetMapper());
    }

    @Override
    public List<Set> getAllSets() {
        return jdbcTemplate.query(SQL_GET_ALL, new SetMapper());
    }

    @Override
    public boolean deleteSet(int id) {
        return jdbcTemplate.update(SQL_DELETE_K_PAC, id) > 0;
    }

    @Override
    public boolean createSet(Set set) {
        return jdbcTemplate.update(SQL_INSERT_K_PAC, set.getId(), set.getTitle()) > 0;
    }
}
