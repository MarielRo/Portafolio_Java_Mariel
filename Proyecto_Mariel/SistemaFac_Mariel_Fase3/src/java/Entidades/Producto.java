//Mariel Rojas


package Entidades;
import java.sql.Date;

/**
 *
 * @author marie
 */
public class Producto {
    
    // Atributos
    private int id_producto;
    private String nombre;
    private double precio;
    private int cantidad_disponible;
    private String categoria;
    private boolean existe; // controlar insertar y modificar

    
    // Constructor 
     public Producto() {
        id_producto = 0;
        nombre = "";
        precio = 0;
        cantidad_disponible = 0;
        categoria = "";
        existe = false;
    }
    
    public Producto(int id_producto, String nombre, double precio, int cantidad_disponible, String categoria) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad_disponible = cantidad_disponible;
        this.categoria = categoria;
        this.existe=true;
    }
    
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isExiste() {
        return existe;
    }
    public void setExiste(boolean existe) {
        this.existe = existe;
    }
}
