/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ModelPerfil;
/**
 *
 * @author edube
 */
public class DaoPerfil extends conexoes.ConexaoMySql {
    
    public int salvarPerfilDAO(ModelPerfil modelPerfil){
        try{
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO perfil ("
                            + "dscperfil "
                            + ") VALUES ("
                            + "'" + modelPerfil.getNome() + "'"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        finally{
            this.fecharConexao();
        }
    }
    
    public boolean excluirPerfilDAO(int codigo){
        try{
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM perfil WHERE codperfil == '" + codigo + "';"
            );        
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally{
            this.fecharConexao();
        }
    }
    
     public boolean alterarPerfilDAO(ModelPerfil pModelPerfil) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE perfil SET "
                    + "dscperfil = '" + pModelPerfil.getNome() + "' "
                    + "WHERE codperfil = '" + pModelPerfil.getCodPerfil()+ "';"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
     
    public ModelPerfil retornarPerfilDAO(int pCodigo) {
        ModelPerfil modelPerfil = new ModelPerfil();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "codperfil, "
                    + "dscperfil "
                    + "FROM perfil WHERE codperfil = '" + pCodigo + "'");
            while (this.getResultSet().next()) {
                modelPerfil.setCodPerfil(this.getResultSet().getInt(1));
                modelPerfil.setNome(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelPerfil;
    }
    
    public ModelPerfil retornarPerfilDAO(String pNomeCliente) {
        ModelPerfil modelPerfil = new ModelPerfil();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "codperfil, "
                    + "dscperfil "
                    + "FROM perfil WHERE dscperfil = '" + pNomeCliente + "'");
            while (this.getResultSet().next()) {
                modelPerfil.setCodPerfil(this.getResultSet().getInt(1));
                modelPerfil.setNome(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelPerfil;
    }

    public ArrayList<ModelPerfil> retornarListaPerfisDAO() {
        ArrayList<ModelPerfil> listaModelPerfis = new ArrayList<>();
        ModelPerfil modelPerfil = new ModelPerfil();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "codperfil, "
                    + "dscperfil "
                    + "FROM perfil ORDER BY dscperfil");
            while (this.getResultSet().next()) {
                modelPerfil = new ModelPerfil();
                modelPerfil.setCodPerfil(this.getResultSet().getInt(1));
                modelPerfil.setNome(this.getResultSet().getString(2));
                listaModelPerfis.add(modelPerfil);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelPerfis;
    }
    
}
