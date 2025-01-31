/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.daoPersona;



public class validar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean acceso = false;
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        daoPersona daoPersona = new daoPersona();
        daoPersona.setClausulaWhere("WHERE usuario='"+usuario+"' and clave='"+password+"'");
      
        if(!daoPersona.listar().isEmpty()){
            acceso = true;
        }
        
        try (PrintWriter out = response.getWriter()) {
            if(acceso){
                
                HttpSession misession= (HttpSession) request.getSession();
                misession.setAttribute("usuario",usuario);
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
            }
            else{
                String mensaje = "El usuario y/o password son incorrectos";
                request.setAttribute("mensaje", mensaje);
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
                
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
