package BEAN;  

public class Rol {  
    private int idRol;  
    private String nombreRol;  
    private String areaTrabajo;  
    private int numMaxRol;  
    private String nivelAcceso;  
    private int estado;  

    public Rol() {  
    }  

    public Rol(int idRol, String nombreRol, String areaTrabajo, int numMaxRol, String nivelAcceso, int estado) {  
        this.idRol = idRol;  
        this.nombreRol = nombreRol;  
        this.areaTrabajo = areaTrabajo;  
        this.numMaxRol = numMaxRol;  
        this.nivelAcceso = nivelAcceso;  
        this.estado = estado;  
    }  

    public int getIdRol() {  
        return idRol;  
    }  

    public String getNombreRol() {  
        return nombreRol;  
    }  

    public String getAreaTrabajo() {  
        return areaTrabajo;  
    }  

    public int getNumMaxRol() {  
        return numMaxRol;  
    }  

    public String getNivelAcceso() {  
        return nivelAcceso;  
    }  

    public int getEstado() {  
        return estado;  
    }  

    public void setIdRol(int idRol) {  
        this.idRol = idRol;  
    }  

    public void setNombreRol(String nombreRol) {  
        this.nombreRol = nombreRol;  
    }  

    public void setAreaTrabajo(String areaTrabajo) {  
        this.areaTrabajo = areaTrabajo;  
    }  

    public void setNumMaxRol(int numMaxRol) {  
        this.numMaxRol = numMaxRol;  
    }  

    public void setNivelAcceso(String nivelAcceso) {  
        this.nivelAcceso = nivelAcceso;  
    }  

    public void setEstado(int estado) {  
        this.estado = estado;  
    }  
}