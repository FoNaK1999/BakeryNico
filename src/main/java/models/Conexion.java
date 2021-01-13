package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String user="root";
    private String pass="RELrbq70898";
    private String port="3306";
    private String host="localhost";
    private String database="bakerynico";
    private String classname="com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://node61115-env-7271523.jelastic.saveincloud.net/"+database;
    Connection con;
    
    public Conexion(){
        try{
            Class.forName(classname);
            con = DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            System.out.println("Error en la conexion"+ e);
        }
    }
    public Connection getConnection(){
        return this.con;
    }
}   
