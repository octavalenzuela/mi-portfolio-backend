package com.octa.backendportfolio.controller;

import com.octa.backendportfolio.dto.ContactRequest;
import com.octa.backendportfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:3000") 
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendContact(@RequestBody ContactRequest request) {
        emailService.sendEmail(request);
        return ResponseEntity.ok("Mensaje enviado con éxito");
    }
}