package com.dbccompany.vemser.repository;

import com.dbccompany.vemser.entity.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private List<Endereco> enderecos;
    private final AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository (){
        enderecos = new ArrayList<>();
        enderecos.add(new Endereco(COUNTER.incrementAndGet(),1, "Rua qualquer, 75", "bairrinho"));
        enderecos.add(new Endereco(COUNTER.incrementAndGet(),2, "Rua nenhuma, 325", "bairrinho2"));
        enderecos.add(new Endereco(COUNTER.incrementAndGet(), 3,"Rua dos bobos, 125", "bairrinho3"));
        enderecos.add(new Endereco(COUNTER.incrementAndGet(), 1,"Rua do ze ninguem, 155", "bairrinho4"));
    }

    public List<Endereco> listarEnderecos (){
        return enderecos;
    }

    public Endereco encontrarEnderecoPorId (Integer id) throws Exception {
        Endereco endEncontrado = enderecos.stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(()-> new Exception ("Endereço não encontrado."));
        return endEncontrado;
    }

    public Endereco cadastrarEndereco (Endereco endereco, Integer idPessoa){
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        enderecos.add(endereco);
        return endereco;
    }

    public Endereco atualizarEndereco (Integer id, Endereco endereco) throws Exception {
        Endereco endAtualizar = enderecos.stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(()-> new Exception ("Endereço não encontrado."));
        endAtualizar.setBairro(endereco.getBairro());
        endAtualizar.setLogradouro(endereco.getLogradouro());
        return endAtualizar;
    }

    public void deletarEndereco (Integer id) throws Exception {
        Endereco endDeletar = enderecos.stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(()-> new Exception ("Endereço não encontrado."));
        enderecos.remove(endDeletar);
    }

    public List<Endereco> encontrarEnderecoPorPessoa (Integer idPessoa){
        return enderecos.stream()
                .filter(e-> e.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}
