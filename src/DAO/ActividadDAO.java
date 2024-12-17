package DAO;

import BEAN.Actividad;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;


public class ActividadDAO {
    Vector actdao;

    public ActividadDAO() {
        actdao = new Vector();
    }
    
    public void setActividad(Vector cliedao) {
        this.actdao.addElement(actdao);
    }  
    
    
   public Vector<Actividad> listaActividad (boolean bool, String cad) {
        DbBean conBD = new DbBean();
        Vector<Actividad> listaActividad = new Vector<Actividad>();
        String sql;
        sql = "select * from Actividad ";
        if(bool == true){
            sql = sql +  " where descripcion like '"+ cad +"%'";
        }
        try{
            ResultSet result = conBD.resultadoSQL(sql);
            while(result.next()){
                Actividad act = new Actividad();
                act.setId_Actividad(result.getInt(1));
                act.setDescripcion_Actividad(result.getString(2));
                act.setCategoria(result.getString(3));
                act.setLocalizacion(result.getString(4));
                act.setNivelRiego(result.getString(5));
                act.setObs(result.getString(6));
                listaActividad.addElement(act);
                
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaActividad;
    }
   public Vector<String> listaCategorias() {
    Vector<String> categorias = new Vector<>();
    String sql = "SELECT DISTINCT categoria FROM Actividad";
    DbBean conBD = new DbBean();
    try {
        ResultSet result = conBD.resultadoSQL(sql);
        while (result.next()) {
            categorias.add(result.getString(1));
        }
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
    }
    try {
        conBD.desconecta();
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
    }
    
    return categorias;
    }

        public void insertaActividad(Actividad act){
            String sql;
            DbBean conBD = new DbBean();
            try{
                sql = "insert into Actividad values("+ act.getId_Actividad()+", '"+ act.getDescripcion_Actividad()+"' , ";
                sql += " '"+ act.getCategoria() +"' , '"+ act.getLocalizacion() +"' , '"+ act.getNivelRiego() +"' , '"+ act.getObs()  +"' )";
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

    public void actualizaActividad(Actividad act){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "update Actividad  set descripcion = '"+ act.getDescripcion_Actividad()+"',  ";
            sql += " categoria = '"+ act.getCategoria() +"' , localizacion = '"+ act.getLocalizacion() +"' , nivelRiego = '"+ act.getNivelRiego() +"' , obs = '"+ act.getObs()  +"'   ";
            sql += " where idActividad = "+ act.getId_Actividad() +" ";
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
    
    public boolean eliminarActividad(int id){
        DbBean con = new DbBean();
        boolean sw = true;
        boolean sw1 = true;
        boolean sw2 = true;
        String sql1;
        String sql2;
        String sql;
        ResultSet result1;
        ResultSet result2;
        try{
            sql1 = "select * from DetEmpleado where idActividad = " + id;
            result1 = con.resultadoSQL(sql1);

            sql2 = "select * from DetEquipo where idActividad = " + id;
            result2 = con.resultadoSQL(sql2);

            if (!result1.next()) {
                sw1 = true;  
            } else {
                sw1 = false; 
            }

            if (!result2.next()) {
                sw2 = true;  
            } else {
                sw2 = false;
            }

            if (sw1 && sw2) {
                sql = "delete from Actividad where idActividad = " + id;
                con.ejecutaSQL(sql);
            } else {
                sw = false;
            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            sw = false;
        } finally {
            try {
                con.desconecta();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        
        return sw;
    }

}

