
package BEAN;

import java.time.LocalDateTime;


public class CabOrden {
    private int idOrden;
    private int idMantenimiento;
    private int idCliente;
    private int idvehiculo;
    private String fechProg;
    private int idUsuarioReg;
    private LocalDateTime fech_reg;
    private LocalDateTime fech_mod;
    private int idUsuarioMod;
    private String obs;
    private int estado;

    public CabOrden() {
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getFechProg() {
        return fechProg;
    }

    public void setFechProg(String fechProg) {
        this.fechProg = fechProg;
    }

    public int getIdUsuarioReg() {
        return idUsuarioReg;
    }

    public void setIdUsuarioReg(int idUsuarioReg) {
        this.idUsuarioReg = idUsuarioReg;
    }

    public LocalDateTime getFech_reg() {
        return fech_reg;
    }

    public void setFech_reg(LocalDateTime fech_reg) {
        this.fech_reg = fech_reg;
    }

    public LocalDateTime getFech_mod() {
        return fech_mod;
    }

    public void setFech_mod(LocalDateTime fech_mod) {
        this.fech_mod = fech_mod;
    }

    public int getIdUsuarioMod() {
        return idUsuarioMod;
    }

    public void setIdUsuarioMod(int idUsuarioMod) {
        this.idUsuarioMod = idUsuarioMod;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
   

    
    
    
}
