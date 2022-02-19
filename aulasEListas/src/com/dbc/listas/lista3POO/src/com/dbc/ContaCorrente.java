package com.dbc.listas.lista3POO.src.com.dbc;

public class ContaCorrente {

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial)
    {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    public void imprimirContaCorrente ()
    {
        System.out.printf("%nCliente: %s | Número da conta: %s | Agência: %d%nSaldo: R$ %.2f | Cheque Especial: R$ %.2f%n" +
                "", this.cliente.nome,this.numeroConta,this.agencia,this.saldo,this.chequeEspecial);
    }
    public boolean sacar (double valor)
    {
        double valorEmConta = this.saldo+this.chequeEspecial;
        if ((valor <= valorEmConta)&&(valor>0))
        {
            double diferencaSaldoValor = this.saldo-valor;
            if (diferencaSaldoValor >= 0){
                this.saldo -= valor;
            }else{
                if (!(diferencaSaldoValor <= chequeEspecial)) {
                    return false;
                }
                this.saldo = 0;
                this.chequeEspecial-= Math.abs(diferencaSaldoValor);
            }
            return true;
        }
        return false;
    }

    public boolean depositar (double valor)
    {
        if (valor<=0){
            return false;
        }
        this.saldo +=valor;
        return true;
    }

    public double retornarSaldoComChequeEspecial ()
    {
        return this.saldo+this.chequeEspecial;
    }

    public boolean transferir (ContaCorrente contaCorrente, double valor)
    {
        double valorEmConta = this.saldo+this.chequeEspecial;
        if ((valor <= valorEmConta)&&(valor>0))
        {
            double diferencaSaldoValor = this.saldo-valor;
            if (diferencaSaldoValor >= 0){
                this.saldo -= valor;
            }else{
                if (!(diferencaSaldoValor <= chequeEspecial)) {
                    return false;
                }
                this.saldo = 0;
                this.chequeEspecial-= Math.abs(diferencaSaldoValor);
            }
            contaCorrente.saldo += valor;
            return true;
        }
        return false;
    }

}
