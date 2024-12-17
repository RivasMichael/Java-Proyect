/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.CabOrden;
import BEAN.Cab_Registro_Cruzado;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;


public class CabOrdenDAO {

    public CabOrdenDAO() {
    }

    public Vector<CabOrden> ListaItem(boolean sw, String str){
        
        Vector<CabOrden> item = new Vector<CabOrden>();
        DbBean con = new DbBean();
        String sql = "Select * from CabOrden";
        if(sw == true){
            sql = sql + " WHERE (idCliente = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                CabOrden cabOrd = new CabOrden();
                cabOrd.setIdOrden(resultado.getInt(1));
                cabOrd.setIdMantenimiento(resultado.getInt(2));
                cabOrd.setIdCliente(resultado.getInt(3));
                cabOrd.setIdvehiculo(resultado.getInt(4));
                cabOrd.setFechProg(resultado.getString(5));
                cabOrd.setIdUsuarioReg(resultado.getInt(6));
                
                Timestamp timestampFechReg = resultado.getTimestamp(7);
                cabOrd.setFech_reg(timestampFechReg.toLocalDateTime());
                
                cabOrd.setIdUsuarioMod(resultado.getInt(8));
                
                Timestamp timestampsetFech_mod = resultado.getTimestamp(9);
                cabOrd.setFech_mod(timestampsetFech_mod.toLocalDateTime());
             
                cabOrd.setObs(resultado.getString(10));
                
                cabOrd.setEstado(resultado.getInt(11));
                item.addElement(cabOrd);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    public Vector<CabOrden> ListaItem(int idOrden){
        
        Vector<CabOrden> item = new Vector<CabOrden>();
        DbBean con = new DbBean();
        String sql = "select cab.obs from  CabOrden as cab where cab.idOrden = "+ idOrden +"";
        
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                CabOrden cabOrd = new CabOrden();
                cabOrd.setObs(resultado.getString(1));
                item.addElement(cabOrd);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    public int procesaItem(CabOrden co, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql = "INSERT INTO CabOrden (idOrden, idMantenimiento, idCliente, idVehiculo, fechProg, fech_reg, idUsuarioRegistro, obs,estado ) VALUES ( ";
            sql += " "+ co.getIdOrden() +", "+ co.getIdMantenimiento() + ", "+ co.getIdCliente() +", "+ co.getIdvehiculo() +", '"+ co.getFechProg() +"', ";
            sql += " '"+ co.getFech_reg() +"',  "+ co.getIdUsuarioReg() +" ,";
            sql += " '" +co.getObs() +"' , "+ co.getEstado()+ " ) ";        

            
            System.out.println("uuuuuuu" + sql);
       }
       if(proc.equals("update")){
            sql = "update  CabOrden set idMantenimiento = "+ co.getIdMantenimiento() + ", idCliente  = "+ co.getIdCliente() +", idVehiculo = "+ co.getIdvehiculo() +", fechProg = '"+ co.getFechProg() +"', ";
            sql += " fech_mod = '"+ co.getFech_mod()+"',  idUsuarioModificacion = "+ co.getIdUsuarioMod()+" , obs = '" +co.getObs() +"' , estado =  "+ co.getEstado()+ " ";
            sql += " where idOrden = "+ co.getIdOrden() +" ";
       }

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
    
    
    public Vector<Cab_Registro_Cruzado> ListaCruzadaItem(boolean sw, String str) {
        Vector<Cab_Registro_Cruzado> item = new Vector<>();
        DbBean con = new DbBean();
        String sql = "SELECT c.idOrden, ci.idCliente, c.fechProg, v.idVehiculo, v.placa, m.idMantenimiento, m.descripcion "
                   + "FROM CabOrden AS c "
                   + "INNER JOIN Cliente AS ci ON c.idCliente = ci.idCliente "
                   + "INNER JOIN Vehiculo AS v ON v.idVehiculo = c.idVehiculo "
                   + "INNER JOIN Mantenimiento AS m ON m.idMantenimiento = c.idMantenimiento ";
        if (sw==true) {
            sql += "WHERE ci.idCliente = "+str;
        }

        try {

            ResultSet resultado = con.resultadoSQL(sql);

            while (resultado.next()) {
                Cab_Registro_Cruzado crCruzado = new Cab_Registro_Cruzado();
                crCruzado.setIdOrden(resultado.getInt(1));
                crCruzado.setIdCliente(resultado.getInt(2));
                crCruzado.setFechProg(resultado.getString(3));
                crCruzado.setIdVehiculo(resultado.getInt(4));
                crCruzado.setPlaca(resultado.getString(5));
                crCruzado.setIdMantenimiento(resultado.getInt(6));
                crCruzado.setDescripcion(resultado.getString(7));
                item.addElement(crCruzado);
            }

        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            con.desconecta();
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }

        return item;
    }
    
    
    
    
}
