package com.vaccine.service;

import com.vaccine.jdbc.Conexion;
import com.vaccine.model.DatosClinicosModel;
import com.vaccine.model.PersonasModel;
import com.vaccine.model.RegistroVacunaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Aqui comienza lo complicado, aqui se hace la logica de la aplicacion.
 */

public class PersonaService {
    public PersonasModel consultarPersona(String curp) {
        Conexion conexion = new Conexion(); // se crea una instancia de la clase manejadora de Conexiones
        Connection connection = conexion.getConnection(); // se obtiene la conexion

        List<PersonasModel> personaModelList = new ArrayList<>(); // se hace un arreglo por si acaso

        // Se crea la query para obtener los datos de la persona
        String query =  "SELECT " +
                            "personas.*, " +
                            "datos_clinicos.*, " +
                            "registro_vacunacion.* " +
                        "FROM " +
                            "personas " +
                            "INNER JOIN datos_clinicos ON datos_clinicos.id = personas.datos_clinicos_id " +
                            "INNER JOIN registro_vacunacion ON registro_vacunacion.id = personas.registro_vacuna_id " +
                        "WHERE " +
                            "personas.CURP = " + curp;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query); // la conexion se vuelve en statement
            ResultSet resultSet = preparedStatement.executeQuery(); // se ejecuta el statement lo cual duelve un set de resultados (arreglo de resultados)

            while (resultSet.next()) { // mientras que este set tenga resultados
                PersonasModel personaModel = new PersonasModel( // se crea un objeto de tipo persona con los datos obtenidos
                        resultSet.getInt("id"), resultSet.getString("curp"),
                        resultSet.getInt("datos_clinicos_id"), resultSet.getString("datos_clinicos_matricula"),
                        resultSet.getInt("registro_vacuna_id"),
                        resultSet.getString("nombre"), resultSet.getString("apellido_paterno"),
                        resultSet.getString("apellido_materno"), resultSet.getString("fecha_nacimiento"),
                        resultSet.getString("calle"), resultSet.getString("numero_casa"),
                        resultSet.getString("colonia_localidad"), resultSet.getString("municipio_alcaldia"),
                        resultSet.getString("codigo_postal"), resultSet.getString("entidad_federativa"),
                        resultSet.getString("lugar_nacimiento"),

                        new DatosClinicosModel(
                                resultSet.getInt("datos_clinicos_id"), resultSet.getString("tipo_sangre"),
                                resultSet.getString("matricula"), resultSet.getString("unidad_medica"),
                                resultSet.getString("sexo"), resultSet.getString("peso"),
                                resultSet.getString("altura")));

                personaModelList.add(personaModel);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            conexion.cerrarConexion();
        }

