//Creamos una matriz JSON para almacenar los datos de la tabla
//import {connection} from "config.js";
//const connection = require('config.js');

//const connection = require('config');

//const connection = require('./config');

const connection = require('./config.js');

//load the mysql connection
//const connection = require('config');
const app=requiere('express');

//exportamos la conexión para que cualquier otro archivo la pueda usar
module.exports = {
    //función para obtener todos los datos de la tabla
    get: function (callback) {      //callback es una función que se ejecuta cuando se llama a la función get
        connection.query('SELECT * FROM nueva_vacuna', callback);   //ejecutamos la consulta y llamamos a la función callback con los resultados
    }  
};

//usamos metodo pool.query para ejecutar la consulta
 pool.query('SELECT * FROM nueva_vacuna', (error, results) => {  //results es el resultado de la consulta
     if (error) { throw error; }    //si hay error, lo lanzamos
        response.status(200).json(results); //si no hay error, devolvemos el resultado de la consulta
});

//Display a single vacuna by ID
app.get('/nueva_vacuna/:id', (request, response) => {    //creamos la ruta para obtener un registro por id
    const id = request.params.id;   //obtenemos el id de la url
    pool.query('SELECT * FROM nueva_vacuna WHERE id = ?', id, (error, results) => {  //ejecutamos la consulta
        if (error) { throw error; } //si hay error, lo lanzamos
        response.status(200).json(results); //si no hay error, devolvemos el resultado de la consulta
    });
});

//Add a new vacuna *checar esta parte*
app.post('/vaccine', (request, response) => {   //creamos la ruta para añadir un registro
    pool.query('INSERT INTO nueva_vacuna(nombre_vacuna, folio, cantidad_dosis, dosis, periodo,descripcion) VALUES (?, ?, ?, ?, ?, ?)', 
    request.body, (error, result) => {  //ejecutamos la consulta con los datos de request.body  (que contendrá los datos del registro a insertar)
        if (error) throw error;     //hacemos lo mismo del erro
            response.status(201).send(`Vacuna added with ID: ${result.insertId}`);   //si no hay error, devolvemos el id del registro insertado
        }
    );
});


//update an existing vacuna in the database
app.put('/vaccine/:id', (request, response) => {    //creamos la ruta para actualizar un registro
    const id = request.params.id;   //obtenemos el id de la url
    pool.query('UPDATE nueva_vacuna SET ? WHERE id = ?', [request.body, id], (error, result) => {    //ejecutamos la consulta
        if (error) { throw error; } //si hay error, lo lanzamos
        response.status(200).send(`Vacuna modified with ID: ${id}`);   //si no hay error, devolvemos el id del registro actualizado
    });
});









/**
 * //Add a new vacuna *checar esta parte*
    app.post('/vaccine', (request, response) => {   //creamos la ruta para añadir un registro
        pool.query(
            `INSERT INTO nueva_vacuna (
            nombre_vacuna, folio, cantidad_dosis, dosis, 
            periodo, descripcion) VALUES('${variable}', '${variable}')'`,
            (error, result) => {  //ejecutamos la consulta
                if (error) { throw error; } //si hay error, lo lanzamos
                response.status(201).send(`Vacuna added with ID: ${result.insertId}`);   //si no hay error, devolvemos el id del registro insertado
            }
        );
    });
 * 
 * 
 * 
 * 
 */