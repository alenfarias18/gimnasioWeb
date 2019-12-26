/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.genero;
import dao.persona;
import dao.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.daoGenero;
import modelo.daoPersona;
import modelo.daoUsuario;

/**
 *
 * @author farias
 */
public class registro extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         String NomUsuario = request.getParameter("usuario");
         String nombre = request.getParameter("nombre");
         String apellidoPat = request.getParameter("apellidoPat");
         String apellidoMat = request.getParameter("apellidoMat");
         String userClave = request.getParameter("clave");
         String fechaNacimiento = request.getParameter("fechaNacimiento");
         String fechaIngreso = request.getParameter("fechaIngreso");
         String Idgenero = request.getParameter("genero");
         if(NomUsuario!="" || nombre !="" || apellidoPat != "" || apellidoMat != "" || userClave != "" || fechaNacimiento != "" || fechaIngreso != "" || Idgenero != "" ){
             
             persona persona = new persona(NomUsuario, nombre, apellidoPat, apellidoMat,userClave);
             
                daoGenero daoGenero = new daoGenero();
                  List<genero> datos = new ArrayList<>();
                  datos = (List<genero>) daoGenero.listar();
                daoGenero.setIdGenero(Integer.parseInt(Idgenero));
                int IDGenero = Integer.parseInt(Idgenero);
                for(genero g:datos){
                    IDGenero = g.getIdGenero();
                }
            
                
                usuario usuario = new usuario(fechaNacimiento,fechaIngreso, IDGenero);
            
             
             persona.setUsuario(NomUsuario);
             persona.setNombre(nombre);
             persona.setApellidoPat(apellidoPat);
             persona.setApellidoMat(apellidoMat);
             persona.setClave(userClave);
             
             usuario.setFechaNacimiento(fechaNacimiento);
             usuario.setFechaIngreso(fechaIngreso);
             
             
             daoPersona daoPersona = new daoPersona();
             daoUsuario daoUsuario = new daoUsuario();
             
             daoPersona.setClausulaWhere("WHERE vchUsuario='"+NomUsuario+"'");
             daoPersona.setUsuario(NomUsuario);
             daoUsuario.setUsuario(NomUsuario);
             
             
             if(daoPersona.listar().isEmpty()){
                  daoPersona.insertar(persona);
                  daoUsuario.insertar(usuario);
             }
            
             
         }
         else{
             
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
