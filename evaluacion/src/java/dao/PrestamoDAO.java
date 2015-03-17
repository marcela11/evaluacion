/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Modelo.Conectar;
import dto.PrestamoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author -ADMIN-
 */
public class PrestamoDAO {
    
   static PreparedStatement pstmt = null;
   static ResultSet rs = null;
   static Connection cnn = cnn = Conectar.getInstance();
   static int resultado = 0;
    static String salida = "";
    
    
    public static String modificarPrestamo(PrestamoDTO prestamo){
        try{
            String querryModificar = "UPDATE prestamos SET userId=?, libroId=?, estado=? WHERE idprestamo=?";
            pstmt = cnn.prepareStatement(querryModificar);
            pstmt.setInt(1, prestamo.getUsuarioId());
            pstmt.setInt(2, prestamo.getLibroId());
            pstmt.setInt(3, prestamo.getEstado());
            pstmt.setInt(4, prestamo.getIdPrestamo());
            resultado = pstmt.executeUpdate();
            if (resultado != 0) {
                salida = "La modificación ha sido satisfactoria. ";
            }else{
                salida = "No se logro la modificación.";
            }
        }catch(SQLException sqle){
            salida = "Ha ocurrido lo siguiente. "+sqle.getMessage();
        }
        return salida;
    }
    
    public static boolean cambiarEstadoPrestamo(int estado, int idPrestamo){
        boolean res = false;
        
        String sql = "UPDATE prestamos SET estado= ? WHERE idprestamo= ?";
       try {
           pstmt = cnn.prepareStatement(sql);
           pstmt.setInt(1, estado);
           pstmt.setInt(2, idPrestamo);
           int x = pstmt.executeUpdate();
           if(x > 0)
               res = true;
           
           
       } catch (SQLException ex) {
           res = false;
       }
        
        
        return res;
    }
    
    public static boolean consultarMoraFechasaDevoluciones(int iduser){
        boolean salida = false;
        String sql = "select idprestamo from prestamos where userId = ? AND estado = 1 AND  fechaDevolucion < now()";
       try {
           pstmt = cnn.prepareStatement(sql);
           pstmt.setInt(1, iduser);
           rs = pstmt.executeQuery();
           if(rs != null){
               salida = true;
           }
       } catch (SQLException ex) {
           salida = false;
       }
//        
        return salida;
    }
    
    public static List<PrestamoDTO> consultarPrestamos(){
        LinkedList<PrestamoDTO> prestamos = new LinkedList<PrestamoDTO>();
        try {
            String query = "SELECT  idprestamo, userId, libroId, estado FROM prestamos ";
            pstmt = cnn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                PrestamoDTO prestamo = new PrestamoDTO();
                prestamo.setIdPrestamo(rs.getInt("idprestamo"));
                prestamo.setUsuarioId(rs.getInt("userId"));
                prestamo.setLibroId(rs.getInt("libroId"));
                prestamo.setEstado(rs.getInt("estado"));
                prestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            prestamos = null;
        }

        return prestamos;
    }
    
    public static PrestamoDTO consultarPrestamoByUser(int user, int libro){
        PrestamoDTO prestar = null;
        
        String sql = "select p.idprestamo, p.libroid, p.estado, p.fechaDevolucion, p.fechaPrestamo from prestamos p where p.userId = ? and p.libroid = ? and p.estado = 1";
       try {
           pstmt = cnn.prepareStatement(sql);
           pstmt.setInt(1, user);
           pstmt.setInt(2, libro);
           rs = pstmt.executeQuery();
           if(rs != null){
               while(rs.next()){
                   prestar = new PrestamoDTO(rs.getInt("idprestamo"), user, rs.getInt("libroid"), rs.getInt("estado"), rs.getDate("fechaPrestamo"), rs.getDate("fechaDevolucion"));                            
               }
           }
       } catch (SQLException ex) {
           prestar =  null;
       }
        
        return prestar;
    }
    
    public static int consultarCantidadPrestamosByUser(int id){
        int res = 0;
        String sql = "select count(idprestamo) as 'contar' from prestamos \n" +
                        "inner join usuarios on prestamos.userId = usuarios.iduser where iduser = ?";
        
       try {
           pstmt = cnn.prepareStatement(sql);
           pstmt.setInt(1, id);
           rs = pstmt.executeQuery();
           if(rs != null){
               while(rs.next()){
                   res = rs.getInt("contar");
               }
           }
           
       } catch (SQLException ex) {
           res = 0;
       }
  
        return res;
    }
    
    
//    public List<PrestamoDTO> consultarPrestamos()  {
//        LinkedList<PrestamoDTO> prestamos = new LinkedList();
//        try {
//            String query = "SELECT  idprestamo, userId, libroId, estado FROM prestamos ";
//            pstmt = cnn.prepareStatement(query);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                PrestamoDTO prestamo = new PrestamoDTO();
//                prestamo.setIdPrestamo(rs.getInt("idprestamo"));
//                prestamo.setUsuarioId(rs.getInt("userId"));
//                prestamo.setLibroId(rs.getInt("libroId"));
//                prestamo.setEstado(rs.getInt("estado"));
//                prestamos.add(prestamo);
//            }
//        } catch (SQLException ex) {
//            System.out.println("Se ha producido el siguiente error. "+ex.getMessage());
//        } finally {
//            try {
//                pstmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return prestamos;
//    }
    
    public static String eliminarOferta(int id) {
        try {
            pstmt = cnn.prepareStatement("DELETE FROM prestamos WHERE idprestamo = ?;");
            pstmt.setInt(1, id);
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "El prestamo " + resultado + " ha sido eliminado exitosamente";
            }else {
                salida = "No se pudo eliminar el registro.";
            }
        } catch (SQLException sqle) {
            salida = "Ocurrio esta excepción " + sqle.getMessage();
        }
        return salida;
    }
    
    public static PrestamoDTO consultarPrestamo(int id)  {
        PrestamoDTO prestamo = null;
        try {
            String query = "SELECT  idprestamo, userId, libroId, estado FROM prestamos ";
            pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                prestamo = new PrestamoDTO();
                prestamo.setIdPrestamo(rs.getInt("idprestamo"));
                prestamo.setUsuarioId(rs.getInt("userId"));
                prestamo.setLibroId(rs.getInt("libroId"));
                prestamo.setEstado(rs.getInt("estado"));
            }
        } catch (SQLException ex) {
            System.out.println("Se ha producido el siguiente error. "+ex.getMessage());
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prestamo;
    }
    
    public static String insertarPrestamo(PrestamoDTO prestamo){
        try{
            String querry = "INSERT INTO prestamos( userid, libroid, estado, fechaPrestamo, fechaDevolucion)  VALUES (?, ?, 1, now(), date_add(current_date(), interval 3 day) )";
            pstmt = cnn.prepareStatement(querry);
            pstmt.setInt(1, prestamo.getUsuarioId());
            pstmt.setInt(2, prestamo.getLibroId());
            resultado = pstmt.executeUpdate();
            if (resultado != 0) {
                salida = "Se ha registrado el prestamo";
            }else{
                salida = "No se pudo registrar";
            }
        }catch (SQLException ex){
            salida = "Ha ocurrido la siguiente excepción! "+ex.getMessage();
        }
        return salida;
    } 
    
    
}
