/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelAgrupamento;

/**
 *
 * @author Nielson Soares
 */
public class DaoAgrupamento extends conexoes.ConexaoMySql{
    
    public ArrayList<ModelAgrupamento> retornarListaAgrupamentoDAO(){
        ArrayList<ModelAgrupamento> listaAgrupamentos = new ArrayList();
        
        String sql = "SELECT * FROM AGRUPAMENTO WHERE DSCAGRUPAMENTO LIKE 'PM%' ORDER BY DSCAGRUPAMENTO;";
        
        try {
            this.conectar();
            this.executarSQL(sql);
            while (this.getResultSet().next()){
                ModelAgrupamento agrupamento = new ModelAgrupamento();
                agrupamento.setCodAgrupamento(this.getResultSet().getInt("CODAGRUPAMENTO"));
                agrupamento.setDescAgrupamento(this.getResultSet().getString("DSCAGRUPAMENTO"));
                
                listaAgrupamentos.add(agrupamento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgrupamento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.fecharConexao();
        }
        
        return listaAgrupamentos;
    }
    
    public ModelAgrupamento retornarAgrupamentoPorCodDAO(int codAgrupamento){
        ModelAgrupamento agrupamento = new ModelAgrupamento();
        String sql = "SELECT * FROM AGRUPAMENTO WHERE CODAGRUPAMENTO = " + codAgrupamento;
        
        try {
            this.conectar();
            this.executarSQL(sql);
            while (this.getResultSet().next()){
                agrupamento.setCodAgrupamento(this.getResultSet().getInt("CODAGRUPAMENTO"));
                agrupamento.setDescAgrupamento(this.getResultSet().getString("DSCAGRUPAMENTO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgrupamento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.fecharConexao();
        }
        
        return agrupamento;
    }
}
