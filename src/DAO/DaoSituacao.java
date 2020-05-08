/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ModelServico;
import model.ModelSituacao;

/**
 *
 * @author edube
 */
public class DaoSituacao extends conexoes.ConexaoMySql {

    public ArrayList<ModelSituacao> retornarListaSituacaoDAO() {
        ArrayList<ModelSituacao> listaModelSituacoes = new ArrayList<>();
        ModelSituacao modelSituacao = new ModelSituacao();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "CODSTATUS , "
                    + "DESCSTATUS "
                    + "FROM status ORDER BY DESCSTATUS");
            while (this.getResultSet().next()) {
                modelSituacao = new ModelSituacao();
                modelSituacao.setCodSituacao(this.getResultSet().getInt(1));
                modelSituacao.setDescricao(this.getResultSet().getString(2));
                listaModelSituacoes.add(modelSituacao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelSituacoes;
    }

    public ModelSituacao retornarSituacaoDAO(int pCodigo) {
        ModelSituacao modelSituacao = new ModelSituacao();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "CODSTATUS , "
                    + "DESCSTATUS "
                    + "FROM status WHERE CODSTATUS = '" + pCodigo + "'");
            while (this.getResultSet().next()) {
                modelSituacao.setCodSituacao(this.getResultSet().getInt(1));
                modelSituacao.setDescricao(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelSituacao;
    }

     public ModelSituacao retornarSituacaoDAO(String pNome) {
        ModelSituacao modelSituacao = new ModelSituacao();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "CODSTATUS , "
                    + "DESCSTATUS "
                    + "FROM status WHERE DESCSTATUS = '" + pNome + "'");
            while (this.getResultSet().next()) {
                modelSituacao.setCodSituacao(this.getResultSet().getInt(1));
                modelSituacao.setDescricao(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelSituacao;
    }

    
}
