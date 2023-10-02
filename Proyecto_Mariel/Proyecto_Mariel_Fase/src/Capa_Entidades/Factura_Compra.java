// Mariel Rojas
package Capa_Entidades;


public class Factura_Compra {
    
    // Atributos
    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    private int id_factura_compra;
    private double total;
    private String fecha;
    private String estado;
    private String proveedor;
    private boolean existe;
    
    
    // Constructor vacio 
     public Factura_Compra() {
        id_factura_compra=0;
        total=0;
        fecha="";
        proveedor="";
        estado = "";
        existe=false;
    }
    // Constructor parametros

    public Factura_Compra(int id_factura_compra, double total, String fecha, String proveedor, String estado) {
        this.id_factura_compra = id_factura_compra;
        this.total = total;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.estado = estado;
        this.existe=true;
    }
    
    // getters y setters
     public int getId_factura_compra() {
        return id_factura_compra;
    }

    public void setId_factura_compra(int id_factura_compra) {
        this.id_factura_compra = id_factura_compra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public boolean isExiste() {
        return existe;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
