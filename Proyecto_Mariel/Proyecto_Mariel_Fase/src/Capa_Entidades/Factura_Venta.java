/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

public class Factura_Venta {
    
    // Atributos
    private int id_factura_venta;
    private int id_cliente;
    private int id_trabajador;
    private double total;
    private String fecha;
    private String metodo_pago;
    private String estado;
    private boolean existe;
    
    // constructor
    public Factura_Venta() {
        id_factura_venta = 0;
        id_cliente = 0;
        id_trabajador = 0;
        total = 0;
        fecha = "";
        metodo_pago = "";
        estado ="";
        existe = false;
    }
    
    public Factura_Venta(int id_factura_venta, int id_cliente, int id_trabajador, double total, String fecha, String metodo_pago,String estado) {
        this.id_factura_venta = id_factura_venta;
        this.id_cliente = id_cliente;
        this.id_trabajador = id_trabajador;
        this.total = total;
        this.fecha = fecha;
        this.metodo_pago = metodo_pago;
        this.estado = estado;
        this.existe = true;
    }
     
    public int getId_factura_venta() {
        return id_factura_venta;
    }

    public void setId_factura_venta(int id_factura_venta) {
        this.id_factura_venta = id_factura_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
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

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isExiste() {
        return existe;
    }
    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
}
