package AccesoDatos;


import Entidades.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static AccesoDatos.ClaseConexion.getConnection;


public class DA_Productos {
    //"Atributos"
        private String _Mensaje="";
    //*******************************************

    public String getMensaje() {
        return _Mensaje;
    }

    
        
    //"Constructores"
        public DA_Productos() {
            _Mensaje="";
        }
    //*******************************************

    //"Metodos"
        public int Insertar(Producto EntidadProducto) throws Exception{
            ResultSet RS=null;
            CallableStatement CS=null;
            int resultado = 0;
            Connection _Conexion=null;
            
            try{
                _Conexion=ClaseConexion.getConnection();
                CS=_Conexion.prepareCall("{call GuardarProducto(?,?,?,?,?,?)}");

                CS.setInt(1, EntidadProducto.getId_producto());          
                CS.setString(2, EntidadProducto.getNombre());
                CS.setDouble(3, EntidadProducto.getPrecio());
                CS.setInt(4, EntidadProducto.getCantidad_disponible());
                CS.setString(5, EntidadProducto.getCategoria());
                CS.setString(6, _Mensaje);
           
                resultado = CS.executeUpdate();
                
            }catch (Exception ex){
                resultado=-1;
                throw ex;
            }finally{
                if (_Conexion != null) ClaseConexion.close(_Conexion);
            }
            return resultado;
        }//fin de insertar

        public int Modificar(Producto EntidadProducto) throws Exception{
            int resultado = 0;
            Connection _conexion=null;
            try{
                _conexion=ClaseConexion.getConnection();
                PreparedStatement ps =_conexion.prepareStatement("UPDATE PRODUCTO SET NOMBRE=?, PRECIO=?, CANTIDAD_DISPONIBLE=?,CATEGORIA=? WHERE ID_PRODUCTO = ?");
              
                ps.setInt(1, EntidadProducto.getId_producto());          
                ps.setString(2, EntidadProducto.getNombre());
                ps.setDouble(3, EntidadProducto.getPrecio());
                ps.setInt(4, EntidadProducto.getCantidad_disponible());
                ps.setString(5, EntidadProducto.getCategoria());
                ps.setString(6, _Mensaje);

                
            }catch (Exception ex){
                resultado=-1;
                throw ex;
                
            }finally{
                if (_conexion != null) ClaseConexion.close(_conexion);
            }
            return resultado;
        }//fin de modificar
        

        public int Eliminar(Producto EntidadProducto) throws Exception {
            CallableStatement CS=null;
            int resultado = 0;
            Connection _Conexion=null;
            try{
                _Conexion=ClaseConexion.getConnection();
                CS=_Conexion.prepareCall("{call EliminarProducto(?,?)}");
                             
                CS.setInt(1, EntidadProducto.getId_producto());
                CS.setString(2, _Mensaje);
                CS.registerOutParameter(2, Types.VARCHAR);
                resultado = CS.executeUpdate();

                _Mensaje=CS.getString(2);
                
            }catch (Exception ex){
                resultado=-1;
                throw  ex;
            }finally{
                if (_Conexion != null) ClaseConexion.close(_Conexion);
            }
            return resultado;
        }//fin de eliminar

        
        public ResultSet ListarRegistros(String condicion, String orden) throws SQLException, Exception{
            ResultSet RS=null;
            String Sentencia;
            Sentencia = "SELECT ID_PRODUCTO,NOMBRE,PRECIO, CANTIDAD_DISPONIBLE,CATEGORIA FROM PRODUCTO";

            if (!condicion.equals("")) {
                Sentencia = String.format("%s WHERE %s", Sentencia, condicion);
            }

            if(!orden.equals("")) {
                Sentencia = String.format("%s ORDER BY %s", Sentencia, orden);
            }

            try{
                Connection _Conexion=ClaseConexion.getConnection();
                Statement ST = _Conexion.createStatement();
                RS=ST.executeQuery(Sentencia);
                
            }catch(Exception ex){
                throw ex;
            }
            return RS;
        }

        public List<Producto> ListarRegistros(String Condicion) throws Exception{
            ResultSet RS=null;
            Producto Entidad;
            List<Producto> lista=new ArrayList<>();
            Connection _Conexion=null;
            try{
                _Conexion=ClaseConexion.getConnection(); 
                Statement ST = _Conexion.createStatement();
                String Sentencia;

                Sentencia = "SELECT ID_PRODUCTO,NOMBRE,PRECIO,CANTIDAD_DISPONIBLE,CATEGORIA FROM PRODUCTO";
                if (!Condicion.equals("")) {
                    Sentencia = String.format("%s WHERE %s", Sentencia, Condicion);
                }

                RS=ST.executeQuery(Sentencia);
                while(RS.next()){
                    Entidad=new Producto(RS.getInt(1), RS.getString(2), RS.getDouble(3), RS.getInt(4),RS.getString(5));
                    lista.add(Entidad);
                }
            }catch(Exception ex){
                throw ex;
            }finally{
                if (_Conexion != null) ClaseConexion.close(_Conexion);
            }
            return lista;
        }
        
        public Producto ObtenerRegistro(String condicion) throws SQLException, Exception {
            ResultSet RS=null;
            Producto EntidadProducto=new Producto();
            String vlc_Sentencia;
            Connection _Conexion=null;
            vlc_Sentencia = "SELECT ID_PRODUCTO,NOMBRE,PRECIO, CANTIDAD_DISPONIBLE,CATEGORIA FROM PRODUCTO";

            if (!condicion.equals("")) {
                vlc_Sentencia = String.format("%s WHERE %s", vlc_Sentencia, condicion);
            }

            try{
                _Conexion=ClaseConexion.getConnection();
                Statement ST = _Conexion.createStatement();
                RS=ST.executeQuery(vlc_Sentencia);
                if(RS.next()){
                    EntidadProducto.setId_producto(RS.getInt(1));
                    EntidadProducto.setNombre(RS.getString(2));
                    EntidadProducto.setPrecio(RS.getDouble(3));
                    EntidadProducto.setCantidad_disponible(RS.getInt(4));
                    EntidadProducto.setCategoria(RS.getString(5));

                    EntidadProducto.setExiste(true);
                    
                }else{
                    EntidadProducto.setExiste(false);
                    
                }
                   
            }catch(Exception ex){
                throw ex;
            }finally{
                if (_Conexion != null) ClaseConexion.close(_Conexion);
            }
            return EntidadProducto;
        }
        
}
