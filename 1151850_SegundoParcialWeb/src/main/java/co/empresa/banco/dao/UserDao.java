package co.empresa.banco.dao;

import co.empresa.banco.modelo.User;
import co.empresa.banco.util.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoweb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    
    private static final String SELECT_ALL_USUARIO_SQL = "SELECT * FROM usuario;";
    
  

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
    
    public List<User> selectAll() {
		List <User> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_USUARIO_SQL);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuarios.add(new Usuario(id, nombre, email, pais));
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuarios;
		
	}
}
