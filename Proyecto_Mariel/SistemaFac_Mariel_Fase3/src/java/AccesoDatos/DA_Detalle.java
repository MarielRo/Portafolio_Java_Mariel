
package AccesoDatos;

import Entidades.Detalle_Venta;
import java.sql.*;
import java.util.*;

public class DA_Detalle {
    // ATRIBUTOS
    private String _Mensaje;

    // PROPIEDADES
    public String getMensaje() {
        return _Mensaje;
    }

    // CONSTRUCTOR VACÍO
    public DA_Detalle() {
        _Mensaje = "";
    }
    
    // METODOS
    
    public int Eliminar(Detalle_Venta Entidad) throws Exception{
        CallableStatement CS = null;
        int resultado = -1;
        Connection _Conexion = null;
        try{
            _Conexion = ClaseConexion.getConnection();
            CS = _Conexion.prepareCall("{call ELIMINAR_DETALLE(?,?,?)}");
            
            CS.setInt(1, Entidad.getFactura_venta());
            CS.setInt(2, Entidad.getId_producto());
            CS.setString(3, _Mensaje);
            resultado = CS.executeUpdate();
        }catch (Exception ex){
            resultado = -1;
            throw ex;
        }finally{
            if (_Conexion != null ) {
                ClaseConexion.close(_Conexion);
            }
        }
        return resultado; // la cantidad de filas afectadas
    } // fin Eliminar
    
    
    public List<Detalle_Venta> ListarRegistros(String Condicion) throws Exception{
        ResultSet RS = null;
        /*  Porque la consulta la BD SIEMPRE va a devolver eun ResultSet, no hay
            forma que la consulta nos devuelva una LISTA. 
            Luego convertimos el ResultSet a una Lista para retornarla 
        */
                
        Detalle_Venta Entidad;
        List<Detalle_Venta> lista = new ArrayList<>();
        Connection _Conexion = null;
        
        try {
            _Conexion = ClaseConexion.getConnection();
            Statement ST = _Conexion.createStatement();
            String Sentencia;
            
            Sentencia = "SELECT D.ID_FACTURA, D.ID_PRODUCTO,D.CANTIDAD,D.PRECIO_VENTA,P.NOMBRE FROM DETALLE_FACTURA D INNER JOIN PRODUCTO P ON D.ID_PRODUCTO = P.ID_PRODUCTO";

            if(!Condicion.equals(""))  {
                Sentencia = String.format("%s WHERE %s", Sentencia, Condicion);
            }
            
            RS = ST.executeQuery(Sentencia);
            
            while(RS.next()){
                Entidad = new Detalle_Venta(RS.getInt("ID_FACTURA"), 
                                                RS.getInt("ID_PRODUCTO"), 
                                                RS.getInt("CANTIDAD"),
                                                RS.getInt("PRECIO_VENTA"),
                                                RS.getString("NOMBRE"));
                
                lista.add(Entidad);
            }
        }
        catch (Exception ex) {
            throw ex;
        } finally{
            if (_Conexion != null) ClaseConexion.close(_Conexion);
        }
        return lista;
    }
    
    public Detalle_Venta ObtenerRegistro(String condicion) throws SQLException,Exception {
        ResultSet RS = null;
        Detalle_Venta Entidad = new Detalle_Venta();
        String Sentencia;
        Connection _Conexion = null;
        Sentencia = "SELECT D.ID_FACTURA, D.ID_PRODUCTO, P.NOMBRE, D.CANTIDAD,D.PRECIO_VENTA FROM DETALLE_FACTURA D INNER JOIN PRODUCTO P ON D.ID_PRODUCTO = P.ID_PRODUCTO";
        if(!condicion.equals("")){
            Sentencia = String.format("%s WHERE %s", Sentencia, condicion);
        }
        try {
            _Conexion = ClaseConexion.getConnection();
            Statement ST = _Conexion.createStatement();
            RS = ST.executeQuery(Sentencia);
            if(RS.next()){
                Entidad.setFactura_venta(RS.getInt(1));
                Entidad.setId_producto(RS.getInt(2));
                Entidad.setNombreProducto(RS.getString(3));
                Entidad.setCantidad(RS.getInt(4));
                Entidad.setPrecio(RS.getInt(5));
                Entidad.setExiste(true);
            }
            else{
                Entidad.setExiste(false);
            }
            
        } catch (Exception ex) {
            throw ex;
        }finally{
            if(_Conexion != null) ClaseConexion.close(_Conexion);
        }
        return Entidad;
    }
    
}
