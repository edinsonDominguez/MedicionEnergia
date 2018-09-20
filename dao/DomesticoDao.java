package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.Conexion;
import vo.Domestico;

public class DomesticoDao {

	/* Esta clase se encargara de interactuar con la Base de datos
		los Datos de los electrodomesticos
	*/
	
	
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
	
	
	public String ingresarCompo(Domestico miCompo){
		
		String respuesta = "";
		iniciarConexion();
	
		connection = conexion.getConexion();
		String consulta = "INSERT INTO CompoCasa(nombreCompo, vatiosCompo, UsuarioCompo) "
				+ " VALUES (?, ?, ?)";
		
		try {	
			statement =	connection.prepareStatement(consulta);
			statement.setString(1, miCompo.getNombreCompo());
			statement.setInt(2, miCompo.getVatios());
			statement.setString(3, miCompo.getUsuarioCompo());
			statement.execute();			
			
			respuesta = "ok";
			} catch (SQLException e) {			
					System.out.println("Error en el method IngresarCompo()");
					System.out.println(e.getMessage());
			}
		
			conexion.desconectar();
		return respuesta;
		
	}
	
	
	public ArrayList<String> obtenerCompo(String nombreUsuario){
		
		iniciarConexion();
		connection = conexion.getConexion();
		
		ArrayList<String> lista = null;
		
		String consulta = "SELECT nombreCompo FROM CompoCasa WHERE UsuarioCompo = ?";
		
		try {	
			statement =	connection.prepareStatement(consulta);
			statement.setString(1, nombreUsuario);
			result = statement.executeQuery();			
			
			lista = new ArrayList<>();
			
			while(result.next()){
				
				String mensaje = result.getString("nombreCompo");
				lista.add(mensaje);
			}
			
			} catch (SQLException e) {			
					System.out.println("Error en el method IngresarCompo()");
					System.out.println(e.getMessage());
			}
		
			conexion.desconectar();
		
		return lista;
	}
	
	
	
}
