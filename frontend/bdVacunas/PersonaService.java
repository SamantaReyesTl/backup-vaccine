package com.vaccine.service;

import com.vaccine.jdbc.Conexion;
import com.vaccine.model.PersonasModel;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Aqui comienza lo complicado, aqui se hace la logica de la aplicacion.
 */

public class PersonaService {
    public PersonasModel consultarPersona(String curp) {
        Conexion conexion = new Conexion(); // se crea una instancia de la clase manejadora de Conexiones
        Connection connection = conexion.getConnection(); // se obtiene la conexion

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
                 personaModel = new PersonasModel( // se crea un objeto de tipo persona
                                                                // con los datos obtenidos
                        resultSet.getInt("id"), resultSet.getString("curp"),
                        resultSet.getString("nombre"), resultSet.getString("apellido_paterno"),
                        resultSet.getString("apellido_materno"), resultSet.getDate("fecha_nacimiento"),
                        resultSet.getInt("edad"), resultSet.getString("calle"), 
                        resultSet.getString("numero_casa"), resultSet.getString("colonia_localidad"), 
                        resultSet.getString("municipio_alcaldia"), resultSet.getString("codigo_postal"), resultSet.getString("entidad_federativa"),
                        resultSet.getString("lugar_nacimiento"));
            }
            return personaModel; // se regresa el objeto de persona pedido
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            conexion.cerrarConexion();
        }

        return null;
    }

    public ResponseEntity<Object> altaPersona(PersonasModel personaModel) {
        Conexion conexion = new Conexion(); // se crea una instancia de la clase manejadora de Conexiones
        Connection connection = conexion.getConnection(); // se obtiene la conexion

        // Se crean las queries para insertar los datos en las tablas correspondientes
        String queryPersonas = "INSERT INTO " +
                                    "personas " +
                                    "(curp, nombre, " +
                                    " apellido_paterno, apellido_materno, fecha_nacimiento, edad, calle, numero_casa," +
                                    " colonia_localidad, municipio_alcaldia, codigo_postal," +
                                    " entidad_federativa, lugar_nacimiento) " +
                                "VALUES " +
                                "(?, ?, ?, ?, ?, TIMESTAMPDIFF(YEAR, ?, CURDATE()), ?, ?, ?, ?, ?, ?, ?)";

        // Tener cuidado pues se esta ocupando bind param o prepare statement lo que quiere decir que
        // se debe de poner el signo de interrogacion en donde se quiere que se inserte el valor

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryPersonas); // la conexion devuelve un prepare statement
            preparedStatement.setString(1, personaModel.getCurp());
            preparedStatement.setString(2, personaModel.getNombre());
            preparedStatement.setString(3, personaModel.getApellidoPaterno());
            preparedStatement.setString(4, personaModel.getApellidoMaterno());
            preparedStatement.setDate(5, personaModel.getFechaNacimiento());
            // La fecha de nacimiento se pasa dos veces como parámetro: una vez para el campo fecha_nacimiento 
            //y otra vez para el cálculo de la edad.
            preparedStatement.setDate(6, personaModel.getFechaNacimiento());

            preparedStatement.setString(7, personaModel.getCalle());
            preparedStatement.setString(8, personaModel.getNumeroCasa());
            preparedStatement.setString(9, personaModel.getColoniaLocalidad());
            preparedStatement.setString(10, personaModel.getMunicipioAlcaldia());
            preparedStatement.setString(11, personaModel.getCodigoPostal());
            preparedStatement.setString(12, personaModel.getEntidadFederativa());
            preparedStatement.setString(13, personaModel.getLugarNacimiento());
            preparedStatement.executeUpdate();

            // A futuro servira:
            // ResultSet resultSet = preparedStatement.getGeneratedKeys(); // se obtienen las llaves generadas

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return ResponseEntity.badRequest().body("Error al insertar los datos: "+e);
        } finally {
            conexion.cerrarConexion();
        }

        return ResponseEntity.ok("Datos insertados correctamente");
    }

    public ResponseEntity<Object> actualizarPersona(String curp, PersonasModel personaModel) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        String queryPersonas = "UPDATE " +
                                    "personas " +
                                "SET " +
                                    "curp = ?, nombre = ?, apellido_paterno = ?, apellido_materno = ?" +
                                    ", fecha_nacimiento = ?, edad = TIMESTAMPDIFF(YEAR, ?, CURDATE()), calle = ?, numero_casa = ?, colonia_localidad = ?" +
                                    ", municipio_alcaldia = ?, codigo_postal = ?, entidad_federativa = ?" +
                                    ", lugar_nacimiento = ? " +
                                "WHERE " +
                                    "curp = '" + curp + "'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryPersonas);
            preparedStatement.setString(1, curp);
            preparedStatement.setString(2, personaModel.getNombre());
            preparedStatement.setString(3, personaModel.getApellidoPaterno());
            preparedStatement.setString(4, personaModel.getApellidoMaterno());
            preparedStatement.setDate(5, personaModel.getFechaNacimiento());
            // La fecha de nacimiento se pasa dos veces como parámetro: una vez para el campo fecha_nacimiento 
            //y otra vez para el cálculo de la edad.
            preparedStatement.setDate(6, personaModel.getFechaNacimiento());

            preparedStatement.setString(7, personaModel.getCalle());
            preparedStatement.setString(8, personaModel.getNumeroCasa());
            preparedStatement.setString(9, personaModel.getColoniaLocalidad());
            preparedStatement.setString(10, personaModel.getMunicipioAlcaldia());
            preparedStatement.setString(11, personaModel.getCodigoPostal());
            preparedStatement.setString(12, personaModel.getEntidadFederativa());
            preparedStatement.setString(13, personaModel.getLugarNacimiento());
            preparedStatement.executeUpdate();

            return ResponseEntity.ok("Datos actualizados correctamente");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return ResponseEntity.badRequest().body("Error al actualizar los datos: "+e);
        } finally {
            conexion.cerrarConexion();
        }
    }

    public ResponseEntity<Object> bajaPersona(String curp) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        String queryPersonas = "DELETE FROM personas WHERE curp = '" + curp + "'";

        // Nos servira a futuro:
        /*String queryDatosClinicos = "DELETE FROM datos_clinicos WHERE datos_clinicos_id = " +
                "(SELECT datos_clinicos_id FROM personas WHERE curp = " + curp + ")";*/

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryPersonas);
            preparedStatement.executeUpdate();
            return ResponseEntity.ok("Datos eliminados correctamente");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return ResponseEntity.badRequest().body("Error al eliminar los datos: "+e);
        } finally {
            conexion.cerrarConexion();
        }
    }
}