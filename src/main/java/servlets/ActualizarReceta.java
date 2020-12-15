/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Receta;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import models.ModeloRecetas;
import javax.servlet.annotation.MultipartConfig;

/**
 *
 * @author marti
 */
@MultipartConfig
public class ActualizarReceta extends HttpServlet {

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
        ModeloRecetas mrc = new ModeloRecetas();
        
        int id = Integer.parseInt(request.getParameter("idrc2"));
        Receta rec = mrc.getReceta(id);
              
            String nombre = request.getParameter("nombrerc2");
            String descripcion = request.getParameter("descripcionrc2");
            String ingredientes = request.getParameter("ingredientesrc2");
            String estado = request.getParameter("staterc2");
            Part archivo = request.getPart("imagenrc2"); //llamada al parámetro foto de mi formulario. 
            String context = request.getServletContext().getRealPath("images\\home"); //img es la carpeta que he creado en mi proyecto.
            String foto = Paths.get(archivo.getSubmittedFileName()).getFileName().toString();

            
            
            
            if (foto.isEmpty()) {
                String img = rec.getImagen();
                mrc.UpdateReceta2(id, nombre, descripcion, ingredientes, img, estado);
                System.out.println(id+" "+nombre+" "+descripcion+" "+ingredientes+" "+estado+" "+ img);
                response.sendRedirect("MantenedorRecetas.jsp?status = No cambio la imagen");
            } else {
                archivo.write(context + File.separator + foto); // Se escribe el archivo al disco duro del servidor.

                String fotoName = "images\\home" + File.separator + foto;
                if(mrc.UpdateReceta2(id, nombre, descripcion, ingredientes, fotoName, estado)){
                    response.sendRedirect("MantenedorRecetas.jsp?status= Cambio la imagen");
                }
                
            }
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
