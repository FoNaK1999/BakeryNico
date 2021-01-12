/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Articulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ModeloFactura;
import models.ModeloPedidos;

/**
 *
 * @author marti
 */
public class ServletFactura2 extends HttpServlet {

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
        
        ModeloPedidos mp = new ModeloPedidos();
        ModeloPedidos mp2 = new ModeloPedidos();
        
        
        
        
        String codeorder =request.getParameter("codeorder");
        String tipopago = request.getParameter("tipopago");
        String patente = request.getParameter("patente");
        int monto = Integer.parseInt(request.getParameter("monto"));
        String estado = "Pendiente";
        switch(tipopago){
            case "VN":
                tipopago = "Venta Normal";
                break;
            case "VD":
                tipopago= "Venta Debito";
                break;
            case "VC":
                tipopago = "Venta en Cuotas";
        }
        System.out.println("Tipo Pago: "+tipopago+"Codigo de orden: "+codeorder+" Patente: "+patente);
       
        int valor = 0;                     
        valor = mp.RegistrarPedido("Pendiente", request.getParameter("rut"), patente);               
        
        if(valor>0){
            mp2.RegistrarVenta(monto, tipopago, estado, valor);
            response.sendRedirect("factura.jsp?valor="+valor);
        }else{
            response.sendRedirect("error.jsp");
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
