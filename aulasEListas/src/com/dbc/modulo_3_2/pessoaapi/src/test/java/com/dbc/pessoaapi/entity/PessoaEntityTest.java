package com.dbc.pessoaapi.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoaEntityTest {

    @Test
    public void testLombok() {
        PessoaEntity pessoa = new PessoaEntity();
        pessoa.setIdPessoa(1);
        pessoa.setNome("OI");
        pessoa.setDataNascimento(LocalDate.of(1991, 10, 10));
        pessoa.setCpf("132456789");
        System.out.println(pessoa.toString());

        PessoaEntity pessoa1 = PessoaEntity.builder()
                .idPessoa(1)
                .cpf("teste")
                .dataNascimento(LocalDate.of(1991, 10, 10))
                .nome("Maicon")
                .build();

        var pessoaX = PessoaEntity.builder()
                .idPessoa(1)
                .cpf("teste")
                .dataNascimento(LocalDate.of(1991, 10, 10))
                .nome("Maicon")
                .build();
    }
}