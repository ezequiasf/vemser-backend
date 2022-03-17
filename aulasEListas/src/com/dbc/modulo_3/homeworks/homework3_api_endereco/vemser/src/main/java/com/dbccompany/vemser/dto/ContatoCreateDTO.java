package com.dbccompany.vemser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContatoCreateDTO implements DTO{
    private Integer idPessoa;
    @NotBlank
    private String tipoContato;
    @NotBlank
    @Size(max = 13)
    private String numero;
    @NotBlank
    private String descricao;
}
