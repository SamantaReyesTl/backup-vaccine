package com.vaccine.service;

import com.vaccine.jdbc.Conexion;
import com.vaccine.model.DatosClinicosModel;
import com.vaccine.model.PersonaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Aqui comienza lo complicado, aqui se hace la logica de la aplicacion.
 */

public class PersonaService {
    public PersonaModel consultarPersona(String curp) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        List<PersonaModel> personaModelList = new ArrayList<>();
        String query =  "SELECT personas.*, datos_clinicos.* " +
                        "FROM personas " +
                        "INNER JOIN datos_clinicos ON personas.CURP = datos_clinicos.CURP " +
                        "WHERE personas.CURP = " + curp;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PersonaModel personaModel = new PersonaModel( resultSet.getInt("id"),
                        resultSet.getString("curp"), resultSet.getString("nombre"),
                        resultSet.getString("apellido_paterno"),resultSet.getString("apellido_materno"),
                        resultSet.getString("fecha_nacimiento"), resultSet.getString("calle"),
                        resultSet.getString("numero_casa"),
                        resultSet.getString("colonia_localidad"), resultSet.getString("municipio_alcaldia"),
                        resultSet.getString("codigo_postal"), resultSet.getString("entidad_federativa"),
                        resultSet.getString("lugar_nacimiento"), resultSet.getInt("datos_clinicos_id"),
                        resultSet.getString("datos_clinicos_matricula"),
                        new DatosClinicosModel(
                                resultSet.getInt("datos_clinicos_id"), resultSet.getString("tipo_sangre"),
                                resultSet.getString("matricula"), resultSet.getString("unidad_medica"),
                                resultSet.getString("sexo"), resultSet.getString("peso"),
                                resultSet.getString("altura")  ));
                personaModelList.add(personaModel);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            conexion.cerrarConexion();
        }

        return personaModelList.get(0);
    }

    public void altaPersona(PersonaModel personaModel) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        String queryDatosClinicos = "INSERT INTO datos_clinicos (tipo_sangre, matricula, unidad_medica, " +
                                    "sexo, peso, altura) " +
                                    "VALUES (?, ?, ?, ?, ?, ?)";

        String queryPersonas = "INSERT INTO personas (curp, nombre, apellido_paterno, apellido_materno, " +
                        "fecha_nacimiento, calle, numero_casa, colonia_localidad, municipio_alcaldia, codigo_postal, " +
                        "entidad_federativa, lugar_nacimiento, datos_clinicos_id, datos_clinicos_matricula) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryDatosClinicos);
            preparedStatement.setString(1, personaModel.getDatosClinicosModel().getTipoSangre());
            preparedStatement.setString(2, personaModel.getDatosClinicosModel().getMatricula());
            preparedStatement.setString(3, personaModel.getDatosClinicosModel().getUnidadMedica());
            preparedStatement.setString(4, personaModel.getDatosClinicosModel().getSexo());
            preparedStatement.setString(5, personaModel.getDatosClinicosModel().getPeso());
            preparedStatement.setString(6, personaModel.getDatosClinicosModel().getAltura());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

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

    public void actualizarPersona(String curp, PersonaModel personaModel) {
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
