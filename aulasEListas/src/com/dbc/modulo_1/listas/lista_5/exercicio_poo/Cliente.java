package com.dbc.listas.lista_5.exercicio_poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private final List<Contato> contatos;
    private final List<Endereco> enderecos;

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = new ArrayList<>();
        this.enderecos = new ArrayList<>();

        this.setContatos(contatos);
        this.setEnderecos(enderecos);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(Contato... contatos) {
        this.contatos.addAll(Arrays.asList(contatos));
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco... enderecos) {
        this.enderecos.addAll(Arrays.asList(enderecos));
    }

    public void imprimirContatos ()
    {
        for (Contato contato : contatos) {
            contato.imprimirContato();
        }
    }

    public void imprimirEnderecos ()
    {
        for (Endereco endereco : enderecos) {
            endereco.imprimirEndereco();
        }
    }

    public void imprimirCliente ()
    {
        System.out.printf("Nome: %s%nCpf: %s%n%n",getNome(),
                getCpf());
    }
}
