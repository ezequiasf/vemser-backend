package com.dbccompany.vemser.controller;

import com.dbccompany.vemser.dto.ContatoCreateDTO;
import com.dbccompany.vemser.dto.ContatoDTO;
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
    public ContatoDTO cadastrarContato (@Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        return contatoService.cadastrarContato(contato);
    }

    @GetMapping("/all")
    public List<ContatoDTO> getContatos (){
        return contatoService.listarContatos();
    }

    @GetMapping("/pessoa/{id}")
    public List<ContatoDTO> listarContatosPorPessoa (@PathVariable("id") Integer idPessoa){
        return contatoService.listarContatosPorPessoa(idPessoa);
    }

    @PutMapping("/{id}")
    @Validated
    public ContatoDTO putContato (@PathVariable("id") Integer id,@Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        return contatoService.atualizarContato(id, contato);
    }

    @DeleteMapping("/{id}")
    public void deletarContato (@PathVariable("id")Integer id) throws RegraDeNegocioException {
        contatoService.deletarContato(id);
    }

    @GetMapping("/findByTipo")
    public List<ContatoDTO> encontrarPorTipo (@RequestParam("tipo") String tipo){
        return contatoService.listarPorTipo(tipo);
    }

}
