package com.dbc.listas.lista_4;

public class Endereco {

    private int tipo;
    private int numero;
    private String logradouro;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais)
    {
        setTipo(tipo);
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void imprimirEndereco()
    {
        if (tipo != 0){
            String tipoNome = (tipo == 1)? "Residencial":"Comercial";
            System.out.printf("Tipo de endereço: %s%n%s," +
                    "%d,%s,%s,%s%nComplemento: %s.%n%n", tipoNome,getLogradouro(),getNumero(),
                    getCidade(),getEstado(), getPais(),getComplemento());
        }else{
            System.out.println("Você ainda não especificou um tipo de endereço.");
        }
    }

}
