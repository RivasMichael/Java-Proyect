/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Mantenimiento;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author luism
 */
public class MantenimientoDAO {
    
    Vector Mantenimiento;
    public MantenimientoDAO() {
        Mantenimiento = new Vector();
    }
    
    
    
    public Vector<Mantenimiento>listaMantenimiento(boolean sw,String cad){
        DbBean conBD;
        conBD = new DbBean();
        
        Vector<Mantenimiento>listMantenimiento;
        listMantenimiento = new Vector<Mantenimiento>();
        String sql;
        ResultSet rstMants;
        
        try{
            sql = "select *from Mantenimiento ";
            if(sw == true){
                sql = sql + "where descripcion like '"+cad + "%'" ;
            }
            rstMants = conBD.resultadoSQL(sql);
             while(rstMants.next()){
                Mantenimiento mant = new Mantenimiento();
                mant.setIdMantenimiento(rstMants.getInt(1));
                mant.setDescripcion(rstMants.getString(2));
                mant.setTipoMant(rstMants.getString(3));
                mant.setPrioridad(rstMants.getString(4));
                mant.setPeriodoGarantia(rstMants.getString(5));  
                mant.setEstado(rstMants.getInt(6));  
                listMantenimiento.addElement(mant);
            }
            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listMantenimiento;
        
        
    }
    
    public Vector<Mantenimiento>listaMantenimiento(int idmantenimiento){
        DbBean conBD;
        conBD = new DbBean();
        
        Vector<Mantenimiento>listMantenimiento;
        listMantenimiento = new Vector<Mantenimiento>();
        String sql;
        ResultSet rstMants;
        
        try{
            sql = "select * from Mantenimiento where idMantenimiento = "+ idmantenimiento +" ";
            rstMants = conBD.resultadoSQL(sql);
             while(rstMants.next()){
                Mantenimiento mant = new Mantenimiento();
                mant.setIdMantenimiento(rstMants.getInt(1));
                mant.setDescripcion(rstMants.getString(2));
                mant.setTipoMant(rstMants.getString(3));
                mant.setPrioridad(rstMants.getString(4));
                mant.setPeriodoGarantia(rstMants.getString(5));  
                mant.setEstado(rstMants.getInt(6));  
                listMantenimiento.addElement(mant);
            }
            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listMantenimiento;
        
        
    }
    
    
    public void insertaMantenimiento(Mantenimiento mant){
        String sql;
        DbBean conBD = new DbBean();
        try{
            sql = "insert into Mantenimiento values (";
            sql = sql + ""+ mant.getIdMantenimiento() +", '" + mant.getDescripcion()+"', ";
            sql = sql + "'"+ mant.getTipoMant() +"', ";
            sql = sql + "'"+ mant.getPrioridad() +"' , '"+ mant.getPeriodoGarantia() +"' , " + mant.getEstado() +" )";
        
            System.out.println("Mijaaa: "+sql);
            
            conBD.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void actualizaMantenimiento(Mantenimiento mant){
        String sql;
        DbBean conBD = new DbBean();
        
        try{
            sql = "update Mantenimiento set descripcion= '"+ mant.getDescripcion() +"', ";
            sql +=  " tipoMant = '"+ mant.getTipoMant() +"', prioridad = '"+ mant.getPrioridad() +"',  ";
            sql += " periodoGarantia = '"+ mant.getPeriodoGarantia() +"' , Estado = " + mant.getEstado() +" ";
            sql += " where idMantenimiento = "+ mant.getIdMantenimiento() +"";
            System.out.println(sql);
            conBD.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean eliminaMantenimiento(int idMant){
        boolean sw = false;
        String sql;
        DbBean conBD = new DbBean();
        ResultSet rstMant;
        
        try{
            sql = "select * from cabOrden where idMantenimiento = "+ idMant +"";
            rstMant = conBD.resultadoSQL(sql);
            if(!rstMant.next()){
                sw = true;
                sql = "delete from Mantenimiento where idMantenimiento = "+ idMant +"";
                conBD.ejecutaSQL(sql);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return sw;
    }
    
    
}
