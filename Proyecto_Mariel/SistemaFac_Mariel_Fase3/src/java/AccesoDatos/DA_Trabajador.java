/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Entidades.Trabajador;
import java.sql.*; // Las clases de SQL de JDBC
import java.util.*; // para manejo de Listas 
import static AccesoDatos.ClaseConexion.getConnection;

public class DA_Trabajador {
    // ATRIBUTOS 
    private String _mensaje;

    // PROPIEDADES
    public String getMensaje() {
        return _mensaje;
    }

    // CONSTRUCTORES 
    public DA_Trabajador() {
        _mensaje = "";
    }

    // MÉTODOS 
    // Este método va a llamar a un Procedimiento Almacenado
    public int Insertar(Trabajador trabajador) throws Exception {
        CallableStatement CS = null; // para llamar a un procedimiento almacenado
        int resultado = -1;
        Connection _conexion = null;

        try {
            _conexion = getConnection(); // obtenemos la Cadena de Conexión
            // con static, se usa como si fuera un método de esta clase
            CS = _conexion.prepareCall("{call GUARDARTRABAJADOR(?,?,?,?,?,?,?)}");
            // llamanos el procedimiento almacenado

            // 1) Registrar los parámetros
            CS.setInt(1, trabajador.getId_trabajador());
            CS.setString(2, trabajador.getNombre());
            CS.setString(3, trabajador.getApellido());
            CS.setString(4, trabajador.getTelefono());
            CS.setString(5, trabajador.getEmail());
            CS.setString(6, trabajador.getPuesto_trabajo());
            
            CS.setString(7, _mensaje);

            // 2) Registrar los parámetros de SALIDA
            CS.registerOutParameter(1, Types.INTEGER);
            CS.registerOutParameter(7, Types.VARCHAR);

            // 3) Ejecutar
            resultado = CS.executeUpdate();

            // 4) Leer los parámetros de Salida
            _mensaje = CS.getString(7);
        } catch (Exception ex) {
            //resultado = -1; // ya está definido desde el inicio en -1
            _mensaje = "Error inesperado, intente más tarde";
            throw ex;
        } finally {
            if (_conexion != null) {
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;
    } // método insertar 

    
    // No utiliza procedimientos almacenados:
    public int Modificar(Trabajador trabajador) throws Exception {
        int resultado = -1;
        Connection _conexion = null;

        try {
            _conexion = ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement("update Trabajador set nombre=?,apellido=?,telefono=?,email=?,puesto_trabajo=? where id_trabajador=?");
            ps.setString(1,trabajador.getNombre());
            ps.setString(2,trabajador.getApellido());
            ps.setString(3,trabajador.getTelefono());
            ps.setString(4,trabajador.getEmail());
            ps.setString(5,trabajador.getPuesto_trabajo());
            ps.setInt(6,trabajador.getId_trabajador());
            resultado = ps.executeUpdate();
            
        } catch (Exception ex) {
            //resultado = -1;
            throw ex;
        } finally {
            if (_conexion != null) {
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;
    }//Modificar

    
    public int Eliminar(Trabajador trabajador) throws Exception {
        CallableStatement cs = null;//Se usa CallableStatement porque estoy "llamando" a un procedimiento almacenado
        int resultado = -1;
        Connection _conexion = null;

        try {
            _conexion = ClaseConexion.getConnection();

            cs = _conexion.prepareCall("{call Eliminartrabajador(?,?)}");

            // 1) Registrar los parámetros
            cs.setInt(1, trabajador.getId_trabajador());
            cs.setString(2, _mensaje);

            // 2) Registrar los parámetros de SALIDA
            cs.registerOutParameter(2, Types.VARCHAR);

            // 3) Ejecutar
            resultado = cs.executeUpdate();

            // 4) Leer los parámetros de Salida
            _mensaje = cs.getString(2);

        }//try
        catch (Exception ex) {
            //resultado = -1;
            throw ex;
        } finally {
            if (_conexion != null) {
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;
    }//Eliminar

    public ResultSet ListarRegistros(String Condicion, String Orden) throws Exception {
        // Orden es el tipo de ordenamiento que se va a utilizar en la consulta por ejemplo ORDER BY NOMBRE
       
        ResultSet rs = null;
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia;

            sentencia = "Select id_trabajador,nombre,apellido,telefono,email,puesto_trabajo from trabajador";
            if (!Condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, Condicion);
            }
            if (!Orden.equals("")) {
                sentencia = String.format("%s ORDER BY %s", sentencia, Orden);
            }
            rs =st.executeQuery(sentencia);
        } catch (Exception ex) {
            throw ex;
        }

        return rs;
    }

    public List<Trabajador> ListarRegistros(String Condicion) throws Exception {
        ResultSet rs = null;
        Trabajador trabajador;
        List<Trabajador> lista = new ArrayList<>();
        Connection _conexion = null;
        try {
            // Abrir la conexión:
            _conexion = ClaseConexion.getConnection();
            
            Statement st = _conexion.createStatement();
            String Sentencia;

            Sentencia = "Select id_trabajador,nombre,apellido,telefono,email,puesto_trabajo from trabajador";
            
            if (!Condicion.equals("")) {
                Sentencia = String.format("%s WHERE %s", Sentencia, Condicion);
            }

            rs = st.executeQuery(Sentencia);
            
            // Recorremos el ResultSet agregando cada Registro a la Lista
            while (rs.next()) {
                trabajador = new Trabajador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6));
                lista.add(trabajador);
            }
        } 
        catch (Exception ex) {
            throw ex;
        } 
        finally {
            if (_conexion != null) {
                ClaseConexion.close(_conexion);
            }
        }
        return lista;
    }

    /*
        MÉTODO 6: Obtener registro _____________________
        Recibe: condición (String)
        Retorna: un objeto CLIENTE
     */
    public Trabajador ObtenerRegistro(String Condicion) throws Exception {
        // La idea es que la Condición que ingresa permita conseguir un registro único y no varios!
        // Por tanto al llamar a este método debemos garantizar que SIEMPRE le enviemos en la condición
        // el ID de un cliente. 
        
        ResultSet rs = null;
        Trabajador trabajador = new Trabajador();
        String sentencia;
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();

            sentencia = "Select id_trabajador,nombre,apellido,telefono,email,puesto_trabajo from trabajador";
            if (!Condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, Condicion);
            }
            rs = st.executeQuery(sentencia);

            // Con If y no While, por si esta consulta hubiera retornado varios registros, 
            // lee solamene uno (el primero).
            // En teoría eso nunca va a pasar si en la condición el método recibe el ID de un cliente
            if (rs.next()) {
                trabajador.setId_trabajador(rs.getInt(1));
                trabajador.setNombre(rs.getString(2));
                trabajador.setApellido(rs.getString(3));
                trabajador.setTelefono(rs.getString(4));
                trabajador.setEmail(rs.getString(5));
                trabajador.setPuesto_trabajo(rs.getString(6));
                trabajador.setExiste(true);
            } else {
                trabajador.setExiste(false);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (_conexion != null) {
                ClaseConexion.close(_conexion);
            }
        }
        return trabajador;
    }
}
