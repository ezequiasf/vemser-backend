package com.dbc.listas.lista_5.exercicio_poo;

public class ContaPagamento extends Conta implements Impressao{

    private final static double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar (double valor){
        if ((valor<=getSaldo()-TAXA_SAQUE)&&(valor>0)){
            System.out.println(" Você sacou: "+valor);
            System.out.println(" Taxa saque: "+TAXA_SAQUE);
            setSaldo(getSaldo() - (valor+TAXA_SAQUE));
            return true;
        }
        return false;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return " Conta pagamento\n"+super.toString();
    }
}
