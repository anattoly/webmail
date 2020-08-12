package com.varusometr.webmail.ropository.mail;


import com.varusometr.webmail.entity.Mail;
import org.springframework.data.domain.Page;

public interface MailRepository {

    void createMail(Mail mail);

    void removeMailById(Long id);

    Mail findMailById(Long id);

    Page<Mail> findAll(int page, int size);

    Page<Mail> findAllBySomeParam(int page, int size, String keyword);
}
