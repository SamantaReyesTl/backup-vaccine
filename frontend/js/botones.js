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
    window.location.href = "mostrar_registros_vacunas.html";
}
function actualizar(){
    window.location.href = "actualizar_registros_vacunacion.html";
}
function eliminar(){
    window.location.href = "eliminar_registros_vacunacion.html";
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
