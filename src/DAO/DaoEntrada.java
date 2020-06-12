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
import model.ModelEntrada;

/**
 *
 * @author Nielson Soares
 */
public class DaoEntrada extends conexoes.ConexaoMySql{
    
    public ArrayList<ModelEntrada> retornarListaEntradaDAO(){
        ArrayList<ModelEntrada> listaEntradas = new ArrayList();
        
        String sql = "SELECT * FROM ENTRADA ORDER BY DESCENTRADA;";
        
        try{
            this.conectar();
            this.executarSQL(sql);
            while(this.getResultSet().next()){
                ModelEntrada modelEntrada = new ModelEntrada();
                modelEntrada.setCodEntrada(this.getResultSet().getInt("CODENTRADA"));
                modelEntrada.setDescEntrada(this.getResultSet().getString("DESCENTRADA"));
                
                listaEntradas.add(modelEntrada);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.fecharConexao();
        }
        
        return listaEntradas;
    }
    
    public ModelEntrada retornarEntradaPorCodDAO(int codEntrada){
        ModelEntrada modelEntrada = new ModelEntrada();
        String sql = "SELECT * FROM ENTRADA WHERE CODENTRADA = " + codEntrada;
        
        try {
            this.conectar();
            this.executarSQL(sql);
            
            this.getResultSet().next();
            
            modelEntrada.setCodEntrada(this.getResultSet().getInt("CODENTRADA"));
            modelEntrada.setDescEntrada(this.getResultSet().getString("DESCENTRADA"));
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.fecharConexao();
        }
        
        return modelEntrada;
    }
}
