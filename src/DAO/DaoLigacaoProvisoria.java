/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.Utilitario;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelLigacaoProvisoria;

/**
 *
 * @author Nielson Soares
 */
public class DaoLigacaoProvisoria extends conexoes.ConexaoMySql{
    
    public int salvarLigacaoProvisoriaDAO (ModelLigacaoProvisoria mlp){
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
    
    public ArrayList retornarListaLigacoesProvisoriasDAO(){
        ArrayList<ModelLigacaoProvisoria> lista = new ArrayList();
        
        String sql = "SELECT * FROM SOLICITACAO_PROVISORIA;";
        
        try {
            this.conectar();
            this.executarSQL(sql);
            
            while (this.getResultSet().next()){
                ModelLigacaoProvisoria mlp = new ModelLigacaoProvisoria();
                mlp.setCodSolicitacao(this.getResultSet().getInt("CODSOLICITACAO"));
                Date dataSolicitacao = Date.valueOf(this.getResultSet().getString("DATA_SOLICITACAO"));
                mlp.setDataSolicitacao(Utilitario.coonverteDataBrasilFormat(dataSolicitacao));
                mlp.setCodAgrupamento(this.getResultSet().getInt("CODAGRUPAMENTO"));
                mlp.setCodEntrada(this.getResultSet().getInt("CODENTRADA"));
                mlp.setNumOficio(this.getResultSet().getString("ID_OFICIO"));
                mlp.setEvento(this.getResultSet().getString("EVENTO"));
                mlp.setCodCidade(this.getResultSet().getInt("CODCIDADE"));
                Date dataInicio = Date.valueOf(this.getResultSet().getString("DATA_INI"));
                mlp.setDataInicio(Utilitario.coonverteDataBrasilFormat(dataInicio));
                Date dataFim = Date.valueOf(this.getResultSet().getString("DATA_FIM"));
                mlp.setDataFim(Utilitario.coonverteDataBrasilFormat(dataFim));
                mlp.setTipoLigacao(this.getResultSet().getInt("TIPOLIGACAO_DISJUNTOR"));
                mlp.setAmperagem(this.getResultSet().getInt("AMPERAGEM_DISJUNTOR"));
                mlp.setTrafoKva(this.getResultSet().getString("TRAFO_KVA"));
                mlp.setEnderecoLigacao(this.getResultSet().getString("ENDERECO_LIGACAO"));
                mlp.setReferencia(this.getResultSet().getString("REFERENCIA"));
                
                lista.add(mlp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoLigacaoProvisoria.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            this.fecharConexao();
        }
        
        return lista;
    }

    public boolean alterarLigacaoProvisoriaDAO(ModelLigacaoProvisoria mlp) {
        String sql = "UPDATE SOLICITACAO_PROVISORIA SET "
                + "CODAGRUPAMENTO = " + "'" + mlp.getCodAgrupamento() + "',"
                + "CODENTRADA = " + "'" + mlp.getCodEntrada() + "',"
                + "ID_OFICIO = " + "'" + mlp.getNumOficio() + "',"
                + "EVENTO = " + "'" + mlp.getEvento().toUpperCase() + "',"
                + "CODCIDADE = " + "'" + mlp.getCodCidade() + "',"
                + "DATA_INI = " + "'" + mlp.getDataInicio() + "',"
                + "DATA_FIM = " + "'" + mlp.getDataFim()+ "',"
                + "TIPOLIGACAO_DISJUNTOR = " + "'" + mlp.getTipoLigacao()+ "',"
                + "AMPERAGEM_DISJUNTOR = "  + "'" + mlp.getAmperagem()+ "',"
                + "TRAFO_KVA = " + "'" + mlp.getTrafoKva()+ "',"
                + "ENDERECO_LIGACAO = " + "'" + mlp.getEnderecoLigacao().toUpperCase()+ "',"
                + "REFERENCIA = " + "'" + mlp.getReferencia().toUpperCase()+ "' "
                + "WHERE CODSOLICITACAO = " + mlp.getCodSolicitacao() + ";";
        
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(sql);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean removerLigacaoProvisoriaDAO(int codSolicitacao) {
        String sql  = "DELETE FROM SOLICITACAO_PROVISORIA WHERE CODSOLICITACAO = " + codSolicitacao;
        
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(sql);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
        
    }
}
