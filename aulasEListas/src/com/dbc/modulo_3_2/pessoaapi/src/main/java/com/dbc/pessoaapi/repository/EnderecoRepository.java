package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query("select ep from Endereco_Pessoa ep where ep.pais=:pais")
    List<EnderecoEntity> findEnderecosPorPais (String pais);

    @Query("select ep from Endereco_Pessoa ep join fetch ep.pessoas p " +
            "where p.idPessoa = :idPessoa")
    List<EnderecoEntity> findEnderecoByIdPessoa (Integer idPessoa);

}
