package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.entity.Pessoa;
import com.dbccompany.vemser.service.PessoaService;
import com.dbccompany.vemser.service.PropertieReader;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader leitor;

    @GetMapping("/ambiente")
    public String retornaAmbiente(){
        return "O ambiente é: "+ leitor.getAmbiente();
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
