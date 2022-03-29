package com.dbccompany.vemser.repository;

import com.dbccompany.vemser.entity.Endereco;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private final List<Endereco> enderecos;
    private final AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        enderecos = new ArrayList<>();
        enderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, "Residencial", "Rua qualquer", 75, "48680-970", "Abaré", "Bahia", "Brasil", "bairrinho"));
        enderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, "Trabalho", "Rua nenhuma", 87, "57660-970", "Alguma", "Alagoas", "Brasil", "obinho"));
        enderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, "Trabalho", "Rua dos bobos", 65, "54490-102", "Jaboatão", "Pernambuco", "Brasil", "Bairro dos bobos"));
        enderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, "Residencial", "Rua do ze ninguem", 344, "48288-970", "Salvador", "Bahia", "Brasil", "Bairrão"));
    }

    public List<Endereco> listarEnderecos() {
        return enderecos;
    }

    public Endereco encontrarEnderecoPorId(Integer id) throws RegraDeNegocioException {
        return enderecos.stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado."));
    }

    public Endereco cadastrarEndereco(Endereco endereco, Integer idPessoa) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        enderecos.add(endereco);
        return endereco;
    }

    public Endereco atualizarEndereco(Integer id, Endereco endereco) throws RegraDeNegocioException {
        Endereco endAtualizar = encontrarEnderecoPorId(id);
        endAtualizar.setCep(endereco.getCep());
        endAtualizar.setCidade(endereco.getCidade());
        endAtualizar.setPais(endereco.getPais());
        endAtualizar.setTipoEndereco(endereco.getTipoEndereco());
        endAtualizar.setEstado(endereco.getEstado());
        endAtualizar.setNumero(endereco.getNumero());
        endAtualizar.setBairro(endereco.getBairro());
        endAtualizar.setLogradouro(endereco.getLogradouro());
        return endAtualizar;
    }

    public Endereco deletarEndereco(Integer id) throws RegraDeNegocioException {
        Endereco endDeletar = encontrarEnderecoPorId(id);
        enderecos.remove(endDeletar);
        return endDeletar;
    }

    public List<Endereco> encontrarEnderecoPorPessoa(Integer idPessoa) {
        return enderecos.stream()
                .filter(e -> e.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }


}
