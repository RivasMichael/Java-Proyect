
package UI.Mantenimiento;

import BEAN.Rol;
import DAO.RolDAO;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmMantRol extends javax.swing.JInternalFrame {
    DefaultTableModel dtmrol;
    RolDAO rodao;
    int idRol;

    public FrmMantRol() {
        initComponents();
        dtmrol = (DefaultTableModel)this.tblRol.getModel();
        rodao = new RolDAO();
        llenatblRol(false,"");
        llenarEstado();
        llenacmbAreaTra();
        llenarcmbNivAcce();
        this.tblRol.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.tblRol.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.tblRol.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.tblRol.getColumnModel().getColumn(5).setPreferredWidth(30);
    }
    
    public void llenatblRol(boolean sw, String cad){
        Vector<Rol> lisrol=rodao.listaRoles(sw, cad);
        dtmrol.setRowCount(0);
        for(int i=0;i<lisrol.size();i++){
            Vector vec =new Vector();
            vec.addElement(lisrol.get(i).getIdRol());
            vec.addElement(lisrol.get(i).getNombreRol());
            vec.addElement(lisrol.get(i).getAreaTrabajo());
            vec.addElement(lisrol.get(i).getNumMaxRol());
            vec.addElement(lisrol.get(i).getNivelAcceso());
            vec.addElement(lisrol.get(i).getEstado());
            dtmrol.addRow(vec);

        }

    }
    
    private void llenarEstado(){
        this.cmbEstado.addItem("");
        this.cmbEstado.addItem("Activo");
        this.cmbEstado.addItem("No Activo");
    }
    private void llenacmbAreaTra() {
        this.cmbAreaTra.addItem(""); 
        this.cmbAreaTra.addItem("Reparación y Mantenimiento");
        this.cmbAreaTra.addItem("Supervisión General");
        this.cmbAreaTra.addItem("Apoyo Logístico");
        this.cmbAreaTra.addItem("Administración y Ventas");
        this.cmbAreaTra.addItem("Almacén y Repuestos");
        this.cmbAreaTra.addItem("Atención al Cliente");
    }
    private void llenarcmbNivAcce() {
        this.cmbNivAcce.addItem(""); 
        this.cmbNivAcce.addItem("Medio");
        this.cmbNivAcce.addItem("Alto");
        this.cmbNivAcce.addItem("Bajo");
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cmbAreaTra = new javax.swing.JComboBox<>();
        cmbNivAcce = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();
        txtIdRol = new javax.swing.JTextField();
        txtNombRol = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumMaxRol = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRol = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtIdRol.setEnabled(false);

        txtNombRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombRolActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Estado");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("MANTENIMIENTO DE ROL");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Id Rol");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nombre de Rol");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Area Trabajo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Numero Máx. Rol");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Nivel de Acceso");

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        jLabel9.setText("Buscar");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 20, 38, 16);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar);
        txtBuscar.setBounds(70, 20, 620, 22);

        tblRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Rol", "Nombre de Rol", "Area de Trabajo", "N° Maximo de rol", "Nivel de Acceso", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRol);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 680, 180);

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(540, 250, 130, 31);

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGrabar.setBackground(new java.awt.Color(0, 255, 255));
        btnGrabar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(192, 192, 192))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNumMaxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbNivAcce, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbAreaTra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtNombRol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1)
                        .addGap(0, 251, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnGrabar)
                                .addComponent(btnLimpiar))
                            .addComponent(btnSalir))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbAreaTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNumMaxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cmbNivAcce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombRolActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        boolean verif;
	int idx;
	int idRol;
	idx = this.tblRol.getSelectedRow();
	idRol=Integer.parseInt(this.dtmrol.getValueAt(idx, 0).toString());
	verif=this.rodao.eliminaRol(idRol);  
	if(verif == true){
            JOptionPane.showMessageDialog(this, "Eliminación exitosa");
            this.llenatblRol(false, " ");
        }else{
            JOptionPane.showMessageDialog(this, "No es posible la eliminación");
        }
	this.btnEliminar.setEnabled(false);
        //limpia();                   
    }//GEN-LAST:event_btnEliminarActionPerformed
    private void limpia() {  
        this.txtIdRol.setText("");  
        this.txtNombRol.setText("");  
        this.cmbAreaTra.setSelectedItem("");  
        this.txtNumMaxRol.setText("");  
        this.cmbNivAcce.setSelectedItem("");  
        this.cmbEstado.setSelectedItem("");  
        this.btnGrabar.setText("Grabar");  
        this.txtBuscar.setText("");  
        this.llenatblRol(false, "");
    }
    private void tblRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolMouseClicked
        int idx = this.tblRol.getSelectedRow();
        this.txtIdRol.setText(this.dtmrol.getValueAt(idx, 0).toString());  
        this.txtNombRol.setText(this.dtmrol.getValueAt(idx, 1).toString());  
        this.cmbAreaTra.setSelectedItem(this.dtmrol.getValueAt(idx, 2).toString());  
        this.txtNumMaxRol.setText(this.dtmrol.getValueAt(idx, 3).toString());  
        this.cmbNivAcce.setSelectedItem(this.dtmrol.getValueAt(idx, 4).toString());  
        if(this.dtmrol.getValueAt(idx, 5).toString().equals("1")){
            this.cmbEstado.setSelectedItem("Activo");
        }else{
            this.cmbEstado.setSelectedItem("No Activo");
        }
       this.btnEliminar.setEnabled(true);
        this.btnGrabar.setText("Actualizar");
    }//GEN-LAST:event_tblRolMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    private boolean valida(){
        boolean sw = false;
        String cad = "";
        String soloLetrasRegex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        
        if(this.txtNombRol.getText().isEmpty()){
            cad = "Debe el nombre del rol ";
        }else if (!this.txtNombRol.getText().matches(soloLetrasRegex)) {
            cad += "\n El nombre del Rol solo deben contener solo letras";
        }
        
        if(this.cmbAreaTra.getSelectedItem().toString().isEmpty()){
            cad += "\nDebe seleccionar el Area de trabajo";
        }
        if(this.txtNumMaxRol.getText().isEmpty()){
            cad += "\nDebe llenar el numero máximo de roles";
        }else if (!this.txtNumMaxRol.getText().matches("\\d+")) {
            cad += "\n El NumMaxRol debe contener solo números";
        }
        
        if(this.cmbNivAcce.getSelectedItem().toString().isEmpty()){
            cad += "\nDebe seleccionar el nivel de acceso del rol";
        }
        if(this.cmbEstado.getSelectedItem().toString().isEmpty()){
            cad += "\nDebe seleccionar estado";
        }
        if(cad.isEmpty()){
            sw = true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return sw;
    }
    
    
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            Util u = new Util();
            Rol rol = new Rol();  
                rol.setNombreRol(this.txtNombRol.getText());  
                rol.setAreaTrabajo(this.cmbAreaTra.getSelectedItem().toString());  
                rol.setNumMaxRol(Integer.parseInt(this.txtNumMaxRol.getText()));  
                rol.setNivelAcceso(this.cmbNivAcce.getSelectedItem().toString());  

            if(this.cmbEstado.getSelectedItem().equals("Activo")){
                rol.setEstado(1);
            }else{
                rol.setEstado(0);
            }

            if(this.btnGrabar.getText().toString().equals("Grabar")){
                this.idRol = u.idNext("Rol", "idRol");
                rol.setIdRol(idRol);
                rodao.insertaRol(rol);
            }else{
                rol.setIdRol(Integer.parseInt(this.txtIdRol.getText()));
                rodao.actualizaRol(rol);
            }
            JOptionPane.showMessageDialog(this,"Rol grabado");
            limpia();
            this.llenatblRol(false, "");
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            this.llenatblRol(false, "");
        }else{
            this.llenatblRol(true, this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbAreaTra;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbNivAcce;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRol;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdRol;
    private javax.swing.JTextField txtNombRol;
    private javax.swing.JTextField txtNumMaxRol;
    // End of variables declaration//GEN-END:variables
}
