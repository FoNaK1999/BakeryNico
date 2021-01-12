/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.ProductosSolicitados2;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloFactura;
import models.ModeloPedidos;

/**
 *
 * @author marti
 */
@WebServlet(name = "BorrarSolicitar", urlPatterns = {"/BorrarSolicitar"})
public class BorrarSolicitar extends HttpServlet {

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
            
            int idped = Integer.parseInt(request.getParameter("idped"));
            int idprod = Integer.parseInt(request.getParameter("idprod"));
            
            
            System.out.println(idped + " "+ idprod);
            
            ModeloPedidos mp = new ModeloPedidos();
            
//            mp.BorrarSolicitarProducto(idprod, idped);
            
            if(mp.BorrarSolicitarProducto(idprod, idped)){
                ModeloFactura mf = new ModeloFactura();
                ModeloFactura mf2 = new ModeloFactura();
                int cantidad = mf2.getCantidadRegistros(idped);
                String htmlcode2 = "";       
                for(ProductosSolicitados2 soli : mf.getListSolicitar2(idped)){
                    for(int i=1;i==cantidad;i++){
                        htmlcode2 += "<input type='hidden' id='idprod' value='"+soli.getIdprod()+"'><input type='hidden' id='cantidadRegistros' value='"+cantidad+"'><strong>Nombre producto: </strong>"+soli.getNombreProd()+"          |          <strong>CANTIDAD: </strong>"+soli.getCantidadProd()+"<input type='button' onclick='EliminarProducto();' value='Eliminar Producto'>";
  
                    }
                            
                }
                out.println(htmlcode2);  
            }else{
                out.println("No se ha Hecho");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BorrarSolicitar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BorrarSolicitar.class.getName()).log(Level.SEVERE, null, ex);
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
