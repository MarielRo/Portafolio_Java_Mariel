/*
 *Mariel Rojas
 *21/09/2023
 */
package Capa2_LogicaNegocio;
import Capa3_AccesoDatos.ADCliente;
import Capa_Entidades.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LNCliente {
    //Atributos
    private String _mensaje;
    
    //metodo acceso GET
    public String getMensaje(){
        return _mensaje;
    }
    
    // Llamar al metodo de insertar cliente de la capa Acceso a datos
    public int Insertar(Cliente cliente) throws Exception{
        int id = -1;
        ADCliente adcliente;
        try {
            adcliente = new ADCliente();
            id = adcliente.Insertar(cliente);
            _mensaje = adcliente.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }
    
    //llamar metodo que devuelve una lista dee clientes en un resulset
    public ResultSet ListarRegistros(String condicion, String orden) throws Exception{
        ResultSet resultado;
        ADCliente adcliente;
        try {
            adcliente = new ADCliente();
            resultado = adcliente.ListarRegistros(condicion,orden);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public List<Capa_Entidades.Cliente> ListarRegistros(String condicion) throws Exception{
        List<Capa_Entidades.Cliente> resultado= new ArrayList();
        ADCliente adcliente;
        try {
            adcliente = new ADCliente();
            resultado = adcliente.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    // llamar el metodo obtener registro para obtener los datos del cliente
    public Cliente ObtenerRegisto(String condicion) throws Exception{
        Cliente resultado;
        ADCliente adcliente;
        try {
            adcliente = new ADCliente();
            
            resultado = adcliente.ObtenerRegisto(condicion);
            if(resultado.isExiste()){
                _mensaje= "Cliente Recuperado exitosamente";
            }else{
                _mensaje = "El cliente no existe";
            }
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int Modificar(Cliente cliente) throws Exception{
        int resultado = -1;
        ADCliente adcliente;
        try {
            adcliente = new ADCliente();
            
            resultado = adcliente.Modificar(cliente);
            _mensaje= adcliente.getMensaje();     
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int Eliminar(Cliente cliente) throws Exception{
        int resultado = -1;
        ADCliente adcliente;
        try {
            adcliente = new ADCliente();
            resultado = adcliente.Eliminar(cliente);
            _mensaje= adcliente.getMensaje();     
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
