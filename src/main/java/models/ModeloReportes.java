/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class ModeloReportes extends Conexion {
    
        public ArrayList<Venta> getAllVentasDiarias() throws SQLException{
        ArrayList<Venta> venta = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "Select * from venta";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                venta.add(new Venta(rs.getString("id_v"),rs.getString("fecha_v"),rs.getInt("total_v"),rs.getString("tipopago_v"),rs.getString("estado_dv"),rs.getInt("id_ped_v")));
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
        return venta;
    }
    
    
}
