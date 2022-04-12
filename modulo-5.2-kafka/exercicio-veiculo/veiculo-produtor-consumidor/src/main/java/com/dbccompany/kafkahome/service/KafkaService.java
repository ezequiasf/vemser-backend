package com.dbccompany.kafkahome.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value(value = "${kafka.topic}")
    private String topic;

    public void sendMessage(String msg) {
        // >> Configurando: payload (conteúdo), chave randomica e ações para sucesso e falha.
        Message<String> message = MessageBuilder.withPayload(msg)
                .setHeader(KafkaHeaders.TOPIC, topic)
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

    //Listener para escutar tópico (meu-primeiro-topico)
    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "group1",
            containerFactory = "listenerContainerFactory")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) {
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);
    }
}
