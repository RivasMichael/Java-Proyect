/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.DetRepuesto;
import BEAN.Det_Repuesto_Cruzada;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author luism
 */
public class DetRepuestoDAO {

    public DetRepuestoDAO() {
    }
    
    
    
     public Vector<DetRepuesto> ListaItem(boolean sw, String str){
        Vector<DetRepuesto> item = new Vector<DetRepuesto>();
        DbBean con = new DbBean();
        String sql = "Select * from DetRepuesto";
        if(sw == true){
            sql = sql + " WHERE (idRepuesto = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                DetRepuesto detRep = new DetRepuesto();
                detRep.setIdOrden(resultado.getInt(1));
                detRep.setIdRepuesto(resultado.getInt(2));
                detRep.setUnidadMedida(resultado.getString(3));
                detRep.setCantidad(resultado.getInt(4));
           
                item.addElement(detRep);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
     
    public Vector<Det_Repuesto_Cruzada> ListaItem(int idOrden){
        Vector<Det_Repuesto_Cruzada> item = new Vector<Det_Repuesto_Cruzada>();
        DbBean con = new DbBean();
        String sql = "select det.idRepuesto, r.Nombre, r.TipRepuesto , det.unidadMedida, det.cantidad  from DetRepuesto as det inner join Repuesto as r on det.idRepuesto = r.idRepuesto ";
                sql += " where det.idOrden = "+ idOrden +" " ;
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                Det_Repuesto_Cruzada detRep = new Det_Repuesto_Cruzada();
                detRep.setIdRepuesto(resultado.getInt(1));
                detRep.setNombreRep(resultado.getString(2));
                detRep.setTipo(resultado.getString(3));
                detRep.setUnidadMedida(resultado.getString(4));
                detRep.setCantidad(resultado.getInt(5));
           
                item.addElement(detRep);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
     
     
    
    public void borraDeta(String idOrden){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       sql="delete from DetRepuesto WHERE (id_venta = "+ idOrden +")";
       System.out.println("Del dv "+sql);
       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){
        }
        
    }
    public int procesaItem(DetRepuesto dv, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       System.out.println("ENTRE SUAVE");
       if(proc.equals("insert")){
            sql="INSERT INTO DetRepuesto VALUES ("+ dv.getIdOrden()+", "+ dv.getIdRepuesto()+", '"+ dv.getUnidadMedida()+"', "+ dv.getCantidad() +")";
            System.out.println("EVallll: "+sql);
       }
       if(proc.equals("update")){
            sql="UPDATE DetRepuesto set idRepuesto  = "+ dv.getIdRepuesto() +", unidadMedida = '"+ dv.getUnidadMedida() +"', cantidad = " +dv.getCantidad() +" ";
            sql += " where idOrden= "+ dv.getIdOrden() +" ";
       }
       System.out.println("Observando el estado de la sentencia sql: "+sql);

       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){e.printStackTrace();
        }
        try{
        con.desconecta();
        }
        catch(SQLException e){
        }
          return resultado;
      }  
}
