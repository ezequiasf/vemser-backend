package com.dbc.modulo_1.aulas.aula3;

public class Pessoa {

    String nome;
    String sobrenome;
    int idade;
    int whatsapp;

    public void conversar (Pessoa pessoa){
        System.out.println(this+" Conversou com:"+ pessoa);
    }

    public String retornarNomeCompleto (){
        return nome +" "+sobrenome;
    }

    public boolean ehMaiorDeIdade (){
        return idade > 18;
    }

    public void mandarWhatsapp(Pessoa pessoa, String mensagem){
        System.out.println(this.nome +" enviou "+ mensagem +"para:"+pessoa.nome);
    }

    @Override
    public String toString (){
        return nome;
    }
}
