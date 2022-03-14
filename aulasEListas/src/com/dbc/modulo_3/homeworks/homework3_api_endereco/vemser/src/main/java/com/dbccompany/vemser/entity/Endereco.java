package com.dbccompany.vemser.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;
    @NotNull
    private String tipoEndereco;
    @NotEmpty
    @Size(max = 250)
    private String logradouro;
    @NotNull
    private Integer numero;
    @NotNull
    @NotEmpty
    @Size( max = 8)
    private String cep;
    private String bairro;
    @NotNull
    @NotEmpty
    @Size( max = 250)
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;


    public Endereco (){}

    public Endereco(Integer idEndereco, Integer idPessoa, String tipoEndereco, String logradouro, Integer numero, String cep, String cidade, String estado, String pais, String bairro) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
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

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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
