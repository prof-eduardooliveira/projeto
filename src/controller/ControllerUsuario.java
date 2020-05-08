/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoUsuario;
import java.util.ArrayList;
import model.ModelUsuario;

/**
 *
 * @author Lara Guedes
 */
public class ControllerUsuario {

    private DaoUsuario daoUsuario = new DaoUsuario();

    public ModelUsuario getUsuarioController(int pCodigo) {
        return this.daoUsuario.retornarUsuarioDAO(pCodigo);
    }

    public ModelUsuario getUsuarioController(String pNome) {
        return this.daoUsuario.retornarUsuarioDAO(pNome);
    }

    public ArrayList<ModelUsuario> getListaUsuarioController() {
        return this.daoUsuario.retornarListaUsuarioDAO();
    }

    public ArrayList<ModelUsuario> getListaUsuarioNomeController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.retornarListaUsuarioPesquisaNomeDAO(pModelUsuario);
    }

    public ArrayList<ModelUsuario> getListaUsuarioPerfilController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.retornarListaUsuarioPesquisaPerfilDAO(pModelUsuario);
    }

    public boolean atualizarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.alterarUsuarioDAO(pModelUsuario);
    }

    public int salvarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.salvarUsuarioDAO(pModelUsuario);
    }

    public boolean excluirUsuarioController(int pCodigo) {
        return this.daoUsuario.excluirUsuarioDAO(pCodigo);
    }

    public boolean validarUsuario(ModelUsuario modelUsuario) {
        return this.daoUsuario.validarUsuarioDAO(modelUsuario);
    }
}
