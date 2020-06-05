package com.mailservice.api;

import com.mailservice.domain.email.EmailSender;
import com.mailservice.domain.email.Receiver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MailConsumer {

    private final EmailSender emailSender;

    @RabbitListener(queues = "${queue.name}")
    private void sendEmail(Receiver receiver) {
        emailSender.sendReport(receiver.getMailAddress(), receiver.getContent());
        log.info("Mail was sent successfully to receiver");
    }
}