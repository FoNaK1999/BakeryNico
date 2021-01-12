/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Ingredientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class ModeloIngredientes extends Conexion {
    public ArrayList<Ingredientes> getListIngredientes() throws SQLException{
        ArrayList<Ingredientes> ingredientes = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select * from ingredientes";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                ingredientes.add(new Ingredientes(rs.getInt("codigo_ing"),rs.getString("nombre_ing"),rs.getInt("cantidad_ing"),rs.getString("estado_ing"),rs.getString("rut_prov_ing")));
            }
        }catch(SQLException e){
            System.out.println("Error al obtener Ingredientes");
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
        return ingredientes;
    }
    
    public int RegistrarIngrediente(String nombre, int cantidad,String estado, String rut){
        PreparedStatement pst = null;
        ResultSet rs = null;
        int lastid = -1;
        try{
        String sql = "insert into ingredientes (nombre_ing,cantidad_ing,rut_prov_ing,estado_ing) values (?,?,?,?)";
        pst = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, nombre);
        pst.setInt(2, cantidad);
        pst.setString(3, rut);
        pst.setString(4, estado);
        pst.executeUpdate();
        
        rs = pst.getGeneratedKeys();
                
        if (rs.next()){
            lastid=rs.getInt(1);
                                
        }
        return lastid;
        
        }catch(SQLException ex){
            System.out.println("Error al insertar ingrediente"+ ex);
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
        
        return lastid;
    }
    
        public boolean RegistrarIngredienteProp(int idprop, String rutprov){
        PreparedStatement pst = null;
        try{
        String sql = "insert into proporciona (rut_prov_prop, id_ing_prop) values (?,?)";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, rutprov);
        pst.setInt(2, idprop);
        pst.executeUpdate();
        return true;
        }catch(SQLException ex){
            System.out.println("Error al insertar proporcionar"+ ex);
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
    
    
    public boolean UpdateIngrediente(int codigo, String nombre, int cantidad, String rut, String estado){
        PreparedStatement pst = null;
        try{
        String sql = "update ingredientes set nombre_ing = ?, cantidad_ing = ?, estado_ing = ? ,rut_prov_ing = ? where codigo_ing = ?";
        pst = getConnection().prepareStatement(sql);       
        pst.setString(1, nombre);
        pst.setInt(2, cantidad);
        pst.setString(3, estado);
        pst.setString(4, rut);
        pst.setInt(5, codigo);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al modificar ingrediente");
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

        public boolean BorrarIngrediente(int codigo){
        PreparedStatement pst = null;
        try{
        String sql = "update ingredientes set estado_ing = 'Eliminado' where codigo_ing = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.executeUpdate();
        return true;
        }catch(SQLException ex){
            System.out.println("Error al eliminar ingrediente");
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
}
