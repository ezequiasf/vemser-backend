package com.dbccompany.vemser.service;

import com.dbccompany.vemser.entity.Endereco;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository endRepo;

    public Endereco cadastrarEndereco (Endereco endereco, Integer id) throws RegraDeNegocioException {
        return endRepo.cadastrarEndereco(endereco, id);
    }

    public List<Endereco> listarEnderecos (){
        return endRepo.listarEnderecos();
    }

    public Endereco encontrarEnderecoPorId (Integer id) throws RegraDeNegocioException {
        return endRepo.encontrarEnderecoPorId(id);
    }

    public List<Endereco> encontrarEnderecosPorPessoa (Integer idPessoa){
        return endRepo.encontrarEnderecoPorPessoa(idPessoa);
    }

    public Endereco atualizarEndereco (Integer id, Endereco endereco) throws RegraDeNegocioException {
        return endRepo.atualizarEndereco(id,endereco);
    }

    public void deletarEndereco (Integer id) throws RegraDeNegocioException {
        endRepo.deletarEndereco(id);
    }
}
