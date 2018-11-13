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
public class Aluguel {
    
    private int codaluguel;
    private int codveic;
    private int codcliente;
    private int codtppagamento;
    private String login;
    private int kminicio;
    private int kmfim;
    private String dtinicio;
    private String dtfim;
    private double vldiaria;
    private double vlkmadicional;
    private double vltotal;

    public int getCodaluguel() {
        return codaluguel;
    }

    public void setCodaluguel(int codaluguel) {
        this.codaluguel = codaluguel;
    }

    public int getCodveic() {
        return codveic;
    }

    public void setCodveic(int codveic) {
        this.codveic = codveic;
    }

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }
    
    

    public int getCodtppagamento() {
        return codtppagamento;
    }

    public void setCodtppagamento(int codtppagamento) {
        this.codtppagamento = codtppagamento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getKminicio() {
        return kminicio;
    }

    public void setKminicio(int kminicio) {
        this.kminicio = kminicio;
    }

    public int getKmfim() {
        return kmfim;
    }

    public void setKmfim(int kmfim) {
        this.kmfim = kmfim;
    }

    public String getDtinicio() {
        return dtinicio;
    }

    public void setDtinicio(String dtinicio) {
        this.dtinicio = dtinicio;
    }

    public String getDtfim() {
        return dtfim;
    }

    public void setDtfim(String dtfim) {
        this.dtfim = dtfim;
    }

    public double getVldiaria() {
        return vldiaria;
    }

    public void setVldiaria(double vldiaria) {
        this.vldiaria = vldiaria;
    }

    public double getVlkmadicional() {
        return vlkmadicional;
    }

    public void setVlkmadicional(double vlkmadicional) {
        this.vlkmadicional = vlkmadicional;
    }

    public double getVltotal() {
        return vltotal;
    }

    public void setVltotal(double vltotal) {
        this.vltotal = vltotal;
    }
    
    
    
}
