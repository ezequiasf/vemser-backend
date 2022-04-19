package com.dbccompany.vemser.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDto {
    private String destinatario;
    private String assunto;
    private String mensagem;
}
