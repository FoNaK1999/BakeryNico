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
import models.ModeloPedidos;

/**
 *
 * @author marti
 */
public class RegistrarPedido extends HttpServlet {

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
        
        ModeloPedidos mp = new ModeloPedidos();
        
        String fecha = request.getParameter("fecha");
        String rut = request.getParameter("rut");
        String matricula = request.getParameter("matricula");
        String state = request.getParameter("state");
        String estadoSol = "Activo";
        int cantidadProd = Integer.parseInt(request.getParameter("cantidadProductos"));       
        
        int valor = mp.RegistrarPedidoFormulario(fecha, state, rut, matricula);
              
        System.out.println(fecha+" "+rut+" "+matricula+" "+state+" "+valor);
        
        if(valor > -1){
            for(int i=1;i<=cantidadProd;i++){
                ModeloPedidos mp2 = new ModeloPedidos();
                ModeloPedidos mp3 = new ModeloPedidos();                
                System.out.println(request.getParameter("resultado" + i));
                mp2.RegistrarSolicitar(Integer.parseInt(request.getParameter("resultado" + i)),Integer.parseInt(request.getParameter("cantidad" + i)), valor, i,estadoSol);
                mp3.UpdateStock(Integer.parseInt(request.getParameter("cantidad" + i)), Integer.parseInt(request.getParameter("resultado" + i)));
            }
            response.sendRedirect("MantenedorPedidos.jsp");
        }else{
            
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
