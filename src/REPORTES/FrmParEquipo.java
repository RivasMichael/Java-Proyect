package REPORTES;

    import UTIL.DbBean;
    import java.sql.SQLException;
    import java.util.HashMap;
import java.util.Map;
    import javax.swing.JOptionPane;
    import net.sf.jasperreports.engine.JRException;

public class FrmParEquipo extends javax.swing.JInternalFrame {
    private static Map<String, Object> parametros;

    public FrmParEquipo() {
        initComponents();
        parametros = new HashMap<>();
        llenaCmbCategoria();
    }
    public Map<String, Object> obtenerParametros() {
        int estE;
        String cat = this.cmbCategoria.getSelectedItem().toString();
        parametros.put("categoria", cat);
        String logo = "/REPORTES/equipo.jpg";
        parametros.put("logo", this.getClass().getResourceAsStream(logo));

        return parametros;
    }
    public Map<String, Object> getParametros() {
        return parametros;
    }
    
    
    private void llenaCmbCategoria(){
        this.cmbCategoria.addItem("");
        this.cmbCategoria.addItem("Máquina Herramienta");
        this.cmbCategoria.addItem("Soldadura");
        this.cmbCategoria.addItem("Compresor");
        this.cmbCategoria.addItem("Herramienta Eléctrica");
        this.cmbCategoria.addItem("Máquina CNC");
        this.cmbCategoria.addItem("Herramienta Eléctrica");
        this.cmbCategoria.addItem("Prensas");
        this.cmbCategoria.addItem("Gas Industrial");
        this.cmbCategoria.addItem("Gas Combustible");
        this.cmbCategoria.addItem("Lubricante");
        this.cmbCategoria.addItem("Instrumento de Medición");
        this.cmbCategoria.addItem("Herramienta Manual");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Seleccionar de categoría");

        cmbCategoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbCategoriaMouseClicked(evt);
            }
        });
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Reportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed

    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void cmbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCategoriaMouseClicked
        
    }//GEN-LAST:event_cmbCategoriaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cat = this.cmbCategoria.getSelectedItem().toString();
        DbBean rep = new DbBean();
        HashMap map = new HashMap();
        map.put("categoria", cat);
        String logo = "/REPORTES/equipo.jpg";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        
        try{
            String ruta = "src/REPORTES/RepParEquipo.jasper";
            rep.connectRep(ruta, map, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private class txtAño {

        public txtAño() {
        }
    }
}
