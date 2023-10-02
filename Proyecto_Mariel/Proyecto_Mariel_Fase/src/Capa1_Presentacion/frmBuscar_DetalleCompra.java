
package Capa1_Presentacion;

import Capa2_LogicaNegocio.LNDetalle_Compras;
import Capa_Entidades.Detalle_Compra;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmBuscar_DetalleCompra extends javax.swing.JDialog {

    //Variable global
    DefaultTableModel modelo;
    
    public frmBuscar_DetalleCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setTitle("Buscar detalle factura compra");
        // cedntral modal
        this.setLocationRelativeTo(null);
        try{
            CargarDatos("");
        }catch( Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdFacturaVenta = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtIdFactura = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalle_Compra = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código");

        txtIdFacturaVenta.setText("Código Factura");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtId.setEditable(false);

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
        jScrollPane2.setViewportView(tblDetalle_Compra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdFacturaVenta)
                                .addGap(0, 190, Short.MAX_VALUE))
                            .addComponent(txtIdFactura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdFacturaVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String condicion="";
        if (!txtIdFactura.getText().equals("")) {
            try {
                int numeroBuscado = Integer.parseInt(txtIdFactura.getText());
                condicion = "ID_DETALLE_FACTURA = " + numeroBuscado;
            } catch (NumberFormatException e) {
                // Manejar una entrada no válida como un número
                System.err.println("Entrada no válida: No es un codigo válido.");
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblDetalle_CompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalle_CompraMouseClicked
        if(evt.getClickCount()==2){
            int fila = tblDetalle_Compra.rowAtPoint(evt.getPoint());
            txtId.setText(tblDetalle_Compra.getValueAt(fila, 0).toString());
            txtIdFactura.setText(tblDetalle_Compra.getValueAt(fila, 1).toString());
            this.dispose();
        }
    }//GEN-LAST:event_tblDetalle_CompraMouseClicked

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
            java.util.logging.Logger.getLogger(frmBuscar_DetalleCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscar_DetalleCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscar_DetalleCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscar_DetalleCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmBuscar_DetalleCompra dialog = new frmBuscar_DetalleCompra(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDetalle_Compra;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JLabel txtIdFacturaVenta;
    // End of variables declaration//GEN-END:variables
}
