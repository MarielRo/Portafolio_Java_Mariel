/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import java.util.*;

import AccesoDatos.DA_Facturas;
import Entidades.Detalle_Venta;
import Entidades.Factura;
//import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class BL_Factura {
    private String _Mensaje;

    public String getMensaje() {
        return _Mensaje;
    }
    
    public int Insertar(Factura Entidad, Detalle_Venta EntidadDetalle) throws Exception{
            int Resultado= 0;
            
            try{
                
                DA_Facturas DA = new DA_Facturas();
                Resultado=DA.Insertar(Entidad, EntidadDetalle);
                _Mensaje=DA.getMensaje();
                
            }catch(Exception ex){
                Resultado=-1;
                throw ex;
            }

            return Resultado;
    }
    
//    public int Anular(Factura Entidad) throws Exception {
//        int Resultado= 0;
//        
//        try{
//
//            DA_Facturas DA = new DA_Facturas();
//
//            Resultado = DA.Anular(Entidad);
//          
//
//        }catch(Exception ex){
//            Resultado=-1;
//            throw ex;
//        }
//
//        return Resultado;
//    }
    
    public int ModificarEstado(Factura Entidad) throws Exception {
        int Resultado= 0;
        
        try{

            DA_Facturas DA = new DA_Facturas();

            Resultado = DA.ModificarEstado(Entidad);
          

        }catch(Exception ex){
            throw ex;
        }

        return Resultado;
    }
    
    public int ModificarCliente(Factura Entidad) throws Exception {
        int idfactura= 0;
        
        try{

            DA_Facturas DA = new DA_Facturas();

            idfactura = DA.ModificarCliente(Entidad);
          

        }catch(Exception ex){
            throw ex;
        }

        return idfactura;
    }

//    public ResultSet ListarRegistros(String condicion, String orden) throws Exception{
//        ResultSet RSDatos;
//        
//        try{
//            
//            DA_Facturas DA = new DA_Facturas();
//
//            RSDatos = DA.ListarRegistros(condicion);
//            
//
//        }catch (Exception ex){
//            RSDatos=null;
//            throw ex;
//        }
//
//        return RSDatos;
//    }

    public List<Factura> ListarRegistros(String condicion) throws Exception{
        List<Factura> Datos;
        
        try{
            
            DA_Facturas DA = new DA_Facturas();

            Datos = DA.ListarRegistros(condicion);
                    
            

        }catch (Exception ex){
            Datos=null;
            throw ex;
        }

        return Datos;
    }
    
    public Factura ObtenerRegistro(String condicion) throws Exception{
        Factura Entidad=null;
        
        try{
            
            DA_Facturas DA = new DA_Facturas();

            Entidad = DA.ObtenerRegistro(condicion);
            

        }catch (Exception ex){
            throw ex;
        }

        return Entidad;
    }

       
}
