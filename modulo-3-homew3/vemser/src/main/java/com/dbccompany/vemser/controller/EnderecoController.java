package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.dto.EnderecoCreateDTO;
import com.dbccompany.vemser.dto.EnderecoDTO;
import com.dbccompany.vemser.entity.Endereco;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.service.EmailService;
import com.dbccompany.vemser.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public List<EnderecoDTO> getEnderecos() {
        return endService.listarEnderecos();
    }

    @ApiOperation(value = "Retorna um endereço através do id.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorna um endereço."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/{id}")
    public EnderecoDTO getEnderecoPorId(@PathVariable("id") Integer idEndereco) throws RegraDeNegocioException {
        return endService.encontrarEnderecoPorId(idEndereco);
    }

    @ApiOperation(value = "Retorna uma lista de endereços através do id da pessoa.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorna uma lista de endereços."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> encontrarEnderecoPorPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return endService.encontrarEnderecosPorPessoa(idPessoa);
    }

    @ApiOperation(value = "Cadastra um endereço passando como parâmetro o id da pessoa.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Cadastrou uma pessoa."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PostMapping("/{idPessoa}")
    @Validated
    public EnderecoDTO cadastrarEndereco(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        EnderecoDTO enderecoDto = endService.cadastrarEndereco(endereco, idPessoa);
        emailService.sendEmail(enderecoDto, "cadastro-endereco-template.ftl");
        return enderecoDto;
    }

    @ApiOperation(value = "Atualiza um endereço através do id.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Endereço atualizou com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PutMapping("/{id}")
    @Validated
    public EnderecoDTO atualizarEndereco(@PathVariable("id") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        EnderecoDTO endDto = endService.atualizarEndereco(id, endereco);
        emailService.sendEmail(endDto, "atualizar-endereco-template.ftl");
        return endDto;
    }

    @ApiOperation(value = "Exclui um endereço do banco.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Exclusão concluída com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @DeleteMapping("/{id}")
    public EnderecoDTO deletarEndereco(@PathVariable("id") Integer id) throws RegraDeNegocioException {
        EnderecoDTO enderecoDTO = endService.deletarEndereco(id);
        emailService.sendEmail(enderecoDTO, "excluir-endereco-template.ftl");
        return enderecoDTO;
    }
}
