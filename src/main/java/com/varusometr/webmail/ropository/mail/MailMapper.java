package com.varusometr.webmail.ropository.mail;

import com.varusometr.webmail.entity.Mail;
import com.varusometr.webmail.entity.Role;
import com.varusometr.webmail.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MailMapper implements RowMapper<Mail> {

    @Override
    public Mail mapRow(ResultSet resultSet, int i) throws SQLException {
        Mail mail = new Mail();
        mail.setMailId(resultSet.getLong(1));
        mail.setRecipientsId(Arrays.stream(resultSet.getString(3)
                .split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList()));
        mail.setSubject(resultSet.getString(4));
        mail.setText(resultSet.getString(5));
        mail.setDateMail(resultSet.getTimestamp(6));
        mail.setReplyMailId(resultSet.getLong(7));

        User user = new User();
        user.setUserId(resultSet.getLong(8));
        user.setLogin(resultSet.getString(9));
        user.setPassword(resultSet.getString(10));
        user.setFirstName(resultSet.getString(11));
        user.setLastName(resultSet.getString(12));
        user.setMiddleName(resultSet.getString(13));
        user.setUserRole(Arrays.stream(resultSet.getString(14)
                .split(","))
                .map(Role::valueOf)
                .collect(Collectors.toSet()));

        mail.setAuthor(user);
        return mail;
    }
}
