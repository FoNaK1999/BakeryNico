
package models;
import classes.Administrador;
import classes.Producto;
import classes.Session;
import classes.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloUsuarios extends Conexion {
   
    //Buscar Usuario segun correo , pass y rol para login 
    public boolean Autenticacion(String mail, String pass){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "Select * From cliente where mail_usu = ? and pass_usu = ? and estado_usu= 'Disponible' ";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, mail);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
            
        }catch(SQLException ex){
            System.out.println("Error al obtener Usuarios");
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
            }catch(Exception ex){
                
            }
        }
        return false;
    }   
    //Fin busqueda de usuarios segun correo, pass y rol para login 
    
    
    //Busqueda de administrador segun correo, pass y rol para login
        public boolean AutenticacionAdmin(String mail, String pass){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "Select * From administrador where mail = ? and pass_adm = ? and estado_adm= 'Disponible'";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, mail);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
            
        }catch(SQLException ex){
            System.out.println("Error al obtener Admin");
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
            }catch(Exception ex){
                
            }
        }
        return false;
    }
    //Fin busqueda de administrador segun correo, pass, rol para login.
                         
    //Buscar usuario y mostrar nombre segun correo
        public Session getNombreUsuario(String mail){
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nombre="";
        String apellido="";
        String fono="";
        String id = "";
        Session datos = null;
        try {
            String sql = "select id_usu,nombre_usu,apellido_usu,telefono_usu from cliente where mail_usu= ? ";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, mail);
            rs = pst.executeQuery();
            while(rs.next()){
                id = rs.getString("id_usu");
                nombre = rs.getString("nombre_usu");
                apellido = rs.getString("apellido_usu");
                fono = rs.getString("telefono_usu");
            }
            datos = new Session(id,nombre,apellido,fono,mail);
        } catch (Exception e) {
            
        } finally{
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (Exception e) {
            }
        }       
        return datos;
        
    }
    // Fin buscar usuario y mostrar nombre segun correo
    
    //Insertar Usuario(Cliente)
        
    public boolean RegistrarUsuario(String id, String nombre, String apellido, String fono, String ubicacion, String mail, String pass, String estado){
        PreparedStatement pst = null;
        try{
            String sql = "insert into cliente (id_usu,nombre_usu,apellido_usu,telefono_usu,ubicacion_usu,mail_usu,pass_usu,estado_usu) values (?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setString(4, fono);
            pst.setString(5, ubicacion);
            pst.setString(6, mail);
            pst.setString(7, pass);
            pst.setString(8, estado);
            pst.executeUpdate();
            
            if(pst != null){
                return true;
            }
            
        }catch(SQLException ex){
            System.out.println("Error al insertar registro" + ex);
        }finally{
            try{
                if(getConnection() != null){
                    getConnection().close();
                }
                if(pst != null){
                    pst.close();
                }
            }catch(Exception ex){
                
            }
        }
        return false;                       
    }
    
        public boolean RegistrarAdmin(String id, String nombre, String apellido, String fono, String ubicacion, String mail, String pass, String estado){
        PreparedStatement pst = null;
        try{
            String sql = "insert into administrador (id_adm,nombre_adm,apellido_adm,telefono_adm,ubicacion_adm,mail,pass_adm,estado_adm) values (?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setString(4, fono);
            pst.setString(5, ubicacion);
            pst.setString(6, mail);
            pst.setString(7, pass);
            pst.setString(8, estado);
            pst.executeUpdate();
            
            if(pst != null){
                return true;
            }
            
        }catch(SQLException ex){
            System.out.println("Error al insertar registro" + ex);
        }finally{
            try{
                if(getConnection() != null){
                    getConnection().close();
                }
                if(pst != null){
                    pst.close();
                }
            }catch(Exception ex){
                
            }
        }
        return false;                       
    }
    
    public ArrayList<Usuarios> getListUsuarios() throws SQLException{
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select * from cliente"; 
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                usuarios.add(new Usuarios(rs.getString("id_usu"),rs.getString("nombre_usu"),rs.getString("apellido_usu"),rs.getString("telefono_usu"),rs.getString("ubicacion_usu"),rs.getString("mail_usu"),rs.getString("pass_usu"),rs.getString("estado_usu")));
            }
        }catch(Exception e){
            System.out.println("Error al obtener usuarios");
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
        return usuarios;
    }
    
        public ArrayList<Administrador> getListUsuarios2() throws SQLException{
        ArrayList<Administrador> admin = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select * from administrador"; 
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                admin.add(new Administrador(rs.getString("id_adm"),rs.getString("nombre_adm"),rs.getString("apellido_adm"),rs.getString("telefono_adm"),rs.getString("ubicacion_adm"),rs.getString("mail"),rs.getString("pass_adm"),rs.getString("estado_adm")));
            }
        }catch(SQLException e){
            System.out.println("Error al obtener usuarios");
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
        return admin;
    }
     
    public boolean UpdateUsuarios(String id, String nombre, String apellido, String fono, String ubicacion, String email, String pass,String estado){        
        PreparedStatement pst = null;
        try{
        String sql = "update cliente set nombre_usu = ? , apellido_usu = ? , telefono_usu = ? , ubicacion_usu = ? , mail_usu = ?, pass_usu = ?, estado_usu= ? where id_usu = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, fono);
        pst.setString(4, ubicacion);
        pst.setString(5, email );
        pst.setString(6, pass);
        pst.setString(7, estado);
        pst.setString(8, id);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al obtener usuario");
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
    
    public boolean UpdateAdmin(String id, String nombre, String apellido, String fono, String ubicacion, String email, String pass,String estado){        
        PreparedStatement pst = null;
        try{
        String sql = "update administrador set nombre_adm = ? , apellido_adm = ? , telefono_adm = ? , ubicacion_adm = ? , mail = ?, pass_adm = ?, estado_adm= ? where id_adm = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, fono);
        pst.setString(4, ubicacion);
        pst.setString(5, email );
        pst.setString(6, pass);
        pst.setString(7, estado);
        pst.setString(8, id);
        pst.executeUpdate();
        return true;
        }catch(SQLException ex){
            System.out.println("Error al actualizar administrador");
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
    
   public boolean EliminarUsuario (String id){
        PreparedStatement pst = null;
        try{
            String sql = "UPDATE cliente set estado_usu = 'Eliminado' "
                    + "WHERE id_usu = ?";
            
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error");
        }
        return false;
    }
   
      public boolean EliminarAdmin (String id){
        PreparedStatement pst = null;
        try{
            String sql = "UPDATE administrador set estado_adm = 'Eliminado' "
                    + "WHERE id_adm = ?";
            
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error");
        }
        return false;
    }
        
    //Prueba de conexion y busqueda de usuarios
    public static void main(String[] args) throws SQLException{
       ModeloUsuarios mu = new ModeloUsuarios();
       mu.getListUsuarios2();
    }
    //Fin conexion y busqueda de usuarios

    
}
