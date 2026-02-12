package com.octa.backendportfolio.service;

import com.octa.backendportfolio.dto.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(ContactRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("octavalenzuela0@gmail.com");
        message.setTo("octavalenzuela0@gmail.com"); // Te llega a vos mismo
        message.setSubject("Nuevo contacto del Portfolio: " + request.getAsunto());
        message.setText("De: " + request.getNombre() + " " + request.getApellido() + "\n\n" + request.getMensaje());

        mailSender.send(message);
    }
}