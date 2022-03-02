package com.dbc.modulo_1.listas.lista_4;

public class Main {

    public static void main(String[] args) {

        Contato[] contatosCliente1 = new Contato[2];
        Contato  c1Cliente1 = new Contato("Alguma descricao","87 32723843",1);
        contatosCliente1[0] = c1Cliente1;

        Endereco[] enderecosCliente1 = new Endereco[2];
        Endereco e1Cliente1 = new Endereco(1,"Rua qualquerNome",32,"casa","54321-433","Olinda","Pernambuco","Brasil");
        enderecosCliente1[0]=e1Cliente1;

        Cliente cliente1 = new Cliente("Marcos","12345678907", contatosCliente1, enderecosCliente1);

        ContaCorrente contaCliente1 = new ContaCorrente(cliente1,"87463458","3456-1",1500.00,250.0);
        ContaPoupanca contaPoup1 = new ContaPoupanca(cliente1,"834237","7382463",350);
        //Operações de contato
     //   c1Cliente1.imprimirContato();

        //Operações de endereço
       // e1Cliente1.imprimirEndereco();

        //Operações de cliente
       // cliente1.imprimirCliente();
       // cliente1.imprimirContatos();
        //cliente1.imprimirEnderecos();

        //Operações de conta
        contaCliente1.imprimir();
        double total = contaCliente1.retornarSaldoComChequeEspecial();
        System.out.println(total);
        //Tentando sacar mais do que tem
        contaCliente1.sacar(1800);
        contaCliente1.imprimir();

        //Saque com saldo
        contaCliente1.sacar(700);
        contaCliente1.imprimir();

        //Saque pegando do cheque especial
        contaCliente1.sacar(900);
        contaCliente1.imprimir();

        //Método conta poupança
        contaPoup1.imprimir();

        //Creditando taxa
        contaPoup1.creditarTaxa();
        contaPoup1.imprimir();

        //Depositando
        contaCliente1.imprimir();
        contaCliente1.depositar(1000);
        contaCliente1.imprimir();
    }
}
