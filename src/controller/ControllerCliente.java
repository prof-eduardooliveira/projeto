/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoCliente;
import java.util.ArrayList;
import model.ModelCliente;

/**
 *
 * @author Eduardo
 */
public class ControllerCliente {
    private DaoCliente daoCliente = new DaoCliente();
    
    /*public ModelCliente retornarClienteController(int pCDC){
        return this.daoCliente.retornarProdutoDAO(pCDC);
    }*/
    
    public ArrayList<ModelCliente> retornarListaClienteController(){
        return this.daoCliente.retornarListaClienteDAO();
    }
    
    public int salvarClientelController(ModelCliente modelCliente){
        return this.daoCliente.salvarClientelDAO(modelCliente);
    }
  
    public boolean excluirClienteController(int codigo){
        return this.daoCliente.excluirClienteDAO(codigo);
    }
    
    public boolean alterarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.alterarClienteDAO(pModelCliente);
    }
    
    public ModelCliente retornarClienteController(int pCodigo){
        return this.daoCliente.retornarClienteDAO(pCodigo);
    }   
    
    public ModelCliente retornarClienteController(String pNomeCliente){
        return this.daoCliente.retornarClienteDAO(pNomeCliente);
    }   
}
