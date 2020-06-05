package com.mailservice.infrastructure.email;

import com.mailservice.domain.email.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {

    private final JavaMailSender javaMailSender;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendReport(String mailAddress, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailAddress);
        simpleMailMessage.setSubject("Weather report");

        simpleMailMessage.setText(content);
        javaMailSender.send(simpleMailMessage);
    }
}
