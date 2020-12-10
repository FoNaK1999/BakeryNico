package classes;

public class ProductosSolicitados {
    
    private String nombreProd;
    private int cantidadProd;
    
    public ProductosSolicitados(String nombreProd, int cantidadProd){
        this.nombreProd = nombreProd;
        this.cantidadProd = cantidadProd;
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
    
    
}
