package com.varusometr.webmail.ropository.mail;

import com.varusometr.webmail.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@PropertySource("classpath:db.properties")
public class MailRepositoryImpl implements MailRepository {

    @Value("${Mail.createMail}")
    private String qCreateMail;

    @Value("${Mail.removeMailById}")
    private String qRemoveMail;

    @Value("${Mail.findMailById}")
    private String qfindById;

    @Value("${Mail.findAll}")
    private String qfindAll;

    @Value("${Mail.findAllBySomeParam}")
    private String qfindAllBySomeParam;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MailRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void createMail(Mail mail) {
        jdbcTemplate.update(qCreateMail,
                mail.getAuthor(),
                mail.getRecipientsId(),
                mail.getSubject(),
                mail.getText(),
                mail.getDateMail());
    }

    @Override
    public void removeMailById(Long id) {
        jdbcTemplate.update(qRemoveMail, id);
    }

    @Override
    public Mail findMailById(Long id) {
        return jdbcTemplate.queryForObject(qfindById, new Object[]{id}, new MailMapper());
    }

    @Override
    public Page<Mail> findAll(int page, int size) {

        return pagination(page, size, jdbcTemplate.query(qfindAll, new MailMapper()));
    }

    @Override
    public Page<Mail> findAllBySomeParam(int page, int size, String keyword) {

        return pagination(page, size, jdbcTemplate.query(qfindAllBySomeParam, new MailMapper(), keyword));
    }

    private Page<Mail> pagination(int page, int size, List<Mail> list) {

        long countElements = list.size();
        Pageable rowToPage = PageRequest.of(page, size);
        int start = (int) rowToPage.getOffset();
        int end = (start + rowToPage.getPageSize()) > countElements ? (int) countElements : (start + rowToPage.getPageSize());

        return new PageImpl<>(list.subList(start, end), rowToPage, countElements);
    }
}
