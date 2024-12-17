
package REPORTES;

import DAO.ActividadDAO;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;


public class FrmParActividad extends javax.swing.JInternalFrame {
    private static Map<String, Object> parametros;
    public FrmParActividad() {
        initComponents();
        llenarComboBoxCategorias();
        parametros = new HashMap<>();
    }
    
    public Map<String, Object> obtenerParametros() {
        String d = cmbCategoriaActi.getSelectedItem().toString();
        parametros.put("paraActiviada_1", d);
        String logo = "/REPORTES/actividad.jpg";
        parametros.put("logo", this.getClass().getResourceAsStream(logo));

        return parametros;
    }
    public Map<String, Object> getParametros() {
        return parametros;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCategoriaActi = new javax.swing.JComboBox<>();
        btnReportar_Actividad = new javax.swing.JButton();

        setClosable(true);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 102));
        jLabel1.setText("Selecciona");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Categoria");

        cmbCategoriaActi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmbCategoriaActi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActiActionPerformed(evt);
            }
        });

        btnReportar_Actividad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReportar_Actividad.setText("Reportar");
        btnReportar_Actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportar_ActividadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbCategoriaActi, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnReportar_Actividad)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCategoriaActi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(btnReportar_Actividad))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportar_ActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportar_ActividadActionPerformed
    String d = cmbCategoriaActi.getSelectedItem().toString();
    if (d.equals("Seleccione una categoría")) {
        JOptionPane.showMessageDialog(this, "Por favor seleccione una categoría válida.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    HashMap map = new HashMap<>();
    map.put("paraActiviada_1", d);
    
    try {
        String logo = "/REPORTES/actividad.jpg";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        String r = "src/REPORTES/RepParActividad.jasper";
        DbBean db = new DbBean();
        db.connectRep(r, map, true);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (JRException ex) {
        JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    }//GEN-LAST:event_btnReportar_ActividadActionPerformed

    private void cmbCategoriaActiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActiActionPerformed

    
    
    private void llenarComboBoxCategorias() {
    ActividadDAO actividadDAO = new ActividadDAO(); // Crear una instancia de ActividadDAO
    Vector<String> categorias = actividadDAO.listaCategorias(); // Obtener las categorías únicas desde la base de datos

    cmbCategoriaActi.removeAllItems(); // Limpiar el combo box antes de llenarlo
    cmbCategoriaActi.addItem("Seleccione una categoría"); // Agregar una opción por defecto

    for (String categoria : categorias) {
        cmbCategoriaActi.addItem(categoria); // Agregar cada categoría al combo box
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportar_Actividad;
    private javax.swing.JComboBox<String> cmbCategoriaActi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
