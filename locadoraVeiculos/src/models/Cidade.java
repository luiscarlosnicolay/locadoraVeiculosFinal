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
public class Cidade {
    
    private int codcid;
    private String nmcidade;
    private String cep;
    private String uf;

    public int getCodcid() {
        return codcid;
    }

    public void setCodcid(int codcid) {
        this.codcid = codcid;
    }

    public String getNmcidade() {
        return nmcidade;
    }

    public void setNmcidade(String nmcidade) {
        this.nmcidade = nmcidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
    
}
