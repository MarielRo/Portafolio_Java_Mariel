// Mariel Rojas 
package Capa3_AccesoDatos;

import Capa_Entidades.Detalle_Venta;
import Config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marie
 */
public class ADDetalle_Ventas {
    
    //atributos
    private Connection _cnn;
    private String _mensaje;
    
     //constructor
    public ADDetalle_Ventas() throws Exception{
        try {
            String url = Config.getConnectionString();            
            _cnn = DriverManager.getConnection(url);
            _mensaje="";
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }        
    }
    
    public String getMensaje(){
        return _mensaje;
    }
    
    
    public int Insertar(Detalle_Venta detalle_Venta) throws Exception {
        int id = -1;
        String sentencia = "insert into detalle_factura_Venta(id_detalle_venta,id_factura_venta,id_producto,cantidad,precio_venta) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalle_Venta.getId_detalle_venta());
            ps.setInt(2, detalle_Venta.getFactura_venta());
             ps.setInt(3, detalle_Venta.getId_producto());
            ps.setInt(4, detalle_Venta.getCantidad());            
            ps.setDouble(5, detalle_Venta.getPrecio());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
                _mensaje = "Ingresado satisfactoriamente";
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return id;
    }   
    
    public ResultSet ListarRegistros(String condicion, String orden)throws SQLException{
         ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_factura_venta,id_cliente,id_trabajador,total,fecha,estado,metodo_pago from Detalle_Factura_Venta";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            if(!orden.equals("")){
                sentencia = String.format("%s order by %s", sentencia, orden);  
            }
            rs= stm.executeQuery(sentencia);

        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn= null;
        }
        return rs;
    }
    
    public List<Capa_Entidades.Detalle_Venta> ListarRegistros(String condicion)throws SQLException{
        ResultSet rs = null;
        List<Capa_Entidades.Detalle_Venta> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_detalle_venta,id_factura_venta,id_producto,cantidad,precio_venta from Detalle_Factura_Venta";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new Capa_Entidades.Detalle_Venta(rs.getInt("id_detalle_venta"),rs.getInt("id_factura_venta"),rs.getInt("id_producto"),rs.getInt("cantidad"),rs.getDouble("precio_venta")));
            }
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn= null;
        }
        return lista;
    }   
    
    // metodo para obtener un registro en la capa de acceso a datos
    public Detalle_Venta ObtenerRegisto(String condicion)throws SQLException{
        Detalle_Venta detalle_venta = new Detalle_Venta();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_detalle_venta,id_factura_venta,id_producto,cantidad,precio_venta from detalle_factura_venta";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            if(rs.next()){
                detalle_venta.setId_detalle_venta(rs.getInt(1));
                detalle_venta.setFactura_venta(rs.getInt(2));
                detalle_venta.setId_producto(rs.getInt(3));
                detalle_venta.setCantidad(rs.getInt(4));
                detalle_venta.setPrecio(rs.getDouble(5));
                detalle_venta.setExiste(true);
            }

        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn= null;
        }
        return detalle_venta;
    }
    
    
    public int Modificar(Detalle_Venta detalle_venta) throws Exception{
        int resultado = 0;
        String sentencia = "update Detalle_Factura_Venta set id_factura_venta=?,id_producto=?,cantidad=?,precio_venta=? where id_detalle_venta=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, detalle_venta.getFactura_venta());
            ps.setInt(2, detalle_venta.getId_producto());
            ps.setInt(3,detalle_venta.getCantidad());
            ps.setDouble(3,detalle_venta.getPrecio());
            ps.setInt(5,detalle_venta.getId_detalle_venta());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "detalle_venta modificada satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return resultado;
    
    
    }

    public int Eliminar(Detalle_Venta detalle_venta) throws Exception{
        int resultado = 0;
        String sentencia = "delete Detalle_Factura_Venta where id_detalle_venta=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, detalle_venta.getId_detalle_venta());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "detalle_venta eliminadoo satisfactoriamente";
            }
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            _cnn=null;
        }
        return resultado;
    
    
    }
    
    
    
    
    
    
    
}
