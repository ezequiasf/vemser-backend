package com.dbccompany.vemser.service;

import com.dbccompany.vemser.client.DadosCliente;
import com.dbccompany.vemser.dto.DadosPessoaisDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DadosPessoaisService {

    @Autowired
    private DadosCliente client;

    public List<DadosPessoaisDTO> requisitarDadosExternosPessoa (){
        return client.getAll();
    }

    public DadosPessoaisDTO criarDadoAmbienteExternoPessoa (DadosPessoaisDTO dto){
        return client.post(dto);
    }

    public DadosPessoaisDTO atualizarDadoAmbienteExternoPessoa (String cpf, DadosPessoaisDTO dto){
        return client.put(cpf, dto);
    }

    public void deletarDadoAmbienteExternoPessoa (String cpf){
        client.delete(cpf);
    }

    public DadosPessoaisDTO requisitarDadosPorCpf (String cpf){
        return client.get(cpf);
    }
}
