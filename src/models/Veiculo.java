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
public class Veiculo {
    
    private int codveic;
    private int codmarca;
    private String modelo;
    private int ano;
    private int km;
    private int qtdeportas;
    private String cor;
    private String placa;

    public int getCodveic() {
        return codveic;
    }

    public void setCodveic(int codveic) {
        this.codveic = codveic;
    }

    public int getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(int codmarca) {
        this.codmarca = codmarca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getQtdeportas() {
        return qtdeportas;
    }

    public void setQtdeportas(int qtdeportas) {
        this.qtdeportas = qtdeportas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
