package com.dbccompany.vemser.service;

import com.dbccompany.vemser.entity.Pessoa;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
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
        return pessoaRepo.cadastrarPessoa(pessoa);
    }

    public List<Pessoa> listarPessoas (){
        return pessoaRepo.listarPessoas();
    }

    public Pessoa atualizarPessoa (Integer id, Pessoa pessoa) throws Exception {
        return pessoaRepo.atualizarPessoa(id, pessoa);
    }

    public void deletarPessoa (Integer id) throws RegraDeNegocioException {
        pessoaRepo.deletarPessoa(id);
    }

    public List<Pessoa> encontrarPorNome (String nome){
        return pessoaRepo.listarPorNome(nome);
    }
}
