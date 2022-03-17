package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.dto.DTOUtils;
import com.dbccompany.vemser.dto.DataTransitionBack;
import com.dbccompany.vemser.dto.DataTransitionFormed;
import com.dbccompany.vemser.entity.Pessoa;
import com.dbccompany.vemser.entity.Pessoa2;
import com.dbccompany.vemser.service.PessoaService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/pessoa")
public class PessoaController2 {

    @Autowired
    private PessoaService2 pessoaService;

    private final DTOUtils<Pessoa2> dtoUtils = new DTOUtils<>();

    @Validated
    @PostMapping("/cadastro")
    public DataTransitionFormed<Pessoa2> cadastrarPessoa (@Valid @RequestBody Pessoa2 y){
        DataTransitionBack<Pessoa2> d = (DataTransitionBack<Pessoa2>) dtoUtils
                .getTransitionInformation(y, "nome", "cpf", "nascimento");
        return pessoaService.cadastrarPessoa(d);
    }
}
