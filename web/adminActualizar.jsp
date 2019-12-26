<%-- 
    Document   : registro
    Created on : 26-oct-2019, 20:39:27
    Author     : farias
--%>

<%@page import="modelo.daoEntrenador"%>
<%@page import="dao.profesion"%>
<%@page import="dao.entrenador"%>
<%@page import="dao.usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.persona"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GymFitness</title>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
         <link rel="stylesheet" type="text/css" href="css/general.css"/>
        <link rel="stylesheet" type="text/css" href="css/navegator.css"/>
        <script>
            function valida(){
                var password1 = document.getElementById("idPassword1").value;
                var password2 = document.getElementById("idPassword2").value;
                if(password1!=password2){
                    alert("Las password no coinciden.");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <% 
          Object usuarioLog = session.getAttribute("usuario");
          daoEntrenador daoEntrenador = new daoEntrenador();
               daoEntrenador.setClausulaWhere(" WHERE usuario='"+usuarioLog+"'");
               if(!daoEntrenador.listar().isEmpty()){
                     out.print("<div class='container-logo'>");
             out.print("<h1 style='color: #FFFFFF'>GYM&nbsp;</h1><h1> Fitness</h1>");
         out.print("<br>");
         out.print("<h1>Club</h1>");
        out.print(" </div>");
        
        
                       out.print("  <div id='navegador'>");
           out.print("  <ul>");
               out.print("  <li><a href='home.jsp'>Home</a></li>");
              out.print("   <li><a href='evaluacion.jsp'>Evaluaciones</a></li>");
              out.print("   <li><a href='adminRegistro.jsp'>Registro Entrenador</a></li>");
              out.print("   <li><a href='adminBuscar.jsp'>Buscar Entrenador</a></li>");
              out.print("   <li><a href='usuarioBuscar.jsp'>Buscar Usuario</a></li>");
              out.print("    <li><a href='logout'>logout</a></li>");
           out.print("  </ul>");
        out.print(" </div>");
        
  
        out.print(" <br>");
         out.print("<form method='POST' action='actualizaEntrenador2' onsubmit='return valida()'>");
          out.print("   <center>");
             out.print("    <div class='container-registro'  style='background: #2196F3'>");
        
              out.print("   <H1 id='tituloRegistro'>Actualizar entrenador</H1>");
              
              
                  String entrenador="";
                 String nombre = "";
                 String apellidop = "";
                 String apellidom = "";
                 String fechaNacimiento = "";
                 String passwordOld = "";
                 int idGenero = 0;
                 List<persona> datos = new ArrayList();
                 List<usuario> datos2 = new ArrayList();
                  List<profesion> datos3 = new ArrayList();
                 datos =  (List<persona>)   request.getAttribute("persona");
                 datos2 =  (List<usuario>)   request.getAttribute("usuario");
                 datos3 =  (List<profesion>) request.getAttribute("entrenador");
                 for(persona e:datos){
                     entrenador = e.getUsuario();
                     passwordOld = e.getClave();
                     nombre = e.getNombre();
                     apellidop = e.getApellidoPat();
                     apellidom = e.getApellidoMat();
                 }
                 for(usuario u: datos2){
                     fechaNacimiento = u.getFechaNacimiento();
                     idGenero = u.getGenero();
                 }
                 
                 out.print("<input type='text' value="+entrenador+" name='usuario'  maxlength='50' readonly />");
                out.print("<br><br>");
                out.print("<input type='password' name='password1' id='idPassword1'  placeholder='Password' maxlength='50' min='4'/>");
                out.print("<br><br>");
                out.print("<input type='password' name='password2'  id='idPassword2' placeholder='Repita su password' maxlength='50' min='4'  />");
                out.print("<br><br>");
                out.print("<input type='text' value="+apellidop+"  maxlength='50' readonly/>");
                out.print("<br><br>");
                out.print("<input type='text' value="+apellidom+" Paterno' maxlength='50' readonly />");
                out.print("<br><br>");
                out.print("<input type='text' value="+passwordOld+"  Materno' maxlength='50' readonly />");
                out.print("<br><br>");
                out.print("<label style='color: #FFFFFF'>Fecha nacimiento: </label><br>");
                out.print("<input type='date' value="+fechaNacimiento+"  readonly />");
                out.print("<br><br>");
                out.print("<label style='color: #FFFFFF'>Sexo</label><br>");
                if(idGenero==1){
                     out.print("<label style='color: #FFFFFF'>Masculino</label><input type='radio' name='rb'  readonly />");
                      out.print("<label style='color: #FFFFFF'>Femenino</label><input type='radio' name='rb' checked  readonly />");
                }
                else if (idGenero == 2){
                     out.print("<label style='color: #FFFFFF'>Masculino</label><input type='radio' name='rb' checked readonly />");
                    out.print("<label style='color: #FFFFFF'>Femenino</label><input type='radio' name='rb'  readonly />");
                }
                
               
                out.print("<br><br>");
                out.print("<select id='IDprofesion' name='profesion'>");
                out.print("<option value='0'>Seleccione la profesion</option>");
                for(profesion en:datos3){
                out.print("<option value='"+en.getIdProfesion()+"'>"+en.getProfesion()+"</option>");
             
                }
  
                out.print("</select>");
                out.print("<br><br>");
                out.print("<input style='width: 200px' type='submit' value='Enviar'>");
                out.print("<br><br>");
                out.print("</div>");
                
                
            out.print("</center>");
         out.print("</form>");
                
                
              
              
              
               }
               else{
                   out.print("<center><div><h1>Acceso no permitido</h1><br></div></center>");
               }
        
        
        %>
        
        
           
                

        
        
    </body>
</html>
