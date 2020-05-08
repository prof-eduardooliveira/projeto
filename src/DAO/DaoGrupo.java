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
public class DaoGrupo extends conexoes.ConexaoMySql {

    public ArrayList<ModelServico> retornarListaGrupoDAO() {
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
