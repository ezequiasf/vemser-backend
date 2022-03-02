package com.dbc.listas.lista_5.exercicio_poo;

public class ContaCorrente extends Conta implements Impressao {

    private double chequeEspecial;
    private final double chequeEspecialReferencia;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
        chequeEspecialReferencia = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial (){
        return getSaldo()+chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public boolean sacar (double valor){
        double valorEmConta = getSaldo() + chequeEspecial;
        if ((valor <= valorEmConta)&&(valor>0))
        {
            double diferencaSaldoValor = getSaldo()-valor;
            if (diferencaSaldoValor >= 0){
                setSaldo(getSaldo()-valor);
            }else{
                if (!(diferencaSaldoValor <= chequeEspecial)) {
                    return false;
                }
                setSaldo(0);
                chequeEspecial-= Math.abs(diferencaSaldoValor);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar (double valor){
        if (valor<=0){
            return false;
        }

        if (chequeEspecial < chequeEspecialReferencia){
            chequeEspecial += valor;
            if (chequeEspecial> chequeEspecialReferencia){
                setSaldo(getSaldo()+(chequeEspecial-chequeEspecialReferencia));
                chequeEspecial = chequeEspecialReferencia;
            }
        }else{
            setSaldo(getSaldo()+valor);
        }
        return true;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return " Corrente\n"+" Cheque Especial= " + chequeEspecial +
                "\n" + super.toString();
    }
}
