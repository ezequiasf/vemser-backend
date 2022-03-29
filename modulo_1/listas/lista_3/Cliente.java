package com.dbc.modulo_1.listas.lista_3;

public class Cliente {

    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos)
    {
        this.nome = nome;
        this.cpf = cpf;
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

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        if (!(contatos.length>2)){
            this.contatos = contatos;
        }else{
            System.out.println("O Array contatos deve conter no máximo 2 contatos.");
        }
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        if (!(enderecos.length>2)){
            this.enderecos = enderecos;
        }else{
            System.out.println("O Array endereços deve conter no máximo 2 endereços.");
        }
    }

    public void imprimirContatos ()
    {
        for (Contato contato : contatos) {
            if (contato != null) {
                contato.imprimirContato();
            }
        }
    }

    public void imprimirEnderecos ()
    {
        for (Endereco endereco : enderecos) {
            if (endereco != null) {
                endereco.imprimirEndereco();
            }
        }
    }

    public void imprimirCliente ()
    {
        System.out.printf("Nome: %s%nCpf: %s%n%n",getNome(),
                getCpf());
    }
}
