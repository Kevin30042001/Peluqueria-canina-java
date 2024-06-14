
package Form;

import Clases.dbObjetos;
import Form.frmMenuPrincipal;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class frmProducto extends javax.swing.JInternalFrame {
    private frmMenuPrincipal menuPrincipal;
    ResultSet rs = null;
    dbObjetos cSql = new dbObjetos();
    boolean Nuevo = false, Editar = false;
    int IdProducto;
    String Nombre, Fecha;
    double Precio;
    int Stock;

    public frmProducto(frmMenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        initComponents();
        cargarProductos();
        
      TbProducto.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = TbProducto.getSelectedRow();
            if (selectedRow >= 0) {
                txtIdProducto.setText(TbProducto.getValueAt(selectedRow, 0).toString());
                txtNombre.setText(TbProducto.getValueAt(selectedRow, 1).toString());
                txtPrecio.setText(TbProducto.getValueAt(selectedRow, 2).toString());
                txtCantidad.setText(TbProducto.getValueAt(selectedRow, 3).toString());
                txtFecha.setText(TbProducto.getValueAt(selectedRow, 4).toString());
                ActivarControles(false); // Habilitar campos de texto
            }
        }
    }
});
    }

    private void ActivarControles(boolean v) {
        txtIdProducto.setEditable(v);
        txtNombre.setEditable(v);
        txtPrecio.setEditable(v);
        txtCantidad.setEditable(v);
        txtFecha.setEditable(v);
        btnEliminar.setEnabled(!v);
        btnBuscar.setEnabled(!v);
        btnCerrar.setEnabled(!v);
    }
    
    private void LimpiarDatos() {
        txtIdProducto.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtFecha.setText("");
    }

    private void cargarProductos() {
        DefaultTableModel modelotabla = (DefaultTableModel) TbProducto.getModel();
        modelotabla.setRowCount(0);

        try {
            dbObjetos db = new dbObjetos();
            ResultSet rs = db.Productos();

            while (rs.next()) {
                Object[] fila = new Object[modelotabla.getColumnCount()];

                for (int indice = 0; indice < fila.length; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modelotabla.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtIdProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbProducto = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Precio", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingresar Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Precio");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("ID Producto");

        jLabel12.setText("Fecha:");

        txtFecha.setEditable(false);

        txtPrecio.setEditable(false);

        txtNombre.setEditable(false);

        txtIdProducto.setEditable(false);

        txtCantidad.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdProducto)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(68, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCantidad)
                                        .addContainerGap())
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPrecio)
                                        .addGap(13, 13, 13))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre)))
                        .addGap(6, 6, 6))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, 340, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        TbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Precio", "Stock", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TbProducto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 42, 470, 440));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("PRODUCTOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 0, 134, -1));

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salida.png"))); // NOI18N
        btnCerrar.setText("SALIR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 124, 40));

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, 115, 40));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 140, 40));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NUEVO.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, -1, -1));

        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnExcel.setText("Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 520, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
    
        this.dispose();
        // Hacer frmMenuPrincipal visible
        if (menuPrincipal != null) {
            menuPrincipal.setVisible(true);
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      try {
            if (txtIdProducto.isEditable()) {
             rs = cSql.BuscarProducto(txtIdProducto.getText(), txtNombre.getText(), txtPrecio.getText(), txtCantidad.getText());
                if (rs.next()) {
                    txtIdProducto.setText(rs.getString("IdProducto"));
                    txtNombre.setText(rs.getString("Nombre"));
                    txtPrecio.setText(rs.getString("Precio"));
                    txtCantidad.setText(rs.getString("Stock"));
                    txtFecha.setText(rs.getString("Fecha"));
                }
               ActivarControles(false);
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(true);
            } else {
                ActivarControles(true);
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnBuscar.setEnabled(true);
                btnCerrar.setEnabled(true);
                txtIdProducto.requestFocus();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
      try {
            if (btnNuevo.getText().equals("Nuevo")) {
                LimpiarDatos();
                ActivarControles(true);
                txtNombre.requestFocus();
                Nuevo = true;
                Editar = false;
                btnNuevo.setText("Guardar");
                btnEditar.setText("Cancelar");
            } else {
                String confirmMessage = Nuevo ? "¿Estás seguro de agregar el producto?" : "¿Estás seguro de editar el producto?";
                int option = JOptionPane.showOptionDialog(null, confirmMessage, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "Sí");
                if (option == JOptionPane.YES_OPTION) {
                    IdProducto = Nuevo ? 0 : Integer.parseInt(txtIdProducto.getText());
                    Nombre = txtNombre.getText();
                    Precio = Double.parseDouble(txtPrecio.getText());
                    Stock = Integer.parseInt(txtCantidad.getText());
                    Fecha = txtFecha.getText();

                    // Validar precio y stock
                    if (Precio < 0) {
                        JOptionPane.showMessageDialog(null, "El precio no puede ser negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Salir del método si el precio es negativo
                    }
                    if (Stock < 0) {
                        JOptionPane.showMessageDialog(null, "El stock no puede ser negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Salir del método si el stock es negativo
                    }

                    int resp = Nuevo ? cSql.AgregarProducto(Nombre, Precio, Stock) : cSql.ModificarProducto(IdProducto, Nombre, Precio, Stock, Fecha);
                    if (resp > 0) {
                        JOptionPane.showMessageDialog(null, Nuevo ? "El producto se creó exitosamente" : "El producto se modificó exitosamente");
                        cargarProductos();
                    } else {
                        JOptionPane.showMessageDialog(null, Nuevo ? "No se pudo crear el producto" : "No se pudo modificar el producto");
                    }
                }
                btnNuevo.setText("Nuevo");
                btnEditar.setText("Editar");
                ActivarControles(false);
                Nuevo = false;
                Editar = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
   try {
            if (btnEditar.getText().equals("Editar")) {
                ActivarControles(true);
                txtNombre.requestFocus();
                Nuevo = false;
                Editar = true;
                btnNuevo.setText("Guardar");
                btnEditar.setText("Cancelar");

                // Asignar los valores actuales del producto seleccionado a los campos
                int idProducto = Integer.parseInt(txtIdProducto.getText());
                ResultSet rs = cSql.BuscarProducto(String.valueOf(idProducto), "", "", "");
                if (rs.next()) {
                    txtNombre.setText(rs.getString("Nombre"));
                    txtPrecio.setText(String.valueOf(rs.getDouble("Precio")));
                    txtCantidad.setText(String.valueOf(rs.getInt("Stock")));
                    // Asignar el valor de la fecha del producto al campo correspondiente
                }
            } else {
                btnNuevo.setText("Nuevo");
                btnEditar.setText("Editar");
                ActivarControles(false);
                Nuevo = false;
                Editar = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       
      
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         try {
            if (!txtIdProducto.getText().isEmpty()) {
                int option = JOptionPane.showOptionDialog(null, "¿Estás seguro de eliminar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "No");
                if (option == JOptionPane.YES_OPTION) {
                    IdProducto = Integer.parseInt(txtIdProducto.getText());
                    boolean eliminado = cSql.EliminarProducto(IdProducto);
                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "El producto se eliminó exitosamente");
                        cargarProductos();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún producto para eliminar");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
      
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtIdProducto.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtFecha.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int opcion = fileChooser.showSaveDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String nombreArchivo = file.getAbsolutePath();
            ExcelUtils.exportarTablaAExcel(TbProducto, nombreArchivo);
        }
    }//GEN-LAST:event_btnExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
