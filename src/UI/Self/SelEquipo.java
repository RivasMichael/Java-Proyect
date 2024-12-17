
package UI.Self;

import BEAN.Equipo;
import DAO.EquipoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class SelEquipo extends javax.swing.JDialog {

    EquipoDAO equidao;
    DefaultTableModel dtmequi;
    Equipo equip;
    public SelEquipo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        equidao = new EquipoDAO();
        dtmequi = (DefaultTableModel)this.tblEquipo.getModel();
        llenartblEquipo(false,"");
        equip = new Equipo();
    }

    private void llenartblEquipo(boolean bool, String cad){
        Vector<Equipo> equi;
        equi = equidao.listaEquipos(bool, cad);
        dtmequi.setRowCount(0);
        for(int i=0; i<equi.size();i++){
            Vector vec = new Vector();
            vec.addElement(equi.get(i).getIdEquipo());
            vec.addElement(equi.get(i).getNumero_serie());
            vec.addElement(equi.get(i).getNombre());
            vec.addElement(equi.get(i).getMarca());
            vec.addElement(equi.get(i).getCategoria());
            vec.addElement(equi.get(i).getEstado());
            dtmequi.addRow(vec);
        }
    }
    public Equipo getEquipo(){
        return this.equip;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipo = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Busqueda Equipos");

        jPanel2.setLayout(null);

        tblEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Equipo", "Num.Serie", "Nombre", "Marca", "Categoria", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEquipoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEquipo);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 610, 200);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel2.add(txtBuscar);
        txtBuscar.setBounds(90, 20, 430, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Buscar:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 20, 69, 22);

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(540, 20, 75, 25);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquipoMouseClicked
        int idx = this.tblEquipo.getSelectedRow();
        this.equip.setIdEquipo(Integer.parseInt(this.dtmequi.getValueAt(idx, 0).toString()));
        this.equip.setNumero_serie(this.dtmequi.getValueAt(idx, 1).toString());
        this.equip.setNombre(this.dtmequi.getValueAt(idx, 2).toString());
        this.equip.setMarca(this.dtmequi.getValueAt(idx, 3).toString());
        this.equip.setCategoria(this.dtmequi.getValueAt(idx, 4).toString());
        this.equip.setEstado(Integer.parseInt(this.dtmequi.getValueAt(idx, 5).toString()));
        this.dispose();
        

    }//GEN-LAST:event_tblEquipoMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().toString().isEmpty()){
            this.llenartblEquipo(false, "");
        }else{
            this.llenartblEquipo(true, this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.txtBuscar.setText("");
       this.llenartblEquipo(false, "");
    }//GEN-LAST:event_jButton1ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEquipo;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
