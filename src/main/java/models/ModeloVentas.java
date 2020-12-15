package models;

import classes.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloVentas extends Conexion {
    
    public ArrayList<Venta> getAllVentas() throws SQLException{
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
    
    public boolean RegistrarVenta(String id, String fecha, int total, String tipopago, String estado, int idpedido){
        PreparedStatement pst = null;
        try{
        String sql = "insert into venta (id_v,fecha_v,total_v,tipopago_v,estado_dv,id_ped_v) values (?,?,?,?,?,?)";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, id);
        pst.setString(2, fecha);
        pst.setInt(3, total);
        pst.setString(4, tipopago);
        pst.setString(5, estado);
        pst.setInt(6, idpedido);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al insertar venta");
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
    
    public boolean UpdateVenta(String id,String fecha, int total, String tipopago, String estado){
        PreparedStatement pst = null;
        try{
        String sql = "update venta set fecha_v = ?, total_v = ?, tipopago_v = ?, estado_dv = ? where id_v = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, fecha);
        pst.setInt(2, total);
        pst.setString(3, tipopago);
        pst.setString(4, estado);
        pst.setString(5, id);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al modificar venta");
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
    
        public boolean BorrarVenta(String id){
        PreparedStatement pst = null;
        try{
        String sql = "update venta set estado_dv = 'Eliminado' where id_v = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, id);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al eliminar venta");
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
        
    
    
}
