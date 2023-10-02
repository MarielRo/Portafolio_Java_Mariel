//Mariel Rojas Sánchez

package Capa3_AccesoDatos;

import Capa_Entidades.Trabajador;
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
public class ADTrabajador {
    // Atributos
    private Connection _cnn;
    private String _mensaje;
   
    // Constructor
    public ADTrabajador()throws Exception{
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
    public int Insertar(Trabajador trabajador) throws Exception{
        int id_trabajador = -1;
        String sentencia = "Insert into Trabajador(nombre,apellido,telefono,email,puesto_trabajo) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,trabajador.getNombre());
            ps.setString(2,trabajador.getApellido());
            ps.setString(3,trabajador.getTelefono());
            ps.setString(4,trabajador.getEmail());
            ps.setString(5,trabajador.getPuesto_trabajo());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs !=null && rs.next()){
                id_trabajador = rs.getInt(1);
                _mensaje = "Trabajador ingresado satisfactoriamente";
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return id_trabajador;
    }
    
    public ResultSet ListarRegistros(String condicion, String orden)throws SQLException{
         ResultSet rs=null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_trabajador,nombre,apellido,telefono,email,puesto_trabajo from trabajador";
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
    
    public List<Capa_Entidades.Trabajador> ListarRegistros(String condicion)throws SQLException{
        ResultSet rs = null;
        List<Capa_Entidades.Trabajador> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_trabajador,nombre,apellido,telefono,email,puesto_trabajo from trabajador";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new Capa_Entidades.Trabajador(rs.getInt("id_trabajador"),rs.getString("nombre"),rs.getString("apellido"),
                rs.getString("telefono"),rs.getString("email"),rs.getString("puesto_trabajo")));
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
    public Trabajador ObtenerRegisto(String condicion)throws SQLException{
        Trabajador trabajador = new Trabajador();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia= "Select id_trabajador,nombre,apellido,telefono,email,puesto_trabajo from trabajador";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s", sentencia, condicion);  
            }
            rs= stm.executeQuery(sentencia);
            if(rs.next()){
                trabajador.setId_trabajador(rs.getInt(1));
                trabajador.setNombre(rs.getString(2));
                trabajador.setApellido(rs.getString(3));
                trabajador.setTelefono(rs.getString(4));
                trabajador.setEmail(rs.getString(5));
                trabajador.setPuesto_trabajo(rs.getString(6));
                trabajador.setExiste(true);
            }

        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn= null;
        }
        return trabajador;
    }
    
    
    public int Modificar(Trabajador trabajador) throws Exception{
        int resultado = 0;
        String sentencia = "update Trabajador set nombre=?,apellido=?,telefono=?,email=?,puesto_trabajo=? where id_trabajador=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setString(1,trabajador.getNombre());
            ps.setString(2,trabajador.getApellido());
            ps.setString(3,trabajador.getTelefono());
            ps.setString(4,trabajador.getEmail());
            ps.setString(5,trabajador.getPuesto_trabajo());
            ps.setInt(6,trabajador.getId_trabajador());
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

    public int Eliminar(Trabajador trabajador) throws Exception{
        int resultado = 0;
        String sentencia = "delete Trabajador where id_trabajador=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, trabajador.getId_trabajador());
            resultado = ps.executeUpdate();
            if(resultado > 0){
                _mensaje = "Trabajador eliminadoo satisfactoriamente";
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
