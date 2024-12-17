
package BEAN;  

public class Mantenimiento {  
    private int idMantenimiento;  
    private String descripcion;  
    private String tipoMant;  
    private String prioridad;
    private String periodoGarantia;
    private int Estado;

    public Mantenimiento() {
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoMant() {
        return tipoMant;
    }

    public void setTipoMant(String tipoMant) {
        this.tipoMant = tipoMant;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getPeriodoGarantia() {
        return periodoGarantia;
    }

    public void setPeriodoGarantia(String periodoGarantia) {
        this.periodoGarantia = periodoGarantia;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    
}    

