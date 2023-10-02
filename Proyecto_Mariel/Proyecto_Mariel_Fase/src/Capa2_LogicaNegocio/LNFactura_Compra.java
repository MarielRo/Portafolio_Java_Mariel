// Mariel Rojas
package Capa2_LogicaNegocio;

import Capa3_AccesoDatos.ADFactura_Compra;
import Capa_Entidades.Factura_Compra;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marie
 */
public class LNFactura_Compra {
    //Atributos
    private String _mensaje;
    
    //metodo acceso GET
    public String getMensaje(){
        return _mensaje;
    }
    
    // Llamar al metodo de insertar cliente de la capa Acceso a datos
    public int Insertar(Factura_Compra factura_compra) throws Exception{
        int id = -1;
        ADFactura_Compra adfactura_compra;
        try {
            adfactura_compra = new ADFactura_Compra();
            id = adfactura_compra.Insertar(factura_compra);
            _mensaje = adfactura_compra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }
    
    //llamar metodo que devuelve una lista dee clientes en un resulset
    public ResultSet ListarRegistros(String condicion, String orden) throws Exception{
        ResultSet resultado;
        ADFactura_Compra adfactura_compra;
        try {
            adfactura_compra = new ADFactura_Compra();
            resultado = adfactura_compra.ListarRegistros(condicion,orden);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public List<Capa_Entidades.Factura_Compra> ListarRegistros(String condicion) throws Exception{
        List<Capa_Entidades.Factura_Compra> resultado= new ArrayList();
        ADFactura_Compra adfactura_compra;
        try {
            adfactura_compra = new ADFactura_Compra();
            resultado = adfactura_compra.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    // llamar el metodo obtener registro para obtener los datos del Producto
    public Factura_Compra ObtenerRegisto(String condicion) throws Exception{
        Factura_Compra resultado;
        ADFactura_Compra adfactura_compra;
        try {
            adfactura_compra = new ADFactura_Compra();
            
            resultado = adfactura_compra.ObtenerRegisto(condicion);
            if(resultado.isExiste()){
                _mensaje= "Factura_compra Recuperado exitosamente";
            }else{
                _mensaje = "Factura_compra no existe";
            }
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int Modificar(Factura_Compra factura_compra) throws Exception{
        int resultado = -1;
        ADFactura_Compra adfactura_compra;
        try {
            adfactura_compra = new ADFactura_Compra();
            
            resultado = adfactura_compra.Modificar(factura_compra);
            _mensaje= adfactura_compra.getMensaje();     
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int Eliminar(Factura_Compra factura_compra) throws Exception{
        int resultado = -1;
        ADFactura_Compra adfactura_compra;
        try {
            adfactura_compra = new ADFactura_Compra();
            resultado = adfactura_compra.Eliminar(factura_compra);
            _mensaje= adfactura_compra.getMensaje();     
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
