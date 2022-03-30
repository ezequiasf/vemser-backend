package com.dbc.modulo_1.listas.lista_3;

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
                new Cliente("Marcos","12345678907", contatosCliente1, enderecosCliente1);
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
                new Cliente("Alex","12345678907", contatosCliente2, enderecosCliente2);
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
        //Tentativa de sacar mais saldo 1100
        sacou = contaCliente1.sacar(1600);
        System.out.println("Tentativa de sacar mais do que tem no saldo e cheque especial:(salso)"+sacou);
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

        //Depósito com 0 saldo
        contaCliente1.imprimirContaCorrente();
        //Debita do cheque especial
        contaCliente1.sacar(1500);
        contaCliente1.imprimirContaCorrente();
        //Depósito de 100 (Não vai adicionar ao saldo)
        contaCliente1.depositar(100);
        contaCliente1.imprimirContaCorrente();
        //Adicionar mais 100 para começar a adicionar no saldo
        contaCliente1.depositar(100);
        contaCliente1.imprimirContaCorrente();

        //Testando a nova lógica de transferencia mais uma vez.
        contaCliente1.depositar(100);
        System.out.println("Antes da transferencia");
        contaCliente1.imprimirContaCorrente();
        contaCliente2.imprimirContaCorrente();
        boolean transferiu = contaCliente1.transferir(contaCliente2, 380.76);
        System.out.println("Depois da transferencia");
        contaCliente1.imprimirContaCorrente();
        contaCliente2.imprimirContaCorrente();

        //Deposito cliente 1
        contaCliente1.depositar(260);
        contaCliente1.imprimirContaCorrente();
    }
}
