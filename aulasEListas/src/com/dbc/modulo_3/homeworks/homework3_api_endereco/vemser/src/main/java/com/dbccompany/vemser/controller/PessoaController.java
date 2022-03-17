package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.dto.PessoaCreateDTO;
import com.dbccompany.vemser.dto.PessoaDTO;
import com.dbccompany.vemser.entity.Pessoa;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.service.EmailService;
import com.dbccompany.vemser.service.PessoaService;
import com.dbccompany.vemser.service.PropertieReader;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
//
//@RestController
//@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader leitor;

    @Autowired
    private EmailService servicoDeEmail;

    @GetMapping("/ambiente")
    public String retornaAmbiente(){
        return "O ambiente é: "+ leitor.getAmbiente();
    }

    @GetMapping("/all")
    public List<PessoaDTO> listarPessoas(){
        return pessoaService.listarPessoas();
    }

    @Validated
    @PostMapping("/cadastro")
    public PessoaDTO cadastrarPessoa (@Valid @RequestBody PessoaCreateDTO pessoaCreate){
        PessoaDTO pessoaCadastrada = pessoaService.cadastrarPessoa(pessoaCreate);
        servicoDeEmail.sendEmail(pessoaCadastrada);
        return pessoaCadastrada;
    }

    @Validated
    @PutMapping("/{id}")
    public PessoaDTO atualizarPessoa (@PathVariable("id")Integer id, @Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        return pessoaService.atualizarPessoa(id,pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa (@PathVariable Integer id) throws RegraDeNegocioException{
        pessoaService.deletarPessoa(id);
    }

    @GetMapping("/findByName")
    public List<PessoaDTO> listarPessoasPorNome (@RequestParam("nome") String nome){
        return pessoaService.encontrarPorNome(nome);
    }
}
