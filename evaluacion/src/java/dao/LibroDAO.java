/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Modelo.Conectar;
import dto.LibroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author -ADMIN-
 */
public class LibroDAO {
    
    private static ResultSet rs = null;
    private static PreparedStatement pst = null;
    protected  static Connection  cnn = Conectar.getInstance();
    
    public static String crearLibro(LibroDTO newLibro) {
        String sal = "";
        int res = 0;
        try {

            pst = cnn.prepareStatement("INSERT INTO libros VALUES (null,?,?,?)");
            pst.setInt(1, newLibro.getIdLibro());
            pst.setString(2, newLibro.getIsbn());
            pst.setString(3, newLibro.getTitulo());
            pst.setInt(4, newLibro.getEstado());
            res = pst.executeUpdate();
            if (res != 0) {
                sal = " Registro exitoso" + res + "filas afectadas";
            } else {
                sal = "Ha ocurrido un problema ";
            }
        } catch (SQLException sql) {
            sal = "Ha ocurrido lo siguiente " + sql.getMessage();
        }
        return sal;
    }

    public static String eliminarbyId(int idlibro) {
        LibroDTO librodto = new LibroDTO();
        int resultado = 0;
        String salida = "";
        try {
            pst = cnn.prepareStatement("DELETE FROM libros WHERE idLibro=?;");
            pst.setInt(1, idlibro);
            resultado = pst.executeUpdate();

            if (resultado != 0) {
                salida = "Registro " + resultado + " eliminado. Exitosamente";
            }
        } catch (SQLException sqle) {
            salida = "Ocurrio esta excepción " + sqle.getMessage();
        }
        return salida;

    }

    public static String modificarLibro(LibroDTO modLibro){
        String fuera = "";
        int res = 0;
        try {
            pst = cnn.prepareStatement("UPDATE  libros SET isbn=?, titulo=?, estado=? WHERE idLibro=?;");

            pst.setString(1, modLibro.getIsbn());
            pst.setString(2, modLibro.getTitulo());
            pst.setInt(3, modLibro.getEstado());
            pst.setInt(4, modLibro.getIdLibro());
            res = pst.executeUpdate();
            if (res != 0) {
                fuera = "ACTUALIZACION REALIZADA EXITOSAMENTE";
            } else {
                fuera = "ERROR AL ACTUALIZAR EL LIBRO";
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la base de datos" + sqle.getSQLState() + "y" + sqle.getMessage());
        }
        return fuera;

    }

    public static LinkedList<LibroDTO> listarLibros() {
        LinkedList<LibroDTO> resultado = new LinkedList();
        try {
            String sql = "  SELECT idlibro, isbn, titulo, estado "
                    + "FROM libros; ";
            pst = cnn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {                    
                    LibroDTO librodto=new LibroDTO();
                    librodto.setIdLibro(rs.getInt("idlibro"));
                    librodto.setIsbn(rs.getString("isbn"));
                    librodto.setTitulo(rs.getString("titulo"));
                    librodto.setEstado(rs.getInt("estado"));                    
                    resultado.add(librodto);
                }
            } else {
                System.out.println("No se encuetran registros ... ");
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los elementos " + ex.getSQLState() + " - " + ex.getMessage());
        }
        return resultado;
    }
    
    public static LinkedList<LibroDTO> listarLibros(int estado) {
        LinkedList<LibroDTO> resultadoLibro = new LinkedList();
        try {
            String sql = "  SELECT idlibro, isbn, titulo, estado "
                    + "FROM libros; ";
            pst = cnn.prepareStatement(sql);
             pst.setInt(1, estado);
            rs = pst.executeQuery();           
            if (rs != null) {
                while (rs.next()) {                    
                    LibroDTO librodto=new LibroDTO();
                    librodto.setIdLibro(rs.getInt("idlibro"));
                    librodto.setIsbn(rs.getString("isbn"));
                    librodto.setTitulo(rs.getString("titulo"));
                    librodto.setEstado(rs.getInt("estado"));                    
                    resultadoLibro.add(librodto);
                }
            } else {
                System.out.println("No se encuetran registros ... ");
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los elementos " + ex.getSQLState() + " - " + ex.getMessage());
        }
        return resultadoLibro;
    }
    
    public static boolean cambiarEstadoLibro(int idLibro, int estado){
        boolean salida = false;    
           String sql = "update libros set estado = ? where idlibro = ?";
           
        try {
            pst = cnn.prepareStatement(sql);
            pst.setInt(1, estado);
            pst.setInt(2, idLibro);
            int  res = pst.executeUpdate();
            if(res > 0)
                salida = true;
            
        } catch (SQLException ex) {
            salida = false;
        }
        
        return salida;
    }
    
}
