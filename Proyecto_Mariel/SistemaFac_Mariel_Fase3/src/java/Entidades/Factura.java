/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author marie
 */
public class Factura {
    
    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isExisteRegistro() {
        return existeRegistro;
    }

    public void setExisteRegistro(boolean existeRegistro) {
        this.existeRegistro = existeRegistro;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    // Atributos
    private int id_factura;
    private Date fecha;
    private int id_cliente;
    private double subtotal;
    private double impuesto;
    private double descuento;
    private String estado;
    private boolean existeRegistro;
    private String nombreCliente; // No es un campo mapeado de la BD
    
    // constructor
    public Factura() {
        id_factura = 0;
        id_cliente = 0;
        subtotal = 0;
        fecha = null;
        impuesto = 0;
        descuento = 0;
        estado ="";
        existeRegistro = false;
        nombreCliente= "";
    }
    
    public Factura(int id_factura, Date fecha, int id_cliente, double subtotal,double impuesto,double descuento,String estado,String nombreCliente) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.id_cliente = id_cliente;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.descuento = descuento;
        this.estado = estado;
        this.nombreCliente = nombreCliente;
        this.existeRegistro = true;
    }
     
}
