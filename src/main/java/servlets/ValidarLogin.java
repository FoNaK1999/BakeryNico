/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Session;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ModeloUsuarios;

/**
 *
 * @author marti
 */
public class ValidarLogin extends HttpServlet {

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
        ModeloUsuarios mu3 = new ModeloUsuarios();
        ModeloUsuarios mu4 = new ModeloUsuarios();
        
        Session miusuario = new Session();
        
        
        String mail = request.getParameter("Mail");
        String pass = request.getParameter("Password");
        
        
        //Cliente
        if(mu.Autenticacion(mail, pass)==true){
            miusuario= mu3.getNombreUsuario(mail);                        
            
            HttpSession misession= request.getSession(true);
            misession.setAttribute("usuario",miusuario);
            
            response.sendRedirect("shop.jsp?idcat=1");
        }else if(mu2.AutenticacionAdmin(mail, pass)==true){
            //Administrador
                miusuario= mu4.getNombreAdmin(mail);                        
            
                HttpSession misession= request.getSession(true);
                misession.setAttribute("usuario",miusuario); 
                
                response.sendRedirect("mantenedor.jsp");               
        }else{
            response.sendRedirect("login.jsp?status=Correo o clave incorrectos");  
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
