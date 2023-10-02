// Mariel Rojas

package Capa_Entidades;


public class Detalle_Compra {

    // Atributos
    private int id_detalle_compra;
    private int factura_compra;
    private int id_producto;
    private int cantidad;
    private double precio;
    private boolean existe;
    
    // Constructores
    public Detalle_Compra() {
        id_detalle_compra = 0;
        factura_compra = 0;
        id_producto = 0;
        cantidad = 0;
        precio = 0;
        existe = false;
    }
    
    public Detalle_Compra(int id_detalle_compra, int factura_compra, int id_producto, int cantidad, double precio) {
        this.id_detalle_compra = id_detalle_compra;
        this.factura_compra = factura_compra;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.existe = true;
    }
    
    // Metodos
    public int getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(int id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public int getFactura_compra() {
        return factura_compra;
    }

    public void setFactura_compra(int factura_compra) {
        this.factura_compra = factura_compra;
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
