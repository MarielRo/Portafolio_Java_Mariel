// Mariel Rojas

package Capa3_AccesoDatos;

import Capa_Entidades.Factura_Compra;
import Config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ADFactura_Compra {
    // Atributos
    private Connection _cnn;
    private String _mensaje;
    
    // Constructor
    public ADFactura_Compra()throws Exception{
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
    public int Insertar(Factura_Compra factura_compra) throws Exception{
        int id_factura_compra = -1;
        String sentencia = "Insert into Factura_Compra(total,fecha,estado,proveedor)"
                + " values(?,?,?,?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1,factura_compra.getTotal());
            ps.setString(2,factura_compra.getFecha());
            ps.setString(3,factura_compra.getEstado());
            ps.setString(4, factura_compra.getProveedor());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs !=null && rs.next()){
                id_factura_compra = rs.getInt(1);
                _mensaje = "Factura Compra ingresado satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return id_factura_compra;
    }
    
    public ResultSet ListarRegistros(String condicion, String orden)throws SQLException{
         ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_factura_compra,total,fecha,estado,proveedor Factura_Compra";
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
    
    public List<Capa_Entidades.Factura_Compra> ListarRegistros(String condicion)throws SQLException{
        ResultSet rs = null;
        List<Capa_Entidades.Factura_Compra> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_factura_compra,total,fecha,estado,proveedor from Factura_Compra";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new Capa_Entidades.Factura_Compra(rs.getInt("id_factura_compra"),rs.getDouble("total"),rs.getString("fecha"),
                rs.getString("estado"),rs.getString("proveedor")));
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
    public Factura_Compra ObtenerRegisto(String condicion)throws SQLException{
        Factura_Compra factura_compra = new Factura_Compra();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_factura_compra,total,fecha,estado,proveedor from Factura_Compra";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            if(rs.next()){
                factura_compra.setId_factura_compra(rs.getInt(1));
                factura_compra.setTotal(rs.getDouble(2));
                factura_compra.setFecha(rs.getString(3));
                factura_compra.setEstado(rs.getString(4));
                factura_compra.setProveedor(rs.getString(5));
                factura_compra.setExiste(true);
            }

        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn= null;
        }
        return factura_compra;
    }
    
    
    public int Modificar(Factura_Compra factura_compra) throws Exception{
        int resultado = 0;
        String sentencia = "update Factura_Compra set total=?,fecha=?,estado=?,proveedor=? where id_factura_compra=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setDouble(1,factura_compra.getTotal());
            ps.setString(2,factura_compra.getFecha());
            ps.setString(3,factura_compra.getEstado());
            ps.setString(4, factura_compra.getProveedor());
            ps.setInt(5, factura_compra.getId_factura_compra());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "factura compra modificada satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return resultado;
    
    
    }

    public int Eliminar(Factura_Compra factura_compra) throws Exception{
        int resultado = 0;
        String sentencia = "delete Factura_Compra where id_factura_compra=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, factura_compra.getId_factura_compra());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "Factura Compra eliminadoo satisfactoriamente";
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
