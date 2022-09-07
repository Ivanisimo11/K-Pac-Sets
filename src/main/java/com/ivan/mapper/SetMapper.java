package com.ivan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ivan.entity.Set;
import org.springframework.jdbc.core.RowMapper;

public class SetMapper implements RowMapper<Set> {
    public Set mapRow(ResultSet resultSet, int i) throws SQLException {
        Set set = new Set();
        set.setId(resultSet.getInt("id"));
        set.setTitle(resultSet.getString("title"));
        return set;
    }
}
