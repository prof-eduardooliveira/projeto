/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoLigacaoProvisoria;
import java.util.ArrayList;
import model.ModelLigacaoProvisoria;


/**
 *
 * @author Nielson Soares
 */
public class ControllerLigacoesProvisorias {
    private DaoLigacaoProvisoria dlp = new DaoLigacaoProvisoria();
    
    public int salvarLigacaoProvisoriaController(ModelLigacaoProvisoria mlp){
        return this.dlp.salvarLigacaoProvisoriaDAO(mlp);
    }
    
    public ArrayList listarLigacoesProvisoriasController(){
        return this.dlp.retornarListaLigacoesProvisoriasDAO();
    }
    
    public boolean alterarLigacaoProvisoriaController(ModelLigacaoProvisoria mlp){
        return this.dlp.alterarLigacaoProvisoriaDAO(mlp);
    }
    
    public boolean removerLigacaoProvisoriaController(int codSolicitacao){
        return this.dlp.removerLigacaoProvisoriaDAO(codSolicitacao);
    }
}
