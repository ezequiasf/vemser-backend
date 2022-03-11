package com.dbccompany.vemser.service;

import com.dbccompany.vemser.entity.Pessoa;
import com.dbccompany.vemser.repository.PessoaRepository;

import java.util.List;

public class PessoaService {

    private final PessoaRepository pessoaRepo;

    public PessoaService (){
        pessoaRepo = new PessoaRepository();
    }

    public Pessoa cadastrarPessoa (Pessoa pessoa){
        return pessoaRepo.cadastrarPessoa(pessoa);
    }

    public List<Pessoa> listarPessoas (){
        return pessoaRepo.listarPessoas();
    }

    public Pessoa atualizarPessoa (Integer id, Pessoa pessoa){
        Pessoa p = null;
        try {
            p = pessoaRepo.atualizarPessoa(id, pessoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public void deletarPessoa (Integer id){
        try {
            pessoaRepo.deletarPessoa(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pessoa> encontrarPorNome (String nome){
        return pessoaRepo.listarPorNome(nome);
    }
}
