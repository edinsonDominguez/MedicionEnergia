package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatosDefecto {

	// esta clase ingresara todos los datos por defecto en el programa
	
	private Connection connection;
	private Conexion conexion;
	private PreparedStatement statement;
	private ResultSet result;
	
	private void iniciarConexion(){
		// Este metodo tendra las varibles de conexion a la base de datos
		connection = null;
		conexion = new Conexion();
		statement = null;
		result = null;
	}

	
	public void cargardomesticos(String nombreUsuario){
		/* este method ingresara todos los datos por defecto de los electrodomesticos
		 * a el usuario*/
		
		System.out.println("Ingresando electrodomesticos por defecto... ");
		iniciarConexion();
		
		connection = conexion.getConexion();
		
		// completar
		String consulta = "INSERT INTO componentesCasa (nombreComponente, wattsComponente, usuarioComponente)";
		
		try {
			statement = connection.prepareStatement(consulta);
			statement.setString(1, nombreUsuario);
			statement.execute();
			
		} catch (SQLException e) {
		System.out.println("Error en el method electrodomesticos");
		System.out.println(e.getMessage());
		}
		
	}
	
	
}
