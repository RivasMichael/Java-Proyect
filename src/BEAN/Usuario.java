
package BEAN;

import java.time.LocalDateTime;

public class Usuario {
    
    private int idUsuario;
    private int idEpleado;
    private String usuario;
    private String pw;
    private LocalDateTime fech_reg;
    private LocalDateTime fecha_mod;
    private int estado;

    public Usuario() {
    }

    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEpleado() {
        return idEpleado;
    }

    public void setIdEpleado(int idEpleado) {
        this.idEpleado = idEpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public LocalDateTime getFech_reg() {
        return fech_reg;
    }

    public void setFech_reg(LocalDateTime fech_reg) {
        this.fech_reg = fech_reg;
    }

    public LocalDateTime getFecha_mod() {
        return fecha_mod;
    }

    public void setFecha_mod(LocalDateTime fecha_mod) {
        this.fecha_mod = fecha_mod;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

   
    
    
    
            
    
}
