/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Pedido;
import classes.Producto;
import classes.Proveedor;
import classes.Venta;
import classes.vehiculo;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class ModeloPedidos extends Conexion {
    //Flujo cliente
    public int RegistrarPedido(String estado, String rutCliente, String matricula){
        PreparedStatement pst = null;
        ResultSet rs = null;
        int lastid = -1;
        
        
        try{
            
                String sql = "insert into pedidos (fecha_ped, estado_ped, id_usu_ped, id_ve_ped) values (CURDATE(),?,?,?)";
                pst = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                pst.setString(1,estado);
                pst.setString(2,rutCliente);
                pst.setString(3,matricula);
                pst.executeUpdate();

                
                
                rs = pst.getGeneratedKeys();
                
                if (rs.next()){
                    lastid=rs.getInt(1);
                                
                }
                return lastid;
                
        }catch(SQLException ex){
            System.out.println("Error en los datos del pedido");
        }finally{
            try{
                if(getConnection() != null){
                    getConnection().close();
                }
                if(pst != null){
                    pst.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(SQLException ex){
                
            }
        }
        return lastid;
    }
   
    public boolean UpdateStock(int cantidad,int idprod){        
        PreparedStatement pst = null;
        
        System.out.println(cantidad+" "+idprod);
        
        try{
        String sql = "UPDATE productos set stock_producto = stock_producto - ? WHERE id_producto = ? ";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1,cantidad);
        pst.setInt(2, idprod);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al obtener producto");
        }finally{
            try{
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
            }catch(Exception e){
                System.out.println("Error");
            }
        
        }
      return false;
    }
    
    public boolean RegistrarSolicitar(int idprod, int cantidad, int idped, int rows, String estado){        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        String sql = "insert into solicitar (cantidad_sol,id_producto_sol,id_ped_sol,estado_sol) values (?,?,?,?)";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1,cantidad);  
        pst.setInt(2,idprod);  
        pst.setInt(3,idped);
        pst.setString(4,estado);
        pst.executeUpdate();
        return true;
        }catch(SQLException ex){
            System.out.println("Error al registrar solicitud");
        }finally{
            try{
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
            }catch(Exception e){
                System.out.println("Error");
            }
        
        }
      return false;
    }
    //Insercion en tabla venta
    public boolean RegistrarVenta(int total, String tipopago, String estado, int idped){        
        PreparedStatement pst = null;
        ResultSet rs = null;   
        try{
        String sql = "insert into venta (fecha_v, total_v, tipopago_v, estado_dv, id_ped_v) values (CURDATE(),?,?,?,?)";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, total);
        pst.setString(2, tipopago);
        pst.setString(3, estado);
        pst.setInt(4, idped);
        pst.executeUpdate();
        return true;
        }catch(SQLException ex){
            System.out.println("Error al registrar venta");
        }finally{
            try{
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
            }catch(SQLException e){
                System.out.println("Error");
            }
        
        }
      return false;
    }
    
    
   
    
