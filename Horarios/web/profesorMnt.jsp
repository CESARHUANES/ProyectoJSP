<%-- 
    Document   : index
    Created on : 25-jul-2012, 15:06:33
    Author     : GC
--%>

<%@page import="com.horarios.bean.ProfesorBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    ProfesorBean profesor = (ProfesorBean) session.getAttribute("profesorActualizar");
    profesor = profesor == null ? new ProfesorBean() : profesor;
   
    String paterno = profesor.getAppaterno() == null ? "" : profesor.getAppaterno();
    String materno = profesor.getApmaterno() == null ? "" : profesor.getApmaterno();
    String nombres = profesor.getNombres() == null ? "" : profesor.getNombres();
    String direccion = profesor.getDireccion() == null ? "" : profesor.getDireccion();
    String fecNacimiento = profesor.getFecNacimiento() == null ? "" : profesor.getFecNacimiento();
    String referencia = profesor.getReferencia() == null ? "" : profesor.getReferencia();
    String genero = profesor.getGenero() == null ? "" : profesor.getGenero();
    String estado=profesor.getEstado() == null ? "" : profesor.getEstado();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de clientes</title>
        <script type="text/javascript">
            function insertar(){
           
            var paterno = document.getElementById("txtPaterno").value;
            var materno= document.getElementById("txtMaterno").value;
            var nombres = document.getElementById("txtNombres").value;
            var direccion = document.getElementById("txtDireccion").value;
            var referencia = document.getElementById("txtReferencia").value;
            var nacimiento=document.getElementById("txtFecNacimiento").value;
            var genero=document.getElementById("txtGenero").value;
            var estado=document.getElementById("txtEstado").value;  
                  
                  
                  
            document.frmMnt.action = "ClienteServlet?accion=insertar&paterno=" + paterno + 
            "&materno=" + materno + 
             "&nombres=" + nombres +
             "&direccion=" + direccion+
             "&referencia="+referencia+
             "&nacimiento="+nacimiento+
             "&genero="+genero+
             "&estado="+estado;
            document.frmMnt.submit();
                
            }
            
            function actualizar(id){
            var id = document.getElementById("txtId").value;
            var paterno = document.getElementById("txtPaterno").value;
            var materno= document.getElementById("txtMaterno").value;
            var nombres = document.getElementById("txtNombres").value;
            var direccion = document.getElementById("txtDireccion").value;
            var referencia = document.getElementById("txtReferencia").value;
            var nacimiento=document.getElementById("txtFecNacimiento").value;
            var genero=document.getElementById("txtGenero").value;
            var estado=document.getElementById("txtEstado").value;
            
                document.frmMnt.action = "ClienteServlet?accion=actualizar&id=" + id +
                "&paterno=" + paterno+ 
                "&materno=" + materno + 
                "&nombres=" + nombres +
                "&direccion=" + direccion+
                "&referencia="+referencia+
                "&nacimiento="+nacimiento+
                "&genero="+genero+
                "&estado="+estado;
                document.frmMnt.submit();
                
            }
            
            function cancelar(){
                document.location = "clienteLst.jsp";
            }
        </script>
    </head>
    <body>
        <form name="frmMnt" method="post">
          <table>
             
            <tr>
              <td>PATERNO:</td>
              <td><input name="text" type="text" id="txtPaterno" value="<%=paterno%>" /></td>
            </tr>
            <tr>
              <td>MATERNO:</td>
              <td><input name="materno" type="text" id="txtMaterno" value="<%=materno%>" /></td>
            </tr>
            <tr>
              <td>NOMBRES:</td>
              <td><input name="nombres" type="text" id="txtNombre" value="<%=nombres%>" /></td>
            </tr>
            <tr>
              <td>DIRECCION:</td>
              <td><input name="direccion" type="text" id="txtDireccion" value="<%=direccion%>" /></td>
            </tr>
             <tr>
              <td>REFERENCIA:</td>
              <td><input name="referencia" type="text" id="txtReferencia" value="<%=referencia%>" /></td>
            </tr>
            <tr>
              <td>FEC. NAC:</td>
              <td><input name="fechaNacimiento" type="date" id="txtFecNacimiento" value="<%=fecNacimiento%>" /></td>
            </tr>
             <tr>
              <td>GENERO:</td>
              <td><input name="sexo" type="text" id="txtGenero" value="<%=genero%>" /> 
              </td>
              
            </tr>
             <tr>
              <td>ESTADO:</td>
              <td><input name="estado" type="text" id="txtEstado" value="<%=estado%>" /> 
              </td>
           
            </tr>
            <tr>
              <td><input name="button" type="button" id="btnCancelar" onClick="cancelar()" value="Cancelar" />
              </td>
              <%if(session.getAttribute("profesorActualizar") == null){%>
              ${clienteActualizar}
              <td><input name="button" type="button" id="btnInsertar" onClick="insertar()" value="Insertar" />
              </td>
              <%}else{%>
              <td><input name="button" type="button" 
               id="btnActualizar" onClick="actualizar(<%=profesor.getIdProfesor()%>)" value="Actualizar" />
              </td>
              <%}%>
            </tr>
          </table>
        </form>
    </body>
</html>
