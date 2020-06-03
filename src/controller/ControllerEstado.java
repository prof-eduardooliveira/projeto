/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoEstado;
import java.util.ArrayList;
import model.ModelEstado;

/**
 *
 * @author Nielson Soares
 */
public class ControllerEstado {
    private DaoEstado daoEstado = new DaoEstado();
    
    public ArrayList<ModelEstado> retornarListaEstadoController(){
        return this.daoEstado.retornarListaEstadoDAO();
    }
    
    public ModelEstado retornarEstadoPorCod(int codEstado){
        return this.daoEstado.retornaEstadoPorCod(codEstado);
    }
}
