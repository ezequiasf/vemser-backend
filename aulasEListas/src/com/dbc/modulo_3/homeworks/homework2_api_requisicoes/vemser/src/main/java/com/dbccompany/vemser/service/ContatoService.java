package com.dbccompany.vemser.service;

import com.dbccompany.vemser.entity.Contato;
import com.dbccompany.vemser.repository.ContatoRepository;

import java.util.List;

public class ContatoService {

    private final ContatoRepository contatoRepo;

    public ContatoService (){
        this.contatoRepo = new ContatoRepository();
    }

    public Contato cadastrarContato (Contato contato){
        return contatoRepo.cadastrarContato(contato);
    }

    public List<Contato> listarContatos (){
        return contatoRepo.listarContatos();
    }

    public Contato atualizarContato (Integer id, Contato contato){
        Contato cont = null;
        try {
            cont = contatoRepo.atualizarContato(id, contato);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cont;
    }

    public void deletarContato (Integer id){
        try {
            contatoRepo.deletarContato(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Contato> listarPorTipo (String tipo){
        return contatoRepo.encontrarPorTipo(tipo);
    }
}
