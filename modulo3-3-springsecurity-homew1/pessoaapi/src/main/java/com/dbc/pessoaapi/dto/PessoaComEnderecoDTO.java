package com.dbc.pessoaapi.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PessoaComEnderecoDTO extends PessoaCreateDTO{
    private Integer idPessoa;
    private List<EnderecoDTO> enderecos;
}
