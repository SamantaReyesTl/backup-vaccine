package com.vaccine.service;

import com.vaccine.jdbc.ConexionCreada;
import com.vaccine.model.VacunasModel;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VacunaService {
    public ResponseEntity<Object> consultarVacuna(Integer id) {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();

        String query = "SELECT " +
                            "* " +
                        "FROM " +
                            "vacunas " +
                        "WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            VacunasModel vacuna = new VacunasModel(
                    rs.getInt("id"),
                    rs.getString("nombre_Vacuna"),
                    rs.getString("enfermedad_Previene"),
                    rs.getInt("numero_Dosis"),
                    rs.getInt("Edad_Vacunacion"),
                    rs.getInt("esquema_1"),
                    rs.getInt("esquema_2"),
                    rs.getInt("siguiente_Esquema")
            );

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body(vacuna);
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al consultar vacuna "+e);
        }
    }

    public ResponseEntity<Object> altaVacuna(VacunasModel vacunaModel) {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();

        String query = "INSERT INTO " +
                            "vacunas " +
                            "(nombre_vacuna, enfermedad_Previene, numero_Dosis, edad_vacunacion, esquema_1,esquema_2, siquiente_Esquema) " +
                        "VALUES " +
                            "(?, ?, ?, ?, ?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vacunaModel.getNombre_Vacuna());
            preparedStatement.setString(2, vacunaModel.getEnfermedad_Previene());
            preparedStatement.setInt(3, vacunaModel.getNumero_Dosis());
            preparedStatement.setInt(4, vacunaModel.getEdad_Vacunacion());
            preparedStatement.setInt(5, vacunaModel.getEsquema_1());
            preparedStatement.setInt(6, vacunaModel.getEsquema_2());
            preparedStatement.setInt(7, vacunaModel.getSiguiente_Esquema());
            preparedStatement.executeUpdate();

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Vacuna dada de alta correctamente");
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al dar de alta vacuna");
        }
    }

    public ResponseEntity<Object> actualizarVacuna(Integer id, VacunasModel vacunaModel) {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();

        String query = "UPDATE " +
                            "vacunas " +
                        "SET " +
                            "nombre_vacuna = ?, enfermedad_previene = ?, numero_dosis = ?, edad_vacunacion = ?,esquema_1 = ?, esquema_2 = ?, siguie     nte_Esquema = ? " +

                        "WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vacunaModel.getNombre_Vacuna());
            preparedStatement.setString(2, vacunaModel.getEnfermedad_Previene());
            preparedStatement.setInt(3, vacunaModel.getNumero_Dosis());
            preparedStatement.setInt(4, vacunaModel.getEdad_Vacunacion());
            preparedStatement.setInt(5, vacunaModel.getEsquema_1());
            preparedStatement.setInt(6, vacunaModel.getEsquema_2());
            preparedStatement.setInt(7, vacunaModel.getSiguiente_Esquema());
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Vacuna actualizada correctamente");
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al actualizar vacuna"+e);
        }
    }

    public ResponseEntity<Object> bajaVacuna(Integer id) {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();

        String query = "DELETE FROM " +
                            "vacunas " +
                        "WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Vacuna eliminada correctamente");
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al eliminar vacuna");
        }
    }
}
