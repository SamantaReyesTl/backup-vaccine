package com.vaccine.ultil;

import com.vaccine.model.PersonasModel;

import java.sql.PreparedStatement;

public class PersonaUtil {
    public static void prepare(PreparedStatement preparedStatement, PersonasModel personaModel) throws Exception {
        preparedStatement.setString(1, personaModel.getCurp());
        preparedStatement.setString(2, personaModel.getNombre());
        preparedStatement.setString(3, personaModel.getApellidoPaterno());
        preparedStatement.setString(4, personaModel.getApellidoMaterno());
        preparedStatement.setString(5, personaModel.getFechaNacimiento());
        preparedStatement.setInt(6, personaModel.getEdad());
        preparedStatement.setString(7, personaModel.getCalle());
        preparedStatement.setString(8, personaModel.getNumeroCasa());
        preparedStatement.setString(9, personaModel.getColoniaLocalidad());
        preparedStatement.setString(10, personaModel.getComunidad());
        preparedStatement.setString(11, personaModel.getCodigoPostal());
        preparedStatement.setString(12, personaModel.getEntidadFederativa());
        preparedStatement.setString(13, personaModel.getLugarNacimiento());
    }
}
