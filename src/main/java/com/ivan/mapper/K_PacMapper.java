package com.ivan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ivan.entity.K_Pac;
import org.springframework.jdbc.core.RowMapper;

public class K_PacMapper implements RowMapper<K_Pac> {
    public K_Pac mapRow(ResultSet resultSet, int i) throws SQLException {
        K_Pac k_pac = new K_Pac();
        k_pac.setId(resultSet.getInt("id"));
        k_pac.setTitle(resultSet.getString("title"));
        k_pac.setDescription(resultSet.getString("description"));
        k_pac.setDateCreated(resultSet.getDate("date_created"));
        return k_pac;
    }
}
