const buscar = document.querySelector("#buscar_paciente");

async function buscarPaciente(arrayCheck) {
    let data = await window.fetch("http://localhost:8080/api/v1/obtenerPersona?curp="+arrayCheck['curp'], {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then(data => data)
        .catch(e => console.log(e));

    let dataR = await window.fetch("http://localhost:8080/api/v1/obtenerRegistroClinicoBasico?curp="+arrayCheck['curp'], {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then(data => data)
        .catch(e => console.log(e));

    console.log(data);
    if (!data) {
        alert("No se encontró a ningún paciente con la CURP ingresada");
        return;
    }

    const div = document.getElementById("response");
    div.innerHTML = "";

    let htmlInner = `
        <table class="table-response">
            <thead>
                <tr>
                    <th scope="col">CURP</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Fecha de nacimiento</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Tipo de sangre</th>
                    <th scope="col">Peso</th>
                    <th scope="col">Altura</th>
                    <th scope="col">Alergias</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${data.curp}</td>
                    <td>${data.nombre} ${data.apellidoPaterno} ${data.apellidoMaterno}</td>
                    <td>${data.fechaNacimiento}</td>
                    <td>${dataR.sexo? "Hombre" : "Mujer"}</td>
                    <td>${dataR.tipoSangre}</td>
                    <td>${dataR.peso}</td>
                    <td>${dataR.altura}</td>
                    <td>${dataR.alergias}</td>
                </tr>
            </tbody>
        </table>`;

    div.innerHTML = htmlInner;
}
    

buscar.addEventListener("click", (event) => {
    event.preventDefault();
    let arrayCheck = {};

    arrayCheck['curp'] = document.querySelector("#curp").value;

    if (arrayCheck['curp'] == "") {
        alert("Por favor, ingrese la CURP del paciente");
        return;
    }

    buscarPaciente(arrayCheck);
});