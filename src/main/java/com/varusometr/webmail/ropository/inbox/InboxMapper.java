package com.varusometr.webmail.ropository.inbox;

import com.varusometr.webmail.entity.Inbox;
import com.varusometr.webmail.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InboxMapper implements RowMapper<Inbox> {
    @Override
    public Inbox mapRow(ResultSet resultSet, int i) throws SQLException {


        Inbox inbox = new Inbox();

        return inbox;
    }
}
