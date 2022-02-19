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
        System.out.printf("%nCliente: %s | Número da conta: %s | Agência: %d%nSaldo: R$ %.3f | Cheque Especial: R$ %.3f%n" +
                "", this.cliente.nome,this.numeroConta,this.agencia,this.saldo,this.chequeEspecial);
    }
    public boolean sacar (double valor)
    {
        if (valor <= (this.saldo+this.chequeEspecial))
        {
            double diferenca = this.saldo-valor;
            if (diferenca > 0){
                this.saldo -=valor;
            }else{
                if (valor>chequeEspecial) {
                    return false;
                }
                this.chequeEspecial -=valor;
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
        if (valor>saldo){
            return false;
        }
        saldo -=valor;
        contaCorrente.saldo +=valor;
        return true;
    }

}
