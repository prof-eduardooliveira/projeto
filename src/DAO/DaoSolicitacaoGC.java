/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ModelSolicitacaoGC;

/**
 *
 * @author edube
 */
public class DaoSolicitacaoGC extends conexoes.ConexaoMySql {

    public int salvarSolicitacaoGCDAO(ModelSolicitacaoGC pModelSolicitacao) {
        try {
            this.conectar();
            return this.insertSQL(
                    // eliminei o campo mesanovalidar
                    "INSERT INTO solicitacao_grd_cli ("
                    + "codenergisa, "
                    + "cdc, "
                    + "codservico, "
                    + "codgruposolicitacao, "
                    + "data_solicitacao, "
                    + "data_encaminhamento, "
                    + "codusuario_resp, "
                    + "demanda_ant_pt, "
                    + "demanda_ant_fp, "
                    + "demanda_sol_pt, "
                    + "demanda_sol_fp, "
                    + "codstatus, "
                    + "prioridade, "
                    + "data_resposta, "
                    + "data_limite, "
                    + "observacao "
                    + ") VALUES ("
                    + "'" + pModelSolicitacao.getCodEnergisa() + "',"
                    + "'" + pModelSolicitacao.getCDC() + "',"
                    + "'" + pModelSolicitacao.getCodServico() + "',"
                    + "'" + pModelSolicitacao.getCodGrupo() + "',"
                    + "'" + pModelSolicitacao.getDataSolicitacao() + "',"
                    + "'" + pModelSolicitacao.getDataEncaminhamento() + "',"
                    + "'" + pModelSolicitacao.getCodResponsavel() + "',"
                    + "'" + pModelSolicitacao.getDemAnteriorPonta() + "',"
                    + "'" + pModelSolicitacao.getDemAnteriorForaPonta() + "',"
                    + "'" + pModelSolicitacao.getDemSolicitadaPonta() + "',"
                    + "'" + pModelSolicitacao.getDemSolicitadaForaPonta() + "',"
                    + "'" + pModelSolicitacao.getCodSituacao() + "',"
                    + "'" + pModelSolicitacao.getPrioridade() + "',"
                    + "'" + pModelSolicitacao.getDataResposta() + "',"
                    + "'" + pModelSolicitacao.getDataLimite() + "',"
                    + "'" + pModelSolicitacao.getObservacao() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelSolicitacaoGC retQuantSolicUsua(String pNomeUsuario) {
        ModelSolicitacaoGC modelSolicitacaoGC = new ModelSolicitacaoGC();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT count(sgc.CODSOLICITACAO), "
                    + "sgc.CODUSUARIO_RESP, "
                    + "u.CODUSUARIO "
                    + "FROM solicitacao_grd_cli as sgc "
                    + "LEFT JOIN usuario as u "
                    + "ON sgc.CODUSUARIO_RESP = u.CODUSUARIO WHERE u.usuario = '" + pNomeUsuario + "'");
            while (this.getResultSet().next()) {
                modelSolicitacaoGC.setTotal(this.getResultSet().getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelSolicitacaoGC;
    }

    public boolean excluirSolicitacaoGCDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM solicitacao_grd_cli WHERE codsolicitacao = '" + pCodigo + "';");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<ModelSolicitacaoGC> retornarListaSolicitacaoGCDAO() {
        ArrayList<ModelSolicitacaoGC> listaModelSolicitacaoGCs = new ArrayList<>();
        ModelSolicitacaoGC modelSolicitacaoGC = new ModelSolicitacaoGC();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "c.CDC, "
                    + "c.NOMECSD, "
                    + "u.CODUSUARIO, "
                    + "u.USUARIO, "
                    + "s.CODSERVICO, "
                    + "s.DSCSERVICO, "
                    + "s.SLA_D_U, "
                    + "stat.CODSTATUS, "
                    + "stat.DESCSTATUS, "
                    + "sgc.CDC, "
                    + "sgc.CODUSUARIO_RESP, "
                    + "sgc.CODENERGISA, "
                    + "sgc.PRIORIDADE, "
                    + "e.CODENERGISA, "
                    + "e.SGLENERGISA, "
                    + "sgc.DATA_SOLICITACAO, "
                    + "sgc.DATA_LIMITE "
                    + "FROM solicitacao_grd_cli as sgc "
                    + "LEFT JOIN cliente as c "
                    + "ON sgc.CDC = c.CDC "
                    + "LEFT JOIN energisa as e "
                    + "ON sgc.CODENERGISA = e.CODENERGISA "
                    + "LEFT JOIN usuario as u "
                    + "ON sgc.CODUSUARIO_RESP = u.CODUSUARIO "
                    + "LEFT JOIN status as stat "
                    + "ON sgc.CODSTATUS = stat.CODSTATUS "
                    + "LEFT JOIN servico as s "
                    + "ON sgc.CODSERVICO = s.CODSERVICO ORDER BY sgc.DATA_SOLICITACAO DESC;");

            while (this.getResultSet().next()) {
                modelSolicitacaoGC = new ModelSolicitacaoGC(); // evitar erros
                modelSolicitacaoGC.setCDC(this.getResultSet().getInt(1));
                modelSolicitacaoGC.setNomeEnergisa(this.getResultSet().getString(15));
                modelSolicitacaoGC.setNomeCliente(this.getResultSet().getString(2));
                modelSolicitacaoGC.setResponsavel(this.getResultSet().getString(4));
                modelSolicitacaoGC.setServico(this.getResultSet().getString(6));
                modelSolicitacaoGC.setSLA_D_U(this.getResultSet().getInt(7));
                modelSolicitacaoGC.setSituacao(this.getResultSet().getString(9));
                modelSolicitacaoGC.setPrioridade(this.getResultSet().getString(13));
                modelSolicitacaoGC.setDataSolicitacao(this.getResultSet().getString(16));
                modelSolicitacaoGC.setDataLimite(this.getResultSet().getString(17));
                listaModelSolicitacaoGCs.add(modelSolicitacaoGC);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelSolicitacaoGCs;
    }

}
