package com.dbc.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {
    @NotBlank
    private String tipoContato;
    @NotBlank
    @Size(min = 8, max = 11)
    private String numero;
    @NotBlank
    @Size(min = 1, max = 50)
    private String descricao;
}
