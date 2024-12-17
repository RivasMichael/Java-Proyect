
package UI;


import CORREO.FrmCorreo;
import REPORTES.FrmParActividad;
import REPORTES.FrmParCliente;
import REPORTES.FrmParEmpleado;
import REPORTES.FrmParRepuesto;
import REPORTES.FrmParVehiculo;
import REPORTES.FrmParEquipo;
import REPORTES.FrmParMant;
import REPORTES.FrmParRol;
import REPORTES.FrmParUsuario;
import REPORTES.RegistroEMPLEADO;
import UI.Mantenimiento.FrmMantActividad;
import UI.Mantenimiento.FrmMantEmpleado;
import UI.Mantenimiento.FrmMantEquipo;
import UI.Mantenimiento.FrmMantMantenimiento;
import UI.Mantenimiento.FrmMantRepuesto;
import UI.Mantenimiento.FrmMantRol;
import UI.Mantenimiento.FrmMantUsuario;
import UI.Mantenimiento.FrmMantVehiculo;
import UI.Mantenimiento.FrnMantCliente;
import UTIL.DbBean;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class MDI extends javax.swing.JFrame {

    private int wd;
    private int hd;
    int idusuario;
    public MDI(int idUsuario) {
        initComponents();
        idusuario = idUsuario;
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); 
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "¿Estás seguro de que deseas cerrar la aplicación?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0); 
                }
            }
        });
        
        this.setLocationRelativeTo(null);

        this.menuReportes.setVisible(false);
        this.mnuMantenimiento.setVisible(false);
        this.menuCorreo.setVisible(false);
        this.menuReporteEmpleados.setVisible(false);
    }
    public void setvisible(){
        this.menuReportes.setVisible(true);
        this.mnuMantenimiento.setVisible(true);
        this.menuCorreo.setVisible(true);
        this.menuReporteEmpleados.setVisible(true);
    }

   
    int dimW(){
      return wd;
    }
    int dimH(){
       return hd;
    }
    
    public void cerrarFrames(JDesktopPane desktopPane) {
        JInternalFrame[] frames = desktopPane.getAllFrames();

        for (JInternalFrame frame : frames) {
            if (frame != null && frame.isVisible()) {
                try {
                    frame.setClosed(true); 
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuMantenimiento = new javax.swing.JMenu();
        sMnuActividad = new javax.swing.JMenuItem();
        sMnuEmpleado = new javax.swing.JMenuItem();
        sMnuEquipo = new javax.swing.JMenuItem();
        sMnuMantenimiento = new javax.swing.JMenuItem();
        sMnuRepuesto = new javax.swing.JMenuItem();
        sMnuUsuario = new javax.swing.JMenuItem();
        sMnuVehiculo = new javax.swing.JMenuItem();
        sMnuRol = new javax.swing.JMenuItem();
        sMnuCliente = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        RepSimActividad = new javax.swing.JMenuItem();
        RepSimEmpleados = new javax.swing.JMenuItem();
        RepSimEquipos = new javax.swing.JMenuItem();
        RepSimMantenimiento = new javax.swing.JMenuItem();
        RepSimRepuestos = new javax.swing.JMenuItem();
        RepSimUsuarios = new javax.swing.JMenuItem();
        RepSimVehiculos = new javax.swing.JMenuItem();
        RepSimRoles = new javax.swing.JMenuItem();
        RepSimpleClientes = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        RepParActividad = new javax.swing.JMenuItem();
        RepParEmpleado = new javax.swing.JMenuItem();
        RepParEquipo = new javax.swing.JMenuItem();
        RepParMantenimiento = new javax.swing.JMenuItem();
        RepParRepuesto = new javax.swing.JMenuItem();
        RepParUsuario = new javax.swing.JMenuItem();
        RepParVehiculo = new javax.swing.JMenuItem();
        RepParRol = new javax.swing.JMenuItem();
        RepParCliente = new javax.swing.JMenuItem();
        RepEmpledadosDatosGerales = new javax.swing.JMenuItem();
        menuCorreo = new javax.swing.JMenu();
        menuReporteEmpleados = new javax.swing.JMenu();
        MenuOrdenMantenimeinto = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escritorio.setAlignmentX(0.7F);
        Escritorio.setAlignmentY(0.7F);
        Escritorio.setInheritsPopupMenu(true);
        Escritorio.setPreferredSize(new java.awt.Dimension(1920, 1800));

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1343, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );

        getContentPane().add(Escritorio, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(0, 51, 204));
        jMenuBar1.setForeground(new java.awt.Color(0, 51, 204));

        mnuMantenimiento.setBackground(new java.awt.Color(255, 255, 0));
        mnuMantenimiento.setBorder(null);
        mnuMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mantenimiento.png"))); // NOI18N
        mnuMantenimiento.setText("MANTENIMIENTO");
        mnuMantenimiento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        sMnuActividad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sMnuActividad.setText("Actividad");
        sMnuActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuActividadActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuActividad);

        sMnuEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sMnuEmpleado.setText("Empleado");
        sMnuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuEmpleadoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuEmpleado);

        sMnuEquipo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sMnuEquipo.setText("Equipo");
        sMnuEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuEquipoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuEquipo);

        sMnuMantenimiento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sMnuMantenimiento.setText("Mantenimiento");
        sMnuMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuMantenimientoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuMantenimiento);

        sMnuRepuesto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sMnuRepuesto.setText("Repuesto");
        sMnuRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuRepuestoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuRepuesto);

        sMnuUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sMnuUsuario.setText("Usuario");
        sMnuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuUsuarioActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuUsuario);

        sMnuVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sMnuVehiculo.setText("Vehiculo");
        sMnuVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuVehiculoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuVehiculo);

        sMnuRol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sMnuRol.setText("Rol");
        sMnuRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuRolActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuRol);

        sMnuCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sMnuCliente.setText("Cliente");
        sMnuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuClienteActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuCliente);

        jMenuBar1.add(mnuMantenimiento);

        menuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reporte.png"))); // NOI18N
        menuReportes.setText("REPORTES");
        menuReportes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jMenu6.setText("Simples");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        RepSimActividad.setText("Actividades");
        RepSimActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepSimActividadActionPerformed(evt);
            }
        });
        jMenu6.add(RepSimActividad);

        RepSimEmpleados.setText("Empleados");
        RepSimEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepSimEmpleadosActionPerformed(evt);
            }
        });
        jMenu6.add(RepSimEmpleados);

        RepSimEquipos.setText("Equipos");
        RepSimEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepSimEquiposActionPerformed(evt);
            }
        });
        jMenu6.add(RepSimEquipos);

        RepSimMantenimiento.setText("Mantenimientos");
        RepSimMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepSimMantenimientoActionPerformed(evt);
            }
        });
        jMenu6.add(RepSimMantenimiento);

        RepSimRepuestos.setText("Repuestos");
        RepSimRepuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepSimRepuestosActionPerformed(evt);
            }
        });
        jMenu6.add(RepSimRepuestos);

        RepSimUsuarios.setText("Usuarios");
        RepSimUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepSimUsuariosActionPerformed(evt);
            }
        });
        jMenu6.add(RepSimUsuarios);

        RepSimVehiculos.setText("Vehiculos");
        RepSimVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepSimVehiculosActionPerformed(evt);
            }
        });
        jMenu6.add(RepSimVehiculos);

        RepSimRoles.setText("Roles");
        RepSimRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepSimRolesActionPerformed(evt);
            }
        });
        jMenu6.add(RepSimRoles);

        RepSimpleClientes.setText("Clientes");
        RepSimpleClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepSimpleClientesActionPerformed(evt);
            }
        });
        jMenu6.add(RepSimpleClientes);

        menuReportes.add(jMenu6);

        jMenu7.setText("Parametros");

        RepParActividad.setText("ActividadPorCategoria");
        RepParActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepParActividadActionPerformed(evt);
            }
        });
        jMenu7.add(RepParActividad);

        RepParEmpleado.setText("EmpleadosPorEstado");
        RepParEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepParEmpleadoActionPerformed(evt);
            }
        });
        jMenu7.add(RepParEmpleado);

        RepParEquipo.setText("EquiposPorCategoria");
        RepParEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepParEquipoActionPerformed(evt);
            }
        });
        jMenu7.add(RepParEquipo);

        RepParMantenimiento.setText("MantenimientoPorPrioridad");
        RepParMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepParMantenimientoActionPerformed(evt);
            }
        });
        jMenu7.add(RepParMantenimiento);

        RepParRepuesto.setText("RepuestosPorStock");
        RepParRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepParRepuestoActionPerformed(evt);
            }
        });
        jMenu7.add(RepParRepuesto);

        RepParUsuario.setText("UsuariosPorAñosyMes");
        RepParUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepParUsuarioActionPerformed(evt);
            }
        });
        jMenu7.add(RepParUsuario);

        RepParVehiculo.setText("VehiculosPorMarca");
        RepParVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepParVehiculoActionPerformed(evt);
            }
        });
        jMenu7.add(RepParVehiculo);

        RepParRol.setText("DisponibilidadRoles");
        RepParRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepParRolActionPerformed(evt);
            }
        });
        jMenu7.add(RepParRol);

        RepParCliente.setText("ClientePorEstado");
        RepParCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepParClienteActionPerformed(evt);
            }
        });
        jMenu7.add(RepParCliente);

        menuReportes.add(jMenu7);

        RepEmpledadosDatosGerales.setText("EmpleadosGeneral");
        RepEmpledadosDatosGerales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RepEmpledadosDatosGeralesMouseClicked(evt);
            }
        });
        RepEmpledadosDatosGerales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepEmpledadosDatosGeralesActionPerformed(evt);
            }
        });
        menuReportes.add(RepEmpledadosDatosGerales);

        jMenuBar1.add(menuReportes);

        menuCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/correo.png"))); // NOI18N
        menuCorreo.setText("ENVIARCORREO");
        menuCorreo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menuCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCorreoMouseClicked(evt);
            }
        });
        menuCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCorreoActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuCorreo);

        menuReporteEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte_empleado.png"))); // NOI18N
        menuReporteEmpleados.setText("ENVIARREPORTES");
        menuReporteEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menuReporteEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuReporteEmpleadosMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuReporteEmpleados);

        MenuOrdenMantenimeinto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caja-registradora.png"))); // NOI18N
        MenuOrdenMantenimeinto.setText("ORDEN MP");
        MenuOrdenMantenimeinto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MenuOrdenMantenimeinto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuOrdenMantenimeintoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuOrdenMantenimeintoMouseEntered(evt);
            }
        });
        MenuOrdenMantenimeinto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOrdenMantenimeintoActionPerformed(evt);
            }
        });
        jMenuBar1.add(MenuOrdenMantenimeinto);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sMnuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuEmpleadoActionPerformed
           this.cerrarFrames(this.Escritorio);
           FrmMantEmpleado  frmEmple=new FrmMantEmpleado();
           int desktopWidth = Escritorio.getWidth();
            int desktopHeight = Escritorio.getHeight();
            int frameWidth = frmEmple.getWidth();
            int frameHeight = frmEmple.getHeight();
            int x = (desktopWidth - frameWidth) / 2;
            int y = (desktopHeight - frameHeight) / 2;
            frmEmple.setLocation(x, y);
           frmEmple.setVisible(true);
           this.Escritorio.add(frmEmple);
    }//GEN-LAST:event_sMnuEmpleadoActionPerformed

    private void sMnuMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuMantenimientoActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrmMantMantenimiento frmMant=new FrmMantMantenimiento();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = frmMant.getWidth();
        int frameHeight = frmMant.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        frmMant.setLocation(x, y);
        frmMant.setVisible(true);
        this.Escritorio.add(frmMant);
    }//GEN-LAST:event_sMnuMantenimientoActionPerformed

    private void sMnuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuUsuarioActionPerformed
       this.cerrarFrames(this.Escritorio);
       FrmMantUsuario frmUsuar=new FrmMantUsuario();
       int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = frmUsuar.getWidth();
        int frameHeight = frmUsuar.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        frmUsuar.setLocation(x, y);
       frmUsuar.setVisible(true);
       this.Escritorio.add(frmUsuar);
    }//GEN-LAST:event_sMnuUsuarioActionPerformed

    private void sMnuActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuActividadActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrmMantActividad frmActivid=new FrmMantActividad();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = frmActivid.getWidth();
        int frameHeight = frmActivid.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        frmActivid.setLocation(x, y);
        frmActivid.setVisible(true);
        this.Escritorio.add(frmActivid);
        
    }//GEN-LAST:event_sMnuActividadActionPerformed

    private void sMnuEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuEquipoActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrmMantEquipo frmEqui=new FrmMantEquipo();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = frmEqui.getWidth();
        int frameHeight = frmEqui.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        frmEqui.setLocation(x, y);
        frmEqui.setVisible(true);
        this.Escritorio.add(frmEqui);
    }//GEN-LAST:event_sMnuEquipoActionPerformed

    private void sMnuRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuRepuestoActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrmMantRepuesto frmRepuest=new FrmMantRepuesto();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = frmRepuest.getWidth();
        int frameHeight = frmRepuest.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        frmRepuest.setLocation(x, y);
        frmRepuest.setVisible(true);
        this.Escritorio.add(frmRepuest);
    }//GEN-LAST:event_sMnuRepuestoActionPerformed

    private void sMnuVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuVehiculoActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrmMantVehiculo frmVehi=new FrmMantVehiculo();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = frmVehi.getWidth();
        int frameHeight = frmVehi.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        frmVehi.setLocation(x, y);
        frmVehi.setVisible(true);
        this.Escritorio.add(frmVehi);
    }//GEN-LAST:event_sMnuVehiculoActionPerformed

    private void sMnuRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuRolActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrmMantRol frmR=new FrmMantRol();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = frmR.getWidth();
        int frameHeight = frmR.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        frmR.setLocation(x, y);
        frmR.setVisible(true);
        this.Escritorio.add(frmR);
    }//GEN-LAST:event_sMnuRolActionPerformed

    private void sMnuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuClienteActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrnMantCliente frmClie=new FrnMantCliente();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = frmClie.getWidth();
        int frameHeight = frmClie.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        frmClie.setLocation(x, y);
        frmClie.setVisible(true);
        this.Escritorio.add(frmClie);
    }//GEN-LAST:event_sMnuClienteActionPerformed
    public void agregarInternalFrame(JInternalFrame internalFrame) {
        
        this.Escritorio.add(internalFrame);
    }
    private void RepSimActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepSimActividadActionPerformed
         try{
        HashMap h = new HashMap();
        String logo = "/REPORTES/actividad.jpg";
        h.put("logo", this.getClass().getResourceAsStream(logo));     
        String r="src/REPORTES/RepSimActividad.jasper";
        DbBean db=new DbBean();
        db.connectRep(r, h, true);
        }catch(SQLException ex){
          ex.printStackTrace();
        }catch(JRException ex){
          ex.printStackTrace();
        }
    }//GEN-LAST:event_RepSimActividadActionPerformed

    private void RepSimEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepSimEmpleadosActionPerformed
          try{
        HashMap h = new HashMap();
        String logo = "/REPORTES/empleados.png";
        h.put("logo", this.getClass().getResourceAsStream(logo));  
        String r="src/REPORTES/RepSimEmpleados.jasper";
        DbBean db=new DbBean();
        db.connectRep(r, h, true);
        }catch(SQLException ex){
          ex.printStackTrace();
        }catch(JRException ex){
          ex.printStackTrace();
        }
    }//GEN-LAST:event_RepSimEmpleadosActionPerformed

    private void RepSimpleClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepSimpleClientesActionPerformed
         try{
            HashMap h = new HashMap();
            String logo = "/REPORTES/cliente.jpg";
            h.put("logo", this.getClass().getResourceAsStream(logo));
            String ruta ="src/REPORTES/RepSimCliente.jasper";
            DbBean db=new DbBean();
            db.connectRep(ruta, h, true);
            }catch(SQLException ex){
              ex.printStackTrace();
            }catch(JRException ex){
              ex.printStackTrace();
            }
    }//GEN-LAST:event_RepSimpleClientesActionPerformed

    private void RepSimRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepSimRolesActionPerformed
         try{
            HashMap h = new HashMap();
            String logo = "/REPORTES/roles.png";
            h.put("logo", this.getClass().getResourceAsStream(logo));
            String ruta = "src/REPORTES/RepSimRol.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, h, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_RepSimRolesActionPerformed

    private void RepSimUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepSimUsuariosActionPerformed
        try{
            HashMap h = new HashMap();
            String logo = "/REPORTES/usuario.png";
            h.put("logo", this.getClass().getResourceAsStream(logo));
            String ruta = "src/REPORTES/RepSimUsuario.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, h, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_RepSimUsuariosActionPerformed

    
    
    private void RepParActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepParActividadActionPerformed
       this.cerrarFrames(this.Escritorio);
       FrmParActividad repACategoria= new FrmParActividad();
        int desktopWidth = Escritorio.getWidth();
            int desktopHeight = Escritorio.getHeight();
            int frameWidth = repACategoria.getWidth();
            int frameHeight = repACategoria.getHeight();
            int x = (desktopWidth - frameWidth) / 2;
            int y = (desktopHeight - frameHeight) / 2;
            repACategoria.setLocation(x, y);
       this.Escritorio.add(repACategoria);
       repACategoria.setVisible(true);
    }//GEN-LAST:event_RepParActividadActionPerformed

    private void RepParRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepParRolActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrmParRol ParRol = new FrmParRol();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = ParRol.getWidth();
        int frameHeight = ParRol.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        ParRol.setLocation(x, y);
        ParRol.setVisible(true);
        this.Escritorio.add(ParRol);
    }//GEN-LAST:event_RepParRolActionPerformed

    private void RepParUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepParUsuarioActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrmParUsuario paru = new FrmParUsuario();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = paru.getWidth();
        int frameHeight = paru.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        paru.setLocation(x, y);
        paru.setVisible(true);
        this.Escritorio.add(paru);
    }//GEN-LAST:event_RepParUsuarioActionPerformed

    private void RepSimRepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepSimRepuestosActionPerformed
        try{
            HashMap h = new HashMap();
            String logo = "/REPORTES/Repuestos.jpg";
            h.put("logo", this.getClass().getResourceAsStream(logo));
            String ruta = "src/REPORTES/RepSimRepuesto.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, h, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_RepSimRepuestosActionPerformed

    private void RepSimVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepSimVehiculosActionPerformed
        try{
            HashMap h = new HashMap();
            String logo = "/REPORTES/vehiculo.jpg";
            h.put("logo", this.getClass().getResourceAsStream(logo));
            String ruta = "src/REPORTES/RepSimVehiculo.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, h, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_RepSimVehiculosActionPerformed

    private void RepSimEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepSimEquiposActionPerformed
        try{
            HashMap h = new HashMap();
            String logo = "/REPORTES/equipo.jpg";
            h.put("logo", this.getClass().getResourceAsStream(logo));
            String ruta = "src/REPORTES/RepSimEquipo.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, h, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_RepSimEquiposActionPerformed

    private void RepSimMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepSimMantenimientoActionPerformed

    try{
            HashMap h = new HashMap();
            String logo = "/REPORTES/mantenimiento.jpg";
            h.put("logo", this.getClass().getResourceAsStream(logo));
            String ruta = "src/REPORTES/RepSimMantenimiento.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, h, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_RepSimMantenimientoActionPerformed

    private void RepParRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepParRepuestoActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrmParRepuesto rep = new FrmParRepuesto();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = rep.getWidth();
        int frameHeight = rep.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        rep.setLocation(x, y);
        rep.setVisible(true);
        this.Escritorio.add(rep);

    }//GEN-LAST:event_RepParRepuestoActionPerformed

    private void RepParVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepParVehiculoActionPerformed
        this.cerrarFrames(this.Escritorio);
        FrmParVehiculo vehi = new FrmParVehiculo();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = vehi.getWidth();
        int frameHeight = vehi.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        vehi.setLocation(x, y);
        vehi.setVisible(true);
        this.Escritorio.add(vehi);
        
    }//GEN-LAST:event_RepParVehiculoActionPerformed

    private void MenuOrdenMantenimeintoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOrdenMantenimeintoActionPerformed
  
    }//GEN-LAST:event_MenuOrdenMantenimeintoActionPerformed

    private void MenuOrdenMantenimeintoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuOrdenMantenimeintoMouseEntered

    }//GEN-LAST:event_MenuOrdenMantenimeintoMouseEntered

    private void MenuOrdenMantenimeintoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuOrdenMantenimeintoMouseClicked
        this.cerrarFrames(this.Escritorio);
        FrmOMP frm = new FrmOMP(this.idusuario);
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = frm.getWidth();
        int frameHeight = frm.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        frm.setLocation(x, y);
        frm.setVisible(true);
        Escritorio.add(frm);
    }//GEN-LAST:event_MenuOrdenMantenimeintoMouseClicked

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void RepParClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepParClienteActionPerformed
       this.cerrarFrames(this.Escritorio);
       FrmParCliente repCEstado=new FrmParCliente();
       this.Escritorio.add(repCEstado);
       int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = repCEstado.getWidth();
        int frameHeight = repCEstado.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        repCEstado.setLocation(x, y);
       repCEstado.setVisible(true);
          
    }//GEN-LAST:event_RepParClienteActionPerformed

    private void RepParMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepParMantenimientoActionPerformed
       this.cerrarFrames(this.Escritorio);
       FrmParMant par = new FrmParMant();
       int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = par.getWidth();
        int frameHeight = par.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        par.setLocation(x, y);
       par.setVisible(true);
       this.Escritorio.add(par);
    }//GEN-LAST:event_RepParMantenimientoActionPerformed

    private void RepParEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepParEquipoActionPerformed
       this.cerrarFrames(this.Escritorio);
       FrmParEquipo par = new FrmParEquipo();
       int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = par.getWidth();
        int frameHeight = par.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        par.setLocation(x, y);
       par.setVisible(true);
       this.Escritorio.add(par);
    }//GEN-LAST:event_RepParEquipoActionPerformed

    private void RepParEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepParEmpleadoActionPerformed
       this.cerrarFrames(this.Escritorio);
       FrmParEmpleado repEs = new FrmParEmpleado();
       int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = repEs.getWidth();
        int frameHeight = repEs.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        repEs.setLocation(x, y);
       this.Escritorio.add(repEs);
       repEs.setVisible(true);
        
        
    }//GEN-LAST:event_RepParEmpleadoActionPerformed

    private void menuCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCorreoActionPerformed
       
    }//GEN-LAST:event_menuCorreoActionPerformed

    private void menuCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCorreoMouseClicked
        this.cerrarFrames(this.Escritorio);
        FrmCorreo frm = new FrmCorreo(this.Escritorio);
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = frm.getWidth();
        int frameHeight = frm.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        frm.setLocation(x, y);
        frm.setVisible(true);
        this.Escritorio.add(frm);
    }//GEN-LAST:event_menuCorreoMouseClicked

    private void RepEmpledadosDatosGeralesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RepEmpledadosDatosGeralesMouseClicked
        
    }//GEN-LAST:event_RepEmpledadosDatosGeralesMouseClicked

    private void RepEmpledadosDatosGeralesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepEmpledadosDatosGeralesActionPerformed
       try{
            HashMap h = new HashMap();
            String logo = "/REPORTES/empleados.png";
            h.put("logo", this.getClass().getResourceAsStream(logo));
            String ruta = "src/REPORTES/RepCruzadoXempleadoXrolXusuario.jasper";
            DbBean rep = new DbBean();
            rep.connectRep(ruta, h, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_RepEmpledadosDatosGeralesActionPerformed

    private void menuReporteEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuReporteEmpleadosMouseClicked
        this.cerrarFrames(this.Escritorio);
        RegistroEMPLEADO reo = new RegistroEMPLEADO();
        int desktopWidth = Escritorio.getWidth();
        int desktopHeight = Escritorio.getHeight();
        int frameWidth = reo.getWidth();
        int frameHeight = reo.getHeight();
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;
        reo.setLocation(x, y);
        reo.setVisible(true);
        this.Escritorio.add(reo);
    }//GEN-LAST:event_menuReporteEmpleadosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu MenuOrdenMantenimeinto;
    private javax.swing.JMenuItem RepEmpledadosDatosGerales;
    private javax.swing.JMenuItem RepParActividad;
    private javax.swing.JMenuItem RepParCliente;
    private javax.swing.JMenuItem RepParEmpleado;
    private javax.swing.JMenuItem RepParEquipo;
    private javax.swing.JMenuItem RepParMantenimiento;
    private javax.swing.JMenuItem RepParRepuesto;
    private javax.swing.JMenuItem RepParRol;
    private javax.swing.JMenuItem RepParUsuario;
    private javax.swing.JMenuItem RepParVehiculo;
    private javax.swing.JMenuItem RepSimActividad;
    private javax.swing.JMenuItem RepSimEmpleados;
    private javax.swing.JMenuItem RepSimEquipos;
    private javax.swing.JMenuItem RepSimMantenimiento;
    private javax.swing.JMenuItem RepSimRepuestos;
    private javax.swing.JMenuItem RepSimRoles;
    private javax.swing.JMenuItem RepSimUsuarios;
    private javax.swing.JMenuItem RepSimVehiculos;
    private javax.swing.JMenuItem RepSimpleClientes;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCorreo;
    private javax.swing.JMenu menuReporteEmpleados;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenuItem sMnuActividad;
    private javax.swing.JMenuItem sMnuCliente;
    private javax.swing.JMenuItem sMnuEmpleado;
    private javax.swing.JMenuItem sMnuEquipo;
    private javax.swing.JMenuItem sMnuMantenimiento;
    private javax.swing.JMenuItem sMnuRepuesto;
    private javax.swing.JMenuItem sMnuRol;
    private javax.swing.JMenuItem sMnuUsuario;
    private javax.swing.JMenuItem sMnuVehiculo;
    // End of variables declaration//GEN-END:variables
}
