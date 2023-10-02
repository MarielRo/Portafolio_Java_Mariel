/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

package Capa1_Presentacion;

import Capa2_LogicaNegocio.LNDetalle_Ventas;
import Capa_Entidades.Detalle_Venta;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marie
 */
public class frmDetalle_Ventas extends javax.swing.JInternalFrame {
//Variable global
    DefaultTableModel modelo;
    
    /** Creates new form frmDetalle_Ventas */
    public frmDetalle_Ventas() {
        initComponents();
    }
    private Detalle_Venta GenerarEntidad() throws ParseException {
        Detalle_Venta detalle_venta = new Detalle_Venta();

        if (!txtId.getText().equals("")) {
            detalle_venta.setExiste(true);
           detalle_venta.setId_detalle_venta(Integer.parseInt(txtId.getText()));
        }
        detalle_venta.setFactura_venta(Integer.parseInt(txtIdFactura_venta.getText()));
        detalle_venta.setId_producto(Integer.parseInt(txtIdProducto.getText()));
        detalle_venta.setCantidad(Integer.parseInt(txtCantidad.getText()));
        detalle_venta.setPrecio(Double.parseDouble(txtPrecio.getText()));
        return detalle_venta;
    }
    
    // prepara la tabla para que no se pueda modificar y agrega los encabezados de columna
    private void LimpiarTabla(){
        modelo = new DefaultTableModel(){
            @Override 
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblDetalle_Venta.setModel(modelo);
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
            LNDetalle_Ventas  logica = new LNDetalle_Ventas();
            List<Capa_Entidades.Detalle_Venta> lista;
            LimpiarTabla();
            Object[] fila = new Object[5];
            lista = logica.ListarRegistros(condicion);
            for (Detalle_Venta detalle_venta:lista){
            fila[0] = detalle_venta.getId_detalle_venta();
            fila[1] = detalle_venta.getFactura_venta();
            fila[2] = detalle_venta.getId_producto();
            fila[3] = detalle_venta.getCantidad();
            fila[4] = detalle_venta.getPrecio();
            modelo.addRow(fila);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    private void Limpiar(){
        txtId.setText("");
        txtIdFactura_venta.setText("");
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
        btnSalir = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        lblCantidadDisponible = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtIdFactura_venta = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle_Venta = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();

        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblCodigo.setText("Código");

        lblCantidadDisponible.setText("Precio");

        jLabel1.setText("Código Factura Venta");

        txtId.setEditable(false);

        jLabel2.setText("Código producto");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lblNombre.setText("Cantidad");

        tblDetalle_Venta.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDetalle_Venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalle_VentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalle_Venta);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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
                                .addComponent(txtIdFactura_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(17, Short.MAX_VALUE))
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
                    .addComponent(txtIdFactura_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidadDisponible)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
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
        LNDetalle_Ventas logica = new LNDetalle_Ventas();
        Detalle_Venta detalle_venta = null;
        try {
           detalle_venta = GenerarEntidad();
        } catch (ParseException ex) {
            Logger.getLogger(Detalle_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(detalle_venta.isExiste()){
                logica.Modificar(detalle_venta);
            }
            else{
                logica.Insertar(detalle_venta);
            }
            JOptionPane.showMessageDialog(this,logica.getMensaje());
            Limpiar();
            CargarDatos("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        frmBuscar_DetalleVenta frmBuscar = new frmBuscar_DetalleVenta(null, true);
        frmBuscar.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblDetalle_VentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalle_VentaMouseClicked
        try
        {
            LNDetalle_Ventas logica = new LNDetalle_Ventas();
            Detalle_Venta detalle_venta;
            String condicion;
            if (evt.getClickCount() == 2) {
                int fila = tblDetalle_Venta.rowAtPoint(evt.getPoint());
                txtId.setText(tblDetalle_Venta.getValueAt(fila, 0).toString());
                condicion = String.format("id_factura_venta=%s", txtId.getText());
                detalle_venta = logica.ObtenerRegistro(condicion);

                txtId.setText(String.valueOf(detalle_venta.getId_detalle_venta()));
                txtIdFactura_venta.setText(String.valueOf(detalle_venta.getFactura_venta()));
                txtIdProducto.setText(String.valueOf(detalle_venta.getId_producto()));
                txtCantidad.setText(String.valueOf(detalle_venta.getCantidad()));
                txtPrecio.setText(String.valueOf(detalle_venta.getPrecio()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());}
    }//GEN-LAST:event_tblDetalle_VentaMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        LNDetalle_Ventas logica = new LNDetalle_Ventas();
        Detalle_Venta  detalle_venta;
        try {
            detalle_venta= GenerarEntidad();
            if(detalle_venta.isExiste()){
                if(logica.Eliminar(detalle_venta)>0) {
                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                    Limpiar();
                    CargarDatos("");
                }else{
                    JOptionPane.showMessageDialog(this, "No fue posible eliminar el detalle ventas");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Debe seleccionar el detalle_ventas que desea eliminar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


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
    private javax.swing.JTable tblDetalle_Venta;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdFactura_venta;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

}
