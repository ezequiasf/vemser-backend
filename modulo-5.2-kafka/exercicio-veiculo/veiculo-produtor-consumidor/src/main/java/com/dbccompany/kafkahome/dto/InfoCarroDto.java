package com.dbccompany.kafkahome.dto;

import lombok.Data;

@Data
public class InfoCarroDto {
    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}
