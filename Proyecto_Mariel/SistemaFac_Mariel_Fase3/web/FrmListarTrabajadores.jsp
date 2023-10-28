
<%@page import="Entidades.Trabajador"%>
<%@page import="LogicaNegocio.BL_Trabajador"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Lib/bootstrap-datepicker/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" type="text/css"/>
        <link href="Lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <title>Listado de Trabajadores</title>
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
            <div class="card-header">
                <h1>Listado de Trabajadores</h1>
            </div>
            <br/>

            <form action="FrmListarTrabajadores.jsp" method="post">
                
                <div class="form-group">
                    <div class="input-group">
                        
                        <input type="text" id="txtnombre" name="txtnombre" value="" placeholder="Buscar por nombre..." 
                               class="form-control"/>&nbsp; &nbsp;
                        <input type="submit" id="btnbuscar" name="btnBuscar" value="Buscar" class="btn btn-info"/><br><br>
                    </div>
                </div>
            </form>
            <hr/>
            <table class="table">
                <thead>
                    <tr id="titulos">
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Teléfono</th>
                        <th>Email</th>
                        <th>Puesto Trabajo</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <%
                        String nombre = "";
                        String condicion = "";
                        if (request.getParameter("txtnombre")!=null){ 
                            nombre = request.getParameter ("txtnombre");
                            condicion="NOMBRE LIKE '%" + nombre + "%'";
                        }
                        BL_Trabajador logica = new BL_Trabajador();
                        List<Trabajador> datos;
                        datos=logica.ListarRegistros(condicion);
                        
                        for (Trabajador registro:datos){  
                    %>

                    <tr>
                        <%int codigo=registro.getId_trabajador();%>
                        
                        <td><%= codigo%></td> <!-- estos no terminan con ; porque son Expresiones -->
                        <td><%= registro.getNombre()%></td>
                        <td><%= registro.getApellido()%></td>
                        <td><%= registro.getTelefono()%></td>
                        <td><%= registro.getEmail()%></td>
                        <td><%= registro.getPuesto_trabajo()%></td>
                        
                        <!-- Columna adicional con botones de opciones: -->
                        <td>
                            <a href="Frm_Trabajadores.jsp?idCrearModificar=<%=codigo%>"><i class="fas fa-user-edit"></i></a> |           
                            <a href="EliminarTrabajador?idEliminar=<%=codigo%>"><i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    
                    <%}%> <!--Cerrar la llave del FOR de JAVA-->
                </tbody>
            </table>
            <br>

            <% 
                if(request.getParameter("mensajeServletEliminarTrabajador")!=null){
                   
                    
                    out.print("<p class='text-danger'>"+ new String (request.getParameter("mensajeServletEliminarTrabajador").getBytes("ISO-8859-1"),
                    "UTF-8")+"</p>");
                }
            %>
                          
            <a href="Frm_Trabajadores.jsp?idCrearModificar=-1" class="btn btn-info">Agregar Nuevo Trabajador</a> 
            <a href="FrmListarTrabajadores.jsp" class="btn btn-info">Actualizar</a>
            <br><br>
            <a href="index.html" class="btn btn-secondary">Regresar al Index</a>
        </div>

        <script src="Lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        

    </body>
</html>
