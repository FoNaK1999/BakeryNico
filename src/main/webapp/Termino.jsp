<%@page import="controllers.ControladorFactura"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ControladorFactura cf = new ControladorFactura();
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/termino.css">
        <title>Termino de Pago</title>
    </head>
    <body>
        <img alt="full screen background image" src="images/home/pasteleriatermino.jpg" id="full-screen-background-image" /> 
            <div class="TablaDatos">
                <div class="list-group">
                    <button type="button" class="list-group-item list-group-item-action active" disabled>
                    Gracias por comprar en nuestra tienda.
                  </button>
                  <button type="button" class="list-group-item list-group-item-action" disabled id="codeorder"></button>
                  <button type="button" class="list-group-item list-group-item-action" disabled id="monto"></button>
                  <button type="button" class="list-group-item list-group-item-action" disabled id="tipopago"></button>                  
                  <button type="button" class="list-group-item list-group-item-action" disabled id="fecha"></button>
                  <button type="button" class="list-group-item list-group-item-action" disabled id="reponsecode"></button>
                  <a href="shop.jsp?idcat=1" class="btn btn-primary">Volver al Inicio</a>
                </div>
            </div>            
        <script>
            document.getElementById('monto').innerHTML = "<strong>Monto: </strong>"+localStorage.getItem('amount');
            document.getElementById('codeorder').innerHTML = "<strong>Codigo de orden: </strong>"+localStorage.getItem('codeorder');
            //document.getElementById('reponsecode').innerHTML = "<strong>Response code: </strong>"+localStorage.getItem('responsecode');
            var pagotipo = localStorage.getItem('tipopago');
            switch(pagotipo){
                case "VN":
                    pagotipo = "Venta Normal";
                    document.getElementById('tipopago').innerHTML = "<strong>Metodo de Pago: </strong>"+pagotipo;
                    break;
            }
            var f = new Date();
            document.getElementById('fecha').innerHTML = "<strong>Fecha Pago: </strong>"+(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
        </script>
           
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>
