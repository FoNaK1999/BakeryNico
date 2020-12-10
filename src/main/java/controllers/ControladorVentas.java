package controllers;

import classes.Pedido;
import classes.Venta;
import java.sql.SQLException;
import models.ModeloPedidos;
import models.ModeloVentas;

public class ControladorVentas {
    
    public String getDatosVenta() throws SQLException{
        ModeloVentas mv = new ModeloVentas();
        String htmlcode = "";       
        for(Venta venta : mv.getAllVentas()){
            htmlcode += "<tr>\n" +
"                  <th scope=\"row\">"+venta.getId()+"</th>\n" +
"                       <td>"+venta.getFecha()+"</td>\n" +
"                       <td>"+venta.getTotal()+"</td>\n" +
"                       <td>"+venta.getTipopago()+"</td>\n" +
"                       <td>"+venta.getEstado()+"</td>\n" +
"                       <td>"+venta.getIdped()+"</td>\n" +
"                       <td><a href='FormularioUpdateVenta.jsp?id="+venta.getId()+"&fecha="+venta.getFecha()+"&total="+venta.getTotal()+"&tipopago="+venta.getTipopago()+"&idpedido="+venta.getIdped()+"'>Modificar</a><br><br><form action='BorrarVenta' method='post'><input type='text' name='hidden' style='display:none;' value='"+venta.getId()+"'><input type='submit' value='Eliminar'></form></td>\n" +                    
"                  </tr>";
        }       
        return htmlcode;        
    }
    
    public String getDatosPedidos() throws SQLException{
        ModeloPedidos mp = new ModeloPedidos();
        String htmlcode = "";           
        for(Pedido pedido : mp.getListPedidos()){
            htmlcode +="<option value="+pedido.getId()+">"+pedido.getId()+"</option>";
        }        
        return htmlcode;        
    }
    
    
}
