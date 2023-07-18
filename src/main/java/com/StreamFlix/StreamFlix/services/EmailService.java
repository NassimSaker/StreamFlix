package com.StreamFlix.StreamFlix.services;

public interface EmailService {
    void sendEmail(String toUser, String subject, String body);
}
