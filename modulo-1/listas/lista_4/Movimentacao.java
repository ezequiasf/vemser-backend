package com.dbc.modulo_1.listas.lista_4;

public interface Movimentacao {

    boolean sacar (double valor);
    boolean depositar (double valor);
    boolean transferir (Conta conta, double valor);
}
