/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoLigacao;
import java.util.ArrayList;
import model.ModelLigacao;

/**
 *
 * @author Nielson Soares
 */
public class ControllerLigacao {
    private DaoLigacao daoLigacao = new DaoLigacao();
    
    public ArrayList<ModelLigacao> retornarListaLigacaoController(){
        return this.daoLigacao.retornarListaLigacaoDAO();
    }
    
    public ModelLigacao retornarLigacaoPorCodController(int codLigacao){
        return this.daoLigacao.retornarLigacaoPorCodDAO(codLigacao);
    }
}
