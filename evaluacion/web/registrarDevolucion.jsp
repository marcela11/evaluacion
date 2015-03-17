<%-- 
    Document   : registrarMulta
    Created on : 11/03/2015, 06:37:22 PM
    Author     : -ADMIN-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <ul>
            <a href="index.jsp">Inicio</a> |
            <a href="registrarDevolucion.jsp"> Registrar Devolucion </a> |
            <a href="pagarmultas.jsp">Pago multas </a> 
        </ul>
        <h1>Devolver Libro</h1>
        <form action="Controlador" method="POST">
            <table>
                <tr>
                    <td><label> Usuario </label> </td>
                    <td> <input type="text" name="txtUser" /> </td>
                </tr>
                <tr> 
                    <td> Libro </td>
                    <td> <input type="text" name="txtLibro" /> </td>
                </tr>
                <tr>
                    <td> Estado libro </td>
                 <td>   
                        <select name="estado">
                            <option selected="true" value="0"> Bueno </option>
                            <option value="1"> Perdido </option>
                            <option value="2"> Dañado  </option>
                       </select>
                 </td> 
                </tr>
                <tr>
                    <td> <input  type="submit" name="devolver" value="Guardar" /> </td>
                </tr>
                
                <%
                    if(request.getParameter("msg") != null){ %>
                    <tr>
                        <td style="color: #009999"> <% out.println(request.getParameter("msg") ); %> </td>
                    </tr>
                 <%   }%>
            </table>
            
        </form>
        
        
    </body>
</html>
