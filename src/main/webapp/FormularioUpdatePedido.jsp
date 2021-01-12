<%@page import="controllers.ControladorVehiculo"%>
<%@page import="controllers.ControladorUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String fecha = request.getParameter("fecha");
    String rut = request.getParameter("rutcliente");
    String matricula = request.getParameter("matricula");
    ControladorUsuarios cu = new ControladorUsuarios();
    ControladorVehiculo cv = new ControladorVehiculo();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html" charset=UTF-8" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Modificar Pedido</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="img/panaderia1.png" type="image/png">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
         <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <!--<a class="navbar-brand container" href="#">Navbar</a>-->
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <!--Nabvar centro-->
                <a id="logo" class="navbar-brand" href="index.html"><img src="img/logo022.png" alt="" width="110" height="100"></a>
                 </div>
          </nav>
        <center>
            <h1 align="center">Modificar Pedido</h1>
                <form action="UpdatePedido" method="post">
                    <table>
                        <tr id="resultado"></tr>
                        <tr><td><input type="hidden" name="id" value="<%=id%>" required readonly="readonly"></td></tr>
                        <tr><td colspan="2"><label>FECHA: </label></td></tr>
                        <tr><td><input type="date" name="fecha" value="<%=fecha%>" required></td></tr>
                        <tr><td colspan="2"><label>RUT CLIENTE: </label></td></tr>
                        <tr><td>
                                <select name="rut" required>
                                    <option value="<%=rut%>">Dejar el mismo</option>
                                    <%=cu.getRutUsuarios()%>
                                </select>
                        </td></tr>
                        <tr><td colspan="2"><label>MATRICULA: </label></td></tr>
                        <tr><td>
                                <select name="matricula" required>
                                    <option value="<%=matricula%>">Dejar el mismo</option>
                                    <%=cv.getVehiculo()%>
                                </select>
                        </td></tr>
                        <tr><td><label colspan="2">CAMBIAR ESTADO:</label></td></tr>
                        <tr><td><div id="content" style="padding:20px">
                            <label>Entregado</label>
                                <input type="radio"  name="state" value="Entregado" style="margin-right: 10px" required>
                            <label>Pendiente</label>
                                <input type="radio"  name="state" value="Pendiente" required>
                                </div></td></tr>
                        <tr><td><input type="submit" value="Actualizar"/></td></tr>
                    </table>
                </form>
            <a href="javascript:window.history.go(-1);" style="float:left; border:2px black solid; background-color:gainsboro;">Volver al listado</a>
        </center>
    </body>
    
    <script>               
        function MostrarProductos2(){
            var estado1 = document.getElementById("estado1").value;
            var estado2 = document.getElementById("estado2").value;
            var nombre = document.getElementsByName("verprod").value;
            
            console.log(estado1 + " " + estado2);
            
            if(estado1="Si"){
                document.getElementById("resultado").innerHTML = "<td id='producto'>Estado 1</td>";
            }else if(estado2="No"){
                document.getElementById("resultado").innerHTML = "<td id='producto'>Estado 2</td>";
            }
            
        }
        
        function Eliminar(){                       
            var hijo = document.getElementById("productos");
            var padre3 = document.getElementById("resultado");         
            padre3.parentNode.removeChild(hijo);        
        }
        
    </script>
</html>
