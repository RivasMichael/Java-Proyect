package BEAN;

public class Det_Empleado {
    private int idOrden;
    private int idEmpleado;
    private int idActividad;
    private String fecha;
    private int numHoras;

    public Det_Empleado() {
    }

    public Det_Empleado(int idOrden, int idEmpleado, int idActividad, String fecha, int numHoras) {
        this.idOrden = idOrden;
        this.idEmpleado = idEmpleado;
        this.idActividad = idActividad;
        this.fecha = fecha;
        this.numHoras = numHoras;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }
}
