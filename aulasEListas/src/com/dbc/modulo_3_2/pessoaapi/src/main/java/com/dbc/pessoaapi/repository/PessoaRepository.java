package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);
    PessoaEntity findByCpf (String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataInicio, LocalDate dataFim);

    @Query("select p from PESSOA p where p.dataNascimento >= :data1 and p.dataNascimento <= :data2 ")
    List<PessoaEntity> findByBetweenDatas (LocalDate data1, LocalDate data2);

    @Query("select p from PESSOA p join fetch p.enderecos pe where p.enderecos.size>0")
    List<PessoaEntity> findPessoasComEndereco ();

    @Query(value = "SELECT * FROM PESSOA P " +
            "LEFT JOIN PESSOA_X_PESSOA_ENDERECO PE ON " +
            "P.ID_PESSOA = PE.ID_PESSOA " +
            "WHERE PE.ID_PESSOA IS NULL ", nativeQuery = true)
    List<PessoaEntity> findPessoasSemEndereco ();
}
