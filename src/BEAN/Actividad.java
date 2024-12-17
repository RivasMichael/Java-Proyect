package BEAN;

public class Actividad {
    private int id_Actividad;
    private String descripcion_Actividad;
    private String categoria;
    private String localizacion;
    private String nivelRiego;
    private String obs;

    public Actividad() {
    }

    public int getId_Actividad() {
        return id_Actividad;
    }

    public void setId_Actividad(int id_Actividad) {
        this.id_Actividad = id_Actividad;
    }

    public String getDescripcion_Actividad() {
        return descripcion_Actividad;
    }

    public void setDescripcion_Actividad(String descripcion_Actividad) {
        this.descripcion_Actividad = descripcion_Actividad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getNivelRiego() {
        return nivelRiego;
    }

    public void setNivelRiego(String nivelRiego) {
        this.nivelRiego = nivelRiego;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    


    
}
