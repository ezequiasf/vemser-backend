package com.dbccompany.vemser.repository;

import com.dbccompany.vemser.entity.Contato;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {

    private final List<Contato> contatos = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        contatos.add(new Contato(COUNTER.incrementAndGet(), 1, "RESIDENCIAL", "8423632", "Whats"));
    }

    public Contato cadastrarContato(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        contatos.add(contato);
        return contato;
    }

    public List<Contato> listarContatoPessoa(Integer idPessoa) {
        return contatos.stream()
                .filter(c -> c.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public List<Contato> listarContatos() {
        return contatos;
    }

    public Contato atualizarContato(Integer id, Contato contato) throws RegraDeNegocioException {
        Contato contatoAtualizar = encontrarContatoPorId(id);
        contatoAtualizar.setTipoContato(contato.getTipoContato());
        contatoAtualizar.setDescricao(contato.getDescricao());
        contatoAtualizar.setNumero(contato.getNumero());
        return contatoAtualizar;
    }

    public void deletarContato(Integer id) throws RegraDeNegocioException {
        Contato contatoDeletar = encontrarContatoPorId(id);
        contatos.remove(contatoDeletar);
    }

    public List<Contato> encontrarPorTipo(String tipo) {
        return contatos.stream()
                .filter(c -> c.getTipoContato().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    //Método get sendo usado para validação.
    public Contato encontrarContatoPorId(Integer id) throws RegraDeNegocioException {
        return contatos.stream()
                .filter(c -> c.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado."));
    }
}
