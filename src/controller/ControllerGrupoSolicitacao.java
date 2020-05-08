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

    public int salvarGrupoSolController(ModelGrupoSolicitacao pmodelGrupoSolicitacao) {
        return this.daoGrupoSolicitacao.salvarGrupoSolDAO(pmodelGrupoSolicitacao);
    }

    public boolean atualizarGrupoSolController(ModelGrupoSolicitacao pmodelGrupoSolicitacao) {
        return this.daoGrupoSolicitacao.alterarGrupoSolDAO(pmodelGrupoSolicitacao);
    }

    public boolean excluirGrupoSolController(int pCodigo) {
        return this.daoGrupoSolicitacao.excluirGrupoSolDAO(pCodigo);
    }

}
