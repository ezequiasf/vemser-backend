package com.dbccompany.vemser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;
    @NotBlank
    private String tipoEndereco;
    @NotBlank
    @Size(min = 5, max = 250)
    private String logradouro;
    @NotNull
    private Integer numero;
    @NotBlank
    @NotEmpty
    @Size( max = 8)
    private String cep;
    private String bairro;
    @NotBlank
    @NotEmpty
    @Size( max = 250)
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String pais;
}
