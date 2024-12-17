
package DAO;

import BEAN.Equipo;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;


public class EquipoDAO {

    public EquipoDAO() {
    }
    
    public Vector<Equipo> listaEquipos(boolean sw, String cad) {
        DbBean conBD = new DbBean();
        Vector<Equipo> lisEquip = new Vector<Equipo>();
        String sql = "Select * from Equipo ";
        if (sw == true){
            sql += " where Nombre like '" + cad + "%' or numero_serie like '"+ cad +"%'";
        }
        
        try {
            ResultSet result = conBD.resultadoSQL(sql);

            while (result.next()) {
                Equipo equip = new Equipo();
                equip.setIdEquipo(result.getInt(1));
                equip.setNumero_serie(result.getString(2));
                equip.setNombre(result.getString(3));
                equip.setMarca(result.getString(4));
                equip.setCategoria(result.getString(5));
                equip.setEstado(result.getInt(6));
                lisEquip.addElement(equip);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
  
        try {
            conBD.desconecta();
        }catch(java.sql.SQLException e){
          e.printStackTrace();
        }
        System.out.println("aaa");
        
        return lisEquip;
    }

    public void insertaEquipo(Equipo equipo) {
        DbBean con = new DbBean();
        String sql;
        try {
            sql = "insert into Equipo values ( "+ equipo.getIdEquipo() +" , '"+ equipo.getNumero_serie()+"' , '"+ equipo.getNombre() +"' ,";
            sql += " '"+ equipo.getMarca() +"' , '"+ equipo.getCategoria() +"' , '"+ equipo.getEstado() +"' )";
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

    public void actualizaEquipo(Equipo equip) {
        DbBean con = new DbBean();
        String sql;
        try {
            sql = "update Equipo set numero_serie = '" + equip.getNumero_serie()+ "', Nombre = '" + equip.getNombre() + "', ";
            sql += "marca = '" + equip.getMarca() + "', Categoria = '" + equip.getCategoria() + "', estado = " + equip.getEstado() + " ";
            sql += "where idEquipo = " + equip.getIdEquipo() + " ";

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

    public boolean eliminarEquipo(int id) {
        DbBean con = new DbBean();
        boolean sw = true;
        String sql;
        ResultSet result;
        try {
            sql = "Select * from DetEquipo where idEquipo = " + id + " ";
            result = con.resultadoSQL(sql);
            if (!result.next()) {
                sw = true;
                sql = "Delete from Equipo where idEquipo = " + id + " ";
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
