// Mariel Rojas Sánchez
package Capa2_LogicaNegocio;

import Capa3_AccesoDatos.ADProducto;
import Capa_Entidades.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marie
 */
public class LNProducto {
    //Atributos
    private String _mensaje;
    
    //metodo acceso GET
    public String getMensaje(){
        return _mensaje;
    }
    
    // Llamar al metodo de insertar cliente de la capa Acceso a datos
    public int Insertar(Producto producto) throws Exception{
        int id = -1;
        ADProducto adproducto;
        try {
            adproducto = new ADProducto();
            id = adproducto.Insertar(producto);
            _mensaje = adproducto.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }
    
    //llamar metodo que devuelve una lista dee clientes en un resulset
    public ResultSet ListarRegistros(String condicion, String orden) throws Exception{
        ResultSet resultado;
        ADProducto adproducto;
        try {
            adproducto= new ADProducto();
            resultado = adproducto.ListarRegistros(condicion,orden);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public List<Capa_Entidades.Producto> ListarRegistros(String condicion) throws Exception{
        List<Capa_Entidades.Producto> resultado= new ArrayList();
        ADProducto adproducto;
        try {
            adproducto = new ADProducto();
            resultado = adproducto.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    // llamar el metodo obtener registro para obtener los datos del Producto
    public Producto ObtenerRegisto(String condicion) throws Exception{
        Producto resultado;
        ADProducto adproducto;
        try {
            adproducto = new ADProducto();
            
            resultado = adproducto.ObtenerRegisto(condicion);
            if(resultado.isExiste()){
                _mensaje= "Producto Recuperado exitosamente";
            }else{
                _mensaje = "El Producto no existe";
            }
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int Modificar(Producto producto) throws Exception{
        int resultado = -1;
        ADProducto adproducto;
        try {
            adproducto = new ADProducto();
            
            resultado = adproducto.Modificar(producto);
            _mensaje= adproducto.getMensaje();     
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int Eliminar(Producto producto) throws Exception{
        int resultado = -1;
        ADProducto adproducto;
        try {
            adproducto = new ADProducto();
            resultado = adproducto.Eliminar(producto);
            _mensaje= adproducto.getMensaje();     
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
