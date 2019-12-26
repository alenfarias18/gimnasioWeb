<%-- 
    Document   : home
    Created on : 06-nov-2019, 4:14:15
    Author     : farias
--%>

<%@page import="modelo.daoEntrenador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" type="text/css" href="css/general.css"/>
           <link rel="stylesheet" type="text/css" href="css/navegator.css"/>
        <title>GymFitness</title>
    </head>
    <body>
        <%
            
          Object usuario = session.getAttribute("usuario");
            if(usuario == null){
            out.print("<center><div><h1>Acceso no permitido</h1><br><br><h3 style='color:black'>Favor de iniciar sesion</h3></div></center>");
        }
        else{
        out.print("<div class='container-logo'><h1 style='color: #FFFFFF'>GYM&nbsp;</h1><h1> Fitness</h1><br><h1>Club</h1></div><div id='navegador'>");
        out.print("<ul>");
        out.print("<li><a href='home.jsp'>Home</a></li>");
        out.print("<li><a href='evaluacion.jsp'>Evaluaciones</a></li>");
                       daoEntrenador daoEntrenador = new daoEntrenador();
               daoEntrenador.setClausulaWhere(" WHERE usuario='"+usuario+"'");
               if(!daoEntrenador.listar().isEmpty()){
                    out.print("<li><a href='adminBuscar.jsp'>Admin</a></li>");
               }
    
        out.print("<li><a href='logout'>logout</a></li></ul></div>");
        out.print("<br><br>");
        out.print("<center><div style='background: #2196F3'>"
                + "<h2>Noticias</h2><br><br>"
                + "<p>'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                + " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor"
                + " in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident,"
                + " sunt in culpa qui officia deserunt mollit anim id est laborum.'</p><br><br></div></center>");
         }
        
        %>
        

        
    </body>
</html>
