package com.dbccompany.vemser.entity;

public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;
    private String logradouro;
    private String bairro;

    public Endereco (){}

    public Endereco(Integer idEndereco, Integer idPessoa, String logradouro, String bairro) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.logradouro = logradouro;
        this.bairro = bairro;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
