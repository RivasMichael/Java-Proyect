/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REPORTES;

import UTIL.DbBean;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

public class FrmParRepuesto extends javax.swing.JInternalFrame {
    private static Map<String, Object> parametros;
    private String categoria;
    public FrmParRepuesto() {
        parametros = new HashMap<>();
        initComponents();        

    }
    public Map<String, Object> obtenerParametros() {
        if(this.categoria.equals("mayor")){
            parametros.put("Mayor", 5); 
            parametros.put("Menor", 100);
           String logo = "/REPORTES/Repuestos.jpg";
           parametros.put("logo", this.getClass().getResourceAsStream(logo));
        }
        
        if(this.categoria.equals("menor")){
            parametros.put("Mayor", 0); 
            parametros.put("Menor", 10);
            String logo = "/REPORTES/Repuestos.jpg";
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
        btnMayor = new javax.swing.JButton();
        btnMenor = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("REPUESTO ");

        btnMayor.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnMayor.setText("Mayor Stock");
        btnMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMayorActionPerformed(evt);
            }
        });

        btnMenor.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnMenor.setText("Menor Stock");
        btnMenor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenor, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(btnMayor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
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

    private void btnMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMayorActionPerformed
        HashMap map= new HashMap();
        this.categoria = "mayor";
         map.put("Mayor", 5); 
         map.put("Menor", 100);
        String logo = "/REPORTES/Repuestos.jpg";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        try{
            String r="src/REPORTES/RepParRepuesto.jasper";
            DbBean db=new DbBean();
            db.connectRep(r, map, true);
        }catch(SQLException e){
          e.printStackTrace();
        }catch(JRException ex){
        ex.printStackTrace();
        
        }
        
    }//GEN-LAST:event_btnMayorActionPerformed

    private void btnMenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenorActionPerformed
        this.categoria = "menor";
        HashMap map= new HashMap();
         map.put("Mayor", 0); 
         map.put("Menor", 10);
         String logo = "/REPORTES/Repuestos.jpg";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        try{
            String r="src/REPORTES/RepParRepuesto.jasper";
            DbBean db=new DbBean();
            db.connectRep(r, map, true);
        }catch(SQLException e){
          e.printStackTrace();
        }catch(JRException ex){
        ex.printStackTrace();
        
        }
    }//GEN-LAST:event_btnMenorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMayor;
    private javax.swing.JButton btnMenor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
