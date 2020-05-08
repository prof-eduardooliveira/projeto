/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ModelServico;

/**
 *
 * @author edube
 */
public class DaoServico extends conexoes.ConexaoMySql {

    public int salvarServicolDAO(ModelServico modelServico) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO servico ("
                    + "dscservico, "
                    + "sla_d_u, "
                    + "codperfil "
                    + ") VALUES ("
                    + "'" + modelServico.getDescricao() + "', "
                    + "'" + modelServico.getPrazo() + "', "
                    + "'" + modelServico.getCodPerfil() + "')"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirServicoDAO(int codigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM servico WHERE codservico = '" + codigo + "';"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean alterarServicoDAO(ModelServico pModelServico) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE servico SET "
                    + "dscservico = '" + pModelServico.getDescricao() + "', "
                    + "sla_d_u = '" + pModelServico.getPrazo() + "', "
                    + "codperfil = '" + pModelServico.getCodPerfil() + "' "
                    + "WHERE codservico = '" + pModelServico.getCodServico() + "';"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelServico retornarServicoDAO(int pCodigo) {
        ModelServico modelServico = new ModelServico();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "codservico, "
                    + "dscservico, "
                    + "sla_d_u "
                    + "FROM servico WHERE codservico = '" + pCodigo + "'");
            while (this.getResultSet().next()) {
                modelServico.setCodServico(this.getResultSet().getInt(1));
                modelServico.setDescricao(this.getResultSet().getString(2));
                modelServico.setPrazo(this.getResultSet().getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelServico;
    }

    public ModelServico retornarServicoDAO(String pDescricaoServico) {
        ModelServico modelServico = new ModelServico();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "codservico, "
                    + "dscservico, "
                    + "sla_d_u "
                    + "FROM servico WHERE dscservico = '" + pDescricaoServico + "'");
            while (this.getResultSet().next()) {
                modelServico.setCodServico(this.getResultSet().getInt(1));
                modelServico.setDescricao(this.getResultSet().getString(2));
                modelServico.setPrazo(this.getResultSet().getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelServico;
    }

    public ArrayList<ModelServico> retornarListaServicoDAO() {
        ArrayList<ModelServico> listaModelServicos = new ArrayList<>();
        ModelServico modelServico = new ModelServico();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "s.codservico, "
                    + "s.dscservico, "
                    + "s.sla_d_u, "
                    + "p.dscperfil "
                    + "FROM servico AS s LEFT JOIN perfil AS p ON s.CODPERFIL = p.CODPERFIL ORDER BY s.dscservico");
            while (this.getResultSet().next()) {
                modelServico = new ModelServico();
                modelServico.setCodServico(this.getResultSet().getInt(1));
                modelServico.setDescricao(this.getResultSet().getString(2));
                modelServico.setPrazo(this.getResultSet().getInt(3));
                modelServico.setPerfil(this.getResultSet().getString(4));
                listaModelServicos.add(modelServico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelServicos;
    }
}
