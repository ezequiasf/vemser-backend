package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.dto.DadosPessoaisDTO;
import com.dbccompany.vemser.service.DadosPessoaisService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@RequiredArgsConstructor
public class DadosPessoaisController {

    @Autowired
    private final DadosPessoaisService service;

    @ApiOperation(value = "Retorna toda a lista de dados pessoais.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retornou a lista com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping
    public List<DadosPessoaisDTO> listDadosPessoais() {
        return service.requisitarDadosExternosPessoa();
    }

    @ApiOperation(value = "Cadastra dados pessoais.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Cadastrou com sucesso no banco de dados."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PostMapping
    public DadosPessoaisDTO create(
            @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return service.criarDadoAmbienteExternoPessoa(dadosPessoaisDTO);
    }

    @ApiOperation(value = "Atualiza os dados pessoais num ambiente externo.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Atualizou os dados pessoais com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update(@PathVariable("cpf") String cpf,
                          @RequestBody DadosPessoaisDTO dto) throws Exception {
        return service.atualizarDadoAmbienteExternoPessoa(cpf, dto);
    }

    @ApiOperation(value = "Deletar um dado pessoal no ambiente/api externa.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Deletou com sucesso o dado pessoal."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf){
        service.deletarDadoAmbienteExternoPessoa(cpf);
    }

    @ApiOperation(value = "Retorna um dado pessoal através do cpf.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retornou o dado pessoal com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/{cpf}")
    public DadosPessoaisDTO getByCpf(@PathVariable("cpf") String cpf){
        return service.requisitarDadosPorCpf(cpf);
    }

}
