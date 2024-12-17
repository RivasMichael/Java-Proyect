package DAO;  

import BEAN.Rol;  
import UTIL.DbBean;  
import java.sql.ResultSet;  
import java.util.Vector;  

public class RolDAO {  
    
    public RolDAO() {  
    }  

    public Vector<Rol> listaRoles(boolean sw, String cad) {  
        DbBean conBD = new DbBean();  
        Vector<Rol> listRoles = new Vector<Rol>();  
        String sql;  
        ResultSet rstRoles;  

        try {  
            sql = "SELECT * FROM rol";  
            if (sw) {  
                sql += " WHERE nombreRol LIKE '" + cad + "%'";  
            }  
            rstRoles = conBD.resultadoSQL(sql);  
            while (rstRoles.next()) {  
                Rol rol = new Rol();  
                rol.setIdRol(rstRoles.getInt(1));  
                rol.setNombreRol(rstRoles.getString(2));  
                rol.setAreaTrabajo(rstRoles.getString(3));  
                rol.setNumMaxRol(rstRoles.getInt(4));  
                rol.setNivelAcceso(rstRoles.getString(5));  
                rol.setEstado(rstRoles.getInt(6));  

                listRoles.addElement(rol);  
            }  

        } catch (java.sql.SQLException e) {  
            e.printStackTrace();  
        }  

        try {  
            conBD.desconecta();  
        } catch (java.sql.SQLException e) {  
            e.printStackTrace();  
        }  
        return listRoles;  
    }  

    public void insertaRol(Rol rol) {  
        String sql;  
        DbBean conBD = new DbBean();  
        try {  
            sql = "INSERT INTO rol VALUES (";  
            sql += rol.getIdRol() + ", ";  
            sql += "'" + rol.getNombreRol() + "', ";  
            sql += "'" + rol.getAreaTrabajo() + "', ";  
            sql += rol.getNumMaxRol() + ", ";  
            sql += "'" + rol.getNivelAcceso() + "', ";  
            sql += rol.getEstado() + ")";  

            System.out.println("SQL Insert: " + sql);  
            conBD.ejecutaSQL(sql);  
        } catch (java.sql.SQLException e) {  
            e.printStackTrace();  
        }  
        try {  
            conBD.desconecta();  
        } catch (java.sql.SQLException e) {  
            e.printStackTrace();  
        }  
    }  

    public void actualizaRol(Rol rol) {  
        String sql;  
        DbBean conBD = new DbBean();  

        try {  
            sql = "UPDATE rol SET ";  
            sql += "nombreRol = '" + rol.getNombreRol() + "', ";  
            sql += "areaTrabajo = '" + rol.getAreaTrabajo() + "', ";  
            sql += "NumMaxRol = " + rol.getNumMaxRol() + ", ";  
            sql += "nivelAcceso = '" + rol.getNivelAcceso() + "', ";  
            sql += "estado = " + rol.getEstado() + " ";  
            sql += "WHERE idRol = " + rol.getIdRol();  

            conBD.ejecutaSQL(sql);  
        } catch (java.sql.SQLException e) {  
            e.printStackTrace();  
        }  

        try {  
            conBD.desconecta();  
        } catch (java.sql.SQLException e) {  
            e.printStackTrace();  
        }  
    }  

    public boolean eliminaRol(int idRol) {  
        boolean sw = false;  
        String sql;  
        DbBean conBD = new DbBean();  
        ResultSet rstRol;  

        try {  
            sql = "SELECT * FROM Empleado WHERE idRol = " + idRol; 
            System.out.println(sql);
            rstRol = conBD.resultadoSQL(sql);  
            if (!rstRol.next()) {  
                sw = true;  
                sql = "DELETE FROM Rol WHERE idRol = " + idRol;  
                conBD.ejecutaSQL(sql);  
            }  
        } catch (java.sql.SQLException e) {  
            e.printStackTrace();  
        }  
        try {  
            conBD.desconecta();  
        } catch (java.sql.SQLException e) {  
            e.printStackTrace();  
        }  
        return sw;  
    }  
}