/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class ModeloVehiculo extends Conexion {
    public ArrayList<vehiculo> getAllAuto() throws SQLException{
        ArrayList<vehiculo> auto = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "Select * from vehiculo";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                auto.add(new vehiculo(rs.getString("matricula_ve"),rs.getString("estado_ve"),rs.getString("rut_ch_ve")));
            }
        }catch(SQLException e){
            System.out.println("Error al obtener vehiculos");
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
        return auto;
    } 
   /*Metodo Ingresar*/
     public boolean RegistrarVehiculo(String matricula,String estado,String rut_chofer){
        PreparedStatement pst = null;
        try{
        String sql = "insert into vehiculo(matricula_ve,estado_ve,rut_ch_ve) values (?,?,?)";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, matricula);
        pst.setString(2, estado);
        pst.setString(3, rut_chofer);
        pst.executeUpdate();
        return true;
        }catch(SQLException ex){
            System.out.println("Error al insertar Vehiculo");
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
     /*Seccion Actualizar*/
    public boolean UpdateVehiculos(String estado,String rutchofer, String matricula){
     PreparedStatement pst = null;
     try{
     String sql="update vehiculo set estado_ve = ?, rut_ch_ve = ? where matricula_ve = ?";
     pst = getConnection().prepareStatement(sql);
     pst.setString(1, estado);
     pst.setString(2, rutchofer);
     pst.setString(3, matricula);
     pst.executeUpdate();
     return true;
     }catch(SQLException ex){
         System.out.println("Error al actualizar datos vehiculo");
     }finally{
         try{
                if(pst !=null){
                    if(getConnection() != null){
                        getConnection().close();
                    }
                }
         }catch(SQLException ex){
             System.out.println("Error en ModeloVehiculo Actualizar");
         }
        
     }
      return false;
    }
    /*Fin Seccion Actualizar*/
    /*================================================================================================================*/
     /*Sección Eliminar*/
     public boolean EliminarVehiculo (String matricula){
        PreparedStatement pst = null;
        try{
            String sql = "UPDATE vehiculo set estado_ve = 'Eliminado' "
                    + "WHERE matricula_ve = ?";
            
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, matricula);
            pst.executeUpdate();
        }catch(Exception ex){
            System.out.println("Error");
        }
        return false;
    }     
}
