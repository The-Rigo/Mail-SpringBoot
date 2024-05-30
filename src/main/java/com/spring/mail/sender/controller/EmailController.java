package com.spring.mail.sender.controller;

import com.spring.mail.sender.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;


    @GetMapping("/send")
    public String sendEmail() {
        Map<String, Object> model = new HashMap<>();
        model.put("name", "John Doe");

        try {
            emailService.sendEmail("rodri.ledezma9483@gmail.com", "Test Email", "templates/email-template.vm", model);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error sending email.";
        }
        return "Email sent successfully.";
    }
}
