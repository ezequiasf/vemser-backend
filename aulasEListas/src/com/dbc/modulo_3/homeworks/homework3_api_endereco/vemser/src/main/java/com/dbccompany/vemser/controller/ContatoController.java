package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.entity.Contato;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.service.ContatoService;
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

    @PostMapping("/cadastrar")
    @Validated
    public Contato cadastrarContato (@Valid @RequestBody Contato contato) throws RegraDeNegocioException {
        return contatoService.cadastrarContato(contato);
    }

    @GetMapping("/all")
    public List<Contato> getContatos (){
        return contatoService.listarContatos();
    }

    @GetMapping("/pessoa/{id}")
    public List<Contato> listarContatosPorPessoa (@PathVariable("id") Integer idPessoa){
        return contatoService.listarContatosPorPessoa(idPessoa);
    }

    @PutMapping("/{id}")
    @Validated
    public Contato putContato (@PathVariable("id") Integer id,@Valid @RequestBody Contato contato) throws RegraDeNegocioException {
        return contatoService.atualizarContato(id, contato);
    }

    @DeleteMapping("/{id}")
    public void deletarContato (@PathVariable("id")Integer id) throws RegraDeNegocioException {
        contatoService.deletarContato(id);
    }

    @GetMapping("/findByTipo")
    public List<Contato> encontrarPorTipo (@RequestParam("tipo") String tipo){
        return contatoService.listarPorTipo(tipo);
    }

}
