package com.dbccompany.kafkahome.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfoDetalhada {
    public Double mediaVelocidade;
    public Double mediaRotacao;
    public Long qtdInfo;
}
