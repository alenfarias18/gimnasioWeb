<%-- 
    Document   : index.jsp
    Created on : 26-oct-2019, 19:20:00
    Author     : farias
--%>

<%@page contentType='text/html' pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
        <script src='valida.js' type='text/javascript'></script>
        <link rel='stylesheet' type='text/css' href='css/index.css'/>
         <link rel='stylesheet' type='text/css' href='css/general.css'/>
        
        <title>GymFitness</title>
    </head>
    <body>
                <%
            
         
            if(session.getAttribute("usuario") == null){
            out.print("<div class='container-logo'><h1 style='color: #FFFFFF'>GYM&nbsp;</h1><h1> Fitness</h1><br><h1>Club</h1></div><form method='POST' action='validar' onsubmit='return validacion()'><div class='login-container'><div class='input-container'><center><h3>Login</h3></center><input type='text' placeholder='Usuario' maxlength='50' name='usuario' id='user'/><br><br><input type='password' placeholder='Password' maxlength='50' name='password' id='password'/><br><br>");
            Object mensaje =   request.getAttribute("mensaje");
            if(mensaje != null){
                     out.print("<center><label>El usuario y/o password son incorrectos</label></center>");
                    }
                
              out.print("<br><br><input type='submit' value='Entrar'/><br><br><br><br></div></div><center><img src='image/muscle.png' id='imgMuscle'/></div<center></form>");
            }
        else{
                    RequestDispatcher rd;
                rd = request.getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
            
            }
        
        %>
       
              
                          
               
                    
              
          
    </body>
</html>
