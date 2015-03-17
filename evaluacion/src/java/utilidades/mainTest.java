/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import dao.MultadoDAO;
import dao.PrestamoDAO;
import dto.PrestamoDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




/**
 *
 * @author -ADMIN-
 */
public class mainTest {
    
    public static void main(String []args){
        
        int x = MultadoDAO.consultarMultasUsuario(3);
        
        System.out.println(""+x);
                
    }
    
    
    
    
}
