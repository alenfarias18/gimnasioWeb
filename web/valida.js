function validacion(){
   var user = document.getElementById("user").value;
   var password = document.getElementById("password").value;
   if(user == "" ||  password == ""){
       alert("Favor de rellenar todos los campos.");
       return false;
   }
}


