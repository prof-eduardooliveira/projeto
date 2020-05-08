/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ModelPrioridade;

/**
 *
 * @author edube
 */
public class DaoPrioridade extends conexoes.ConexaoMySql{
    
      public ArrayList<ModelPrioridade> retornarListaPrioridadeDAO() {
        ArrayList<ModelPrioridade> listaModelPrioridade = new ArrayList<>();
        ModelPrioridade modelPrioridade = new ModelPrioridade();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "CODPRIORIDADE, "
                    + "DESCPRIORIDADE "
                    + "FROM prioridade ORDER BY DESCPRIORIDADE");
            while (this.getResultSet().next()) {
                modelPrioridade = new ModelPrioridade();
                modelPrioridade.setCodPrioridade(this.getResultSet().getInt(1));
                modelPrioridade.setDescricao(this.getResultSet().getString(2));
                listaModelPrioridade.add(modelPrioridade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelPrioridade;
    }
    
}
