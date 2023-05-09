package com.vaccine.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/vaccine?useSSL=false&serverTimezone=UTC";
    private static final String USER = "vaccine";
    private static final String PASSWORD = "vaccine";
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
