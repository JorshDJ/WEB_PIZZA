
package controlador;

import beans.Administradores;
import beans.Articulos;
import beans.Clientes;
import beans.Compra;
import dao.NegocioPizza;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Control extends HttpServlet {
    NegocioPizza obj =new NegocioPizza();
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int opc=Integer.parseInt(request.getParameter("op"));
        
       if(opc==1) lisArt(request, response);
       if(opc==2) detalle(request, response);
       if(opc==3) carrito(request, response);
       if(opc==4) borraItem(request, response);
       if(opc==5) login(request, response);
       if(opc==6) loginAdm(request,response);
       if(opc==7) lisArt2(request,response);
       if(opc==8) lisCliente(request,response);
       
       if(opc==9) buscarArtic(request,response);
       if(opc==10) editarArt(request,response);
       if(opc==11) nuevoArt(request,response);
       if(opc==12) borrarArt(request,response);
              
    }
    
    protected void lisArt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      request.setAttribute("dato", obj.lisArt());
      String pag="/carta.jsp";
      request.getRequestDispatcher(pag).forward(request, response);        
    }
    
    protected void lisArt2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod=request.getParameter("id");
        request.setAttribute("dato",obj.lisArt());
        HttpSession ses=request.getSession();
        ses.setAttribute("dato2", obj.busArt(cod));
        String pag="/ListaArticulo.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void lisCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod=request.getParameter("id");
        request.setAttribute("dato",obj.lisClientes());
        HttpSession ses=request.getSession();
        ses.setAttribute("datocEsp", obj.busCli(cod));
        String pag="/ListaClientes.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void buscarArtic(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("id");
        HttpSession ses = request.getSession();
        ses.setAttribute("dato", obj.busArt(cod));
        String pag="/editarArticulo.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    
    protected void editarArt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Articulos articulo = new Articulos();
        HttpSession ses = request.getSession();
        Articulos a = (Articulos) ses.getAttribute("dato");
        articulo.setIdArtic(a.getIdArtic());
        articulo.setDescripArtic(request.getParameter("desArt"));
        articulo.setPrecioUnitArtic(Double.parseDouble(request.getParameter("preArt")));
        articulo.setStockArtic(Integer.parseInt(request.getParameter("stoArt")));
        obj.actualizaArticulo(articulo);
        request.getRequestDispatcher("Control?op=7").forward(request, response);
    }
    
    protected void nuevoArt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Articulos art = new Articulos();
        art.setIdArtic(request.getParameter("idArt")); 
        art.setDescripArtic(request.getParameter("desArt"));
        art.setPrecioUnitArtic(Double.parseDouble(request.getParameter("preArt")));        
        art.setStockArtic(Integer.parseInt(request.getParameter("stoArt")));      
        obj.nuevoArticulo(art);
        request.getRequestDispatcher("Control?op=7").forward(request, response);
    }
    
    protected void borrarArt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("id");
        obj.borrarArticulo(cod);
        request.getRequestDispatcher("Control?op=7").forward(request, response);
    }
    
    
    protected void detalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        request.setAttribute("dato", obj.busArt(id));
      String pag="/pagDetalle.jsp";
      request.getRequestDispatcher(pag).forward(request, response); 
    }
    
    
    protected void carrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String coda=request.getParameter("coda");
        int can=Integer.parseInt(request.getParameter("cantidad"));
        Articulos ar=obj.busArt(coda);
        //el articulo buscado pasa al objeto compra
        
       Compra cp=new Compra();
       cp.setCantidad(can);
       cp.setIdArtic(coda);
       cp.setDescripArtic(ar.getDescripArtic());
       cp.setPrecioUnitArtic(ar.getPrecioUnitArtic());
  
       List<Compra> lista;
       HttpSession ses=request.getSession();
       if(ses.getAttribute("canasta")==null)
           lista=new ArrayList();
       else //recuperar lo que esta en la sesion
           lista=(ArrayList)ses.getAttribute("canasta");
        //agregar la compra     
            lista.add(cp);
       //actualizar la sesion      
      ses.setAttribute("canasta", lista);
         String pag="/pagCompra.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    
    protected void borraItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession ses=request.getSession();
      int indice=Integer.parseInt(request.getParameter("id"));
      List<Compra>  lista=(ArrayList)ses.getAttribute("canasta");
      lista.remove(indice);
      ses.setAttribute("canasta", lista);//actualizar la sesion
      String pag="/pagCompra.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession ses=request.getSession();
      
      String user=request.getParameter("tarjeta").trim();
      String clave=request.getParameter("contra").trim();      
      Clientes cli=obj.busCli(user);
      int sw=0;
        if (cli==null) {
            request.setAttribute("dato","usuario no existe");            
        }else{
            if (cli.getClaveClie().equals(clave)) {
                ses.setAttribute("cliente", cli);
                grabaFactura(request,response);               
            }else{
                request.setAttribute("dato", "clave incorrecta");
            }                     
        }
        if (sw==0) {
            String pag="/login.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
            
        }
        
    }
    
    protected void loginAdm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession ses=request.getSession();
      
      String user=request.getParameter("codigo").trim();
      String clave=request.getParameter("contra").trim();      
      Administradores adm =obj.busAdm(user);
      int sw=0;
        if (adm==null) {
            request.setAttribute("dato","usuario no existe");            
        }else{
            if (adm.getPass().equals(clave)) {
                ses.setAttribute("administrador", obj.busAdm(user));
                
                
                
                String pag="/pagAdministrador.jsp";
                request.getRequestDispatcher(pag).forward(request, response);
                
                            
            }else{
                request.setAttribute("dato", "clave incorrecta");
            }                     
        }
        if (sw==0) {
            String pag="/loginAdm.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
            
        }
        
    }
    
    
    protected void grabaFactura(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses=request.getSession();
        Clientes cli=(Clientes) ses.getAttribute("cliente");
        List<Compra> lista=(ArrayList)ses.getAttribute("canasta");
        String fac=obj.grabaFac(cli.getTarjetaCli(), lista);
        double tot=0;
        for (Compra x:lista) tot+=x.total();
        //el request va a la página y luego el dato se pierder 
        //la session mantiene el dato
        request.setAttribute("factura", fac);
        request.setAttribute("cli", cli.getNombreCli());
        request.setAttribute("total", tot);
        
        ses.setAttribute("cliente", null);
        ses.setAttribute("canasta", null);
        String pag="/Resumen.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
            
        
        
    }
     
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
