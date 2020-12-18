<%@page import="controllers.ControladorUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ControladorUsuarios cu = new ControladorUsuarios();
    
    String status = request.getParameter("status");
%>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Usuarios</title>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <!----------------------Inicio Links---------------------------------->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <!----------------------Fin Links------------------------------------->
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <!--<a class="navbar-brand container" href="#">Navbar</a>-->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <!--Navbar izquierdo-->
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <a class="nav-link" href="index.html">Casa</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="IngresarUsuario.jsp">Ingresar Usuario</a>
                </li>
                <li class="nav-item" id="cambiarjsp">
                    <a class="nav-link" href="#" onclick="CambiarLink()" id>Ver Administradores</a>
                </li>
              </ul>
                <!--Nabvar centro-->
                <a class="navbar-brand" href="index.html"><img src="img/logo022.png" alt="" width="110" height="100"></a>
                <!--Navbar derecho-->
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href="mantenedor.jsp">Volver al menú</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#"></a>
                </li>
              </ul>
            </div>
          </nav>
        <table class="table">
            <thead>
                <tr class="table-dark">
                    <th scope="col">Rut</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Telefono</th>                                    
                    <th scope="col">Ubicacion</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Contraseña</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>

            <tbody id="cuerpo1">
                <%=cu.getListadoUsuarios()%>             
            </tbody>

        </table>           
        <script>
                  $( document ).ready(function() {
                      if(<%=status%>=="1"){
                        $('#myModal').modal('toggle');
                      }
              });
        </script>    
        <!-- Modal HTML -->
        <div id="myModal" class="modal fade">
            <div class="modal-dialog modal-login">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Proceso Completado</h4>
                        <!--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>-->
                    </div>
                    <div class="modal-body">
                        <div class="alert alert-success" role="alert">
                            !Se ha hecho el procedimiento con exito¡
                        </div>
                    </div>
                </div>
            </div>
        </div>      
            <script>
                  $( document ).ready(function() {
                      if(<%=status%> == "2"){
                          $('#myModal2').modal('toggle'); 
                      }                
              });
        </script>      
        <!-- Modal HTML -->
        <div id="myModal2" class="modal fade">
            <div class="modal-dialog modal-login">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">No se ha podido seguir con el proceso</h4>
                        <!--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>-->
                    </div>
                    <div class="modal-body">
                        <div class="alert alert-danger" role="alert">
                            Ha ocurrido un error y no se han hecho los cambios.
                        </div>
                    </div>
                </div>
            </div>
        </div>
        

            
            
<!----------------------Inicio Scripts---------------------------------->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
<!----------------------Fin Scripts------------------------------------->
    <script>       

    function CambiarLink(){
        document.getElementById("cambiarjsp").innerHTML = "<a class='nav-link' href='mantenedorUsuarios.jsp'>Ver Clientes</a>";
        veradmin();     
    }
    
    function veradmin(){
                    $.ajax({
                        url: "Pruebas",
                        data:{
                            texto:"hola"
                        },
                        success: function(result){                           
                            $("#cuerpo1").html(result);                                          
                        }
                    });
    }
    </script>
</body>
</html>

