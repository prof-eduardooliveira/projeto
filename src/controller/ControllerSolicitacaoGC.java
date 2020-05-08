/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoSolicitacaoGC;
import java.util.ArrayList;
import model.ModelSolicitacaoGC;

/**
 *
 * @author edube
 */
public class ControllerSolicitacaoGC {

    private DaoSolicitacaoGC daoSolicitacaoGC = new DaoSolicitacaoGC();

    public int salvarSolicitacaoGCController(ModelSolicitacaoGC pModelSolicitacaoGC) {
        return this.daoSolicitacaoGC.salvarSolicitacaoGCDAO(pModelSolicitacaoGC);
    }

    public ArrayList<ModelSolicitacaoGC> retornarListaClienteController() {
        return this.daoSolicitacaoGC.retornarListaSolicitacaoGCDAO();
    }
    
    public ModelSolicitacaoGC retQuantSolicUsua(String pNomeUsuario) {
        return this.daoSolicitacaoGC.retQuantSolicUsua(pNomeUsuario);
    }

}
