package com.varusometr.webmail.ropository.mail;

import com.varusometr.webmail.entity.Mail;
import com.varusometr.webmail.entity.Role;
import com.varusometr.webmail.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MailMapper implements RowMapper<Mail> {

    @Override
    public Mail mapRow(ResultSet resultSet, int i) throws SQLException {
        User author = new User();
        author.setUserId(resultSet.getLong(7));
        author.setLogin(resultSet.getString(8));
        author.setPassword(resultSet.getString(9));
        author.setFirstName(resultSet.getString(10));
        author.setLastName(resultSet.getString(11));
        author.setMiddleName(resultSet.getString(12));
        author.setUserRole(Arrays.stream(resultSet.getString(13)
                .split(","))
                .map(Role::valueOf)
                .collect(Collectors.toSet()));

        Mail mail = new Mail();
        mail.setMailId(resultSet.getLong(1));
        mail.setAuthor(author);
        mail.setRecipients(resultSet.getString(14));
        mail.setSubject(resultSet.getString(3));
        mail.setText(resultSet.getString(4));
        mail.setDateMail(resultSet.getTimestamp(5));
        mail.setReplyMailId(resultSet.getLong(6));

        return mail;
    }
}
