package com.dbc.listas.lista3POO.src.com.dbc;

public class Cliente {

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = new Contato[2];
        this.enderecos = new Endereco[2];
    }

    public String nome;
    public String cpf;
    public Contato[] contatos;
    public Endereco[] enderecos;

    public void imprimirContatos ()
    {
        for (Contato contato:contatos)
            contato.imprimirContato();
    }

    public void imprimirEnderecos ()
    {
        for (Endereco endereco:enderecos)
            endereco.imprimirEndereco();
    }

    public void imprimirCliente ()
    {
        System.out.printf("Nome:%s%nCpf:%s%n",this.nome, this.cpf);
    }
}
