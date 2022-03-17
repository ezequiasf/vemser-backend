package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.client.DadosCliente;
import com.dbccompany.vemser.dto.DadosPessoaisDTO;
import com.dbccompany.vemser.service.DadosPessoaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@RequiredArgsConstructor
public class DadosPController {

    @Autowired
    private final DadosPessoaisService service;

    @GetMapping
    public List<DadosPessoaisDTO> listDadosPessoais() {
        return service.requisitarDadosExternosPessoa();
    }

    @PostMapping
    public DadosPessoaisDTO create(
            @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return service.criarDadoAmbienteExternoPessoa(dadosPessoaisDTO);
    }

}
