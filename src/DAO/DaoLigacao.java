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
import model.ModelLigacao;

/**
 *
 * @author Nielson Soares
 */
public class DaoLigacao extends conexoes.ConexaoMySql{
    public ArrayList<ModelLigacao> retornarListaLigacaoDAO(){
        ArrayList<ModelLigacao> listLigacoes = new ArrayList();
        
        String sql = "SELECT * FROM LIGACAO";
        
        try {
            this.conectar();
            this.executarSQL(sql);
            
            while (this.getResultSet().next()){
                ModelLigacao l = new ModelLigacao();
                
                l.setCodLigacao(this.getResultSet().getInt(1));
                l.setDescligacao(this.getResultSet().getString(2));
                
                listLigacoes.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoLigacao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.fecharConexao();
        }
        return listLigacoes;
    }
}
