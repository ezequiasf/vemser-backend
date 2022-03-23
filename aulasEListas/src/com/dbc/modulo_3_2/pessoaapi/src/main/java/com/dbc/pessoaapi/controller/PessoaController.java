package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaComContatoDTO;
import com.dbc.pessoaapi.dto.PessoaComEnderecoDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) {
        log.info("criando pessoa");
        PessoaDTO pessoaCriado = pessoaService.create(pessoa);
        return new ResponseEntity<>(pessoaCriado, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

    @GetMapping("/findByNome")
    public List<PessoaDTO> findByNome(@RequestParam String nome) {
        return pessoaService.findByNome(nome);
    }

    @GetMapping("/findByCpf")
    public PessoaDTO findByCpf (@RequestParam String cpf){
        return pessoaService.findByCpf(cpf);
    }

    @GetMapping("/findByDataNascimento")
    public List<PessoaDTO> findByDataNascimento(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                @RequestParam LocalDate dataInicio,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                        LocalDate dataFim) {
        return pessoaService.findDataNascimentoBetween(dataInicio, dataFim);
    }

    @GetMapping("/findByIdPessoaContato")
    public List<PessoaComContatoDTO> findByIdPessoaContato (@RequestParam(required = false) Integer idPessoa){
        return pessoaService.findContatoPessoaOuTodas(idPessoa);
    }

    @GetMapping("/findByIdPessoaEndereco")
    public List<PessoaComEnderecoDTO> findByIdPessoaEndereco (@RequestParam(required = false)Integer idPessoa){
        return pessoaService.findEnderecoByIdPessoa(idPessoa);
    }

}
