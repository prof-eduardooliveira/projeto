/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoPerfil;
import java.util.ArrayList;
import model.ModelPerfil;

/**
 *
 * @author edube
 */
public class ControllerPerfil {
    private DaoPerfil daoPerfil = new DaoPerfil();
    
    public ModelPerfil getPerfilController(int pCodigo){
        return this.daoPerfil.retornarPerfilDAO(pCodigo);
    }
    
    public ModelPerfil getPerfilController(String pNomeCliente){
        return this.daoPerfil.retornarPerfilDAO(pNomeCliente);
    }
    
    public ArrayList<ModelPerfil> getListaPerfilController(){
        return this.daoPerfil.retornarListaPerfisDAO();
    }
    
    public boolean atualizarPerfilController(ModelPerfil pModelPerfil){
        return this.daoPerfil.alterarPerfilDAO(pModelPerfil);
    }
     
    public int salvarPerfilController(ModelPerfil pModelPerfil){
        return this.daoPerfil.salvarPerfilDAO(pModelPerfil);
    }
    
    public boolean excluirPerfilController(int pCodigo){
        return this.daoPerfil.excluirPerfilDAO(pCodigo);
    }
}
