package com.horarios.horariosmaven.daoImpl;




import com.horarios.horariosmaven.bean.ProfesorBean;
import com.horarios.horariosmaven.conexion.Conexion;
import com.horarios.horariosmaven.dao.ProfesorDAO;
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
    Connection cn;
    PreparedStatement st;
    ResultSet rs;
    Statement cmd;
    String sql="";
    @Override
    public List<ProfesorBean> ListProfesor() {
    
        ArrayList lista=new ArrayList();
        sql="SELECT  IDPROFESOR ,APPATERNO ,APMATERNO ,NOMBRES,NACIMIENTO, DIRECCION ,REFERENCIA ,GENERO ,ESTADO  FROM PROFESOR";
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
      sql="delete from profesor  where idProfesor=? ";
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
     sql="insert into profesor values(?,?,?,?,?,?,?,?,?)";
        try{

            st= Conexion.GetConnection().prepareStatement(sql);
            st.setInt(1,pro.getIdProfesor());
            st.setString(2,pro.getAppaterno());
            st.setString(3,pro.getApmaterno());
            st.setString(4,pro.getNombres());
            st.setString(5,pro.getFecNacimiento());
            st.setString(6,pro.getDireccion());
            st.setString(7,pro.getReferencia());
            st.setString(8,pro.getGenero());
            st.setString(9,pro.getEstado());
            st.executeUpdate();
 
        }  catch(SQLException ex){

            ex.getStackTrace();
        }    }

    @Override
    public void actualizarProfesor(ProfesorBean pro) {
     sql="UPDATE PROFESOR SET \n" +
                "APPATERNO =?,\n" +
                "APMATERNO =?,\n" +
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
    sql="SELECT  APPATERNO ,APMATERNO ,NOMBRES,NACIMIENTO, DIRECCION ,REFERENCIA ,GENERO ,ESTADO  FROM PROFESOR WHERE IDPROFESOR='"+idProfesor+"'";

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
