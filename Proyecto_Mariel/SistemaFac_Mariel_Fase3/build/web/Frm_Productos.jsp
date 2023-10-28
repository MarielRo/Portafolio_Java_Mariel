<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.Producto" %>
<%@page import="LogicaNegocio.BL_Producto" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Agregar productos</title>
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
        
        <div class="container">
            <div class="row">
                <div class="col-md-8 mx-auto">
                    <div class="card-header">
                        <h1>Lista de Productos</h1>
                    </div>

                    <%
                        Producto entidad;
                        BL_Producto logica = new BL_Producto();
                        int idproducto;
                        if (request.getParameter("txtIdproducto") != null
                                && !request.getParameter("txtIdproducto").equals("")) {
                            idproducto = Integer.parseInt(request.getParameter("txtIdproducto"));
                            entidad = logica.ObtenerRegistro("Id_producto=" + idproducto);
                        } else {
                            entidad = new Producto();
                            entidad.setId_producto(-1);
                        }
                    %>
                    <br>
                    <form action="AddProducto" method="post">

                        <div class="form-group">
                            <input type="hidden" name="txtIdproducto" id="txtIdproducto" class="form-control"
                                   value="<%= entidad.getId_producto()%>" readonly/>

                            <label for="txtNombre">Nombre</label>
                            <input type="text" name="txtNombre" id="txtNombre" 
                                   value="<%= entidad.getNombre()%>" required class="form-control"/>
                        </div>  
                        <div class="form-group">
                            <label for="txtPrecio">Precio</label>
                            <input type="text" name="txtPrecio" id="txtPrecio" 
                                   value="<%= entidad.getPrecio()%>" required class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="txtCantidadDispo">Existencia</label>
                            <input type="text" name="txtCantidadDispo" id="txtCantidadDispo" 
                                   value="<%= entidad.getCantidad_disponible()%>" required class="form-control"/>
                        </div> 
                        <div class="form-group">
                            <label for="txtCategoria">Categoria</label>
                            <input type="text" name="txtCategoria" id="txtCategoria" 
                                   value="<%= entidad.getCategoria()%>" required class="form-control"/>
                        </div>
                        
                        <div class="form-group">
                            <input type="submit" value="Guardar" class="btn btn-primary">
                            <input type="button" id="btnRegresar" value="Regresar" onclick="location.href = 'Frm_ListarProductos.jsp'" class="btn btn-secondary"/>
                        </div>  
                    </form>
                </div> <!-- clase que crea las 6 columnas -->

            </div> <!-- class row, div de la fila -->

        </div> <!-- class container -->

        <script src="Lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="Lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
