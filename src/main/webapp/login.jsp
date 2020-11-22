<%-- 
    Document   : login
    Created on : 10-05-2020, 8:33:04
    Author     : Nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String status = request.getParameter("status");
%>
        
<!DOCTYPE html>
<html>
        <!--Inicio de estilos para el login-->
    <style>
        input[type=text]
        {
            width: 100%;
            padding: 8px 20px;
            border: 2px solid black;
            box-sizing: border-box;
        }
        input[type=password]
        {
            width: 100%;
            padding: 8px 20px;
            border: 2px solid black;
            box-sizing: border-box;
        }
        label{
            font-size:14px;
            font-family: Arial;
            font-weight: bold;
        }
        input [type=submit]
        {
            padding: 8px 10px;
            margin:8px 0px;
            border:solid;
            cursor: pointer;
            width: 40%;
            
        } 
    </style>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <title>Principal</title>
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
                <!--Navbar izquierdo-->
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <a class="nav-link" href="index.html">Casa</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#"></a>
                </li>
              </ul>
                <!--Nabvar centro-->
                <a class="navbar-brand" href="index.html"><img src="img/logo022.png" alt="" width="110" height="100"></a>
                <!--Navbar derecho-->
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href="javascript:window.history.go(-1);">Volver</a>
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
        <center><form method="post" action="validarusuario">
                <table>
                    <tr><td colspan="2"><label>Login</label></td></tr>
                    <tr><td align="center" rowspan="5"></td><td><label>Usuario</label></td></tr>
                    <tr><td><input type="text" name="Mail"/></td></tr>
                    <tr><td><label>Password</label></td></tr>
                    <tr><td><input type="password" name="Password"/></td></tr>
                    <tr><td><input type="submit" value="Ingresar"/></td></tr>
                    <br>
                    <a href="Registro.jsp">¿No tiene una cuenta?</a>
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
        </form></center>
    </body>
</html>
