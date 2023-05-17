const enviar = document.querySelector("#Enviar");
const updateInputsSeguro = document.querySelectorAll(".seguro-medico-hidden");

function altaPersona(arrayCheck) {
    window.fetch("http://127.0.0.1:8080/api/v1/altaPersona", {
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
            "coloniaLocalidad":arrayCheck['colonia'],
            "municipioAlcaldia":arrayCheck['municipio'],
            "entidadFederativa":arrayCheck['entidadFederativa'],
            "codigoPostal":arrayCheck['cp'],
            "lugarNacimiento": arrayCheck['lugarNacimiento'],
            "tipoSangre":arrayCheck['tipoSangre'],
            "peso":arrayCheck['peso'],
            "altura":arrayCheck['altura'],
            "matriculaSeguro":arrayCheck['matriculaSeguro'],
            "sexo":arrayCheck['sexo']
        })
    })  .then(response => response.json())
        .then(responseJSON => console.log(responseJSON))
        .catch(e => console.log(e));
}

enviar.addEventListener("click", (event) => {
    let arrayCheck = {};

    arrayCheck['apellidoPaterno'] = document.querySelector("#apellido-paterno").value;
    arrayCheck['apellidoMaterno'] = document.querySelector("#apellido-materno").value;
    arrayCheck['nombre'] = document.querySelector("#nombre").value;
    arrayCheck['curp'] = document.querySelector("#obtener-curp").value;
    arrayCheck['fechaNacimiento'] = document.querySelector("#fecha-nacimiento").value;
    arrayCheck['calle'] = document.querySelector("#calle").value;
    arrayCheck['colonia'] = document.querySelector("#colonia").value;
    arrayCheck['municipio'] = document.querySelector("#municipio").value;
    arrayCheck['entidadFederativa'] = document.querySelector("#entidad-federativa").value;
    arrayCheck['cp'] = document.querySelector("#cp").value;
    arrayCheck['lugarNacimiento'] = document.querySelector("#lugar-nacimiento").value;
    arrayCheck['tipoSangre'] = document.querySelector("#tipo-sangre").value;
    arrayCheck['peso'] = document.querySelector("#peso").value;
    arrayCheck['altura'] = document.querySelector("#altura").value;

    arrayCheck['seguroMedico'] = document.querySelector("#seguro-medico-si");
    if (arrayCheck['seguroMedico'].checked) { // matricula body param
        arrayCheck['matriculaSeguro'] = document.querySelector("#matricula-seguro").value;
    } else {
        arrayCheck['matriculaSeguro'] = '';
    }

    if (document.querySelector("#sexoM").checked) { // gendre body param
        arrayCheck['sexo'] = "M";
    } else {
        arrayCheck['sexo'] = "H";
    }

    for (let element in arrayCheck) {
        if (element === 'matriculaSeguro') continue;
        if (arrayCheck[element].value === '') return;
    }

    event.preventDefault();
    altaPersona(arrayCheck);
});

const updateInputsSeguroArray = Array.from(updateInputsSeguro);

updateInputsSeguroArray.forEach(tag => {
    tag.addEventListener("click", () => {
        const elementSi = document.querySelector("#seguro-medico-si");
        const updateTag = document.querySelector("#matricula-seguro");
    
        if (!elementSi.checked) {
            updateTag.classList.add("hidden");
            updateTag.removeAttribute('required');
        } else {
            updateTag.classList.remove("hidden");
            updateTag.setAttribute('required', '');
        }

        // future: updateTag.classList.toggle("hidden");
    });
});