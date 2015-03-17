<%-- 
    Document   : index
    Created on : 12/03/2015, 11:34:24 AM
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
            <a href="pagarmultas.jsp">Pago Multas </a> 
        </ul>
        
        <h1> Registro Prestamo  </h1>
        <form action="Prestamo" method="post">
            <table>
                <tr>
                    <td><label> Usuario </label> </td>
                    <td> <input type="text" name="txtUser" /> </td>
                </tr>
                <tr>
                    <td><label> Libro </label> </td>
                    <td> <input type="text" name="txtLibro" /> </td>
                </tr>
                <tr>
                    <td><input type="submit" name="registro" value="Registrar"/>  </td>
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
