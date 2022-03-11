package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.entity.Pessoa;
import com.dbccompany.vemser.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(){
        pessoaService = new PessoaService();
    }

    @GetMapping("/all")
    public List<Pessoa> listarPessoas(){
        return pessoaService.listarPessoas();
    }

    @PostMapping("/cadastro")
    public Pessoa cadastrarPessoa (@RequestBody Pessoa pessoa){
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa atualizarPessoa (@PathVariable("id")Integer id,@RequestBody Pessoa pessoa){
        return pessoaService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa (@PathVariable Integer id){
        pessoaService.deletarPessoa(id);
    }

    @GetMapping("/findByName")
    public List<Pessoa> listarPessoasPorNome (@RequestParam("nome") String nome){
        return pessoaService.encontrarPorNome(nome);
    }
}
