/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Receta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class ModeloRecetas extends Conexion {
    public ArrayList<Receta> getAllRecetas() throws SQLException {
        ArrayList<Receta> recetas = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "Select * from recetas";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                recetas.add(new Receta(rs.getInt("id_rc"), rs.getString("nombre_rc"), rs.getString("descripcion_rc"), rs.getString("Ingrediente_rc"), rs.getString("imagen_rc"), rs.getString("estado_rc")));
            }
        } catch (SQLException e) {
            System.out.println("Error en 1°catch Modelo recetas");
        } finally {
            try {
                if (rs != null) {
                    if (pst != null) {
                        if (getConnection() != null) {
                            getConnection().close();
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error");
            }
        }
        return recetas;
    }

    //Registro
    public boolean RegistrarRecetas(int id, String nombre, String descripcion, String ingrediente, String archivo, String estado) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

            String sql = "insert into recetas (id_rc, nombre_rc, descripcion_rc, ingrediente_rc, imagen_rc, estado_rc) values (?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, nombre);
            pst.setString(3, descripcion);
            pst.setString(4, ingrediente);
            pst.setString(5, archivo);
            pst.setString(6, estado);
            pst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println("Error en los datos del Modelo Recetas");
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {

            }
        }
        return false;
    }
//Update

    public boolean UpdateReceta2(int id, String nombre, String descripcion, String ingrediente, String imagen, String estado){
        PreparedStatement pst = null;
        Conexion2 con2 = new Conexion2();
        
        try{
        String sql = "update recetas set nombre_rc = ?, descripcion_rc = ?, Ingrediente_rc = ?, imagen_rc = ?, estado_rc = ? where id_rc = ?";
        pst = con2.conectarMySQL().prepareStatement(sql);       
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        pst.setString(3, ingrediente);
        pst.setString(4, imagen);
        pst.setString(5, estado);
        pst.setInt(6, id);
        pst.executeUpdate();
        return true;
        
        }catch(SQLException ex){
            System.out.println("Error al modificar Receta"+ ex);
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

    //Borrar 
    public boolean BorrarReceta(int id) {
        PreparedStatement pst = null;
        try {
            String sql = "update recetas set estado_rc = 'Eliminado' where id_rc = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Receta");
        } finally {
            try {
                if (pst != null) {
                    if (getConnection() != null) {
                        getConnection().close();
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error en modelo receta: zona borrar");
            }

        }

        return false;
    }
    
        public Receta getReceta(int id){
        Receta recetas = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select * from recetas where id_rc = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                recetas = new Receta(rs.getInt("id_rc"), rs.getString("nombre_rc"),rs.getString("descripcion_rc"), rs.getString("Ingrediente_rc"), rs.getString("imagen_rc"),rs.getString("estado_rc"));
            }
        } catch (SQLException e) {
            
        } finally{
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (SQLException e) {
            }
        }       
        return recetas;
        
    }
        
    public static void main(String[] args) {
        ModeloRecetas mr = new ModeloRecetas();
        
        System.out.println(mr.UpdateReceta2(2, "Hola", "Descripcion", "Ingredientes", "images\\home\\goofy-high-face.jpg", "Disponible"));
    }
        
}
