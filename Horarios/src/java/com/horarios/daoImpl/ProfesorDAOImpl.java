
package com.horarios.daoImpl;

import com.horarios.bean.ProfesorBean;
import com.horarios.conexion.Conexion;
import com.horarios.dao.ProfesorDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class ProfesorDAOImpl implements ProfesorDAO{
  private static final Logger logger = Logger.getLogger(ProfesorDAOImpl.class.
            getName());
    Conexion con;
    Connection cn;
    PreparedStatement st;
    private CallableStatement cs;
    ResultSet rs;
    Statement cmd;
    String sql="";
    @Override
    public List<ProfesorBean> ListProfesor() {
    
        ArrayList lista=new ArrayList();
        sql="SELECT  IDPROFESOR ,APPATERNO ,APPMATERNO ,NOMBRES,NACIMIENTO, DIRECCION ,REFERENCIA ,GENERO ,ESTADO  FROM PROFESORES";
        try{
         cn= Conexion.GetConnection();
         cmd=cn.createStatement();
         rs=cmd.executeQuery(sql);

        while(rs.next()){
        ProfesorBean profesor=new ProfesorBean();
        profesor.setIdProfesor(rs.getInt(1));
        profesor.setAppaterno(rs.getString(2));
        profesor.setApmaterno(rs.getString(3));
        profesor.setNombres(rs.getString(4));
        profesor.setDireccion(rs.getString(5));
        profesor.setFecNacimiento(rs.getString(6));
        profesor.setReferencia(rs.getString(7));
        profesor.setGenero(rs.getString(8));
        profesor.setEstado(rs.getString(9));
      
        lista.add(profesor);
        }
        
         Conexion.GetConnection().close();
        }catch(SQLException ex){
        ex.printStackTrace();

    }
    return lista;
    }

    @Override
    public void eliminarProfesor(int idProfesor) {
      sql="delete from profesores  where idProfesor=? ";
       try{
            st=Conexion.GetConnection().prepareStatement(sql);
            st.setInt(1, idProfesor);
            st.executeUpdate();

       }   catch(SQLException ex){
           ex.printStackTrace();
       }
    }

    @Override
    public void adicionarProfesor(ProfesorBean pro) {
          logger.info("insertar");
     sql=" call P_INSERTAR_PROFESOR(?,?,?,?,?,?,?,?)";
        try{

            con = new Conexion();
            cn = con.GetConnection();
            cn.setAutoCommit(false);
            cs = cn.prepareCall(sql);
          
            cs.setString(1,pro.getAppaterno());
            cs.setString(2,pro.getApmaterno());
            cs.setString(3,pro.getNombres());
            cs.setString(4,pro.getFecNacimiento());
            cs.setString(5,pro.getDireccion());
            cs.setString(6,pro.getReferencia());
            cs.setString(7,pro.getGenero());
            cs.setString(8,pro.getEstado());
            cs.executeUpdate();
           
            cn.commit();
            
                
            
 
        }  catch(SQLException ex){
           
            ex.getStackTrace();
        }   
    }

    @Override
    public void actualizarProfesor(ProfesorBean pro) {
     sql="UPDATE PROFESORES SET \n" +
                "APPATERNO =?,\n" +
                "APPMATERNO =?,\n" +
                "NOMBRES =?,\n" +
                "NACIMIENTO =?,\n" +
                "DIRECCION =?,\n" +
                "REFERENCIA =?,\n" +
                "GENERERO =?,\n" +
                "ESTADO=? WHERE \n" +
                "IDPROFESOR =?";
        try{

        st=
           Conexion.GetConnection().prepareStatement(sql);
            //relacionar cada ? con su valor

          
            st.setString(1,pro.getAppaterno());
            st.setString(2,pro.getApmaterno());
            st.setString(3,pro.getNombres());
            st.setString(4,pro.getFecNacimiento());
            st.setString(5,pro.getDireccion());
            st.setString(6,pro.getReferencia());
            st.setString(7,pro.getGenero());
            st.setString(8,pro.getEstado());
            st.setInt(9,pro.getIdProfesor());
            st.executeUpdate();//para grabar , modificar , anular

        }

    catch(SQLException e){
        e.getStackTrace();
    } 
    }

  @Override
  public ProfesorBean buscarCodigo(int idProfesor) {
    ProfesorBean pro=null;//inicializar como si la cuenta no existiese
    sql="SELECT  APPATERNO ,APPMATERNO ,NOMBRES,NACIMIENTO, DIRECCION ,REFERENCIA ,GENERO ,ESTADO  FROM PROFESORES WHERE IDPROFESOR='"+idProfesor+"'";

 try{
    st=Conexion.GetConnection().prepareStatement(sql); 
    rs=st.executeQuery();//ejecutar la consulta
   while(rs.next()){//si la cuenta existe procede a leerlo
    pro=new ProfesorBean(idProfesor,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)) ;
            }
   }catch(SQLException e){
     e.printStackTrace();
   }
  return pro;
        
 }
    
}
