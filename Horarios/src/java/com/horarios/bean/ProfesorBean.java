
package com.horarios.bean;


public class ProfesorBean {
    private int idProfesor=0;
    private String appaterno="";
    private String apmaterno="";
    private String nombres="";
    private String fecNacimiento="";
    private String direccion="";
    private String referencia="";
    private String genero="";
    private String estado="";
    public ProfesorBean(){
        
    }
    public ProfesorBean(  int idProfesor,
    String appaterno,
    String apmaterno,
    String nombres,
    String fecNacimiento,
    String direccion,
    String referencia,
    String genero,
    String estado){
    this.idProfesor=idProfesor;
     this.appaterno=appaterno;
    this.apmaterno=apmaterno;
    this.nombres=nombres;
    this.fecNacimiento=fecNacimiento;
    this.direccion=direccion;
    this.referencia=referencia;
    this.genero=genero;
    this.estado=estado;
    }

    /**
     * @return the idProfesor
     */
    public int getIdProfesor() {
        return idProfesor;
    }

    /**
     * @param idProfesor the idProfesor to set
     */
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    /**
     * @return the appaterno
     */
    public String getAppaterno() {
        return appaterno;
    }

    /**
     * @param appaterno the appaterno to set
     */
    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    /**
     * @return the apmaterno
     */
    public String getApmaterno() {
        return apmaterno;
    }

    /**
     * @param apmaterno the apmaterno to set
     */
    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the fecNacimiento
     */
    public String getFecNacimiento() {
        return fecNacimiento;
    }

    /**
     * @param fecNacimiento the fecNacimiento to set
     */
    public void setFecNacimiento(String fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
