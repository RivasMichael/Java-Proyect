
package BEAN;

public class Cab_Registro_Cruzado {
    private int idOrden;
    private int idCliente;
    private String fechProg;
    private  int idVehiculo;
    private String placa;
    private int idMantenimiento;
    private String descripcion;

    public Cab_Registro_Cruzado() {
    }

    public Cab_Registro_Cruzado(int idOrden, int idCliente, String fechProg, int idVehiculo, String placa, int idMantenimiento, String descripcion) {
        this.idOrden = idOrden;
        this.idCliente = idCliente;
        this.fechProg = fechProg;
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.idMantenimiento = idMantenimiento;
        this.descripcion = descripcion;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechProg() {
        return fechProg;
    }

    public void setFechProg(String fechProg) {
        this.fechProg = fechProg;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
    
 
    
}
