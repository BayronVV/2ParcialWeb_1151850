package co.empresa.banco.dao;

import co.empresa.banco.util.Conexion;

public class UserDao {

private Conexion conexion;
	
	private static final String INSERT_USUARIO_SQL = "INSER INTO usuario (usernmae,passl,email) VALUES (?,?,?);";
	private static final String DELETE_USUARIO_SQL = "DELTE FROM usuario WHERE id = ?;";
	
    private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM usuario WHERE id = ?;";
	private static final String SELECT_ALL_USUARIO_SQL = "SELECT * FROM usuario;";
					
	
	
	
}
