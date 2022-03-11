package com.dbccompany.vemser.repository;

import com.dbccompany.vemser.entity.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {

    private final List<Contato> contatos = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository (){
        contatos.add(new Contato(COUNTER.incrementAndGet(), 1, "RESIDENCIAL", "8423632", "Whats"));
        contatos.add(new Contato(COUNTER.incrementAndGet(), 1, "TRABALHO", "8423632", "Whats"));
        contatos.add(new Contato(COUNTER.incrementAndGet(), 2, "RESIDENCIAL", "8423632", "Whats"));
        contatos.add(new Contato(COUNTER.incrementAndGet(), 3, "RESIDENCIAL", "8423632", "Whats"));
    }

    public Contato cadastrarContato (Contato contato){
        contato.setIdContato(COUNTER.incrementAndGet());
        contatos.add(contato);
        return contato;
    }

    public List<Contato> listarContatos (){
        return contatos;
    }

    public Contato atualizarContato (Integer id, Contato contato) throws Exception {
        Contato contatoAtualizar = contatos.stream()
                .filter(c -> c.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(()-> new Exception("Contato não encontrado."));
        contatoAtualizar.setTipoContato(contato.getTipoContato());
        contatoAtualizar.setDescricao(contato.getDescricao());
        contatoAtualizar.setNumero(contato.getNumero());
        return contatoAtualizar;
    }

    public void deletarContato (Integer id) throws Exception {
        Contato contatoDeletar = contatos.stream()
                .filter(c -> c.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(()-> new Exception("Contato não encontrado."));
        contatos.remove(contatoDeletar);
    }

    public List<Contato> encontrarPorTipo (String tipo){
        return contatos.stream()
                        .filter(c -> c.getTipoContato().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

}
