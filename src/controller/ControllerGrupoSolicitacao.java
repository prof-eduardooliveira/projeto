/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoGrupoSolicitacao;
import java.util.ArrayList;
import model.ModelGrupoSolicitacao;
import model.ModelPerfil;

/**
 *
 * @author edube
 */
public class ControllerGrupoSolicitacao {

    private DaoGrupoSolicitacao daoGrupoSolicitacao = new DaoGrupoSolicitacao();

    public ArrayList<ModelGrupoSolicitacao> getListaGrupoSolicitacaoController() {
        return this.daoGrupoSolicitacao.retornarListaGrupoSolicitacaoDAO();
    }

    public ModelGrupoSolicitacao getGrupoSolicitacaoController(int pCodigo) {
        return this.daoGrupoSolicitacao.retornarGrupoSolicitacaoDAO(pCodigo);
    }

    public ModelGrupoSolicitacao getGrupoSolicitacaoController(String pNome) {
        return this.daoGrupoSolicitacao.retornarGrupoSolicitacaoDAO(pNome);
    }

}
