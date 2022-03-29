package com.dbc.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaComContatoDTO extends PessoaCreateDTO{
    private Integer idPessoa;
    private List<ContatoDTO> contatos;
}
