package com.dbc.listas.lista_3;

public class ContaCorrente {

    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;
    private double chequeEspecial;
    private double chequeEspecialReferencia;

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial)
    {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
        this.chequeEspecialReferencia = chequeEspecial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente ()
    {
        System.out.printf("%nCliente: %s | Número da conta: %s | Agência: %d%nSaldo: R$ %.2f | Cheque Especial: R$ %.2f%n" +
                "", getCliente().getNome(),getNumeroConta(),
                getAgencia(),getSaldo(),getChequeEspecial());
    }
    public boolean sacar (double valor)
    {
        double valorEmConta = saldo+chequeEspecial;
        if ((valor <= valorEmConta)&&(valor>0))
        {
            double diferencaSaldoValor = saldo-valor;
            if (diferencaSaldoValor >= 0){
                saldo -= valor;
            }else{
                if (!(diferencaSaldoValor <= chequeEspecial)) {
                    return false;
                }
                saldo = 0;
                chequeEspecial-= Math.abs(diferencaSaldoValor);
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

        if (chequeEspecial < chequeEspecialReferencia){
            chequeEspecial += valor;
            if (chequeEspecial> chequeEspecialReferencia){
                saldo += (chequeEspecial-chequeEspecialReferencia);
                chequeEspecial = chequeEspecialReferencia;
            }
        }else{
            saldo +=valor;
        }
        return true;
    }

    public double retornarSaldoComChequeEspecial ()
    {
        return getSaldo()+getChequeEspecial();
    }

    public boolean transferir (ContaCorrente contaCorrente, double valor)
    {
        if (sacar(valor)){
            contaCorrente.depositar(valor);
            return true;
        }
        return false;
    }

}
