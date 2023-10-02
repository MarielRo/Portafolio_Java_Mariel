// Mariel Rojas
package Capa_Entidades;

/**
 *
 * @author marie
 */
public class Detalle_Venta {
   
    // Atributos
    private int id_detalle_venta;
    private int factura_venta;
    private int id_producto;
    private int cantidad;
    private double precio;
    private boolean existe;
    
    // Constructores
    public Detalle_Venta() {
        id_detalle_venta = 0;
        factura_venta = 0;
        id_producto = 0;
        cantidad = 0;
        precio = 0;
        existe = false;
    }
    public Detalle_Venta(int id_detalle_venta, int factura_venta, int id_producto, int cantidad, double precio) {
        this.id_detalle_venta = id_detalle_venta;
        this.factura_venta = factura_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.existe = true;
    }
    
    // Metodos getter y setter
    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getFactura_venta() {
        return factura_venta;
    }

    public void setFactura_venta(int factura_venta) {
        this.factura_venta = factura_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isExiste() {
        return existe;
    }
    
    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
}
