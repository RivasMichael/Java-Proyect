/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Vehiculo;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class VehiculoDAO {

    public VehiculoDAO() {
    }
    
    
   public Vector<Vehiculo> listaVehiculos(boolean sw, String cad) {
        DbBean conBD = new DbBean();
        Vector<Vehiculo> listaVehi = new Vector<>();
        String sql = "select * from Vehiculo ";

        if (sw == true) {
            sql += "WHERE modelo LIKE '" + cad + "%'";
        }
        try {
            
            ResultSet result = conBD.resultadoSQL(sql);

            while (result.next()) {
                Vehiculo vehic = new Vehiculo();
                vehic.setIdVehiculo(result.getInt(1));
                vehic.setPlaca(result.getString(2));
                vehic.setMarca(result.getString(3));
                vehic.setModelo(result.getString(4));
                vehic.setAño(result.getInt(5));
                vehic.setEstado(result.getInt(6));
                listaVehi.addElement(vehic);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            conBD.desconecta();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        
        return listaVehi;
    }
   public Vector<Vehiculo> listaVehiculos(int id) {
        DbBean conBD = new DbBean();
        Vector<Vehiculo> listaVehi = new Vector<>();
        String sql = "select * from Vehiculo where idVehiculo = "+ id +"";
        try {
            
            ResultSet result = conBD.resultadoSQL(sql);

            while (result.next()) {
                Vehiculo vehic = new Vehiculo();
                vehic.setIdVehiculo(result.getInt(1));
                vehic.setPlaca(result.getString(2));
                vehic.setMarca(result.getString(3));
                vehic.setModelo(result.getString(4));
                vehic.setAño(result.getInt(5));
                vehic.setEstado(result.getInt(6));
                listaVehi.addElement(vehic);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            conBD.desconecta();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        
        return listaVehi;
    }

    public void insertaVehiculo(Vehiculo vehi) {
        String sql;
        DbBean conBD = new DbBean();
        try {
            sql = "insert into Vehiculo values (";
            sql += vehi.getIdVehiculo() + ", '" + vehi.getPlaca() + "', ";
            sql += "'" + vehi.getMarca() + "', '" + vehi.getModelo() + "', " + vehi.getAño() + " , "+ vehi.getEstado() +")";
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

    public void actualizaVehiculo(Vehiculo vehi) {
        String sql;
        DbBean conBD = new DbBean();
        try {
            sql = "update Vehiculo set placa = '" + vehi.getPlaca() + "', ";
            sql += "marca = '" + vehi.getMarca() + "', modelo = '" + vehi.getModelo() + "', ";
            sql += "año = " + vehi.getAño() + "  , estado = "+ vehi.getEstado() +"  where idVehiculo = " + vehi.getIdVehiculo()+ " " ;
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

    public boolean eliminaVehiculo(int idVehi) {
        boolean sw = false;
        String sql;
        DbBean conBD = new DbBean();
        ResultSet rstDetVent;

        try {
            sql = "Select * from CabOrden where idVehiculo = " + idVehi + " ";
            rstDetVent = conBD.resultadoSQL(sql);
            if (!rstDetVent.next()) {
                sw = true;
                sql = "delete from Vehiculo where idVehiculo = " + idVehi+ " ";
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

