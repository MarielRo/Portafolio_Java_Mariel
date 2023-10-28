package AccesoDatos;

import Entidades.Detalle_Venta;
import Entidades.Factura;
import java.sql.*;
import java.util.*;

public class DA_Facturas {
    // ATRIBUTOS
    private String _Mensaje;

    public String getMensaje() {
        return _Mensaje;
    }
    
    // CONSTRUCTORES
    public DA_Facturas() {
        _Mensaje = "";
    }
    
    // METODOS
    public int Insertar(Factura EntidadFactura, Detalle_Venta EntidadDetalle) throws Exception{
        //ResultSet RSDatos; // no se esta utilizando
        CallableStatement CS;
        int resultado = 0;
        int idFactura = 0;
        Connection _Conexion = null;
        try {
            _Conexion = ClaseConexion.getConnection(); 
            
            // Transacciones Implicitas y Explicitas:
            _Conexion.setAutoCommit(false);
            
            CS = _Conexion.prepareCall("{call Guardar_Factura(?,?,?,?,?,?,?,?)}");
            
            CS.setInt(1, EntidadFactura.getId_factura());
            CS.setDate(2, EntidadFactura.getFecha());  
            CS.setInt(3, EntidadFactura.getId_cliente());
            CS.setDouble(4,EntidadFactura.getSubtotal());
            CS.setDouble(5,EntidadFactura.getImpuesto());
            CS.setDouble(6,EntidadFactura.getDescuento());
            CS.setString(7, EntidadFactura.getEstado());
            CS.setString(8, _Mensaje);
            CS.registerOutParameter(1, Types.INTEGER); // en la BD el parametro 1 es de salida para obtener el IDENTITY generado
            
            resultado = CS.executeUpdate();
            
            idFactura = CS.getInt(1);
            
            CS = _Conexion.prepareCall("{call Guardar_Detalle(?,?,?,?,?)}");
            CS.setInt(1, idFactura); // llama a la variable que acabamos de declarar
            CS.setInt(2, EntidadDetalle.getId_producto());
            CS.setInt(3, EntidadDetalle.getCantidad());
            CS.setDouble(4, (double)EntidadDetalle.getPrecio()); 
            CS.setString(5, _Mensaje);
            
            //registrar mensaje para salida
            CS.registerOutParameter(5, Types.VARCHAR);
            
            resultado = CS.executeUpdate();
            
            //SE RECIBE DEL SP
            _Mensaje = CS.getString(5);
            
            _Conexion.commit();
                          
            
        } catch (ClassNotFoundException | SQLException ex) { // tambien pudo usarse Exception que es general
            
            _Conexion.rollback(); // Si algo salió mal se DESHACEN todas las transacciones con un ROLLBACK
                                   // para que la BD quede en un estado consistente. 
            
            throw ex;
        }finally{
            if(_Conexion != null) ClaseConexion.close(_Conexion);
        }
        return idFactura;
    } // fin de insertar
    
    
    public int ModificarEstado(Factura EntidadFactura)  throws Exception{
        int resultado = 0;
        Connection _Conexion = null;  
        
        try{
            _Conexion = ClaseConexion.getConnection(); 
            PreparedStatement PS = _Conexion.prepareStatement("update Factura set Estado = ? where id_factura = ?");
            
            PS.setString(1, EntidadFactura.getEstado());
            PS.setInt(2, EntidadFactura.getId_factura());
            
            resultado = PS.executeUpdate();
            
        }catch(Exception ex){
            resultado = -1;
            throw  ex;
        }finally{
            if(_Conexion != null) ClaseConexion.close(_Conexion);
         
        }
        return resultado;
    } // fin ModificarEstado
    
    
    public int ModificarCliente(Factura EntidadFactura)  throws Exception{
        int idfactura = 0;
        Connection _Conexion = null; 
        try{
            _Conexion = ClaseConexion.getConnection(); 
            PreparedStatement PS = _Conexion.prepareStatement("update Factura set ID_CLIENTE = ? where ID_FACTURA = ?");
            
            PS.setInt(1, EntidadFactura.getId_cliente());
            PS.setInt(2, EntidadFactura.getId_factura());
            
            PS.executeUpdate();
            idfactura = EntidadFactura.getId_factura(); // este devuelve el ID FACTURA
            
        }catch(Exception ex){
            throw  ex;
        }finally{
            if(_Conexion != null) ClaseConexion.close(_Conexion);
        }
        return idfactura;
    } // fin Modificar ID del cliente
    
    
    public List<Factura> ListarRegistros(String Condicion) throws Exception{
        ResultSet RS = null;
        Factura Entidad;
        List<Factura> ListaF = new ArrayList<>();
        Connection _Conexion = null;
        try {
            _Conexion = ClaseConexion.getConnection();
            Statement ST = _Conexion.createStatement();
            String Sentencia;
            
            Sentencia = "SELECT ID_FACTURA,F.ID_CLIENTE,NOMBRE,FECHA,IMPUESTO,SUBTOTAL,DESCUENTO,ESTADO FROM Factura F INNER JOIN CLIENTE ON CLIENTE.ID_CLIENTE=F.ID_CLIENTE";
            if(!Condicion.equals("")){
                Sentencia = String.format("%s WHERE %s", Sentencia, Condicion);
            }
            RS = ST.executeQuery(Sentencia);
            while(RS.next()){
                Entidad = new Factura(RS.getInt("ID_FACTURA"),
                        RS.getDate("Fecha"),
                        RS.getInt("Id_Cliente"),
                        RS.getDouble("Subtotal"),
                        RS.getDouble("Impuesto"),
                        RS.getDouble("Descuento"),
                        RS.getString("Estado"),
                        RS.getString("Nombre"));
                         
                ListaF.add(Entidad);
            }

            } catch (Exception ex) {
                throw ex;
            }finally{
            if(_Conexion != null) ClaseConexion.close(_Conexion);
        }
        return ListaF;
    } // fin Listar Registros
    
    
    
