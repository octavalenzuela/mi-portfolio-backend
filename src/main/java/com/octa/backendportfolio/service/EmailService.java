package com.octa.backendportfolio.service;

import com.octa.backendportfolio.dto.ContactRequest;
import lombok.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    private String apiKey;

    public void sendEmail(ContactRequest request) {
        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);


        Map<String, Object> body = new HashMap<>();
        body.put("from", "onboarding@resend.dev");
        body.put("to", "octavalenzuela0@gmail.com");
        body.put("subject", "Nuevo contacto: " + request.getAsunto());
        body.put("html", "<strong>De:</strong> " + request.getNombre() + " " + request.getApellido() + "<br><br>" + request.getMensaje());

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        try {
            restTemplate.postForEntity("https://api.resend.com/emails", entity, String.class);
        } catch (Exception e) {
            System.err.println("Error enviando por API: " + e.getMessage());
            throw e;
        }
    }
}