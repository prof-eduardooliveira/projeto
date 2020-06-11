/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoLigacoesProvisorias;
import model.ModelLigacoesProvisorias;

/**
 *
 * @author Nielson Soares
 */
public class ControllerLigacoesProvisorias {
    private DaoLigacoesProvisorias dlp = new DaoLigacoesProvisorias();
    
    public int salvarLigacaoProvisoriaController(ModelLigacoesProvisorias mlp){
        return this.dlp.salvarLigacaoProvisoriaDAO(mlp);
    }
}
