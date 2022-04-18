package com.dbccompany.kafkahome.service;

import com.dbccompany.kafkahome.dto.MensagemCompleta;
import com.dbccompany.kafkahome.model.NomesChats;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
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
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaService {

    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    public void sendVariousMsg(String msg, List<NomesChats> chats) {
        List<Integer> partitions = chats.stream().map(chat -> chat.ordinal())
                    .collect(Collectors.toList());
        for (Integer part : partitions) {
            sendMessage(msg, part);
        }
    }

    public void sendMessage(String msg, Integer partition) {
        Message<String> message = MessageBuilder.withPayload(msg)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .setHeader(KafkaHeaders.PARTITION_ID, partition)
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
            groupId = "ezequias",
            containerFactory = "factoryConsumer",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0", "2"})},
            clientIdPrefix = "privadoGeral"
    )
    public void consumerGeralParticular(
                @Payload String message,
                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId)
                throws JsonProcessingException {
        MensagemCompleta msgCompleta = objectMapper.readValue(message, MensagemCompleta.class);

        if (partitionId == 0){
            log.info(format.format(msgCompleta.getDataCriacao()) + "[" + msgCompleta.getUsuario() + "]: " + msgCompleta.getMensagem());
        }else{
            log.info(format.format(msgCompleta.getDataCriacao()) + "[" + msgCompleta.getUsuario() + "] (privada): " + msgCompleta.getMensagem());
        }

    }

}
