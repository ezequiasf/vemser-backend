package com.dbccompany.vemser.repository;

import com.dbccompany.vemser.entity.Endereco;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class EnderecoRepository2 implements RepositorioGenerico<Endereco, Integer> {

    private List<Endereco> enderecos;
    private final AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository2 (){
        Endereco e = Endereco.builder().idEndereco(COUNTER.incrementAndGet()).tipoEndereco("Residencial")
                .bairro("Bairrinho Novo").cep("54678434").cidade("Jaboatão").estado("Pernambuco")
                .pais("Brasil").numero(54).logradouro("Rua n sei das quantas").build();
        enderecos.add(e);
    }

    @Override
    public Endereco salvar(Endereco end) {
        end.setIdEndereco(COUNTER.incrementAndGet());
        enderecos.add(end);
        return end;
    }

    @Override
    public Endereco atualizar(Endereco endereco, Integer id) throws RegraDeNegocioException {
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

    @Override
    public List<Endereco> lerTodos() {
        return enderecos;
    }

    @Override
    public void deletar(Integer id) throws RegraDeNegocioException {
        enderecos.remove(encontrarEnderecoPorId(id));
    }

    public Endereco encontrarEnderecoPorId (Integer id) throws RegraDeNegocioException {
        return enderecos.stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(()-> new RegraDeNegocioException ("Endereço não encontrado."));
    }

    public List<Endereco> encontrarEnderecoPorPessoa (Integer idPessoa){
        return enderecos.stream()
                .filter(e-> e.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}
