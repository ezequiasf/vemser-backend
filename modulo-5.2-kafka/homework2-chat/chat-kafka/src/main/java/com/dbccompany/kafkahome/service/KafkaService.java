package com.dbccompany.kafkahome.service;

import com.dbccompany.kafkahome.dto.MensagemCompleta;
import com.dbccompany.kafkahome.model.NomesChats;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public void sendMessage(String msg, NomesChats chat) {
        Message<String> message = MessageBuilder.withPayload(msg)
                .setHeader(KafkaHeaders.TOPIC, chat.getNome())
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info(" Log enviado para o kafka com o texto: {} ", msg);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", msg, ex);
            }
        });
    }

    @KafkaListener(
            topics = "${kafka.topic.particular}",
            groupId = "ezequias",
            containerFactory = "factoryConsumer",
            clientIdPrefix = "private"
    )
    public void consumerParticular(@Payload String message) throws JsonProcessingException {
        MensagemCompleta msgCompleta = objectMapper.readValue(message, MensagemCompleta.class);

        log.info(format.format(msgCompleta.getDataCriacao())+"["+msgCompleta.getUsuario()+"] (privada): "+msgCompleta.getMensagem());
    }

    @KafkaListener(
            topics = "${kafka.topic.geral}",
            groupId = "ezequias",
            containerFactory = "factoryConsumer",
            clientIdPrefix = "private"
    )
    public void consumerGeral(@Payload String message) throws JsonProcessingException {
        MensagemCompleta msgCompleta = objectMapper.readValue(message, MensagemCompleta.class);

        log.info(format.format(msgCompleta.getDataCriacao())+"["+msgCompleta.getUsuario()+"]: "+msgCompleta.getMensagem());
    }
}
