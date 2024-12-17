
package REPORTES;
import java.util.HashMap;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

public class FrmParEmpleado extends javax.swing.JInternalFrame {
    private static Map<String, Object> parametros;
    public FrmParEmpleado() {
        initComponents();
        parametros = new HashMap<>();
        llenacmbEstado();   
    }
    public Map<String, Object> obtenerParametros() {
        int estE;
        if (this.cmbEstadoEmpleado.getSelectedItem().toString().equals("Activo")) {
            estE=1;
        } else {
            estE=0;
        }
        parametros.put("Estado", estE);
        String logo = "/REPORTES/empleados.png";
        parametros.put("logo", this.getClass().getResourceAsStream(logo));
        return parametros;
    }
    public Map<String, Object> getParametros() {
        return parametros;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbEstadoEmpleado = new javax.swing.JComboBox<>();
        btnEstado = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Estado Empleado");

        cmbEstadoEmpleado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnEstado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEstado.setText("Reportar");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Seleccionar ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbEstadoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEstadoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstado))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        int estE;

        if (this.cmbEstadoEmpleado.getSelectedItem().toString().equals("Activo")) {
            estE=1;
        } else {
            estE=0;
        }
        HashMap  map = new HashMap();
        map.put("Estado", estE);
        String logo = "/REPORTES/empleados.png";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        try {
            String a = "src/REPORTES/RepParEmpleado.jasper";
            DbBean db = new DbBean();
            db.connectRep(a, map, true);

        } catch (SQLException ex){
            ex.printStackTrace();
        } catch (JRException ex){
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnEstadoActionPerformed
    public void llenacmbEstado(){
        this.cmbEstadoEmpleado.addItem(" ");
        this.cmbEstadoEmpleado.addItem("Activo");
        this.cmbEstadoEmpleado.addItem("No activo ");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEstado;
    private javax.swing.JComboBox<String> cmbEstadoEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
