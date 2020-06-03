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
public class ModelAgrupamento {
    private int codAgrupamento;
    private String descAgrupamento;

    public int getCodAgrupamento() {
        return codAgrupamento;
    }

    public void setCodAgrupamento(int codAgrupamento) {
        this.codAgrupamento = codAgrupamento;
    }

    public String getDescAgrupamento() {
        return descAgrupamento;
    }

    public void setDescAgrupamento(String descAgrupamento) {
        this.descAgrupamento = descAgrupamento;
    }

    @Override
    public String toString() {
        return descAgrupamento;
    }
}
