package com.dbccompany.kafkahome.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "infoCarro")
public class InfoCarroEntity {
    @Id
    private String id;
    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}
