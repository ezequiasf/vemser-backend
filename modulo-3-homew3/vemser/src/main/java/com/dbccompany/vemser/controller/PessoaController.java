package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.dto.PessoaCreateDTO;
import com.dbccompany.vemser.dto.PessoaDTO;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.service.EmailService;
import com.dbccompany.vemser.service.PessoaService;
import com.dbccompany.vemser.service.PropertieReader;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader leitor;

    @Autowired
    private EmailService servicoDeEmail;

    @GetMapping("/ambiente")
    public String retornaAmbiente() {
        return "O ambiente é: " + leitor.getAmbiente();
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"), @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/all")
    public List<PessoaDTO> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @ApiOperation(value = "Cadastra uma pessoa")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Uma pessoa foi cadastrada com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @Validated
    @PostMapping("/cadastro")
    public PessoaDTO cadastrarPessoa(@Valid @RequestBody PessoaCreateDTO pessoaCreate) {
        PessoaDTO pessoaCadastrada = pessoaService.cadastrarPessoa(pessoaCreate);
        servicoDeEmail.sendEmail(pessoaCadastrada, "cadastro-pessoa-template.ftl");
        return pessoaCadastrada;
    }

    @ApiOperation(value = "Atualizar uma pessoa")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Uma pessoa foi atualizada com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @Validated
    @PutMapping("/{id}")
    public PessoaDTO atualizarPessoa(@PathVariable("id") Integer id, @Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        PessoaDTO pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoa);
        servicoDeEmail.sendEmail(pessoaAtualizada, "atualizar-pessoa-template.ftl");
        return pessoaAtualizada;
    }

    @ApiOperation(value = "Deleta uma pessoa")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Uma pessoa foi deletada com sucesso do cadastro"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @DeleteMapping("/{id}")
    public PessoaDTO deletarPessoa(@PathVariable Integer id) throws RegraDeNegocioException {
        PessoaDTO p = pessoaService.deletarPessoa(id);
        servicoDeEmail.sendEmail(p, "deletar-pessoa-template.ftl");
        return p;
    }

    @ApiOperation(value = "Retorna uma lista de pessoas através do nome.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorna uma lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/findByName")
    public List<PessoaDTO> listarPessoasPorNome(@RequestParam("nome") String nome) {
        return pessoaService.encontrarPorNome(nome);
    }
}
