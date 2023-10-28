/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;
import AccesoDatos.DA_Trabajador;
import Entidades.Trabajador;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BL_Trabajador {
    
    // ATRIBUTOS __________________________
    private String _mensaje;

    // PROPIEDADES ________________________
    public String getMensaje() {
        return _mensaje;
    }

    // CONSTRUCTOR
    public BL_Trabajador() {
        _mensaje = "";
    }

    /*
        MÉTODO 1: Insertar un registro en la base de datos
        Recibe: un objeto tipo CLIENTE
        Retorna: un entero (la cantidad de registros afectacos)
     */
    public int Insertar(Trabajador cliente) throws Exception {
        int resultado = 0;
        // Llamar a la capa de acceso a datos:
        DA_Trabajador accesoDatos = new DA_Trabajador();
        
        try {
            resultado = accesoDatos.Insertar(cliente);
            _mensaje = accesoDatos.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /*
        MÉTODO 2: Modificar _________________________________________
        Recibe: un objeto tipo CLIENTE
        Retorna: un entero (la cantidad de registros (filas) afectados)
     */
    public int Modificar(Trabajador trabajador) throws Exception {
        int resultado = 0;
        DA_Trabajador accesoDatos  = new DA_Trabajador();
        
        try {
            resultado = accesoDatos.Modificar(trabajador);
            _mensaje = accesoDatos.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /*
        MÉTODO 3: Eliminar _________________________________________
        Recibe: un objeto tipo CLIENTE
        Retorna: un entero (la cantidad de registros (filas) afectados)
     */
    public int Eliminar(Trabajador trabajador) throws Exception {
        int resultado = 0;
        DA_Trabajador accesoDatos  = new DA_Trabajador();
        
        try {
            resultado = accesoDatos.Eliminar(trabajador);
            _mensaje = accesoDatos.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public ResultSet ListarRegistros(String condicion, String orden) throws Exception{
    ResultSet resultado;
    DA_Trabajador accesoDatos  = new DA_Trabajador();
    
        try {
            resultado = accesoDatos.ListarRegistros(condicion, orden);
        } 
        catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public List<Trabajador> ListarRegistros(String condicion) throws Exception{
        List<Trabajador> resultado = new ArrayList();
        DA_Trabajador accesoDatos  = new DA_Trabajador();
        
        try {
            resultado = accesoDatos.ListarRegistros(condicion);
        } 
        catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    
    public Trabajador ObtenerRegistro(String condicion) throws Exception{
        Trabajador trabajador;
        DA_Trabajador accesoDatos  = new DA_Trabajador();;
        
        try {
            trabajador = accesoDatos.ObtenerRegistro(condicion);
            
            if(trabajador.isExiste()){
                _mensaje = "Trabajador recuperado satisfactoriamente";
            }
            else {
                _mensaje = "Trabajador no existe";
            }
            
        } catch (Exception e) {
            throw e;
        }
        
        return trabajador;
    }
}
