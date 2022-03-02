package com.dbc.listas.lista_4;

public class ContaPoupanca extends Conta implements Impressao{

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
        return super.toString() + "ContaPoupanca{ Juros = "+JUROS_MENSAL+"}";
    }
}
