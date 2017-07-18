<%-- 
    Document   : index
    Created on : 25-jul-2012, 15:06:33
    Author     : GC
--%>

<%@page import="com.horarios.bean.ProfesorBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Profesor</title>
        <script type="text/javascript">
            function nuevo(){
                document.location = "profesorMnt.jsp";
            }
            
            function buscar(){
                var id = document.getElementById("txtId").value;
                document.frmLst.action = "ProfesorServlet?accion=buscar&id=" + id;
                document.frmLst.submit();
            }
            
            function obtenerPorId(id){
                document.frmLst.action = "ProfesorServlet?accion=obtenerPorId&id=" + id;
                document.frmLst.submit();
            }
            
            function eliminar(id){
                document.frmLst.action = "ProfesorServlet?accion=eliminar&id=" + id;
                document.frmLst.submit();
            }
        </script>
    </head>
    <body>
        <form name="frmLst" method="post">
            <table>
                <tr>
                    <td colspan="3">&nbsp;</td>
                </tr>
                <tr>
                    <td>CODIGO:</td>
                    <td colspan="2"><input type="text" id="txtId" size="50" /></td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <input type="button" value="Buscar" onClick="buscar()" id="btnBuscar" />
                        <input type="button" value="Nuevo" onClick="nuevo()" id="btnNuevo" />
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        ${msgListado}
                        ${msgPostOperacion}
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <table border="1">
                            <tr align="center">
                                <td width="125px"><b>ID</b></td>
                                <td width="150px"><b>PATERNO</b></td>
                                <td width="150px"><b>MATERNO</b></td>
                                <td width="100px"><b>NOMBRES</b></td>
                                <td width="125px"><b>NACIMIENTO</b></td>
                                <td width="150px"><b>DIRECCION</b></td>
                                <td width="150px"><b>REFERENCIA</b></td>
                                <td width="100px"><b>GENERO</b></td>
                                <td width="100px"><b>ESTADO</b></td>
								<td width="75px"><b>Operaciones</b></td>
                            </tr>
                            <%if(session.getAttribute("listaProfesor") != null){
                                List<ProfesorBean> lstProfesor = (List<ProfesorBean>)session.
                                        getAttribute("listaProfesor");
                                for(int i=0; i < lstProfesor.size(); i++){
                                    ProfesorBean profesor = lstProfesor.get(i);
                            %>
                            <tr>
                                <td><%=profesor.getIdProfesor()%></td>
                                <td><%=profesor.getAppaterno()%></td>
                                <td><%=profesor.getApmaterno()%></td>
                                <td><%=profesor.getNombres()%></td>
                                <td><%=profesor.getFecNacimiento()%></td>
                                <td><%=profesor.getDireccion()%></td>
                                <td><%=profesor.getReferencia()%></td>
                                <td><%=profesor.getGenero()%></td>
                                <td><%=profesor.getEstado()%></td>
                                <td>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <a onClick="obtenerPorId(<%=profesor.getIdProfesor()%>)" href="#">A</a>
                                    &nbsp;&nbsp;
                                    <a onClick="eliminar(<%=profesor.getIdProfesor()%>)" href="#">E</a>
                                </td>
                            </tr>
                            <%  }
                            }%>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