        return personaModelList.get(0);
    }

    public void altaPersona(PersonasModel personaModel) {
        Conexion conexion = new Conexion(); // se crea una instancia de la clase manejadora de Conexiones
        Connection connection = conexion.getConnection(); // se obtiene la conexion

        // Se crean las queries para insertar los datos en las tablas correspondientes
        String queryDatosClinicos = "INSERT INTO " +
                                        "datos_clinicos " +
                                        "(matricula, tipo_sangre, unidad_medica, sexo, peso, altura) " +
                                    "VALUES " +
                                        "(?, ?, ?, ?, ?, ?)";

        String queryPersonas = "INSERT INTO " +
                                    "personas " +
                                    "(curp, datos_clinicos_id, datos_clinicos_matricula, registro_vacuna_id, nombre, " +
                                    "apellido_paterno, apellido_materno, fecha_nacimiento, calle, numero_casa, colonia_localidad," +
                                    "municipio_alcaldia, codigo_postal, entidad_federativa, lugar_nacimiento) " +
                                "VALUES " +
                                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Tener cuidado pues se esta ocupando bind param o prepare statement lo que quiere decir que
        // se debe de poner el signo de interrogacion en donde se quiere que se inserte el valor

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryDatosClinicos); // la conexion devuelve un prepare statement
            preparedStatement.setString(1, personaModel.getDatosClinicosModel().getMatricula()); // se insertan los valores en los signos de interrogacion
            preparedStatement.setString(2, personaModel.getDatosClinicosModel().getTipoSangre());
            preparedStatement.setString(3, personaModel.getDatosClinicosModel().getUnidadMedica());
            preparedStatement.setString(4, personaModel.getDatosClinicosModel().getSexo());
            preparedStatement.setString(5, personaModel.getDatosClinicosModel().getPeso());
            preparedStatement.setString(6, personaModel.getDatosClinicosModel().getAltura());
            preparedStatement.executeUpdate(); // se ejecuta la query
            ResultSet resultSet = preparedStatement.getGeneratedKeys(); // se obtienen las llaves generadas

            preparedStatement = connection.prepareStatement(queryPersonas);
            preparedStatement.setString(1, personaModel.getCURP());
            preparedStatement.setString(2, personaModel.getNombre());
            preparedStatement.setString(3, personaModel.getApellidoPaterno());
            preparedStatement.setString(4, personaModel.getApellidoMaterno());
            preparedStatement.setString(5, personaModel.getFechaNacimiento());
            preparedStatement.setString(6, personaModel.getCalle());
            preparedStatement.setString(7, personaModel.getNumeroCasa());
            preparedStatement.setString(8, personaModel.getColoniaLocalidad());
            preparedStatement.setString(9, personaModel.getMunicipioAlcaldia());
            preparedStatement.setString(10, personaModel.getCodigoPostal());
            preparedStatement.setString(11, personaModel.getEntidadFederativa());
            preparedStatement.setString(12, personaModel.getLugarNacimiento());
            preparedStatement.setInt(13, resultSet.getInt(1));
            preparedStatement.setString(14, resultSet.getString(2));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            conexion.cerrarConexion();
        }
    }

    public void actualizarPersona(String curp, PersonasModel personaModel) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        String queryPersonas = "UPDATE personas " +
                        "SET curp = ?, nombre = ?, apellido_paterno = ?, apellido_materno = ?, fecha_nacimiento = ?, " +
                        "calle = ?, numero_casa = ?, colonia_localidad = ?, municipio_alcaldia = ?, codigo_postal = ?, " +
                        "entidad_federativa = ?, lugar_nacimiento = ?, datos_clinicos_id = ?, datos_clinicos_matricula = ? " +
                        "WHERE curp = " + curp;

        String queryDatosClinicos = "UPDATE datos_clinicos " +
                "SET tipo_sangre = ?, matricula = ?, unidad_medica = ?, sexo = ?, peso = ?, altura = ? " +
                "WHERE datos_clinicos_id = " + personaModel.getDatosClinicosModel().getId();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryPersonas);
            preparedStatement.setString(1, personaModel.getCURP());
            preparedStatement.setString(2, personaModel.getNombre());
            preparedStatement.setString(3, personaModel.getApellidoPaterno());
            preparedStatement.setString(4, personaModel.getApellidoMaterno());
            preparedStatement.setString(5, personaModel.getFechaNacimiento());
            preparedStatement.setString(6, personaModel.getCalle());
            preparedStatement.setString(7, personaModel.getNumeroCasa());
            preparedStatement.setString(8, personaModel.getColoniaLocalidad());
            preparedStatement.setString(9, personaModel.getMunicipioAlcaldia());
            preparedStatement.setString(10, personaModel.getCodigoPostal());
            preparedStatement.setString(11, personaModel.getEntidadFederativa());
            preparedStatement.setString(12, personaModel.getLugarNacimiento());
            preparedStatement.setInt(13, personaModel.getDatosClinicosModel().getId());
            preparedStatement.setString(14, personaModel.getDatosClinicosModel().getMatricula());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(queryDatosClinicos);
            preparedStatement.setString(1, personaModel.getDatosClinicosModel().getTipoSangre());
            preparedStatement.setString(2, personaModel.getDatosClinicosModel().getMatricula());
            preparedStatement.setString(3, personaModel.getDatosClinicosModel().getUnidadMedica());
            preparedStatement.setString(4, personaModel.getDatosClinicosModel().getSexo());
            preparedStatement.setString(5, personaModel.getDatosClinicosModel().getPeso());
            preparedStatement.setString(6, personaModel.getDatosClinicosModel().getAltura());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            conexion.cerrarConexion();
        }
    }

    public void bajaPersona(String curp) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        String queryPersonas = "DELETE FROM personas WHERE curp = " + curp;
        String queryDatosClinicos = "DELETE FROM datos_clinicos WHERE datos_clinicos_id = " +
                "(SELECT datos_clinicos_id FROM personas WHERE curp = " + curp + ")";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryPersonas);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(queryDatosClinicos);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            conexion.cerrarConexion();
        }
    }
}
