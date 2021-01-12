/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Pedido;
import classes.ProductosSolicitados;
import classes.ProductosSolicitados2;
import classes.solicitar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
 //Buscar factura
public class ModeloFactura extends Conexion{
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
        pst.setString(4, estado);
        pst.executeUpdate();
        return true;
        }catch(SQLException ex){
            System.out.println("Error al obtener solicitud");
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
    
    
    
    public boolean ObtenerVehiculo(){        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        String sql = "select * from vehiculo where estado_ve = 'Disponible'";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();      
        if(rs.absolute(1)){
            return true;
        }
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
    
    public Pedido getPedido(){
        Pedido pedido = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select * from pedidos)";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                pedido = new Pedido(rs.getInt("id_ped"), rs.getString("fecha_ped"),rs.getString("estado_ped"), rs.getString("id_usu_ped"), rs.getString("id_ve_ped"));
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
        return pedido;
        
    }
    
        public int getProductosSolicitados(int id){
        solicitar soli = null;
        PreparedStatement pst = null;
        int idproducto = 0;
        ResultSet rs = null;
        try {
            String sql = "select * from solicitar s, productos p where s.id_ped_sol = ? and p.id_producto = s.id_producto_sol";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while(rs.next()){
                soli = new solicitar(rs.getInt("id_sol"), rs.getInt("cantidad_sol"),rs.getInt("id_producto_sol"), rs.getInt("id_ped_sol"));
                idproducto = rs.getInt("id_producto_sol");
            }
        } catch (Exception e) {
            System.out.println("Error en obtener solicitados");
        } finally{
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (Exception e) {
            }
        }       
        return idproducto;
        
    }
    
    
    public ArrayList<ProductosSolicitados> getListSolicitar(int idpedido) throws SQLException{
        ArrayList<ProductosSolicitados> soli = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select p.nombre_producto, s.cantidad_sol from solicitar s, productos p where s.id_ped_sol = ? and s.id_producto_sol = p.id_producto and estado_sol = 'Activo'";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, idpedido);
            rs = pst.executeQuery();
            while(rs.next()){
                soli.add(new ProductosSolicitados(rs.getString("p.nombre_producto"),rs.getInt("s.cantidad_sol")));
                
            }
        }catch(Exception e){
            System.out.println("Error al obtener listado de solicitar");
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
        return soli;
    }
    
    public int getCantidadRegistros(int id){
        ProductosSolicitados2 soli2 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int cantidad = 0;
        try {
            String sql = "select count(s.id_sol) from solicitar s, productos p where s.id_ped_sol = ? and s.id_producto_sol = p.id_producto and estado_sol = 'Activo'";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                cantidad = rs.getInt("count(s.id_sol)");
//                soli2 = new ProductosSolicitados2(rs.getInt("id_producto"), rs.getString("nombre_producto"),rs.getString("descripcion"), rs.getString("img_producto"), rs.getInt("id_categoria_prod"), rs.getInt("precio_producto"), rs.getInt("stock_producto"),rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener registros");
        } finally{
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (SQLException e) {
            }
        }       
        return cantidad;
        
    }
    
        public ArrayList<ProductosSolicitados2> getListSolicitar2(int idpedido) throws SQLException{
        ArrayList<ProductosSolicitados2> soli = new ArrayList<>();
        Conexion2 con2 = new Conexion2();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select p.nombre_producto, s.cantidad_sol, s.id_producto_sol from solicitar s, productos p where s.id_ped_sol = ? and s.id_producto_sol = p.id_producto and estado_sol = 'Activo'";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, idpedido);
            rs = pst.executeQuery();
            while(rs.next()){
                soli.add(new ProductosSolicitados2(rs.getString("p.nombre_producto"),rs.getInt("s.cantidad_sol"),rs.getInt("s.id_producto_sol")));              
            }
        }catch(SQLException e){
            System.out.println("Error al obtener listado de solicitar");
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
        return soli;
    }
    
    public ArrayList<solicitar> getAllsolicitados() throws SQLException{
        ArrayList<solicitar> soli = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "Select * from solicitar";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                soli.add(new solicitar(rs.getInt("id_sol"),rs.getInt("cantidad_sol"),rs.getInt("id_producto_sol"),rs.getInt("id_ped_sol")));
            }
        }catch(Exception e){
            System.out.println("Error al obtener ventas");
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
        return soli;
    }
    
    
    
    
    
    
    public static void main(String[] args){
       ModeloFactura mf = new ModeloFactura();
       int valor = mf.RegistrarPedido("Disponible", "12.313.123-K", "FS12RT");
       
        System.out.println(valor);        
    }
}
 //Fin Buscar  factura

//UPDATE tabla productos stock_producto= stock_producto -'cantidad' WHERE id_producto='id'