    // retorna una factura 
    public Factura ObtenerRegistro(String Condicion) throws Exception{
        ResultSet RsDatos = null;
        Factura Entidad = new Factura();
        String Sentencia;
        Connection _Conexion = null;
        Sentencia = "SELECT ID_FACTURA,F.ID_CLIENTE,NOMBRE,FECHA,IMPUESTO,SUBTOTAL,DESCUENTO,ESTADO FROM Factura F INNER JOIN CLIENTE ON CLIENTE.ID_CLIENTE=F.ID_CLIENTE";
        if(!Condicion.equals("")){
                Sentencia = String.format("%s WHERE %s", Sentencia, Condicion);
            }
        try {
            _Conexion = ClaseConexion.getConnection();
            Statement ST = _Conexion.createStatement();
            RsDatos = ST.executeQuery(Sentencia);
            if(RsDatos.next()){
                Entidad.setId_cliente(RsDatos.getInt("id_factura"));
                Entidad.setFecha(RsDatos.getDate("Fecha"));
                Entidad.setId_cliente(RsDatos.getInt("Id_Cliente"));
                Entidad.setSubtotal(RsDatos.getDouble("Subtotal"));
                Entidad.setImpuesto(RsDatos.getDouble("Impuesto"));
                Entidad.setDescuento(RsDatos.getDouble("Descuento"));
                Entidad.setNombreCliente(RsDatos.getString("Nombre"));
                Entidad.setEstado(RsDatos.getString("Estado"));
                Entidad.setExisteRegistro(false);
            }else{
                Entidad.setExisteRegistro(false);
            }
            } catch (Exception ex) {
                throw ex;
            }finally{
            if(_Conexion != null) ClaseConexion.close(_Conexion);
        }
        return Entidad;
    } // fin Listar Registros
}
