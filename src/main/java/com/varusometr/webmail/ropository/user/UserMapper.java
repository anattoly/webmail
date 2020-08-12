package com.varusometr.webmail.ropository.user;

import com.varusometr.webmail.entity.Role;
import com.varusometr.webmail.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getLong(1));
        user.setLogin(resultSet.getString(2));
        user.setPassword(resultSet.getString(3));
        user.setFirstName(resultSet.getString(4));
        user.setLastName(resultSet.getString(5));
        user.setMiddleName(resultSet.getString(6));
        user.setUserRole(Arrays.stream(resultSet.getString(7)
                .split(","))
                .map(Role::valueOf)
                .collect(Collectors.toSet()));
        return user;
    }
}
