package com.dbccompany.kafkahome.controller;

import com.dbccompany.kafkahome.dto.*;
import com.dbccompany.kafkahome.service.CarroService;
import com.dbccompany.kafkahome.service.KafkaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/carro")
@RequiredArgsConstructor
public class CarroController {

    private final KafkaService kafkaService;
    private final CarroService carroService;
    private final ObjectMapper objectMapper;

    @PostMapping("/salvar-info")
    public void salvarInfoCarro(InfoCarroDto info) throws JsonProcessingException {
        InfoCarroData infoData = objectMapper.convertValue(info, InfoCarroData.class);
        infoData.setDataLeitura(LocalDateTime.now());

        String payload = objectMapper.writeValueAsString(infoData);

        kafkaService.sendMessage(payload);
    }

    @GetMapping("/info-detalhada")
    public InfoDetalhada getInfoDetalhada() {
        return InfoDetalhada.builder()
                .mediaVelocidade(carroService.mediaVelocidade())
                .mediaRotacao(carroService.mediaRotacao())
                .qtdInfo(carroService.quantidadeLeituras()).build();
    }

}
