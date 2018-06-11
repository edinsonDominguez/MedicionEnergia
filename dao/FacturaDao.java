package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.Conexion;
import vo.Factura;

public class FacturaDao {

	private Connection connection;
	private Conexion conexion;
	private PreparedStatement statement;
	private ResultSet result;
	
	private void iniciarConexion(){

		// Este method tendra las variables de conexion a la base de datos
		connection = null;
		conexion = new Conexion();
		statement = null;
		result = null;
		
	}

	public String registrarFactura(Factura miFactura){
		
		String respuesta = "";
		
		iniciarConexion();
		connection = conexion.getConexion();
		
		String consulta = "INSERT INTO factura"
				+ "(consumoActivo, subsidioNacion, alumbradoPublico, totalPagar, usuarioFactura, fechaFactura)"
				+ "VALUES(?,?,?,?,?,?)";
		
		try {	
			statement =	connection.prepareStatement(consulta);
			statement.setInt(1, miFactura.getConsumoActivo());
			statement.setInt(2, miFactura.getSubsidioNacion());
			statement.setInt(3, miFactura.getAlumbradoPublico());
			statement.setInt(4, miFactura.getTotalPagar());
			statement.setString(5, miFactura.getNombreUsuario());
			statement.setString(6, miFactura.getFechaFactura());
			
			statement.execute();			
			
			respuesta = "ok";
			} catch (SQLException e) {			
					System.out.println("Error en el method registrarFactura()");
					System.out.println(e.getMessage());
			}
		
			conexion.desconectar();
	
			return respuesta;
		
	}




}
