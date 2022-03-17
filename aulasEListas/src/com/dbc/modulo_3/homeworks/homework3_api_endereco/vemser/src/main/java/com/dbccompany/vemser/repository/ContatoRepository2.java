package com.dbccompany.vemser.repository;

import com.dbccompany.vemser.entity.Contato;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository2 implements RepositorioGenerico<Contato, Integer> {

    private final List<Contato> contatos = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository2() {
        Contato c = Contato.builder()
                .idContato(COUNTER.incrementAndGet())
                .idPessoa(1)
                .tipoContato("Residencial")
                .numero("84235467")
                .descricao("Whats").build();
        contatos.add(c);
    }

    @Override
    public Contato salvar(Contato c) {
        c.setIdContato(COUNTER.incrementAndGet());
        contatos.add(c);
        return c;
    }

    @Override
    public Contato atualizar(Contato c, Integer id) throws RegraDeNegocioException {
        Contato contatoAtualizar = encontrarPorId(id);
        contatoAtualizar.setTipoContato(c.getTipoContato());
        contatoAtualizar.setDescricao(c.getDescricao());
        contatoAtualizar.setNumero(c.getNumero());
        return contatoAtualizar;
    }

    @Override
    public List<Contato> lerTodos() {
        return contatos;
    }

    @Override
    public void deletar(Integer id) throws RegraDeNegocioException {
        Contato contatoDeletar = encontrarPorId(id);
        contatos.remove(contatoDeletar);
    }

    /*  >>> Diferentes implementações  */
    public List<Contato> encontrarPorPessoa(Integer idPessoa) {
        return contatos.stream()
                .filter(c -> c.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public List<Contato> encontrarPorTipo(String tipo) {
        return contatos.stream()
                .filter(c -> c.getTipoContato().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public Contato encontrarPorId(Integer id) throws RegraDeNegocioException {
        return contatos.stream()
                .filter(c -> c.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(()-> new RegraDeNegocioException("Contato não encontrado."));
    }
}
