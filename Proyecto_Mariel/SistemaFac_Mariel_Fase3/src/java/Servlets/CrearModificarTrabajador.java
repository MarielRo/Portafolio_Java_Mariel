/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;
import Entidades.Trabajador;
import LogicaNegocio.BL_Trabajador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marie
 */
public class CrearModificarTrabajador extends HttpServlet {

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

        /*
            Este Servlete va a hacer un trabajo muy sencillo, va a crear una entidad Cliente
            para enviárselo al metodo correspondiente (insertar o modificar)
        */
        
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        // No la incluimos dentro del Try, porque necesitamos usarla en el catch

        try {
            BL_Trabajador Logica = new BL_Trabajador();
            Trabajador trabajador = new Trabajador();
            int resultado;

            trabajador.setId_trabajador(Integer.parseInt(request.getParameter("txtCodigo")));
            trabajador.setNombre(new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"), "UTF-8"));
            trabajador.setApellido(new String(request.getParameter("txtApellido").getBytes("ISO-8859-1"), "UTF-8"));
            trabajador.setTelefono(request.getParameter("txtTelefono"));
            trabajador.setEmail(new String(request.getParameter("txtEmail").getBytes("ISO-8859-1"), "UTF-8"));
            trabajador.setPuesto_trabajo(new String(request.getParameter("txtPuesto").getBytes("ISO-8859-1"), "UTF-8"));
            
            if (trabajador.getId_trabajador() > 0) {
                resultado = Logica.Modificar(trabajador);
            } else {
                resultado = Logica.Insertar(trabajador);
            }
            response.sendRedirect("FrmListarTrabajadores.jsp");

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
