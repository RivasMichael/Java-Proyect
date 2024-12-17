
package BEAN;


public class Repuesto {
    private int idRepuesto;
    private String nombre;
    private String tipRepuesto;
    private String marca;
    private int numSerie;
    private int stock;
    private int estado;

    public Repuesto() {
    }

    public Repuesto(int idRepuesto, String nombre, String tipRepuesto, String marca, int numSerie, int stock, int estado) {
        this.idRepuesto = idRepuesto;
        this.nombre = nombre;
        this.tipRepuesto = tipRepuesto;
        this.marca = marca;
        this.numSerie = numSerie;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(int idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipRepuesto() {
        return tipRepuesto;
    }

    public void setTipRepuesto(String tipRepuesto) {
        this.tipRepuesto = tipRepuesto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
