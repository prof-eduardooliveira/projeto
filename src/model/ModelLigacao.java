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
public class ModelLigacao {
    private int codLigacao;
    private String descligacao;

    public int getCodLigacao() {
        return codLigacao;
    }

    public void setCodLigacao(int codLigacao) {
        this.codLigacao = codLigacao;
    }

    public String getDescligacao() {
        return descligacao;
    }

    public void setDescligacao(String descligacao) {
        this.descligacao = descligacao;
    }

    @Override
    public String toString() {
        return descligacao;
    }
}
