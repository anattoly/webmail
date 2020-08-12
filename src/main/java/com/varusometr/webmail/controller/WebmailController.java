package com.varusometr.webmail.controller;

import com.varusometr.webmail.entity.Mail;
import com.varusometr.webmail.entity.User;
import com.varusometr.webmail.ropository.mail.MailRepository;
import com.varusometr.webmail.ropository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api")
public class WebmailController {
    private final MailRepository mailRepository;
    private final UserRepository userRepository;

    public WebmailController(MailRepository mailRepository, UserRepository userRepository) {
        this.mailRepository = mailRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String getUsers(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("userData", userRepository.findAll(page, 5));
        model.addAttribute("currentPage", page);

        return "users";
    }

    @GetMapping("/mails")
    public String getMails(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("data", mailRepository.findAll(page, 20));
        model.addAttribute("currentPage", page);
        model.addAttribute("email", new Mail());

        return "index";
    }

    @PostMapping("/mail")
    @ResponseBody
    public Mail createMail(@RequestParam List<Long> recipientsId,
                             @AuthenticationPrincipal User author,
                             @RequestParam String subject,
                             @RequestParam String text) {

        Mail mail = new Mail(author, recipientsId, subject, text, new Date());
        mailRepository.createMail(mail);


        return mail;
    }

    @PostMapping("/mail/{mail_id}")
    @ResponseBody
    public Mail replyEmail(@PathVariable Long mail_id,
                           @AuthenticationPrincipal User author,
                           @RequestParam String subject,
                           @RequestParam String text) {

        Long recipientId = mailRepository.findMailById(mail_id).getAuthor().getUserId();
        List<Long> recipientsId = new ArrayList<>();
        recipientsId.add(recipientId);
        Mail mail = new Mail(author, recipientsId, subject, text, new Date(), mail_id);
        mailRepository.createMail(mail);


        return mail;
    }

    @GetMapping("/mail")
    @ResponseBody
    public Mail findMail(Model model, Long id) {
        Mail email = mailRepository.findMailById(id);
        model.addAttribute("email", email);

        return email;
    }

    @GetMapping("/results")
    public String getSearchMail(Model model,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "") String search_query) {
        model.addAttribute("data", mailRepository.findAllBySomeParam(page, 20, "%" + search_query + "%"));
        model.addAttribute("currentPage", page);

        return "index";
    }

    @DeleteMapping("/mail/{mail_id}")
    public ResponseEntity deleteMails( @PathVariable long mail_id) {
        mailRepository.removeMailById(mail_id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Mail by id " + mail_id + "was deleted");
    }

}
