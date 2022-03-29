package com.dbccompany.vemser.service;

import com.dbccompany.vemser.entity.Pessoa;
import com.dbccompany.vemser.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepo;

    private boolean validacaoPessoa (Pessoa pessoa){
        boolean condicaoNome = StringUtils.isBlank(pessoa.getNome());
        boolean condicaoData = ObjectUtils.isEmpty(pessoa.getNascimento());
        boolean condicaoCpf = StringUtils.isBlank(pessoa.getCpf());
        return condicaoNome || condicaoData || condicaoCpf;
    }

    public Pessoa cadastrarPessoa (Pessoa pessoa){
        try{
            if (validacaoPessoa(pessoa)){
                throw new Exception ("Erro no cadastro!\nVerifique os campos:\nnome, cpf e data: Não podem estar vazios.");
            }
            return pessoaRepo.cadastrarPessoa(pessoa);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<Pessoa> listarPessoas (){
        return pessoaRepo.listarPessoas();
    }

    public Pessoa atualizarPessoa (Integer id, Pessoa pessoa){
        Pessoa p = null;
        try{
            if (validacaoPessoa(pessoa)){
                throw new Exception ("Erro na atualização!\nVerifique os campos:\nnome, cpf e data: Não podem estar vazios.");
            }
            p = pessoaRepo.atualizarPessoa(id, pessoa);
        }catch (Exception e){
            System.err.println(e.getMessage());
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
