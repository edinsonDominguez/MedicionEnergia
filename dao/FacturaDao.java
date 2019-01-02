package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public ArrayList<Factura> listaFacturas (String nombreUsuario){
	
		iniciarConexion();
		connection = conexion.getConexion();
	
		Factura miFactura = null;
		ArrayList<Factura> lista = null;
	
		String consulta = "SELECT * FROM factura WHERE usuarioFactura = ?;";
		
		try {
			
			lista = new ArrayList<>();
					
			statement=connection.prepareStatement(consulta);
			statement.setString(1, nombreUsuario);
			result = statement.executeQuery();
			
			while(result.next()){
				miFactura = new Factura();
				miFactura.setConsumoActivo(result.getInt("consumoActivo"));		
				miFactura.setSubsidioNacion(result.getInt("subsidioNacion"));		
				miFactura.setAlumbradoPublico(result.getInt("alumbradoPublico"));		
				miFactura.setTotalPagar(result.getInt("totalPagar"));		
				miFactura.setFechaFactura(result.getString("fechaFactura"));		
				
				lista.add(miFactura);
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en el method listaFacturas()");
			System.out.println(e.getMessage());
	
		}
		
		conexion.desconectar();
		
		return lista;
	}

	
public String eliminarFactura(String fecha){
		
	// elimina las facturas por medio de la fecha de vencimiento
		String estado = "";
		
		iniciarConexion();
		connection = conexion.getConexion();
		
		String consulta = "DELETE FROM factura WHERE fechaFactura = ?;";
		
		try {	
			statement =	connection.prepareStatement(consulta);
			statement.setString(1, fecha);
			
			statement.execute();			
			
			estado = "ok";
			
			} catch (SQLException e) {			
					System.out.println("Error en el method eliminarFactura()");
					System.out.println(e.getMessage());
			}
		
			conexion.desconectar();
	
		return estado;
	}

}
