package com.oxcentra.menumaster.services;

public interface EmailService {
    public Boolean sendEmail(String toEmail,
                             String body,
                             String subject);
}
