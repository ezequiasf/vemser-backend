package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.entity.Endereco;
import com.dbccompany.vemser.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Endereco getEnderecoPorId (@PathVariable("id") Integer idEndereco){
        return endService.encontrarEnderecoPorId(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> encontrarEnderecoPorPessoa (@PathVariable("idPessoa")Integer idPessoa){
        return endService.encontrarEnderecosPorPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Endereco cadastrarEndereco (@PathVariable("idPessoa") Integer idPessoa,@RequestBody Endereco endereco){
        return endService.cadastrarEndereco(endereco,idPessoa);
    }

    @PutMapping("/{id}")
    public Endereco atualizarEndereco (@PathVariable ("id")Integer id,@RequestBody Endereco endereco){
        return endService.atualizarEndereco(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco ( @PathVariable("id")Integer id){
        endService.deletarEndereco(id);
    }
}
