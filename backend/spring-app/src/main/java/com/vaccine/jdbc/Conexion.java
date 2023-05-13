package com.vaccine.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Aqui se crea la conexion a la base de datos, simplemente se crea un objeto con el cual a partir de el
 * podemos hacer queries a la base de datos.
 */

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/vaccine?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // cambia esta cosa por tu usuario de mysql
    private static final String PASSWORD = "root"; // cambia esto por tu contraseña de mysql
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private Connection connection;

    public Conexion() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
