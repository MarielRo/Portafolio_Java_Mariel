
package Capa1_Presentacion;

import Capa2_LogicaNegocio.LNDetalle_Compras;
import Capa_Entidades.Detalle_Compra;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmDetalle_Compras extends javax.swing.JInternalFrame {

    //Variable global
    DefaultTableModel modelo;
    public frmDetalle_Compras() {
        initComponents();
        
        
        try {
            CargarDatos("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error:" + e.getMessage());
        } 
        
    }
    private Detalle_Compra GenerarEntidad() throws ParseException {
        Detalle_Compra detalle_Compra = new Detalle_Compra();

        if (!txtId.getText().equals("")) {
            detalle_Compra.setExiste(true);
           detalle_Compra.setId_detalle_compra(Integer.parseInt(txtId.getText()));
        }
        detalle_Compra.setFactura_compra(Integer.parseInt(txtIdFactura_compra.getText()));
        detalle_Compra.setId_producto(Integer.parseInt(txtIdProducto.getText()));
        detalle_Compra.setCantidad(Integer.parseInt(txtCantidad.getText()));
        detalle_Compra.setPrecio(Double.parseDouble(txtPrecio.getText()));
        return detalle_Compra;
    }
    
    // prepara la tabla para que no se pueda modificar y agrega los encabezados de columna
    private void LimpiarTabla(){
        modelo = new DefaultTableModel(){
            @Override 
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblDetalle_Compra.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Cód. Factura");
        modelo.addColumn("Cód. Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
    }
    
    // Metodo para mostra losreegiatros del cliente en la tabla 
    // llamma a limpiar tabla y a la logica
    private void CargarDatos(String condicion)throws Exception{
        try {
            LNDetalle_Compras  logica = new LNDetalle_Compras();
            List<Capa_Entidades.Detalle_Compra> lista;
            LimpiarTabla();
            Object[] fila = new Object[5];
            lista = logica.ListarRegistros(condicion);
            for (Detalle_Compra detalle_Compra:lista){
            fila[0] = detalle_Compra.getId_detalle_compra();
            fila[1] = detalle_Compra.getFactura_compra();
            fila[2] = detalle_Compra.getId_producto();
            fila[3] = detalle_Compra.getCantidad();
            fila[4] = detalle_Compra.getPrecio();
            modelo.addRow(fila);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    private void Limpiar(){
        txtId.setText("");
        txtIdFactura_compra.setText("");
        txtIdProducto.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        
    }
    public int ObtenerId(){
        int codigo = -1;
        if (!txtId.getText().equals("")) {
            codigo=Integer.parseInt(txtId.getText());
        }
        return  codigo;
    }  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle_Compra = new javax.swing.JTable();
        lblCantidadDisponible = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtIdFactura_compra = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();

        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblNombre.setText("Cantidad");

        lblCodigo.setText("Código");

        tblDetalle_Compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetalle_Compra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalle_CompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalle_Compra);

        lblCantidadDisponible.setText("Precio");

        jLabel1.setText("Código Factura Venta");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtId.setEditable(false);

        jLabel2.setText("Código producto");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addComponent(lblCantidadDisponible)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdFactura_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(42, 42, 42)
                .addComponent(btnLimpiar)
                .addGap(42, 42, 42)
                .addComponent(btnGuardar)
                .addGap(47, 47, 47)
                .addComponent(btnEliminar)
                .addGap(39, 39, 39)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdFactura_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidadDisponible)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir)
                    .addComponent(btnEliminar))
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        LNDetalle_Compras logica = new LNDetalle_Compras();
        Detalle_Compra detalle_compras = null;
        try {
            detalle_compras = GenerarEntidad();
        } catch (ParseException ex) {
            Logger.getLogger(Detalle_Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(detalle_compras.isExiste()){
                logica.Modificar(detalle_compras);
            }
            else{
                logica.Insertar(detalle_compras);
            }
            JOptionPane.showMessageDialog(this,logica.getMensaje());
            Limpiar();
            CargarDatos("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblDetalle_CompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalle_CompraMouseClicked
        try
        {
            LNDetalle_Compras logica = new LNDetalle_Compras();
            Detalle_Compra detalle_compra;
            String condicion;
            if (evt.getClickCount() == 2) {
                int fila = tblDetalle_Compra.rowAtPoint(evt.getPoint());
                txtId.setText(tblDetalle_Compra.getValueAt(fila, 0).toString());
                condicion = String.format("id_detalle_compra=%s", txtId.getText());
                detalle_compra = logica.ObtenerRegistro(condicion);

                txtId.setText(String.valueOf(detalle_compra.getId_detalle_compra()));
                txtIdFactura_compra.setText(String.valueOf(detalle_compra.getFactura_compra()));
                txtIdProducto.setText(String.valueOf(detalle_compra.getId_producto()));
                txtCantidad.setText(String.valueOf(detalle_compra.getCantidad()));
                txtPrecio.setText(String.valueOf(detalle_compra.getPrecio()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());}
    }//GEN-LAST:event_tblDetalle_CompraMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        LNDetalle_Compras logica = new LNDetalle_Compras();
        Detalle_Compra  detalle_Compras;
        try {
            detalle_Compras= GenerarEntidad();
            if(detalle_Compras.isExiste()){
                if(logica.Eliminar(detalle_Compras)>0) {
                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                    Limpiar();
                    CargarDatos("");
                }else{
                    JOptionPane.showMessageDialog(this, "No fue posible eliminar el detalle Compras");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Debe seleccionar el detalle Compras que desea eliminar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        frmBuscar_DetalleVenta frmBuscar = new frmBuscar_DetalleVenta(null, true);
        frmBuscar.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidadDisponible;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblDetalle_Compra;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdFactura_compra;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
