/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ModelUsuario;

/**
 *
 * @author Lara Guedes
 */
public class DaoUsuario extends conexoes.ConexaoMySql {

    public int salvarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO usuario ("
                    + "nomeusuario, "
                    + "codperfil, "
                    + "email, "
                    + "whatsapp, "
                    + "usuario, "
                    + "senha "
                    + ") VALUES ("
                    + "'" + pModelUsuario.getNome() + "',"
                    + "'" + pModelUsuario.getPerfil() + "',"
                    + "'" + pModelUsuario.getEmail() + "',"
                    + "'" + pModelUsuario.getWhatsapp() + "',"
                    + "'" + pModelUsuario.getUsuario() + "',"
                    + "'" + pModelUsuario.getSenha() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirUsuarioDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM usuario WHERE codusuario = '" + pCodigo + "';");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean alterarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE usuario SET "
                    + "nomeusuario = '" + pModelUsuario.getNome() + "', "
                    + "codperfil = '" + pModelUsuario.getPerfil() + "', "
                    + "email = '" + pModelUsuario.getEmail() + "', "
                    + "whatsapp = '" + pModelUsuario.getWhatsapp() + "', "
                    + "usuario = '" + pModelUsuario.getUsuario() + "', "
                    + "senha = '" + pModelUsuario.getSenha() + "' "
                    + "WHERE codusuario = '" + pModelUsuario.getId_usuario() + "';"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelUsuario retornarUsuarioDAO(int pCodigo) {
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "codusuario, "
                    + "nomeusuario, "
                    + "codperfil, "
                    + "email, "
                    + "whatsapp, "
                    + "usuario, "
                    + "senha FROM usuario WHERE codusuario = '" + pCodigo + "'");
            while (this.getResultSet().next()) {
                modelUsuario.setId_usuario(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setPerfil(this.getResultSet().getInt(3));
                modelUsuario.setEmail(this.getResultSet().getString(4));
                modelUsuario.setWhatsapp(this.getResultSet().getString(5));
                modelUsuario.setUsuario(this.getResultSet().getString(6));
                modelUsuario.setSenha(this.getResultSet().getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }
    
     public ModelUsuario retornarUsuarioDAO(String pNome) {
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "codusuario, "
                    + "nomeusuario, "
                    + "codperfil, "
                    + "email, "
                    + "whatsapp, "
                    + "usuario, "
                    + "senha FROM usuario WHERE nomeusuario = '" + pNome + "'");
            while (this.getResultSet().next()) {
                modelUsuario.setId_usuario(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setPerfil(this.getResultSet().getInt(3));
                modelUsuario.setEmail(this.getResultSet().getString(4));
                modelUsuario.setWhatsapp(this.getResultSet().getString(5));
                modelUsuario.setUsuario(this.getResultSet().getString(6));
                modelUsuario.setSenha(this.getResultSet().getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    public ArrayList<ModelUsuario> retornarListaUsuarioDAO() {
        ArrayList<ModelUsuario> listaModelUsuarios = new ArrayList<>();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "u.codusuario, "
                    + "u.nomeusuario, "
                    + "u.codperfil, "
                    + "p.dscperfil, "
                    + "u.email, "
                    + "u.whatsapp, "
                    + "u.usuario, "
                    + "u.senha "
                    + "FROM usuario as u "
                    + "LEFT JOIN perfil as p ON u.CODPERFIL = p.CODPERFIL ORDER BY u.nomeusuario"
            );
            while (this.getResultSet().next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setId_usuario(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setPerfil(this.getResultSet().getInt(3));
                modelUsuario.setNomePerfil(this.getResultSet().getString(4));
                modelUsuario.setEmail(this.getResultSet().getString(5));
                modelUsuario.setWhatsapp(this.getResultSet().getString(6));
                modelUsuario.setUsuario(this.getResultSet().getString(7));
                modelUsuario.setSenha(this.getResultSet().getString(8));
                listaModelUsuarios.add(modelUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelUsuarios;
    }

    public ArrayList<ModelUsuario> retornarListaUsuarioPesquisaNomeDAO(ModelUsuario pModelUsuario) {
        ArrayList<ModelUsuario> listaModelUsuarios = new ArrayList<>();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "u.codusuario, "
                    + "u.nomeusuario, "
                    + "u.codperfil, "
                    + "p.dscperfil, "
                    + "u.email, "
                    + "u.whatsapp, "
                    + "u.usuario, "
                    + "u.senha "
                    + "FROM usuario as u "
                    + "LEFT JOIN perfil as p ON u.CODPERFIL = p.CODPERFIL "
                    + "WHERE u.nomeusuario LIKE '%" + pModelUsuario.getNome() + "%'"
            );
            while (this.getResultSet().next()) {
                pModelUsuario = new ModelUsuario();
                pModelUsuario.setId_usuario(this.getResultSet().getInt(1));
                pModelUsuario.setNome(this.getResultSet().getString(2));
                pModelUsuario.setPerfil(this.getResultSet().getInt(3));
                pModelUsuario.setNomePerfil(this.getResultSet().getString(4));
                pModelUsuario.setEmail(this.getResultSet().getString(5));
                pModelUsuario.setWhatsapp(this.getResultSet().getString(6));
                pModelUsuario.setUsuario(this.getResultSet().getString(7));
                pModelUsuario.setSenha(this.getResultSet().getString(8));
                listaModelUsuarios.add(pModelUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelUsuarios;
    }
    
    public ArrayList<ModelUsuario> retornarListaUsuarioPesquisaPerfilDAO(ModelUsuario pModelUsuario) {
        ArrayList<ModelUsuario> listaModelUsuarios = new ArrayList<>();
        System.out.println(pModelUsuario.getNomePerfil());
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "u.codusuario, "
                    + "u.nomeusuario, "
                    + "u.codperfil, "
                    + "p.dscperfil, "
                    + "u.email, "
                    + "u.whatsapp, "
                    + "u.usuario, "
                    + "u.senha "
                    + "FROM usuario as u "
                    + "LEFT JOIN perfil as p ON u.CODPERFIL = p.CODPERFIL "
                    + "WHERE p.dscperfil LIKE '%" + pModelUsuario.getNomePerfil()+ "%'"
            );
            while (this.getResultSet().next()) {
                pModelUsuario = new ModelUsuario();
                pModelUsuario.setId_usuario(this.getResultSet().getInt(1));
                pModelUsuario.setNome(this.getResultSet().getString(2));
                pModelUsuario.setPerfil(this.getResultSet().getInt(3));
                pModelUsuario.setNomePerfil(this.getResultSet().getString(4));
                pModelUsuario.setEmail(this.getResultSet().getString(5));
                pModelUsuario.setWhatsapp(this.getResultSet().getString(6));
                pModelUsuario.setUsuario(this.getResultSet().getString(7));
                pModelUsuario.setSenha(this.getResultSet().getString(8));
                listaModelUsuarios.add(pModelUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelUsuarios;
    }
    
    /*public ModelUsuario retornarUsuarioLoginDAO(String pUsuario, String pSenha) {
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_usuario, "
                    + "nome, "
                    + "login, "
                    + "senha "
                    + "FROM usuario WHERE nome = '" + pUsuario + "' AND senha = '" + pSenha + "'");
            while (this.getResultSet().next()) {
                modelUsuario.setId_usuario(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setUsuario(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }*/
    public boolean validarUsuarioDAO(ModelUsuario modelUsuario) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "codusuario, "
                    + "nomeusuario, "
                    + "usuario, "
                    + "senha "
                    + "FROM usuario WHERE usuario = '" + modelUsuario.getUsuario() + "' AND senha = '" + modelUsuario.getSenha() + "'");
            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
