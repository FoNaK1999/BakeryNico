<%-- 
    Document   : contactanos
    Created on : Jun 16, 2020, 2:31:25 PM
    Author     : Happy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .map{
        margin-bottom: 50px;
        margin-top: 50px;
    }
    .pies{
        margin-top: -200px;
    }
    footer{
        background-color:black;
        width:100%;
        height:150px;
    }
    .copyright p{
        color:white;
    }
    .txt h3{
        color:white;
        font-size:10px;
    }
    nav ul ol a{
	color:white;
	float:right;
	margin:5px;
}
</style>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/contactanos.css" rel="stylesheet" type="text/css"/>
        <title>Contactanos</title>
        <link rel="shortcut icon" href="img/panaderia1.png" type="image/png">
    </head>
    <body background="img/contactanosfont4.jpg" width="50%" height="50%"  background-attachment="fixed">
        <!--Inicio de barra de categorias-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!--<a class="navbar-brand container" href="#">Navbar</a>-->

            <div class="collapse navbar-collapse" id="navbarSupportedContent" >
                <!--Navbar izquierdo-->
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="index.html">Casa</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="shop.jsp?idcat=1">Panes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="shop.jsp?idcat=2">Pasteles</a>
                    </li>
                </ul>
                <!--Nabvar centro-->
                <a class="navbar-brand" href="index.html"><img src="img/logo022.png" alt="" width="110" height="100" id="imgsuperior"></a>
                <!--Navbar derecho-->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Recetas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contactanos.jsp">Contactanos</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!--fin de Inicio de barra de categorias-->

        <!--Inicio de baner de contactanos-->
        <div id="main" class="site-main extra">
            <div class="page-title header" style="background-position: 100% -42px;">
                <div class="page-title-inner">
                    <h3 class="entry-title-main">Contactanos</h3>
                    <div class="breadcrumbs">
                        <p id="breadcrumbs"><span><span><a href="index.html" color="white">Casa</a> / <span class="breadcrumb_last" aria-current="page">Contactanos</span></span></span></p>  
                    </div>
                </div>
            </div>
        </div>
        <!--Fin de baner de contactanos-->


    <center>
        <div class="pies">
            <img src="img/bakeyniko.jpg" alt=""/>
        </div>
        <div class="map">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3355.6400113065674!2d-70.72503101969747!3d-32.74874837284326!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x968816cf5674b55b%3A0x7946037ea76b9002!2sPanaderia%20Moderna!5e0!3m2!1ses!2scl!4v1608499248084!5m2!1ses!2scl" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>        
        </div>
    </center>
</body>
<!--Pie de pagina-->
<footer class="m-footer-bottom section-expand b3">
    <div class="container-fluid">
        <div class="copyright">
            <p>Copyright 2018-2025©</p>
            <div class="txt">	
                <h3>Pagina amparada por la ley N 17.336 que protege los derechos que, por el solo hecho de la creacion de la obra,</h3>
                <h3> adquieren los autores de obras de la inteligencia en los dominios literarios,</h3>	
                <h3> artistico y cientificos, cualquiera sea su forma de expresion, y los derechos conexos que ella determina.</h3>
            </div>	
            <nav>
                <ul>
                    <ol><a href=index.html>Inicio</a></ol>
                    <ol><a href=index.html>Destacados</a></ol>
                    <ol><a href="#imgsuperior">Subir</a></ol>
                </ul>   
            </nav>
        </div>
    </div>
</footer>
</html>
