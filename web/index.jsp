<%-- 
    Document   : index.jsp
    Created on : 26-oct-2019, 19:20:00
    Author     : farias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="valida.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
         <link rel="stylesheet" type="text/css" href="css/general.css"/>
        <title>GymFitness</title>
    </head>
    <body>
        <div class="container-logo">
            <h1 style="color: #FFFFFF">GYM&nbsp;</h1><h1> Fitness</h1>
        <br>
        <h1>Club</h1>
        </div>
        <form method="POST" action="validate" onsubmit="return validacion()">
            <div class="login-container">
                <div class="input-container">
                <center><h3>Login</h3></center>
                <input type="text" placeholder="Usuario" maxlength="50" name="user" id="user"/>
                <br><br>
                <input type="password" placeholder="Password" maxlength="50" name="password" id="password"/>
                <br><br>
                <input type="submit" value="Entrar"/>
                <center><p>¿No tiene una cuenta? <a href="registro.jsp">Cree una</a></p></center>
                </div>
            </div>
                <center>
                    
                    <img src="image/muscle.png" id="imgMuscle"/>
                    </div
                <center>
        </form>
    </body>
</html>
