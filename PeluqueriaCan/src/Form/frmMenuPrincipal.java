/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Form;


import java.awt.Dimension;
import javax.swing.JInternalFrame;

public class frmMenuPrincipal extends javax.swing.JInternalFrame {

private frmCajero frmCajero;
private frmProducto frmProducto;
private frmReservas frmReservas;
private Servicios frmServicios;
private frmRepoFactura frmRepoFactura;

 public frmMenuPrincipal() {
        
        initComponents();
    }



  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnProducto = new javax.swing.JButton();
        btnCobro = new javax.swing.JButton();
        btnReserva = new javax.swing.JButton();
        btnMttoClientes = new javax.swing.JButton();
        btnMttoEmpleados = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ReporFact = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("\"PELUQUERIA CANINA\"");

        btnProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/productos.png"))); // NOI18N
        btnProducto.setText("PRODUCTOS");
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });

        btnCobro.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCobro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salario.png"))); // NOI18N
        btnCobro.setText("COBRO");
        btnCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobroActionPerformed(evt);
            }
        });

        btnReserva.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reservado.png"))); // NOI18N
        btnReserva.setText("RESERVA");
        btnReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservaActionPerformed(evt);
            }
        });

        btnMttoClientes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMttoClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/objetivo.png"))); // NOI18N
        btnMttoClientes.setText("CLIENTES");
        btnMttoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMttoClientesActionPerformed(evt);
            }
        });

        btnMttoEmpleados.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMttoEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleados.png"))); // NOI18N
        btnMttoEmpleados.setText("EMPLEADOS");
        btnMttoEmpleados.setToolTipText("");
        btnMttoEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMttoEmpleadosActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salida.png"))); // NOI18N
        btnSalir.setText("CERRAR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnServicios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agente-de-servicio-al-cliente.png"))); // NOI18N
        btnServicios.setText("SERVICIOS");
        btnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perro.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(50, 50));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("MENÚ PRINCIPAL");

        ReporFact.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ReporFact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cuenta.png"))); // NOI18N
        ReporFact.setText("REPORTES VENTAS");
        ReporFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporFactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(ReporFact)
                                .addGap(126, 126, 126)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMttoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMttoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel2)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(btnMttoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnMttoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ReporFact, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
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
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMttoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMttoClientesActionPerformed
   frmClientes_1 formularioCliente = new frmClientes_1(this);
    this.getDesktopPane().add(formularioCliente);
        formularioCliente.setVisible(true);
    this.setVisible(false);



    }//GEN-LAST:event_btnMttoClientesActionPerformed

    private void btnMttoEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMttoEmpleadosActionPerformed
         // TODO add your handling code here:
        
         frmEmpleado formularioEmpleado = new frmEmpleado(this);
        this.getDesktopPane().add(formularioEmpleado);
        formularioEmpleado.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMttoEmpleadosActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed

        frmProducto = new frmProducto(this);
        this.getDesktopPane().add(frmProducto);
        frmProducto.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservaActionPerformed
      frmReservas = new frmReservas(this);
        this.getDesktopPane().add(frmReservas);
        frmReservas.setVisible(true);
        this.setVisible(false);
 
    }//GEN-LAST:event_btnReservaActionPerformed

    private void btnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosActionPerformed
      frmServicios = new Servicios(this);
        this.getDesktopPane().add(frmServicios);
        frmServicios.setVisible(true);
        this.setVisible(false);

    

    }//GEN-LAST:event_btnServiciosActionPerformed

    private void btnCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobroActionPerformed
       frmVentas formularioCobro = new frmVentas(this);
        this.getDesktopPane().add(formularioCobro);
        formularioCobro.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnCobroActionPerformed

    private void ReporFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporFactActionPerformed
        // TODO add your handling code here:
        frmRepoFactura = new frmRepoFactura(this);
        this.getDesktopPane().add(frmRepoFactura);
           frmRepoFactura.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_ReporFactActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReporFact;
    private javax.swing.JButton btnCobro;
    private javax.swing.JButton btnMttoClientes;
    private javax.swing.JButton btnMttoEmpleados;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnReserva;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
