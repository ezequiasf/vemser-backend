package com.dbc.pessoaapi.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class ContatoDTOTest {
    @Test
    void test(){

        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setTipoContato(2);

        Contato contato1 = new ObjectMapper().convertValue(contatoDTO, Contato.class);



        Contato contato = new Contato();
        contato.setTipoContato(TipoContato.COMERCIAL);
    }
}