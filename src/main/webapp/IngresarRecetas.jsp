<%-- 
    Document   : recetas
    Created on : 24-may-2020, 12:57:50
    Author     : Nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String status = request.getParameter("status");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Ingresar Recetas</title>
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
        <h1 align="center">Ingresar Recetas</h1>
        <form action="RegistrarReceta" method="post" enctype="multipart/form-data">
            <table>
                <tr><td colspan="2"><label>ID Receta: </label></td></tr>
                <tr><td><input type="text" name="idrc" required></td></tr>
                <tr><td colspan="2"><label>Nombre Receta: </label></td></tr>
                <tr><td><input type="text" name="nombrerc" required></td></tr>
                <tr><td colspan="2"><label>Descripcion: </label></td></tr>
                <tr><td><input type="text" name="descripcionrc" required></td></tr>

                <tr><td colspan="2"><label>Ingredientes: </label></td></tr>
                <tr><td><input type="text" name="ingredientec" required></td></tr>
                <tr><td colspan="2"><label>Imagen (Tamaño recomendado 268x249): </label></td></tr>
                <tr><td><input type="file" name="imagenrc" required></td></tr>
                <tr><td><div id="content" style="padding:20px">
                            <label>Disponible</label>
                            <input type="radio" id="Disponible" name="staterc" value="Disponible" style="margin-right: 10px" required>
                            <label>No Disponible</label>
                            <input type="radio" id="nodisponible" name="staterc" value="No Disponible" required>
                        </div></td></tr>
                <!--Boton ingreso datos-->        
                <tr><td><input type="submit" value="Ingresar Receta"/></td></tr>
                        <%
                            if (status != null) {
                        %>
                <p><strong style="color:red;"><%=status%></strong></p>
                    <%
                    } else {
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
