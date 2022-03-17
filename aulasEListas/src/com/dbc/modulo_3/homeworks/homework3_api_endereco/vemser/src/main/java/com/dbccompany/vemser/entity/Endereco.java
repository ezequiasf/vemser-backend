package com.dbccompany.vemser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;
    private String tipoEndereco;
    private String logradouro;
    private Integer numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
}
