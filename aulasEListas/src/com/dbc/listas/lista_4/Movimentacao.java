package com.dbc.listas.lista_4;

public interface Movimentacao {

    boolean sacar (double valor);
    boolean depositar (double valor);
    boolean transferir (Conta conta, double valor);
}
