<%-- 
    Document   : FrmListarFacturas
    Created on : 12/11/2020, 10:52:46 AM
    Author     : PC
--%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Factura"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="LogicaNegocio.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Lib/bootstrap-datepicker/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" type="text/css"/>
        <link href="Lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <title>Lisatdo de Facturas</title>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-grey border-bottom box-shadow mb-3">
                <div class="container">
                    <a class="navbar-brand btn btn-info btn-lg" href="index.html">
                        Sistema Facturación <i class="fas fa-tasks"></i></a>
                    <button class="navbar-toggler bg-secondary" type="button" data-toggle="collapse" data-target=".navbar-collapse" 
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    
                    <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                        <ul class="navbar-nav flex-grow-1">
                            <li class="nav-item">
                                <a class="btn btn-secondary mr-2" href="index.html" >Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="btn btn-secondary mr-2" href="Frm_ListarProductos.jsp">Productos</a>
                            </li>
                            <li class="nav-item">
                                <a class="btn btn-secondary mr-2" href="FrmListarClientes.jsp">Clientes</a>
                            </li>
                            <li class="nav-item">
                                <a class="btn btn-secondary mr-2" href="FrmListarTrabajadores.jsp">Trabajadores</a>
                            </li>
                            <li class="nav-item">
                                <a class="btn btn-secondary mr-2" href="FrmListarFacturas.jsp">Facturación</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <div class="container">
            <div class="card-header">
                <h1>Listado de Facturas Pendientes</h1>
            </div>
            <br/>
            <form action="FrmListarFacturas.jsp" method="post">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" id="txtfecha" name="txtfecha" value="" 
                               placeholder="Seleccione la fecha" class="datepicker"/> &nbsp; &nbsp;
                        <input type="submit" id="btnbuscar" name="btnBuscar" value="Buscar" 
                               class="btn btn-info"/> <br><br>
                    </div>
                </div>
            </form>
            </hr>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id_Factura</th>
                        <th>Cliente</th>
                        <th>Fecha</th>
                        <th>impuesto</th>
                        <th>Descuento</th>
                        <th>Estado</th>
                        <th>Opciones</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        String fecha = "";
                        String condicion = ""; //Estado='Pendiente'";
                        if (request.getParameter("txtfecha") != null
                                && !request.getParameter("txtfecha").equals("")) {
                            fecha = request.getParameter("txtfecha");
                            //condicion = condicion + " AND FECHA = '" + fecha + "'";
                            condicion = condicion + "FECHA = '" + fecha + "'";
                        }

                        BL_Factura logica = new BL_Factura();
                        List<Factura> datos;
                        datos = logica.ListarRegistros(condicion);
                        for (Factura registro : datos) {
                    %>
                    <tr>
                        <%int num = registro.getId_factura();%>
                        <td><%= num%></td>
                        <td><%= registro.getNombreCliente()%></td>
                        <td><%= registro.getFecha()%></td>
                        <td><%= registro.getImpuesto()%></td>
                        <td><%= registro.getDescuento()%></td>
                        <td><%= registro.getEstado()%></td>
                        <td>
                            <a href="Frm_Facturar.jsp?txtnumFactura=<%= num%>">
                                <i class="fas fa-cart-plus"></i></a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <br/>
            <a href="Frm_Facturar.jsp?txtnumFactura=-1" class="btn btn-info">Nueva Factura</a>
        </div>
        <script src="Lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="Lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="Lib/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
        <script src="Lib/bootstrap-datepicker/locales/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
    </body>

    <script>
        $('.datepicker').datepicker({
            format: 'yyyy-mm-dd',
            autoclose: true,
            language: 'es'
        });
    </script>

</html>
