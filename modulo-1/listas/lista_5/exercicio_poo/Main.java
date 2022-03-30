package com.dbc.modulo_1.listas.lista_5.exercicio_poo;

public class Main {

    public static void main(String[] args) {
        //Criação do cliente 1
        Contato[] contatosCliente1 = new Contato[2];
        Contato c1Cliente1 = new Contato("Alguma descricao","87 32723843",1);
        contatosCliente1[0] = c1Cliente1;

        Endereco[] enderecosCliente1 = new Endereco[2];
        Endereco e1Cliente1 = new Endereco(1,"Rua qualquerNome",32
                ,"casa","54321-433","Olinda","Pernambuco","Brasil");
        enderecosCliente1[0]=e1Cliente1;

        Cliente cliente1 = new Cliente("Marcos","12345678907", contatosCliente1
                , enderecosCliente1);

        //Cliente 2
        Contato[] contatosCliente2 = new Contato[2];
        Contato c1Cliente2 = new Contato("Descricao cliente 2",
                "32 12234323",2);
        contatosCliente2[0] = c1Cliente2;
        Endereco[] enderecosCliente2 = new Endereco[2];
        Endereco e1Cliente2 = new Endereco(1,"Rua outroNomedeRua",109,"apt"
                ,"43567-321","Goiânia","Goiás","Brasil");
        enderecosCliente2[0]=e1Cliente2;
        Cliente cliente2 =
                new Cliente("Alex","12345678907", contatosCliente2, enderecosCliente2);

        //Corrente e pagamento c1
        ContaCorrente contaCorrentec1 = new ContaCorrente(cliente1,
                "87463458","3456-1",1500.00,250.0);
        ContaPagamento contaPagamentoc1 = new ContaPagamento(cliente1,
                "324243","23234-9",1000);
        // Poupanca cliente 2
        ContaPoupanca contaPoupancac2 = new ContaPoupanca(cliente2,
                "834237","7382463",350);

        //Depósito e transferência são as mesmas implementações para Corrente, poupança, pagamento
        System.out.println("============== Saque, depósito e transferência (Conta corrente) ==============");
        contaCorrentec1.imprimir();

        System.out.println("\n <<<<<<< Saque de 1600 >>>>>>>>\n");
        contaCorrentec1.sacar(1600);
        contaCorrentec1.imprimir();

        System.out.println("\n <<<<<<< Depósito de 300 >>>>>>>>\n");
        contaCorrentec1.depositar(300);
        contaCorrentec1.imprimir();

        System.out.println("\n ============ Estado inicial conta poupança =============\n");
        contaPoupancac2.imprimir();

        System.out.println("\n <<<<<<< Transferencia de 100 p/ conta poupança >>>>>>>>\n");
        contaCorrentec1.transferir(contaPoupancac2,100);
        contaCorrentec1.imprimir();
        System.out.println();
        contaPoupancac2.imprimir();

        System.out.println("============== Saque (Conta pagamento) ==============");
        contaPagamentoc1.imprimir();

        System.out.println("\n <<<<<<< Saque de 500 (deve permitir e retirar a taxa) >>>>>>>>\n");
        contaPagamentoc1.sacar(500);
        contaPagamentoc1.imprimir();

        System.out.println("\n <<<<<<< Saque de 495 (Não deve permitir,pois não tem o valor suficiente para a taxa) >>>>>>>>\n");
        contaPagamentoc1.sacar(495);
        contaPagamentoc1.imprimir();

        //Usando a implementação da conta pagamento na chamada do método sacar dentro do transferir.
        System.out.println("\n <<<<<<< Transferencia de pagamento c1 -> poupanca c2 de 200 >>>>>>>>\n");
        contaPagamentoc1.transferir(contaPoupancac2,200);
        contaPagamentoc1.imprimir();
        System.out.println();
        contaPoupancac2.imprimir();
    }
}
