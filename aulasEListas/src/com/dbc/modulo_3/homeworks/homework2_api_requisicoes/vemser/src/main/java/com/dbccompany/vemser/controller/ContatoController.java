package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.entity.Contato;
import com.dbccompany.vemser.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController (){
        contatoService = new ContatoService();
    }

    @PostMapping("/cadastrar")
    public Contato cadastrarContato (@RequestBody Contato contato){
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
    public Contato putContato (@PathVariable("id") Integer id,@RequestBody Contato contato){
        return contatoService.atualizarContato(id, contato);
    }

    @DeleteMapping("/{id}")
    public void deletarContato (@PathVariable("id")Integer id){
        contatoService.deletarContato(id);
    }

    @GetMapping("/findByTipo")
    public List<Contato> encontrarPorTipo (@RequestParam("tipo") String tipo){
        return contatoService.listarPorTipo(tipo);
    }

}
