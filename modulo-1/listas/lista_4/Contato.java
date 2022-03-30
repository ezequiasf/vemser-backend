package com.dbc.modulo_1.listas.lista_4;

public class Contato {

    private String descricao;
    private String telefone;
    private int tipo;

    public Contato(String descricao, String telefone, int tipo)
    {
        this.descricao = descricao;
        this.telefone = telefone;
        setTipo(tipo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        if (tipo ==0){
            System.out.println("Você ainda não inicializou a variável tipo.");
        }
        return tipo;
    }

    public void setTipo(int tipo) {
        if ((tipo==1)||(tipo==2)){
            this.tipo = tipo;
        }else{
            System.out.println("Tipo inválido. Você só pode setar 1 ou 2.");
        }
    }

    public void imprimirContato ()
    {
        if (tipo != 0){
            String tipoNome = (tipo == 1)? "Residencial":"Comercial";
            System.out.printf("Descrição: %s%n" +
                    "Telefone: %s%nTipo de contato: %s%n%n", getDescricao()
                    ,getTelefone(), tipoNome);
        }else{
            System.out.println("Você ainda não especificou um tipo de contato.");
        }
    }
}
