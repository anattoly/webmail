package com.varusometr.webmail.entity;

public class Inbox {
    private User recipient;
    private Mail inboxMail;
    private boolean isRead;
    private boolean isStared;
    private boolean isImportant;

    public Inbox() {
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Mail getInboxMail() {
        return inboxMail;
    }

    public void setInboxMail(Mail inboxMail) {
        this.inboxMail = inboxMail;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isStared() {
        return isStared;
    }

    public void setStared(boolean stared) {
        isStared = stared;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }
}
