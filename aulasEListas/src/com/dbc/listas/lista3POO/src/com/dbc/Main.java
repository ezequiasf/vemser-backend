package com.dbc.listas.lista3POO.src.com.dbc;

public class Main {

    public static void main(String[] args) {

        //Cliente 1
        Contato[] contatosCliente1 = new Contato[2];
        Contato c1Cliente1 = new Contato("Alguma descricao","87 32723843",1);
        contatosCliente1[0] = c1Cliente1;
        Endereco[] enderecosCliente1 = new Endereco[2];
        Endereco e1Cliente1 = new Endereco(1,"Rua qualquerNome",32,"casa"
                ,"54321-433","Olinda","Pernambuco","Brasil");
        enderecosCliente1[0]=e1Cliente1;
        Cliente cliente1 =
                new Cliente("Marcos","12345678907",contatosCliente1,enderecosCliente1);
        ContaCorrente contaCliente1 = new ContaCorrente(cliente1,"87463458",3456-1,1500.00,250.0);

        //Cliente 2
        Contato[] contatosCliente2 = new Contato[2];
        Contato c1Cliente2 = new Contato("Descricao cliente 2","32 12234323",2);
        contatosCliente2[0] = c1Cliente2;
        Endereco[] enderecosCliente2 = new Endereco[2];
        Endereco e1Cliente2 = new Endereco(1,"Rua outroNomedeRua",109,"apt"
                ,"43567-321","Goiânia","Goiás","Brasil");
        enderecosCliente2[0]=e1Cliente2;
        Cliente cliente2 =
                new Cliente("Alex","12345678907",contatosCliente2,enderecosCliente2);
        ContaCorrente contaCliente2 = new ContaCorrente(cliente2,"32432345",42736-2,350.0,175.00);

        System.out.println("*******Status inicial das contas:*******");
        contaCliente1.imprimirContaCorrente();
        contaCliente2.imprimirContaCorrente();

        boolean sacou;
        System.out.println("\n******Transferência de R$ 300 entre cliente 1 e cliente 2:*******\n");
        // Uma transferência entre eles
        contaCliente1.transferir(contaCliente2,300.00);
        //Conta do cliente 1 tinha 1500.00 e do cliente 2 - 350.0;
        contaCliente1.imprimirContaCorrente();
        contaCliente2.imprimirContaCorrente();
        //Tentativa de transferir com valor negativo
        sacou = contaCliente1.transferir(contaCliente2,-50.0);
        System.out.println("Tentativa de transferir com valor negativo:(false)"+sacou);

        System.out.println("\n*******Saque de R$ 100 e de R$1150:********\n");
        //>>>> Sacar
        sacou = contaCliente1.sacar(100.00);
        System.out.println("Saque normal:(true)"+sacou);
        //Tentatica de sacar mais saldo 1100
        sacou = contaCliente1.sacar(1150);
        System.out.println("Tentativa de sacar mais do que tem no saldo:(true - debita do cheque especial)"+sacou);
        contaCliente1.imprimirContaCorrente();
        //Tentativa de saque negativo
        sacou = contaCliente1.sacar(-20.0);
        System.out.println("Tentativa de saque negativo:(false)"+sacou);

        System.out.println("\n *******Depósito de R$ 230.76 na conta do cliente 1:*******\n");
        //depositar
        contaCliente1.depositar(230.76);
        contaCliente1.imprimirContaCorrente();
        boolean depositou = contaCliente1.depositar(-10.0);
        System.out.println("Tentativa de depósito negativo(false):"+depositou);

        //retornarSaldocomChequeEspecial
        double saldoComCheque = contaCliente1.retornarSaldoComChequeEspecial();
        System.out.println("Saldo com cheque especial cliente 1: R$ "+saldoComCheque);
        System.out.println();

        //Operações da classe Cliente
        cliente1.imprimirCliente();
        cliente1.imprimirContatos();
        cliente1.imprimirEnderecos();

        //Operações da classe Contato
        c1Cliente1.imprimirContato();

        //Operações da class Endereco
        e1Cliente2.imprimirEndereco();
    }
}
