package com.example.motorider.service;

import com.example.motorider.dto.request.EmailRequestDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {
    @Value("${mail}")
    private String from;
    private final JavaMailSender javaMailSender;
    public void sendOrderConfirmation( String orderDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(from);
        message.setSubject("Order List");
        message.setText(orderDetails);
        javaMailSender.send(message);
    }


    }
