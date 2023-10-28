
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.Producto"%>
<%@page import="LogicaNegocio.BL_Producto"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Lista de productos</title>
        <link href="Lib/bootstrap-datepicker/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" type="text/css"/>
        <link href="Lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>

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
                                <a class="btn btn-secondary mr-2" href="FrmListarFacturas.jsp">Facturación Venta</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <div class="container">  <!-- container y card-header son clases de BOOTSTRAP -->
            <div class="row">
                <div class="col-md-8 mx-auto">

                    <div class="card-header">
                        <h1>Listado de Productos</h1>
                    </div>
                    <br/>

                    <form action="Frm_ListarProductos.jsp" method="post">
                        <div class="form-group">
                            <div class="input-group">
                                <label for="txtnombre">Nombre de Producto</label>&nbsp; &nbsp;
                                <!-- el for de este label lo unico que hace asociar esa etiqueta con el input -->
                                <input type="text" id="txtnombre" name="txtnombre" placeholder="Nombre" class="form-control"/>&nbsp; &nbsp;
                                <input type="submit" value="Buscar" name="btnBuscar" class="btn btn-info"/>
                            </div>
                        </div>
                    </form>
                    <br>

                    <%
                        if (request.getParameter("mensaje") != null
                                && !request.getParameter("mensaje").equals("")) {
                            out.print("<p style='color:red'>" + request.getParameter("mensaje") + "</p>");
                        }
                    %>

                    <table class="table">
                        <tr>
                            <th style="text-align: left">Código</th>
                            <th style="text-align: left">Nombre</th>
                            <th style="text-align: left">Precio</th>
                            <th style="text-align: left">Cantidad Disponible</th>
                            <th style="text-align: left">Categoria</th>
                            <th style="text-align: left">Opciones</th>
                        </tr>

                        <%
                            String nombre; // la vamos a llenar con lo que traiga la solicitud
                            String condicion = "";
                            if (request.getParameter("txtnombre") != null
                                    && !request.getParameter("txtnombre").equals("")) {
                                nombre = request.getParameter("txtnombre");
                                condicion = "nombre like '%" + nombre + "%'";
                            }
                            BL_Producto logica = new BL_Producto();
                            List<Producto> datos = logica.ListarRegistros(condicion);
                            for (Producto registro : datos) {

                        %>

                        <tr>
                            <td><%=registro.getId_producto()%></td>
                            <td><%= new String(registro.getNombre().getBytes("ISO-8859-1"), "UTF-8")%></td>
                           <!--   <td><%=DecimalFormat.getCurrencyInstance().format(registro.getPrecio())%></td> -->
                            <td><%=registro.getPrecio()%></td>
                            <td><%=registro.getCantidad_disponible()%></td>
                            <td><%= new String(registro.getCategoria().getBytes("ISO-8859-1"), "UTF-8")%></td>
                            <td>
                                <a href="Frm_Productos.jsp?txtIdproducto=<%= registro.getId_producto()%>"><i class="fas fa-user-edit"></i></a> |
                                <a href="EliminarProducto?txtIdproducto=<%= registro.getId_producto()%>"><i class="fas fa-trash-alt"></i></a>
                            </td>
                        </tr>
                        <% } // fin del For %>

                    </table>

                    <br>
                    <a href="Frm_Productos.jsp" class="btn btn-info" >Agregar Nuevo Producto</a>

                </div> <!-- clase que crea las 6 columnas -->

            </div> <!-- class row, div de la fila -->

        </div> <!-- class container -->

        <script src="Lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="Lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>

    </body>
</html>
