package DAO;

import BEAN.Det_Empleado;
import BEAN.Det_Empleado_Cruzada;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class det_EmpleadoDAO {

        public det_EmpleadoDAO() {
        }
    
        
        public Vector<Det_Empleado> ListaItem(boolean sw, String str){
        Vector<Det_Empleado> item = new Vector<Det_Empleado>();
        DbBean con = new DbBean();
        String sql = "Select * from detEmpleado";
        if(sw == true){
            sql = sql + " WHERE (idEmpleado = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                Det_Empleado detEmp = new Det_Empleado();
                detEmp.setIdOrden(resultado.getInt(1));
                detEmp.setIdEmpleado(resultado.getInt(2));
                detEmp.setIdActividad(resultado.getInt(3));
                detEmp.setFecha(resultado.getString(4));
                detEmp.setNumHoras(resultado.getInt(4));
                item.addElement(detEmp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    public Vector<Det_Empleado_Cruzada> ListaItem(int idOrden){
        Vector<Det_Empleado_Cruzada> item = new Vector<Det_Empleado_Cruzada>();
        DbBean con = new DbBean();
        String sql = "select e.idEmpleado, e.apellidos, e.nombres , a.idActividad, a.descripcion, de.fecha, de.NumHoras from DetEmpleado as de inner join CabOrden as cab on de.idOrden = cab.idOrden inner join Actividad as a\n" +
"		on de.idActividad=a.idActividad inner join Empleado as e on de.idEmpleado = e.idEmpleado where cab.idOrden = "+ idOrden +" ";
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                Det_Empleado_Cruzada detEmp = new Det_Empleado_Cruzada();
                detEmp.setIdempleado(resultado.getInt(1));
                detEmp.setApellidos(resultado.getString(2));
                detEmp.setNombres(resultado.getString(3));
                detEmp.setIdactividad(resultado.getInt(4));
                detEmp.setDescripcion(resultado.getString(5));
                detEmp.setFecha(resultado.getString(6));
                detEmp.setNumHoras(resultado.getInt(7));
                
                item.addElement(detEmp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    
    
    
    
    public void borraDeta(String idEm){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       sql="delete from detEmpleado  WHERE (idEmpleado = "+ idEm +")";
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
    public int procesaItem(Det_Empleado de, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       System.out.println("Entre Suave");
       if(proc.equals("insert")){
            sql="Insert into detEmpleado values ("+ de.getIdOrden() +", "+ de.getIdEmpleado()+", "+ de.getIdActividad()+", '"+ de.getFecha() +"', "+de.getNumHoras()+")";
            System.out.println("EVallll: "+sql);
       }
       if(proc.equals("update")){
            sql="update detEmpleado set idEmpleado  = "+ de.getIdEmpleado() +", idActividad = '"+ de.getIdActividad()+"', fecha = '"+ de.getFecha() +"' , NumHoras = "+ de.getNumHoras() +"  ";
            sql += " where idOrden = '"+ de.getIdOrden()+"'";
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
