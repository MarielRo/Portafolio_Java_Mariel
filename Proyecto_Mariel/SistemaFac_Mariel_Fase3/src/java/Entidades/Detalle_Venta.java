// Mariel Rojas
package Entidades;

/**
 *
 * @author marie
 */
public class Detalle_Venta {
   
    // Atributos
    private int factura_venta;
    private int id_producto;
    private int cantidad;
    private double precio;
    private String nombreProducto;
    private boolean existe;
    
    // Constructores
    public Detalle_Venta() {
        factura_venta = 0;
        id_producto = 0;
        cantidad = 0;
        precio = 0;
        nombreProducto="";
        existe = false;
    }
    public Detalle_Venta(int factura_venta, int id_producto, int cantidad, double precio,String nombreProducto) {
        this.factura_venta = factura_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombreProducto = nombreProducto;
        this.existe = true;
    }
    
    // Metodos getter y setter
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.nombreProducto = NombreProducto;
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
