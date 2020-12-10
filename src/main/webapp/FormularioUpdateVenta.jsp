<%
    String id = request.getParameter("id");
    String fecha = request.getParameter("fecha");
    String total = request.getParameter("total");
    String tipopago = request.getParameter("tipopago");
    String idpedido = request.getParameter("idpedido");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html" charset=UTF-8" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Modificar Pedido</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
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
                <form action="UpdateVenta" method="post">
                    <table>
                        <tr><td colspan="2"><label>ORDEN DE VENTA: </label></td></tr>
                        <tr><td><input type="text" name="id" value="<%=id%>" required readonly="readonly"></td></tr>
                        <tr><td colspan="2"><label>NUMERO PEDIDO: </label></td></tr>
                        <tr><td><input type="text" name="idpedido" value="<%=idpedido%>" required readonly="readonly"></td></tr>
                        <tr><td colspan="2"><label>FECHA: </label></td></tr>
                        <tr><td><input type="date" name="fecha" value="<%=fecha%>" required></td></tr>
                        <tr><td colspan="2"><label>TOTAL: </label></td></tr>
                        <tr><td><input type="text" name="total" value="<%=total%>" required></td></tr>
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
                        <tr><td><label colspan="2">CAMBIAR ESTADO:</label></td></tr>
                        <tr><td><div id="content" style="padding:20px">
                            <label>Pagado</label>
                                <input type="radio"  name="state" value="Pagado" style="margin-right: 10px" required>
                            <label>Pendiente</label>
                                <input type="radio"  name="state" value="Pendiente" required>
                                </div></td></tr>
                        <tr><td><input type="submit" value="Actualizar"/></td></tr>
                    </table>
                </form>
            <a href="javascript:window.history.go(-1);" style="float:left; border:2px black solid; background-color:gainsboro;">Volver al listado</a>
        </center>
    </body>
</html>
