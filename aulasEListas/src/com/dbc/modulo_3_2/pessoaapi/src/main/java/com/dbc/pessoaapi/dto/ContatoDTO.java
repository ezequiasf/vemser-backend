package com.dbc.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO extends ContatoCreateDTO {
    private Integer id_contato;
    private Integer id_pessoa;
}
