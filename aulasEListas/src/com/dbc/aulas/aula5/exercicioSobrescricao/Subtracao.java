package com.dbc.aulas.aula5.exercicioSobrescricao;

public class Subtracao implements OperacaoMatematica{
    @Override
    public int calcula(int a, int b) {
        return a-b;
    }
}
