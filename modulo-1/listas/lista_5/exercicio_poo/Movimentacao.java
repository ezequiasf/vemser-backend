package com.dbc.modulo_1.listas.lista_5.exercicio_poo;

public interface Movimentacao {
    boolean sacar (double valor);
    boolean depositar (double valor);
    boolean transferir (Conta conta, double valor);
}
