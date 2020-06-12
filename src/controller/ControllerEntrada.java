/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoEntrada;
import java.util.ArrayList;
import model.ModelEntrada;

/**
 *
 * @author Nielson Soares
 */
public class ControllerEntrada {
    private DaoEntrada daoEntrada = new DaoEntrada();
    
    public ArrayList<ModelEntrada> retornarListaEntradaController(){
       return this.daoEntrada.retornarListaEntradaDAO();
    }
    
    public ModelEntrada retornarEntradaPorCodController(int codEntrada){
        return this.daoEntrada.retornarEntradaPorCodDAO(codEntrada);
    }
}
