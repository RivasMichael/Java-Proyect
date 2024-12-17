
package DAO;

import BEAN.Empleado;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class EmpleadoDAO {
    public EmpleadoDAO(){    
    }
    public Vector<Empleado> listaEmpleado(boolean sw, String cad){
        DbBean conBD= new DbBean();
        Vector<Empleado> listEmp= new Vector<Empleado>();
        String sql;
        ResultSet resultado;
        try{
            sql= "Select * from Empleado";
            if(sw){
                sql = sql + " where apellidos like '"+ cad + "%' ";
            }
            
            resultado = conBD.resultadoSQL(sql);
            while(resultado.next()){
                Empleado emp= new Empleado();
                emp.setIdEmpleado(resultado.getInt(1));
                emp.setIdRol(resultado.getInt(2));
                emp.setApellidos(resultado.getString(3));
                emp.setNombres(resultado.getString(4));
                emp.setTelefono(resultado.getString(5));
                emp.setDireccion(resultado.getString(6));
                emp.setCorreo(resultado.getString(7));
                emp.setEstado(resultado.getInt(8));
            
                listEmp.addElement(emp);                
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();  
        }
        try{
            conBD.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listEmp;
    }
    public Vector<String> filtrarTodosLosApellidos() {
        DbBean conBD = new DbBean();
        Vector<String> apellidosList = new Vector<String>();
        String sql = "select distinct  e.apellidos from Empleado as e inner join Usuario as u on e.idEmpleado = u.idEmpleado inner join CabOrden as c on u.idUsuario = c.idUsuarioRegistro";
        ResultSet resultado;

        try {
            resultado = conBD.resultadoSQL(sql);

            while (resultado.next()) {
                apellidosList.add(resultado.getString("apellidos"));
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conBD.desconecta();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }

        return apellidosList;
    }
    public void insertaEmpleado(Empleado emp){
        String sql;
        System.out.println("adsdfghjktredfghjkluytf");
        DbBean conBD = new DbBean();
        try{
            sql = "insert into Empleado values (";  
            sql += emp.getIdEmpleado() + ", "+ emp.getIdRol() +",  '" + emp.getApellidos() + "', '" + emp.getNombres() + "', '";  
            sql += emp.getTelefono()+ "', '" + emp.getDireccion() + "', '" + emp.getCorreo() + "', ";  
            sql += emp.getEstado() + " )";  
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
    
    public void actualizaEmpleado(Empleado emp){
        String sql;
        DbBean conBD = new DbBean();
        try{
            sql =" update Empleado set   idRol = "+ emp.getIdRol() +" , apellidos =  '" + emp.getApellidos();
            sql +="', nombres = '" + emp.getNombres() + "', telefono ='" + emp.getTelefono();
            sql +="', direccion=  '" + emp.getDireccion() + "', correo = '" + emp.getCorreo();
            sql +="' , estado = " + emp.getEstado()+" where idEmpleado = "+ emp.getIdEmpleado()  +"   " ;
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
    public boolean eliminaEmpleado(int idEmp){
        boolean sw= true;
        boolean sw1= true;
        boolean sw2= true;
        boolean sw3= true;
        String sql;
        String sql2;
        String sql3;
        DbBean conBD = new DbBean();
        String cad = "";
        try {  
            sql = "SELECT * FROM usuario WHERE idEmpleado = " + idEmp + " "; 
            sql2 = "SELECT * FROM DetEquipo WHERE idEmpleado = " + idEmp + " "; 
            sql3 = "SELECT * FROM DetEmpleado WHERE idEmpleado = " + idEmp + " "; 
            ResultSet rstUsur = conBD.resultadoSQL(sql);  
            ResultSet rstDetEquipo = conBD.resultadoSQL(sql2);  
            ResultSet rstDetEmp = conBD.resultadoSQL(sql3);  
            if (!rstUsur.next()) {  
                sw1 = true;
            }else{
                sw1 = false;
            }
            if (!rstDetEquipo.next()) {  
                sw2 = true;
            }else{
                sw2 = false;
            }
            if (!rstDetEmp.next()) {  
                sw3= true;
            }else{
                sw3= false;
            }
            System.out.println(cad);
           if(sw1 && sw2 && sw3){
               sql = "delete from empleado where idEmpleado = " + idEmp + " ";
               conBD.ejecutaSQL(sql);  
           }else{
               sw = false;
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
    

    public Vector<String> obtenerCorreosDeEmpleados() {
        DbBean conBD = new DbBean();
        Vector<String> listaCorreos = new Vector<>();
        String sql = "SELECT correo FROM Empleado"; // Consulta para obtener solo los correos
        ResultSet resultado;

        try {
            resultado = conBD.resultadoSQL(sql);

            while (resultado.next()) {
                String correo = resultado.getString("correo");
                listaCorreos.add(correo); // Agregar cada correo al vector
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conBD.desconecta();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }

        return listaCorreos;
    }
    
    
}
