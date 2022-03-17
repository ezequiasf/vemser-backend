package com.dbccompany.vemser.repository;

import com.dbccompany.vemser.entity.Pessoa2;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PessoaRepository2 implements RepositorioGenerico<Pessoa2, Integer> {

    private final List<Pessoa2> pessoas = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository2 (){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Pessoa2 p = Pessoa2.builder()
                .nome("Carlos sales")
                .cpf("32112344543")
                .nascimento(LocalDate.parse("10/10/2000", formatter))
                .email("exemplo@gmail.com").build();
        pessoas.add(p);
    }

    @Override
    public Pessoa2 salvar(Pessoa2 pessoa) {
        pessoa.setId(COUNTER.incrementAndGet());
        pessoas.add(pessoa);
        return pessoa;
    }

    @Override
    public Pessoa2 atualizar(Pessoa2 p, Integer id) throws RegraDeNegocioException {
//        Pessoa pessoaEncontrada = encontrarPorId(id);
//        pessoaEncontrada.setNome(p.getNome());
//        pessoaEncontrada.setNascimento(p.getNascimento());
//        pessoaEncontrada.setCpf(p.getCpf());
        return null;
    }

    @Override
    public List<Pessoa2> lerTodos() {
        return null;
    }

    @Override
    public void deletar(Integer id) throws RegraDeNegocioException {
//        Pessoa pessoaDelete = encontrarPorId(id);
//        pessoas.remove(pessoaDelete);
    }

//    public Pessoa encontrarPorId (Integer id) throws RegraDeNegocioException {
//        return pessoas.stream()
//                .filter(pessoa-> pessoa.getId().equals(id))
//                .findFirst()
//                .orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada."));
//    }
//
//    public List<Pessoa> listarPorNome (String nome){
//        return pessoas.stream()
//                .filter(p -> p.getNome().equalsIgnoreCase(nome))
//                .collect(Collectors.toList());
//    }
}
