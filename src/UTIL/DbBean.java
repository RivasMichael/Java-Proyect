package UTIL;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class DbBean {
    static String puerto;
    static String dbURL;
    static String BaseDatos;
    static String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    private Connection dbCon;
    private static String login;
    private static String password; 

    public DbBean() {
        conecta();   
        System.out.println(this.dbURL);
        System.out.println(this.login);
        System.out.println(this.password);
    }
    public DbBean(String user, String pw, String puer) {
        this.login = user;
        this.password = pw;
        this.BaseDatos = "master";
        DbBean.puerto = puer;
        conecta(); 
    }
    
    public boolean conecta(){
        try{
            this.dbURL = "jdbc:sqlserver://" + this.puerto + ":1433;databaseName= "+BaseDatos+"";
            System.out.println("-------------------Conecta----------------");
            System.out.println(this.dbURL);
            System.out.println(this.login);
            System.out.println(this.password);
            Class.forName(this.dbDriver);
        }catch(java.lang.ClassNotFoundException e){
            System.out.println("Error en clase");
            return false;
        }
        try{
            this.dbCon = DriverManager.getConnection(this.dbURL, this.login, this.password);
        }catch(SQLException ex){
            System.out.println("No hay conexion al servidor");
            return false;
        }
        return true;
    }

    public void connectRep(String ruta, HashMap m, boolean sw) throws SQLException, JRException {
        conecta();
        JasperReport reporte = null;
        JasperPrint imp;
        reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
        if (sw == false) {
            imp = JasperFillManager.fillReport(reporte, null, dbCon);
        } else {
            imp = JasperFillManager.fillReport(reporte, m, dbCon);
        }
        if (imp.getPages().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos disponibles para generar el reporte.", "Reporte vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JasperViewer ver = new JasperViewer(imp, false);
        ver.setTitle("Reporte");
        ver.setVisible(true);
    }

    
    public void desconecta()throws SQLException{
        this.dbCon.close();
    }
    
       
    public ResultSet resultadoSQL(String sql)throws SQLException{
        Statement s = this.dbCon.createStatement();
        ResultSet r = s.executeQuery(sql);
        if(r==null){
            return null;
        }else{
            return r;
        }
    }
    public int ejecutaSQL(String sql)throws SQLException{
        Statement s = this.dbCon.createStatement();
        int r = s.executeUpdate(sql);
        if(r == 0){
            return 0;
        }else{
            return r;
        }
    }
    public boolean dbExiste() {
       
        String sql = "SELECT database_id FROM sys.databases WHERE name = ?";
        boolean existe = false;
        
        try (Connection conn = DriverManager.getConnection(this.dbURL, this.login, this.password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "BD_ORDEN_MANTENIMIENTO_PREVENTIVO");

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    existe = true;
                    System.out.println("Existe");
                    this.BaseDatos = "BD_ORDEN_MANTENIMIENTO_PREVENTIVO";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(existe == false){
            System.out.println("No Existe");
            JOptionPane.showMessageDialog(null, "NO existe La BD, creela");
        }
        return existe;
}
    
public boolean crearBD() {
    
    System.out.println("-----------------------crea----------------------");
    System.out.println(this.dbURL);
    System.out.println(this.login);
    System.out.println(this.password);
    boolean valida = false;
        String crearDB  = "CREATE DATABASE BD_ORDEN_MANTENIMIENTO_PREVENTIVO;\n";
        
        String crearTablas = "USE BD_ORDEN_MANTENIMIENTO_PREVENTIVO;\n\n" +
                "CREATE TABLE Cliente (\n" +
                "    idCliente INT CONSTRAINT pk_idCliente PRIMARY KEY,\n" +
                "    apellidos VARCHAR(100),\n" +
                "    nombres VARCHAR(100),\n" +
                "    telefono VARCHAR(20),\n" +
                "    direccion VARCHAR(255),\n" +
                "    correoElectronico VARCHAR(100),\n" +
                "    estado INT\n" +
                ");\n\n" +
                "CREATE TABLE Vehiculo (\n" +
                "    idVehiculo INT CONSTRAINT pk_idVehiculo PRIMARY KEY,\n" +
                "    placa VARCHAR(20),\n" +
                "    marca VARCHAR(50),\n" +
                "    modelo VARCHAR(50),\n" +
                "    año INT,\n" +
                "    estado INT\n" +
                ");\n\n" +
                "CREATE TABLE Mantenimiento (\n" +
                "    idMantenimiento INT CONSTRAINT pk_idMantenimiento PRIMARY KEY,\n" +
                "    descripcion VARCHAR(255),\n" +
                "    tipoMant VARCHAR(255),\n" +
                "    prioridad VARCHAR(255),\n" +
                "    periodoGarantia VARCHAR(100),\n" +
                "    estado INT\n" +
                ");\n\n" +
                "CREATE TABLE Rol (\n" +
                "    idRol INT CONSTRAINT pk_dRol PRIMARY KEY,\n" +
                "    nombreRol VARCHAR(255),\n" +
                "    areaTrabajo VARCHAR(255),\n" +
                "    NumMaxRol INT,\n" +
                "    nivelAcceso VARCHAR(255),\n" +
                "    estado INT\n" +
                ");\n\n" +
                "CREATE TABLE Empleado (\n" +
                "    idEmpleado INT CONSTRAINT pk_idEmpleado PRIMARY KEY,\n" +
                "    idRol INT CONSTRAINT fk_idRol FOREIGN KEY REFERENCES Rol(idRol),\n" +
                "    apellidos VARCHAR(100),\n" +
                "    nombres VARCHAR(100),\n" +
                "    telefono VARCHAR(20),\n" +
                "    direccion VARCHAR(255),\n" +
                "    correo VARCHAR(100),\n" +
                "    estado VARCHAR(50)\n" +
                ");\n\n" +
                "CREATE TABLE Usuario (\n" +
                "    idUsuario INT CONSTRAINT pk_idUsuario PRIMARY KEY,\n" +
                "    idEmpleado INT CONSTRAINT fk_idEmpleado FOREIGN KEY REFERENCES Empleado(idEmpleado),\n" +
                "    usuario VARCHAR(100),\n" +
                "    pw VARCHAR(100),\n" +
                "    fech_reg DATETIME,\n" +
                "    fech_mod DATETIME,\n" +
                "    estado INT\n" +
                ");\n\n" +
                "CREATE TABLE CabOrden (\n" +
                "    idOrden INT CONSTRAINT pk_idOrden PRIMARY KEY,\n" +
                "    idMantenimiento INT CONSTRAINT fk_idMantenimiento1 FOREIGN KEY REFERENCES Mantenimiento(idMantenimiento),\n" +
                "    idCliente INT CONSTRAINT fk_idCliente FOREIGN KEY REFERENCES Cliente(idCliente),\n" +
                "    idVehiculo INT CONSTRAINT fk_idVehiculo FOREIGN KEY REFERENCES Vehiculo(idVehiculo),\n" +
                "    fechProg DATE,\n" +
                "    fech_reg DATETIME,\n" +
                "    idUsuarioRegistro INT CONSTRAINT fk_idUsuario1 FOREIGN KEY REFERENCES Usuario(idUsuario),\n" +
                "    fech_mod DATETIME,\n" +
                "    idUsuarioModificacion INT CONSTRAINT fk_idUsuario3 FOREIGN KEY REFERENCES Usuario(idUsuario),\n" +
                "    obs VARCHAR(255),\n" +
                "    estado INT\n" +
                ");\n\n" +
                "CREATE TABLE Equipo (\n" +
                "    idEquipo INT CONSTRAINT pk_idEquipo PRIMARY KEY,\n" +
                "    numero_serie INT,\n" +
                "    nombre VARCHAR(255),\n" +
                "    marca VARCHAR(255),\n" +
                "    categoria VARCHAR(255),\n" +
                "    estado INT\n" +
                ");\n\n" +
                "CREATE TABLE Repuesto (\n" +
                "    idRepuesto INT CONSTRAINT pk_idRepuesto PRIMARY KEY,\n" +
                "    nombre VARCHAR(255),\n" +
                "    tipRepuesto VARCHAR(255),\n" +
                "    marca VARCHAR(255),\n" +
                "    numero_serie INT,\n" +
                "    stock INT,\n" +
                "    estado INT\n" +
                ");\n\n" +
                "CREATE TABLE Actividad (\n" +
                "    idActividad INT CONSTRAINT pk_idActividad PRIMARY KEY,\n" +
                "    descripcion VARCHAR(255),\n" +
                "    categoria VARCHAR(100),\n" +
                "    localizacion VARCHAR(100),\n" +
                "    nivelRiego VARCHAR(100),\n" +
                "    obs VARCHAR(100)\n" +
                ");\n\n" +
                "CREATE TABLE DetEmpleado (\n" +
                "    idOrden INT CONSTRAINT fk_idOrden FOREIGN KEY REFERENCES CabOrden(idOrden),\n" +
                "    idEmpleado INT CONSTRAINT fk_idEmpleado3 FOREIGN KEY REFERENCES Empleado(idEmpleado),\n" +
                "    idActividad INT CONSTRAINT fk_idActividad1 FOREIGN KEY REFERENCES Actividad(idActividad),\n" +
                "    fecha VARCHAR(100),\n" +
                "    numHoras INT\n" +
                ");\n\n" +
                "CREATE TABLE DetEquipo (\n" +
                "    idOrden INT CONSTRAINT fk_idOrden1 FOREIGN KEY REFERENCES CabOrden(idOrden),\n" +
                "    idEmpleado INT CONSTRAINT fk_idEmpleado2 FOREIGN KEY REFERENCES Empleado(idEmpleado),\n" +
                "    idEquipo INT CONSTRAINT fk_idEquipo FOREIGN KEY REFERENCES Equipo(idEquipo),\n" +
                "    idActividad INT CONSTRAINT fk_idActividad FOREIGN KEY REFERENCES Actividad(idActividad),\n" +
                "    fecha DATE,\n" +
                "    numHoras INT\n" +
                ");\n\n" +
                "CREATE TABLE DetRepuesto (\n" +
                "    idOrden INT CONSTRAINT fk_idOrden2 FOREIGN KEY REFERENCES CabOrden(idOrden),\n" +
                "    idRepuesto INT CONSTRAINT fk_idRepuesto FOREIGN KEY REFERENCES Repuesto(idRepuesto),\n" +
                "    unidadMedida VARCHAR(50),\n" +
                "    cantidad INT\n" +
                ")"+
                     
                " INSERT INTO rol VALUES (1, 'Administrador', 'Administración y Ventas', 2, 'Alto', 1) " +
                "INSERT INTO Rol VALUES (2, 'Técnico', 'Mantenimiento', 5, 'Medio', 1); " +
                "INSERT INTO Rol VALUES (3, 'Supervisor', 'Supervisión', 3, 'Alto', 1); " +
                "INSERT INTO Rol VALUES (4, 'Recepcionista', 'Atención al cliente', 5, 'Bajo', 1); " +
                
                "INSERT INTO Cliente VALUES (1, 'Pérez', 'Juan', '123456789', 'Calle Ficticia 123', 'juanperez@example.com', 1); " +
                "INSERT INTO Cliente VALUES (2, 'González', 'Maria', '987654321', 'Avenida Central 456', 'mariagonzalez@example.com', 1); " +
                "INSERT INTO Cliente VALUES (3, 'Martínez', 'Carlos', '456789123', 'Calle 12 789', 'carlosmartinez@example.com', 1); " +
                "INSERT INTO Cliente VALUES (4, 'Rodríguez', 'Ana', '654321987', 'Avenida 1 123', 'anarodriguez@example.com', 1); " +
                
                "INSERT INTO Empleado VALUES (101, 1, 'Quiliche', 'Andres', '973791546', 'Av. Principal 123', '22200144@ue.edu.pe', 1) "+
                "INSERT INTO Empleado VALUES (102, 2, 'López', 'Luisa', '223344556', 'Calle 12', 'jballon@esan.edu.pe', '1'); " +
                "INSERT INTO Empleado VALUES (103, 3, 'Fernández', 'Juan', '334455667', 'Calle 15', '22200144@ue.edu.pe', '1'); " +
                "INSERT INTO Empleado VALUES (104, 4, 'Gómez', 'Laura', '445566778', 'Calle 18', '22200217@ue.edu.pe', '1'); " +

                "INSERT INTO Mantenimiento VALUES (1, 'Cambio de aceite', 'Preventivo', 'Alta', '6 meses', 1); " +
                "INSERT INTO Mantenimiento VALUES (2, 'Revisión frenos', 'Correctivo', 'Media', '3 meses', 1); " +
                "INSERT INTO Mantenimiento VALUES (3, 'Chequeo general', 'Preventivo', 'Baja', '1 año', 1); " +
                "INSERT INTO Mantenimiento VALUES (4, 'Reemplazo de batería', 'Correctivo', 'Alta', '6 meses', 1); " +

                "INSERT INTO Vehiculo VALUES (1, 'ABC123', 'Toyota', 'Corolla', 2020, 1); " +
                "INSERT INTO Vehiculo VALUES (2, 'XYZ456', 'Honda', 'Civic', 2019, 1); " +
                "INSERT INTO Vehiculo VALUES (3, 'LMN789', 'Ford', 'Focus', 2018, 1); " +
                "INSERT INTO Vehiculo VALUES (4, 'DEF321', 'Chevrolet', 'Malibu', 2021, 1); " +

                "INSERT INTO Usuario VALUES (1001, 102, 'luisa_t', 'password123', '"+LocalDateTime.now()+"', '"+LocalDateTime.now()+"', 1); " +
                "INSERT INTO Usuario VALUES (1002, 103, 'juan_f', 'securepassword', '"+LocalDateTime.now()+"', '"+LocalDateTime.now()+"', 1); " +
                "INSERT INTO Usuario VALUES (1003, 104, 'Andres2', '1234', '"+LocalDateTime.now()+"', '"+LocalDateTime.now()+"', 1); " +
                "INSERT INTO Usuario VALUES (1004, 101, 'Andres', '1234', '"+LocalDateTime.now()+"', '"+LocalDateTime.now()+"', 1) ;"+
                
                "INSERT INTO CabOrden VALUES (1, 1, 2, 1, '2024-12-01', '"+LocalDateTime.now()+"', 2, '"+LocalDateTime.now()+"', 2, 'Reemplazo de aceite programado', 1); " +
                "INSERT INTO CabOrden VALUES (2, 2, 3, 2, '2024-12-05', '"+LocalDateTime.now()+"', 3, '"+LocalDateTime.now()+"', 3, 'Revisión de frenos', 1); " +
                "INSERT INTO CabOrden VALUES (3, 3, 4, 3, '2024-12-10', '"+LocalDateTime.now()+"', 4, '"+LocalDateTime.now()+"', 4, 'Chequeo general programado', 1); " +
                "INSERT INTO CabOrden VALUES (4, 4, 4, 4, '2024-12-15', '"+LocalDateTime.now()+"', 4, '"+LocalDateTime.now()+"', 4, 'Reemplazo de batería urgente', 1); " +

                "INSERT INTO Equipo VALUES (1, 12345, 'Compresor', 'Atlas Copco', 'Herramienta', 1); " +
                "INSERT INTO Equipo VALUES (2, 67890, 'Generador', 'Honda', 'Maquinaria', 1); " +
                "INSERT INTO Equipo VALUES (3, 11223, 'Soldadora', 'Lincoln', 'Herramienta', 1); " +
                "INSERT INTO Equipo VALUES (4, 44556, 'Bomba', 'Wacker', 'Maquinaria', 1); " +

                "INSERT INTO Repuesto VALUES (1, 'Aceite motor', 'Consumible', 'Castrol', 1001, 50, 1); " +
                "INSERT INTO Repuesto VALUES (2, 'Pastillas freno', 'Repuesto', 'Brembo', 1002, 30, 1); " +
                "INSERT INTO Repuesto VALUES (3, 'Batería', 'Repuesto', 'Bosch', 1003, 20, 1); " +
                "INSERT INTO Repuesto VALUES (4, 'Filtro aire', 'Repuesto', 'K&N', 1004, 15, 1); " +

                "INSERT INTO Actividad VALUES (1, 'Cambio de aceite', 'Mantenimiento', 'Taller A', 'Bajo', 'Cambio de aceite programado'); " +
                "INSERT INTO Actividad VALUES (2, 'Revisión frenos', 'Mantenimiento', 'Taller B', 'Medio', 'Revisión periódica de frenos'); " +
                "INSERT INTO Actividad VALUES (3, 'Chequeo general', 'Inspección', 'Taller C', 'Bajo', 'Chequeo preventivo'); " +
                "INSERT INTO Actividad VALUES (4, 'Reemplazo batería', 'Mantenimiento', 'Taller A', 'Alto', 'Reemplazo urgente de batería'); " +

                "INSERT INTO DetEmpleado VALUES (1, 2, 1, '2024-12-01', 3); " +
                "INSERT INTO DetEmpleado VALUES (2, 2, 2, '2024-12-05', 2); " +
                "INSERT INTO DetEmpleado VALUES (3, 3, 3, '2024-12-10', 4); " +
                "INSERT INTO DetEmpleado VALUES (4, 4, 4, '2024-12-15', 5); " +

                "INSERT INTO DetEquipo VALUES (1, 2, 1, 1, '2024-12-01', 2); " +
                "INSERT INTO DetEquipo VALUES (2, 2, 2, 2, '2024-12-05', 3); " +
                "INSERT INTO DetEquipo VALUES (3, 3, 3, 3, '2024-12-10', 4); " +
                "INSERT INTO DetEquipo VALUES (4, 4, 4, 4, '2024-12-15', 2); " +

                "INSERT INTO DetRepuesto VALUES (1, 1, 'Litro', 5); " +
                "INSERT INTO DetRepuesto VALUES (2, 2, 'Juego', 2); " +
                "INSERT INTO DetRepuesto VALUES (3, 3, 'Unidad', 1); " +
                "INSERT INTO DetRepuesto VALUES (4, 4, 'Unidad', 1); ";

        
        try (Connection conn = DriverManager.getConnection(this.dbURL, this.login, this.password);
            Statement stmt = conn.createStatement()) {

           stmt.execute(crearDB);
           System.out.println("Base de datos creada exitosamente.");
           this.BaseDatos = "BD_ORDEN_MANTENIMIENTO_PREVENTIVO";

           try (Connection connDB = DriverManager.getConnection(this.dbURL + ";databaseName="+this.BaseDatos+"", this.login, this.password);
                Statement stmtDB = connDB.createStatement()) {

               stmtDB.execute(crearTablas);
               JOptionPane.showMessageDialog(null, "Tablas creadas exitosamente");
               System.out.println("Tablas creadas exitosamente.");
               valida = true;
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }
        return valida;
    }
    public Connection getDbCon() {
        return this.dbCon; 
    }
}