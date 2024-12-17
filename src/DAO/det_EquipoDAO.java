package DAO;

import BEAN.Det_Equipo;
import BEAN.Det_Equipo_Cruzada;
import BEAN.Det_Repuesto_Cruzada;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class det_EquipoDAO {

        public det_EquipoDAO() {
        }
    
        
        public Vector<Det_Equipo> ListaItem(boolean sw, String str){
        Vector<Det_Equipo> item = new Vector<Det_Equipo>();
        DbBean con = new DbBean();
        String sql = "Select * from detEquipo";
        if(sw == true){
            sql = sql + " WHERE (idEquipo = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                Det_Equipo detEq = new Det_Equipo();
                detEq.setIdOrden(resultado.getInt(1));
                detEq.setIdEmpleado(resultado.getInt(2));
                detEq.setIdEquipo(resultado.getInt(3));
                detEq.setIdActividad(resultado.getInt(4));
                detEq.setFecha(resultado.getString(4));
                detEq.setNumHoras(resultado.getInt(4));
                item.addElement(detEq);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    public Vector<Det_Equipo_Cruzada> ListaItem(int idOrden){
        Vector<Det_Equipo_Cruzada> item = new Vector<Det_Equipo_Cruzada>();
        DbBean con = new DbBean();
        String sql = "select em.idEmpleado, e.idEquipo, e.Nombre, e.Categoria , a.idActividad, a.descripcion, de.fecha, de.numHoras from DetEquipo as de inner join Empleado as em ";
                sql += " on de.idEmpleado = em.idEmpleado inner join Actividad as a on de.idActividad = a.idActividad inner join Equipo as e on de.idEquipo = e.idEquipo ";
                sql += " where de.idOrden = "+ idOrden +" ";
       
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                Det_Equipo_Cruzada detcruz = new Det_Equipo_Cruzada();
                detcruz.setIdEmpleado(resultado.getInt(1));
                detcruz.setIdEquipo(resultado.getInt(2));
                detcruz.setNombre(resultado.getString(3));
                detcruz.setCategoria(resultado.getString(4));
                detcruz.setIdActividad(resultado.getInt(5));
                detcruz.setDesActividad(resultado.getString(6));
                detcruz.setFecha(resultado.getString(7));
                detcruz.setNumHoras(resultado.getInt(8));
                
                item.addElement(detcruz);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }    
        
        
        
    public void borraDeta(String idEq){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       sql="delete from detEmpleado  WHERE (idEquipo = "+ idEq +")";
       System.out.println("Del deq "+sql);
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
    public int procesaItem(Det_Equipo deq, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       System.out.println("Entre Suave");
       if(proc.equals("insert")){
            sql="Insert into DetEquipo values ("+ deq.getIdOrden() +", "+ deq.getIdEmpleado()+", "+ deq.getIdEquipo()+", "+ deq.getIdActividad()+", '"+ deq.getFecha() +"', "+deq.getNumHoras()+" )";
            System.out.println("EVallll: "+sql);
       }
       if(proc.equals("update")){
            sql=" update DetEquipo set idEmpleado  = "+ deq.getIdEmpleado() +", idEquipo = '"+ deq.getIdEquipo()+"', idActividad = "+ deq.getIdActividad()+" , ";
            sql += " fecha = '"+ deq.getFecha() +"' , numHoras = "+ deq.getNumHoras() +"  where idOrden = " + deq.getIdOrden()+ " ";
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
    