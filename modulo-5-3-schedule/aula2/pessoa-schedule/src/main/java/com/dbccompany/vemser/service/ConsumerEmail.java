package com.dbccompany.vemser.service;

import com.dbccompany.vemser.dto.EmailDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsumerEmail {

    private final ObjectMapper objectMapper;
    private final Queue<EmailDto> emails = new LinkedList<>();
    private final EmailService emailService;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "email",
            containerFactory = "factoryConsumer",
            clientIdPrefix = "consumidorEmail"
    )
    public void consumerEmail(@Payload String message)
            throws JsonProcessingException {
        EmailDto email = objectMapper.readValue(message, EmailDto.class);
        emails.add(email);
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void enviadorEmail() {
        for (int i = 0; i < 9; i++) {
            EmailDto emailDto = emails.poll();
            if (emailDto == null) {
                break;
            }
            emailService.sendSimpleMessage(emailDto.getDestinatario(), emailDto.getMensagem());
        }
    }
}
