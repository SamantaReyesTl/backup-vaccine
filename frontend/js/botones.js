/**
 * funcion que al dar click en el boton te lleva a la pagina de inicio
 */
function formulario(){
    window.location.href = "formulario.html";
}

function nuevaVacuna(){
    window.location.href = "registro_nuevaVacuna.html";
}
function buscarPersona(){
    window.location.href = "buscar_paciente.html";
}
function registroVacuna(){
    window.location.href = "registro_vacuna.html";
}
/*botones de inicio persona/paciente */
function mostrar(){
    window.location.href = "";
}
function actualizar(){
    window.location.href = "al";
}
function eliminar(){
    window.location.href = "";
}
/*btones de administrador */
function usuarios(){
    window.location.href = "opcion_usuario.html";
}
function vacunas(){
    window.location.href = "opcion_vacunas.html";
}

/** metodo para que solo se pueda seleccionar una opcion del checkbox */
function check(id){
    var check = document.getElementById(id);
    if(check.checked){
        check.checked = false;
    }else{
        check.checked = true;
    }
}
