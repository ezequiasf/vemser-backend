package com.dbc.pessoaapi.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TipoGrupo {
    ADMIN(1), CADASTRO(2), MARKETING(3);
    private final Integer idGrupo;
}
