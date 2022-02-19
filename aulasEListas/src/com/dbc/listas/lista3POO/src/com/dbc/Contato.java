package com.dbc.listas.lista3POO.src.com.dbc;

public class Contato {

    public Contato(String descricao, String telefone, int tipo)
    {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public String descricao;
    public String telefone;
    public int tipo;

    public void imprimirContato ()
    {
        String tipoNome = (tipo==1)? "Residencial":"Comercial";
        System.out.printf("Descrição:%s%n" +
                "Telefone:%s%nTipo:%s%n", this.descricao,this.telefone, this.tipo);
    }
}
