package com.dbc.modulo_1.listas.lista_5.exercicio_poo;

public class ContaPoupanca extends Conta implements Impressao {

    private final static double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa (){
        setSaldo(JUROS_MENSAL*getSaldo());
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
         return " Poupanca\n"+ super.toString() + "\n Juros = "+JUROS_MENSAL;
    }
}
