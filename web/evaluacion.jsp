<%-- 
    Document   : index.jsp
    Created on : 26-oct-2019, 19:20:00
    Author     : farias
--%>

<%@page import="modelo.daoEntrenador"%>
<%@page import="modelo.daoMedicion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.medicion"%>
<%@page import="java.util.List"%>
<%@page import="controlador.Sevaluacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
         <link rel="stylesheet" type="text/css" href="css/general.css"/>
        <link rel="stylesheet" type="text/css" href="css/navegator.css"/>
        <title>GymFitness</title>
    </head>
    <body>
        <%  
             Object usuario = session.getAttribute("usuario");
            if(usuario != null){
           
             medicion medicion = new medicion(0,"", 0, 0, 0, 0, 0, 0, "", "", "");
           
            daoMedicion dMedicion = new daoMedicion();
            dMedicion.setClausulaWhere("where personausuario='"+usuario+"'");
           List<medicion> datos = new ArrayList();
            datos =  (List<medicion>)  dMedicion.listar();
            
             out.print("<div class='container-logo'>");
            out.print("<h1 style='color: #FFFFFF'>GYM&nbsp;</h1><h1> Fitness</h1>");
        out.print("<br>");
        out.print("<h1>Club</h1>");
      
        out.print("</div>");
        
                out.print("<div id='navegador'>");
            out.print("<ul>");
                out.print("<li><a href='home.jsp'>Home</a></li>");
               out.print("<li><a href='evaluacion.jsp'>Evaluaciones</a></li>");
               daoEntrenador daoEntrenador = new daoEntrenador();
               daoEntrenador.setClausulaWhere(" WHERE usuario='"+usuario+"'");
               if(!daoEntrenador.listar().isEmpty()){
                    out.print("<li><a href='adminBuscar.jsp'>Admin</a></li>");
               }
              
                out.print("<li><a href='logout'>logout</a></li>");
            
            out.print("</ul>");
        out.print("</div>");
        
       out.print("<form method='POST'  action='evaluaciones' onsubmit='return validacion()'>");
            out.print("<div class='login-container'>");
                out.print("<div class='input-container'>");
                out.print("<center><h3>Evaluaciones</h3></center> ");            
               out.print(" <br><br>");
                out.print("<input type='text' value="+usuario+" name='usuario' style='display:none;'>");
                
                
                        out.print("<select name='idEvaluacion' required>");
                   out.print(" <option value=''>Seleccione una evaluacion</option>");
                        for(medicion e:datos){
                        out.print("<option value="+e.getId()+">"+e.getFecha()+"</option>");
                    }
                    out.print(" </select>");
                    
                    
                    
               out.print(" <br><br>");
                out.print("<input type='submit' value='Buscar'/>");
                out.print("<br>");
                out.print("<br>");

                out.print("</div>");
            out.print("</div>");
                        
                          List<medicion> datos2 = new ArrayList();
                    String fecha="";
                    String entrenador="";
                    int estatura = 0;
                    int peso = 0;
                    int medidaCintura = 0;
                    float porcentajeGrasa = 0;
                    float imc = 0;
                    float grasaInstrumento = 0;
                     datos2 = (ArrayList<medicion>) request.getAttribute("arreglo");
                     if(datos2 != null ){
                         for(medicion e:datos2){
                           fecha = e.getFecha();
                           estatura = e.getEstatura();
                           peso = e.getPeso();
                           medidaCintura = e.getMedidaCintura();
                           porcentajeGrasa = e.getPorcentajeGrasa();
                           imc = e.getImc();
                           grasaInstrumento = e.getIndiceGrasaInstrumento();
                           entrenador = e.getEntrenador();
                     }
                     if( fecha != ""){
                     out.print("<div class='login-container'>");
                    out.print("<div class='input-container'>");
                    out.print("<center><h3>Informacion</h3></center>");
                    out.print("<center>");
                    out.print("<label>Fecha: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' value="+fecha+" readonly></label><br><br>");
                    out.print("<label>Estatura: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' value="+estatura+" readonly></label><br><br>");
                    out.print("<label>Peso: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' value="+peso+" readonly></label><br><br>");
                    out.print("<label>Medida cintura:&nbsp&nbsp <input type='text' value="+medidaCintura+" readonly></label><br><br>");
                    out.print("<label>Porcentaje grasa: <input type='text' value="+porcentajeGrasa+" readonly></label><br><br>");
                    out.print("<label>imc: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' value="+imc+" readonly></label><br><br>");
                    out.print("<label>Indice grasaInst: <input type='text' value="+grasaInstrumento+" readonly></label><br><br>");
                    out.print("<label>Entrenador: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' value="+entrenador+" readonly></label><br><br>");
                    out.print("</center>");
                     }
                     
         
                    
                     }
                                    
                out.print("</div></div>");
       out.print(" </form>");
        
        }
        else{
             out.print("<center><div><h1>Acceso no permitido</h1><br><br><h3 style='color:black'>Favor de iniciar sesion</h3></div></center>");
        }
           
            
      
        %>
       
        
                
    
                
                    
    
          
           
    </body>
</html>
