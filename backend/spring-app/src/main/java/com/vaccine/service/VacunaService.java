package com.vaccine.service;

import com.vaccine.jdbc.Conexion;
import com.vaccine.model.VacunasModel;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VacunaService {
    public Object consultarVacuna(Integer id) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

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
                    rs.getString("folio_vacuna"),
                    rs.getString("edad_vacunacion"),
                    rs.getString("proposito"),
                    rs.getString("nombre_vacuna"),
                    rs.getString("periodo")
            );

            return ResponseEntity.ok().body(vacuna);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al consultar vacuna "+e);
        } finally {
            conexion.cerrarConexion();
        }
    }

    public Object altaVacuna(VacunasModel vacunaModel) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO " +
                            "vacunas " +
                            "(folio_vacuna, edad_vacunacion, proposito, nombre_vacuna, periodo) " +
                        "VALUES " +
                            "(?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vacunaModel.getFolio());
            preparedStatement.setString(2, vacunaModel.getEdadVacunacion());
            preparedStatement.setString(3, vacunaModel.getProposito());
            preparedStatement.setString(4, vacunaModel.getNombreVacuna());
            preparedStatement.setString(5, vacunaModel.getPeriodo());
            preparedStatement.executeUpdate();

            return ResponseEntity.ok().body("Vacuna dada de alta correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al dar de alta vacuna");
        } finally {
            conexion.cerrarConexion();
        }
    }

    public Object actualizarVacuna(Integer id, VacunasModel vacunaModel) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        String query = "UPDATE " +
                            "vacunas " +
                        "SET " +
                            "folio_vacuna = ?, edad_vacunacion = ?, proposito = ?, nombre_vacuna = ?, periodo = ? " +
                        "WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vacunaModel.getFolio());
            preparedStatement.setString(2, vacunaModel.getEdadVacunacion());
            preparedStatement.setString(3, vacunaModel.getProposito());
            preparedStatement.setString(4, vacunaModel.getNombreVacuna());
            preparedStatement.setString(5, vacunaModel.getPeriodo());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();

            return ResponseEntity.ok().body("Vacuna actualizada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar vacuna"+e);
        } finally {
            conexion.cerrarConexion();
        }
    }

    public Object bajaVacuna(Integer id) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        String query = "DELETE FROM " +
                            "vacunas " +
                        "WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            return ResponseEntity.ok().body("Vacuna eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar vacuna");
        } finally {
            conexion.cerrarConexion();
        }
    }
}
