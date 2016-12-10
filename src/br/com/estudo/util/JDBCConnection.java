package br.com.estudo.util;

import static br.com.estudo.util.BuscarPropriedade.getString;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {

    private final static String URL = getString("URL");
    private final static String USER = getString("USER");
    private final static String PASSWORD = getString("PASSWORD");
    private final static String DRIVER = getString("DRIVER");

    private static Connection conexao = null;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao se conectar com o banco : " + URL);
            e.printStackTrace();
        }
        return conexao;
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
