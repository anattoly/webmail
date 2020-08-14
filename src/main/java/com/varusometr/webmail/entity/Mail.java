package com.varusometr.webmail.entity;

import java.util.Date;

public class Mail {
    private Long mailId;
    private User author;
    private String recipients;
    private String subject;
    private String text;
    private Date dateMail;
    private Long replyMailId;

    public Mail(User author, String recipients, String subject, String text, Date dateMail, Long replyMailId) {
        this.author = author;
        this.recipients = recipients;
        this.subject = subject;
        this.text = text;
        this.dateMail = dateMail;
        this.replyMailId = replyMailId;
    }

    public Mail() {
    }

    public Mail(User author, String recipients, String subject, String text, Date dateMail) {
        this.author = author;
        this.recipients = recipients;
        this.subject = subject;
        this.text = text;
        this.dateMail = dateMail;
    }

    public Long getReplyMailId() {
        return replyMailId;
    }

    public void setReplyMailId(Long replyMailId) {
        this.replyMailId = replyMailId;
    }

    public Long getMailId() {
        return mailId;
    }

    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateMail() {
        return dateMail;
    }

    public void setDateMail(Date dateMail) {
        this.dateMail = dateMail;
    }
}
