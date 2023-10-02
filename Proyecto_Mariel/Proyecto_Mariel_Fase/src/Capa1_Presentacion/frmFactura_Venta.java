/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Capa1_Presentacion;

import Capa2_LogicaNegocio.LNFactura_Venta;
import Capa_Entidades.Factura_Venta;
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
public class frmFactura_Venta extends javax.swing.JInternalFrame {

    //Variable global
    DefaultTableModel modelo;
    
    
    public frmFactura_Venta() {
        initComponents();
        try {
            CargarDatos("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error:" + e.getMessage());
        } 
    }

    
   private Factura_Venta GenerarEntidad() throws ParseException {
        Factura_Venta factura_venta = new Factura_Venta();

        if (!txtId.getText().equals("")) {
            factura_venta.setExiste(true);
            factura_venta.setId_factura_venta(Integer.parseInt(txtId.getText()));
        }
        factura_venta.setId_cliente(Integer.parseInt(txtIdCliente.getText()));
        factura_venta.setId_trabajador(Integer.parseInt(txtIdTrabajador.getText()));
        double total = Double.parseDouble(txtTotal.getText());
        factura_venta.setTotal((int)total);
        factura_venta.setFecha(txtFecha.getText());
        factura_venta.setEstado(txtEstado.getText());
        factura_venta.setMetodo_pago(txtMetodo_pago.getText());

        return factura_venta;
    }
    
    // prepara la tabla para que no se pueda modificar y agrega los encabezados de columna
    private void LimpiarTabla(){
        modelo = new DefaultTableModel(){
            @Override 
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblFactura_Venta.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Cód. Cliente");
        modelo.addColumn("Cód. Trabajador");
        modelo.addColumn("Total");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
        modelo.addColumn("Met.Pago"); 
    }
    
    // Metodo para mostra losreegiatros del cliente en la tabla 
    // llamma a limpiar tabla y a la logica
    private void CargarDatos(String condicion)throws Exception{
        try {
            LNFactura_Venta  logica = new LNFactura_Venta ();
            List<Capa_Entidades.Factura_Venta> lista;
            LimpiarTabla();
            Object[] fila = new Object[7];
            lista = logica.ListarRegistros(condicion);
            for (Factura_Venta factura_compra:lista){
            fila[0] = factura_compra.getId_factura_venta();
            fila[1] = factura_compra.getId_cliente();
            fila[2] = factura_compra.getId_trabajador();
            fila[3] = factura_compra.getTotal();
            fila[4] = factura_compra.getFecha();
            fila[5] = factura_compra.getEstado();
            fila[6] = factura_compra.getMetodo_pago();
            modelo.addRow(fila);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    private void Limpiar(){
        txtId.setText("");
        txtIdCliente.setText("");
        txtIdTrabajador.setText("");
        txtTotal.setText("");
        txtFecha.setText("");
        txtEstado.setText("");
        txtMetodo_pago.setText("");
        
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

        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura_Venta = new javax.swing.JTable();
        txtEstado = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        lblCantidadDisponible = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtMetodo_pago = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lblPrecio = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdTrabajador = new javax.swing.JTextField();

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblFactura_Venta.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFactura_Venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFactura_VentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFactura_Venta);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblCodigo.setText("Código");

        lblCantidadDisponible.setText("Metodo Pago");

        txtId.setEditable(false);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblCategoria.setText("Fecha");

        lblNombre.setText("Total");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblPrecio.setText("Estado");

        jLabel1.setText("Código Cliente");

        jLabel2.setText("Código Trabajador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addComponent(lblPrecio))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtIdTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCantidadDisponible)
                                        .addComponent(lblCategoria))
                                    .addGap(34, 34, 34)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtMetodo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(42, 42, 42)
                        .addComponent(btnLimpiar)
                        .addGap(42, 42, 42)
                        .addComponent(btnGuardar)
                        .addGap(47, 47, 47)
                        .addComponent(btnEliminar)
                        .addGap(39, 39, 39)
                        .addComponent(btnSalir)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidadDisponible)
                    .addComponent(txtMetodo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir)
                    .addComponent(btnEliminar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblFactura_VentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFactura_VentaMouseClicked
        try
        {
            LNFactura_Venta logica = new LNFactura_Venta();
            Factura_Venta factura_venta;
            String condicion;
            if (evt.getClickCount() == 2) {
                int fila = tblFactura_Venta.rowAtPoint(evt.getPoint());
                txtId.setText(tblFactura_Venta.getValueAt(fila, 0).toString());
                condicion = String.format("id_factura_venta=%s", txtId.getText());
                factura_venta = logica.ObtenerRegisto(condicion);

                txtId.setText(String.valueOf(factura_venta.getId_factura_venta()));
                txtIdCliente.setText(String.valueOf(factura_venta.getId_cliente()));
                txtIdTrabajador.setText(String.valueOf(factura_venta.getId_trabajador()));
                txtTotal.setText(String.valueOf(factura_venta.getTotal()));
                txtFecha.setText(factura_venta.getFecha());
                txtEstado.setText(String.valueOf(factura_venta.getEstado()));
                txtMetodo_pago.setText(factura_venta.getMetodo_pago());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());}
    }//GEN-LAST:event_tblFactura_VentaMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        frmBuscar_FacturaVenta frmBuscar = new frmBuscar_FacturaVenta(null, true);
        frmBuscar.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        LNFactura_Venta logica = new LNFactura_Venta();
        Factura_Venta  factura_venta;
        try {
            factura_venta= GenerarEntidad();
            if(factura_venta.isExiste()){
                if(logica.Eliminar(factura_venta)>0) {
                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                    Limpiar();
                    CargarDatos("");
                }else{
                    JOptionPane.showMessageDialog(this, "No fue posible eliminar la factura venta");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Debe seleccionar la factura venta que desea eliminar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        LNFactura_Venta  logica = new LNFactura_Venta();
        Factura_Venta  factura_venta = null;
        try {
            factura_venta = GenerarEntidad();
        } catch (ParseException ex) {
            Logger.getLogger(Factura_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(factura_venta.isExiste()){
                logica.Modificar(factura_venta);
            }
            else{
                logica.Insertar(factura_venta);
            }
            JOptionPane.showMessageDialog(this,logica.getMensaje());
            Limpiar();
            CargarDatos("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


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
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JTable tblFactura_Venta;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdTrabajador;
    private javax.swing.JTextField txtMetodo_pago;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
