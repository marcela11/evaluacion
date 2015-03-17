/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import dao.MultadoDAO;
import dto.MultadoDTO;

/**
 *
 * @author -ADMIN-
 */
public class IMultas {
    
    public static boolean pagarMultaLibro(int multa){
        return MultadoDAO.pagoMulta(multa);
    }
    
    public static String crearMultaUsuario(MultadoDTO m){
        return MultadoDAO.agregarNuevaMulta(m);
    }
    
    public static int verificarMultasUsuario(int idUsu){
        return MultadoDAO.consultarMultasUsuario(idUsu);
    }
    
    public static MultadoDTO buscarMulta(int multa){
        return MultadoDAO.consultarMulta(multa);
    }
    
    
}
