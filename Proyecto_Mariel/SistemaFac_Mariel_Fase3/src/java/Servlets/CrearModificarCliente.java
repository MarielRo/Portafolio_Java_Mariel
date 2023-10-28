
package Servlets;

import Entidades.Cliente;
import LogicaNegocio.BL_Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrearModificarCliente extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
            Este Servlete va a hacer un trabajo muy sencillo, va a crear una entidad Cliente
            para enviárselo al metodo correspondiente (insertar o modificar)
        */
        
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        // No la incluimos dentro del Try, porque necesitamos usarla en el catch

        try {
            BL_Cliente Logica = new BL_Cliente();
            Cliente cliente = new Cliente();
            int resultado;

            cliente.setId_cliente(Integer.parseInt(request.getParameter("txtCodigo")));
            cliente.setNombre(new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"), "UTF-8"));
            cliente.setApellido(new String(request.getParameter("txtApellido").getBytes("ISO-8859-1"), "UTF-8"));
            cliente.setTelefono(request.getParameter("txtTelefono"));
            cliente.setEmail(new String(request.getParameter("txtEmail").getBytes("ISO-8859-1"), "UTF-8"));
            
            if (cliente.getId_cliente() > 0) {
                resultado = Logica.Modificar(cliente);
            } else {
                resultado = Logica.Insertar(cliente);
            }
            response.sendRedirect("FrmListarClientes.jsp");

        } catch (Exception ex) {
            out.print(ex.getMessage());
        }
    }
     
  
   
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
