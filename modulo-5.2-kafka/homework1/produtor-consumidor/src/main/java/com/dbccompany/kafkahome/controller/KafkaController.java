package com.dbccompany.kafkahome.controller;

import com.dbccompany.kafkahome.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaService kafkaService;

    @PostMapping("/send")
    public void sendMessage(@RequestParam String msg) {
        kafkaService.sendMessage(msg);
    }
}
