/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author luis_
 */
public class Cliente {
    
    private int codcliente;
    private int codcid;
    private String nmcliente;
    private String cpfcnpj;
    private String telefone;
    private String endereco;
    private String dtnasc;
    private String uf;

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public int getCodcid() {
        return codcid;
    }

    public void setCodcid(int codcid) {
        this.codcid = codcid;
    }

    public String getNmcliente() {
        return nmcliente;
    }

    public void setNmcliente(String nmcliente) {
        this.nmcliente = nmcliente;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereço) {
        this.endereco = endereço;
    }

    public String getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(String dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
    
    
}
