/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import dao.MultadoDAO;
import dao.PrestamoDAO;
import dto.PrestamoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author -ADMIN-
 */
public class Prestamo extends HttpServlet {

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
        
            if(request.getParameter("registro") != null){
                int user = Integer.parseInt(request.getParameter("txtUser").trim());
                int idLibro = Integer.parseInt(request.getParameter("txtLibro"));
                
                // consultar prestamos
                int prestamos = PrestamoDAO.consultarCantidadPrestamosByUser(user);
                if(prestamos == 2 || prestamos > 2){
                    response.sendRedirect("index.jsp?msg= Ya tiene 2 libros prestados");
                }else{
                    int multado = MultadoDAO.consultarMultasUsuario(user);
                    if(multado != 0){
                        response.sendRedirect("index.jsp?msg=Usuario tiene multas por pagar");
                    }else{
                        boolean moroso = PrestamoDAO.consultarMoraFechasaDevoluciones(user);
                        if(moroso == true) {
                            response.sendRedirect("index.jsp?msg=Usuario Moroso, fecha de prestamo vencido");
                        }else{
                            PrestamoDTO prestar = new PrestamoDTO(user, idLibro);
                            String salida = PrestamoDAO.insertarPrestamo(prestar);
                            response.sendRedirect("index.jsp?msg= Prestamo registrado!");
                          }
                    }
                }
                
              
            }else{
                response.sendRedirect("index.jsp?msg= no puede ingresar");
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
