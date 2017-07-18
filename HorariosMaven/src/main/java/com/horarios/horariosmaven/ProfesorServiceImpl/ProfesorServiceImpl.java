package com.horarios.horariosmaven.ProfesorServiceImpl;



import com.horarios.horariosmaven.ProfesorService.ProfesorService;
import com.horarios.horariosmaven.bean.ProfesorBean;
import com.horarios.horariosmaven.dao.ProfesorDAO;
import com.horarios.horariosmaven.daoImpl.ProfesorDAOImpl;
import java.util.List;



public class ProfesorServiceImpl implements ProfesorService {
private ProfesorDAO  profesorDAO;
   
    @Override
    public List<ProfesorBean> ListProfesor() {
        profesorDAO = new ProfesorDAOImpl();
        return profesorDAO.ListProfesor();
    }

    @Override
    public void eliminarProfesor(int idProfesor) {
       profesorDAO = new ProfesorDAOImpl();
       profesorDAO.eliminarProfesor(idProfesor);
    }

    @Override
    public void adicionarProfesor(ProfesorBean pro) {
    profesorDAO = new ProfesorDAOImpl();
    profesorDAO.adicionarProfesor(pro);
    }

    @Override
    public void actualizarProfesor(ProfesorBean pro) {
       profesorDAO = new ProfesorDAOImpl();
       profesorDAO.actualizarProfesor(pro);
    }

    @Override
    public ProfesorBean buscarCodigo(int idProfesor) {
     profesorDAO = new ProfesorDAOImpl();
       return profesorDAO.buscarCodigo(idProfesor);
    }
    
}
