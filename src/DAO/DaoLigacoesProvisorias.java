/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.ModelLigacoesProvisorias;

/**
 *
 * @author Nielson Soares
 */
public class DaoLigacoesProvisorias extends conexoes.ConexaoMySql{
    
    public int salvarLigacaoProvisoriaDAO (ModelLigacoesProvisorias mlp){
        String sql = "INSERT INTO SOLICITACAO_PROVISORIA ("
                + "DATA_SOLICITACAO,"
                + "CODAGRUPAMENTO,"
                + "CODENTRADA,"
                + "ID_OFICIO,"
                + "EVENTO,"
                + "CODCIDADE,"
                + "DATA_INI,"
                + "DATA_FIM,"
                + "TIPOLIGACAO_DISJUNTOR,"
                + "AMPERAGEM_DISJUNTOR,"
                + "TRAFO_KVA,"
                + "ENDERECO_LIGACAO,"
                + "REFERENCIA) VALUE ("
                + "'" + java.time.LocalDate.now() + "',"
                + "'" + mlp.getCodAgrupamento() + "',"
                + "'" + mlp.getCodEntrada() + "',"
                + "'" + mlp.getNumOficio() + "',"
                + "'" + mlp.getEvento().toUpperCase() + "',"
                + "'" + mlp.getCodCidade() + "',"
                + "'" + mlp.getDataInicio() + "',"
                + "'" + mlp.getDataFim()+ "',"
                + "'" + mlp.getTipoLigacao()+ "',"
                + "'" + mlp.getAmperagem()+ "',"
                + "'" + mlp.getTrafoKva()+ "',"
                + "'" + mlp.getEnderecoLigacao().toUpperCase()+ "',"
                + "'" + mlp.getReferencia().toUpperCase()+ "'"
                + ");";
        try{
            this.conectar();
            return this.insertSQL(sql);
            //System.out.println(sql);
            //return 1;
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
}
