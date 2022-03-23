package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.ContatoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@RequiredArgsConstructor
@Slf4j
public class ContatoController {

    private final ContatoService contatoService;

    @GetMapping
    public List<ContatoDTO> listarContatos() {
        return contatoService.listarContatos();
    }

    @PostMapping("/{idPessoa}")
    @Validated
    public ContatoDTO cadastrarContato(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody ContatoCreateDTO dto) throws RegraDeNegocioException {
        return contatoService.criarContato(idPessoa, dto);
    }

    @PutMapping("/{idContato}")
    @Validated
    public ContatoDTO atualizarContato(@PathVariable("idContato") Integer idContato, @Valid @RequestBody ContatoCreateDTO dto) throws RegraDeNegocioException {
        return contatoService.atualizarContato(idContato, dto);
    }

    @DeleteMapping("/{idContato}")
    public void deletarContato(@PathVariable("idContato") Integer idContato) throws RegraDeNegocioException {
        contatoService.deletarContato(idContato);
    }
}
