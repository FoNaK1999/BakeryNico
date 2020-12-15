/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Receta;
import java.sql.SQLException;
import models.ModeloRecetas;

/**
 *
 * @author marti
 */
public class ControladorReceta {
        public String getListadoRecetas() throws SQLException{
        ModeloRecetas mr = new ModeloRecetas();
        String htmlcode = "";       
        for(Receta recetas : mr.getAllRecetas()){
            htmlcode += "<tr>\n" +
"                             <td class=\"column1\">"+recetas.getId()+"</td>\n" +
"                             <td class=\"column1\">"+recetas.getNombre()+"</td>\n" +
"                             <td class=\"column1\">"+recetas.getDescripcion()+"</td>\n" +
"                             <td class=\"column1\">"+recetas.getIngredientes()+"</td>\n" +
"                             <td class=\"column1\"><img src="+recetas.getImagen()+" width='100px' height='100px'></td>\n" +
"                             <td class=\"column1\">"+recetas.getEstado()+"</td>\n" +
"                             <td class=\"column1\"><a href='FormularioUpdateRecetas.jsp?id="+recetas.getId()+"&nombre="+recetas.getNombre()+"&descripcion="+recetas.getDescripcion()+"&Ingredientes="+recetas.getIngredientes()+"&estado="+recetas.getEstado()+"'>Modificar</a><br><br><form action='BorrarRecetas' method='post'><input type='text' name='hidden' style='display:none;' value='"+recetas.getId()+"'><input type='submit' value='Eliminar'></form></td>\n" +
"                       </tr>";
        }        
        return htmlcode;        
    }
    //Fin mantenedor 
}
