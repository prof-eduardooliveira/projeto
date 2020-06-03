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
public class ModelCidade {
    private int codCidade;
    private String descCidade;
    private ModelEstado estado;
    private int codEstado;

    public int getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }

    public String getDescCidade() {
        return descCidade;
    }

    public void setDescCidade(String descCidade) {
        this.descCidade = descCidade;
    }

    public ModelEstado getEstado() {
        return estado;
    }

    public void setEstado(ModelEstado estado) {
        this.estado = estado;
    }

    public int getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(int codEstado) {
        this.codEstado = codEstado;
    }

    @Override
    public String toString() {
        return descCidade;
    }
    
}
