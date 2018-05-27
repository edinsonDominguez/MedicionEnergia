package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private String nombreBd = "medienergia";
	private String usuario = "root";
	private String password = "sistemas";
	// OJO CON EL PUERTO Y LA CONTRASEÑA...........
	private String url = "jdbc:mysql://localhost:3380/" + nombreBd;
	// TAMBIEN PARA CONECTAR O HACER VISIBLE EL PC PARA BASE DE DATOS....
	// 196.0.155:3380//
	Connection conn = null;
	
	public Conexion(){
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, usuario, password);
			
			if(conn != null){
	
			}else{
				System.out.println("No se conecta!!!");
			}
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Ocurre un error tipo ClassNotFoundException en conexion " + e.getMessage());
		
		}catch( SQLException e){
			
			System.out.println("Ocurre un error de tipo SQLException en conexion " + e.getMessage());
			e.printStackTrace();
		}
	}
	public Connection getConexion(){	
		return conn;
	}
	public void desconectar(){
		conn = null;
	}	
}
