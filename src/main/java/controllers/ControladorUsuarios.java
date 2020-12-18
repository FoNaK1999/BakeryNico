package controllers;

import classes.Administrador;
import classes.Usuarios;
import java.sql.SQLException;
import models.ModeloUsuarios;

public class ControladorUsuarios {
    //Crear listado que se mostrara en mantenedor de usuarios
    public String getListadoUsuarios() throws SQLException{
        ModeloUsuarios mu = new ModeloUsuarios();
        String htmlcode = "";       
        for(Usuarios usuarios : mu.getListUsuarios()){
            htmlcode += "<tr>\n" +
"                             <td class=\"column1\">"+usuarios.getId()+"</>\n" +
"                             <td class=\"column1\">"+usuarios.getNombre()+"</td>\n" +
"                             <td class=\"column1\">"+usuarios.getApellido()+"</td>\n" +
"                             <td class=\"column1\">"+usuarios.getFono()+"</td>\n" +
"                             <td class=\"column1\">"+usuarios.getUbicacion()+"</td>\n" +
"                             <td class=\"column1\">"+usuarios.getMail()+"</td>\n" +
"                             <td class=\"column1\">"+usuarios.getPass()+"</td>\n" +
"                             <td class=\"column1\">"+usuarios.getEstado()+"</td>\n" +
"                             <td class=\"column1\"><a href='FormularioUpdateUsuario.jsp?id="+usuarios.getId()+"&nombre="+usuarios.getNombre()+"&Apellido="+usuarios.getApellido()+"&fono="+usuarios.getFono()+"&Ubicacion="+usuarios.getUbicacion()+"&email="+usuarios.getMail()+"&pass="+usuarios.getPass()+"&estado="+usuarios.getEstado()+"'>Modificar</a><br><br><form action='BorrarUsuario' method='post'><input type='text' name='hidden' style='display:none;' value='"+usuarios.getId()+"'><input type='submit' value='Eliminar'></form></td>\n" +
"                       </tr>";
        }        
        return htmlcode;        
    }
    
        public String getListadoUsuarios2() throws SQLException{
        ModeloUsuarios mu = new ModeloUsuarios();
        String htmlcode = "";       
        for(Administrador adm : mu.getListUsuarios2()){
            htmlcode += "<tr id='test'>\n" +
"                             <td class=\"column1\">"+adm.getId()+"</>\n" +
"                             <td class=\"column1\">"+adm.getNombre()+"</td>\n" +
"                             <td class=\"column1\">"+adm.getApellido()+"</td>\n" +
"                             <td class=\"column1\">"+adm.getFono()+"</td>\n" +
"                             <td class=\"column1\">"+adm.getUbicacion()+"</td>\n" +
"                             <td class=\"column1\">"+adm.getMail()+"</td>\n" +
"                             <td class=\"column1\">"+adm.getPass()+"</td>\n" +
"                             <td class=\"column1\">"+adm.getEstado()+"</td>\n" +
"                             <td class=\"column1\"><a href='FormularioUpdateUsuario.jsp?id="+adm.getId()+"&nombre="+adm.getNombre()+"&Apellido="+adm.getApellido()+"&fono="+adm.getFono()+"&Ubicacion="+adm.getUbicacion()+"&email="+adm.getMail()+"&pass="+adm.getPass()+"&estado="+adm.getEstado()+"'>Modificar</a><br><br><form action='BorrarUsuario' method='post'><input type='text' name='hidden' style='display:none;' value='"+adm.getId()+"'><input type='submit' value='Eliminar'></form></td>\n" +
"                       </tr>";
        }        
        return htmlcode;        
    }
    
    public String getRutUsuarios() throws SQLException{
        ModeloUsuarios mus = new ModeloUsuarios();
        String htmlcode = "";           
        for(Usuarios usuarios : mus.getListUsuarios()){
            htmlcode +="<option value="+usuarios.getId()+">"+usuarios.getNombre()+"</option>";
        }        
        return htmlcode;        
    }
    
    
    
}
