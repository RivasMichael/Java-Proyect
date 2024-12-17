
package UI;

import UTIL.DbBean;
import javax.swing.JFrame;

public class CrearBD extends javax.swing.JFrame {

    public CrearBD() {
        initComponents();
        txtIncorrecto.setVisible(false);
        llenarcmbPuerto();
        this.ver.setVisible(false);
        this.cerrar.setVisible(true);
    }
    private void llenarcmbPuerto() {
        this.cmbPuerto.addItem("");
        this.cmbPuerto.addItem("localhost");
        this.cmbPuerto.addItem("IP");
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPuerto = new javax.swing.JTextField();
        btnCrearBd = new javax.swing.JButton();
        txtIncorrecto = new javax.swing.JLabel();
        cmbPuerto = new javax.swing.JComboBox<>();
        ojo = new javax.swing.JPanel();
        ver = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        txtPw = new javax.swing.JPasswordField();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("USUARIO:");

        jLabel4.setBackground(new java.awt.Color(255, 0, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("CREAR O USAR BASE DE DATOS");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("CONTRASEÑA:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("SERVIDOR:");

        txtUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        txtPuerto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtPuerto.setEnabled(false);

        btnCrearBd.setBackground(new java.awt.Color(0, 0, 0));
        btnCrearBd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCrearBd.setForeground(new java.awt.Color(255, 255, 0));
        btnCrearBd.setText("CREAR BD");
        btnCrearBd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearBdActionPerformed(evt);
            }
        });

        txtIncorrecto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtIncorrecto.setForeground(new java.awt.Color(255, 0, 0));
        txtIncorrecto.setText("DATOS INCORRECTOS");

        cmbPuerto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cmbPuerto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbPuertoMouseClicked(evt);
            }
        });
        cmbPuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPuertoActionPerformed(evt);
            }
        });
        cmbPuerto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbPuertoKeyPressed(evt);
            }
        });

        ojo.setForeground(new java.awt.Color(255, 255, 255));
        ojo.setLayout(null);

        ver.setBackground(new java.awt.Color(255, 255, 255));
        ver.setForeground(new java.awt.Color(255, 255, 255));
        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/foto.png"))); // NOI18N
        ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                verMousePressed(evt);
            }
        });
        ojo.add(ver);
        ver.setBounds(10, 0, 20, 20);

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-ojo.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cerrarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cerrarMouseReleased(evt);
            }
        });
        ojo.add(cerrar);
        cerrar.setBounds(10, 0, 20, 29);

        txtPw.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPuerto)
                                    .addComponent(txtUser)
                                    .addComponent(cmbPuerto, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPw, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ojo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(txtIncorrecto, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnCrearBd, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ojo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPw))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtIncorrecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearBd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    
    private void btnCrearBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearBdActionPerformed

        String user = this.txtUser.getText();
        String pw = this.txtPw.getText();
        String puerto;
        String selected = this.cmbPuerto.getSelectedItem().toString();
        if(selected.equals("localhost")){
            puerto = selected;
        }else{
            puerto = puerto = this.txtPuerto.getText();
        }
        DbBean db = new DbBean(user,pw,puerto);
        if(db.dbExiste()==true){
            Login lo = new Login();
            lo.setVisible(true);
        }else{
            db.crearBD();
            Login log = new Login();
            log.setVisible(true);
        }
         this.dispose();

        
    }//GEN-LAST:event_btnCrearBdActionPerformed

    private void cmbPuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPuertoActionPerformed
        String selected = this.cmbPuerto.getSelectedItem().toString();
        System.out.println("Opción seleccionada: " + selected);

        if (selected.equals("IP")) {
            this.txtPuerto.setEnabled(true);
            this.txtPuerto.setVisible(true);  
        } else {
            this.txtPuerto.setEnabled(false);
        }
    }//GEN-LAST:event_cmbPuertoActionPerformed

    private void cmbPuertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbPuertoMouseClicked

    }//GEN-LAST:event_cmbPuertoMouseClicked

    private void cmbPuertoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbPuertoKeyPressed

    }//GEN-LAST:event_cmbPuertoKeyPressed

    private void verMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_verMousePressed

    private void cerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMousePressed
        ver.setVisible(true);
        cerrar.setVisible(false);
        txtPw.setEchoChar((char)0);
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarMousePressed

    private void cerrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseReleased
        ver.setVisible(false);
        cerrar.setVisible(true);
        txtPw.setEchoChar('*');
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarMouseReleased
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearBd;
    private javax.swing.JLabel cerrar;
    private javax.swing.JComboBox<String> cmbPuerto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel ojo;
    private javax.swing.JLabel txtIncorrecto;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JPasswordField txtPw;
    private javax.swing.JTextField txtUser;
    private javax.swing.JLabel ver;
    // End of variables declaration//GEN-END:variables
}
