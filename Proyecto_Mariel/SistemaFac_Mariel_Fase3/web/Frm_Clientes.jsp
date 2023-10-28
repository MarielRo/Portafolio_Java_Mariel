
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="LogicaNegocio.BL_Cliente"%>
<%@page import="Entidades.Cliente"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Mantenimiento de Cliente</title>
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
                        <h1>Mantenimiento de  Clientes</h1>
                    </div>

                    <%
                        String id = request.getParameter("idCrearModificar");
                        int codigo = Integer.parseInt(id);
                        Cliente cliente;
                        BL_Cliente logica = new BL_Cliente();

                        if (codigo > 0) {
                            // Si el cliente existe, lo obtiene enviándole una
                            // CONDICIÓN al método que obtiene un registro:
                            cliente = logica.ObtenerRegistro("ID_CLIENTE=" + id);
                        } else {
                            // Sino, crea uno nuevo
                            cliente = new Cliente();
                        }
                    %>

                    <form action="CrearModificarCliente" method="post" id="form_AgregarModificar">
                        
                        <div class="form-group">
                            <%if (codigo > 0) {%>
                            <label for="txtCodigo" class="control-label">Código</label>
                            <input type="number" id="txtCodigo" name="txtCodigo" value="<%=cliente.getId_cliente()%>" readonly class="form-control"/><br>
                            <%} else {%>
                            <!-- Sino, el campo ID se le asigna -1 y no se muestra en pantalla -->
                            <input type="hidden" id="txtCodigo" name="txtCodigo" value="-1"/><br>
                            <%}%>
                        </div>

                        <!-- form-group para los controles de Nombre -->
                        <div class="form-group">
                            <label for="txtNombre" class="control-label">Nombre</label>
                            <input type="txt" id="txtNombre" name="txtNombre" value="<%=cliente.getNombre()%>" class="form-control"/><br>
                        </div>
                        
                        <!-- form-group para los controles de Apellido -->
                        <div class="form-group">
                            <label for="txtApellido" class="control-label">Apellido</label>
                            <input type="txt" id="txtApellido" name="txtApellido" value="<%=cliente.getApellido()%>" class="form-control"/><br>
                        </div>

                        <!-- form-group para los controles de Teléfono -->
                        <div class="form-group">
                            <label for="txtTelefono" class="control-label">Teléfono</label>
                            <input type="txt" id="txtTelefono" name="txtTelefono" value="<%=cliente.getTelefono()%>" class="form-control"
                                   placeholder="00-00-00-00"/><br>
                        </div>

                        <!-- form-group para los controles de Dirección -->
                        <div class="form-group">
                            <label for="txtEmail" class="control-label">Email</label>
                            <input type="email" id="txtEmail" name="txtEmail" value="<%=cliente.getEmail()%>" class="form-control"/><br>
                        </div>

                        <!-- form-group para los BOTONES de guardar y regresar  -->
                       <div class="form-group">
                            <div class="input-group">
                                <input type="submit" id="btnGuardar" value="Guardar" class="btn btn-info"/> &nbsp;&nbsp;
                                <input type="button" id="btnRegresar" value="Regresar" onclick="location.href = 'FrmListarClientes.jsp'" class="btn btn-secondary"/>
                                <!-- El botón Regresar lleva a la página FrmListarClientes.jsp, no estamos haciendo un RESPONSE
                                porque no está respondiento a ninguna petición, entonces el Regresar lo estamos haciendo por medio de 
                                Javascript con un atributo ONCLICk a ese botón, y en el ONCLICK estamos usando un LOCATION.HREF
                                y poder redireccionar a otra página. -->
                            </div>
                        </div>

                    </form>

                </div> <!-- clase que crea las 6 columnas -->

            </div> <!-- class row, div de la fila -->

        </div> <!-- class container -->

        <!-- Agregamos las referencias a Bootstrap, jquery y jquery-validation -->
        <script src="Lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="Lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="Lib/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>


        <script>
            // Cuando el documento está listo
            $(document).ready(function () {
                $("#form_AgregarModificar").validate({
                    // Reglas que deseamos personalizar:
                    rules: {
                        // Si no definimos estas reglas, solamente se aplicarán las reglas que estén definidas
                        // dentro de cada input (por ejemplo el input se definió como requiered)

                        txtNombre: {required: true, maxlength: 50},
                        txtApellido: {required: true, maxlength: 50},
                        txtTelefono: {required: true, minlength: 8, maxlength: 11},
                        txtEmail: {required: true, maxlength: 45}

                        // Nota: Para determinar estos tamaños debemos verificar las restricciones de nuestra BD


                    },
                    // Mensajes que deseamos personalizar: 
                    messages: {
                        txtNombre: "El campo de Nombre es obligatorio (max 50 caracteres)",
                        txtApellido: "El campo de Apellido es obligatorio (max 50 caracteres)",
                        txtTelefono: "El campo Teléfono es obligatorio (mínimo 8 caracteres, máximo 11)",
                        txtEmail: "El campo Email es obligatorio (max 45 caracteres)"
                    },
                    errorElement: 'span'
                            // Indicamos que si muestar mensajes de error, los muestre dentro de un span, con esto 
                            // de forma automática si se produce un error se va a generar un SPAN, y por eso fue 
                            // que creamos un ESTILO para indicar que el color de ese SPAN fuera rojo en una letra
                            // un poco más pequeña. 
                });
            });
            
        </script>

    </body>
</html>
