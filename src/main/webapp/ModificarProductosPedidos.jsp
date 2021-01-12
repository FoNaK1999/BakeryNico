<%@page import="controllers.ControladorPedidos"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="classes.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="controllers.ControladorProducto"%>
<%@page import="controllers.ControladorVehiculo"%>
<%@page import="controllers.ControladorUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String status = request.getParameter("status");
    ControladorPedidos cp = new ControladorPedidos();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Modificar Productos del Pedido</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
    </head>
    <body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <!--<a class="navbar-brand container" href="#">Navbar</a>-->
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <a id="logo" class="navbar-brand" href="index.html"><img src="img/logo022.png" alt="" width="110" height="100"></a>
                 </div>
          </nav> 
        <center>
            <h1 align="center">Modificar productos del pedido</h1>
                    <table>
                        <tbody>
                            <tr><td>Seleccione un pedido:</td></tr>
                            <tr><td>
                                <select name="idped" id="idped">
                                 <option>Seleccionar un pedido</option>
                                    <%=cp.VerPedidosCombobox()%>
                                </select>                                              
                            </td></tr>

                            <tr><td><div class="form-check">
                                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" onclick="VerOpciones()">
                                    <label class="form-check-label" for="flexRadioDefault1">
                                      ¿Agregar nuevos productos?
                                    </label>
                                  </div>
                                  <div class="form-check">
                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" onclick="VerOpciones()">
                                    <label class="form-check-label" for="flexRadioDefault2">
                                      ¿Modificar existentes?
                                    </label>
                            </div></td></tr>
                            <tr id="resultado"></tr>
                            
                            
                            
                            
                            <!--Agregar Producto
                            <tr><td colspan="2"><label id="textolabel">INGRESAR CANTIDAD DE PRODUCTOS: </label></td></tr>
                            <tr><td><input type="text" name="cantidadProductos" id="cantprod" required></td></tr>
                            <tr><td><input type="button" onclick="probar();" value="Agregar productos" id="botonprod"></td></tr>
                            <tr id="resultado"></tr>
                            <br>
                            <br>
                            <!-- Fin Agregar Producto-->
                        </tbody>

                    </table>
                    <br>
                    <br>
                    <input type="submit" value="Registrar Pedido" id="botoncin"/>
            <a href="javascript:window.history.go(-1);" style="float:left; border:2px black solid; background-color:gainsboro;">Volver al listado</a>
        </center>
        <script>                                                                             
            //<tr><td colspan='2><label id='textolabel'>INGRESAR CANTIDAD DE PRODUCTOS: </label></td></tr><tr><td><input type='text' name='cantidadProductos' id='cantprod' required></td></tr><tr><td><input type='button' onclick='probar();' value='Agregar productos' id='botonprod'></td></tr><tr id='resultado'></tr>";           
    
    function VerOpciones(){
                if(document.getElementById('flexRadioDefault1').checked) {
                    document.getElementById("resultado").innerHTML = "<tr><td colspan='2><label id='textolabel'>INGRESAR CANTIDAD DE PRODUCTOS: </label></td><tr><td><input type='text' name='cantidadProductos' id='cantprod' required></td></tr><tr><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='button' onclick='probar();' value='Agregar productos' id='botonprod'></td></tr>";
                }else if(document.getElementById('flexRadioDefault2').checked) {
                    
                    
                    document.getElementById("resultado").innerHTML = "<ul class='list-group' id='Listado'>"+
                                                                        "<li class='list-group-item active' aria-current='true'>Ver Productos del Pedido</li>"+
                                                                          "<li class=\'list-group-item\' id='resultado2'></li>"+
                                                                      "</ul>";
                   
                }
                RellenarTabla();
            }   
    

            

            
            function RellenarTabla(){
                var idped = document.getElementById("idped").value;
                $.ajax({
                    url: "ObtenerListadoProductosPedido",
                    data:{
                        idped:idped
                    },
                    success: function(result){                     
                        $("#resultado2").html(result); 
                    }
                });
            }
            
            function EliminarProducto(){
                var idped = document.getElementById("idped").value;
                for(var i=1;i<=2){
                    var id = "idprod"+i.toString();
                    var idprod = document.getElementById(id).value;
                }
                
                $.ajax({
                    url: "BorrarSolicitar",
                    data:{
                        idped:idped,
                        idprod:idprod
                    },
                    success: function(result){
                      $("#resultado2").html(result);                        
                    }
                });
            }            
        </script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    </body>
</html>