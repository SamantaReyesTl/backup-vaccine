const enviar = document.querySelector("#Enviar");
const updateInputsSeguro = document.querySelectorAll(".seguro-medico-hidden");

enviar.addEventListener("click", (event) => {
    let arrayCheck = {};

    arrayCheck['apellidoPaterno'] = document.querySelector("#apellido-paterno");
    arrayCheck['apellidoMaterno'] = document.querySelector("#apellido-materno");
    arrayCheck['nombre'] = document.querySelector("#nombre");
    arrayCheck['curp'] = document.querySelector("#curp");
    arrayCheck['fechaNacimiento'] = document.querySelector("#fecha-nacimiento");
    arrayCheck['calle'] = document.querySelector("#calle");
    arrayCheck['colonia'] = document.querySelector("#colonia");
    arrayCheck['municipio'] = document.querySelector("#municipio");
    arrayCheck['entidadFeredativa'] = document.querySelector("#entidad-federativa");
    arrayCheck['cp'] = document.querySelector("#cp");
    arrayCheck['lugarNacimiento'] = document.querySelector("#lugar-nacimiento");
    arrayCheck['tipoSangre'] = document.querySelector("#tipo-sangre");
    arrayCheck['peso'] = document.querySelector("#peso");
    arrayCheck['altura'] = document.querySelector("#altura");

    // Poner logica de seguro medico
    arrayCheck['seguroMedico'] = document.querySelector("#seguro-medico-si");

    if (arrayCheck['seguroMedico'].checked) { // hay un bug, hay dos ids mismos
        console.log("La persona cuenta con seguro medico");
    }

    arrayCheck['matriculaSeguro'] = document.querySelector("#matricula-seguro");

    // Poner logica del sexo
    arrayCheck['sexo'] = document.querySelector("#H");    
    let sexoM = document.querySelector("#M");
    let sexoH = document.querySelector("#H");

    for (let element in arrayCheck) {
        if (arrayCheck[element].value === '') {
            return;
        }
    }

    event.preventDefault();
    console.log(arrayCheck);
}); // todo: arriba y radio buttons

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