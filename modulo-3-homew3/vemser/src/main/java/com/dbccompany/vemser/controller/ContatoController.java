package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.dto.ContatoCreateDTO;
import com.dbccompany.vemser.dto.ContatoDTO;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @ApiOperation(value = "Cadastra um contato no banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Cadastrou o contato com sucesso no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PostMapping("/cadastrar")
    @Validated
    public ContatoDTO cadastrarContato(@Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        return contatoService.cadastrarContato(contato);
    }

    @ApiOperation(value = "Retorna todos os contatos.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retornou com sucesso todos os contatos."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/all")
    public List<ContatoDTO> getContatos() {
        return contatoService.listarContatos();
    }

    @ApiOperation(value = "Retorna uma lista de contatos passando o id da pessoa como parâmetro.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retornou com sucesso a lista."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/pessoa/{id}")
    public List<ContatoDTO> listarContatosPorPessoa(@PathVariable("id") Integer idPessoa) {
        return contatoService.listarContatosPorPessoa(idPessoa);
    }

    @ApiOperation(value = "Atualiza um contato através do id.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Atualizou o contato no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PutMapping("/{id}")
    @Validated
    public ContatoDTO putContato(@PathVariable("id") Integer id, @Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        return contatoService.atualizarContato(id, contato);
    }

    @ApiOperation(value = "Deleta um contato através do id.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Deletou o contato com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @DeleteMapping("/{id}")
    public void deletarContato(@PathVariable("id") Integer id) throws RegraDeNegocioException {
        contatoService.deletarContato(id);
    }

    @ApiOperation(value = "Retorna uma lista de contatos através do tipo.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retornou com sucesso a lista."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/findByTipo")
    public List<ContatoDTO> encontrarPorTipo(@RequestParam("tipo") String tipo) {
        return contatoService.listarPorTipo(tipo);
    }

}
