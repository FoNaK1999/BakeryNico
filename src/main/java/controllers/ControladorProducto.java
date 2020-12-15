/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Producto;
import java.sql.SQLException;
import models.ModeloProducto;

/**
 *
 * @author Martin
 */
public class ControladorProducto {
    public String getProductos(int idcat) throws SQLException{
        ModeloProducto mp = new ModeloProducto();
        String htmlcode = "";       
        for(Producto producto : mp.getAllProductos(idcat)){
            htmlcode += "<div class=\"col-sm-4\">\n" +
"							<div class=\"product-image-wrapper\">\n" +
"								<div class=\"single-products\">\n" +
"									<div class=\"productinfo text-center\">\n" +
"										<img src=\""+producto.getImg()+"\" alt=\"\" />\n" +
"										<h2>$"+producto.getPrecio()+"</h2>\n" +
"										<p>"+producto.getNombre()+"</p>\n" +
"										<a href=\"product-details.jsp?id="+producto.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver detalles</a>\n" +
"									</div>\n" +
"									<div class=\"product-overlay\">\n" +
"										<div class=\"overlay-content\">\n" +
"											<h2>$"+producto.getPrecio()+"</h2>\n" +
"											<p>"+producto.getNombre()+"</p>\n" +
"											<a href=\"product-details.jsp?id="+producto.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalles</a>\n" +
"										</div>\n" +
"									</div>\n" +
"								</div>\n" +
"								<div class=\"choose\">\n" +
"									<ul class=\"nav nav-pills nav-justified\">\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to wishlist</a></li>\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to compare</a></li>\n" +
"									</ul>\n" +
"								</div>\n" +
"							</div>\n" +
"						</div>";
        }        
        return htmlcode;        
    }
    
    //Mantenedor
    public String getListadoProductos() throws SQLException{
        ModeloProducto mp = new ModeloProducto();
        String htmlcode = "";       
        for(Producto producto : mp.getListProductos()){
            htmlcode += "<tr>\n" +
"                             <td class=\"column1\">"+producto.getId()+"</>\n" +
"                             <td class=\"column1\">"+producto.getNombre()+"</td>\n" +
"                             <td class=\"column1\">"+producto.getDescripcion()+"</td>\n" +
"                             <td class=\"column1\"><img src="+producto.getImg()+" width='100px' height='100px'></td>\n" +
"                             <td class=\"column1\">"+producto.getCategoria()+"</td>\n" +
"                             <td class=\"column1\">"+producto.getPrecio()+"</td>\n" +
"                             <td class=\"column1\">"+producto.getStock()+"</td>\n" +
"                             <td class=\"column1\">"+producto.getEstado()+"</td>\n" +
"                             <td class=\"column1\"><a href='FormularioUpdateProducto.jsp?id="+producto.getId()+"&nombre="+producto.getNombre()+"&descripcion="+producto.getDescripcion()+"&categoria="+producto.getCategoria()+"&precio="+producto.getPrecio()+"&stock="+producto.getStock()+"'>Modificar</a><br><br><form action='borro' method='post'><input type='text' name='hidden' style='display:none;' value='"+producto.getId()+"'><input type='submit' value='Eliminar'></form></td>\n" +
"                       </tr>";
        }        
        return htmlcode;        
    }
    //Fin mantenedor
    
        public String getListadoProductosRegistrarPedido() throws SQLException{
        ModeloProducto mp = new ModeloProducto();
        String htmlcode = "";       
        for(Producto producto : mp.getListProductos()){
            htmlcode += "<tr>\n" +
"                             <td class=\"column1\">"+producto.getId()+"</>\n" +
"                             <td class=\"column1\">"+producto.getNombre()+"</td>\n" +
"                             <td class=\"column1\">"+producto.getStock()+"</td>\n" +
"                       </tr>";
        }        
        return htmlcode;        
    }
    
        //Combobox Ingresar Pedido
        public String getDatosProductos() throws SQLException{
            ModeloProducto mp = new ModeloProducto();
            String htmlcode = "";       
            for(Producto producto : mp.getListProductos()){
                htmlcode += "<option value="+producto.getId()+">"+producto.getNombre()+"</option>";
            }        
            return htmlcode;  
    }
    
    
    
    
    public Producto getProducto(int id){
        return new ModeloProducto().getProducto(id);
    }
}
