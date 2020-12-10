<%-- 
    Document   : MantenedorChofer
    Created on : 18-11-2020, 16:02:04
    Author     : Nicolas_Herrera
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="controllers.ControladorChofer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%
   ControladorChofer ch = new ControladorChofer();  
%>
<!DOCTYPE html>
<html lang="en">
<head>
        <title>Conductores</title>
        <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!----------------------Inicio Links---------------------------------->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
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
                  <a class="nav-link" href="IngresarChofer.jsp">Ingresar Chofer</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="MantenedorVehiculo.jsp">Mantenedor Vehiculos</a>
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
                    <th scope="col">NOMBRE</th>
                    <th scope="col">R.U.T</th>
                    <th scope="col">FONO</th>
                    <th scope="col">E-MAIL</th>
                    <th scope="col">DIRECCION</th>
                    <th scope="col">ESTADO</th>
                    <th scope="col">ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <%=ch.getDatosChofer()%>
            </tbody>
        </table>

	

<!----------------------Inicio Scripts---------------------------------->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
<!----------------------Fin Scripts------------------------------------->
</body>
</html>