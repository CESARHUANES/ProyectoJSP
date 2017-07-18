<%-- 
    Document   : index
    Created on : 25-jul-2012, 15:06:33
    Author     : GC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de clientes</title>
    </head>
    <body>
        <form method="post" action="ProfesorServlet?accion=buscar">
            <table width="100%">
                <tr>
                    <td align="center">
                        <h3>Bienvenido a nuestra primera aplicación <br />web con Java.</h3>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input type="submit" value="Ir a listar clientes">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
