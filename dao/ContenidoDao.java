package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.Conexion;

public class ContenidoDao {

	
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
	
	
	public String extraerFacturaActual(String nombreUsuario){
		
		String respuesta = "";
		iniciarConexion();
		
		connection = conexion.getConexion();
		
		String consulta = "SELECT * FROM factura WHERE (usuarioFactura = ?) " 
				+ "AND (YEAR(fechaFactura) = YEAR(NOW())) "
				+ "AND (MONTH(fechaFactura) = MONTH(NOW()));";
		
		try {
			
			statement = connection.prepareStatement(consulta);
			statement.setString(1, nombreUsuario);
			result = statement.executeQuery();
			
			while(result.next()){
				respuesta = result.getString("totalPagar");
			}
			
		} catch (SQLException e) {
			System.out.println("Error en el method extraerfactura() / ContenidoDao");
			System.out.println(e.getMessage());
		}
		
		conexion.desconectar();
		
		System.out.println("Dao: valorFacturaActual => " + respuesta);
		
		return respuesta;
	}
	
	public String extraerFacturaAnterior(String nombreUsuario){
	
		String respuesta = "";
		iniciarConexion();
		
		connection = conexion.getConexion();
	
		String consulta = "SELECT * FROM factura WHERE (usuarioFactura = ?) "
				+ "AND YEAR(fechaFactura) = YEAR(NOW()) "
				+ "AND MONTH(fechaFactura) = MONTH(DATE_SUB(NOW(), INTERVAL 1 MONTH));";
		
		try {
			
			statement = connection.prepareStatement(consulta);
			statement.setString(1, nombreUsuario);
			result = statement.executeQuery();
			
			while(result.next()){
				respuesta = result.getString("totalPagar");
			}
			
		} catch (SQLException e) {
			System.out.println("Error en el method extraerfactura() / ContenidoDao");
			System.out.println(e.getMessage());
		}
		
		conexion.desconectar();
		
		return respuesta;
	}
	
	public ArrayList<String> listaFacturas(String nombreUsuario){
		
		ArrayList<String> lista = new ArrayList<>();
		iniciarConexion();
		
		connection = conexion.getConexion();
		
		String consulta = "SELECT * FROM factura WHERE usuarioFactura = ?";

		try {
			
			statement = connection.prepareStatement(consulta);
			statement.setString(1, nombreUsuario);
			result = statement.executeQuery();
			
			while(result.next()){
				lista.add(result.getString("totalPagar"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error en el method listaFacturas() / ContenidoDao");
			System.out.println(e.getMessage());
		}
		
		conexion.desconectar();
		
		return lista; 
	}
	
}
