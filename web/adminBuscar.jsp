<%-- 
    Document   : index.jsp
    Created on : 26-oct-2019, 19:20:00
    Author     : farias
--%>

<%@page import="modelo.daoEntrenador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="valida.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
         <link rel="stylesheet" type="text/css" href="css/general.css"/>
        <link rel="stylesheet" type="text/css" href="css/navegator.css"/>
        <title>GymFitness</title>
    </head>
    <body>
        <%
         Object usuario = session.getAttribute("usuario");
          daoEntrenador daoEntrenador = new daoEntrenador();
               daoEntrenador.setClausulaWhere(" WHERE usuario='"+usuario+"'");
               if(!daoEntrenador.listar().isEmpty()){
                 out.print("<div class='container-logo'>");
            out.print("<h1 style='color: #FFFFFF'>GYM&nbsp;</h1><h1> Fitness</h1>");
       out.print(" <br>");
        out.print("<h1>Club</h1>");
      
        out.print("</div>");
        
                   out.print("          <div id='navegador'>");
            out.print("<ul>");
                out.print("<li><a href='home.jsp'>Home</a></li>");
                out.print("<li><a href='evaluacion.jsp'>Evaluaciones</a></li>");
                out.print("<li><a href='adminRegistro.jsp'>Registro Entrenador</a></li>");
                out.print("<li><a href='adminBuscar.jsp'>Buscar Entrenador</a></li>");
                out.print("<li><a href='usuarioBuscar.jsp'>Buscar Usuario</a></li>");
                 out.print("<li><a href='logout'>logout</a></li>");
            out.print("</ul>");
        out.print("</div>");
        
       
            out.print("<div class='login-container'>");
                out.print("<div class='input-container' >");
                out.print("<center><h3>Buscar</h3></center>");
                 out.print("<form method='POST'  action='buscarEntrenador' nsubmit='return validacion_buscar()'>");
                out.print("<input type='text' placeholder='Entrenador' required maxlength='50' name='usuario' id='user'/>");
            
out.print("                <br><br>");
out.print("                <input type='submit' value='Buscar'/>        ");
out.print("                </form>");
out.print("                <br>");
out.print("                <br>");
              
        Object entrenador = request.getAttribute("entrenador");
               
                  if(entrenador!=null){
                  
                          
                      if(entrenador != ""){
                      out.print("<center><div style='background: #ffffff;opacity:0.8;'><label>Entrenador: "+entrenador+" <label/><br><br><div style='float:left; margin-left:20%;'><form action='borrarEntrenador' method='POST'><input style='display:none;' type='text' name='entrenadorBuscar'  value="+entrenador+"  /><input style='color:white; background:red; width:70px; ' type='submit' value='Eliminar' /></form></div><div style='float:right; margin-right:20%;'><form action='actualizaEntrenador' method='POST'><input style='display:none;' type='text' name='entrenadorBuscar'  value="+entrenador+"  /><input style='color:white; background:green; width:80px; ' type='submit' value='Actualizar' /></form></div><br><br><br><br></div></center>");
                      
            
                      
                      }
                      else{
                          out.print("<center><label>No se ha encontrado el entrenador.</label></center>");
                      }
             
                  }
                     Object respuesta = request.getAttribute("respuesta");
                       if(respuesta != null){
                          out.print("<center><label>"+respuesta+"</label></center>");
                      }
                         out.print("   <br><br>");
               out.print("  </div >");
            out.print(" </div>");
               out.print("  <center>");
                    
                   out.print("  <img src='image/muscle.png' id='imgMuscle'/>");
                  out.print("   </div");
               out.print("  <center>");
                }
               else{
                     out.print("<center><div><h1>Acceso no permitido</h1><br></div></center>");
               }
        %>
      
                
           
    </body>
</html>
