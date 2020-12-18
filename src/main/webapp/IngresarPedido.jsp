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
    ControladorUsuarios cu = new ControladorUsuarios();
    ControladorVehiculo cv = new ControladorVehiculo();
    ControladorProducto cp = new ControladorProducto();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Ingresar Pedido</title>
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
            <h1 align="center">Ingresar Pedido</h1>
                <form action="RegistrarPedido" method="post">
                    <table>
                        <tbody>
                        <!--solicita-->
                        <tr><td colspan="2"><label id="textolabel">INGRESAR CANTIDAD DE PRODUCTOS: </label></td></tr>
                        <tr><td><input type="text" name="cantidadProductos" id="cantprod" required></td></tr>
                        <tr><td><input type="button" onclick="probar();" value="Agregar productos" id="botonprod"></td></tr>
                        <tr id="resultado"></tr>
                        <br>
                        <br>
                        <tr><td colspan="2"><label>FECHA: </label></td></tr>
                        <tr><td><input type="date" name="fecha" required></td></tr>
                        <tr><td colspan="2"><label>RUT CLIENTE: </label></td></tr>
                        <tr><td>
                                <select name="rut" id="usu">
                                 <option>Seleccione un cliente</option>
                                    <%=cu.getRutUsuarios()%>
                                </select>
                        </td></tr>
                        <tr><td colspan="2"><label>MATRICULA: </label></td></tr>
                        <tr><td>
                                <select name="matricula" id="matricula">
                                 <option>Seleccione una matricula</option>
                                    <%=cv.getVehiculo()%>
                                </select>
                        </td></tr>
                        <tr><td colspan="2"><label>ESTADO: </label></td></tr>
                        <tr><td><div id="content" style="padding:20px">
                            <label>Entregado</label>
                                <input type="radio" id="Disponible" name="state" value="Entregado" style="margin-right: 10px" required>
                            <label>Pendiente</label>
                                <input type="radio" id="nodisponible" name="state" value="Pendiente" required>
                        </div></td></tr>
                        <tr><td>
                                
                        </td></tr>
                        <%
                        if(status!=null){
                        %>
                        <p><strong style="color:red;"><%=status%></strong></p>
                        <%
                        }else{
                        %>
                        <p><strong style="color:red;"> </strong></p>
                        <%
                        }    
                        %>
                        </tbody>

                    </table>
                    <br>
                    <br>
                    <input type="submit" value="Registrar Pedido" id="botoncin"/>
                </form>
            <a href="javascript:window.history.go(-1);" style="float:left; border:2px black solid; background-color:gainsboro;">Volver al listado</a>
        </center>      
        <script>          
            
                window.onload=function()
                {
                  var elemento=document.getElementById("botoncin");
                  elemento.onmouseover = function(e) {
                        var usuario = document.getElementById("usu").value;
                        var patente = document.getElementById("matricula").value;               
                                                                                              
                        if("Seleccione un cliente" == usuario && "Seleccione una matricula" == patente){
                            
                            alert("Falta seleccionar en los desplegables de RUT CLIENTE y MATRICULA");
                            
                        }else if("Seleccione un cliente" == usuario){
                            alert("Seleccione un CLIENTE");
                        }else if("Seleccione una matricula" == patente){
                            alert("Seleccione una MATRICULA");
                        }
                  };
                };
                                             
            
            function probar(){
                        var cantprod = document.getElementById("cantprod").value;
                        for(var i = 1; i <= cantprod; i++){
                            var id = "resultado"+i.toString();
                            var cantidad = "cantidad"+i.toString();
                            //document.getElementById("resultado").innerHTML += "<select id='"+id+"' name='"+id+"'></select>\n<label>CANTIDAD: </label><input type='text' name='"+cantidad+"'>";
                            document.getElementById("resultado").innerHTML += "<label for='exampleFormControlTextarea1' class='form-label'>PRODUCTO: </label><div class='mb-3'><select id='"+id+"' name='"+id+"' required></select></div><div class='mb-3'><label for='exampleFormControlTextarea1' class='form-label'>CANTIDAD:</label><input type='number' class='form-control' id='exampleFormControlTextarea1' rows='3' name='"+cantidad+"' placeholder='Ingresar la cantidad' required></div>";  
                        }
                        
                        combobox();
                        Eliminar();
            }
            
            function combobox(){
                var cantprod = document.getElementById("cantprod").value;
                $.ajax({
                    url: "TestServlet",
                    data:{
                        cantprod:cantprod
                    },
                    success: function(result){
                        for(var i = 1; i <= cantprod; i++){
                            var id2 = "#resultado"+i.toString();
                            $(id2).html(result);
                        }                  
                    }
                });
            }
            
            
                
        function Eliminar(){
                        //Input
                        var  cajita = document.getElementById("cantprod");
                        cajita.type = "hidden";
                        
                        //var boton = document.getElementById("botoncin");
                        //boton.type = 
                        //Label
                        var label = document.getElementById("textolabel");
                        var padre2 = document.getElementById("productos");         
                        padre2 = label.parentNode;
                        padre2.removeChild(label);
                        
                        //Boton
                        var botoncito = document.getElementById("botonprod");
                        var padre3 = document.getElementById("productos");         
                        padre3 = botoncito.parentNode;
                        padre3.removeChild(botoncito);                       
                }  
                
        </script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    </body>
</html>
