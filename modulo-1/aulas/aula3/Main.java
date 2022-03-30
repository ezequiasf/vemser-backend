package com.dbc.modulo_1.aulas.aula3;

public class Main {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();

        pessoa1.nome = "Ezequias";
        pessoa1.sobrenome = "Barros";
        pessoa1.idade = 25;
        pessoa1.whatsapp = 9543957;

        pessoa2.nome = "Carlos";
        pessoa2.sobrenome = "Junior";
        pessoa2.idade = 17;
        pessoa2.whatsapp = 63427332;

        pessoa1.conversar(pessoa2);
        pessoa1.ehMaiorDeIdade();
        boolean ehMaior = pessoa2.ehMaiorDeIdade();
        System.out.println("Eh maior:"+ehMaior);
        String nomeCompleto = pessoa1.retornarNomeCompleto();
        System.out.println(nomeCompleto);
        pessoa1.mandarWhatsapp(pessoa2,"Olá mundo.");
    }
}
