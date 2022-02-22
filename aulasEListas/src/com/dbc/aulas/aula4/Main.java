package com.dbc.aulas.aula4;

public class Main {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Ezequias", "Barros", 25, 82436876);
        Pessoa pessoa2 = new Pessoa("Carlos", "Junior", 20, 36724537);

        pessoa1.conversar(pessoa2);
        pessoa1.ehMaiorDeIdade();
        boolean ehMaior = pessoa2.ehMaiorDeIdade();
        System.out.println("Eh maior:"+ehMaior);
        String nomeCompleto = pessoa1.retornarNomeCompleto();
        System.out.println(nomeCompleto);
        pessoa1.mandarWhatsapp(pessoa2,"Olá mundo.");
    }
}
