/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author -ADMIN-
 */
public class Conectar {
 
     protected static Connection con = null;
    
     private static void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
     }
    
    
    public synchronized static Connection getInstance(){
        if(con ==  null){
           conectar();
        }
        return con;
    }
    
   
    
}
