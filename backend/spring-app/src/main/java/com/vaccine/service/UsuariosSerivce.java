package com.vaccine.service;

import com.vaccine.jdbc.ConexionCreada;
import com.vaccine.model.UsuariosModel;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosSerivce {
    public ResponseEntity<Object> getUsuarios(String nombre) {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();
        try {
            String consulta = "SELECT * FROM usuarios WHERE nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, nombre);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            UsuariosModel usuariosModel = new UsuariosModel(
                    resultSet.getInt("id"), resultSet.getString("nombre"),
                    resultSet.getString("contraseña"), resultSet.getString("comunidad"),
                    resultSet.getBoolean("es_administrador")
            );

            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body(usuariosModel);
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al obtener los usuarios "+e);
        }
    }

    public ResponseEntity<Object> altaUsuario(UsuariosModel usuariosModel) {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();
        try {
            String consulta = "INSERT INTO usuarios " +
                                "(nombre, contraseña, comunidad, es_administrador) " +
                            "VALUES " +
                                "(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, usuariosModel.getNombre());
            preparedStatement.setString(2, usuariosModel.getContrasena());
            preparedStatement.setString(3, usuariosModel.getComunidad());
            preparedStatement.setBoolean(4, usuariosModel.getEs_administrador());

            preparedStatement.executeUpdate();
            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Usuario dado de alta correctamente");
        }catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al dar de alta el usuario "+e);
        }
    }

    public ResponseEntity<Object> actualizarUsuario(String nombre, UsuariosModel usuariosModel) {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();
        try {
            String consulta = "UPDATE usuarios " +
                            "SET nombre = ?,  contraseña = ?, comunidad = ?, es_administrador = ? " +
                            "WHERE nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, usuariosModel.getNombre());
            preparedStatement.setString(2, usuariosModel.getContrasena());
            preparedStatement.setString(3, usuariosModel.getComunidad());
            preparedStatement.setBoolean(4, usuariosModel.getEs_administrador());
            preparedStatement.setString(5, nombre);

            preparedStatement.executeUpdate();
            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Usuario actualizado correctamente");
        } catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al actualizar el usuario "+e);
        }
    }

    public ResponseEntity<Object> eliminarUsuario(String nombre) {
        ConexionCreada conexionCreada = new ConexionCreada();
        Connection connection = conexionCreada.getConnection();
        try {
            String consulta = "DELETE FROM usuarios WHERE nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, nombre);

            preparedStatement.executeUpdate();
            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Usuario eliminado correctamente");
        }catch (Exception e) {
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Error al eliminar el usuario "+e);
        }
    }
}
