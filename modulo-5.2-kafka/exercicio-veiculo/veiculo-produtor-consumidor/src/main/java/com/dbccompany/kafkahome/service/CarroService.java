package com.dbccompany.kafkahome.service;

import com.dbccompany.kafkahome.dto.InfoCarroData;
import com.dbccompany.kafkahome.entity.InfoCarroEntity;
import com.dbccompany.kafkahome.repository.InfoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarroService {

    private final InfoRepository infoRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "group-chevrolet",
            containerFactory = "consumerCarro")
    public void salvarInfoCarro(@Payload String message) throws JsonProcessingException {
        InfoCarroData infoData = objectMapper.readValue(message, InfoCarroData.class);
        InfoCarroEntity infoCarroEntity = objectMapper.convertValue(infoData, InfoCarroEntity.class);
        infoRepository.save(infoCarroEntity);
    }

    public Double mediaVelocidade() {
        return infoRepository.findAll().stream().mapToDouble(InfoCarroEntity::getVelocidade)
                .average().orElseThrow();
    }

    public Double mediaRotacao() {
        return infoRepository.findAll().stream().mapToDouble(InfoCarroEntity::getRotacao)
                .average().orElseThrow();
    }

    public Long quantidadeLeituras() {
        return (long) infoRepository.findAll().size();
    }
}
