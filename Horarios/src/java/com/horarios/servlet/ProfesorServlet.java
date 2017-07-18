
package com.horarios.servlet;

import ProfesorService.ProfesorService;
import ProfesorServiceImpl.ProfesorServiceImpl;
import com.horarios.bean.ProfesorBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ProfesorServlet", urlPatterns = {"/ProfesorServlet"})
public class ProfesorServlet extends HttpServlet {
private static Logger logger = Logger.getLogger(ProfesorServlet.
            class.getName());
    private ProfesorService profesorService;
    private ProfesorBean profesor;
  
    private String mensaje = null;
    private HttpSession sesion;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String accion=request.getParameter("accion");
         logger.info("processRequest: " + accion);
        try {
           if(accion!=null){
            if (accion.equals("insertar")) {
                insertar(request, response);
                return;
            }
            if (accion.equals("buscar")) {
                buscar(request, response);
                return;
            }
            if (accion.equals("listar")) {
                listar(request, response);
                return;
            }
            if (accion.equals("actualizar")) {
                actualizar(request, response);
                return;
            }
            if (accion.equals("eliminar")) {
                eliminar(request, response);
            }    
           }
        } finally {            
            out.close();
        }
    }
   protected void insertar(HttpServletRequest request, HttpServletResponse response){
        logger.info("insertar");
        String paterno = request.getParameter("paterno") == null ? "" : 
                request.getParameter("paterno");
        String materno = request.getParameter("materno") == null ? "" : 
                request.getParameter("materno");
        String nombres = request.getParameter("nombres") == null ? "" : 
                request.getParameter("nombres");
        String nacimiento = request.getParameter("nacimiento") == null ? "" : 
                request.getParameter("nacimiento");
        String direccion = request.getParameter("direccion") == null ? "" : 
                request.getParameter("direccion");
        String referencia = request.getParameter("referencia") == null ? "" : 
                request.getParameter("referencia");
        String genero = request.getParameter("genero") == null ? "" : 
                request.getParameter("genero");
        String estado = request.getParameter("estado") == null ? "" : 
                request.getParameter("estado");
        try{
            profesor = new ProfesorBean();
            profesor.setAppaterno(paterno);
            profesor.setApmaterno(materno);
            profesor.setNombres(nombres);
            profesor.setFecNacimiento(nacimiento);
            profesor.setDireccion(direccion);
            profesor.setReferencia(referencia);
            profesor.setGenero(genero);
            profesor.setEstado(estado);
            profesorService = new ProfesorServiceImpl();
            profesorService.adicionarProfesor(profesor);
           
            mensaje ="Profesor  insertado correctamente.";
           
                
            
            sesion = request.getSession();
            sesion.removeAttribute("msgPostOperacion");
            sesion.removeAttribute("listaProfesor");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("profesorActualizar");
            sesion.setAttribute("msgPostOperacion", mensaje);
            buscar(request, response);
        }catch(Exception e){
            mensaje = "Error al insertar profesor.";
            logger.info("insertar: " + e.getMessage());
        } 
   }
   protected void eliminar(HttpServletRequest request, HttpServletResponse response){
       logger.info("eliminar");
        int id = Integer.parseInt(request.getParameter("id") == null ? "0" : 
                request.getParameter("id"));
        try{
            profesorService = new ProfesorServiceImpl();
            profesorService.eliminarProfesor(id);
           
            mensaje = "Profesor eliminado correctamente.";
            sesion = request.getSession();
            sesion.removeAttribute("msgPostOperacion");
            sesion.removeAttribute("listaProfesor");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("profesorActualizar");
            sesion.setAttribute("msgPostOperacion", mensaje);
            buscar(request, response);
        }catch(Exception e){
              mensaje = "Error al eliminar profesor.";
            logger.info("eliminar: " + e.getMessage());
        }
   }
   protected void actualizar(HttpServletRequest request, HttpServletResponse response){
   int id = Integer.parseInt(request.getParameter("id") == null ? "0" : 
                request.getParameter("id"));
        String paterno = request.getParameter("paterno") == null ? "" : 
                request.getParameter("paterno");
        String materno = request.getParameter("materno") == null ? "" : 
                request.getParameter("materno");
        String nombres = request.getParameter("nombres") == null ? "" : 
                request.getParameter("nombres");
        String nacimiento = request.getParameter("nacimiento") == null ? "" : 
                request.getParameter("nacimiento");
        String direccion = request.getParameter("direccion") == null ? "" : 
                request.getParameter("direccion");
        String referencia = request.getParameter("referencia") == null ? "" : 
                request.getParameter("referencia");
        String genero = request.getParameter("genero") == null ? "" : 
                request.getParameter("genero");
        String estado = request.getParameter("estado") == null ? "" : 
                request.getParameter("estado");
        try{
            profesor = new ProfesorBean();
            profesor.setIdProfesor(id);
            profesor.setAppaterno(paterno);
            profesor.setApmaterno(materno);
            profesor.setNombres(nombres);
            profesor.setFecNacimiento(nacimiento);
            profesor.setDireccion(direccion);
            profesor.setReferencia(referencia);
            profesor.setGenero(genero);
            profesor.setEstado(estado);
            profesorService = new ProfesorServiceImpl();
            profesorService.actualizarProfesor(profesor);
            mensaje = "Profesor actualizado correctamente.";
            sesion = request.getSession();
            sesion.removeAttribute("msgPostOperacion");
            sesion.removeAttribute("listaProfesor");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("profesorActualizar");
            sesion.setAttribute("msgPostOperacion", mensaje);
            buscar(request, response);
        }catch(Exception e){
             mensaje = "Error al actualizar profesor.";
            logger.info("actualizar: " + e.getMessage());
        }    
   }
   protected void buscar(HttpServletRequest request, HttpServletResponse response){
     int id = Integer.parseInt(request.getParameter("id") == null ? "0" : 
                request.getParameter("id"));
        try{
            profesorService = new ProfesorServiceImpl();
            profesor = profesorService.buscarCodigo(id);
            sesion = request.getSession();
            sesion.removeAttribute("msgPostOperacion");
            sesion.removeAttribute("listaProfesor");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("profesorActualizar");
            sesion.setAttribute("profesorActualizar", profesor);
            response.sendRedirect("profesorMnt.jsp");
        }catch(Exception e){
            logger.info("obtenerPorId: " + e.getMessage());
        }   
   }
   protected void listar(HttpServletRequest request, HttpServletResponse response){
      logger.info("buscar");
       
        try{
            sesion = request.getSession();
            sesion.removeAttribute("listaProfesor");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("profesorActualizar");
            if(sesion.getAttribute("msgPostOperacion") != null){
              
            }
            profesorService = new ProfesorServiceImpl();
            List<ProfesorBean> lstCliente = profesorService.ListProfesor();
            if(lstCliente.size() > 0){
                sesion.setAttribute("listaProfesor", lstCliente);
            }else{
                mensaje = "No existen clientes.";
                sesion.setAttribute("msgListado", mensaje);
            }
            response.sendRedirect("profesorLst.jsp");
        }catch(Exception e){
            logger.info("buscar: " + e.getMessage());
        }  
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
