/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoAgrupamento;
import java.util.ArrayList;
import model.ModelAgrupamento;

/**
 *
 * @author Nielson Soares
 */
public class ControllerAgrupamento {
    private DaoAgrupamento daoAgrupamento = new DaoAgrupamento();
    
    public ArrayList<ModelAgrupamento> retonarListaAgrupamentoController(){
        return this.daoAgrupamento.retornarListaAgrupamentoDAO();
    }
}
