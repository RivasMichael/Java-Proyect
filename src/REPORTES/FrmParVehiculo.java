
package REPORTES;

import BEAN.Vehiculo;
import DAO.VehiculoDAO;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import net.sf.jasperreports.engine.JRException;


public class FrmParVehiculo extends javax.swing.JInternalFrame {
    VehiculoDAO vehidao;
    private static Map<String, Object> parametros;
    public FrmParVehiculo() {
        this.initComponents();
        vehidao = new VehiculoDAO();
        parametros = new HashMap<>();
        llenarMarca();
    }
    public Map<String, Object> obtenerParametros() {
        String mar = this.cmbMarca.getSelectedItem().toString();
        parametros.put("MarcaVehi", mar);
        String logo = "/REPORTES/vehiculo.jpg";
        parametros.put("logo", this.getClass().getResourceAsStream(logo));
        return parametros;
    }
    public Map<String, Object> getParametros() {
        return parametros;
    }
    
    
    private void llenarMarca() {
        Vector<Vehiculo> v = vehidao.listaVehiculos(false, ""); 
        for (int i = 0; i < v.size(); i++) {
            this.cmbMarca.addItem(v.get(i).getMarca());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbMarca = new javax.swing.JComboBox<>();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        btnReport.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReport.setText("REPORTAR");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setText("SELECCIONA MARCA");

        cmbMarca.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
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

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed

        String mar = this.cmbMarca.getSelectedItem().toString();
        HashMap map = new HashMap();
        map.put("MarcaVehi", mar);
        String logo = "/REPORTES/vehiculo.jpg";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        try{
            String r="src/REPORTES/RepParVehiculo.jasper";
            DbBean db=new DbBean();
            db.connectRep(r, map, true);
        }catch(SQLException e){
          e.printStackTrace();
        }catch(JRException ex){
        ex.printStackTrace();
        
        }
        
 
        // TODO add your handling coe here:
    }//GEN-LAST:event_btnReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
