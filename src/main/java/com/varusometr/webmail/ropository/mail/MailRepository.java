package com.varusometr.webmail.ropository.mail;


import com.varusometr.webmail.entity.Mail;
import com.varusometr.webmail.entity.User;
import org.springframework.data.domain.Page;

public interface MailRepository {

    void createMail(Mail mail);

    void removeMailById(Long id);

    Mail findMailById(Long mailId, Long userId);

    Page<Mail> findAll(int page, int size, Long userId);

    Page<Mail> findAllBySomeParam(int page, int size, String keyword, Long userId);
}
