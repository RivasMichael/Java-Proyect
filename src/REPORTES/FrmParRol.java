
package REPORTES;

import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;


public class FrmParRol extends javax.swing.JInternalFrame {
    private static Map<String, Object> parametros;
    private String categoria;
    public FrmParRol() {
        initComponents();
        parametros = new HashMap<>();
        
    }
    public Map<String, Object> obtenerParametros() {
        if(this.categoria.equals("baja")){
            parametros.put("NumMin", 0);
            parametros.put("NumMax", 3);
            String logo = "/REPORTES/roles.png";
            parametros.put("logo", this.getClass().getResourceAsStream(logo));
        
        }
        
        if(this.categoria.equals("Alta")){
            parametros.put("NumMin", 4);
            parametros.put("NumMax", 20);
            String logo = "/REPORTES/roles.png";
            parametros.put("logo", this.getClass().getResourceAsStream(logo));

        }

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
        btnAlta = new javax.swing.JButton();
        tbnbaja = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Seleccionar:");

        btnAlta.setBackground(new java.awt.Color(255, 255, 0));
        btnAlta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAlta.setText("Alta Disponibilidad");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        tbnbaja.setBackground(new java.awt.Color(255, 51, 51));
        tbnbaja.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbnbaja.setText("Baja Disponibilidad");
        tbnbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnbajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbnbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(113, 113, 113))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbnbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnbajaActionPerformed
        HashMap map = new HashMap();
        this.categoria = "baja";
        map.put("NumMin", 0);
        map.put("NumMax", 3);
        String logo = "/REPORTES/roles.png";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        
        try{
            String ruta = "src/REPORTES/RepParRol.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, map, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_tbnbajaActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        HashMap map = new HashMap();
        this.categoria = "Alta";
        map.put("NumMin", 4);
        map.put("NumMax", 20);
        String logo = "/REPORTES/roles.png";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        
        try{
            String ruta = "src/REPORTES/RepParRol.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, map, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
 
    }//GEN-LAST:event_btnAltaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton tbnbaja;
    // End of variables declaration//GEN-END:variables
}
