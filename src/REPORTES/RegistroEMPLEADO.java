
package REPORTES;

import DAO.EmpleadoDAO;
import UTIL.DbBean;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperExportManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.*;
import java.sql.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class RegistroEMPLEADO extends javax.swing.JInternalFrame {

    public RegistroEMPLEADO() {
        initComponents();
        llenarListApellidoAAA();
    }
    private void llenarListApellidoAAA() {
        try {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            Vector<String> apellidosList = empleadoDAO.filtrarTodosLosApellidos();
            DefaultListModel<String> modeloLista = new DefaultListModel<>();
            for (String apellido : apellidosList) {
                if (apellido != null && !apellido.trim().isEmpty()) {
                    modeloLista.addElement(apellido);
                }
            }
            listApellidoAA.setModel(modeloLista);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al obtener apellidos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }   
    private String generarReportePdf(String apellido, HashMap<String, Object> parametros) {
        String rutaDirectorio = "C:/Java(Compilador)/PROGRAMCION final/ProyectoFinalABCD/ProyectoFinal12345/ProyectoFinal/PDF Empleado/";
        verificarOCrearDirectorio(rutaDirectorio);
        String rutaPdf = rutaDirectorio + apellido + "_Reporte.pdf";
        DbBean db = new DbBean();

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("src/REPORTES/RegistroXEmpleado.jasper", parametros, db.getDbCon());
            JasperExportManager.exportReportToPdfFile(jasperPrint, rutaPdf);
            return rutaPdf;
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte para el apellido " + apellido + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return null;
    }

    private void verificarOCrearDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado: " + rutaDirectorio);
            } else {
                System.err.println("No se pudo crear el directorio: " + rutaDirectorio);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JToggleButton();
        btnEnviarGmail = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listApellidoAA = new javax.swing.JList<>();
        btnReportar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        btnSalir.setText("DESCARTAR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEnviarGmail.setText("ENVIAR GMAIL");
        btnEnviarGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarGmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnviarGmail)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnEnviarGmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORTE DE REGISTROS POR EMPLEADO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jScrollPane1.setViewportView(listApellidoAA);

        btnReportar.setText("Reportar");
        btnReportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReportar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReportar)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("GMAIL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarActionPerformed
        DefaultListModel<String> modeloLista = (DefaultListModel<String>) listApellidoAA.getModel();
        if (modeloLista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La lista de apellidos está vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String rutaReporte = "src/REPORTES/RegistroXEmpleado.jasper"; 
        DbBean db = new DbBean(); 
        Vector<String> exitos = new Vector<>(); 

        for (int i = 0; i < modeloLista.getSize(); i++) {
            String apellido = modeloLista.getElementAt(i);

            if (apellido == null || apellido.trim().isEmpty()) {
                continue; 
            }
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("Apellido", apellido);

            try {
                JasperReport reporte = (JasperReport) net.sf.jasperreports.engine.util.JRLoader.loadObjectFromFile(rutaReporte);
                JasperPrint imp = JasperFillManager.fillReport(reporte, parametros, db.getDbCon());

                // Validar si el reporte tiene páginas (es decir, si tiene datos)
                if (!imp.getPages().isEmpty()) {
                    // Mostrar el visor del reporte si tiene datos
                    JasperViewer ver = new JasperViewer(imp, false);
                    ver.setTitle("Reporte");
                    ver.setVisible(true);

                    exitos.add(apellido); // Agregar a la lista de éxitos
                } else {
                    System.out.println("Reporte en blanco para: " + apellido); // Depuración
                }
            } catch (JRException e) {
                System.err.println("Error generando reporte para: " + apellido);
                e.printStackTrace(); 
            }
        }

        if (exitos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se pudo generar ningún reporte con datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            StringBuilder mensajeExitos = new StringBuilder("Reportes generados para los siguientes apellidos con datos:\n");
            for (String apellido : exitos) {
                mensajeExitos.append("- ").append(apellido).append("\n");
            }
            JOptionPane.showMessageDialog(this, mensajeExitos.toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btnReportarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEnviarGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarGmailActionPerformed
  DefaultListModel<String> modeloLista = (DefaultListModel<String>) listApellidoAA.getModel();
    if (modeloLista.isEmpty()) {
        JOptionPane.showMessageDialog(this, "La lista de apellidos está vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String rutaReporte = "src/REPORTES/RegistroXEmpleado.jasper";
    DbBean db = new DbBean();
    Vector<String> exitos = new Vector<>(); // Lista de apellidos con reportes generados

    for (int i = 0; i < modeloLista.getSize(); i++) {
        String apellido = modeloLista.getElementAt(i);

        if (apellido == null || apellido.trim().isEmpty()) {
            continue;
        }

        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("Apellido", apellido);

        try {
            // Generar el reporte en PDF
            String rutaPdf = generarReportePdf(apellido, parametros);
            if (rutaPdf == null) {
                continue; // Si no se generó el PDF, omitir
            }

            // Verificar si el reporte tiene datos (si el archivo no está vacío)
            File archivoPdf = new File(rutaPdf);
            if (archivoPdf.length() > 0) {
                // Obtener el correo del empleado (supongamos que tienes un método para obtener el correo por apellido)
                String correoEmpleado = obtenerCorreoEmpleado(apellido); 

                // Si el correo es válido, enviar el reporte por correo
                if (correoEmpleado != null && !correoEmpleado.isEmpty()) {
                    if (enviarCorreo(correoEmpleado, rutaPdf)) {
                        exitos.add(apellido); // Agregar a la lista de éxitos si el correo fue enviado
                    } else {
                        System.err.println("Error enviando correo a: " + correoEmpleado);
                    }
                }
            } else {
                System.out.println("Reporte vacío para: " + apellido); // Si el archivo PDF está vacío
            }
        } catch (Exception e) {
            System.err.println("Error generando o enviando reporte para: " + apellido);
            e.printStackTrace();
        }
    }

    if (exitos.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se pudo generar o enviar ningún reporte con datos.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        StringBuilder mensajeExitos = new StringBuilder("Reportes enviados para los siguientes apellidos:\n");
        for (String apellido : exitos) {
            mensajeExitos.append("- ").append(apellido).append("\n");
        }
        JOptionPane.showMessageDialog(this, mensajeExitos.toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }


        
    }//GEN-LAST:event_btnEnviarGmailActionPerformed

private boolean enviarCorreo(String destinatario, String archivoAdjunto) {
    String correoRemitente = "alex2020per@gmail.com";
    String passwordRemitente = "juuw zscw rihs rvjr"; 

    try {
        // Configuración de la sesión de correo
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);

        // Crear el mensaje de correo
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(correoRemitente));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

        // Establecer el asunto del correo
        message.setSubject("REPORTE DE SUS VENTAS");  // Aquí pones el asunto que desees

        // Crear la parte del cuerpo del mensaje
        MimeBodyPart textoParte = new MimeBodyPart();
        textoParte.setText("Adjunto se encuentra su reporte.", "ISO-8859-1", "html");

        // Crear la parte del archivo adjunto
        MimeBodyPart adjuntoParte = new MimeBodyPart();
        adjuntoParte.setDataHandler(new DataHandler(new FileDataSource(archivoAdjunto)));
        adjuntoParte.setFileName(new File(archivoAdjunto).getName());

        // Crear la estructura Multipart para el mensaje
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(textoParte);
        multipart.addBodyPart(adjuntoParte);
        message.setContent(multipart);

        // Enviar el mensaje
        Transport transport = session.getTransport("smtp");
        transport.connect(correoRemitente, passwordRemitente);
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();

        return true; // Correo enviado con éxito
    } catch (Exception e) {
        System.err.println("Error enviando correo: " + e.getMessage());
        e.printStackTrace();
    }
    return false; // Error al enviar el correo


}

private String obtenerCorreoEmpleado(String apellido) {
    // Supongamos que tienes un método para obtener el correo electrónico del empleado
    // Aquí se podría hacer una consulta a la base de datos
    // Ejemplo: SELECT correo FROM Empleado WHERE apellido = ?
    
    String correo = ""; 
    DbBean db = new DbBean();
    String sql = "SELECT correo FROM Empleado WHERE apellidos = '" + apellido + "'";
    try {
        ResultSet rs = db.resultadoSQL(sql);
        if (rs.next()) {
            correo = rs.getString("correo");
        }
        db.desconecta();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return correo;
}
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarGmail;
    private javax.swing.JButton btnReportar;
    private javax.swing.JToggleButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listApellidoAA;
    // End of variables declaration//GEN-END:variables
}
