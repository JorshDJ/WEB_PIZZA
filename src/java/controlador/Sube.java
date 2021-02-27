
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




public class Sube extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
      // String arch="C:\\utp_2020\\web_integrado\\semana13\\PROYECTOTIENDA\\web\\files";
      // primero detecta el repositorio
        String arch=getServletContext().getRealPath("/files");
        arch=arch.replaceAll("\\\\", "/");
        int pos=arch.indexOf("build");//target para otro
        String res=arch.substring(0, pos-1);
         arch=res+"/web/fotos";
         
        //out.print(arch);
        //acá la carga de archivo tiene que ser por cada mega
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(1024);
        
        //acá ubicas el repositorio y creas el repositorio
        factory.setRepository(new File(arch));
        ServletFileUpload upload=new ServletFileUpload(factory);
        try{
          List<FileItem> partes=upload.parseRequest(request);
          for(FileItem item:partes){
              File file=new File(arch,item.getName());
              item.write(file);
          }
           request.setAttribute("dato", "Archivo subido");
        }catch(Exception ex){
            request.setAttribute("dato", ex.getMessage());
        }
        String pag="/nuevoArticulo.jsp";
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
