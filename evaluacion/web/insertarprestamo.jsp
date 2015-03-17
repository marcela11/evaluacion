<%-- 
    Document   : insertarprestamo
    Created on : 11-mar-2015, 19:12:59
    Author     : Mona
--%>

<%@page import="com.prestamos.dto.LibroDTO"%>
<%@page import="com.prestamos.dao.LibroDAO"%>
<%@page import="com.prestamos.dto.UsuarioDTO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.prestamos.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar prestamo</title>
        <%
            UsuarioDAO con = new UsuarioDAO();
            LinkedList<UsuarioDTO> usuarios = new LinkedList();
            usuarios = (LinkedList<UsuarioDTO>) con.consultarUsuarios();
        %>
        <%
            LibroDAO lib = new LibroDAO();
            LinkedList<LibroDTO> libros = new LinkedList();
            libros = (LinkedList<LibroDTO>) lib.consultarLibros();
        %>

    </head>
    <body>
        <h1>Insertar prestamo</h1>        

        <form name="registrarPrestamo" action="../cp" method="POST">
            <label for="txtNombre">Nombre del usuario:</label>
            <select for="txtNombre">
                <%for (UsuarioDTO u : usuarios) {%>
                <option value="<%if (u != null) {
                        out.print(u.getIdUsuario());
                    }%>"><%if (u != null) {
                            out.print(u.getNombreCompleto());
                        }
                    %></option>
                    <%
                        }
                    %>    
            </select><br>
            <label for="txtLibro">Nombre del libro</label>
            <select for="txtLibro">
                <%for (LibroDTO l : libros) {%>
                <option value="<%if (l != null) {
                        out.print(l.getIdLibro());
                    }%>"><%if (l != null) {
                            out.print(l.getTitulo());
                        }
                    %></option>
                    <%
                        }
                    %>    
            </select><br>
            
            <input type="hidden" name="rPrestamo" id="rPrestamo" value="" />
            <input type="submit" value="Registrar" name="btnRegistrarPrestamo" id="btnRegistrarPrestamo" />
            
            <%if (request.getParameter("msg") != null) {
                    out.println("msg");
                }
            %>
        </form>
    </body>
</html>
