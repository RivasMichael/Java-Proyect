package CORREO;

import REPORTES.FrmParActividad;
import REPORTES.FrmParCliente;
import REPORTES.FrmParEmpleado;
import REPORTES.FrmParEquipo;
import REPORTES.FrmParMant;
import REPORTES.FrmParRepuesto;
import REPORTES.FrmParRol;
import REPORTES.FrmParUsuario;
import REPORTES.FrmParVehiculo;
import UI.MDI;
import UTIL.DbBean;
import java.awt.Component;

import java.io.File; 
import java.sql.ResultSet;
import javax.mail.*;  
import javax.mail.internet.*;   
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FrmCorreo extends javax.swing.JInternalFrame {
    private DefaultListModel<String> dlm;
    private ArrayList<File> archivosAdjuntos; 
    private DefaultListModel<String> listModel;
    private static FrmParActividad frmActividad;
    private static FrmParCliente frmCliente;
    private static FrmParEmpleado frmEmpleado;
    private static FrmParEquipo frmEquipo;
    private static FrmParMant frmMantenimiento;
    private static FrmParRepuesto frmRepuesto;
    private static FrmParRol frmRol;
    private static FrmParUsuario frmUsuario;
    private static FrmParVehiculo frmVehiculo;
    private static String frmActual;
    private JDesktopPane escritorio;

    public FrmCorreo(JDesktopPane escritorio) {
        this.escritorio = escritorio;
        initComponents();
        llenarComboNombreApellido(); 
        agregarListener(); 
        listModel = new DefaultListModel<>(); 
        listReportesPdf.setModel(listModel); 
        frmActividad = new FrmParActividad();
        frmCliente = new FrmParCliente();
        frmActividad = new FrmParActividad();
        frmCliente = new FrmParCliente();
        frmEmpleado = new FrmParEmpleado();
        frmEquipo = new FrmParEquipo();
        frmMantenimiento = new FrmParMant();
        frmRepuesto = new FrmParRepuesto();
        frmRol = new FrmParRol();
        frmUsuario = new FrmParUsuario();
        frmVehiculo = new FrmParVehiculo();
        llenarCmbReportes();
    }
    
    
    public void llenarCmbReportes() {
            String rutaReportes = "src/REPORTES";
            File carpeta = new File(rutaReportes);
            if (carpeta.exists() && carpeta.isDirectory()) {
                // Obtiene la lista de archivos .jasper
                File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".jasper"));
                if (archivos != null) {
                    for (File archivo : archivos) {
                        this.cmbReportes.addItem(archivo.getName());
                    }
                }
            } else {
                System.out.println("La carpeta " + rutaReportes + " no existe o no es un directorio.");
            }
        
    }
    
    public void llenarComboNombreApellido() {
        DbBean conBD = new DbBean();
        Vector<String> nombresApellidos = new Vector<>();
        String sql = "SELECT DISTINCT CONCAT(nombres, ' ', apellidos) AS nombreCompleto FROM Empleado";
        try {
            ResultSet rs = conBD.resultadoSQL(sql);
            while (rs.next()) {
                nombresApellidos.add(rs.getString("nombreCompleto"));
            }
            conBD.desconecta();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cmbNombreApellido.setModel(new DefaultComboBoxModel<>(nombresApellidos));
    }
    public void rellenarCorreoPorNombre(String nombreCompleto) {
        DbBean conBD = new DbBean();
        String correo = "";
        String sql = "SELECT correo FROM Empleado WHERE CONCAT(nombres, ' ', apellidos) = '" + nombreCompleto + "'";
        try {
            ResultSet rs = conBD.resultadoSQL(sql);
            if (rs.next()) {
                correo = rs.getString("correo");
            }
            conBD.desconecta();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        txtCorreo.setText(correo);
    }

    private void agregarListener() {
        cmbNombreApellido.addActionListener(e -> {
            String nombreSeleccionado = (String) cmbNombreApellido.getSelectedItem();
            if (nombreSeleccionado != null && !nombreSeleccionado.isEmpty()) {
                rellenarCorreoPorNombre(nombreSeleccionado); 
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMensaje = new javax.swing.JTextField();
        cmbNombreApellido = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cmbEnviarCorreo = new javax.swing.JButton();
        cmbDescartarCorreo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbReportes = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnEliminarArchivos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listReportesPdf = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 53, 133));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ENVIAR CORREO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel5.setFont(new java.awt.Font("DejaVu Serif", 0, 15)); // NOI18N
        jLabel5.setText("Para:");

        jLabel6.setFont(new java.awt.Font("DejaVu Serif", 0, 15)); // NOI18N
        jLabel6.setText("Asunto:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mensaje");

        cmbNombreApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNombreApellidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAsunto)
                            .addComponent(txtCorreo)
                            .addComponent(cmbNombreApellido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbNombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        cmbEnviarCorreo.setText("ENVIAR CORREO");
        cmbEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEnviarCorreoActionPerformed(evt);
            }
        });

        cmbDescartarCorreo.setText("DESCARTAR CORREO");
        cmbDescartarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDescartarCorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(cmbEnviarCorreo)
                .addGap(88, 88, 88)
                .addComponent(cmbDescartarCorreo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEnviarCorreo)
                    .addComponent(cmbDescartarCorreo))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        jLabel7.setText("REPORTES");

        cmbReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbReportesActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminarArchivos.setText("Eliminar ");
        btnEliminarArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarArchivosActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listReportesPdf);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnEliminarArchivos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar))
                            .addComponent(cmbReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarArchivos)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limpiar(){
        this.txtCorreo.setText("");
        this.txtAsunto.setText("");
        this.txtMensaje.setText("");
        this.listModel.clear();

    }
    private void cmbEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEnviarCorreoActionPerformed
        try {
            File zipFile = convertirPdfAZip();

            if (zipFile == null) {
                return;
            }
            
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "alex2020per@gmail.com";
            String passwordRemitente = "juuw zscw rihs rvjr"; // Utiliza un método más seguro para manejar contraseñas
            String correoReceptor = txtCorreo.getText();
            String asunto = txtAsunto.getText();
            String mensaje = txtMensaje.getText();

            if (!validaEnviarCorreo(correoReceptor, asunto, mensaje)) {
                return; 
            }

            // Crear el mensaje de correo
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            // Crear un Multipart para adjuntar el archivo ZIP
            Multipart multipart = new MimeMultipart();

            // Parte del mensaje (cuerpo del correo)
            MimeBodyPart mensajeParte = new MimeBodyPart();
            mensajeParte.setText(mensaje);
            multipart.addBodyPart(mensajeParte);

            // Adjuntar el archivo ZIP generado
            MimeBodyPart adjuntoParte = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(zipFile);
            adjuntoParte.setDataHandler(new DataHandler(fds));
            adjuntoParte.setFileName(zipFile.getName());
            multipart.addBodyPart(adjuntoParte);

            // Asignar el contenido del mensaje con el adjunto
            message.setContent(multipart);

            // Enviar el correo
            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            // Mensaje de éxito
            JOptionPane.showMessageDialog(null, "Correo electrónico enviado con el archivo adjunto.");
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(FrmCorreo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al enviar el correo: " + ex.getMessage());
            limpiar();
        }
    
    }//GEN-LAST:event_cmbEnviarCorreoActionPerformed

    private void cmbDescartarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDescartarCorreoActionPerformed

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea descartar el correo?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
        }    
    }//GEN-LAST:event_cmbDescartarCorreoActionPerformed

    private void cmbNombreApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNombreApellidoActionPerformed
        this.cerrarOtrosFrames();
    }//GEN-LAST:event_cmbNombreApellidoActionPerformed

    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String reporteSeleccionado = (String) cmbReportes.getSelectedItem();
        if (reporteSeleccionado != null && !listModel.contains(reporteSeleccionado) || reporteSeleccionado.startsWith("RepPar")) {
            cerrarOtrosFrames();

            if(reporteSeleccionado.equals("RepParActividad.jasper")){
                this.frmActividad.setVisible(true);
                this.escritorio.add(frmActividad);
            }
            if(reporteSeleccionado.equals("RepParCliente.jasper")){
                this.frmCliente.setVisible(true);
                this.escritorio.add(frmCliente);
            }
            if(reporteSeleccionado.equals("RepParEmpleado.jasper")){
                this.frmEmpleado.setVisible(true);
                this.escritorio.add(frmEmpleado);
            }

            if(reporteSeleccionado.equals("RepParEquipo.jasper")){
                this.frmEquipo.setVisible(true);
                this.escritorio.add(frmEquipo);
            }

            if(reporteSeleccionado.equals("RepParMantenimiento.jasper")){
                this.frmMantenimiento.setVisible(true);
                this.escritorio.add(frmMantenimiento);
            }
            if(reporteSeleccionado.equals("RepParRepuesto.jasper")){
                this.frmRepuesto.setVisible(true);
                this.escritorio.add(frmRepuesto);
            }

            if(reporteSeleccionado.equals("RepParRol.jasper")){
                this.frmRol.setVisible(true);
                this.escritorio.add(frmRol);
            }
            if(reporteSeleccionado.equals("RepParUsuario.jasper")){
                this.frmUsuario.setVisible(true);
                this.escritorio.add(frmUsuario);
            }

            if(reporteSeleccionado.equals("RepParVehiculo.jasper")){
                this.frmVehiculo.setVisible(true);
                this.escritorio.add(frmVehiculo);
            }

            listModel.addElement(reporteSeleccionado); 
        } else {
            JOptionPane.showMessageDialog(this, "El reporte ya está en la lista o no es válido.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    private void cerrarOtrosFrames() {
        for (Component componente : escritorio.getComponents()) {
            if (componente instanceof JInternalFrame) {
                JInternalFrame frame = (JInternalFrame) componente;
                if (!(frame instanceof FrmCorreo)) {
                    try {
                        frame.setClosed(true); 
                    } catch (PropertyVetoException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    private void cmbReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbReportesActionPerformed

    }//GEN-LAST:event_cmbReportesActionPerformed

    private void btnEliminarArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarArchivosActionPerformed
    int selectedIndex = listReportesPdf.getSelectedIndex();

    if (selectedIndex != -1) {
        listModel.removeElementAt(selectedIndex);
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona un reporte para eliminar.");
    }
    }//GEN-LAST:event_btnEliminarArchivosActionPerformed
   private boolean validaEnviarCorreo(String destinatario ,String asunto, String mensaje) {
        if (asunto.isEmpty()) {
            txtAsunto.setText("Detalles de tu Servicio y Comprobante de Reparación");
            return true;
        }
        if (mensaje.isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Desea enviar el correo sin mensaje?", "Confirmar", JOptionPane.YES_NO_OPTION);
            return confirm == JOptionPane.YES_OPTION; 
        }
        if (!destinatario.endsWith("@gmail.com") &&
            !destinatario.endsWith("@outlook.com") &&
            !destinatario.endsWith("@ue.edu.pe") &&
            !destinatario.endsWith("@hotmail.com") &&
            !destinatario.endsWith("@yahoo.com")) {
            JOptionPane.showMessageDialog(this, "El correo del empleado no tiene un dominio válido permitido.");
            return false;
        }
        return true;
    }


    private File convertirPdfAZip() {

        String carpetaDestino = "C:/Java(Compilador)/PROGRAMCION final/ProyectoFinal1/ProyectoFinal/REPORTES";
        File directorio = new File(carpetaDestino);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        String archivoZip = carpetaDestino + "/ReportesPDF.zip";
        File zipFile = new File(archivoZip);

        DbBean db = new DbBean();
        if (!db.conecta()) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            return null;
        }

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            for (int i = 0; i < listModel.size(); i++) {
                String reporte = listModel.getElementAt(i);
                String rutaReporte = "src/REPORTES/" + reporte;

                File archivoReporte = new File(rutaReporte);
                if (!archivoReporte.exists()) {
                    JOptionPane.showMessageDialog(null, "El archivo del reporte no existe: " + rutaReporte);
                    continue;
                }

                try {
                    Map<String, Object> parametros = obtenerParametrosReporte(reporte);

                    if (reporte.equals("RepParActividad.jasper") && parametros.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Por favor, selecciona los parámetros para el reporte antes de continuar.");
                        return null; 
                    }


                    JasperPrint reportePDF = JasperFillManager.fillReport(rutaReporte, parametros, db.getDbCon());
                    File tempPdf = new File(carpetaDestino + "/" + reporte + ".pdf");
                    
                    JasperExportManager.exportReportToPdfFile(reportePDF, tempPdf.getAbsolutePath());

                    try (FileInputStream fis = new FileInputStream(tempPdf)) {
                        ZipEntry zipEntry = new ZipEntry(reporte + ".pdf");
                        zipOut.putNextEntry(zipEntry);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) > 0) {
                            zipOut.write(buffer, 0, length);
                        }
                    }

                } catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + reporte + " - " + e.getMessage());
                }
            }
            return zipFile;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el archivo ZIP: " + e.getMessage());
            return null;
        } finally {
            try {
                db.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    private Map<String, Object> obtenerParametrosReporte(String nombreReporte) {
        Map<String, Object> parametros = new HashMap<>();

        switch (nombreReporte) {
            case "RepSimActividad.jasper":
                String logo = "/REPORTES/actividad.jpg";
                parametros.put("logo", this.getClass().getResourceAsStream(logo));
                break;
            case "RepSimCliente.jasper":
                String logo2 = "/REPORTES/cliente.jpg";
                parametros.put("logo", this.getClass().getResourceAsStream(logo2));
                break;
            case "RepSimEmpleados.jasper":
                String logo3 = "/REPORTES/empleados.png";
                parametros.put("logo", this.getClass().getResourceAsStream(logo3));
                break;
            case "RepSimEquipo.jasper":
                String logo4 = "/REPORTES/equipo.jpg";
                parametros.put("logo", this.getClass().getResourceAsStream(logo4));
                break;
            case "RepSimMantenimiento.jasper":
                String logo5 = "/REPORTES/mantenimiento.jpg";
                parametros.put("logo", this.getClass().getResourceAsStream(logo5));
                break;
            case "RepSimRol.jasper":
                String logo6 = "/REPORTES/roles.png";
                parametros.put("logo", this.getClass().getResourceAsStream(logo6));
                break;
            case "RepSimUsuario.jasper":
                String logo7 = "/REPORTES/usuario.png";
                parametros.put("logo", this.getClass().getResourceAsStream(logo7));
                break;
            case "RepSimVehiculo.jasper":
                String logo8 = "/REPORTES/vehiculo.jpg";
                parametros.put("logo", this.getClass().getResourceAsStream(logo8));
                break;
            case "RepSimRepuesto.jasper":
                String logo9 = "/REPORTES/Repuestos.jpg";
                parametros.put("logo", this.getClass().getResourceAsStream(logo9));
                break;
            case "RepParActividad.jasper":
                if (frmActividad == null) {
                    frmActividad = new FrmParActividad();
                }
                
                parametros = frmActividad.obtenerParametros();
                break;
            case "RepParCliente.jasper":
                if (frmCliente == null) {
                    frmCliente = new FrmParCliente();
                }
                parametros = frmCliente.obtenerParametros();
                break;
            case "RepParEmpleado.jasper":
                if (frmEmpleado == null) {
                    frmEmpleado = new FrmParEmpleado();
                }
                parametros = frmEmpleado.obtenerParametros();
                break;
            case "RepParEquipo.jasper":
                if (frmEquipo == null) {
                    frmEquipo = new FrmParEquipo();
                }
                parametros = frmEquipo.obtenerParametros();
                break;
            case "RepParMantenimiento.jasper":
                if (frmMantenimiento == null) {
                    frmMantenimiento = new FrmParMant();
                }
                parametros = frmMantenimiento.obtenerParametros();
                break;
            case "RepParRepuesto.jasper":
                if (frmRepuesto == null) {
                    frmRepuesto = new FrmParRepuesto();
                }
                parametros = frmRepuesto.obtenerParametros();
                break;
            case "RepParRol.jasper":
                if (frmRol == null) {
                    frmRol = new FrmParRol();
                }
                parametros = frmRol.obtenerParametros();
                break;
            case "RepParUsuario.jasper":
                if (frmUsuario == null) {
                    frmUsuario = new FrmParUsuario();
                }
                parametros = frmUsuario.obtenerParametros();
                break;
            case "RepParVehiculo.jasper":
                if (frmVehiculo == null) {
                    frmVehiculo = new FrmParVehiculo();
                }
                parametros = frmVehiculo.obtenerParametros();
                break;        
                
            default:
                JOptionPane.showMessageDialog(null, "No se encontraron parámetros para el reporte: " + nombreReporte);
                break;
        }

        return parametros;
    }
    
    







    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminarArchivos;
    private javax.swing.JButton cmbDescartarCorreo;
    private javax.swing.JButton cmbEnviarCorreo;
    private javax.swing.JComboBox<String> cmbNombreApellido;
    private javax.swing.JComboBox<String> cmbReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listReportesPdf;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables

    private void agregarInternalFrame(FrmParActividad frmParametros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
