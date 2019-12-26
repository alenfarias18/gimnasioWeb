/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.daoEntrenador;
import modelo.daoPersona;
import modelo.daoProfesion;
import modelo.daoUsuario;

/**
 *
 * @author farias
 */
public class actualizaEntrenador extends HttpServlet {

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
        String entrenador = request.getParameter("entrenadorBuscar");
        
        //Informacion de la persona
        daoPersona p = new daoPersona();
        p.setClausulaWhere(" WHERE usuario = '"+entrenador+"'");
        //Informacion del usuario
        daoUsuario u = new daoUsuario();
        u.setClausulaWhere(" WHERE usuario = '"+entrenador+"'");
        //Informacion del entrenador
        daoProfesion e = new daoProfesion();
        
        
        request.setAttribute("persona",p.listar());
        request.setAttribute("usuario",u.listar());
        request.setAttribute("entrenador",e.listar());
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/adminActualizar.jsp");
        rd.forward(request, response);
   
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
