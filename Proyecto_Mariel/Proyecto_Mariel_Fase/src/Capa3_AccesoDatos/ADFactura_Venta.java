// Mariel Rojas
package Capa3_AccesoDatos;

import Capa_Entidades.Factura_Venta;
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
public class ADFactura_Venta {
    // Atributos
    private Connection _cnn;
    private String _mensaje;
    
    // Constructor
    public ADFactura_Venta()throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            _mensaje = "";
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    // getter /
    public String getMensaje(){
        return _mensaje;
    }

    //////////METODOS /////////////
    // Metodos para unsertat un Factura_Compra
    public int Insertar(Factura_Venta factura_venta) throws Exception{
        int id_factura_venta = -1;
        String sentencia = "Insert into Factura_Venta(id_cliente,id_trabajador,total,fecha,estado,metodo_pago)"
                + " values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, factura_venta.getId_cliente());
            ps.setInt(2, factura_venta.getId_trabajador());
            ps.setDouble(3,factura_venta.getTotal());
            ps.setString(4,factura_venta.getFecha());
            ps.setString(5,factura_venta.getEstado());
             ps.setString(6,factura_venta.getMetodo_pago());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs !=null && rs.next()){
                id_factura_venta = rs.getInt(1);
                _mensaje = "Factura Venta ingresado satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return id_factura_venta;
    }
    
    public ResultSet ListarRegistros(String condicion, String orden)throws SQLException{
         ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_factura_venta,id_cliente,id_trabajador,total,fecha,estado,metodo_pago from Factura_Venta";
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
    
    public List<Capa_Entidades.Factura_Venta> ListarRegistros(String condicion)throws SQLException{
        ResultSet rs = null;
        List<Capa_Entidades.Factura_Venta> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_factura_venta,id_cliente,id_trabajador,total,fecha,estado,metodo_pago from Factura_Venta";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new Capa_Entidades.Factura_Venta(rs.getInt("id_factura_venta"),rs.getInt("id_cliente"),rs.getInt("id_trabajador"),rs.getDouble("total"),rs.getString("fecha"),rs.getString("estado"),rs.getString("metodo_pago")));
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
    public Factura_Venta ObtenerRegisto(String condicion)throws SQLException{
        Factura_Venta factura_venta = new Factura_Venta();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_factura_venta,id_cliente,id_trabajador,total,fecha,estado,metodo_pago from Factura_Venta";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            if(rs.next()){
                factura_venta.setId_factura_venta(rs.getInt(1));
                factura_venta.setId_cliente(rs.getInt(2));
                factura_venta.setId_trabajador(rs.getInt(3));
                factura_venta.setTotal(rs.getDouble(4));
                factura_venta.setFecha(rs.getString(5));
                factura_venta.setEstado(rs.getString(6));
                factura_venta.setMetodo_pago(rs.getString(7));
                factura_venta.setExiste(true);
            }

        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn= null;
        }
        return factura_venta;
    }
    
    
    public int Modificar(Factura_Venta factura_venta) throws Exception{
        int resultado = 0;
        String sentencia = "update Factura_Venta set id_cliente=?,id_trabajador=?,total=?,fecha=?,estado=?,metodo_pago=? where id_factura_venta=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, factura_venta.getId_cliente());
            ps.setInt(2, factura_venta.getId_trabajador());
            ps.setDouble(3,factura_venta.getTotal());
            ps.setString(4,factura_venta.getFecha());
            ps.setString(5,factura_venta.getEstado());
            ps.setString(6,factura_venta.getMetodo_pago());
            ps.setInt(7, factura_venta.getId_factura_venta());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "factura venta modificada satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return resultado;
    
    
    }

    public int Eliminar(Factura_Venta factura_venta) throws Exception{
        int resultado = 0;
        String sentencia = "delete Factura_Venta where id_factura_venta=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, factura_venta.getId_factura_venta());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "Factura venta eliminadoo satisfactoriamente";
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
