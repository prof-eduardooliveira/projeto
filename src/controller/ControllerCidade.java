/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoCidade;
import java.util.ArrayList;
import model.ModelCidade;

/**
 *
 * @author Nielson Soares
 */
public class ControllerCidade {
    private DaoCidade daoCidade = new DaoCidade();
    
    public ArrayList<ModelCidade> retornarListaCidadeController(){
        return this.daoCidade.retornarListaCidadeDAO();
    }
    
    public ModelCidade retornarCidadePorCodController(int codCidade){
        return this.daoCidade.retornarCidadePorCodDAO(codCidade);
    }
}
