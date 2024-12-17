
package DAO;

import BEAN.Usuario;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Vector;

public class UsuarioDAO {
    
    Vector Usuario;

    public UsuarioDAO() {
        
        Usuario = new Vector();
    }
    
    public Vector<Usuario>listaUsuarios(boolean sw,String cad){
        DbBean conBD;
        conBD = new DbBean();
        
        Vector<Usuario>listUsuarios;
        listUsuarios = new Vector<Usuario>();
        String sql;
        ResultSet rstUsers;
        
        try{
            sql = "select *from Usuario ";
            if(sw == true){
                sql = sql + "where usuario like '"+ cad + "%'" ;
            }
            rstUsers = conBD.resultadoSQL(sql);
             while(rstUsers.next()){
                Usuario user = new Usuario();
                user.setIdUsuario(rstUsers.getInt(1));
                user.setIdEpleado(rstUsers.getInt(2));
                user.setUsuario(rstUsers.getString(3));
                user.setPw(rstUsers.getString(4));
                
                Timestamp timestampFechReg = rstUsers.getTimestamp(5);
                user.setFech_reg(timestampFechReg.toLocalDateTime());
                
                Timestamp timestampFecha_mod = rstUsers.getTimestamp(6);
                user.setFecha_mod(timestampFecha_mod.toLocalDateTime());
                
                user.setEstado(rstUsers.getInt(7));
                listUsuarios.addElement(user);
            }
            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listUsuarios;
        
        
       
        
    }
    
    public void insertaUsuario(Usuario user){
        String sql;
        DbBean conBD = new DbBean();
        try{
            sql = "insert into Usuario values (" ;
            sql = sql + ""+ user.getIdUsuario() +", " + user.getIdEpleado() +", ";
            sql = sql + "'"+ user.getUsuario() +"', ";
            sql = sql + "'"+ user.getPw() +"', ";
            sql = sql + "'" +user.getFech_reg() + "', ";
            sql = sql + "'" +user.getFech_reg()+ "', ";
            sql = sql + user.getEstado() + ")";
            
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
    
     public void actualizaUsuarios(Usuario user){
        String sql;
        DbBean conBD = new DbBean();
        
        try{
            sql = "update Usuario set usuario= '"+ user.getUsuario() +"', idEmpleado = "+ user.getIdEpleado() +" , ";
            sql = sql + " pw = '"+ user.getPw() +"', ";
            sql = sql + " fech_mod = '"+ user.getFecha_mod()+"' , ";
            sql = sql + " estado = "+ user.getEstado()+ "  ";
            sql = sql + " where idUsuario= "+ user.getIdUsuario() +"";
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
     
    public boolean eliminaUsuario(int idUser){
        boolean sw = false;
        String sql;
        DbBean conBD = new DbBean();
        ResultSet rstEmple;
        
        try{
            sql = "select * from CabOrden where idUsuario = "+ idUser +"";
            rstEmple = conBD.resultadoSQL(sql);
            if(!rstEmple.next()){
                sw = true;
                sql = "delete from usuario where idUsuario = "+ idUser +"";
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
    
    public boolean ValidaUsuarioyEmpleado(String usur, int idemple){
        boolean bool = false;
        String sql;
        DbBean conBD = new DbBean();
        ResultSet rstusu;

        try{
                sql = "select u.usuario, u.idEmpleado from usuario AS u where u.usuario = '"+ usur +"' or u.idEmpleado = "+ idemple;
            rstusu = conBD.resultadoSQL(sql);
        
            if (!rstusu.next()) {
                bool = true;  
            }
            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }

        return bool;
    }
    
    public boolean verifLogin(String usuario, String contra){
        
        String sql;
        DbBean conBD = new DbBean();
        ResultSet rst;
        boolean valida = false;
        try{
           sql = "select u.usuario, u.pw ";
           sql += "from Empleado as e inner join Rol as r on e.idRol = r.idRol ";
           sql += "inner join usuario as u on e.idEmpleado = u.idEmpleado ";
           sql += "where (r.nombreRol = 'Administrador' or r.nombreRol = 'Recepcionista') ";
           sql += "and u.usuario ='" + usuario + "' and u.pw = '" + contra + "'";

            
            rst = conBD.resultadoSQL(sql);
            if(rst.next()){//mueve el cursor al primer registro
                valida = true;
            }else{
                valida = false;
            }
          
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return valida;
       
        
        
        
        
    }
    
     public int ObtenerID(String usu){
            DbBean conBD = new DbBean();
            String sql;
            int usuar = 0;
            try{
                sql = "select u.idUsuario from usuario as u where u.usuario = '"+ usu +"'";
                ResultSet resul = conBD.resultadoSQL(sql);
                
                while(resul.next()) {
                    usuar = resul.getInt(1);
                }
                
            }catch(java.sql.SQLException e){
                e.printStackTrace();
            }
            try{
                conBD.desconecta();
            }catch(java.sql.SQLException e){
                e.printStackTrace();
            }
            return usuar;
     }
    
    public  String ObtenerRol(String usu){
            DbBean conBD = new DbBean();
            String sql;
            String usuar = "";
            try{
                sql = "select r.nombreRol from usuario as u inner join Empleado as e on u.idEmpleado = e.idEmpleado ";
                sql += " inner join Rol as r on e.idRol =  r.idRol where u.usuario = '"+ usu +"' ";
                ResultSet resul = conBD.resultadoSQL(sql);
                
                if (resul.next()) {
                    usuar = resul.getString(1);
                }
                
            }catch(java.sql.SQLException e){
                e.printStackTrace();
            }
            try{
                conBD.desconecta();
            }catch(java.sql.SQLException e){
                e.printStackTrace();
            }
            return usuar;
    }
    
    
}
