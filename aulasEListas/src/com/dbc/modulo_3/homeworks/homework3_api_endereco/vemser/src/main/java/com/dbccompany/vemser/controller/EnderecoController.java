package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.dto.EnderecoCreateDTO;
import com.dbccompany.vemser.dto.EnderecoDTO;
import com.dbccompany.vemser.entity.Endereco;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.service.EmailService;
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

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public List<EnderecoDTO> getEnderecos() {
        return endService.listarEnderecos();
    }

    @GetMapping("/{id}")
    public EnderecoDTO getEnderecoPorId(@PathVariable("id") Integer idEndereco) throws RegraDeNegocioException {
        return endService.encontrarEnderecoPorId(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> encontrarEnderecoPorPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return endService.encontrarEnderecosPorPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    @Validated
    public EnderecoDTO cadastrarEndereco(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        EnderecoDTO enderecoDto = endService.cadastrarEndereco(endereco, idPessoa);
        emailService.sendEmail(enderecoDto, "cadastro-endereco-template.ftl");
        return enderecoDto;
    }

    @PutMapping("/{id}")
    @Validated
    public EnderecoDTO atualizarEndereco(@PathVariable("id") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        EnderecoDTO endDto = endService.atualizarEndereco(id, endereco);
        emailService.sendEmail(endDto, "atualizar-endereco-template.ftl");
        return endDto;
    }

    @DeleteMapping("/{id}")
    public EnderecoDTO deletarEndereco(@PathVariable("id") Integer id) throws RegraDeNegocioException {
        EnderecoDTO enderecoDTO = endService.deletarEndereco(id);
        emailService.sendEmail(enderecoDTO, "excluir-endereco-template.ftl");
        return enderecoDTO;
    }
}
