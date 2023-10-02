//Mariel
package Capa3_AccesoDatos;

import Capa_Entidades.Detalle_Compra;
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
public class ADDetalle_Compras {
    
    //atributos
    private Connection _cnn;
    private String _mensaje;
    
     //constructor
    public ADDetalle_Compras() throws Exception{
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
    
    
    public int Insertar(Detalle_Compra detalle_compra) throws Exception {
        int id = -1;
        String sentencia = "insert into detalle_factura_compra(id_detalle_compra,id_factura_compra,id_producto,cantidad,precio_compra) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalle_compra.getId_detalle_compra());
            ps.setInt(2, detalle_compra.getFactura_compra());
             ps.setInt(3, detalle_compra.getId_producto());
            ps.setInt(4, detalle_compra.getCantidad());            
            ps.setDouble(5, detalle_compra.getPrecio());
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
            String sentencia= "Select id_factura_compra,id_cliente,id_trabajador,total,fecha,estado,metodo_pago from Detalle_Factura_Venta";
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
    
    public List<Capa_Entidades.Detalle_Compra> ListarRegistros(String condicion)throws SQLException{
        ResultSet rs = null;
        List<Capa_Entidades.Detalle_Compra> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_detalle_compra,id_factura_compra,id_producto,cantidad,precio_compra from Detalle_Factura_compra";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new Capa_Entidades.Detalle_Compra(rs.getInt("id_detalle_compra"),rs.getInt("id_factura_compra"),rs.getInt("id_producto"),rs.getInt("cantidad"),rs.getDouble("precio_compra")));
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
    public Detalle_Compra ObtenerRegisto(String condicion)throws SQLException{
        Detalle_Compra detalle_compra= new Detalle_Compra();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_detalle_compra,id_factura_compra,id_producto,cantidad,precio_compra from detalle_factura_compra";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            if(rs.next()){
                detalle_compra.setId_detalle_compra(rs.getInt(1));
                detalle_compra.setFactura_compra(rs.getInt(2));
                detalle_compra.setId_producto(rs.getInt(3));
                detalle_compra.setCantidad(rs.getInt(4));
                detalle_compra.setPrecio(rs.getDouble(5));
                detalle_compra.setExiste(true);
            }

        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn= null;
        }
        return detalle_compra;
    }
    
    
    public int Modificar(Detalle_Compra detalle_compra) throws Exception{
        int resultado = 0;
        String sentencia = "update Detalle_Factura_compra set id_factura_compra=?,id_producto=?,cantidad=?,precio_compra=? where id_detalle_compra=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, detalle_compra.getFactura_compra());
            ps.setInt(2, detalle_compra.getId_producto());
            ps.setInt(3,detalle_compra.getCantidad());
            ps.setDouble(3,detalle_compra.getPrecio());
            ps.setInt(5,detalle_compra.getId_detalle_compra());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "detalle compra modificada satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return resultado;
    
    
    }

    public int Eliminar(Detalle_Compra detalle_compra) throws Exception{
        int resultado = 0;
        String sentencia = "delete Detalle_Factura_compra where id_detalle_compra=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, detalle_compra.getId_detalle_compra());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "detalle compra eliminadoo satisfactoriamente";
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
