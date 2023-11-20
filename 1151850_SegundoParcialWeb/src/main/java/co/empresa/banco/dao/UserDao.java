package co.empresa.banco.dao;

import co.empresa.banco.util.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoweb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public boolean verifyUser(String username, String pass) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND pass = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
