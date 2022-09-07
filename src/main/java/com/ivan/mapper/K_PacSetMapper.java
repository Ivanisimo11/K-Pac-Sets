package com.ivan.mapper;

import com.ivan.entity.K_PacSet;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class K_PacSetMapper implements RowMapper<K_PacSet> {
    @Override
    public K_PacSet mapRow(ResultSet resultSet, int i) throws SQLException {
        K_PacSet k_pacSet = new K_PacSet();
        k_pacSet.setId_set(resultSet.getInt("id_set"));
        k_pacSet.setId_k_pac(resultSet.getInt("id_k_pac"));
        return k_pacSet;
    }
}
