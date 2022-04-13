package com.dbccompany.kafkahome.controller;

import com.dbccompany.kafkahome.dto.MensagemCompleta;
import com.dbccompany.kafkahome.dto.MensagemDTO;
import com.dbccompany.kafkahome.model.NomesChats;
import com.dbccompany.kafkahome.service.KafkaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mensagem")
public class MensagemController {

    private final KafkaService kafkaService;
    private final ObjectMapper objectMapper;
    private final String USUARIO = "ezequias";

    @PostMapping("/envio")
    public void envioMensagem(@RequestBody String msg, NomesChats chats) throws JsonProcessingException {
        MensagemDTO msgCompleta = new MensagemDTO(USUARIO, msg, LocalDateTime.now());

        String payload = objectMapper.writeValueAsString(msgCompleta);

        kafkaService.sendMessage(payload, chats);
    }
}
