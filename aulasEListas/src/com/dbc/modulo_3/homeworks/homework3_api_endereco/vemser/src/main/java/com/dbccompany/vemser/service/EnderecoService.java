package com.dbccompany.vemser.service;

import com.dbccompany.vemser.entity.Endereco;
import com.dbccompany.vemser.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository endRepo;

    public Endereco cadastrarEndereco (Endereco endereco, Integer id) {
        return endRepo.cadastrarEndereco(endereco, id);
    }

    public List<Endereco> listarEnderecos (){
        return endRepo.listarEnderecos();
    }

    public Endereco encontrarEnderecoPorId (Integer id){
        try {
            return endRepo.encontrarEnderecoPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Endereco> encontrarEnderecosPorPessoa (Integer idPessoa){
        return endRepo.encontrarEnderecoPorPessoa(idPessoa);
    }

    public Endereco atualizarEndereco (Integer id, Endereco endereco){
        try {
            return endRepo.atualizarEndereco(id,endereco);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deletarEndereco (Integer id){
        try {
            endRepo.deletarEndereco(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
