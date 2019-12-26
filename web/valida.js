function validacion(){
   var user = document.getElementById("user").value;
   var password = document.getElementById("password").value;
   if(user == "" ||  password == ""){
       alert("Favor de rellenar todos los campos.");
       return false;
   }
}


function validacion_registro(){
   var user = document.getElementById("user").value;
   var profesion = document.getElementById("IDprofesion").value;
   if(user == ""){
       alert("Favor de rellenar todos los campos.");
       return false;
   }
   else if(profesion == "0"){
       alert("Favor de seleccionar una profesion valida.");
       return false
   }
   
}
function validacion_buscar(){
   var user = document.getElementById("user").value;

   if(user == ""){
       alert("Favor de rellenar todos los campos.");
       return false;
   }

   
}