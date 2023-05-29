package com.vaccine.service;

import com.vaccine.jdbc.ConexionCreada;
import com.vaccine.model.RegistroClinicoBasicoModel;
import com.vaccine.model.RegistroVacunaModel;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistroClinicoBasicoService {
    private final Connection connection;
    private final ConexionCreada conexionCreada;
    public RegistroClinicoBasicoService(){
        conexionCreada = new ConexionCreada();
        connection = conexionCreada.getConnection();
    }

    public ResponseEntity<Object> obtener(String curp){
        String consulta = "SELECT " +
                            "* " +
                        "FROM " +
                            "registro_clinico_basico " +
                        "WHERE " +
                            "curp_personas = '" + curp + "'" ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            RegistroClinicoBasicoModel registroClinicoBasicoModel = new RegistroClinicoBasicoModel(
                    resultSet.getString("curp_personas"), resultSet.getString("tipo_sangre"),
                    resultSet.getBoolean("sexo"), resultSet.getDouble("peso"),
                    resultSet.getDouble("altura"), resultSet.getString("alergias")
            );
            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body(registroClinicoBasicoModel);
        } catch (Exception exception){
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("La busqueda no coincidio con algun registro O"+exception);
        }
    }

    public ResponseEntity<Object> alta(RegistroClinicoBasicoModel rcb) {
        try {
            String consulta = "INSERT INTO " +
                                "registro_clinico_basico " +
                                "(curp_personas, tipo_sangre, sexo, peso, altura, alergias) " +
                            "VALUES " +
                                "(?,?, ?, ?, ?, ?) " ;
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1,rcb.getCurp_personas());
            preparedStatement.setString(2, rcb.getTipoSangre());
            preparedStatement.setBoolean(3, rcb.getSexo());
            preparedStatement.setDouble(4, rcb.getPeso());
            preparedStatement.setDouble(5, rcb.getAltura());
            preparedStatement.setString(6, rcb.getAlergias());
            preparedStatement.executeUpdate();
            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Alta creada");
        } catch (Exception e){
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("No se pudo"+e);
        }
    }

    public ResponseEntity<Object> actualizar(String curp, RegistroClinicoBasicoModel rcb) {
        try {
            String consulta = "UPDATE " +
                    "registro_clinico_basico " +
                    "SET " +
                    "curp_personas = ?, tipo_sangre = ?, sexo = ?, peso = ?, altura = ?, alergias = ? " +
                    "WHERE " +
                    "curp = '" + curp + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1,rcb.getCurp_personas());
            preparedStatement.setString(2, rcb.getTipoSangre());
            preparedStatement.setBoolean(3, rcb.getSexo());
            preparedStatement.setDouble(4, rcb.getPeso());
            preparedStatement.setDouble(5, rcb.getAltura());
            preparedStatement.setString(6, rcb.getAlergias());
            preparedStatement.executeUpdate();
            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Actualizado con exito");
        } catch (Exception e){
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("No se pudo actualizar");
        }
    }

    public ResponseEntity<Object> eliminar(String curp) {
        try {
            String consulta = "DELETE " +
                    "registro_clinico_basico " +
                    "WHERE " +
                    "curp = '" + curp + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.executeUpdate();
            conexionCreada.cerrarConexion();
            return ResponseEntity.ok().body("Persona eliminada");
        } catch (Exception e){
            conexionCreada.cerrarConexion();
            return ResponseEntity.badRequest().body("Persona no eliminada con exito");

        }
    }
}
