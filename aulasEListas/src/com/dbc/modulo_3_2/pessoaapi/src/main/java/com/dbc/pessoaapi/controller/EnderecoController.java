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

    @PostMapping("/{idPessoa}")
    @Validated
    public EnderecoDTO cadastrarEndereco(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody EnderecoCreateDTO dto) throws RegraDeNegocioException {
        return enderecoService.criarEndereco(idPessoa, dto);
    }

    @PutMapping("/{idEndereco}")
    public EnderecoDTO atualizarEndereco(@PathVariable("idEndereco") Integer idEndereco, @Valid @RequestBody EnderecoCreateDTO dto) throws RegraDeNegocioException {
        return enderecoService.atualizarEndereco(idEndereco, dto);
    }

    @DeleteMapping("/{idEndereco}")
    public void deletarEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.deletarEndereco(idEndereco);
    }

    @GetMapping("/findByPais")
    public List<EnderecoDTO> findByPais (@RequestParam String pais){
        return enderecoService.findEnderecoByPais(pais);
    }

    @GetMapping("/findByIdPessoa")
    public List<EnderecoDTO> findByIdPessoa (@RequestParam Integer idPessoa){
        return enderecoService.findEnderecoByIdPessoa(idPessoa);
    }

    @GetMapping("/findByCidadeOuPessoa")
    public List<EnderecoDTO> findByCidadeOuPais (@RequestParam String cidade, @RequestParam String pais){
        return enderecoService.findEnderecosByCidadeOuPais(cidade, pais);
    }

    @GetMapping("/findEnderecoSemComplemento")
    public List<EnderecoDTO> findEnderecoSemComplemento (){
        return enderecoService.findEnderecoSemComplemento();
    }

}
