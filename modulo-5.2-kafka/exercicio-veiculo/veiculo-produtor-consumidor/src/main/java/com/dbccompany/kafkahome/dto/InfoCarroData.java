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
public class InfoCarroData extends InfoCarroDto{
    private LocalDateTime dataLeitura;
}
