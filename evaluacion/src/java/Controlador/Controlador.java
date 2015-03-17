/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import dao.LibroDAO;
import dao.MultadoDAO;
import dao.PrestamoDAO;
import dto.MultadoDTO;
import dto.PrestamoDTO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author -ADMIN-
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("devolver") != null){
                int cc = Integer.parseInt( request.getParameter("txtUser").trim());
                int idLibro = Integer.parseInt( request.getParameter("txtLibro").trim() );
                int estado = Integer.parseInt( request.getParameter("estado").trim() );
                
                //PrestamoDTO prestado = PrestamoDAO.consultarPrestamo();
                
                PrestamoDTO p = PrestamoDAO.consultarPrestamoByUser(cc, idLibro);
                switch(estado) {
                   case 0:
                       // libro entregado correctamnete
                       
                       if(p != null){
                            int idPrestamo =  p.getIdPrestamo();
                            Date fechaDevolver = p.getFechaDevolucion();
                            Double multa = MultadoDAO.verificarMultaUser(fechaDevolver);
                            
                            boolean res = PrestamoDAO.cambiarEstadoPrestamo(2, idPrestamo);
                            if(res == true){
                                  if(multa != 0.0){
                                      MultadoDTO nm = new MultadoDTO(idPrestamo, null, multa);
                                      String multar = MultadoDAO.agregarNuevaMulta(nm);
                                      response.sendRedirect("index.jsp?msg=Usuario tiene multa por valor de "+multa );
                                  }else
                                      response.sendRedirect("index.jsp?msg=Registrada devolucion "+idPrestamo);
                            }else
                                    response.sendRedirect("index.jsp?msg= Error");
                            
                       }else{
                           response.sendRedirect("registrarDevolucion.jsp?msg=No hay prestamos pendientes");
                       }     
                       
                      break;
                   case 1:
                       // libro perdido
                       MultadoDTO nm = new MultadoDTO();
                       nm.setIdPrestamo(p.getIdPrestamo());
                       nm.setEstado(1);
                       nm.setValorTotal(50000.00);
                       String multar = MultadoDAO.agregarNuevaMulta(nm);
                       // cambiam ido o
                       boolean result = LibroDAO.cambiarEstadoLibro(idLibro, 2);
                       response.sendRedirect("index.jsp?msg=Valor perdida libro : "+nm.getValorTotal());
                       // generar multa
                       break;
                   case 2:
                       // libro dañado
                       MultadoDTO nmd = new MultadoDTO();
                       nmd.setIdPrestamo(p.getIdPrestamo());
                       nmd.setEstado(1);
                       nmd.setValorTotal(60000.00);
                       String multa = MultadoDAO.agregarNuevaMulta(nmd);
                       boolean rs = LibroDAO.cambiarEstadoLibro(idLibro, 1);
                       response.sendRedirect("index.jsp?msg=libro dañado, Multa : "+nmd.getValorTotal());                       
                      break;
        
                }
                
                
        }else if(request.getParameter("consultar") != null){
            int user = Integer.parseInt(request.getParameter("txtUser"));
                MultadoDTO nm = MultadoDAO.consultarMultasUsuarios(user);
               
                if(nm != null){
                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("pagar", nm);
                    response.sendRedirect("pagarmultas.jsp?user="+user);
                }else{
                    response.sendRedirect("pagarmultas.jsp?msg=Usuario no tiene multas pendientes");
                }
        }else{
            response.sendRedirect("index.jsp");
        }
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
