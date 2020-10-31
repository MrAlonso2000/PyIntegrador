/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.*;
import ClasesDTO.*;
import ConexionBD.SQLConexion;

/**
 *
 * @author Oscar Alonso
 */
public class UsuarioDAO extends SQLConexion implements OperacionesBd<UsuarioDTO> {

    PreparedStatement pstm = null;
    ResultSet res = null;
    Connection con = null;

    public Boolean userLogin(UsuarioDTO usuario) {
        Boolean result = false;
        con = getConexion();
        final String SQL_LOGIN = "select * from usuario where correo=? and pwd =?";
        try {
            pstm = con.prepareStatement(SQL_LOGIN);
            pstm.setString(1, usuario.getCorreo());
            pstm.setString(2, usuario.getPwd());
            res = pstm.executeQuery();
            while (res.next()) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error en login: " + e.getMessage());
        }
        return result;
    }

    public Boolean siExisteCorreo(String correo) {
        con = getConexion();
        Boolean result = false;
        final String SQL_Correo = "select * from usuario where correo=?";
        try {
            pstm = con.prepareStatement(SQL_Correo);
            pstm.setString(1, correo);
            res = pstm.executeQuery();
            while (res.next()) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al consultar existente" + e.getMessage());
        }
        return result;
    }

   public Boolean Recuperar(UsuarioDTO usuario) {
        con = getConexion();
        UsuarioDTO usuario2 = null;
        Boolean result = false;
        final String SQL_RECUP = "select pwd from usuario where correo=?";
        try {
            pstm = con.prepareStatement(SQL_RECUP);
            pstm.setString(1, usuario.getCorreo());
            res = pstm.executeQuery();
            while (res.next()) {
                usuario.setPwd(res.getString("pwd"));
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al consultar existente" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Boolean insert(UsuarioDTO t) {
        con = getConexion();
        Boolean result = false;
        final String SQL_INSERT = "insert into usuario values(?,?,?,?,?,?)";
        try {
            pstm = con.prepareStatement(SQL_INSERT);
            pstm.setString(1, t.getNombre());
            pstm.setString(2, t.getApellido());
            pstm.setString(3, t.getCorreo());
            pstm.setString(4, t.getPwd());
            pstm.setString(5, t.getDireccion());
            pstm.setString(6, t.getPerfil());
            int resultInsert = pstm.executeUpdate();
            if (resultInsert > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
        return result;
    }

    @Override
    public Boolean update(UsuarioDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDTO selectById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UsuarioDTO> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
