//Mariel Rojas Sánchez
package Capa2_LogicaNegocio;

import Capa3_AccesoDatos.ADTrabajador;
import Capa_Entidades.Trabajador;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marie
 */
public class LNTrabajador {
    //Atributos
    private String _mensaje;
    
    //metodo acceso GET
    public String getMensaje(){
        return _mensaje;
    }
    
    // Llamar al metodo de insertar cliente de la capa Acceso a datos
    public int Insertar(Trabajador trabajador) throws Exception{
        int id = -1;
        ADTrabajador adtrabajador;
        try {
            adtrabajador = new ADTrabajador();
            id = adtrabajador.Insertar(trabajador);
            _mensaje = adtrabajador.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }
    
    //llamar metodo que devuelve una lista dee clientes en un resulset
    public ResultSet ListarRegistros(String condicion, String orden) throws Exception{
        ResultSet resultado;
        ADTrabajador adtrabajador;
        try {
            adtrabajador = new ADTrabajador();
            resultado = adtrabajador.ListarRegistros(condicion,orden);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public List<Capa_Entidades.Trabajador> ListarRegistros(String condicion) throws Exception{
        List<Capa_Entidades.Trabajador> resultado= new ArrayList();
        ADTrabajador adtrabajador;
        try {
            adtrabajador = new ADTrabajador();
            resultado = adtrabajador.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    // llamar el metodo obtener registro para obtener los datos del cliente
    public Trabajador ObtenerRegisto(String condicion) throws Exception{
        Trabajador resultado;
        ADTrabajador adtrabajador;
        try {
            adtrabajador = new ADTrabajador();
            
            resultado = adtrabajador.ObtenerRegisto(condicion);
            if(resultado.isExiste()){
                _mensaje= "Trabajador Recuperado exitosamente";
            }else{
                _mensaje = "El trabajador no existe";
            }
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int Modificar(Trabajador trabajador) throws Exception{
        int resultado = -1;
        ADTrabajador adtrabajador;
        try {
            adtrabajador = new ADTrabajador();
            
            resultado = adtrabajador.Modificar(trabajador);
            _mensaje= adtrabajador.getMensaje();     
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int Eliminar(Trabajador trabajador) throws Exception{
        int resultado = -1;
        ADTrabajador adtrabajador;
        try {
            adtrabajador = new ADTrabajador();
            resultado = adtrabajador.Eliminar(trabajador);
            _mensaje= adtrabajador.getMensaje();     
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
