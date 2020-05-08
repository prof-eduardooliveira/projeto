/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoServico;
import java.util.ArrayList;
import model.ModelPerfil;
import model.ModelServico;

/**
 *
 * @author edube
 */
public class ControllerServico {

    private DaoServico daoServico = new DaoServico();

    public ModelServico getServicoController(int pCodigo) {
        return this.daoServico.retornarServicoDAO(pCodigo);
    }
    
    public ModelServico getServicoController(String pServico) {
        return this.daoServico.retornarServicoDAO(pServico);
    }

    public ArrayList<ModelServico> getListaServicoController() {
        return this.daoServico.retornarListaServicoDAO();
    }

    public boolean atualizarServicoController(ModelServico pModelServico) {
        return this.daoServico.alterarServicoDAO(pModelServico);
    }

    public int salvarServicoController(ModelServico pModelServico) {
        return this.daoServico.salvarServicolDAO(pModelServico);
    }

    public boolean excluirServicoController(int pCodigo) {
        return this.daoServico.excluirServicoDAO(pCodigo);
    }

}
