debugger
export function valida(input) {                             // se exporta para poderlo usar en otros lugares del codigo
    const tipoDeInput = input.dataset.tipo;                 //con dataset obtenemos toda la colección de los data, y con tipo el data que pusimos en el html
    if (validadores[tipoDeInput]) {
        validadores[tipoDeInput](input);
    }

    if(input.Validity.valid){                               // si es valido que quite la clase 
        input.parentElement.classList.remove("input-container--invalid");
        input.parentElement.querySelector(".input-message-error").innerHTML = "";
    } else{                                                 //sino poner la clase
        input.parentElement.classList.add("input-container--invalid");
        input.parentElement.querySelector(".input-message-error").innerHTML = mostrarMensajeError(tipoDeInput, input);
    }
}   
  
const tipoDeErrores = [
    "valueMissing", "typeMismatch", "patternMismatch", "CustomError"
];

const mensajesDeError = {                                   // mejor organizacion de codigo
    nombre: {
        valueMissing: "Este campo Nombre no puede estar vacío"
    },
    password: {
        valueMissing: "Este campo Contraseña no puede estar vacío",
        patternMismatch: "Al menos 6 caracteres, máximo 12, debe contener una letra minúscula, una letra mayúscula, un número y no puede contener caracteres especiales."
    }

};


function mostrarMensajeError(tipoDeInput, input){           //ayudara a acceder a los mensajes de error
    let mensaje = "";
    tipoDeErrores.forEach( error => {
        if (input.Validity[error]){                         // si es true el mensaje sera "El campo no puede estar vacio"
            console.log(tipoDeInput, error);
            console.log(input.Validity[error]);
            console.log(mensajesDeError[tipoDeInput][error]);
            mensaje = mensajesDeError[tipoDeInput];
        }
    });

    return mensaje;
}

