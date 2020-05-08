/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ModelCliente;
import model.ModelPerfil;

/**
 *
 * @author Eduardo
 */
public class DaoCliente extends conexoes.ConexaoMySql {

    public int salvarClientelDAO(ModelCliente modelCliente) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cliente ("
                    + "CDC, "
                    + "NOMECSD, "
                    + "ENDERECO, "
                    + "NUMCASA, "
                    + "COMPLEMENTO, "
                    + "BAIRRO, "
                    + "CEP, "
                    + "NUMDOC, "
                    + "NUMTEL, "
                    + "EMAIL, "
                    + "KW_CONT_PT, "
                    + "KW_CONT_FPT, "
                    + "SUBESTACAO, "
                    + "ALIMENTADOR, "
                    + "INDSIT, "
                    + "CODZONA, "
                    + "CODGRUPO, "
                    + "CODCLS, "
                    + "CODSUBCLS, "
                    + "CODAGRUPAMENTO, "
                    + "CODATIVIDADE"
                    + ") VALUES ("
                    + "'" + modelCliente.getCdc() + "', "
                    + "'" + modelCliente.getNomecsd() + "', "
                    + "'" + modelCliente.getEndereco() + "', "
                    + "'" + modelCliente.getNumero() + "', "
                    + "'" + modelCliente.getComplemento() + "', "
                    + "'" + modelCliente.getBairro() + "', "
                    + "'" + modelCliente.getCEP() + "', "
                    + "'" + modelCliente.getNumdoc() + "', "
                    + "'" + modelCliente.getNumtel() + "', "
                    + "'" + modelCliente.getEmail() + "', "
                    + "'" + modelCliente.getKw_cont_pt() + "', "
                    + "'" + modelCliente.getKw_cont_ftp() + "', "
                    + "'" + modelCliente.getSubestacao() + "', "
                    + "'" + modelCliente.getAlimentador() + "', "
                    + "'" + modelCliente.getIndsit() + "', "
                    + "'" + modelCliente.getCodzona() + "', "
                    + "'" + modelCliente.getCodgrupo() + "', "
                    + "'" + modelCliente.getCodcls() + "', "
                    + "'" + modelCliente.getCodsubcls() + "', "
                    + "'" + modelCliente.getCodagrupamento() + "', "
                    + "'" + modelCliente.getCodatividade() + "')"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirClienteDAO(int codigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cliente WHERE cdc == '" + codigo + "';"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean alterarClienteDAO(ModelCliente pModelCliente) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cliente SET "
                    + "NOMECSD =  '" + pModelCliente.getNomecsd() + "' "
                    + "ENDERECO = '" + pModelCliente.getEndereco() + "' "
                    + "NUMCASA = '" + pModelCliente.getNumero() + "' "
                    + "COMPLEMENTO =  '" + pModelCliente.getComplemento() + "' "
                    + "BAIRRO = '" + pModelCliente.getBairro() + "' "
                    + "CEP = '" + pModelCliente.getCEP() + "' "
                    + "NUMDOC =  '" + pModelCliente.getNumdoc() + "' "
                    + "NUMTEL = '" + pModelCliente.getNumtel() + "' "
                    + "EMAIL = '" + pModelCliente.getEmail() + "' "
                    + "KW_CONT_PT = '" + pModelCliente.getKw_cont_pt() + "' "
                    + "KW_CONT_FPT = '" + pModelCliente.getKw_cont_ftp() + "' "
                    + "SUBESTACAO =  '" + pModelCliente.getSubestacao() + "' "
                    + "ALIMENTADOR = '" + pModelCliente.getAlimentador() + "' "
                    + "INDSIT = '" + pModelCliente.getIndsit() + "' "
                    + "CODZONA = '" + pModelCliente.getCodzona() + "' "
                    + "CODGRUPO = '" + pModelCliente.getCodgrupo() + "' "
                    + "CODCLS = '" + pModelCliente.getCodcls() + "' "
                    + "CODSUBCLS = '" + pModelCliente.getCodsubcls() + "' "
                    + "CODAGRUPAMENTO = '" + pModelCliente.getCodagrupamento() + "' "
                    + "CODATIVIDADE = '" + pModelCliente.getCodatividade() + "' "
                    + "WHERE CDC = '" + pModelCliente.getCdc() + "';"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelCliente retornarClienteDAO(int pCodigo) {
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "c.CDC, "
                    + "c.NOMECSD, "
                    + "c.ENDERECO, "
                    + "c.NUMCASA, "
                    + "c.COMPLEMENTO, "
                    + "c.BAIRRO, "
                    + "cid.DSCCIDADE, "
                    + "c.CEP, "
                    + "c.EMAIL, "
                    + "c.NUMDOC, "
                    + "c.NUMTEL, "
                    + "c.KW_CONT_PT, "
                    + "c.KW_CONT_FPT, "
                    + "c.CODSUBESTACAO, "
                    + "c.CODENERGISA, "
                    + "c.ALIMENTADOR, "
                    + "c.INDSIT, "
                    + "c.CODCIDADE, "
                    + "c.CODZONA, "
                    + "c.CODGRUPO, "
                    + "c.CODCLS, "
                    + "c.CODSUBCLS, "
                    + "c.CODAGRUPAMENTO, "
                    + "c.CODATIVIDADE, "
                    + "e.CODENERGISA, "
                    + "e.SGLENERGISA, "
                    + "cid.CODCIDADE, "
                    + "z.CODZONA, " //zona
                    + "z.DSCZONA, "
                    + "g.CODGRUPO, " //grupo
                    + "g.DSCGRUPO, "
                    + "cla.CODCLS, " // classe 
                    + "cla.DSCCLS, "
                    + "s.CODSUBCLS, " //subclasse
                    + "s.DSCSUBCLS, "
                    + "a.CODAGRUPAMENTO, " //agrupamento
                    + "a.DSCAGRUPAMENTO, "
                    + "ativ.CODATIVIDADE, " // atividade
                    + "ativ.DSCATIVIDADE, "
                    + "sub.SGLSUBESTACAO "
                    + "FROM cliente as c "
                    + "LEFT JOIN cidade as cid "
                    + "ON c.CODCIDADE = cid.CODCIDADE "
                    + "LEFT JOIN energisa as e "
                    + "ON c.CODENERGISA = e.CODENERGISA "
                    + "LEFT JOIN zona as z "
                    + "ON c.CODZONA = z.CODZONA "
                    + "LEFT JOIN grupo as g "
                    + "ON c.CODGRUPO = g.CODGRUPO "
                    + "LEFT JOIN classe as cla "
                    + "ON c.CODCLS = cla.CODCLS "
                    + "LEFT JOIN subclasse as s "
                    + "ON c.CODSUBCLS = s.CODSUBCLS "
                    + "LEFT JOIN agrupamento as a "
                    + "ON c.CODAGRUPAMENTO = a.CODAGRUPAMENTO "
                    + "LEFT JOIN atividade as ativ "
                    + "ON c.CODATIVIDADE = ativ.CODATIVIDADE "
                    + "LEFT JOIN subestacao as sub "
                    + "ON c.CODSUBESTACAO = sub.CODSUBESTACAO "
                    + "WHERE c.CDC = '" + pCodigo + "'");
            while (this.getResultSet().next()) {
                modelCliente.setCdc(this.getResultSet().getInt(1));
                modelCliente.setNomecsd(this.getResultSet().getString(2));
                modelCliente.setEndereco(this.getResultSet().getString(3));
                modelCliente.setNumero(this.getResultSet().getString(4));
                modelCliente.setComplemento(this.getResultSet().getString(5));
                modelCliente.setBairro(this.getResultSet().getString(6));
                modelCliente.setCidade(this.getResultSet().getString(7));
                modelCliente.setCEP(this.getResultSet().getString(8));
                modelCliente.setEmail(this.getResultSet().getString(9));
                modelCliente.setNumdoc(this.getResultSet().getString(10));
                modelCliente.setNumtel(this.getResultSet().getString(11));
                modelCliente.setKw_cont_pt(Integer.parseInt(this.getResultSet().getString(12)));
                modelCliente.setKw_cont_ftp(Integer.parseInt(this.getResultSet().getString(13)));
                /*modelCliente.setKw_cont_pt(this.getResultSet().getInt(10));
                modelCliente.setKw_cont_ftp(this.getResultSet().getInt(11));
                modelCliente.setSubestacao(this.getResultSet().getString(12));
                modelCliente.setAlimentador(this.getResultSet().getString(13));
                modelCliente.setIndsit(this.getResultSet().getString(14));
                modelCliente.setCod_cidade(this.getResultSet().getInt(15));
                modelCliente.setCodzona(this.getResultSet().getInt(16));
                modelCliente.setCodgrupo(this.getResultSet().getInt(17));
                modelCliente.setCodcls(this.getResultSet().getInt(18));
                modelCliente.setCodsubcls(this.getResultSet().getInt(19));
                modelCliente.setCodagrupamento(this.getResultSet().getInt(20));
                modelCliente.setCodatividade(this.getResultSet().getInt(21));
                modelCliente.setZona(this.getResultSet().getString(23));
                modelCliente.setGrupo(this.getResultSet().getString(24));
                modelCliente.setClasse(this.getResultSet().getString(25));
                modelCliente.setSubclasse(this.getResultSet().getString(26));
                modelCliente.setAgrupamento(this.getResultSet().getString(27));
                modelCliente.setAtividade(this.getResultSet().getString(28));*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    public ArrayList<ModelCliente> retornarListaClienteDAO() {
        ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "c.CDC, "
                    + "cid.CODCIDADE, "
                    + "cid.DSCCIDADE, "
                    + "c.CODCIDADE, "
                    + "c.NOMECSD, "
                    + "c.ENDERECO, "
                    + "c.NUMCASA, "
                    + "c.BAIRRO, "
                    + "c.NUMTEL, "
                    + "c.EMAIL, "
                    + "c.CODENERGISA, "
                    + "e.CODENERGISA, "
                    + "e.SGLENERGISA "
                    + "FROM cliente as c "
                    + "INNER JOIN cidade as cid "
                    + "ON c.CODCIDADE = cid.CODCIDADE "
                    + "INNER JOIN energisa as e "
                    + "ON c.CODENERGISA = e.CODENERGISA ORDER BY c.NOMECSD;");
            while (this.getResultSet().next()) {
                modelCliente = new ModelCliente(); // evitar erros
                modelCliente.setCdc(this.getResultSet().getInt(1));
                modelCliente.setNomecsd(this.getResultSet().getString(5));
                modelCliente.setEndereco(this.getResultSet().getString(6));
                modelCliente.setNumero(this.getResultSet().getString(7));
                modelCliente.setBairro(this.getResultSet().getString(8));
                modelCliente.setCidade(this.getResultSet().getString(3));
                modelCliente.setEstado(this.getResultSet().getString(13));
                modelCliente.setNumtel(this.getResultSet().getString(9));
                modelCliente.setEmail(this.getResultSet().getString(10));
                listaModelClientes.add(modelCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelClientes;
    }

    public ModelCliente retornarClienteDAO(String pNomeCliente) {
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "c.CDC, "
                    + "c.NOMECSD, "
                    + "c.CODENERGISA, "
                    + "e.CODENERGISA, "
                    + "e.SGLENERGISA, "
                    + "c.ENDERECO, "
                    + "c.NUMCASA, "
                    + "c.BAIRRO, "
                    + "cid.CODCIDADE, "
                    + "cid.DSCCIDADE, "
                    + "c.CODCIDADE, "
                    + "c.NUMTEL, "
                    + "c.EMAIL "
                    + "FROM cliente as c "
                    + "INNER JOIN cidade as cid "
                    + "ON c.CODCIDADE = cid.CODCIDADE "
                    + "INNER JOIN energisa as e "
                    + "ON c.CODENERGISA = e.CODENERGISA "
                    + "WHERE c.NOMECSD = '" + pNomeCliente + "'");
            while (this.getResultSet().next()) {
                modelCliente.setCdc(this.getResultSet().getInt(1));
                modelCliente.setNomecsd(this.getResultSet().getString(2));
                modelCliente.setCod_energisa(this.getResultSet().getInt(3));
                modelCliente.setSigla(this.getResultSet().getString(5));
                modelCliente.setEndereco(this.getResultSet().getString(6));
                modelCliente.setNumero(this.getResultSet().getString(7));
                modelCliente.setBairro(this.getResultSet().getString(8));
                modelCliente.setCidade(this.getResultSet().getString(10));
                modelCliente.setNumtel(this.getResultSet().getString(12));
                modelCliente.setEmail(this.getResultSet().getString(13));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }
}
