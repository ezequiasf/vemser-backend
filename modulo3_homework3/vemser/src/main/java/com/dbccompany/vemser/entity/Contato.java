package com.dbccompany.vemser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    private String tipoContato;
    private String numero;
    private String descricao;
}
