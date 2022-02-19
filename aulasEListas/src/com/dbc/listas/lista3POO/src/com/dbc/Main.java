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
                new Cliente("Marcos","12345678907",contatosCliente2,enderecosCliente2);
        ContaCorrente contaCliente2 = new ContaCorrente(cliente2,"32432345",42736-2,350.0,175.00);

        // Uma transferência entre eles
        contaCliente1.transferir(contaCliente2,300.00);
        //Conta do cliente 1 tinha 1500.00 e do cliente 2 350.0;
        contaCliente1.imprimirContaCorrente();
        contaCliente2.imprimirContaCorrente();

        //>>>> Sacar
        boolean sacou = contaCliente1.sacar(100.00);
        System.out.println(sacou);
        //Tentatica de sacar mais saldo 1100
        sacou = contaCliente1.sacar(1150);
        System.out.println(sacou);
        contaCliente1.imprimirContaCorrente();

        //depositar
        contaCliente1.depositar(230.76);
        contaCliente1.imprimirContaCorrente();
        boolean depositou = contaCliente1.depositar(-10.0);
        System.out.println(depositou);

        //retornarSaldocomChequeEspecial
        double saldoComCheque = contaCliente1.retornarSaldoComChequeEspecial();
        System.out.println(saldoComCheque);
    }
}
