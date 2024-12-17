
package REPORTES;
import java.util.HashMap;
import UTIL.DbBean;
import java.sql.SQLException;

import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

public class FrmParCliente extends javax.swing.JInternalFrame {
    private static Map<String, Object> parametros;
    public FrmParCliente() {
        initComponents();
        llenacmbEstado();
        parametros = new HashMap<>();
        
    }
    public Map<String, Object> obtenerParametros() {
        int estE;
        if (this.cmbEstadoEmpledo.getSelectedItem().toString().equals("Activo")) {
            estE = 1;
        } else {
            estE = 0;
        }
        parametros.put("Estado", estE);
        String logo = "/REPORTES/cliente.jpg";
        parametros.put("logo", this.getClass().getResourceAsStream(logo));
        
        return parametros;
    }
    public Map<String, Object> getParametros() {
        return parametros;
    }
 
    public void llenacmbEstado(){
            this.cmbEstadoEmpledo.addItem(" ");
            this.cmbEstadoEmpledo.addItem("Activo");
            this.cmbEstadoEmpledo.addItem("No activo ");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbEstadoEmpledo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Seleccionar");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Estado");

        cmbEstadoEmpledo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cmbEstadoEmpledo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoEmpledoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Reportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cmbEstadoEmpledo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(btnCerrar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnCerrar))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbEstadoEmpledo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int estE;

        if (this.cmbEstadoEmpledo.getSelectedItem().toString().equals("Activo")) {
            estE = 1;
        } else {
            estE = 0;
        }
        HashMap map = new HashMap();
        map.put("Estado", estE);
        String logo = "/REPORTES/cliente.jpg";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        try {
            String a = "src/REPORTES/RepParCliente.jasper";
            DbBean db = new DbBean();
            db.connectRep(a, map, true);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (JRException ex) {
            ex.printStackTrace();
}  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbEstadoEmpledoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoEmpledoActionPerformed

    }//GEN-LAST:event_cmbEstadoEmpledoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> cmbEstadoEmpledo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
