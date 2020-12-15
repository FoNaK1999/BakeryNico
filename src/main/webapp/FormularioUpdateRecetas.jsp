<%@page import="models.ModeloRecetas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ModeloRecetas mr= new ModeloRecetas();%>
<% 
    int id = Integer.parseInt(request.getParameter("id"));
    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");
    String ingredientes = request.getParameter("Ingredientes");
    String estado = request.getParameter("estado");
    


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html" charset=UTF-8" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Modificar Receta</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script type="text/javascript">
	function showContent() {
		element = document.getElementById("content");
		check = document.getElementById("check");
		if (check.checked) {
			element.style.display='block';
		}
		else {
			element.style.display='none';
		}
	}
	</script>
        
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
            <h1 align="center">Modificar Receta</h1>
                <form action="ActualizarReceta" method="post" enctype="multipart/form-data">
                    <table>
                        <!--ID-->  
                        <tr><td colspan="2"><label>ID Receta: </label></td></tr>
                        <tr><td><input type="text" name="idrc2" value="<%=id%>" required readonly="readonly"></td></tr>
                        <!--Nombre-->  
                        <tr><td colspan="2"><label>Nombre Receta: </label></td></tr>
                        <tr><td><input type="text" name="nombrerc2" value="<%=nombre%>" required></td></tr>
                        <!--Descripcion-->  
                        <tr><td colspan="2"><label>Descripcion Receta: </label></td></tr>
                        <tr><td><input type="text" name="descripcionrc2" value="<%=descripcion%>" required></td></tr>
                        <!--Ingredientes-->  
                        <tr><td colspan="2"><label>Cambiar Ingredientes: </label></td></tr>
                        <tr><td><input type="text" name="ingredientesrc2"value="<%=ingredientes%>" required></td></tr>
                        <!--Imagen-->  
                        <tr><td colspan="2"><label>Imagen (Tamaño recomendado 268x249): </label></td></tr>
                        <tr><td><input type="file" name="imagenrc2"></td></tr>
                        <!--Estado-->    
                        <tr><td><label colspan="2">Cambiar estado:</label></td></tr>
                        <tr><td><div id="content" style="padding:20px">
                            <label>Disponible</label>
                                <input type="radio"  name="staterc2" value="Disponible" style="margin-right: 10px" required>
                            <label>No Disponible</label>
                                <input type="radio"  name="staterc2" value="No Disponible" required>
                                </div></td></tr>
                        <!--Boton Actualizar-->  
                        <tr><td><input type="submit" value="Actualizar"/></td></tr>
                    </table>
                </form>
            <a href="javascript:window.history.go(-1);" style="float:left; border:2px black solid; background-color:gainsboro;">Volver al listado</a>
        </center>
    </body>
</html>

