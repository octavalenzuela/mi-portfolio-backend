package com.octa.backendportfolio.service;

import com.octa.backendportfolio.dto.ContactRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    @Value("${resend.api.key}")
    private String apiKey;

    @PostConstruct
    public void validateKey() {
        System.out.println("RESEND API KEY cargada: " + (apiKey != null && !apiKey.isBlank()));
    }

    public void sendEmail(ContactRequest request) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> body = new HashMap<>();
        body.put("from", "Octavio <onboarding@resend.dev>");
        body.put("to", new String[]{"octavalenzuela0@gmail.com"});
        body.put("subject", "Nuevo contacto: " + request.getAsunto());
        body.put("html",
                "<strong>Nombre:</strong> " + request.getNombre() + "<br>" +
                        "<strong>Apellido:</strong> " + request.getApellido() + "<br><br>" +
                        "<strong>Mensaje:</strong><br>" +
                        request.getMensaje()
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        restTemplate.postForEntity(
                "https://api.resend.com/emails",
                entity,
                String.class
        );
    }
}
