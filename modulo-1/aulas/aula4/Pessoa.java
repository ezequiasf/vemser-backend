package com.dbc.modulo_1.aulas.aula4;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private int whatsapp;

    public Pessoa (){}

    public Pessoa (String nome, String sobrenome, int idade, int whatsapp){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.whatsapp = whatsapp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(int whatsapp) {
        this.whatsapp = whatsapp;
    }

    public void conversar (Pessoa pessoa){
        System.out.println(this+" Conversou com:"+ pessoa);
    }

    public String retornarNomeCompleto (){
        return this.getNome() +" "+ this.getSobrenome();
    }

    public boolean ehMaiorDeIdade (){
        return this.getIdade() > 18;
    }

    public void mandarWhatsapp(Pessoa pessoa, String mensagem){
        System.out.println(this.getNome() +" enviou "+ mensagem +" para: "+pessoa.getNome());
    }

    @Override
    public String toString (){
        return this.getNome();
    }
}
