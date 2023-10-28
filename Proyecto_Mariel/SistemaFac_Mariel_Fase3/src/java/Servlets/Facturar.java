/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Entidades.Detalle_Venta;
import Entidades.Factura;
import LogicaNegocio.BL_Factura;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marie
 */
public class Facturar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            BL_Factura LogicaFactura = new BL_Factura();
            Factura EntidadFactura = new Factura();
             Detalle_Venta EntidadDetalle = new Detalle_Venta();
            int resultado;
            String mensaje="";
            //crear entidad de factura
            if(request.getParameter("txtNombreCliente")!=null &&
                    !request.getParameter("txtNombreCliente").equals("")){
                EntidadFactura.setId_cliente(Integer.parseInt(request.getParameter("txtIdCliente")));
                EntidadFactura.setId_factura(Integer.parseInt(request.getParameter("txtnumFactura")));
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fechaString = request.getParameter("txtFechaFactura");
                Date fecha = formato.parse(fechaString);
                java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
                EntidadFactura.setFecha(fechasql);
                EntidadFactura.setId_cliente(Integer.parseInt(request.getParameter("txtIdCliente")));
                EntidadFactura.setEstado("Pendiente");
                if(!(request.getParameter("txtdescripcion").equals("")) &&
                        !(request.getParameter("txtcantidad").equals("")) &&
                        !(request.getParameter("txtprecio").equals(""))){
                    //crear entidad de detalle
                    EntidadDetalle.setFactura_venta(-1);
                    EntidadDetalle.setId_producto(Integer.parseInt(request.getParameter("txtIdProducto")));
                    EntidadDetalle.setCantidad(Integer.parseInt(request.getParameter("txtcantidad")));
                    EntidadDetalle.setPrecio(Double.parseDouble(request.getParameter("txtprecio")));
                    resultado = LogicaFactura.Insertar(EntidadFactura, EntidadDetalle);
                    mensaje = LogicaFactura.getMensaje();
                }else{
                   mensaje = "Seleccione un producto";
                   resultado = LogicaFactura.ModificarCliente(EntidadFactura);
                }
                
                response.sendRedirect("Frm_Facturar.jsp?msgFac=" + mensaje + "&txtnumFactura=" + resultado);
                //response.sendRedirect("Frm_Facturar.jsp?txtnumFactura="+resultado);
            }else{
                response.sendRedirect("Frm_Facturar.jsp?txtnumFactura="+
                        request.getParameter("txtnumFactura"));
            }
        }catch(Exception e){
            out.print(e.getMessage());
        }
    }//fin servlets

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
