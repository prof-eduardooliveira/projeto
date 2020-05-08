/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoSituacao;
import java.util.ArrayList;
import model.ModelGrupoSolicitacao;
import model.ModelServico;
import model.ModelSituacao;

/**
 *
 * @author edube
 */
public class ControllerSituacao {

    private DAO.DaoSituacao daoSituacao = new DaoSituacao();

    public ModelSituacao getSituacaoController(int pCodigo) {
        return this.daoSituacao.retornarSituacaoDAO(pCodigo);
    }

    public ModelSituacao getSituacaoController(String pNome) {
        return this.daoSituacao.retornarSituacaoDAO(pNome);
    }

    public ArrayList<ModelSituacao> getListaSituacaoController() {
        return this.daoSituacao.retornarListaSituacaoDAO();
    }
}
