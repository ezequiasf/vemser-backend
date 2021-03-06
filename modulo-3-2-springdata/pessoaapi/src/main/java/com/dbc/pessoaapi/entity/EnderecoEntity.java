package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private TipoEndereco tipo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos")
    private Set<PessoaEntity> pessoas;
}
