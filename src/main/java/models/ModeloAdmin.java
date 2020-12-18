/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.PreparedStatement;

/**
 *
 * @author Martin
 */
public class ModeloAdmin extends Conexion {
    
    public boolean UpdateProductos(int id, String nombre, String descripcion, String img, int cat, int precio, int stock, String estado){        
        PreparedStatement pst = null;
        System.out.println(id+" "+nombre+" "+descripcion+" "+img+" "+cat+" "+precio+" "+stock+" "+estado);
        
        Conexion2 con2 = new Conexion2();
        try{
        String sql = "update productos set nombre_producto = ? , descripcion = ? , img_producto = ? , id_categoria_prod = ? , precio_producto = ?, stock_producto = ?, estado = ? where id_producto = ?";
        pst = con2.conectarMySQL().prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        pst.setString(3, img);
        pst.setInt(4, cat);
        pst.setInt(5, precio);
        pst.setInt(6, stock);
        pst.setString(7, estado);
        pst.setInt(8, id);
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
    
    public boolean IngresarProducto(String nombre, String descripcion, String img, int categoria, int precio, int stock,String estado){
        PreparedStatement pst = null;
        try{
        String sql = "insert into productos (nombre_producto,descripcion,img_producto,id_categoria_prod,precio_producto,stock_producto,estado) values (?,?,?,?,?,?,?)";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        pst.setString(3, img);
        pst.setInt(4, categoria);
        pst.setInt(5, precio);
        pst.setInt(6, stock);
        pst.setString(7, estado);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al insertar producto");
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
    
    
    
    public boolean Eliminar (int id){
        PreparedStatement pst = null;
        
        try{
            String sql = "UPDATE productos set estado = 'Eliminado' "
                    + "WHERE id_producto = ?";
            
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        }catch(Exception ex){
            System.out.println("Error");
        }
        return false;
    }
}