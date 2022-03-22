package com.dbc.pessoaapi.entity;

import java.util.Arrays;

public enum TipoContato {
    RESIDENCIAL(0),
    COMERCIAL(1);

    private final Integer tipo;

    TipoContato(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoContato ofTipo(Integer tipo){
        return Arrays.stream(TipoContato.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
