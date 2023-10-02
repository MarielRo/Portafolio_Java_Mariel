//Mariel Rojas
package Capa2_LogicaNegocio;

import Capa3_AccesoDatos.ADDetalle_Compras;
import Capa_Entidades.Detalle_Compra;
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
    public int Insertar(Detalle_Compra detalle_compra) throws Exception {
        int id = -1;
        ADDetalle_Compras addetalle_compra;
        try {
            addetalle_compra = new ADDetalle_Compras();
            id = addetalle_compra.Insertar(detalle_compra);
            _mensaje = addetalle_compra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }
    
    public List<Detalle_Compra> ListarRegistros(String condicion) throws Exception {
        List<Detalle_Compra> resultado = new ArrayList();
        ADDetalle_Compras addetalle_compra;
        try {
            addetalle_compra = new ADDetalle_Compras();
            resultado = addetalle_compra.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public Detalle_Compra ObtenerRegistro(String condicion) throws Exception {
        Detalle_Compra resultado;
        ADDetalle_Compras addetalle_compra;
        try {
            addetalle_compra = new ADDetalle_Compras();
            resultado = addetalle_compra.ObtenerRegisto(condicion);
            if(resultado.isExiste()){
                _mensaje= "Detalle compra Recuperado exitosamente";
            }else{
                _mensaje = "Detalle compra no existe";
            }
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public int Modificar(Detalle_Compra detalle_compra) throws Exception {
        int resultado = -1;
        ADDetalle_Compras addetalle_compra;
        try {
            addetalle_compra = new ADDetalle_Compras();
            resultado = addetalle_compra.Modificar(detalle_compra);
            _mensaje = addetalle_compra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public int Eliminar(Detalle_Compra detalle_compra) throws Exception {
        int resultado = -1;
        ADDetalle_Compras addetalle_compra;
        try {
            addetalle_compra = new ADDetalle_Compras();
            resultado = addetalle_compra.Eliminar(detalle_compra);
            _mensaje = addetalle_compra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}

