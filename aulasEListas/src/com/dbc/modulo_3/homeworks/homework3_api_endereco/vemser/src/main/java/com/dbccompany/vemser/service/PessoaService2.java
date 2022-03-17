package com.dbccompany.vemser.service;

import com.dbccompany.vemser.dto.DataTransitionBack;
import com.dbccompany.vemser.dto.DataTransitionFormed;
import com.dbccompany.vemser.entity.Entidade;
import com.dbccompany.vemser.entity.Pessoa2;
import com.dbccompany.vemser.repository.PessoaRepository2;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PessoaService2 {

    @Autowired
    private PessoaRepository2 pessoaRepo;
    @Autowired
    private ObjectMapper objectMapper;

    public DataTransitionFormed<Pessoa2> cadastrarPessoa (DataTransitionBack<Pessoa2> pessoaCreate){
        log.info("Chamada de método na service:: Cadastrar Pessoa");
        Pessoa2 entidadeCriar = objectMapper.convertValue(pessoaCreate.getT(), Pessoa2.class);
        Pessoa2 entidadeComId = pessoaRepo.salvar(entidadeCriar);
        return new DataTransitionFormed<>(entidadeComId);
    }
}
