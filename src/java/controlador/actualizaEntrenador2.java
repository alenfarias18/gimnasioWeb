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
import javax.servlet.http.HttpSession;
import modelo.daoEntrenador;
import modelo.daoPersona;

/**
 *
 * @author farias
 */
public class actualizaEntrenador2 extends HttpServlet {

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
           String usuario = request.getParameter("usuario");
           String password1 = request.getParameter("password1");
           String profesion = request.getParameter("profesion");
           if(password1.trim() != ""){              
               daoPersona dpersona = new daoPersona();
               dpersona.setClausulaWhere(" where usuario='"+usuario+"'" );
               dpersona.actualizar(password1);           
           }
           if(Integer.parseInt(profesion) != 0){
                 daoEntrenador daoEntre = new daoEntrenador();
               daoEntre.setClausulaWhere(" WHERE usuario='"+usuario+"'");
               daoEntre.actualizar(Integer.parseInt(profesion));
               request.setAttribute("respuesta","Entrenador actualizado con exito.");
               RequestDispatcher rd;
               
                rd = request.getRequestDispatcher("/adminBuscar.jsp");
                rd.forward(request, response);
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
