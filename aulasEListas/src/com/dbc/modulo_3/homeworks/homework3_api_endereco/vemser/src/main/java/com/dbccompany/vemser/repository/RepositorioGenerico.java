package com.dbccompany.vemser.repository;

import com.dbccompany.vemser.exceptions.RegraDeNegocioException;

import java.util.List;

public interface RepositorioGenerico<T,L>{
    T salvar (T generico);
    T atualizar (T generico,L id) throws RegraDeNegocioException;
    List<T> lerTodos ();
    void deletar (L id) throws RegraDeNegocioException;
}
