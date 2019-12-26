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
                     out.print(" <div class='container-logo'>");
            out.print("   <h1 style='color: #FFFFFF'>GYM&nbsp;</h1><h1> Fitness</h1>");
        out.print("   <br>");
       out.print("    <h1>Club</h1>");
      
        out.print("   </div>");
        
               out.print("    <div id='navegador'>");
            out.print("   <ul>");
             out.print("      <li><a href='home.jsp'>Home</a></li>");
                  out.print(" <li><a href='evaluacion.jsp'>Evaluaciones</a></li>");
                  out.print(" <li><a href='adminRegistro.jsp'>Registro Entrenador</a></li>");
                  out.print(" <li><a href='adminBuscar.jsp'>Buscar Entrenador</a></li>");
                  out.print(" <li><a href='usuarioBuscar.jsp'>Buscar Usuario</a></li>");
                   out.print(" <li><a href='logout'>logout</a></li>");
              out.print(" </ul>");
          out.print(" </div>");
        
  out.print("         <form method='POST'  action='registroEntrenador' onsubmit='return validacion_registro()'>");
  out.print("             <div class='login-container'>");
  out.print("                 <div class='input-container'>");
  out.print("                 <center><h3>Registro entrenador</h3></center>");
  out.print("                 <input type='text' placeholder='Usuario' maxlength='50' name='usuario' id='user'/>");
  out.print("                 <br><br>");
  out.print("                 <select id='IDprofesion' name='profesion'>");
  out.print("                     <option value='0'>Seleccione la profesion</option>");
  out.print("                     <option value='1'>Profesion 1</option>");
  out.print("                     <option value='2'>Profesion 2</option>");
  out.print("                     <option value='3'>Profesion 3</option>");
  out.print("                 </select>");
  out.print("                 <br><br>");
  out.print("                 <input type='submit' value='Entrar'/>");
  out.print("                 <br>");
  out.print("                 <br>");
                 Object respuesta= request.getAttribute("respuesta"); 
                  if(respuesta!=null){
                      out.print("<center><label>"+respuesta+"</label></center>");
                  }
  out.print("                          <br><br>");
  out.print("                 </div>");
  out.print("             </div>");
  out.print("                 <center>");
                     
  out.print("                     <img src='image/muscle.png' id='imgMuscle'/>");
  out.print("                     </div>");
  out.print("                 <center>");
  out.print("         </form>");
               }
               else{
                   out.print("<center><div><h1>Acceso no permitido</h1><br></div></center>");
               }
        
        
        %>
      
           
         
    </body>
</html>
