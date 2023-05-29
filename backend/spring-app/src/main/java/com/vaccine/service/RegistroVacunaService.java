package com.vaccine.service;

import com.vaccine.jdbc.ConexionCreada;
import com.vaccine.model.RegistroVacunaModel;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistroVacunaService {
    public ResponseEntity<Object> consultarRegistroVacuna(String curp) {
        ConexionCreada conexionCreada = null;
        try {
            conexionCreada = new ConexionCreada();
            Connection connection = conexionCreada.getConnection();

            String consulta = "SELECT * FROM registro_vacuna WHERE curp_personas = '" + curp + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            RegistroVacunaModel registroVacunaModel = new RegistroVacunaModel(
                    resultSet.getInt("folio"), resultSet.getString("curp_personas"),
                    resultSet.getInt("id_vacunas"), resultSet.getInt("numero_dosis"),
                    resultSet.getDate("fecha_vacuna"), resultSet.getDate("proxima_vacuna"),
                    resultSet.getString("laboratorio"), resultSet.getString("lote")
            );

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body(registroVacunaModel);
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Ocurrio un problema "+e);
        }
    }

    public ResponseEntity<Object> altaRegistroVacuna(RegistroVacunaModel registroVacunaModel) {
        ConexionCreada conexionCreada = null;
        try {
            conexionCreada = new ConexionCreada();
            Connection connection = conexionCreada.getConnection();

            String consulta = "INSERT INTO " +
                                "registro_vacuna " +
                                "(curp_personas, id_vacunas, dosis, fecha_vacuna, proxima_vacuna, laboratorio, lote) " +
                                "VALUES ( ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, registroVacunaModel.getCurpPersonas());
            preparedStatement.setInt(2, registroVacunaModel.getVacunasId());
            preparedStatement.setInt(3, registroVacunaModel.getNoDosis());
            preparedStatement.setDate(4, registroVacunaModel.getFechaVacuna());
            preparedStatement.setDate(5, registroVacunaModel.getProximaVacuna());
            preparedStatement.setString(6, registroVacunaModel.getLaboratorio());
            preparedStatement.setString(7, registroVacunaModel.getLote());
            preparedStatement.executeUpdate();

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Registro de vacuna creado");
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Ocurrio un problema "+e);
        }
    }

    public ResponseEntity<Object> actualizarRegistroVacuna(Integer id, RegistroVacunaModel registroVacunaModel) {
        ConexionCreada conexionCreada = null;
        try {
            conexionCreada = new ConexionCreada();
            Connection connection = conexionCreada.getConnection();

            String consulta = "UPDATE registro_vacuna " +
                            "SET " +
                                "curp_personas = ?, id_vacunas = ?, dosis = ?, fecha_vacuna = ?, proxima_vacuna = ?, laboratorio = ?, lote = ? " +
                            "WHERE " +
                                "folio = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, registroVacunaModel.getCurpPersonas());
            preparedStatement.setInt(2, registroVacunaModel.getVacunasId());
            preparedStatement.setInt(3, registroVacunaModel.getNoDosis());
            preparedStatement.setDate(4, registroVacunaModel.getFechaVacuna());
            preparedStatement.setDate(5, registroVacunaModel.getProximaVacuna());
            preparedStatement.setString(6, registroVacunaModel.getLaboratorio());
            preparedStatement.setString(7, registroVacunaModel.getLote());
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Registro de vacuna actualizado");
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Ocurrio un problema "+e);
        }
    }

    public ResponseEntity<Object> bajaRegistroVacuna(Integer id) {
        ConexionCreada conexionCreada = null;
        try {
            conexionCreada = new ConexionCreada();
            Connection connection = conexionCreada.getConnection();

            String consulta = "DELETE FROM registro_vacuna WHERE folio = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Registro de vacuna eliminado");
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Ocurrio un problema "+e);
        }
    }
}
