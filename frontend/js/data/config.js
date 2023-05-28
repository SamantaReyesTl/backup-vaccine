/**
 * Conectamos a MySQL con los datos de conexión que hemos creado en el archivo config.js
 */
const mysql = require('mysql');    // Importamos el módulo mysql

const config = {    // Creamos un objeto con los datos de conexión
    host: 'localhost', // Nombre del host o IP del servidor de MySQL (si se ejecuta de manera local, el host es localhost)
    user: 'root',
    password: 'root',
    database: 'nueva_vacuna' // Nombre de la base de datos
};

//Creamos la conexión a la base de datos
const connection = mysql.createConnection(config);

//Abrimos la conexión
connection.connect((err) => {
    if (err) {
        console.log('Error de conexión: ' + err.stack);
        return;
    }
    console.log('Conexión establecida con la base de datos');
});

//Exportamos la conexión para que cualquier otro archivo la pueda usar
export connection;



/**
 * //exportamos la conexión para que cualquier otro archivo la pueda usar
//module.exports = connection;
module.exports = {
    connection: connection
};
 * 
 * 
 */



