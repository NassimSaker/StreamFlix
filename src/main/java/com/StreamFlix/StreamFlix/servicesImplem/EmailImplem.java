package com.StreamFlix.StreamFlix.servicesImplem;

import com.StreamFlix.StreamFlix.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailImplem implements EmailService {

    @Autowired
    JavaMailSender mailSender;
    @Override
    public void sendEmail(String toUser, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toUser);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
