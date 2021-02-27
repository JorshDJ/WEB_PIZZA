
package Interfaces;
import beans.*;
import java.util.*;
public interface tiendaPizza {
    
    List<Articulos> lisArt();
    List<Articulos> lisGenArt();
    List<Clientes> lisClientes();
    Articulos busArt(String id);
    Clientes busCli(String id);
    Administradores busAdm(String id);
    
    
    
    String grabaFac(String codc,List<Compra> lista);
    //primero generamos la factura para grabarlo en el detalle
}
