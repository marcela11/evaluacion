<%-- 
    Document   : pagarmultas
    Created on : 12/03/2015, 08:02:35 PM
    Author     : -ADMIN-
--%>

<%@page import="javax.websocket.Session"%>
<%@page import="dto.MultadoDTO"%>
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
        
        <h1> Pagos de  Multas  </h1>
        
        <%
            HttpSession sesion = request.getSession(false);
            if(sesion.getAttribute("pagar") == null) { %>
        
        <form action="Controlador" method="post">
            <table>
                <tr>
                    <td><label> Usuario </label> </td>
                    <td> <input type="text" name="txtUser" /> </td>
                </tr>
                <tr>
                    <td><input type="submit" name="consultar" value="Consultar"/>  </td>
                </tr>
                <%
                    if(request.getParameter("msg") != null){ %>
                        <tr>
                            <td style="color: #009999"> <% out.println(request.getParameter("msg") ); %> </td>
                        </tr>
                 <%   }  %>
                
            </table>    
                
        </form>
                                  
       <% }else{ 
            
            MultadoDTO mt = (MultadoDTO) sesion.getAttribute("pagar");
            int user = Integer.parseInt(request.getParameter("user"));
       %>
       
                 <table border="1">
                     <th> Usuario </th>
                     <th> Valor Multa </th>
                     <th> Fecha Multa </th>
                     <th> Pagar </th>
                     <tr>
                         <td> <%= user  %></td>
                         <td> <%= mt.getValorTotal() %>  </td>
                         <td> <%= mt.getFechaMulta()  %>  </td>
                         <td> <a href="#">  </a> </td>
                     </tr>
                     
                 </table>
                 
                 <style type="text/css"> 
                     th{
                         min-width: 90px;
                         background-color: #ccccff;
                     }
                 </style>
        
          <% } %>
                 
    </body>
</html>
