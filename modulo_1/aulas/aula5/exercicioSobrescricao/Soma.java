package com.dbc.modulo_1.aulas.aula5.exercicioSobrescricao;

public class Soma implements OperacaoMatematica {

    @Override
    public int calcula(int a, int b) {
        return a+b;
    }
}