public String getAllAutoPatente() throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        String patente = "";
        try{
            String sql = "select * from vehiculo where estado_ve = 'Disponible'";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                patente = rs.getString("matricula_ve");
            }
        }catch(SQLException e){
            System.out.println("Error al obtener patente vehiculo");
        }finally{
            try{
                if(rs != null){
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
                }
            }catch(SQLException e){
                System.out.println("Error");
            }
        }
         return patente;
    }    
    
    public ArrayList<Venta> getListVenta() throws SQLException{
        ArrayList<Venta> venta = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select * from venta";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                venta.add(new Venta(rs.getString("id_v"),rs.getString("fecha_v"),rs.getInt("total_v"),rs.getString("tipopago_v"),rs.getString("estado_dv"),rs.getInt("id_ped_v")));
            }
        }catch(Exception e){
            System.out.println("Error");
        }finally{
            try{
                if(rs != null){
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
                }
            }catch(Exception e){
                System.out.println("Error");
            }
        }
        return venta;
    }
    
        public ArrayList<Pedido> getListPedidos() throws SQLException{
        Conexion2 con2 = new Conexion2();
        ArrayList<Pedido> pedido = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select * from pedidos";
            pst = con2.conectarMySQL().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                pedido.add(new Pedido(rs.getInt("id_ped"),rs.getString("fecha_ped"),rs.getString("estado_ped"),rs.getString("id_usu_ped"),rs.getString("id_ve_ped")));
            }
        }catch(Exception e){
            System.out.println("Error en obtener los pedidos");
        }finally{
            try{
                if(rs != null){
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
                }
            }catch(Exception e){
                System.out.println("Error");
            }
        }
        return pedido;
    }
        
        public boolean UpdatePedido(int id, String fecha, String estado, String rutcliente, String matricula){        
        PreparedStatement pst = null;       
        
        try{
        String sql = "UPDATE pedidos set fecha_ped = ?, estado_ped = ?, id_usu_ped = ?, id_ve_ped = ? where id_ped = ? ";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, fecha);
        pst.setString(2, estado);
        pst.setString(3, rutcliente);
        pst.setString(4, matricula);
        pst.setInt(5, id);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al actualizar pedido");
        }finally{
            try{
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
            }catch(Exception e){
                System.out.println("Error");
            }
        
        }
      return false;
    }
        
        public boolean BorrarPedido(int id){        
        PreparedStatement pst = null;       
        
        try{
        String sql = "UPDATE pedidos set estado_ped = 'Eliminado' where id_ped = ? ";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al borrar pedido");
        }finally{
            try{
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
            }catch(Exception e){
                System.out.println("Error");
            }
        
        }
      return false;
    }
        
    public boolean BorrarSolicitarProducto(int idproducto, int idped){        
        PreparedStatement pst = null;       
        
        try{
        String sql = "UPDATE solicitar set estado_sol = 'Eliminado' where id_ped_sol = ? and id_producto_sol = ? ";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, idped);
        pst.setInt(2, idproducto);
        pst.executeUpdate();
        return true;
        }catch(SQLException ex){
            System.out.println("Error al borrar producto de solicitar");
        }finally{
            try{
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
            }catch(Exception e){
                System.out.println("Error");
            }
        
        }
      return false;
    }
    
    public boolean UpdateStockQuitar(int idproducto, int idped){        
        PreparedStatement pst = null;       
        
        try{
        String sql = "UPDATE productos set stock_producto = stock_producto + ? WHERE id_producto = ? ";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, idped);
        pst.setInt(2, idproducto);
        pst.executeUpdate();
        return true;
        }catch(SQLException ex){
            System.out.println("Error al borrar producto de solicitar");
        }finally{
            try{
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
            }catch(Exception e){
                System.out.println("Error");
            }
        
        }
      return false;
    }
    
    
    public int RegistrarPedidoFormulario(String fecha,String estado, String rutCliente, String matricula){
        PreparedStatement pst = null;
        ResultSet rs = null;
        int lastid = -1;
        
        
        try{
            
                String sql = "insert into pedidos (fecha_ped, estado_ped, id_usu_ped, id_ve_ped) values (?,?,?,?)";
                pst = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                pst.setString(1,fecha);
                pst.setString(2,estado);
                pst.setString(3,rutCliente);
                pst.setString(4,matricula);
                pst.executeUpdate();

                
                
                rs = pst.getGeneratedKeys();
                
                if (rs.next()){
                    lastid=rs.getInt(1);
                                
                }
                return lastid;
                
        }catch(SQLException ex){
            System.out.println("Error en los datos del pedido");
        }finally{
            try{
                if(getConnection() != null){
                    getConnection().close();
                }
                if(pst != null){
                    pst.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(SQLException ex){
                
            }
        }
        return lastid;
    }
    
    //Obtiene el stock de un producto
    public int getStockProducto(int id){
        Producto producto = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int stock = 0;
        try {
            String sql = "select * from productos where id_productos = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                producto = new Producto(rs.getInt("id_producto"), rs.getString("nombre_producto"),rs.getString("descripcion"), rs.getString("img_producto"), rs.getInt("id_categoria_prod"), rs.getInt("precio_producto"), rs.getInt("stock_producto"),rs.getString("estado"));
                stock = rs.getInt("stock_producto");
            }
        } catch (Exception e) {
            
        } finally{
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (Exception e) {
            }
        }       
        return stock;
        
    }
        
    
    public static void main(String[] args){
       ModeloPedidos mf = new ModeloPedidos();
       int total = 1500;
       int idped = 66;              
    }
}
