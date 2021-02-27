
package beans;


public class Articulos {
    
    private String idArtic;
    private String descripArtic;
    private double precioUnitArtic;
    private int stockArtic;

    public Articulos() {
    }
    
    

    public Articulos(String idArtic, String descripArtic, double precioUnitArtic, int stockArtic) {
        this.idArtic = idArtic;
        this.descripArtic = descripArtic;
        this.precioUnitArtic = precioUnitArtic;
        this.stockArtic = stockArtic;
    }
    
    

    public String getIdArtic() {
        return idArtic;
    }

    public void setIdArtic(String idArtic) {
        this.idArtic = idArtic;
    }

    public String getDescripArtic() {
        return descripArtic;
    }

    public void setDescripArtic(String descripArtic) {
        this.descripArtic = descripArtic;
    }

    public double getPrecioUnitArtic() {
        return precioUnitArtic;
    }

    public void setPrecioUnitArtic(double precioUnitArtic) {
        this.precioUnitArtic = precioUnitArtic;
    }

    public int getStockArtic() {
        return stockArtic;
    }

    public void setStockArtic(int stoclArtic) {
        this.stockArtic = stoclArtic;
    }
    
    
    
    
    
    
}
