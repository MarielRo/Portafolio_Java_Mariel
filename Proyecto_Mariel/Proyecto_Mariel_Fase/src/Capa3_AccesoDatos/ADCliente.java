// Mariel Rojas
package Capa3_AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import Config.Config;
import java.sql.PreparedStatement;
import java.sql.Statement;
import Capa_Entidades.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ADCliente {
    // Atributos
    private Connection _cnn;
    private String _mensaje;
   
    // Constructor
    public ADCliente()throws Exception{
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
    public int Insertar(Cliente cliente) throws Exception{
        int id_cliente = -1;
        String sentencia = "Insert into Cliente(nombre,apellido,telefono,email) values(?,?,?,?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,cliente.getNombre());
            ps.setString(2,cliente.getApellido());
            ps.setString(3,cliente.getTelefono());
            ps.setString(4,cliente.getEmail());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs !=null && rs.next()){
                id_cliente = rs.getInt(1);
                _mensaje = "Cliente ingresado satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return id_cliente;
    }
    
    public ResultSet ListarRegistros(String condicion, String orden)throws SQLException{
         ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_cliente,nombre,apellido,telefono,email from cliente";
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
    
    public List<Capa_Entidades.Cliente> ListarRegistros(String condicion)throws SQLException{
        ResultSet rs = null;
        List<Capa_Entidades.Cliente> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_cliente,nombre,apellido,telefono,email from cliente";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new Capa_Entidades.Cliente(rs.getInt("id_cliente"),rs.getString("nombre"),rs.getString("apellido"),
                rs.getString("telefono"),rs.getString("email")));
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
    public Cliente ObtenerRegisto(String condicion)throws SQLException{
        Cliente cliente = new Cliente();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_cliente,nombre,apellido,telefono,email from cliente";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            if(rs.next()){
                cliente.setId_cliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setExiste(true);
            }

        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn= null;
        }
        return cliente;
    }
    
    
    public int Modificar(Cliente cliente) throws Exception{
        int resultado = 0;
        String sentencia = "update Cliente set nombre=?,apellido=?,telefono=?,email=? where id_cliente=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setString(1,cliente.getNombre());
            ps.setString(2,cliente.getApellido());
            ps.setString(3,cliente.getTelefono());
            ps.setString(4,cliente.getEmail());
            ps.setInt(5,cliente.getId_cliente());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "Registro modificado satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return resultado;
    
    
    }

    public int Eliminar(Cliente cliente) throws Exception{
        int resultado = 0;
        String sentencia = "delete Cliente where id_cliente=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, cliente.getId_cliente());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "Registro eliminadoo satisfactoriamente";
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
