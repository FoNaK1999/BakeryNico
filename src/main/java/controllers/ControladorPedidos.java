package controllers;

import classes.Pedido;
import classes.ProductosSolicitados;
import classes.Venta;
import classes.solicitar;
import java.sql.SQLException;
import models.ModeloFactura;
import models.ModeloPedidos;

public class ControladorPedidos {        
    public String getPedidos() throws SQLException{
        ModeloPedidos mp = new ModeloPedidos();
//        ControladorPedidos cp = new ControladorPedidos();
//        htmlcode2 = cp.getPedidos2();
        String htmlcode = "";       
            for(Pedido pedido : mp.getListPedidos()){               
                    htmlcode += "<tr>\n" +
                    "                  <th scope=\"row\">"+pedido.getId()+"</th>\n" +
                    "                       <td>"+pedido.getFecha()+"</td>\n" +
                    "                       <td>"+pedido.getRutcliente()+"</td>\n" +
                    "                       <td>"+pedido.getEstado()+"</td>\n" +
                    "                       <td>"+pedido.getMatricula()+"</td>\n"+
                    "                       <td><a href='VerProductos.jsp?pedido="+pedido.getId()+"'>VER</a></td>\n"+
                    "                       <td><a href='FormularioUpdatePedido.jsp?id="+pedido.getId()+"&fecha="+pedido.getFecha()+"&rutcliente="+pedido.getRutcliente()+"&estado="+pedido.getEstado()+"&matricula="+pedido.getMatricula()+"'>Modificar</a><br><br><form action='BorrarPedido' method='post'><input type='text' name='hidden' style='display:none;' value='"+pedido.getId()+"'><input type='submit' value='Eliminar'></form></td>\n" +                    
                    "                  </tr>";
        }
        return htmlcode;        
    }
    
    public String VerDatosPedidoProductos(int idpedido) throws SQLException{
            ModeloFactura mf = new ModeloFactura();      
            String htmlcode2 = "";       
                for(ProductosSolicitados soli : mf.getListSolicitar(idpedido)){               
                    htmlcode2 += "<li class=\"list-group-item\"><strong>Nombre producto: </strong>"+soli.getNombreProd()+"          |          "+"<strong>CANTIDAD: </strong>"+soli.getCantidadProd()+"</li>";
                }
            return htmlcode2;        
    }
    

    public String VerPedidosCombobox() throws SQLException{
            ModeloPedidos mp3 = new ModeloPedidos();      
            String htmlcode3 = "";       
                for(Pedido pedido : mp3.getListPedidos()){               
                    htmlcode3 += "<option value="+pedido.getId()+">"+pedido.getId()+"</option>";
                }
            return htmlcode3;        
    }

    
    
    
}
