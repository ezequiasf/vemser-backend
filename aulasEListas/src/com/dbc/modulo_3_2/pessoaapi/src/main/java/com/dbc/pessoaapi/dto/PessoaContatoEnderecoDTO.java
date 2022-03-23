package com.dbc.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaContatoEnderecoDTO extends PessoaCreateDTO{
    private Integer idPessoa;
    private List<ContatoDTO> contatos;
    private List<EnderecoDTO> enderecoDTOS;
}
