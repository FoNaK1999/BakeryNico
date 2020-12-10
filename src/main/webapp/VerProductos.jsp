<%@page import="controllers.ControladorPedidos"%>
<%@page import="controllers.ControladorFactura"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int idpedido = Integer.parseInt(request.getParameter("pedido")); //href="javascript:window.history.go(-1);"
    ControladorPedidos cp = new ControladorPedidos();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/verproductos.css">
        <title>Termino de Pago</title>
    </head>
    <body>
        <img alt="full screen background image" src="images/home/pasteleriatermino.jpg" id="full-screen-background-image" /> 
        <ul class="list-group" id="Listado">
          <li class="list-group-item active" aria-current="true">Ver Productos del Pedido</li>
            <%=cp.VerDatosPedidoProductos((idpedido))%>
          <li class="list-group-item active" aria-current="true"><button class="btn btn-primary" type="button" onclick="location.href='javascript:window.history.go(-1)'">Volver al Mantenedor</button></li>
        </ul>           
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>
