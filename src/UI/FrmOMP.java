
package UI;

import BEAN.Actividad;
import BEAN.CabOrden;
import BEAN.Cab_Registro_Cruzado;
import BEAN.Cliente;
import BEAN.DetRepuesto;
import BEAN.Det_Empleado;
import BEAN.Det_Empleado_Cruzada;
import BEAN.Det_Equipo;
import BEAN.Det_Equipo_Cruzada;
import BEAN.Det_Repuesto_Cruzada;
import BEAN.Empleado;
import BEAN.Equipo;
import BEAN.Mantenimiento;
import BEAN.Repuesto;
import BEAN.Vehiculo;
import DAO.CabOrdenDAO;
import DAO.ClienteDAO;
import DAO.DetRepuestoDAO;
import DAO.EmpleadoDAO;
import DAO.MantenimientoDAO;
import DAO.UsuarioDAO;
import DAO.VehiculoDAO;
import DAO.det_EmpleadoDAO;
import DAO.det_EquipoDAO;
import UI.Self.SelActividad;
import UI.Self.SelCliente;
import UI.Self.SelEmpleado;
import UI.Self.SelEquipo;
import UI.Self.SelMantenimiento;
import UI.Self.SelRepuesto;
import UI.Self.SelVehiculo;
import UTIL.Util;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmOMP extends javax.swing.JInternalFrame {
    DefaultTableModel dtmdetEmp;
    DefaultTableModel dtm1;
    DefaultTableModel dtmEquipo;
    DefaultTableModel dtmClie;
    DefaultTableModel dtmCRclie;
    ClienteDAO clieDao;
    CabOrdenDAO cabOrdDao;
    MantenimientoDAO mandao;
    VehiculoDAO vehidao;
    det_EmpleadoDAO detemple;
    DetRepuestoDAO detrepdao;
    det_EquipoDAO detequidao;
    private int Usuarioregistro;
    int idDetEquipo ;
    int idDetEmp;
    int idOrdenActu;
    int tamañoDet = 0;
    int tamañoEquipo = 0;
    int tamañoresp = 0;

    public FrmOMP(int Usuarioregistro) {
        this.Usuarioregistro = Usuarioregistro;
        initComponents();
        dtmdetEmp = (DefaultTableModel)this.tblDetEmpleado.getModel();
        llenaCmbUnidadMedida();
        dtm1=(DefaultTableModel)this.tblRepuesto.getModel();
        dtmEquipo=(DefaultTableModel)this.tblDetEquipo.getModel();
        dtmClie=(DefaultTableModel)this.tblClientesConOrden.getModel();
        dtmCRclie=(DefaultTableModel)this.tblCompraClie.getModel();
        clieDao = new ClienteDAO();
        cabOrdDao = new CabOrdenDAO();
        mandao = new MantenimientoDAO();
        vehidao = new VehiculoDAO();
        detemple = new det_EmpleadoDAO();
        detrepdao = new DetRepuestoDAO();
        detequidao = new det_EquipoDAO();
        llenaTblCliente(false," ", false);
        llenaTblRegistroCliente(false, "" );
    }
    

 
    private void limpiaRepuesto(){
        this.txtRIdRepuesto.setText("");
        this.txtRNombre.setText("");
        this.txtRTipo.setText("");
        this.cmbRMedida.setSelectedItem("");
        this.txtRCantidad.setText("");
        
    }
    private void llenaCmbUnidadMedida(){
        this.cmbRMedida.addItem("");
        this.cmbRMedida.addItem("Litros");
        this.cmbRMedida.addItem("Unidad");
        
    }
 
    private void llenaTblCliente(boolean sw, String CadBuscar, boolean sw2){
        Vector<Cliente> listClie= clieDao.listaClientes(sw, CadBuscar,sw2 );

        dtmClie.setRowCount(0);
        for (int i=0; i<listClie.size();i++){
            Vector vect=new Vector();
            vect.addElement(listClie.get(i).getIdCliente());
            vect.addElement(listClie.get(i).getApellidos());
            vect.addElement(listClie.get(i).getNombres());
            vect.addElement(listClie.get(i).getTelefono());
            vect.addElement(listClie.get(i).getDireccion());
            vect.addElement(listClie.get(i).getCorreo());
            vect.addElement(listClie.get(i).getEstado());
            dtmClie.addRow(vect);

        }
    }
    private void llenaTblRegistroCliente(boolean sw, String idCliente ){
        Vector<Cab_Registro_Cruzado> listClie=cabOrdDao.ListaCruzadaItem(sw, idCliente);
        dtmCRclie.setRowCount(0);
        for (int i=0;i<listClie.size();i++){
            Vector vec=new Vector();
            vec.addElement(listClie.get(i).getIdOrden());
            vec.addElement(listClie.get(i).getIdCliente());
            vec.addElement(listClie.get(i).getFechProg());
            vec.addElement(listClie.get(i).getIdVehiculo());
            vec.addElement(listClie.get(i).getPlaca());
            vec.addElement(listClie.get(i).getIdMantenimiento());
            vec.addElement(listClie.get(i).getDescripcion());
            dtmCRclie.addRow(vec);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarCle = new javax.swing.JTextField();
        btnLimpiarOrde = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientesConOrden = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCompraClie = new javax.swing.JTable();
        panelCliente = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtFechaPro = new com.toedter.calendar.JDateChooser();
        jPanel14 = new javax.swing.JPanel();
        txtobs = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDescriMant = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdMante = new javax.swing.JTextField();
        txtPrioriMant = new javax.swing.JTextField();
        btnBuscarMant = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPeriGaraMante = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTipMant = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txtNombreClie = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtCorreoClie = new javax.swing.JTextField();
        BtnBuscarClie = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        txtApellidoClie = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtTelefonoClie = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        txtMarcaVehicu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdVehiculo = new javax.swing.JTextField();
        txtPlacaVehi = new javax.swing.JTextField();
        btnBuscarVehi = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnatras2 = new javax.swing.JButton();
        PanelDetalles = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        txtIDActividad = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtIDEmpleado = new javax.swing.JTextField();
        btnBuscarEmpleado = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtDescripcionActividad = new javax.swing.JTextField();
        txtHorasEmpleado = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        btnBuscarActividad = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetEmpleado = new javax.swing.JTable();
        BtnAgregarEmpleado = new javax.swing.JButton();
        btnEliminaDeple = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        txtNombreEmpl = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jPanel43 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        txtIdActividadEquip = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtIdEquipo = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtCategoriaEquipo = new javax.swing.JTextField();
        btnBuscarEquip = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        txtApellidosEquipo = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtDesEquipActvi = new javax.swing.JTextField();
        txtHorasEqui = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDetEquipo = new javax.swing.JTable();
        btnAgregar1 = new javax.swing.JButton();
        btnEliminarEquipo = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        txtIdEmpleadoEquip = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtNombreEquipo = new javax.swing.JTextField();
        txtfechaEqui = new javax.swing.JTextField();
        nextpag3 = new javax.swing.JButton();
        btnAtras2 = new javax.swing.JButton();
        pagrep = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jButton30 = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txtRIdRepuesto = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtRTipo = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        txtRCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        cmbRMedida = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        txtRNombre = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblRepuesto = new javax.swing.JTable();
        btnBuscarRepuesto = new javax.swing.JButton();
        btnQuitarRepuesto = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 700));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 102, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("REGISTRO DE ORDENES DE MANTENIMIENTO PREVENTIVO");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 10, 620, 40);

        Panel.setToolTipText("");
        Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 255, 204));
        jPanel4.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel2.setText("Buscar");

        txtBuscarCle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCleKeyReleased(evt);
            }
        });

        btnLimpiarOrde.setText("Limpiar");
        btnLimpiarOrde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarOrdeActionPerformed(evt);
            }
        });

        tblClientesConOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Cliente", "Apellido", "Nombre", "Telefono", "Dirrección", "C  Electronico", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientesConOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesConOrdenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientesConOrden);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarCle, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarOrde))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarOrde)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel6);
        jPanel6.setBounds(53, 35, 623, 220);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tblCompraClie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Orden", "Id Cliente", "Fecha Programación", "Id Vehiculo", "Placa", "Id Mantenimiento", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCompraClie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCompraClieMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCompraClie);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel7);
        jPanel7.setBounds(10, 270, 710, 260);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        Panel.addTab("Ordenenes Cliente", jPanel2);

        jPanel5.setBackground(new java.awt.Color(153, 255, 204));
        jPanel5.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Fecha de Programacion");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFechaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel8);
        jPanel8.setBounds(340, 20, 370, 50);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        txtobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtobsActionPerformed(evt);
            }
        });

        jLabel14.setText("Observaciones");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtobs, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtobs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel14);
        jPanel14.setBounds(20, 440, 690, 50);

        jButton2.setText("NEXT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(630, 540, 63, 25);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Mantenimiento"));
        jPanel9.setLayout(null);

        jLabel3.setText("Prioridad");
        jPanel9.add(jLabel3);
        jLabel3.setBounds(290, 70, 70, 16);

        txtDescriMant.setEnabled(false);
        txtDescriMant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriMantActionPerformed(evt);
            }
        });
        jPanel9.add(txtDescriMant);
        txtDescriMant.setBounds(280, 30, 220, 22);

        jLabel6.setText("Descripcion");
        jPanel9.add(jLabel6);
        jLabel6.setBounds(200, 30, 70, 16);

        jLabel5.setText("Periodo de Garantia");
        jPanel9.add(jLabel5);
        jLabel5.setBounds(10, 110, 140, 16);

        txtIdMante.setEnabled(false);
        jPanel9.add(txtIdMante);
        txtIdMante.setBounds(120, 30, 70, 22);

        txtPrioriMant.setEnabled(false);
        jPanel9.add(txtPrioriMant);
        txtPrioriMant.setBounds(350, 70, 150, 22);

        btnBuscarMant.setText("Buscar Mantenimiento");
        btnBuscarMant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMantActionPerformed(evt);
            }
        });
        jPanel9.add(btnBuscarMant);
        btnBuscarMant.setBounds(520, 30, 160, 25);

        jLabel7.setText("ID Mantenimiento");
        jPanel9.add(jLabel7);
        jLabel7.setBounds(10, 30, 110, 16);

        txtPeriGaraMante.setEnabled(false);
        jPanel9.add(txtPeriGaraMante);
        txtPeriGaraMante.setBounds(140, 110, 210, 22);

        jLabel11.setText("TipMantenimiento");
        jPanel9.add(jLabel11);
        jLabel11.setBounds(10, 70, 110, 16);

        txtTipMant.setEnabled(false);
        jPanel9.add(txtTipMant);
        txtTipMant.setBounds(120, 70, 160, 22);

        jPanel5.add(jPanel9);
        jPanel9.setBounds(20, 80, 690, 150);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jPanel34.setLayout(null);

        jLabel36.setText("Nombres");
        jPanel34.add(jLabel36);
        jLabel36.setBounds(330, 30, 70, 16);

        txtNombreClie.setEnabled(false);
        txtNombreClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClieActionPerformed(evt);
            }
        });
        jPanel34.add(txtNombreClie);
        txtNombreClie.setBounds(400, 30, 120, 22);

        jLabel37.setText("Apellidos");
        jPanel34.add(jLabel37);
        jLabel37.setBounds(150, 30, 70, 16);

        jLabel38.setText("Correo");
        jPanel34.add(jLabel38);
        jLabel38.setBounds(230, 70, 70, 16);

        txtIdCliente.setEnabled(false);
        jPanel34.add(txtIdCliente);
        txtIdCliente.setBounds(80, 30, 50, 22);

        txtCorreoClie.setEnabled(false);
        jPanel34.add(txtCorreoClie);
        txtCorreoClie.setBounds(290, 70, 190, 22);

        BtnBuscarClie.setText("Buscar Cliente");
        BtnBuscarClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarClieActionPerformed(evt);
            }
        });
        jPanel34.add(BtnBuscarClie);
        BtnBuscarClie.setBounds(530, 30, 130, 25);

        jLabel39.setText("ID Cliente");
        jPanel34.add(jLabel39);
        jLabel39.setBounds(10, 30, 70, 16);

        txtApellidoClie.setEnabled(false);
        txtApellidoClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoClieActionPerformed(evt);
            }
        });
        jPanel34.add(txtApellidoClie);
        txtApellidoClie.setBounds(220, 30, 100, 22);

        jLabel40.setText("Telefono");
        jPanel34.add(jLabel40);
        jLabel40.setBounds(10, 70, 70, 16);

        txtTelefonoClie.setEnabled(false);
        jPanel34.add(txtTelefonoClie);
        txtTelefonoClie.setBounds(80, 70, 120, 22);

        jPanel5.add(jPanel34);
        jPanel34.setBounds(20, 240, 690, 110);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehiculo"));
        jPanel10.setLayout(null);

        jPanel11.setLayout(null);
        jPanel10.add(jPanel11);
        jPanel11.setBounds(20, 200, 690, 160);

        jPanel12.setLayout(null);

        jPanel13.setLayout(null);
        jPanel12.add(jPanel13);
        jPanel13.setBounds(20, 200, 690, 160);

        jPanel10.add(jPanel12);
        jPanel12.setBounds(20, 200, 690, 160);

        txtMarcaVehicu.setEnabled(false);
        jPanel10.add(txtMarcaVehicu);
        txtMarcaVehicu.setBounds(380, 20, 100, 22);

        jLabel8.setText("Placa");
        jPanel10.add(jLabel8);
        jLabel8.setBounds(160, 20, 70, 16);

        jLabel9.setText("Marca");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(320, 20, 70, 16);

        txtIdVehiculo.setEnabled(false);
        jPanel10.add(txtIdVehiculo);
        txtIdVehiculo.setBounds(90, 20, 50, 22);

        txtPlacaVehi.setEnabled(false);
        jPanel10.add(txtPlacaVehi);
        txtPlacaVehi.setBounds(200, 20, 100, 22);

        btnBuscarVehi.setText("Buscar Vehiculo");
        btnBuscarVehi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVehiActionPerformed(evt);
            }
        });
        jPanel10.add(btnBuscarVehi);
        btnBuscarVehi.setBounds(540, 20, 130, 25);

        jLabel12.setText("ID Vehiculo");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(10, 20, 70, 16);

        jPanel5.add(jPanel10);
        jPanel10.setBounds(20, 360, 690, 70);

        btnatras2.setText("Atras");
        btnatras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatras2ActionPerformed(evt);
            }
        });
        jPanel5.add(btnatras2);
        btnatras2.setBounds(40, 540, 79, 25);

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        Panel.addTab("Datos Cab", panelCliente);

        jPanel33.setBackground(new java.awt.Color(153, 255, 204));
        jPanel33.setLayout(null);

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Empleados"));

        jLabel49.setText("ID Empleado");

        txtIDActividad.setEnabled(false);
        txtIDActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActividadActionPerformed(evt);
            }
        });

        jLabel50.setText("Apellidos");

        txtIDEmpleado.setEnabled(false);
        txtIDEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDEmpleadoActionPerformed(evt);
            }
        });

        btnBuscarEmpleado.setText("Buscar Empleado");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

        jLabel52.setText("ID Actividad");

        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        jLabel53.setText("Descripcion");

        txtDescripcionActividad.setEnabled(false);
        txtDescripcionActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActividadActionPerformed(evt);
            }
        });

        txtHorasEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasEmpleadoActionPerformed(evt);
            }
        });

        jLabel54.setText("Fecha");

        jLabel55.setText("N: Horas");

        btnBuscarActividad.setText("Buscar Actividad");
        btnBuscarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActividadActionPerformed(evt);
            }
        });

        jPanel3.setLayout(null);

        tblDetEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDEmpleado", "Apellidos", "Nombres", "IDActividad", "Descripcion", "Fecha", "Num:Horas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDetEmpleado);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(0, 0, 670, 80);

        BtnAgregarEmpleado.setText("Agregar");
        BtnAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarEmpleadoActionPerformed(evt);
            }
        });

        btnEliminaDeple.setText("Quitar Empleados");
        btnEliminaDeple.setEnabled(false);
        btnEliminaDeple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaDepleActionPerformed(evt);
            }
        });

        jLabel63.setText("Nombres");

        txtNombreEmpl.setEnabled(false);
        txtNombreEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEmplActionPerformed(evt);
            }
        });

        txtFecha.setMaxSelectableDate(new java.util.Date(253370786496000L));
        txtFecha.setMinSelectableDate(new java.util.Date(-62135747904000L));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminaDeple, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel42Layout.createSequentialGroup()
                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel42Layout.createSequentialGroup()
                                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIDActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel42Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHorasEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47))
                                    .addGroup(jPanel42Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescripcionActividad)
                                        .addGap(31, 31, 31)))
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnBuscarActividad)
                                    .addComponent(BtnAgregarEmpleado))
                                .addGap(5, 5, 5))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(txtIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmpleado)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(txtNombreEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtIDActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(txtDescripcionActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarActividad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel54)
                        .addComponent(jLabel55)
                        .addComponent(txtHorasEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnAgregarEmpleado))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminaDeple)
                .addGap(11, 11, 11))
        );

        jPanel33.add(jPanel42);
        jPanel42.setBounds(20, 10, 690, 260);

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Equipo"));

        jLabel56.setText("ID Equipo");

        txtIdActividadEquip.setEnabled(false);
        txtIdActividadEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActividadEquipActionPerformed(evt);
            }
        });

        jLabel57.setText("Nombre");

        txtIdEquipo.setEnabled(false);
        txtIdEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEquipoActionPerformed(evt);
            }
        });

        jLabel58.setText("Categoria");

        txtCategoriaEquipo.setEnabled(false);
        txtCategoriaEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaEquipoActionPerformed(evt);
            }
        });

        btnBuscarEquip.setText("Buscar Equipo");
        btnBuscarEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEquipActionPerformed(evt);
            }
        });

        jLabel59.setText("ID Actividad");

        txtApellidosEquipo.setEnabled(false);
        txtApellidosEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosEquipoActionPerformed(evt);
            }
        });

        jLabel60.setText("Descripcion");

        txtDesEquipActvi.setEnabled(false);
        txtDesEquipActvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesEquipActviActionPerformed(evt);
            }
        });

        txtHorasEqui.setEnabled(false);
        txtHorasEqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasEquiActionPerformed(evt);
            }
        });

        jLabel61.setText("Fecha");

        jLabel62.setText("N: Horas");

        jPanel15.setLayout(null);

        tblDetEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Empleado", "ID Equipo", "Nombre", "Categoria", "Id Actividad", "Desc Activ", "fecha", "N:Horas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetEquipoMouseClicked(evt);
            }
        });
        tblDetEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDetEquipoKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(tblDetEquipo);

        jPanel15.add(jScrollPane7);
        jScrollPane7.setBounds(0, 0, 670, 90);

        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        btnEliminarEquipo.setText("Quitar Equipo");
        btnEliminarEquipo.setEnabled(false);
        btnEliminarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEquipoActionPerformed(evt);
            }
        });

        jLabel64.setText("ID Empleado");

        txtIdEmpleadoEquip.setEnabled(false);
        txtIdEmpleadoEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEmpleadoEquipActionPerformed(evt);
            }
        });

        jLabel51.setText("Apellidos");

        txtNombreEquipo.setEnabled(false);
        txtNombreEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEquipoActionPerformed(evt);
            }
        });

        txtfechaEqui.setEnabled(false);
        txtfechaEqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaEquiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel43Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addComponent(txtIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addComponent(txtCategoriaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdEmpleadoEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidosEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdActividadEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDesEquipActvi, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addComponent(txtfechaEqui, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(txtHorasEqui, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87)
                                        .addComponent(btnAgregar1)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(24, 24, 24))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57)
                    .addComponent(txtIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEquip)
                    .addComponent(txtNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCategoriaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel64))
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel51)
                        .addComponent(txtIdEmpleadoEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidosEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(txtDesEquipActvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdActividadEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(txtfechaEqui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(txtHorasEqui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar1))
                .addGap(19, 19, 19)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarEquipo)
                .addGap(26, 26, 26))
        );

        jPanel33.add(jPanel43);
        jPanel43.setBounds(20, 280, 690, 310);

        nextpag3.setText("NEXT");
        nextpag3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextpag3ActionPerformed(evt);
            }
        });
        jPanel33.add(nextpag3);
        nextpag3.setBounds(630, 590, 63, 25);

        btnAtras2.setText("Atras");
        btnAtras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras2ActionPerformed(evt);
            }
        });
        jPanel33.add(btnAtras2);
        btnAtras2.setBounds(30, 590, 79, 25);

        javax.swing.GroupLayout PanelDetallesLayout = new javax.swing.GroupLayout(PanelDetalles);
        PanelDetalles.setLayout(PanelDetallesLayout);
        PanelDetallesLayout.setHorizontalGroup(
            PanelDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelDetallesLayout.setVerticalGroup(
            PanelDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        Panel.addTab("Det Emplear", PanelDetalles);

        jPanel35.setBackground(new java.awt.Color(153, 255, 204));
        jPanel35.setLayout(null);

        jButton30.setText("Salir");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel35.add(jButton30);
        jButton30.setBounds(540, 230, 87, 25);

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        jPanel35.add(btnGrabar);
        btnGrabar.setBounds(80, 230, 110, 25);

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Repuestos"));
        jPanel41.setLayout(null);

        jLabel47.setText("TipRepuesto");
        jPanel41.add(jLabel47);
        jLabel47.setBounds(310, 20, 90, 16);

        txtRIdRepuesto.setEnabled(false);
        txtRIdRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRIdRepuestoActionPerformed(evt);
            }
        });
        jPanel41.add(txtRIdRepuesto);
        txtRIdRepuesto.setBounds(90, 20, 50, 22);

        jLabel48.setText("Cantidad");
        jPanel41.add(jLabel48);
        jLabel48.setBounds(280, 50, 130, 16);

        txtRTipo.setEnabled(false);
        txtRTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRTipoActionPerformed(evt);
            }
        });
        jPanel41.add(txtRTipo);
        txtRTipo.setBounds(400, 20, 100, 22);

        jLabel70.setText("Nombre");
        jPanel41.add(jLabel70);
        jLabel70.setBounds(150, 20, 70, 16);
        jPanel41.add(txtRCantidad);
        txtRCantidad.setBounds(350, 50, 100, 22);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel41.add(btnAgregar);
        btnAgregar.setBounds(550, 50, 130, 25);

        jLabel71.setText("ID Repuesto");
        jPanel41.add(jLabel71);
        jLabel71.setBounds(10, 20, 70, 16);

        cmbRMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRMedidaActionPerformed(evt);
            }
        });
        jPanel41.add(cmbRMedida);
        cmbRMedida.setBounds(130, 50, 130, 22);

        jLabel72.setText("Unidad de Medida");
        jPanel41.add(jLabel72);
        jLabel72.setBounds(10, 50, 130, 16);

        txtRNombre.setEnabled(false);
        jPanel41.add(txtRNombre);
        txtRNombre.setBounds(200, 20, 100, 22);

        tblRepuesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Repuesto", "Nombre", "Tipo", "U.Medida", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblRepuesto);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        jPanel41.add(jPanel45);
        jPanel45.setBounds(10, 80, 670, 90);

        btnBuscarRepuesto.setText("Buscar Repuesto");
        btnBuscarRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRepuestoActionPerformed(evt);
            }
        });
        jPanel41.add(btnBuscarRepuesto);
        btnBuscarRepuesto.setBounds(530, 20, 130, 25);

        btnQuitarRepuesto.setText("Quitar Repuesto");
        btnQuitarRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarRepuestoActionPerformed(evt);
            }
        });
        jPanel41.add(btnQuitarRepuesto);
        btnQuitarRepuesto.setBounds(540, 170, 140, 25);

        jPanel35.add(jPanel41);
        jPanel41.setBounds(20, 10, 690, 200);

        javax.swing.GroupLayout pagrepLayout = new javax.swing.GroupLayout(pagrep);
        pagrep.setLayout(pagrepLayout);
        pagrepLayout.setHorizontalGroup(
            pagrepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pagrepLayout.setVerticalGroup(
            pagrepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        Panel.addTab("Repuestos", pagrep);

        jPanel1.add(Panel);
        Panel.setBounds(10, 60, 740, 650);
        Panel.getAccessibleContext().setAccessibleName("Ordenes Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseClicked

    }//GEN-LAST:event_PanelMouseClicked

    private void btnQuitarRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarRepuestoActionPerformed
        int selectedRow = tblRepuesto.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un repuesto a quitar.");
        }
        else{
            DefaultTableModel mode1= (DefaultTableModel) tblRepuesto.getModel();
            mode1.removeRow(selectedRow);
        }
    }//GEN-LAST:event_btnQuitarRepuestoActionPerformed

    private void btnBuscarRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRepuestoActionPerformed
        Repuesto rep= new Repuesto();
        SelRepuesto dialog = new SelRepuesto(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        rep= dialog.devRepuesto();
        this.txtRIdRepuesto.setText(String.valueOf(rep.getIdRepuesto()));
        this.txtRNombre.setText(rep.getNombre());
        this.txtRTipo.setText(rep.getTipRepuesto());
    }//GEN-LAST:event_btnBuscarRepuestoActionPerformed

    private void cmbRMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRMedidaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(validaRepuesto()==true){
            Vector vec= new Vector();
            vec.addElement(this.txtRIdRepuesto.getText());
            vec.addElement(this.txtRNombre.getText());
            vec.addElement(this.txtRTipo.getText());
            vec.addElement(this.cmbRMedida.getSelectedItem().toString());
            vec.addElement(this.txtRCantidad.getText());
            dtm1.addRow(vec);
            limpiaRepuesto();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtRTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRTipoActionPerformed

    private void txtRIdRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRIdRepuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRIdRepuestoActionPerformed
    
    
    
    private void LimpiaCabezera(){
        this.txtFechaPro.setDate(null);   
        
        this.txtIdMante.setText("");
        this.txtDescriMant.setText("");
        this.txtTipMant.setText("");
        this.txtPrioriMant.setText("");
        this.txtPeriGaraMante.setText("");

        this.txtIdCliente.setText("");
        this.txtApellidoClie.setText("");
        this.txtNombreClie.setText("");
        this.txtTelefonoClie.setText("");
        this.txtCorreoClie.setText("");

        this.txtIdVehiculo.setText("");
        this.txtPlacaVehi.setText("");
        this.txtMarcaVehicu.setText("");
        
        this.txtobs.setText("");
        
        this.dtm1.setRowCount(0);
        this.dtmEquipo.setRowCount(0);
        this.dtmdetEmp.setRowCount(0);
    }
    
    private boolean validaGneral(){
        boolean bool = false;
        String cad = "";
        
        Date fecha = this.txtFechaPro.getDate();
        if (fecha == null) {
            cad += "\nDebe seleccionar una fecha de programacion";
        } else {
            Date fechaHoy = new Date();
            if (fecha.before(fechaHoy)) {
                cad += "\nDebe seleccionar una fecha de hoy o posterior";
            }
        }
        
        if(this.txtIdMante.getText().isEmpty()){
            cad += "\nDebe seleccionar un tipo de Mantenimiento";
        }
        
        if(this.txtIdCliente.getText().isEmpty()){
            cad += "\nDebe seleccionar un Cliente";
        }
        
        if(this.txtIdVehiculo.getText().isEmpty()){
            cad += "\nDebe seleccionar un Vehiculo";
        }
        
        if(this.txtobs.getText().isEmpty()){
            cad += "\nDebe Agregar alguna Observacion";
        }
        
        if(this.dtm1.getRowCount() == 0){
            cad += "\nDebe Agregar por lo menos un Repuesto";
        }
        
        if(this.dtmEquipo.getRowCount() == 0){
            cad += "\nDebe Agregar por lo menos un Equipo";
        }
        
        if(this.dtmdetEmp.getRowCount() == 0){
            cad += "\nDebe Agregar por lo menos un Empleado";
        }
        
        if(cad.isEmpty()){
            bool = true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return bool;
    }
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        if(validaGneral()==true){
            Util u  = new Util();
            int idx = u.idNext("CabOrden", "idOrden");
            System.out.println(idx);
            
            //Llenar CabOrden
            CabOrdenDAO cabdao = new CabOrdenDAO();
            CabOrden cab  = new CabOrden();

            
            cab.setIdMantenimiento(Integer.parseInt(this.txtIdMante.getText()));
            cab.setIdCliente(Integer.parseInt(this.txtIdCliente.getText()));
            cab.setIdvehiculo(Integer.parseInt(this.txtIdVehiculo.getText()));
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaString = sdf.format(this.txtFechaPro.getDate());
            cab.setFechProg(fechaString);
            
            cab.setFech_reg(LocalDateTime.now());
            
            cab.setIdUsuarioReg(this.Usuarioregistro);
            cab.setObs(this.txtobs.getText());
            cab.setEstado(1);
            
            
            if(this.btnGrabar.getText().equals("Grabar")){
                cab.setIdOrden(idx);
                cabdao.procesaItem(cab, "insert");
                
            }else{
                cab.setIdOrden(this.idOrdenActu);
                cab.setFech_mod(LocalDateTime.now());
                cab.setIdUsuarioMod(Usuarioregistro);
                cabdao.procesaItem(cab, "update");
            }
            
            

            //Llenar DET Empleado
            det_EmpleadoDAO detemp = new det_EmpleadoDAO();
            for(int i=0; i<this.dtmdetEmp.getRowCount();i++){
                Det_Empleado detempl = new Det_Empleado();
                
                detempl.setIdEmpleado(Integer.parseInt(dtmdetEmp.getValueAt(i, 0).toString()));
                detempl.setIdActividad(Integer.parseInt(dtmdetEmp.getValueAt(i, 3).toString()));
                detempl.setFecha(dtmdetEmp.getValueAt(i, 5).toString());
                detempl.setNumHoras(Integer.parseInt(dtmdetEmp.getValueAt(i, 6).toString()));
                    if(this.btnGrabar.getText().equals("Grabar")){
                        detempl.setIdOrden(idx);
                        detemp.procesaItem(detempl, "insert");
                    }else{
                        detempl.setIdOrden(this.idOrdenActu);
                        if(i<this.tamañoDet){
                            detemp.procesaItem(detempl, "update");
                        }else{
                            detemp.procesaItem(detempl, "insert");
                        }
                    }
            }

            //llenar Det Equipo
            if(this.dtmEquipo.getRowCount() > 0){
                det_EquipoDAO dete = new det_EquipoDAO();
                for(int i=0; i<this.dtmEquipo.getRowCount();i++){
                    Det_Equipo detequi = new Det_Equipo();

                    detequi.setIdEmpleado(Integer.parseInt(dtmEquipo.getValueAt(i, 0).toString()));
                    detequi.setIdEquipo(Integer.parseInt(dtmEquipo.getValueAt(i, 1).toString()));
                    detequi.setIdActividad(Integer.parseInt(dtmEquipo.getValueAt(i, 4).toString()));
                    detequi.setFecha(dtmEquipo.getValueAt(i, 6).toString());
                    detequi.setNumHoras(Integer.parseInt(dtmEquipo.getValueAt(i, 7).toString()));
                        if(this.btnGrabar.getText().equals("Grabar")){
                            detequi.setIdOrden(idx);
                            dete.procesaItem(detequi, "insert");
                        }else{
                            detequi.setIdOrden(this.idOrdenActu);

                            if(i<this.tamañoEquipo){
                                dete.procesaItem(detequi, "update");
                            }else{
                                dete.procesaItem(detequi, "insert");
                            }
                        }
                }
            }

            //Llenar DET Repuesto

            DetRepuestoDAO detrepda = new DetRepuestoDAO();
            for(int i=0; i<this.dtm1.getRowCount();i++){
                DetRepuesto detrep = new DetRepuesto();
                
                detrep.setIdRepuesto(Integer.parseInt(dtm1.getValueAt(i, 0).toString()));
                detrep.setUnidadMedida(dtm1.getValueAt(i, 3).toString());
                detrep.setCantidad(Integer.parseInt(dtm1.getValueAt(i, 4).toString()));
                    if(this.btnGrabar.getText().equals("Grabar")){
                        detrep.setIdOrden(idx);
                        detrepda.procesaItem(detrep, "insert");
                    }else{
                        detrep.setIdOrden(this.idOrdenActu);
                        if(i<this.tamañoresp){
                            detrepda.procesaItem(detrep, "update");
                        }else{
                            detrepda.procesaItem(detrep, "insert");
                        }
                    }
            }
            LimpiaCabezera();
            llenaTblRegistroCliente(false, "" );
            llenaTblCliente(false," ", false);
            this.Panel.setSelectedIndex(0);
            
            
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnAtras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras2ActionPerformed
        this.Panel.setSelectedIndex(1);
    }//GEN-LAST:event_btnAtras2ActionPerformed
    private boolean validapanel2(){
        String cad = "";
        boolean bool = false;
        if(this.dtmdetEmp.getRowCount()<=0){
            cad +="Debes seleccionar por lo menos un empleado";
        }
        if(cad.isEmpty()){
            bool = true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return bool;
    }
    private void nextpag3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextpag3ActionPerformed
        if(validapanel2()==true){
            this.Panel.setSelectedIndex(3);
        }
        
    }//GEN-LAST:event_nextpag3ActionPerformed

    private void txtfechaEquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaEquiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaEquiActionPerformed

    private void txtNombreEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEquipoActionPerformed

    private void txtIdEmpleadoEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpleadoEquipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmpleadoEquipActionPerformed

    private void btnEliminarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEquipoActionPerformed

        this.dtmEquipo.removeRow(this.idDetEquipo );
    }//GEN-LAST:event_btnEliminarEquipoActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        if(validaEquipo()== true){
            Vector vec = new Vector();
            vec.addElement(this.txtIdEmpleadoEquip.getText());
            vec.addElement(this.txtIdEquipo.getText());
            vec.addElement(this.txtNombreEquipo.getText());
            vec.addElement(this.txtCategoriaEquipo.getText());
            vec.addElement(this.txtIdActividadEquip.getText());
            vec.addElement(this.txtDesEquipActvi.getText());
            vec.addElement(this.txtfechaEqui.getText());
            vec.addElement(this.txtHorasEqui.getText());
            this.dtmEquipo.addRow(vec);
            limpiarEquipo();
        }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void tblDetEquipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDetEquipoKeyReleased

    }//GEN-LAST:event_tblDetEquipoKeyReleased

    private void tblDetEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetEquipoMouseClicked
        this.idDetEquipo = this.tblDetEquipo.getSelectedRow();

        this.btnEliminarEquipo.setEnabled(true);
    }//GEN-LAST:event_tblDetEquipoMouseClicked

    private void txtHorasEquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasEquiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasEquiActionPerformed

    private void txtDesEquipActviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesEquipActviActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesEquipActviActionPerformed

    private void txtApellidosEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosEquipoActionPerformed

    private void btnBuscarEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEquipActionPerformed
        Equipo equip= new Equipo();
        SelEquipo dialog = new SelEquipo(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        equip= dialog.getEquipo();
        this.txtIdEquipo.setText(String.valueOf(equip.getIdEquipo()));
        this.txtNombreEquipo.setText(equip.getNombre());
        this.txtCategoriaEquipo.setText(equip.getCategoria());
    }//GEN-LAST:event_btnBuscarEquipActionPerformed

    private void txtCategoriaEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaEquipoActionPerformed

    private void txtIdEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEquipoActionPerformed

    private void txtIdActividadEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActividadEquipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActividadEquipActionPerformed

    private void txtNombreEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEmplActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEmplActionPerformed

    private void btnEliminaDepleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaDepleActionPerformed
        this.dtmdetEmp.removeRow(this.idDetEmp);
    }//GEN-LAST:event_btnEliminaDepleActionPerformed

    private void BtnAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarEmpleadoActionPerformed
        if(validaEmplea() ==  true){
            Vector vec = new Vector();
            vec.addElement(this.txtIDEmpleado.getText());
            vec.addElement(this.txtApellidos.getText());
            vec.addElement(this.txtNombreEmpl.getText());
            vec.addElement(this.txtIDActividad.getText());
            vec.addElement(this.txtDescripcionActividad.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            String fechaString = sdf.format(this.txtFecha.getDate());
            vec.addElement(fechaString);
            vec.addElement(this.txtHorasEmpleado.getText());
            this.dtmdetEmp.addRow(vec);
            limpiar();
        }
    }//GEN-LAST:event_BtnAgregarEmpleadoActionPerformed

    private void tblDetEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetEmpleadoMouseClicked
        this.btnEliminaDeple.setEnabled(true);
        int idx = this.tblDetEmpleado.getSelectedRow();
        this.idDetEmp = this.tblDetEmpleado.getSelectedRow();

        this.txtIdEmpleadoEquip.setText(this.dtmdetEmp.getValueAt(idx, 0).toString());
        this.txtApellidosEquipo.setText(this.dtmdetEmp.getValueAt(idx, 1).toString());
        this.txtIdActividadEquip.setText(this.dtmdetEmp.getValueAt(idx, 3).toString());
        this.txtDesEquipActvi.setText(this.dtmdetEmp.getValueAt(idx, 4).toString());
        this.txtfechaEqui.setText(this.dtmdetEmp.getValueAt(idx, 5).toString());
        this.txtHorasEqui.setText(this.dtmdetEmp.getValueAt(idx, 6).toString());
    }//GEN-LAST:event_tblDetEmpleadoMouseClicked

    private void btnBuscarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActividadActionPerformed
        Actividad act = new Actividad();
        SelActividad selac = new SelActividad(new javax.swing.JFrame(), true);
        selac.setVisible(true);
        act = selac.getActividad();
        this.txtIDActividad.setText(String.valueOf(act.getId_Actividad()));
        this.txtDescripcionActividad.setText(act.getDescripcion_Actividad());
    }//GEN-LAST:event_btnBuscarActividadActionPerformed

    private void txtHorasEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasEmpleadoActionPerformed

    private void txtDescripcionActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActividadActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        Empleado emp = new Empleado();
        SelEmpleado selemp = new SelEmpleado(new javax.swing.JFrame(), true);
        selemp.setVisible(true);
        emp = selemp.devEmpleado();
        this.txtIDEmpleado.setText(String.valueOf(emp.getIdEmpleado()));
        this.txtApellidos.setText(emp.getApellidos());
        this.txtNombreEmpl.setText(emp.getNombres());
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void txtIDEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDEmpleadoActionPerformed

    private void txtIDActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActividadActionPerformed

    private void btnatras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatras2ActionPerformed
        this.Panel.setSelectedIndex(0);
    }//GEN-LAST:event_btnatras2ActionPerformed

    private void btnBuscarVehiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVehiActionPerformed
        Vehiculo vehi=new Vehiculo();
        SelVehiculo dialog1=new SelVehiculo(new javax.swing.JFrame(), true);
        dialog1.setVisible(true);
        vehi=dialog1.getVehiculo();
        this.txtIdVehiculo.setText(String.valueOf(vehi.getIdVehiculo()));
        this.txtMarcaVehicu.setText(vehi.getMarca());
        this.txtPlacaVehi.setText(vehi.getPlaca());
    }//GEN-LAST:event_btnBuscarVehiActionPerformed

    private void txtApellidoClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoClieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoClieActionPerformed

    private void BtnBuscarClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarClieActionPerformed
        Cliente clie=new Cliente();
        SelCliente dialog = new SelCliente(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        clie=dialog.devCliente();
        this.txtIdCliente.setText(String.valueOf(clie.getIdCliente()));
        this.txtApellidoClie.setText(clie.getApellidos());
        this.txtNombreClie.setText(clie.getNombres());
        this.txtTelefonoClie.setText(clie.getTelefono());
        this.txtCorreoClie.setText(clie.getCorreo());
    }//GEN-LAST:event_BtnBuscarClieActionPerformed

    private void txtNombreClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClieActionPerformed

    private void btnBuscarMantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMantActionPerformed
        Mantenimiento mant=new Mantenimiento();
        SelMantenimiento dialog2=new SelMantenimiento(new javax.swing.JFrame(), true);
        dialog2.setVisible(true);
        mant=dialog2.devMantenimiento();
        this.txtIdMante.setText(String.valueOf(mant.getIdMantenimiento()));
        this.txtDescriMant.setText(mant.getDescripcion());
        this.txtTipMant.setText(mant.getTipoMant());
        this.txtPrioriMant.setText(mant.getPrioridad());
        this.txtPeriGaraMante.setText(mant.getPeriodoGarantia());
    }//GEN-LAST:event_btnBuscarMantActionPerformed

    private void txtDescriMantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriMantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriMantActionPerformed
    
    private boolean validaPanel1(){
        String cad = "";
        boolean bool = false;
        Date fecha = this.txtFechaPro.getDate();
        if (fecha == null) {
            cad += "\nDebe seleccionar una fecha de programacion";
        } else {
            Date fechaHoy = new Date();
            if (fecha.before(fechaHoy)) {
                cad += "\nDebe seleccionar una fecha de hoy o posterior";
            }
        }
        
        if(this.txtIdMante.getText().isEmpty()){
            cad += "\nDebe seleccionar un tipo de Mantenimiento";
        }
        
        if(this.txtIdCliente.getText().isEmpty()){
            cad += "\nDebe seleccionar un Cliente";
        }
        
        if(this.txtIdVehiculo.getText().isEmpty()){
            cad += "\nDebe seleccionar un Vehiculo";
        }
        
        if(this.txtobs.getText().isEmpty()){
            cad += "\nDebe Agregar alguna Observacion";
        }
        if(cad.isEmpty()){
            bool = true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return bool;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(validaPanel1()==true){
            this.Panel.setSelectedIndex(2);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtobsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtobsActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void txtBuscarCleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCleKeyReleased
        if(this.txtBuscarCle.getText().isEmpty()){
            this.llenaTblCliente(false, "", false);
        }else{
            this.llenaTblCliente(true, this.txtBuscarCle.getText(), true);
        }
    }//GEN-LAST:event_txtBuscarCleKeyReleased

    private void btnLimpiarOrdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarOrdeActionPerformed
        llenaTblCliente(false," ", false);
        llenaTblRegistroCliente(false, "" );
        this.txtBuscarCle.setText("");
    }//GEN-LAST:event_btnLimpiarOrdeActionPerformed

    private void tblClientesConOrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesConOrdenMouseClicked
        int filSelect=this.tblClientesConOrden.getSelectedRow();
        String idCliente=dtmClie.getValueAt(filSelect, 0).toString();
        this.llenaTblRegistroCliente(true, idCliente);
    }//GEN-LAST:event_tblClientesConOrdenMouseClicked
    
    private void tblCompraClieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCompraClieMouseClicked
        LimpiaCabezera();
        int idx = this.tblCompraClie.getSelectedRow();
        int idx2 = idx + 1;
        int resp = JOptionPane.showConfirmDialog(this, "Desea Actualizar la Orden con ID = "+ idx2 +"");
        if(resp == JOptionPane.YES_OPTION){
            this.btnGrabar.setText("Actualizar");
            this.Panel.setSelectedIndex(1);
            this.idOrdenActu = idx2;
            int idOrden = Integer.parseInt(this.dtmCRclie.getValueAt(idx, 0).toString());
            int idCliente = Integer.parseInt(this.dtmCRclie.getValueAt(idx, 1).toString());
            int idVehiculo = Integer.parseInt(this.dtmCRclie.getValueAt(idx, 3).toString());
            int idMantenimiento = Integer.parseInt(this.dtmCRclie.getValueAt(idx, 5).toString());

            //Datos Cab

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
            try {
                String fechaString = this.dtmCRclie.getValueAt(idx, 2).toString();
                Date fecha = dateFormat.parse(fechaString); 
                this.txtFechaPro.setDate(fecha); 
            } catch (java.text.ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al convertir la fecha: " + e.getMessage());
            }

            Vector<Cliente> clie;
            clie = clieDao.listaCliente(idCliente);
            for(int i=0; i<clie.size();i++){
                this.txtIdCliente.setText(String.valueOf(clie.get(i).getIdCliente()));
                this.txtApellidoClie.setText(clie.get(i).getApellidos());
                this.txtNombreClie.setText(clie.get(i).getNombres());
                this.txtTelefonoClie.setText(clie.get(i).getTelefono());
                this.txtCorreoClie.setText(clie.get(i).getCorreo());
            }

            Vector<Mantenimiento> mant;
             mant = mandao.listaMantenimiento(idMantenimiento);
             for(int i=0; i<mant.size();i++){
                this.txtIdMante.setText(String.valueOf(mant.get(i).getIdMantenimiento()));
                this.txtDescriMant.setText(mant.get(i).getDescripcion());
                this.txtTipMant.setText(mant.get(i).getTipoMant());
                this.txtPrioriMant.setText(mant.get(i).getPrioridad());
                this.txtPeriGaraMante.setText(mant.get(i).getPeriodoGarantia());
             }

            Vector<Vehiculo> listVehi = this.vehidao.listaVehiculos(idVehiculo);
            for(int i=0;i<listVehi.size();i++){
                this.txtIdVehiculo.setText(String.valueOf(listVehi.get(i).getIdVehiculo()));
                this.txtMarcaVehicu.setText(listVehi.get(i).getMarca());
                this.txtPlacaVehi.setText(listVehi.get(i).getPlaca());    
            }

            Vector<CabOrden> item;
            item = cabOrdDao.ListaItem(idOrden);
            for(int i=0;i<item.size();i++){
                this.txtobs.setText(item.get(i).getObs());  
            }

            //Llenar detalle Empleados 

            Vector<Det_Empleado_Cruzada> detem;

            detem = detemple.ListaItem(idOrden);
            dtmdetEmp.setRowCount(0);
            for(int i=0;i<detem.size();i++){
                Vector vec = new Vector();
                vec.addElement(detem.get(i).getIdempleado());
                vec.addElement(detem.get(i).getApellidos());
                vec.addElement(detem.get(i).getNombres());
                vec.addElement(detem.get(i).getIdactividad());
                vec.addElement(detem.get(i).getDescripcion());
                vec.addElement(detem.get(i).getFecha());
                vec.addElement(detem.get(i).getNumHoras());
                this.dtmdetEmp.addRow(vec);
            }

            //llenar detalle REPUESTO

            Vector<Det_Repuesto_Cruzada> detrep;

            detrep = detrepdao.ListaItem(idOrden);
            dtm1.setRowCount(0);
            for(int i=0;i<detrep.size();i++){
                Vector vec = new Vector();
                vec.addElement(detrep.get(i).getIdRepuesto());
                vec.addElement(detrep.get(i).getNombreRep());
                vec.addElement(detrep.get(i).getTipo());
                vec.addElement(detrep.get(i).getUnidadMedida());
                vec.addElement(detrep.get(i).getCantidad());

                this.dtm1.addRow(vec);
            }

            //llenar detalle Equipo

            Vector<Det_Equipo_Cruzada> detequi;

            detequi = detequidao.ListaItem(idOrden);
            dtmEquipo.setRowCount(0);
            for(int i=0;i<detrep.size();i++){
                Vector vec = new Vector();
                vec.addElement(detequi.get(i).getIdEmpleado());
                vec.addElement(detequi.get(i).getIdEquipo());
                vec.addElement(detequi.get(i).getNombre());
                vec.addElement(detequi.get(i).getCategoria());
                vec.addElement(detequi.get(i).getIdActividad());
                vec.addElement(detequi.get(i).getDesActividad());
                vec.addElement(detequi.get(i).getFecha());
                vec.addElement(detequi.get(i).getNumHoras());

                this.dtmEquipo.addRow(vec);
            }
            
            
            
        }
        
        this.tamañoDet = this.dtmdetEmp.getRowCount();
        this.tamañoEquipo = this.dtmEquipo.getRowCount();
        this.tamañoresp = this.dtm1.getRowCount();
        
        
        
        
    }//GEN-LAST:event_tblCompraClieMouseClicked

    
    private boolean validaEmplea() {
        boolean bool = false;
        String cad = "";

        if (this.txtIDEmpleado.getText().isEmpty()) {
            cad += "\nDebe seleccionar un empleado";
        }

        if (this.txtIDActividad.getText().isEmpty()) {
            cad += "\nDebe seleccionar una Actividad";
        }

        Date fecha = this.txtFecha.getDate();
        if (fecha == null) {
            cad += "\nDebe seleccionar una fecha";
        } else {
            Date fechaHoy = new Date();
            if (fecha.before(fechaHoy)) {
                cad += "\nDebe seleccionar una fecha de hoy o posterior";
            }
        }

        if (this.txtHorasEmpleado.getText().isEmpty()) {
            cad += "\nAgregar el número de horas del empleado";
        }

        if(cad.isEmpty()){
            bool = true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return bool;
    }
    
    private void limpiar(){
        this.txtIDEmpleado.setText("");
        this.txtApellidos.setText("");
        this.txtNombreEmpl.setText("");
        this.txtIDActividad.setText("");
        this.txtDescripcionActividad.setText("");
        this.txtFecha.setDate(null);
        this.txtHorasEmpleado.setText("");
    }    
    
    private boolean validaRepuesto(){
        String cad = "";
        boolean bool = false;
        
        if(this.txtRIdRepuesto.getText().isEmpty()){
            cad += "\nSeleccionar un repuesto";
        }
        
        if(this.cmbRMedida.getSelectedItem().toString().isEmpty()){
            cad += "\nSeleccionar una unidad de medida";
        }
        
        if(this.txtRCantidad.getText().isEmpty()){
            cad += "\nAgrega cantidad";
        }
        
        if(cad.isEmpty()){
            bool = true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return bool;
    }
        
   private boolean validaEquipo() {
        boolean bool = false;
        String cad = "";

        if (this.txtIdEquipo.getText().isEmpty()) {
            cad += "Debe seleccionar un Equipo\n";
        }

        if (this.txtIdEmpleadoEquip.getText().isEmpty()) {
            cad += "Debe seleccionar un Empleado de la tabla empleados asignados\n";
        }

        if(cad.isEmpty()){
            bool = true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return bool;
    }
    
    private void limpiarEquipo(){
        this.txtIdEquipo.setText("");
        this.txtApellidosEquipo.setText("");
        this.txtCategoriaEquipo.setText("");
        this.txtIdEmpleadoEquip.setText("");
        this.txtIdActividadEquip.setText("");
        this.txtDesEquipActvi.setText("");
        this.txtNombreEquipo.setText("");
        this.txtHorasEqui.setText("");
        this.txtfechaEqui.setText("");
    }
    
    
    
    
    
    
    
            


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarEmpleado;
    private javax.swing.JButton BtnBuscarClie;
    private javax.swing.JTabbedPane Panel;
    private javax.swing.JPanel PanelDetalles;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAtras2;
    private javax.swing.JButton btnBuscarActividad;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarEquip;
    private javax.swing.JButton btnBuscarMant;
    private javax.swing.JButton btnBuscarRepuesto;
    private javax.swing.JButton btnBuscarVehi;
    private javax.swing.JButton btnEliminaDeple;
    private javax.swing.JButton btnEliminarEquipo;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiarOrde;
    private javax.swing.JButton btnQuitarRepuesto;
    private javax.swing.JButton btnatras2;
    private javax.swing.JComboBox<String> cmbRMedida;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton30;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton nextpag3;
    private javax.swing.JPanel pagrep;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JTable tblClientesConOrden;
    private javax.swing.JTable tblCompraClie;
    private javax.swing.JTable tblDetEmpleado;
    private javax.swing.JTable tblDetEquipo;
    private javax.swing.JTable tblRepuesto;
    private javax.swing.JTextField txtApellidoClie;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosEquipo;
    private javax.swing.JTextField txtBuscarCle;
    private javax.swing.JTextField txtCategoriaEquipo;
    private javax.swing.JTextField txtCorreoClie;
    private javax.swing.JTextField txtDesEquipActvi;
    private javax.swing.JTextField txtDescriMant;
    private javax.swing.JTextField txtDescripcionActividad;
    private com.toedter.calendar.JDateChooser txtFecha;
    private com.toedter.calendar.JDateChooser txtFechaPro;
    private javax.swing.JTextField txtHorasEmpleado;
    private javax.swing.JTextField txtHorasEqui;
    private javax.swing.JTextField txtIDActividad;
    private javax.swing.JTextField txtIDEmpleado;
    private javax.swing.JTextField txtIdActividadEquip;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdEmpleadoEquip;
    private javax.swing.JTextField txtIdEquipo;
    private javax.swing.JTextField txtIdMante;
    private javax.swing.JTextField txtIdVehiculo;
    private javax.swing.JTextField txtMarcaVehicu;
    private javax.swing.JTextField txtNombreClie;
    private javax.swing.JTextField txtNombreEmpl;
    private javax.swing.JTextField txtNombreEquipo;
    private javax.swing.JTextField txtPeriGaraMante;
    private javax.swing.JTextField txtPlacaVehi;
    private javax.swing.JTextField txtPrioriMant;
    private javax.swing.JTextField txtRCantidad;
    private javax.swing.JTextField txtRIdRepuesto;
    private javax.swing.JTextField txtRNombre;
    private javax.swing.JTextField txtRTipo;
    private javax.swing.JTextField txtTelefonoClie;
    private javax.swing.JTextField txtTipMant;
    private javax.swing.JTextField txtfechaEqui;
    private javax.swing.JTextField txtobs;
    // End of variables declaration//GEN-END:variables
}
