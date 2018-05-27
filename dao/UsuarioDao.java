package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.Conexion;
import vo.Usuario;

public class UsuarioDao {
	
	private Connection connection;
	private Conexion conexion;
	private PreparedStatement statement;
	private ResultSet result;
	
	private void iniciarConexion(){

		connection = null;
		conexion = new Conexion();
		statement = null;
		result = null;
		
	}
	
	public String registrarUsuario(Usuario miUsuario){
		// este method registra los usuarios en la bd 
		
		//Esta variable contiene los estados del programa
		String respuesta = "";
		iniciarConexion();
		connection = conexion.getConexion();
		
		String consulta = "INSERT INTO usuario(nombreUsuario, correoUsuario, deptUsuario, passwUsuario)"
				+ "VALUES (?,?,?,?);"; 
		
		try {	
			statement =	connection.prepareStatement(consulta);
			statement.setString(1, miUsuario.getNombre());
			statement.setString(2, miUsuario.getCorreo());
			statement.setInt(3, miUsuario.getDpto());
			statement.setString(4, miUsuario.getContrasenia());
			statement.execute();			
			
			respuesta = "ok";
			} catch (SQLException e) {			
					System.out.println("Error en el method registrarUsuario()");
					System.out.println(e.getMessage());
			}
		
			conexion.desconectar();
		return respuesta;
	}
	
	
	public ArrayList<String> listaDpto(){
		//este method trae toda la lista de paises en la base de datos 
		iniciarConexion();
		
		ArrayList<String> lista = new ArrayList<>();
		connection = conexion.getConexion();
		String consulta = "SELECT * FROM depto ORDER BY nombreDept";
		
		try {	
			statement =	connection.prepareStatement(consulta);
			result = statement.executeQuery();	
			
			while(result.next()){
				String mensaje = result.getString("nombreDept");
				lista.add(mensaje);
			}
			
			} catch (SQLException e) {		
				System.out.println("Error en el method listaDpto");
				System.out.println(e.getMessage());
			}
		
			conexion.desconectar();
			
		return lista;
	}
	
	
}
