package UI.Self;

import BEAN.Repuesto;
import DAO.RepuestoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelRepuesto extends javax.swing.JDialog {
    RepuestoDAO repuestoDao;  
    DefaultTableModel dtm;  
    Repuesto repuesto;  
    public SelRepuesto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        repuestoDao = new RepuestoDAO();  
        repuesto = new Repuesto();  
        dtm = (DefaultTableModel) this.tblRepuesto.getModel();  
        this.llenaTblRepuestos(false, "");  
    }
        public void llenaTblRepuestos(boolean sw, String cad) {  
        Vector<Repuesto> listRepuestos = repuestoDao.listaRepuesto(sw, cad);  
        dtm.setRowCount(0);  
        for (int i = 0; i < listRepuestos.size(); i++) {  
            Vector vec = new Vector();  
            vec.addElement(listRepuestos.get(i).getIdRepuesto());  
            vec.addElement(listRepuestos.get(i).getNombre());  
            vec.addElement(listRepuestos.get(i).getTipRepuesto());  
            vec.addElement(listRepuestos.get(i).getMarca());
            vec.addElement(listRepuestos.get(i).getNumSerie());
            vec.addElement(listRepuestos.get(i).getStock());  
            vec.addElement(listRepuestos.get(i).getEstado());  
            dtm.addRow(vec);  
        }  
    }  
     public Repuesto devRepuesto() {  
        return repuesto;  
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRepuesto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Busqueda de repuesto");

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

        jLabel2.setText("Buscar");

        tblRepuesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID repuesto", "Nombre", "Tipo ", "Marca", "Serie", "Stock", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
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
        jScrollPane1.setViewportView(tblRepuesto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblRepuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRepuestoMouseClicked
        int idx;
        idx= this.tblRepuesto.getSelectedRow();
        repuesto.setIdRepuesto(Integer.parseInt(dtm.getValueAt(idx,0).toString()));
        repuesto.setNombre(dtm.getValueAt(idx, 1).toString());
        repuesto.setTipRepuesto(dtm.getValueAt(idx, 2).toString());
        repuesto.setMarca(dtm.getValueAt(idx, 3).toString());
        repuesto.setNumSerie(Integer.parseInt(dtm.getValueAt(idx, 4).toString()));
        repuesto.setStock(Integer.parseInt(dtm.getValueAt(idx, 5).toString()));
        repuesto.setEstado(Integer.parseInt(dtm.getValueAt(idx, 6).toString()));
        this.dispose();
    }//GEN-LAST:event_tblRepuestoMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        if(this.txtBuscar.getText().isEmpty()){
            this.llenaTblRepuestos(false, " ");
        }else{
            this.llenaTblRepuestos(true, this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRepuesto;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
