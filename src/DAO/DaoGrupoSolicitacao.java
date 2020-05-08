/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ModelCliente;
import model.ModelGrupoSolicitacao;
import model.ModelSolicitacaoGC;

/**
 *
 * @author edube
 */
public class DaoGrupoSolicitacao extends conexoes.ConexaoMySql {

    public ArrayList<ModelGrupoSolicitacao> retornarListaGrupoSolicitacaoDAO() {
        ArrayList<ModelGrupoSolicitacao> listaModelGrupoSolicitacaos = new ArrayList<>();
        ModelGrupoSolicitacao modelGrupoSolicitacao = new ModelGrupoSolicitacao();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "CODGRUPOSOLICITACAO, "
                    + "DESCGRUPOSOLICITACAO "
                    + "FROM grupo_solicitacao ORDER BY DESCGRUPOSOLICITACAO");
            while (this.getResultSet().next()) {
                modelGrupoSolicitacao = new ModelGrupoSolicitacao();
                modelGrupoSolicitacao.setCodGrupoSolicitacao(this.getResultSet().getInt(1));
                modelGrupoSolicitacao.setDescricao(this.getResultSet().getString(2));
                listaModelGrupoSolicitacaos.add(modelGrupoSolicitacao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelGrupoSolicitacaos;
    }

    public ModelGrupoSolicitacao retornarGrupoSolicitacaoDAO(String pDescricaoGrupo) {
        ModelGrupoSolicitacao modelGrupoSolicitacao = new ModelGrupoSolicitacao();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "CODGRUPOSOLICITACAO, "
                    + "DESCGRUPOSOLICITACAO "
                    + "FROM grupo_solicitacao WHERE DESCGRUPOSOLICITACAO = '" + pDescricaoGrupo + "'");
            while (this.getResultSet().next()) {
                modelGrupoSolicitacao.setCodGrupoSolicitacao(this.getResultSet().getInt(1));
                modelGrupoSolicitacao.setDescricao(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelGrupoSolicitacao;
    }

    public ModelGrupoSolicitacao retornarGrupoSolicitacaoDAO(int pCodigo) {
        ModelGrupoSolicitacao modelGrupoSolicitacao = new ModelGrupoSolicitacao();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "CODGRUPOSOLICITACAO, "
                    + "DESCGRUPOSOLICITACAO "
                    + "FROM grupo_solicitacao WHERE CODGRUPOSOLICITACAO = '" + pCodigo + "'");
            while (this.getResultSet().next()) {
                modelGrupoSolicitacao.setCodGrupoSolicitacao(this.getResultSet().getInt(1));
                modelGrupoSolicitacao.setDescricao(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelGrupoSolicitacao;
    }

}
