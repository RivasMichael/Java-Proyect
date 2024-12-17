
package UI.Mantenimiento;

import BEAN.Mantenimiento;
import DAO.MantenimientoDAO;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmMantMantenimiento extends javax.swing.JInternalFrame {
    DefaultTableModel dtmMant;
    MantenimientoDAO mandao;
    int idMant;
    public FrmMantMantenimiento() {
        initComponents();
        dtmMant = (DefaultTableModel)this.tblMantenimiento.getModel();
        mandao = new MantenimientoDAO();
        llenartblMantenimiento(false,"");
        llenarbtnTipoMant();
        llenarbtnPrioridad();
        llenarcmbEstado();
        this.tblMantenimiento.getColumnModel().getColumn(1).setPreferredWidth(200);
    }
    
    private void llenartblMantenimiento(boolean bool, String cad){
         Vector<Mantenimiento> equi;
         equi = mandao.listaMantenimiento(bool, cad);
         dtmMant.setRowCount(0);
         for(int i=0; i<equi.size();i++){
             Vector vec = new Vector();
             vec.addElement(equi.get(i).getIdMantenimiento());
             vec.addElement(equi.get(i).getDescripcion());
             vec.addElement(equi.get(i).getTipoMant());
             vec.addElement(equi.get(i).getPrioridad());
             vec.addElement(equi.get(i).getPeriodoGarantia());
             vec.addElement(equi.get(i).getEstado());
             dtmMant.addRow(vec);
         }
     }
    public void llenarbtnTipoMant() {

    this.cmbTipMante.addItem("");
    this.cmbTipMante.addItem("Preventivo");
    this.cmbTipMante.addItem("Correctivo");
    }
    private void llenarcmbEstado(){
        this.cmbEstado.addItem("");
        this.cmbEstado.addItem("Activo");
        this.cmbEstado.addItem("No Activo");
    }

    public void llenarbtnPrioridad() {
        this.cmbPrioridad.addItem("");
        this.cmbPrioridad.addItem("Alta");
        this.cmbPrioridad.addItem("Media");
        this.cmbPrioridad.addItem("Baja");
    }
    
    private void limpiar(){
        this.txtidMantenimiento.setText("");
        this.txtDescripcion.setText("");
        this.cmbPrioridad.setSelectedItem("");
        this.cmbTipMante.setSelectedItem("");
        this.txtPeriGarantia.setText("");
        this.cmbEstado.setSelectedItem("");
        this.btnGrabar.setText("Grabar");
        this.llenartblMantenimiento(false, "");
        this.txtBuscar.setText("");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtidMantenimiento = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        cmbPrioridad = new javax.swing.JComboBox<>();
        cmbTipMante = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMantenimiento = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPeriGarantia = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Mantenimiento");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Descripcion");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Id Mantenimiento");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Tipo Mantenimiento");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Prioridad");

        txtidMantenimiento.setEnabled(false);

        cmbPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPrioridadActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setLayout(null);

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
        jPanel3.add(txtBuscar);
        txtBuscar.setBounds(80, 10, 440, 22);

        jLabel6.setText("Buscar:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 10, 50, 16);

        tblMantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Mantenimiento", "Descripcion", "Tipo Mantenimiento", "Prioridad", "Periodo de Garantia", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMantenimientoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMantenimiento);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 670, 150);

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar);
        btnEliminar.setBounds(562, 200, 107, 31);

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

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Periodo de Garantia");

        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(60, 60, 60)
                        .addComponent(txtDescripcion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipMante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(74, 74, 74)
                        .addComponent(cmbPrioridad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPeriGarantia))))
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(423, 423, 423))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipMante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPeriGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir)
                    .addComponent(btnGrabar))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPrioridadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPrioridadActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int ixd = this.tblMantenimiento.getSelectedRow();
        System.out.println(this.dtmMant.getValueAt(ixd, 0).toString());
        int idemant = Integer.parseInt(this.dtmMant.getValueAt(ixd, 0).toString());
        
        if(this.mandao.eliminaMantenimiento(idemant) == false){
            JOptionPane.showMessageDialog(this,"Existe Tablas dependientes");
        }else{
            JOptionPane.showMessageDialog(this,"Mantenimiento "+idemant+" Eliminado Satisfactoriamente");
            this.llenartblMantenimiento(false, "");
            this.btnEliminar.setEnabled(false);
        }
        limpiar();
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            this.llenartblMantenimiento(false, "");
        }else{
            this.llenartblMantenimiento(true, this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMantenimientoMouseClicked
        this.btnEliminar.setEnabled(true);
        int idx = this.tblMantenimiento.getSelectedRow();
        this.txtidMantenimiento.setText(this.dtmMant.getValueAt(idx, 0).toString());
        this.txtDescripcion.setText(this.dtmMant.getValueAt(idx, 1).toString());
        this.cmbTipMante.setSelectedItem(this.dtmMant.getValueAt(idx, 2).toString());
        this.cmbPrioridad.setSelectedItem(this.dtmMant.getValueAt(idx, 3).toString());
        this.txtPeriGarantia.setText(this.dtmMant.getValueAt(idx, 4).toString());
        if(this.dtmMant.getValueAt(idx, 5).toString().equals("1")){
            this.cmbEstado.setSelectedItem("Activo");
        }else{
            this.cmbEstado.setSelectedItem("No Activo");
        }
        this.btnGrabar.setText("Actualizar");
        
    }//GEN-LAST:event_tblMantenimientoMouseClicked
    private boolean valida(){
        boolean bool = false;
        String cad = "";
        String soloLetrasRegex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        
        if(this.txtDescripcion.getText().isEmpty()){
            cad += "Llenar Descripcion";
        }else if (!this.txtDescripcion.getText().matches(soloLetrasRegex)) {
            cad += "\n La Descripcion solo deben contener solo letras";
        }
        
        if(this.cmbPrioridad.getSelectedItem().equals("")){
            cad += "Selecciones una Prioridad";
        }
        
        if(this.cmbTipMante.getSelectedItem().equals("")){
            cad += "Selecciones un Tipo de Mantenimiento";
        }
        
        if(this.txtPeriGarantia.getText().isEmpty()){
            cad += "Llenar el Periodo de Garantia";
        }
        if(this.cmbEstado.getSelectedItem().equals("")){
            cad += "Selecciones el Estado";
        }
        
        if(cad.isEmpty()){
            bool = true;
        }else{
            System.out.println(cad);
        }
        return bool;
    }
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            Util u = new Util();
            Mantenimiento mant = new Mantenimiento();
            mant.setDescripcion(this.txtDescripcion.getText());
            mant.setTipoMant(this.cmbTipMante.getSelectedItem().toString());
            mant.setPrioridad(this.cmbPrioridad.getSelectedItem().toString());
            mant.setPeriodoGarantia(this.txtPeriGarantia.getText());
            if(this.cmbEstado.getSelectedItem().equals("Activo")){
                mant.setEstado(1);
            }else{
                mant.setEstado(0);
            }

            if(this.btnGrabar.getText().toString().equals("Grabar")){
                this.idMant = u.idNext("Mantenimiento", "idMantenimiento");
                mant.setIdMantenimiento(idMant);
                mandao.insertaMantenimiento(mant);
            }else{
                mant.setIdMantenimiento(Integer.parseInt(this.txtidMantenimiento.getText()));
                mandao.actualizaMantenimiento(mant);
            }
            JOptionPane.showMessageDialog(this,"Mantenimiento grabado");
            limpiar();
            this.llenartblMantenimiento(false, "");
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbPrioridad;
    private javax.swing.JComboBox<String> cmbTipMante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMantenimiento;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPeriGarantia;
    private javax.swing.JTextField txtidMantenimiento;
    // End of variables declaration//GEN-END:variables

}
