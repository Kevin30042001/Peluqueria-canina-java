/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import Clases.Empleados;
import Clases.dbObjetos;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/**
 *
 * @author Atermiter-X99
 */
public class Menu extends javax.swing.JFrame {

    
    private Empleados pUser = new Empleados();
    private frmMenuPrincipal frmMenuPrincipal;
    public Menu(Empleados user) {
        initComponents();
        pUser = user;
        this.setTitle("Sistema de Peluquería Canina - Usuario: " + pUser.getNombre());
        this.setExtendedState(MAXIMIZED_BOTH);
        MantenimientoActionPerformed(null);
        cargarRolesUsuario();
    }
  private void cargarRolesUsuario() {
        String rol = pUser.getRol();

        if ("Administrador".equalsIgnoreCase(rol)) {
            // Acceso completo, carga frmMenuPrincipal
            cargarFormularioMenuPrincipal();
            Mantenimiento.setEnabled(true);
        } else if ("Empleado".equalsIgnoreCase(rol) || "Cajero".equalsIgnoreCase(rol))  {
            // Acceso solo al formulario frmCajero
            cargarFormularioCajero();
            Mantenimiento.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Rol no reconocido: " + rol, "Error de Rol", JOptionPane.ERROR_MESSAGE);}
    }
   private void cargarFormularioCajero() {
        frmCajero iframeCajero = new frmCajero(this.frmMenuPrincipal);
        dpContenedor.add(iframeCajero);
        Dimension tCont = dpContenedor.getSize();
        Dimension tiFrame = iframeCajero.getSize();
        iframeCajero.setLocation((tCont.width - tiFrame.width) / 2, (tCont.height - tiFrame.height) / 2);
        iframeCajero.setVisible(true);
    }
    private void cargarFormularioMenuPrincipal() {
        this.frmMenuPrincipal = new frmMenuPrincipal();
        dpContenedor.add(this.frmMenuPrincipal);
        Dimension tCont = dpContenedor.getSize();
        Dimension tiFrame = this.frmMenuPrincipal.getSize();
        this.frmMenuPrincipal.setLocation((tCont.width - tiFrame.width) / 2, (tCont.height - tiFrame.height) / 2);
        this.frmMenuPrincipal.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpContenedor = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Mantenimiento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dpContenedorLayout = new javax.swing.GroupLayout(dpContenedor);
        dpContenedor.setLayout(dpContenedorLayout);
        dpContenedorLayout.setHorizontalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 829, Short.MAX_VALUE)
        );
        dpContenedorLayout.setVerticalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        jMenu1.setText("Menú");

        Mantenimiento.setText("Menú Principal");
        Mantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MantenimientoActionPerformed(evt);
            }
        });
        jMenu1.add(Mantenimiento);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");

        jMenuItem4.setText("Salir de Sistema");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpContenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpContenedor)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MantenimientoActionPerformed
        this.frmMenuPrincipal = new frmMenuPrincipal();
        dpContenedor.add(this.frmMenuPrincipal);
        Dimension tCont = dpContenedor.getSize();
        Dimension tiFrame = this.frmMenuPrincipal.getSize();
        this.frmMenuPrincipal.setLocation((tCont.width - tiFrame.width) / 2, (tCont.height - tiFrame.height) / 2);
        this.frmMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_MantenimientoActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Mantenimiento;
    private javax.swing.JDesktopPane dpContenedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
