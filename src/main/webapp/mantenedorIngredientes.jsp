<%@page import="controllers.ControladorIngredientes"%>
<%
    ControladorIngredientes ci = new ControladorIngredientes();
    String status = request.getParameter("status");
    String code = "<script>alert('Hola');</script>";
%>
<!DOCTYPE html>
<html>
    <head>
	<title>Ingredientes</title>
	<meta http-equiv="Content-type" content="text/html" charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-type" content="text/html" charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
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
                  <a class="nav-link" href="IngresarIngrediente.jsp">Ingresar Ingrediente</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="mantenedorProveedores.jsp">Mantenedor Proveedores</a>
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
                  <th scope="col">CODIGO</th>
                  <th scope="col">NOMBRE</th>
                  <th scope="col">CANTIDAD</th>
                  <th scope="col">ESTADO</th>
                  <th scope="col">RUT PROVEEDOR</th>
                  <th scope="col">ACCIONES</th>
                </tr>
              </thead>
              <tbody>
                  <%=ci.getListadoIngredientes()%>
              </tbody>
        </table>        
        
        
        
        
        
        
        
	<!--<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">CODIGO</th>
								<th class="column1">NOMBRE</th>
								<th class="column1">CANTIDAD</th>
								<th class="column1">ESTADO</th>
                                                                <th class="column1">RUT PROVEEDOR</th>
                                                                <th class="column1">ACCIONES</th>
							</tr>
						</thead>
						<tbody>
                                                    <%=ci.getListadoIngredientes()%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>-->
                    <%
                    if(status=="2"){
                    %>
                    <script>alert("No se ha podido guardar los cambios")</script>
                    <%
                    }else if(status=="1"){
                    %>
                    <script>alert("Guardado con exito")</script>
                    <%
                    }else{    
                    %>
                    
                    <%
                    }  
                    %>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
        
    </body>
</html>
