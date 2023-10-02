// Mariel Rojas Sánchez
package Capa3_AccesoDatos;

import Capa_Entidades.Producto;
import Config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ADProducto {
    // Atributos
    private Connection _cnn;
    private String _mensaje;
   
    // Constructor
    public ADProducto()throws Exception{
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
    // Metodos para unsertat un cliente
    public int Insertar(Producto producto) throws Exception{
        int id_producto = -1;
        String sentencia = "Insert into Producto(nombre,precio,cantidad_disponible,categoria)"
                + " values(?,?,?,?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,producto.getNombre());
            ps.setDouble(2,producto.getPrecio());
            ps.setInt(3,producto.getCantidad_disponible());
            ps.setString(4, producto.getCategoria());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs !=null && rs.next()){
                id_producto = rs.getInt(1);
                _mensaje = "Producto ingresado satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return id_producto;
    }
    
    public ResultSet ListarRegistros(String condicion, String orden)throws SQLException{
         ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_producto,nombre,precio,cantidad_disponible,categoria from Producto";
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
    
    public List<Capa_Entidades.Producto> ListarRegistros(String condicion)throws SQLException{
        ResultSet rs = null;
        List<Capa_Entidades.Producto> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_producto,nombre,precio,cantidad_disponible,categoria from Producto";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new Capa_Entidades.Producto(rs.getInt("id_producto"),rs.getString("nombre"),rs.getDouble("precio"),
                rs.getInt("cantidad_disponible"),rs.getString("categoria")));
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
    public Producto ObtenerRegisto(String condicion)throws SQLException{
        Producto producto = new Producto();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_producto,nombre,precio,cantidad_disponible,categoria from Producto";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            if(rs.next()){
                producto.setId_producto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCantidad_disponible(rs.getInt(4));
                producto.setCategoria(rs.getString(5));
                producto.setExiste(true);
            }

        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn= null;
        }
        return producto;
    }
    
    
    public int Modificar(Producto producto) throws Exception{
        int resultado = 0;
        String sentencia = "update Producto set nombre=?,precio=?,cantidad_disponible=?,categoria=? where id_producto=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setString(1,producto.getNombre());
            ps.setDouble(2,producto.getPrecio());
            ps.setInt(3,producto.getCantidad_disponible());
            ps.setString(4, producto.getCategoria());
            ps.setInt(5,producto.getId_producto());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "Producto modificado satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return resultado;
    
    
    }

    public int Eliminar(Producto producto) throws Exception{
        int resultado = 0;
        String sentencia = "delete Producto where id_producto=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, producto.getId_producto());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "Producto eliminadoo satisfactoriamente";
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
