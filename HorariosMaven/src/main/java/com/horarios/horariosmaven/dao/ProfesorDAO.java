
package com.horarios.horariosmaven.dao;


import com.horarios.horariosmaven.bean.ProfesorBean;
import java.util.List;


public interface ProfesorDAO {
      public  List<ProfesorBean> ListProfesor();
      public  void eliminarProfesor(int idProfesor);
      public void adicionarProfesor(ProfesorBean pro);
      public void actualizarProfesor(ProfesorBean pro);
      public ProfesorBean buscarCodigo(int idProfesor);
}
