package com.dbc.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTATO_GER")
    @SequenceGenerator(name = "SEQ_CONTATO_GER", sequenceName = "SEQ_CONTATO", allocationSize = 1)
    private Integer id_contato;

    @Column(name = "ID_PESSOA")
    private Integer id_pessoa;

    @Column(name = "TIPO")
    private Integer tipo;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "DESCRICAO")
    private String descricao;
}
