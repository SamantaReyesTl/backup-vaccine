const enviar = document.querySelector("#Enviar");

async function altaPersona(arrayCheck) {
    await window.fetch("http://127.0.0.1:8080/api/v1/altaPersona", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "apellidoPaterno":arrayCheck['apellidoPaterno'],
            "apellidoMaterno":arrayCheck['apellidoMaterno'],
            "nombre": arrayCheck['nombre'],
            "curp": arrayCheck['curp'],
            "fechaNacimiento":arrayCheck['fechaNacimiento'],
            "calle":arrayCheck['calle'],
            "numeroCasa":arrayCheck['numeroCasa'],
            "coloniaLocalidad":arrayCheck['colonia'],
            "municipioAlcaldia":arrayCheck['municipio'],
            "comunidad":arrayCheck['comunidad'],
            "entidadFederativa":arrayCheck['entidadFederativa'],
            "codigoPostal":arrayCheck['cp'],
            "lugarNacimiento": arrayCheck['lugarNacimiento']
        })
    })  .then(response => console.log(response))
        .catch(e => console.log(e));

    await window.fetch("http://127.0.0.1:8080/api/v1/altaRegistroClinicoBasico", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "curp_personas":arrayCheck['curp'],
            "tipoSangre":arrayCheck['tipoSangre'],
            "peso":arrayCheck['peso'],
            "altura":arrayCheck['altura'],
            "sexo":arrayCheck['sexo'],
            "alergias":arrayCheck['alergias']
        })
    })  .then(response => console.log(response))
        .catch(e => console.log(e));
}

enviar.addEventListener("click", (event) => {
    let arrayCheck = {};

    arrayCheck['apellidoPaterno'] = document.querySelector("#apellido-paterno").value;
    arrayCheck['apellidoMaterno'] = document.querySelector("#apellido-materno").value;
    arrayCheck['nombre'] = document.querySelector("#nombre").value;
    arrayCheck['curp'] = document.querySelector("#curp").value;
    arrayCheck['fechaNacimiento'] = document.querySelector("#fecha-nacimiento").value;
    arrayCheck['calle'] = document.querySelector("#calle").value;
    arrayCheck['numeroCasa'] = document.querySelector("#num-casa").value;
    arrayCheck['colonia'] = document.querySelector("#colonia").value;
    arrayCheck['municipio'] = document.querySelector("#municipio").value;
    arrayCheck['comunidad'] = document.querySelector("#comunidad").value;
    arrayCheck['entidadFederativa'] = document.querySelector("#entidad-federativa").value;
    arrayCheck['cp'] = document.querySelector("#cp").value;
    arrayCheck['lugarNacimiento'] = document.querySelector("#lugar-nacimiento").value;
    arrayCheck['tipoSangre'] = document.querySelector("#tipo-sangre").value;
    arrayCheck['peso'] = document.querySelector("#peso").value;
    arrayCheck['altura'] = document.querySelector("#altura").value;
    arrayCheck['alergias'] = document.querySelector("#alergias").value;

    if (document.querySelector("#sexo-M").checked) { // gendre body param
        arrayCheck['sexo'] = 0;
    } else {
        arrayCheck['sexo'] = 1;
    }
    
    console.log(arrayCheck);
    altaPersona(arrayCheck);
});