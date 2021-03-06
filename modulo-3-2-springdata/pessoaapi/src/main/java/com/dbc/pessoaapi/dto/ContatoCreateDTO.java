package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {
    @NotNull
    private TipoContato tipoContato;
    @NotBlank
    @Size(min = 8, max = 11)
    private String numero;
    @NotBlank
    @Size(min = 1, max = 50)
    private String descricao;
}
