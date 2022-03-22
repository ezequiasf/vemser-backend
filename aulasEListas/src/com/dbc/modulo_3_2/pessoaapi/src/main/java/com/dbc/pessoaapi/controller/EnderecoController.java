package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoDTO> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }

    @PostMapping
    @Validated
    public EnderecoDTO cadastrarEndereco(@Valid @RequestBody EnderecoCreateDTO dto) throws RegraDeNegocioException {
        return enderecoService.criarEndereco(dto);
    }

    @PutMapping("/{idEndereco}")
    public EnderecoDTO atualizarEndereco(@PathVariable("idEndereco") Integer idEndereco, @Valid @RequestBody EnderecoCreateDTO dto) throws RegraDeNegocioException {
        return enderecoService.atualizarEndereco(idEndereco, dto);
    }

    @DeleteMapping("/{idEndereco}")
    public void deletarEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.deletarEndereco(idEndereco);
    }

}
