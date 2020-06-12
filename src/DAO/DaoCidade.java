/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.ControllerEstado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelCidade;

/**
 *
 * @author Nielson Soares
 */
public class DaoCidade extends conexoes.ConexaoMySql{
    public ArrayList<ModelCidade> retornarListaCidadeDAO(){
        ArrayList<ModelCidade> listCidades = new ArrayList();
        String sql = "SELECT * FROM CIDADE WHERE CODESTADO = 11 ORDER BY DSCCIDADE";
        
        try{
            this.conectar();
            this.executarSQL(sql);
            
            while (this.getResultSet().next()){
                ModelCidade c = new ModelCidade();
                
                c.setCodCidade(this.getResultSet().getInt(1));
                c.setDescCidade(this.getResultSet().getString(2));
                //c.setEstado(new ControllerEstado().retornarEstadoPorCod(this.getResultSet().getInt(3)));
                c.setCodEstado(this.getResultSet().getInt(3));
                
                listCidades.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCidade.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.fecharConexao();
        }
        
        return listCidades;
    }

    public ModelCidade retornarCidadePorCodDAO(int codCidade) {
        ModelCidade cidade = new ModelCidade();
        
        String sql = "SELECT * FROM CIDADE WHERE CODCIDADE = " + codCidade;
        
        try{
            this.conectar();
            this.executarSQL(sql);
            
            while (this.getResultSet().next()){
                
                cidade.setCodCidade(this.getResultSet().getInt("CODCIDADE"));
                cidade.setDescCidade(this.getResultSet().getString("DSCCIDADE"));
                cidade.setCodEstado(this.getResultSet().getInt("CODESTADO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCidade.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.fecharConexao();
        }
        
        return cidade;
    }
}
