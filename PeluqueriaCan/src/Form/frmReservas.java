
package Form;

import Clases.dbObjetos;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;

public class frmReservas extends javax.swing.JInternalFrame {

    dbObjetos cSql = new dbObjetos();
    private frmMenuPrincipal menuPrincipal;
    ResultSet rs = null;
    DefaultComboBoxModel<String> modeloMascota = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> modeloServicio = new DefaultComboBoxModel<>();

    public frmReservas(frmMenuPrincipal menuPrincipal) {
        initComponents();
        this.menuPrincipal = menuPrincipal;
        cargarMascotas();
        cargarServicios();
    }

    private void cargarMascotas() {
        try {
            ResultSet rs = cSql.ListarMascotas();
            cbbMascota.removeAllItems();
            while (rs.next()) {
                modeloMascota.addElement(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void cargarServicios() {
        try {
            ResultSet rs = cSql.ListarServicio();
            cbbServicio.removeAllItems();
            while (rs.next()) {
                modeloServicio.addElement(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            java.util.Date fechaSeleccionada = (java.util.Date) evt.getNewValue();
            if (fechaSeleccionada != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                txtFechaReserva.setText(dateFormat.format(fechaSeleccionada));
            }
        }
    }

    private void limpiarCampos() {
        txtCodigoReserva.setText("");
        jCalendar1.setCalendar(new GregorianCalendar()); // Establece una nueva instancia del calendario
        txtFechaReserva.setText("");
        txtHora.setText("");
        cbbMascota.setSelectedIndex(0); // Selecciona el primer elemento del ComboBox de mascotas
        cbbServicio.setSelectedIndex(0); // Selecciona el primer elemento del ComboBox de servicios
        txtTotal.setText("");
    }

    private void ActivarControles(boolean v) {
        txtCodigoReserva.setEditable(v);
        jCalendar1.setEnabled(v);
        txtFechaReserva.setEditable(v);
        txtHora.setEditable(v);
        cbbMascota.setEnabled(v);
        cbbServicio.setEnabled(v);
        txtTotal.setEditable(v);

        btnEliminar.setEnabled(!v);

        btnCerrar.setEnabled(!v);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoReserva = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        btnCerrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtFechaReserva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        modeloServicio = new DefaultComboBoxModel<>();
        cbbServicio = new javax.swing.JComboBox<>();
        cbbServicio.setModel(modeloServicio);
        modeloMascota = new DefaultComboBoxModel<>();
        cbbMascota = new javax.swing.JComboBox<>();
        cbbMascota.setModel(modeloMascota);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reserva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setToolTipText("");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aseo-de-mascotas.png"))); // NOI18N
        jLabel10.setMaximumSize(new java.awt.Dimension(1076, 1024));
        jLabel10.setMinimumSize(new java.awt.Dimension(1076, 1024));

        txtTotal.setEditable(false);

        jLabel6.setText("Total:");

        jLabel4.setText("Hora:");

        jLabel3.setText("FechaReserva:");

        jLabel2.setText("CodigoReserva:");

        txtCodigoReserva.setEditable(false);

        txtHora.setEditable(false);
        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Reservar cita");

        jLabel7.setText("Nombre Mascota:");

        jCalendar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salida.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GUARDAR.png"))); // NOI18N
        btnGuardar.setText("Nuevo");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtFechaReserva.setEditable(false);
        txtFechaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaReservaActionPerformed(evt);
            }
        });

        jLabel5.setText("Servicio:");

        cbbServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbServicioActionPerformed(evt);
            }
        });

        cbbMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMascotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbbServicio, javax.swing.GroupLayout.Alignment.LEADING, 0, 152, Short.MAX_VALUE)
                                        .addComponent(cbbMascota, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtHora, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txtCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGap(65, 65, 65))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbbMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditar)
                        .addComponent(btnEliminar)
                        .addComponent(btnCerrar)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        this.dispose();
        if (menuPrincipal != null) {
            menuPrincipal.setVisible(true);
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String codigoReservaStr = txtCodigoReserva.getText().trim();
        if (!codigoReservaStr.isEmpty()) {
            int codigoReserva = Integer.parseInt(codigoReservaStr);

            // Confirmar la eliminación
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar esta reserva?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                // Llamar al procedimiento almacenado para eliminar la reserva
                boolean eliminado = cSql.EliminarReserva(codigoReserva);

                if (eliminado) {
                    JOptionPane.showMessageDialog(null, "Reserva eliminada exitosamente.");
                    limpiarCampos();
                    ActivarControles(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar la reserva.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un código de reserva válido.");
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (btnEditar.getText().equals("Editar")) {
            ActivarControles(true);
            btnGuardar.setText("Guardar");
            btnEditar.setText("Cancelar");
        } else {
            btnGuardar.setText("Nuevo");
            btnEditar.setText("Editar");
            ActivarControles(false);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (btnGuardar.getText().equals("Nuevo")) {
            limpiarCampos();
            ActivarControles(true);
            btnGuardar.setText("Guardar");
            btnEditar.setText("Cancelar");
        } else {
            // Obtener los valores de los campos
            java.sql.Date fechaReserva = new java.sql.Date(jCalendar1.getDate().getTime());
            String horaStr = txtHora.getText().trim();
            String nombreMascota = cbbMascota.getSelectedItem().toString();
            String nombreServicio = cbbServicio.getSelectedItem().toString();
            double total = Double.parseDouble(txtTotal.getText());

            if (horaStr.matches("\\d{2}:\\d{2}")) {
                java.sql.Time hora = java.sql.Time.valueOf(horaStr + ":00");

                // Llamar al procedimiento almacenado para insertar la reserva
                int codigoReserva = cSql.InsertarReserva(fechaReserva, hora, nombreMascota, nombreServicio, total);

                if (codigoReserva > 0) {
                    JOptionPane.showMessageDialog(null, "Reserva guardada exitosamente. Código de Reserva: " + codigoReserva);
                    limpiarCampos();
                    ActivarControles(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar la reserva.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar una hora válida en formato hh:mm.");
            }

            btnGuardar.setText("Nuevo");
            btnEditar.setText("Editar");
            ActivarControles(false);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
        cbbMascota.setSelectedItem(null);
        cbbMascota.setSelectedIndex(-1);
        cbbServicio.setSelectedItem(null);
        cbbServicio.setSelectedIndex(-1);

        ActivarControles(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // Activar los campos de texto antes de la búsqueda
        ActivarControles(true);
        btnCerrar.setEnabled(true);
        btnEliminar.setEnabled(true);
        String codigoReservaStr = txtCodigoReserva.getText().trim();

        int codigoReserva = Integer.parseInt(codigoReservaStr);

        try {
            ResultSet rs = cSql.BuscarReserva(codigoReserva);
            if (rs.next()) {
                java.sql.Date fechaReserva = rs.getDate("FechaReserva");
                java.sql.Time hora = rs.getTime("Hora");
                String nombreMascota = rs.getString("NombreMascota");
                String nombreServicio = rs.getString("NombreServicio");
                double total = rs.getDouble("Total");

                // Asignar los valores a los campos correspondientes
                jCalendar1.setDate(fechaReserva);
                txtFechaReserva.setText(fechaReserva.toString());
                txtHora.setText(hora.toString().substring(0, 5)); // Mostrar solo "hh:mm"
                cbbMascota.setSelectedItem(nombreMascota);
                cbbServicio.setSelectedItem(nombreServicio);
                txtTotal.setText(String.valueOf(total));

                // Desactivar los campos de texto después de mostrar los datos
                ActivarControles(true);
                btnCerrar.setEnabled(true);
                btnEliminar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la reserva.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la reserva: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void txtFechaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaReservaActionPerformed

    private void cbbServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbServicioActionPerformed

        String servicioSeleccionado = cbbServicio.getSelectedItem().toString();
        try {
            ResultSet rs = cSql.ObtenerPrecioServicio(servicioSeleccionado);
            if (rs.next()) {
                double precio = rs.getDouble("Precio");
                txtTotal.setText(String.valueOf(precio));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cbbServicioActionPerformed

    private void cbbMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMascotaActionPerformed

    }//GEN-LAST:event_cbbMascotaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbbMascota;
    private javax.swing.JComboBox<String> cbbServicio;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtCodigoReserva;
    private javax.swing.JTextField txtFechaReserva;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
