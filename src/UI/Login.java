
package UI;

import DAO.UsuarioDAO;
import UTIL.DbBean;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    UsuarioDAO userDao;
    
    public Login() {
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ver.setVisible(false);
        cerrar.setVisible(true);
        txtFail.setVisible(false);
        userDao = new UsuarioDAO();
        this.setLocationRelativeTo(null);
        Fondos panelFondo = new Fondos();
        panelFondo.setImagen("/Imagenes/Login2.jpg");

        this.setContentPane(panelFondo);
        panelFondo.setLayout(null); 
        panelFondo.add(this.txtUser);
        panelFondo.add(this.txtContra);
        panelFondo.add(this.btnEntrar);
        panelFondo.add(this.iconlogin);
        panelFondo.add(this.txtFail);
        panelFondo.add(this.subUsuario);
        panelFondo.add(this.subContra);
        panelFondo.add(this.ojo);

    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        txtFail = new javax.swing.JLabel();
        subUsuario = new javax.swing.JLabel();
        subContra = new javax.swing.JLabel();
        ojo = new javax.swing.JPanel();
        ver = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        iconlogin = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));

        txtUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txtContra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraActionPerformed(evt);
            }
        });

        btnEntrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEntrar.setText("ENTRAR");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        txtFail.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        txtFail.setForeground(new java.awt.Color(255, 0, 0));
        txtFail.setText("CONTRASEÑA O USUARIO INCORRECTO");

        subUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subUsuario.setForeground(new java.awt.Color(255, 255, 255));
        subUsuario.setText("USUARIO:");

        subContra.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subContra.setForeground(new java.awt.Color(255, 255, 255));
        subContra.setText("CONTRASEÑA:");

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

        iconlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(subContra, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(subUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(iconlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ojo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(txtFail, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(iconlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subContra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ojo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrar)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        boolean login;
        String user = txtUser.getText();

        String pass = String.valueOf(txtContra.getPassword());

        login =userDao.verifLogin(user, pass);
        if(login == true){
            String rol = userDao.ObtenerRol(user);
            System.out.println(rol);
            if(rol.equals("Administrador")){
                int idUsuaIngreso =  userDao.ObtenerID(txtUser.getText());
                
                System.out.println(idUsuaIngreso);
                MDI mdi = new MDI(idUsuaIngreso);
                mdi.setVisible(true);
                mdi.setvisible();
                this.dispose();

            }
            if(rol.equals("Recepcionista")){
                int idUsuaIngreso =  userDao.ObtenerID(txtUser.getText());
                MDI mdi = new MDI(idUsuaIngreso);
                mdi.setVisible(true);
                this.dispose();
            }

        }else{
            txtFail.setVisible(true);

        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void cerrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseReleased
        ver.setVisible(false);
        cerrar.setVisible(true);
        txtContra.setEchoChar('*');
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarMouseReleased

    private void cerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMousePressed
        ver.setVisible(true);
        cerrar.setVisible(false);
        txtContra.setEchoChar((char)0);
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarMousePressed

    private void verMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_verMousePressed

    private void txtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed
    private void cerrar(){
        this.dispose();;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String user = "OMP";
                String pw = "123456789";
                String puerto = "localhost";
                DbBean db = new DbBean(user,pw,puerto);
                if(db.dbExiste()==true){
                    new Login().setVisible(true);
                }else{
                    CrearBD par = new CrearBD();
                    par.setVisible(true);
                }
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel iconlogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel ojo;
    private javax.swing.JLabel subContra;
    private javax.swing.JLabel subUsuario;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JLabel txtFail;
    private javax.swing.JTextField txtUser;
    private javax.swing.JLabel ver;
    // End of variables declaration//GEN-END:variables
}
