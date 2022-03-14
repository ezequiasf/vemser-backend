package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.entity.Endereco;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService endService;

    @GetMapping("/")
    public List<Endereco> getEnderecos (){
        return endService.listarEnderecos();
    }

    @GetMapping("/{id}")
    public Endereco getEnderecoPorId (@PathVariable("id") Integer idEndereco) throws RegraDeNegocioException {
        return endService.encontrarEnderecoPorId(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> encontrarEnderecoPorPessoa (@PathVariable("idPessoa")Integer idPessoa){
        return endService.encontrarEnderecosPorPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    @Validated
    public Endereco cadastrarEndereco (@PathVariable("idPessoa") Integer idPessoa,@Valid @RequestBody Endereco endereco) throws RegraDeNegocioException {
        return endService.cadastrarEndereco(endereco,idPessoa);
    }

    @PutMapping("/{id}")
    @Validated
    public Endereco atualizarEndereco (@PathVariable ("id")Integer id,@Valid @RequestBody Endereco endereco) throws RegraDeNegocioException {
        return endService.atualizarEndereco(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco (@PathVariable("id")Integer id) throws RegraDeNegocioException {
        endService.deletarEndereco(id);
    }
}
