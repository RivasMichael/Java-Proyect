
package DAO;

import BEAN.Cliente;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ClienteDAO {

    public ClienteDAO() {
    }
    
    
    
    
     public Vector<Cliente> listaClientes(boolean sw,String cad, boolean sw2  ){
        System.out.println("holllllllllllllllllllllllllll");
        
        DbBean con = new DbBean();
        Vector<Cliente> lisclie = new Vector<Cliente>();
        String sql;
        if(sw2==true){
            System.out.println("Hola, hola, hola, hola");
        sql = "Select * from Cliente";
        if(sw == true){
            sql = sql +  " where apellidos like '"+ cad +"%'  or nombres like '"+ cad +"%' ";
        }
        }else{
            sql="select distinct c.idCliente,c.apellidos,c.nombres, c.telefono, c.direccion, c.correoElectronico, c.estado\n" +
                  "from cabOrden as cv left outer join Cliente as c on cv.idCliente=c.idCliente";
            if(sw==true){
              sql= sql +"where c.apellidos like '" + cad + "%' or c.nombres like '" + cad + "%'";
           }
        
        }
        try{
            ResultSet result = con.resultadoSQL(sql);
            while(result.next()){
                Cliente clie = new Cliente();
                clie.setIdCliente(result.getInt(1));
                clie.setApellidos(result.getString(2));
                clie.setNombres(result.getString(3));
                clie.setTelefono(result.getString(4));
                clie.setDireccion(result.getString(5));
                clie.setCorreo(result.getString(6));
                clie.setEstado(result.getInt(7));
                lisclie.addElement(clie);
            }
            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            
        }
        return lisclie;    
    }
    
    public Vector<Cliente> listaCliente(int id){
        DbBean con = new DbBean();
        Vector<Cliente> lisclie = new Vector<Cliente>();
        String sql;
        sql = "Select * from Cliente where idCliente = "+ 101 + " ";
        try{
            ResultSet result = con.resultadoSQL(sql);
            while(result.next()){
                Cliente clie = new Cliente();
                clie.setIdCliente(result.getInt(1));
                clie.setApellidos(result.getString(2));
                clie.setNombres(result.getString(3));
                clie.setTelefono(result.getString(4));
                clie.setDireccion(result.getString(5));
                clie.setCorreo(result.getString(6));
                clie.setEstado(result.getInt(7));
                lisclie.addElement(clie);
            }
            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            
        }
        return lisclie; 
    }
     
     
     
    public void insertaCliente(Cliente clie){
        DbBean con = new DbBean();
        String sql;
        try{
           sql = "insert into Cliente values ('" + clie.getIdCliente() + "', '" + clie.getApellidos() + "', '" + clie.getNombres() + "', ";
            sql += "'" + clie.getTelefono() + "', '" + clie.getDireccion() + "', '" + clie.getCorreo() + "', '" + clie.getEstado() + "')";
            System.out.print(sql);
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    
    public void actualizaCliente(Cliente clie) {
        DbBean con = new DbBean();
        String sql;
        try {
            sql = "update Cliente set apellidos = '" + clie.getApellidos() + "', nombres = '" + clie.getNombres() + "', telefono = '" + clie.getTelefono() + "', ";
            sql += " direccion = '" + clie.getDireccion() + "' , correoElectronico = '" + clie.getCorreo() + "', estado = " + clie.getEstado()+ " ";
            sql += " where idCliente = " + clie.getIdCliente() +" ";
            System.out.print(sql);

            con.ejecutaSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            con.desconecta();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean eliminarCliente(int id){
        DbBean con = new DbBean();
        boolean sw = true;
        String sql;
        ResultSet result;
        try{
            sql = "Select * from CabOrden where idCliente = "+id+" ";
            result = con.resultadoSQL(sql);
            if(!result.next()){
                sw = true;
                sql = "Delete from Cliente where  idCliente = "+id+" ";
                con.ejecutaSQL(sql);
            }else{
                sw = false;
            }
   
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return sw;
    }

}
