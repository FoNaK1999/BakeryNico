/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Producto;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import models.ModeloAdmin;
import models.ModeloProducto;

/**
 *
 * @author Martin
 */
@MultipartConfig
public class ActualizarProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            ModeloAdmin mad = new ModeloAdmin();
            
            ModeloProducto mp = new ModeloProducto();
            
            
            
            int id = Integer.parseInt(request.getParameter("id"));
            Producto producto = mp.getProducto(id);
            
            String nombre = request.getParameter("nombreProd");
            String descripcion = request.getParameter("descripcion");
            int categoria = Integer.parseInt(request.getParameter("categoria"));
            int precio = Integer.parseInt(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            String estado = request.getParameter("state");
            Part archivo = request.getPart("imagen"); //llamada al parámetro foto de mi formulario.     
            String context = request.getServletContext().getRealPath("images\\home"); //img es la carpeta que he creado en mi proyecto.
            String foto = Paths.get(archivo.getSubmittedFileName()).getFileName().toString(); 
            
            if(foto.isEmpty()){                                         
                String img = producto.getImg();
                mad.UpdateProductos(id, nombre, descripcion, img, categoria, precio, stock,estado);      
                response.sendRedirect("MantenedorProducto.jsp?status=1");                
            }else{
                archivo.write(context + File.separator + foto); // Se escribe el archivo al disco duro del servidor.

                String fotoName = "images\\home" + File.separator + foto;
                mad.UpdateProductos(id, nombre, descripcion, fotoName, categoria, precio, stock,estado);        
                response.sendRedirect("MantenedorProducto.jsp?status=1");
            }
            

            
            /*response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet verTablaUsuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet verTablaUsuarios at " + foto + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
            
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
