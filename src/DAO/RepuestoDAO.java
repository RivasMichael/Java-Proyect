package DAO;

import BEAN.Repuesto;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;


public class RepuestoDAO {
    Vector repdao;

    public RepuestoDAO() {
        repdao = new Vector();
    }
    
    public void setRepuesto(Vector repdao) {
        this.repdao.addElement(repdao);
    }  
    
   public Vector<Repuesto> listaRepuesto(boolean bool, String cad) {
        DbBean conBD = new DbBean();
        Vector<Repuesto> listaRepuesto = new Vector<Repuesto>();
        String sql;
        sql = "select * from Repuesto ";
        if(bool == true){
            sql = sql +  " where Nombre like '"+ cad +"%'";
        }
        try{
            ResultSet result = conBD.resultadoSQL(sql);
            while(result.next()){
                Repuesto rep = new Repuesto();
                rep.setIdRepuesto(result.getInt(1));
                rep.setNombre(result.getString(2));
                rep.setTipRepuesto(result.getString(3));
                rep.setMarca(result.getString(4));
                rep.setNumSerie(result.getInt(5));
                rep.setStock(result.getInt(6));
                rep.setEstado(result.getInt(7));
                listaRepuesto.addElement(rep);
            }
        } catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaRepuesto;
    }
   
    public void insertaRepuesto(Repuesto rep){
        String sql;
        DbBean conBD = new DbBean();
        try{
            sql = "insert into Repuesto values("+ rep.getIdRepuesto()+", '"+ rep.getNombre()+"', ";
            sql += " '"+ rep.getTipRepuesto()+"', '"+ rep.getMarca() +"' , "+ rep.getNumSerie() +", "+ rep.getStock()+" , "+ rep.getEstado() +" )";
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
    public void actualizaRepuesto(Repuesto rep){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "update Repuesto set  Nombre = '"+ rep.getNombre()+"', TipRepuesto = '"+ rep.getTipRepuesto()+"', marca = '"+ rep.getMarca() +"' , numero_serie = "+ rep.getNumSerie() +", ";
            sql += " stock = "+ rep.getStock()+" , estado = "+ rep.getEstado() +" where idRepuesto = "+ rep.getIdRepuesto() +"  ";
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
    
    public boolean eliminarRepuesto(int id) {
        DbBean con = new DbBean();
        boolean sw = true;
        String sql;
        ResultSet result;
        try {
            sql = "Select * from DetRepuesto where idRepuesto = " + id + " ";
            result = con.resultadoSQL(sql);
            if (!result.next()) {
                sw = true;
                sql = "Delete from Repuesto where idRepuesto = " + id + " ";
                con.ejecutaSQL(sql);
            } else {
                sw = false;
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            con.desconecta();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return sw;
    }
    
}