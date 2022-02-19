package com.dbc.listas.lista3POO.src.com.dbc;

public class Endereco {

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais)
    {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public int tipo;
    public int numero;
    public String logradouro;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public void imprimirEndereco()
    {
        String tipoNome = (tipo==1)? "Residencial":"Comercial";
        System.out.printf("Tipo:%s%n%s," +
                "%d,%s,%s,%s", tipoNome,logradouro,numero, cidade,estado,pais);
    }

}
