package com.dbccompany.vemser.repository;

import com.dbccompany.vemser.entity.Pessoa;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PessoaRepository {

    private final List<Pessoa> pessoas = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository (){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        pessoas.add(new Pessoa(COUNTER.incrementAndGet(),"Marcos", LocalDate.parse("10/10/2000", formatter),"12343456556"));
//        pessoas.add(new Pessoa(COUNTER.incrementAndGet(),"Claudia", LocalDate.parse("01/02/2005", formatter),"1212312316556"));
//        pessoas.add(new Pessoa(COUNTER.incrementAndGet(),"Joao", LocalDate.parse("02/03/1997", formatter),"1234332326"));
//        pessoas.add(new Pessoa(COUNTER.incrementAndGet(),"Jose", LocalDate.parse("11/03/2001", formatter),"123434423456"));
    }

    public Pessoa cadastrarPessoa (Pessoa pessoa){
        pessoa.setId(COUNTER.incrementAndGet());
        pessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> listarPessoas (){
        return pessoas;
    }

    public Pessoa atualizarPessoa (Integer id, Pessoa p) throws RegraDeNegocioException {
        Pessoa pessoaEncontrada = encontrarPorId(id);
        pessoaEncontrada.setNome(p.getNome());
        pessoaEncontrada.setNascimento(p.getNascimento());
        pessoaEncontrada.setCpf(p.getCpf());
        return pessoaEncontrada;
    }

    public Pessoa deletarPessoa (Integer id) throws RegraDeNegocioException {
      Pessoa pessoaDelete = encontrarPorId(id);
      pessoas.remove(pessoaDelete);
      return pessoaDelete;
    }

    public List<Pessoa> listarPorNome (String nome){
        return pessoas.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    private Pessoa encontrarPorId (Integer id) throws RegraDeNegocioException {
        return pessoas.stream()
                .filter(pessoa-> pessoa.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada."));
    }

}
