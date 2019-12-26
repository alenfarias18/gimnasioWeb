
package controlador;

import dao.medicion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.daoMedicion;



public class Sevaluacion extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String respuesta;
        String fecha = request.getParameter("fecha");
        String estatura = request.getParameter("estatura");
        String peso = request.getParameter("peso");
        String medidaCintura = request.getParameter("medidaCintura");
        String porcentajeGrasa = request.getParameter("grasa");
        String imc = request.getParameter("imc") ;
        String indiceGrasa= request.getParameter("indiceGrasa");
        String pathFoto = "null";
        String usuario = request.getParameter("usuario");
        String entrenador = request.getParameter("entrenador");
            medicion medicion = new medicion(0,fecha,Integer.parseInt(estatura),Integer.parseInt(peso),Integer.parseInt(medidaCintura),Float.parseFloat(porcentajeGrasa),Float.parseFloat(imc),Float.parseFloat(indiceGrasa),pathFoto,usuario,entrenador);
            medicion.setFecha(fecha);
            medicion.setEstatura(Integer.parseInt(estatura));
            medicion.setPeso(Integer.parseInt(peso));
            medicion.setMedidaCintura(Integer.parseInt(medidaCintura));
            medicion.setPorcentajeGrasa(Float.parseFloat(porcentajeGrasa));
            medicion.setImc(Float.parseFloat(imc));
            medicion.setIndiceGrasaInstrumento(Float.parseFloat(indiceGrasa));
            medicion.setPathFoto(pathFoto);
            medicion.setUsuario(usuario);
            medicion.setEntrenador(entrenador);
            
            daoMedicion daoMedicion = new daoMedicion();
            respuesta = daoMedicion.insertar(medicion);
            
            
            
            try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet actualizaEntrenador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+respuesta+"</h1>");
            out.println("</body>");
            out.println("</html>");
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
