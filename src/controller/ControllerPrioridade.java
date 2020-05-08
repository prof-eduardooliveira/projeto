/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoPrioridade;
import java.util.ArrayList;
import model.ModelPrioridade;

/**
 *
 * @author edube
 */
public class ControllerPrioridade {
    private DaoPrioridade daoPrioridade = new DaoPrioridade();
    
    public ArrayList<ModelPrioridade> getListaPrioridadeController(){
        return daoPrioridade.retornarListaPrioridadeDAO();
    }
}
