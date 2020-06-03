/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nielson Soares
 */
public class ModelEntrada {
    private int codEntrada;
    private String descEntrada;

    public int getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(int codEntrada) {
        this.codEntrada = codEntrada;
    }

    public String getDescEntrada() {
        return descEntrada;
    }

    public void setDescEntrada(String descEntrada) {
        this.descEntrada = descEntrada;
    }

    @Override
    public String toString() {
        return descEntrada;
    }
    
    
}
