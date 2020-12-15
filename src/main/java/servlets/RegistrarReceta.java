/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import models.ModeloRecetas;

/**
 *
 * @author marti
 */
@MultipartConfig
public class RegistrarReceta extends HttpServlet {

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
        
        ModeloRecetas mr = new ModeloRecetas();
        
        int id = Integer.parseInt(request.getParameter("idrc"));
        String nombre = request.getParameter("nombrerc");
        String descripcion = request.getParameter("descripcionrc");
        String ingrediente = request.getParameter("ingredientec");
        Part archivo = request.getPart("imagenrc");
        String estado = request.getParameter("staterc");
        
        String context = request.getServletContext().getRealPath("images\\home"); //img es la carpeta que he creado en mi proyecto.
        String foto = Paths.get(archivo.getSubmittedFileName()).getFileName().toString();
        archivo.write(context + File.separator + foto); // Se escribe el archivo al disco duro del servidor.
        String fotoName = "images\\home" + File.separator + foto;
        
        if(mr.RegistrarRecetas(id, nombre, descripcion, ingrediente, fotoName, estado)==true){
            response.sendRedirect("MantenedorRecetas.jsp");
        }else{
            response.sendRedirect("IngresarRecetas.jsp?status=Error al ingresar receta.");
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
