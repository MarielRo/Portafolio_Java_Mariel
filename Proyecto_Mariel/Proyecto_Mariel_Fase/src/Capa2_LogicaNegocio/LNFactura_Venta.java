// Mariel Rojas
package Capa2_LogicaNegocio;

import Capa3_AccesoDatos.ADFactura_Venta;
import Capa_Entidades.Factura_Venta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marie
 */
public class LNFactura_Venta {
    //Atributos
    private String _mensaje;
    
    //metodo acceso GET
    public String getMensaje(){
        return _mensaje;
    }
    
    // Llamar al metodo de insertar cliente de la capa Acceso a datos
    public int Insertar(Factura_Venta factura_venta) throws Exception{
        int id = -1;
        ADFactura_Venta adfactura_venta;
        try {
            adfactura_venta = new ADFactura_Venta();
            id = adfactura_venta.Insertar(factura_venta);
            _mensaje = adfactura_venta.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }
    
    //llamar metodo que devuelve una lista dee clientes en un resulset
    public ResultSet ListarRegistros(String condicion, String orden) throws Exception{
        ResultSet resultado;
        ADFactura_Venta adfactura_venta;
        try {
            adfactura_venta = new ADFactura_Venta();
            resultado = adfactura_venta.ListarRegistros(condicion,orden);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public List<Capa_Entidades.Factura_Venta> ListarRegistros(String condicion) throws Exception{
        List<Capa_Entidades.Factura_Venta> resultado= new ArrayList();
        ADFactura_Venta adfactura_venta;
        try {
            adfactura_venta = new ADFactura_Venta();
            resultado = adfactura_venta.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    // llamar el metodo obtener registro para obtener los datos del Producto
    public Factura_Venta ObtenerRegisto(String condicion) throws Exception{
        Factura_Venta resultado;
        ADFactura_Venta adfactura_venta;
        try {
            adfactura_venta = new ADFactura_Venta();
            
            resultado = adfactura_venta.ObtenerRegisto(condicion);
            if(resultado.isExiste()){
                _mensaje= "Factura venta Recuperado exitosamente";
            }else{
                _mensaje = "Factura venta no existe";
            }
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int Modificar(Factura_Venta factura_venta) throws Exception{
        int resultado = -1;
        ADFactura_Venta adfactura_venta;
        try {
            adfactura_venta = new ADFactura_Venta();
            
            resultado = adfactura_venta.Modificar(factura_venta);
            _mensaje= adfactura_venta.getMensaje();     
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int Eliminar(Factura_Venta factura_venta) throws Exception{
        int resultado = -1;
        ADFactura_Venta adfactura_venta;
        try {
            adfactura_venta = new ADFactura_Venta();
            resultado = adfactura_venta.Eliminar(factura_venta);
            _mensaje= adfactura_venta.getMensaje();     
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
