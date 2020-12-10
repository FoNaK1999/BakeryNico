<%@page import="controllers.ControladorVentas"%>
<%@page import="controllers.ControladorVehiculo"%>
<%@page import="controllers.ControladorUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String status = request.getParameter("status");
    
    ControladorVentas cv = new ControladorVentas();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Ingresar Venta</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
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
            <h1 align="center">Ingresar Venta</h1>
                <form action="RegistrarVenta" method="post">
                    <table>
                        <tr><td colspan="2"><label>ORDEN DE VENTA: </label></td></tr>
                        <tr><td><input type="text" name="id" required></td></tr>
                        <tr><td colspan="2"><label>FECHA: </label></td></tr>
                        <tr><td><input type="date" name="fecha" required></td></tr>
                        <tr><td colspan="2"><label>TOTAL: </label></td></tr>
                        <tr><td><input type="text" name="total" required></td></tr>
                        <tr><td colspan="2"><label>METODO DE PAGO: </label></td></tr>
                        <tr><td>
                                <select name="tipopago">
                                    <option>Seleccione un metodo de pago</option>
                                    <option value="Venta Normal">Venta Normal</option>
                                    <option value="Venta Debito">Venta Debito</option>
                                    <option value="Venta en Cuotas">Venta en Cuotas</option>
                                    <option value="Venta Prepago">Venta Prepago</option>                                
                                </select>
                        </td></tr>
                        <tr><td colspan="2"><label>NUMERO DE PEDIDO: </label></td></tr>
                        <tr><td>
                                <select name="idped">
                                    <option>Seleccione un pedido</option>
                                    <%=cv.getDatosPedidos()%>                        
                                </select>
                        </td></tr>
                        <tr><td colspan="2"><label>ESTADO: </label></td></tr>
                        <tr><td><div id="content" style="padding:20px">
                            <label>Pagado</label>
                                <input type="radio" id="Disponible" name="state" value="Pagado" style="margin-right: 10px" required>
                            <label>Pendiente</label>
                                <input type="radio" id="nodisponible" name="state" value="Pendiente" required>
                        </div></td></tr>
                        <tr><td><input type="submit" value="Registrar Venta"/></td></tr>
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
                    </table>   
                </form>
            <a href="javascript:window.history.go(-1);" style="float:left; border:2px black solid; background-color:gainsboro;">Volver al listado</a>
        </center>
    </body>
</html>
