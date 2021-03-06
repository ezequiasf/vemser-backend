package com.dbccompany.kafkahome.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MensagemDTO {
    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;
}
