package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.GrupoEntity;
import com.dbc.pessoaapi.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GrupoService {
    private final GrupoRepository grupoRepository;

    public Optional<GrupoEntity> findGrupoById (Integer idGrupo){
        return grupoRepository.findById(idGrupo);
    }
}
