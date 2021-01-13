package models;

import classes.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloProducto extends Conexion {
    
    public ArrayList<Producto> getAllProductos(int idcat) throws SQLException{
        ArrayList<Producto> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM productos WHERE estado = 'Disponible' and id_categoria_prod = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1,idcat);
            rs = pst.executeQuery();
            while(rs.next()){
                productos.add(new Producto(rs.getInt("id_producto"),rs.getString("nombre_producto"),rs.getString("descripcion"),rs.getString("img_producto"),rs.getInt("id_categoria_prod"),rs.getInt("precio_producto"),rs.getInt("stock_producto"),rs.getString("estado")));
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
        return productos;
    }
    
    public ArrayList<Producto> getListProductos() throws SQLException{
        ArrayList<Producto> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select * from productos";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                productos.add(new Producto(rs.getInt("id_producto"),rs.getString("nombre_producto"),rs.getString("descripcion"),rs.getString("img_producto"),rs.getInt("id_categoria_prod"),rs.getInt("precio_producto"),rs.getInt("stock_producto"),rs.getString("estado")));
            }
        }catch(SQLException e){
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
            }catch(SQLException e){
                System.out.println("Error");
            }
        }
        return productos;
    }
    
    public Producto getProducto(int id){
        Producto producto = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "call selectProducto(?)";
            pst = getConnection().prepareCall(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                producto = new Producto(rs.getInt("id_producto"), rs.getString("nombre_producto"),rs.getString("descripcion"), rs.getString("img_producto"), rs.getInt("id_categoria_prod"), rs.getInt("precio_producto"), rs.getInt("stock_producto"),rs.getString("estado"));
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
        return producto;
        
    }
        public ArrayList<Producto> getListProductosUpdatePedidos(int idped) throws SQLException{
        ArrayList<Producto> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select * from pedidos pe, productos p, solicitar s where s.id_ped_sol = pe.id_ped and s.id_producto_sol = p.id_producto and pe.id_ped = ? ";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, idped);
            rs = pst.executeQuery();
            while(rs.next()){
                productos.add(new Producto(rs.getInt("id_producto"),rs.getString("nombre_producto"),rs.getString("descripcion"),rs.getString("img_producto"),rs.getInt("id_categoria_prod"),rs.getInt("precio_producto"),rs.getInt("stock_producto"),rs.getString("estado")));
            }
        }catch(SQLException e){
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
            }catch(SQLException e){
                System.out.println("Error");
            }
        }
        return productos;
    }
    
    public int CantidadFilas(){
        
        PreparedStatement pst = null;
        int cantidad=0;
        ResultSet rs = null;
        try{
            
            String sql = "SELECT COUNT(id_producto) FROM productos WHERE estado = 'Disponible' ";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                cantidad = rs.getInt("COUNT(id_producto)");
                return cantidad;
            }
            
        }catch(SQLException ex){
            System.out.println("Error al obtener filas de la tabla productos");
        }
        
        return cantidad;
    }
    
    
    public static void main(String[] args) {
        ModeloProducto mp = new ModeloProducto();
        
        System.out.println(mp.CantidadFilas());
    }
}
