/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.ProductosSolicitados;
import classes.ProductosSolicitados2;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloFactura;

/**
 *
 * @author marti
 */
public class ObtenerListadoProductosPedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                int idpedido = Integer.parseInt(request.getParameter("idped"));
                ModeloFactura mf = new ModeloFactura();
                ModeloFactura mf2 = new ModeloFactura();
                
                int cantidad = mf2.getCantidadRegistros(idpedido);
                String htmlcode2 = "";       
                for(ProductosSolicitados2 soli : mf.getListSolicitar2(idpedido)){               
                    for(int i=1;i<cantidad + 1;i++){
                        htmlcode2 += "<input type='hidden' id='idprod"+i+"' value='"+soli.getIdprod()+"'><input type='hidden' id='cantidadRegistros' value='"+cantidad+"'><strong>Nombre producto: </strong>"+soli.getNombreProd()+"          |          <strong>CANTIDAD: </strong>"+soli.getCantidadProd()+"<input type='button' onclick='EliminarProducto();' value='Eliminar Producto'>";
                        System.out.println("Hecho");
                    }
//                    htmlcode2 += "<input type='hidden' id='idprod' value='"+soli.getIdprod()+"'><input type='hidden' id='cantidadRegistros' value='"+cantidad+"'><br><strong>Nombre producto: </strong>"+soli.getNombreProd()+"          |          <strong>CANTIDAD: </strong>"+soli.getCantidadProd()+"&nbsp&nbsp&nbsp&nbsp&nbsp<input type='button' onclick='EliminarProducto();' value='Eliminar Producto'>";
                }
            out.println(htmlcode2);
                
                
                
                
                
                
                
//                ModeloFactura mf = new ModeloFactura();      
//                String htmlcode2 = "";       
//                for(ProductosSolicitados2 soli : mf.getListSolicitar2(idpedido)){                    
//                    htmlcode2 += "<input type='hidden' id='idprod' value='"+soli.getIdprod()+"'><input type='hidden' id='cantidadRegistros' value='"+soli.getCantregistros()+"'><strong>Nombre producto: </strong>"+soli.getNombreProd()+"          |          "+"<strong>CANTIDAD: </strong>"+soli.getCantidadProd()+"<input type='button' onclick='EliminarProducto();' value='Eliminar Producto'>";       
//                    htmlcode2 += "<strong>Nombre producto: </strong>"+soli.getNombreProd()+"          |          "+"<strong>CANTIDAD: </strong>"+soli.getCantidadProd();       
//
//                }
//                out.println(htmlcode2);  
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
            Logger.getLogger(ObtenerListadoProductosPedido.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ObtenerListadoProductosPedido.class.getName()).log(Level.SEVERE, null, ex);
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
