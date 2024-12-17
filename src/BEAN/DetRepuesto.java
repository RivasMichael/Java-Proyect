
package BEAN;


public class DetRepuesto {
    
    private int idOrden;
    private int idRepuesto;
    private String unidadMedida;
    private int cantidad;

    public DetRepuesto() {
    }

    public DetRepuesto(int idOrden, int idRepuesto, String unidadMedida, int cantidad) {
        this.idOrden = idOrden;
        this.idRepuesto = idRepuesto;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public int getIdRepuesto() {
        return idRepuesto;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public void setIdRepuesto(int idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
