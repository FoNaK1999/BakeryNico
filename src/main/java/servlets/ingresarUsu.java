/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloUsuarios;

/**
 *
 * @author marti
 */
public class ingresarUsu extends HttpServlet {

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
        
        ModeloUsuarios mu = new ModeloUsuarios();
        ModeloUsuarios mu2 = new ModeloUsuarios();
        
        String rut = request.getParameter("idusu");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fono = request.getParameter("fono");
        String ubicacion = request.getParameter("ubicacion");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String rol = request.getParameter("rol");
        String estado = "Disponible";
        
        
        switch(rol){
            case "2":
                if(mu.RegistrarUsuario(rut, nombre, apellido, fono, ubicacion, email, pass, estado)){
                    response.sendRedirect("mantenedorUsuarios.jsp?status=1");
                    break;
                }else{
                    response.sendRedirect("mantenedorUsuarios.jsp?status=2");
                    break;
                }
            
            case "1":
                if(mu2.RegistrarAdmin(rut, nombre, apellido, fono, ubicacion, email, pass, estado)){
                    response.sendRedirect("mantenedorUsuarios.jsp?status=1");
                }else{
                    response.sendRedirect("mantenedorUsuarios.jsp?status=2");
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
