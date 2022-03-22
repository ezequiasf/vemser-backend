package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Endereco_Pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_END")
    @SequenceGenerator(name = "SEQ_END", sequenceName = "SEQ_ENDERECO_CONTATO", allocationSize = 1)
    private Integer id_endereco;
    private Integer tipo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
}
