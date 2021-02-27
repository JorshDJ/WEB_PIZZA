
package beans;


public class Compra extends Articulos{
    
    private int cantidad;
    
    public double total(){
       return cantidad*super.getPrecioUnitArtic();
   }
    public Compra() {
   }
     
     
     
    public Compra(int cantidad, String idArtic, String descripArtic, double precioUnitArtic, int stockArtic) {
        super(idArtic, descripArtic, precioUnitArtic, stockArtic);
        this.cantidad = cantidad;
    }
 
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     
}
