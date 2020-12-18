/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloUsuarios;

/**
 *
 * @author marti
 */
public class Pruebas extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        ModeloUsuarios mu = new ModeloUsuarios();
        String htmlcode = "";       
                for(Administrador adm : mu.getListUsuarios2()){
                    htmlcode += "<tr>\n" +
        "                             <td class=\"column1\">"+adm.getId()+"</>\n" +
        "                             <td class=\"column1\">"+adm.getNombre()+"</td>\n" +
        "                             <td class=\"column1\">"+adm.getApellido()+"</td>\n" +
        "                             <td class=\"column1\">"+adm.getFono()+"</td>\n" +
        "                             <td class=\"column1\">"+adm.getUbicacion()+"</td>\n" +
        "                             <td class=\"column1\">"+adm.getMail()+"</td>\n" +
        "                             <td class=\"column1\">"+adm.getPass()+"</td>\n" +
        "                             <td class=\"column1\">"+adm.getEstado()+"</td>\n" +                          
        "                             <td class=\"column1\"><a href='ActualizarAdministrador.jsp?id="+adm.getId()+"&nombre="+adm.getNombre()+"&Apellido="+adm.getApellido()+"&fono="+adm.getFono()+"&Ubicacion="+adm.getUbicacion()+"&email="+adm.getMail()+"&pass="+adm.getPass()+"&estado="+adm.getEstado()+"'>Modificar</a><br><br><form action='BorrarAdmin' method='post'><input type='text' name='hidden' style='display:none;' value='"+adm.getId()+"'><input type='submit' value='Eliminar'></form></td>\n" +
        "                       </tr>";
                }
                out.println(htmlcode);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
