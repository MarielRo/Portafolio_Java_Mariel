//Mariel Rojas
package Capa2_LogicaNegocio;

import Capa3_AccesoDatos.ADDetalle_Ventas;
import Capa_Entidades.Detalle_Venta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marie
 */
public class LNDetalle_Compras {
  // atributos
    private String _mensaje;

    // método de acceso get
    public String getMensaje() {
        return _mensaje;
    }

    // llamar al método de insertar cliente de la capa de acceso de datos
    public int Insertar(Detalle_Venta detalle_Venta) throws Exception {
        int id = -1;
        ADDetalle_Ventas addetalle_Ventas;
        try {
            addetalle_Ventas = new ADDetalle_Ventas();
            id = addetalle_Ventas.Insertar(detalle_Venta);
            _mensaje = addetalle_Ventas.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }
    
    public List<Detalle_Venta> ListarRegistros(String condicion) throws Exception {
        List<Detalle_Venta> resultado = new ArrayList();
        ADDetalle_Ventas addetalle_Ventas;
        try {
            addetalle_Ventas = new ADDetalle_Ventas();
            resultado = addetalle_Ventas.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public Detalle_Venta ObtenerRegistro(String condicion) throws Exception {
        Detalle_Venta resultado;
        ADDetalle_Ventas addetalle_Ventas;
        try {
            addetalle_Ventas = new ADDetalle_Ventas();
            resultado = addetalle_Ventas.ObtenerRegisto(condicion);
            if(resultado.isExiste()){
                _mensaje= "Detalle venta Recuperado exitosamente";
            }else{
                _mensaje = "Detalle venta no existe";
            }
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public int Modificar(Detalle_Venta detalle_Ventas) throws Exception {
        int resultado = -1;
        ADDetalle_Ventas addetalle_Ventas;
        try {
            addetalle_Ventas = new ADDetalle_Ventas();
            resultado = addetalle_Ventas.Modificar(detalle_Ventas);
            _mensaje = addetalle_Ventas.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public int Eliminar(Detalle_Venta detalle_Venta) throws Exception {
        int resultado = -1;
        ADDetalle_Ventas addetalle_Ventas;
        try {
            addetalle_Ventas = new ADDetalle_Ventas();
            resultado = addetalle_Ventas.Eliminar(detalle_Venta);
            _mensaje = addetalle_Ventas.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
 
}
