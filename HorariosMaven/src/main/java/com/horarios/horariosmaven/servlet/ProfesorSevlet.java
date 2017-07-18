package com.horarios.horariosmaven.servlet;



import com.horarios.horariosmaven.ProfesorService.ProfesorService;
import com.horarios.horariosmaven.ProfesorServiceImpl.ProfesorServiceImpl;
import com.horarios.horariosmaven.bean.ProfesorBean;
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


@WebServlet(name = "ProfesorSevlet", urlPatterns = {"/ProfesorSevlet"})
public class ProfesorSevlet extends HttpServlet {
private static Logger logger = Logger.getLogger(ProfesorSevlet.
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
           
            mensaje = "Cliente insertado correctamente.";
           
                
            
            sesion = request.getSession();
            sesion.removeAttribute("msgPostOperacion");
            sesion.removeAttribute("listaClientes");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("clienteActualizar");
            sesion.setAttribute("msgPostOperacion", mensaje);
            buscar(request, response);
        }catch(Exception e){
            mensaje = "Error al insertar cliente.";
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
           
            mensaje = "Cliente eliminado correctamente.";
            sesion = request.getSession();
            sesion.removeAttribute("msgPostOperacion");
            sesion.removeAttribute("listaClientes");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("clienteActualizar");
            sesion.setAttribute("msgPostOperacion", mensaje);
            buscar(request, response);
        }catch(Exception e){
              mensaje = "Error al eliminar cliente.";
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
            mensaje = "Cliente actualizado correctamente.";
            sesion = request.getSession();
            sesion.removeAttribute("msgPostOperacion");
            sesion.removeAttribute("listaClientes");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("clienteActualizar");
            sesion.setAttribute("msgPostOperacion", mensaje);
            buscar(request, response);
        }catch(Exception e){
             mensaje = "Error al actualizar.";
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
            sesion.removeAttribute("listaClientes");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("clienteActualizar");
            sesion.setAttribute("clienteActualizar", profesor);
            response.sendRedirect("clienteMnt.jsp");
        }catch(Exception e){
            logger.info("obtenerPorId: " + e.getMessage());
        }   
   }
   protected void listar(HttpServletRequest request, HttpServletResponse response){
      logger.info("buscar");
       
        try{
            sesion = request.getSession();
            sesion.removeAttribute("listaClientes");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("clienteActualizar");
            if(sesion.getAttribute("msgPostOperacion") != null){
              
            }
            profesorService = new ProfesorServiceImpl();
            List<ProfesorBean> lstCliente = profesorService.ListProfesor();
            if(lstCliente.size() > 0){
                sesion.setAttribute("listaClientes", lstCliente);
            }else{
                mensaje = "No existen clientes.";
                sesion.setAttribute("msgListado", mensaje);
            }
            response.sendRedirect("clienteLst.jsp");
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
