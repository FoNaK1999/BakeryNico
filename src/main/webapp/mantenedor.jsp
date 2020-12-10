<%-- 
    Document   : mantenedor
    Created on : 23-may-2020, 17:00:49
    Author     : Nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!--Inicio Estilos-->
<style>
 
     *{
         margin: 0;
         padding: 0;
      }
      #header{
        background-color: #F9F8FC;
        height: 200px;
        
      }
 
      #logo{
        margin: auto;
        text-align: center;
      }
 
      #logo h1{
         font-family: 'serif';
         font-size: 40px;
       }
     #nav{
       height: 62px;
       background-color:#17181C;
       text-align: center;
     }
 
     #nav ul{
        list-style: none;
        display: inline-block;
     }
 
     #nav ul li{
         float: left;
         margin-top: 20px;
     }
 
     #nav ul li a {
         color: white;
         font-weight: bold;
         text-decoration: none;
         font-size: 20px;
         padding: 20px;
     }
 
     #nav ul li a:hover{
       background-color: #929fb3;
     }
     
     #fondo{
         float:left;
     }
   </style>
   <!--Fin Estilos-->
   <!--Links-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/panaderia1.png" type="image/png">
        <link href="css/mstye.css" rel="stylesheet" type="text/css"/>
        <title>Menu</title>
    </head>
   <!--Inicio Cuerpo-->
  <body>
  <div id="header">
     <div id="logo">  
         <h1>Menu Administrador</h1>  
         <img src="img/logo022.png" alt="FiliDelicias" height="100" width="110"/>
     </div>   
     </div>
     <div id="nav">
       <ul>
         <li><a href="MantenedorProducto.jsp">Ver Productos</a></li>
         <li><a href="mantenedorUsuarios.jsp">Ver Usuarios</a></li>
         <li><a href="mantenedorProveedores.jsp">Ver Proveedores</a></li>
         <li><a href="MantenedorChofer.jsp">Ver Conductores</a></li>
         <li><a href="MantenedorPedidos.jsp">Ver Pedidos</a></li>
         <li><a href="MantenedorVentas.jsp">Ver Ventas</a></li>
         <li><a href="Reportes.jsp">Ver Reportes</a></li>
         <li><a href="#">Mantenedor Recetas</a></li>
       </ul>
     </div>
      <div id="fondo">
          <img src="img/mantenimiento.jpg" alt="Filidelicias" height="50%" width="50%"/>
      </div>
 </body>
    <!--Fin Cuerpo-->
</html>
