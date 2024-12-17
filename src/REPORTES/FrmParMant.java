package REPORTES;

    import UTIL.DbBean;
    import java.sql.SQLException;
    import java.util.HashMap;
import java.util.Map;
    import net.sf.jasperreports.engine.JRException;

public class FrmParMant extends javax.swing.JInternalFrame {
    private static Map<String, Object> parametros;
    private String categoria;
    public FrmParMant() {
        initComponents();
        parametros = new HashMap<>();
    }
    
    public Map<String, Object> obtenerParametros() {
        if(this.categoria.equals("baja")){
            parametros.put("Prioridad", "Baja");
            String logo = "/REPORTES/mantenimiento.jpg";
            parametros.put("logo", this.getClass().getResourceAsStream(logo));
        }
        
        if(this.categoria.equals("Alta")){
            parametros.put("Prioridad", "Alta");
            String logo = "/REPORTES/mantenimiento.jpg";
            parametros.put("logo", this.getClass().getResourceAsStream(logo));
        }
        if(this.categoria.equals("Media")){
            parametros.put("Prioridad", "Media");
            String logo = "/REPORTES/mantenimiento.jpg";
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
        btnBaja = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnMedia = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Seleccionar de prioridad");

        btnBaja.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBaja.setText("Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btnAlta.setBackground(new java.awt.Color(255, 204, 204));
        btnAlta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAlta.setText("Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnMedia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnMedia.setText("Media");
        btnMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMediaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
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

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        HashMap map = new HashMap();
        this.categoria = "baja";
        map.put("Prioridad", "Baja");
        String logo = "/REPORTES/mantenimiento.jpg";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        
        try{
            String ruta = "src/REPORTES/RepParMantenimiento.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, map, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        HashMap map = new HashMap();
        this.categoria = "Alta";
        map.put("Prioridad", "Alta");
        String logo = "/REPORTES/mantenimiento.jpg";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        
        try{
            String ruta = "src/REPORTES/RepParMantenimiento.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, map, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMediaActionPerformed
        HashMap map = new HashMap();
        this.categoria = "Media";
        map.put("Prioridad", "Media");
        String logo = "/REPORTES/mantenimiento.jpg";
        map.put("logo", this.getClass().getResourceAsStream(logo));
        
        try{
            String ruta = "src/REPORTES/RepParMantenimiento.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, map, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMediaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnMedia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
