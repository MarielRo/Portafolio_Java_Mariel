package LogicaNegocio;

import java.util.*;

import AccesoDatos.DA_Detalle;
import Entidades.Detalle_Venta;


public class BL_Detalle {

    private String _Mensaje;

    public String getMensaje() {
        return _Mensaje;
    }

    public int Eliminar(Detalle_Venta Entidad) throws Exception {
        int Resultado = 0;

        try {
            DA_Detalle DA = new DA_Detalle();

            Resultado = DA.Eliminar(Entidad);

        } catch (Exception ex) {
            Resultado = -1;
            throw ex;
        }

        return Resultado;
    }

//    public ResultSet ListarRegistros(String condicion, String orden) throws Exception{
//        ResultSet RSDatos;
//        
//        try{
//            
//            DA_Detalle DA = new DA_Detalle();
//
//            RSDatos = DA.ListarRegistros(condicion, orden);
//            
//        }catch (Exception ex){
//            RSDatos=null;
//            throw ex;
//        }
//
//        return RSDatos;
//    }
    public List<Detalle_Venta> ListarRegistros(String Condicion) throws Exception {
        List<Detalle_Venta> Datos;
        DA_Detalle AccesoDatos;
        try {
            AccesoDatos = new DA_Detalle();

            Datos = AccesoDatos.ListarRegistros(Condicion);
        } catch (Exception ex) {
            Datos = null;
            throw ex;
        }

        return Datos;
    }

    public Detalle_Venta ObtenerRegistro(String condicion) throws Exception {
        Detalle_Venta Entidad = null;

        try {

            DA_Detalle DA = new DA_Detalle();

            Entidad = DA.ObtenerRegistro(condicion);

        } catch (Exception ex) {
            throw ex;
        }

        return Entidad;
    }
    
}//fin de la clase
