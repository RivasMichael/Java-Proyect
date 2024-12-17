
package UI.Mantenimiento;

import BEAN.Repuesto;
import DAO.RepuestoDAO;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmMantRepuesto extends javax.swing.JInternalFrame {
    RepuestoDAO repdao;
    DefaultTableModel dtmrep;
    int idRep;
    public FrmMantRepuesto() {
        initComponents();
        repdao = new RepuestoDAO();
        dtmrep = (DefaultTableModel)this.tblRepuesto.getModel();
        llenartblRepuesto(false,"");
        llenarcmbTRep();
        llenarbtnEstado();
        this.tblRepuesto.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.tblRepuesto.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    
    private void llenartblRepuesto(boolean bool, String cad){
        Vector<Repuesto> rep;
        rep = repdao.listaRepuesto(bool, cad);
        dtmrep.setRowCount(0);
        for(int i=0; i<rep.size();i++){
            Vector vec = new Vector();
            vec.addElement(rep.get(i).getIdRepuesto());
            vec.addElement(rep.get(i).getNombre());
            vec.addElement(rep.get(i).getTipRepuesto());
            vec.addElement(rep.get(i).getMarca());
            vec.addElement(rep.get(i).getNumSerie());
            vec.addElement(rep.get(i).getStock());
            vec.addElement(rep.get(i).getEstado());
            dtmrep.addRow(vec);
        }
    }
    private void llenarbtnEstado(){
        this.cmbEstado.addItem("");
        this.cmbEstado.addItem("Activo");
        this.cmbEstado.addItem("No Activo");
        
    }

    private void llenarcmbTRep(){
        this.cmbTipRep.addItem("");  
        this.cmbTipRep.addItem("Filtro");
        this.cmbTipRep.addItem("Frenos");
        this.cmbTipRep.addItem("Encendido");
        this.cmbTipRep.addItem("Eléctrico");
        this.cmbTipRep.addItem("Suspensión");
        this.cmbTipRep.addItem("Lubricante");
        this.cmbTipRep.addItem("Correa");
        this.cmbTipRep.addItem("Sistema de Enfriamiento");
        this.cmbTipRep.addItem("Sensor");
    }
    
    private boolean valida(){
        boolean sw = false;
        String cad = "";
        String soloLetrasRegex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        
        if(this.txtNombre.getText().isEmpty()){
            cad = "Debe registrar la descripción ";
        }else if (!this.txtNombre.getText().matches(soloLetrasRegex)) {
            cad += "\n La descripcion solo deben contener solo letras";
        }
        
        if(this.cmbTipRep.getSelectedItem().toString().isEmpty()){
            cad += "\nDebe seleccionar el tipo";
        }
        if(this.txtMarca.getText().isEmpty()){
            cad += "\nDebe registrar la marca";
        }
        
        if(this.txtNumSerie.getText().isEmpty()){
            cad += "\nDebe registrar el numero de serie";
        }
        if(this.txtStock.getText().isEmpty()){
            cad += "\nDebe registrar la cantidad en stock";
        }else if (!this.txtStock.getText().matches("\\d+")) {
            cad += "\n El stock debe contener solo números";
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        cmbTipRep = new javax.swing.JComboBox<>();
        txtNumSerie = new javax.swing.JTextField();
        txtIdRepuesto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtBuscarRep = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRepuesto = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnSalirRep = new javax.swing.JButton();
        cmbEstado = new javax.swing.JComboBox<>();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("MANTENIMIENTO DE REPUESTOS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Id Repuesto");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nombre Repuesto");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Tipo de repuesto");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Marca");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Numero de serie");

        txtIdRepuesto.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Estado");

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(null);

        jLabel10.setText("Buscar");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(30, 20, 38, 16);

        txtBuscarRep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarRepKeyReleased(evt);
            }
        });
        jPanel3.add(txtBuscarRep);
        txtBuscarRep.setBounds(100, 20, 560, 22);

        tblRepuesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Repuesto", "Nombre", "Tip. Repuesto", "Marca", "Num. Serie", "Stock", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRepuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRepuestoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRepuesto);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(30, 70, 630, 180);

        btnEliminar.setBackground(new java.awt.Color(255, 51, 0));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar);
        btnEliminar.setBounds(529, 260, 120, 31);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Stock");

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        btnSalirRep.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalirRep.setText("Salir");
        btnSalirRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirRepActionPerformed(evt);
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

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(102, 102, 102)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbEstado, 0, 183, Short.MAX_VALUE)
                                    .addComponent(txtStock)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumSerie)
                                    .addComponent(cmbTipRep, 0, 168, Short.MAX_VALUE)
                                    .addComponent(txtMarca)
                                    .addComponent(txtIdRepuesto)
                                    .addComponent(txtNombre)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(btnLimpiar)
                                .addGap(291, 291, 291)
                                .addComponent(btnSalirRep)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtIdRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbTipRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(btnSalirRep)
                            .addComponent(btnGrabar))))
                .addContainerGap(41, Short.MAX_VALUE))
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

    private void txtBuscarRepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarRepKeyReleased
        if(this.txtBuscarRep.getText().isEmpty()){
            this.llenartblRepuesto(false, "");
        }else{
            this.llenartblRepuesto(true, this.txtBuscarRep.getText());
        }
    }//GEN-LAST:event_txtBuscarRepKeyReleased

    private void tblRepuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRepuestoMouseClicked
        int idx = this.tblRepuesto.getSelectedRow();
        this.txtIdRepuesto.setText(this.dtmrep.getValueAt(idx, 0).toString());
        this.txtNombre.setText(this.dtmrep.getValueAt(idx, 1).toString());
        this.cmbTipRep.setSelectedItem(this.dtmrep.getValueAt(idx, 2).toString());
        this.txtMarca.setText(this.dtmrep.getValueAt(idx, 3).toString());
        this.txtNumSerie.setText(this.dtmrep.getValueAt(idx, 4).toString());
        this.txtStock.setText(this.dtmrep.getValueAt(idx, 5).toString());
        if(this.dtmrep.getValueAt(idx, 6).toString().equals("1"))
            this.cmbEstado.setSelectedItem("Activo");
        else{
            this.cmbEstado.setSelectedItem("Activo");
        }
        this.btnGrabar.setText("Actualizar");
        this.btnEliminar.setEnabled(true);
        
    }//GEN-LAST:event_tblRepuestoMouseClicked

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void btnSalirRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirRepActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirRepActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            Util u = new Util();
            Repuesto rep = new Repuesto();
            rep.setNombre(this.txtNombre.getText());
            rep.setTipRepuesto(this.cmbTipRep.getSelectedItem().toString());
            rep.setMarca(this.txtMarca.getText());
            rep.setNumSerie(Integer.parseInt(this.txtNumSerie.getText()));
            rep.setStock(Integer.parseInt(this.txtStock.getText()));
            if(this.cmbEstado.getSelectedItem().equals("Activo")){
                rep.setEstado(1);
            }else{
                rep.setEstado(0);
            }

            if(this.btnGrabar.getText().toString().equals("Grabar")){
                this.idRep = u.idNext("Repuesto", "idRepuesto");
                rep.setIdRepuesto(idRep);
                repdao.insertaRepuesto(rep);
            }else{
                rep.setIdRepuesto(Integer.parseInt(this.txtIdRepuesto.getText()));
                repdao.actualizaRepuesto(rep);
            }
            JOptionPane.showMessageDialog(this,"Repuesto grabado");
            limpiar();
            this.llenartblRepuesto(false, "");
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int ixd = this.tblRepuesto.getSelectedRow();
        System.out.println(this.dtmrep.getValueAt(ixd, 0).toString());
        int ideRep = Integer.parseInt(this.dtmrep.getValueAt(ixd, 0).toString());
        
        if(this.repdao.eliminarRepuesto(ideRep) == false){
            JOptionPane.showMessageDialog(this,"Existe Tablas dependientes");
        }else{
            JOptionPane.showMessageDialog(this,"Equipo"+ideRep+" Eliminado Satisfactoriamente");
            this.llenartblRepuesto(false, "");
            this.btnEliminar.setEnabled(false);
        }
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    
    private void limpiar(){
        this.txtIdRepuesto.setText("");
        this.txtNombre.setText("");
        this.cmbTipRep.setSelectedItem("");
        this.txtMarca.setText("");
        this.txtNumSerie.setText("");
        this.txtStock.setText("");
        this.cmbEstado.setSelectedItem("");
        this.btnGrabar.setText("Grabar");
        this.txtBuscarRep.setText("");
        this.btnEliminar.setEnabled(false);
        
    }
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalirRep;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbTipRep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRepuesto;
    private javax.swing.JTextField txtBuscarRep;
    private javax.swing.JTextField txtIdRepuesto;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumSerie;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
