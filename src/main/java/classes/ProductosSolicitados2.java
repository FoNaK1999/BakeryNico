/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author marti
 */
public class ProductosSolicitados2 {
        
    private String nombreProd;
    private int cantidadProd;
    private int idprod;
    
    public ProductosSolicitados2(String nombreProd, int cantidadProd, int idprod){
        this.nombreProd = nombreProd;
        this.cantidadProd = cantidadProd;
        this.idprod = idprod;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }
    
    
}
