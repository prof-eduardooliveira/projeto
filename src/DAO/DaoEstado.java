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
import model.ModelEstado;

/**
 *
 * @author Nielson Soares
 */
public class DaoEstado extends conexoes.ConexaoMySql{
    public ArrayList<ModelEstado> retornarListaEstadoDAO(){
        ArrayList<ModelEstado> listEstados = new ArrayList();
        
        String sql = "SELECT * FROM ESTADO ORDER BY DSCESTADO;";
        
        try{
            this.conectar();
            this.executarSQL(sql);
            
            while (this.getResultSet().next()){
                ModelEstado e = new ModelEstado();
                e.setCodEstado(this.getResultSet().getInt(1));
                e.setDescEstado(this.getResultSet().getString(2));
                e.setSiglaEstado(this.getResultSet().getString(3));
                
                listEstados.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.fecharConexao();
        }
        
        return listEstados;
    }
    
    public ModelEstado retornaEstadoPorCod(int codEstado){
        ModelEstado e = new ModelEstado();
        String sql = "SELECT * FROM ESTADO WHERE CODESTADO = " + codEstado;
        try{
            this.conectar();
            this.executarSQL(sql);
            this.getResultSet().next();
            e.setCodEstado(this.getResultSet().getInt(1));
            e.setDescEstado(this.getResultSet().getString(2));
            e.setSiglaEstado(this.getResultSet().getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.fecharConexao();
        }
        
        return e;
    }
}
