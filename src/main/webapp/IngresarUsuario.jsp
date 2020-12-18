<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Ingresar Usuario</title>
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

        <h1 align="center">Ingresar Usuario</h1>
        <form action="ingresarUsu" method="post">
            <table>
                <tr><td colspan="2"><label>Rut: </label></td></tr>
                <tr><td><input type="text" maxlength="10" name="idusu" id="rut" onkeyup="validarRut()" required></td></tr>
                <tr><td colspan="2"><label>Nombre Usuario: </label></td></tr>
                <tr><td><input type="text" maxlength="100" name="nombre" required></td></tr>
                <tr><td colspan="2"><label>Apellido Usuarios: </label></td></tr>
                <tr><td><input type="text" maxlength="150" name="apellido" required></td></tr>
                <tr><td colspan="2"><label>Numero Telefonico: </label></td></tr>
                <tr><td><input type="text"  maxlength="9" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="fono" required></td></tr>
                <tr><td colspan="2"><label>Ubicacion: </label></td></tr>
                <tr><td><input type="text" maxlength="500" name="ubicacion" required></td></tr>
                <tr><td colspan="2"><label>Correo Electronico: </label></td></tr>
                <tr><td><input type="text" maxlength="150" name="email" required ></td></tr>
                <tr><td><label colspan="2">Rol:</label></td></tr>
                <tr><td><div id="content" style="padding:20px">
                            <label>Cliente</label>
                            <input type="radio"  name="rol" value="2" style="margin-right: 10px" required>
                            <label>Administrador</label>
                            <input type="radio"  name="rol" value="1" required>
                        </div></td></tr>
                <tr><td colspan="2"><label>Password: </label></td></tr>
                <tr><td><input type="password" maxlength="50" name="pass" required></td></tr>
                <tr><td><input type="submit" value="Registrar usuario"/></td></tr>
            </table>
        </form>
            <a href="javascript:window.history.go(-1);" style="float:left; border:2px black solid; background-color:gainsboro;">Volver al listado</a>
            
        </center>
    <script>
        function validaNumericos(event) {
            if(event.charCode >= 48 && event.charCode <= 57){                             
              return true;
             }
             return false;
        }
        
        function validarRut() {
            var rut = document.getElementById("rut");
   // Despejar Puntos
    var valor = rut.value.replace('.','');
    // Despejar Guión
    valor = valor.replace('-','');
    
    // Aislar Cuerpo y Dígito Verificador
    cuerpo = valor.slice(0,-1);
    dv = valor.slice(-1).toUpperCase();
    
    // Formatear RUN
    rut.value = cuerpo + '-'+ dv
    
    // Si no cumple con el mínimo ej. (n.nnn.nnn)
    if(cuerpo.length < 7) { rut.setCustomValidity("RUT Incompleto"); return false;}
    
    // Calcular Dígito Verificador
    suma = 0;
    multiplo = 2;
    
    // Para cada dígito del Cuerpo
    for(i=1;i<=cuerpo.length;i++) {
    
        // Obtener su Producto con el Múltiplo Correspondiente
        index = multiplo * valor.charAt(cuerpo.length - i);
        
        // Sumar al Contador General
        suma = suma + index;
        
        // Consolidar Múltiplo dentro del rango [2,7]
        if(multiplo < 7) { multiplo = multiplo + 1; } else { multiplo = 2; }
  
    }
    
    // Calcular Dígito Verificador en base al Módulo 11
    dvEsperado = 11 - (suma % 11);
    
    // Casos Especiales (0 y K)
    dv = (dv == 'K')?10:dv;
    dv = (dv == 0)?11:dv;
    
    // Validar que el Cuerpo coincide con su Dígito Verificador
    if(dvEsperado != dv) { rut.setCustomValidity("RUT Inválido"); return false; }
    
    // Si todo sale bien, eliminar errores (decretar que es válido)
    rut.setCustomValidity('');
            
        }
    </script>
    </body>
</html>
