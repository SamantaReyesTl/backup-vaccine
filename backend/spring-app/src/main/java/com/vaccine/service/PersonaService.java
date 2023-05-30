package com.vaccine.service;

import com.vaccine.jdbc.ConexionCreada;
import com.vaccine.model.PersonasModel;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.vaccine.ultil.PersonaUtil.prepare;

/**
 * Aqui comienza lo complicado, aqui se hace la logica de la aplicacion.
 */

public class PersonaService {
    public ResponseEntity<Object> consultarPersona(String curp) {
        ConexionCreada conexionCreada = new ConexionCreada(); // se crea una instancia de la clase manejadora de Conexiones
        Connection connection = conexionCreada.getConnection(); // se obtiene la conexion

        String query =  "SELECT " + // se crea la query para obtener los datos de la persona
                            "personas.* " +
                        "FROM " +
                            "personas " +
                        "WHERE " +
                            "personas.curp = '" + curp + "'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query); // la conexion se vuelve en statement
            ResultSet resultSet = preparedStatement.executeQuery(); // se ejecuta el statement lo cual duelve
                                                                    // un set de resultados (arreglo de resultados)

            PersonasModel personaModel = null; // se prepara un objeto de persona
            while (resultSet.next()) { // mientras que este set tenga resultados
                 personaModel = new PersonasModel( // se crea un objeto de tipo persona con los datos obtenidos
                         resultSet.getString("curp"),
                        resultSet.getString("nombre"), resultSet.getString("apellido_paterno"),
                        resultSet.getString("apellido_materno"), resultSet.getString("fecha_nacimiento"), resultSet.getInt("edad"),
                        resultSet.getString("calle"), resultSet.getString("numero_casa"),
                        resultSet.getString("colonia_localidad"), resultSet.getString("comunidad"),
                        resultSet.getString("codigo_postal"), resultSet.getString("entidad_federativa"),
                        resultSet.getString("lugar_nacimiento"));}

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body(personaModel); // se regresa el objeto de persona pedido
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error: " + e);
        }
    }

    public ResponseEntity<Object> altaPersona(PersonasModel personaModel) {
        ConexionCreada conexionCreada = new ConexionCreada(); // se crea una instancia de la clase manejadora de Conexiones
        Connection connection = conexionCreada.getConnection(); // se obtiene la conexion

        // Se crean las queries para insertar los datos en las tablas correspondientes
        String queryPersonas = "INSERT INTO " +
                                    "personas " +
                                    "(curp, nombre, " +
                                    " apellido_paterno, apellido_materno, fecha_nacimiento, edad, calle, numero_casa," +
                                    " colonia_localidad, comunidad, codigo_postal," +
                                    " entidad_federativa, lugar_nacimiento) " +
                                "VALUES " +
                                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Tener cuidado pues se esta ocupando bind param o prepare statement lo que quiere decir que
        // se debe de poner el signo de interrogacion en donde se quiere que se inserte el valor

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryPersonas); // la conexion devuelve un prepare statement
            preparedStatement.setString(1, personaModel.getCurp());
            preparedStatement.setString(2, personaModel.getNombre());
            preparedStatement.setString(3, personaModel.getApellidoPaterno());
            preparedStatement.setString(4, personaModel.getApellidoMaterno());
            preparedStatement.setString(5, personaModel.getFechaNacimiento());
            preparedStatement.setInt(6, 0);
            preparedStatement.setString(7, personaModel.getCalle());
            preparedStatement.setString(8, personaModel.getNumeroCasa());
            preparedStatement.setString(9, personaModel.getColoniaLocalidad());
            preparedStatement.setString(10, personaModel.getComunidad());
            preparedStatement.setString(11, personaModel.getCodigoPostal());
            preparedStatement.setString(12, personaModel.getEntidadFederativa());
            preparedStatement.setString(13, personaModel.getLugarNacimiento());
            preparedStatement.executeUpdate();

            //ResultSet resultSet = preparedStatement.getGeneratedKeys(); // se obtienen las llaves generadas
            //resultSet.next(); // se obtiene la llave generada

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Se insertaron los datos correctamente");
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al insertar los datos: "+e);
        }
    }

    public ResponseEntity<Object> actualizarPersona(String curp, PersonasModel personaModel) {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();

        String queryPersonas = "UPDATE " +
                                    "personas " +
                                "SET " +
                                    "curp = ?, nombre = ?, apellido_paterno = ?, apellido_materno = ?" +
                                    ", fecha_nacimiento = ?, edad = ?, calle = ?, numero_casa = ?, colonia_localidad = ?" +
                                    ", comunidad = ?, codigo_postal = ?, entidad_federativa = ?" +
                                    ", lugar_nacimiento = ? " +
                                "WHERE " +
                                    "curp = '" + curp + "'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryPersonas);
            prepare(preparedStatement, personaModel);
            preparedStatement.executeUpdate();

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok("Datos actualizados correctamente");
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al actualizar los datos: "+e);
        }
    }

    public ResponseEntity<Object> bajaPersona(String curp) {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();

        String queryPersonas = "DELETE FROM " +
                                    "personas " +
                                "WHERE " +
                                    "curp = '" + curp + "'";

        // Nos servira a futuro:
        /*String queryDatosClinicos = "DELETE FROM datos_clinicos WHERE datos_clinicos_id = " +
                "(SELECT datos_clinicos_id FROM personas WHERE curp = " + curp + ")";*/

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryPersonas);
            preparedStatement.executeUpdate();

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok("Datos eliminados correctamente");
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al eliminar los datos: "+e);
        }
    }

    public ResponseEntity<Object> consultarPersonas() {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();
        ArrayList<PersonasModel> personasModels = new ArrayList<>();
        try {
            String query =  "SELECT " +
                                    "personas.* " +
                            "FROM " +
                                    "personas";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PersonasModel personaModel = new PersonasModel(
                        resultSet.getString("curp"),
                        resultSet.getString("nombre"), resultSet.getString("apellido_paterno"),
                        resultSet.getString("apellido_materno"), resultSet.getString("fecha_nacimiento"), resultSet.getInt("edad"),
                        resultSet.getString("calle"), resultSet.getString("numero_casa"),
                        resultSet.getString("colonia_localidad"), resultSet.getString("comunidad"),
                        resultSet.getString("codigo_postal"), resultSet.getString("entidad_federativa"),
                        resultSet.getString("lugar_nacimiento"));
                personasModels.add(personaModel);
            }

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body(personasModels);
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error: " + e);
        }
    }
}
