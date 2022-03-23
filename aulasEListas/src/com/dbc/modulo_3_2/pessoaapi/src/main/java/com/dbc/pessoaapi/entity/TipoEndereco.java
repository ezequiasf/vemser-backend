package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum TipoEndereco {
    RESIDENCIAL(0),
    COMERCIAL(1);

    private final Integer tipo;

    TipoEndereco(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    @JsonValue
    public static TipoEndereco ofTipo(Integer tipo){
        return Arrays.stream(TipoEndereco.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
