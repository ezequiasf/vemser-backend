package com.dbccompany.vemser.dto;

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
public class EnderecoCreateDTO implements DTO{
    private Integer idPessoa;
    @NotBlank
    private String tipoEndereco;
    @NotBlank
    @Size(max = 250)
    private String logradouro;
    @NotNull
    private Integer numero;
    @NotBlank
    @Size( max = 8)
    private String cep;
    @NotBlank
    private String bairro;
    @NotBlank
    @Size( max = 250)
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String pais;
}
