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

		// Este metodo tendra las varibles de conexion a la base de datos
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
	
	
	public Usuario verificarUsuario(Usuario miUsuario){
		
		// este method verifica si el usuario ingresado esta en la base de datos
		iniciarConexion();
		connection = conexion.getConexion();
		
		Usuario usua = null;
		String consulta = "SELECT nombreUsuario, correoUsuario FROM usuario "
				+ "WHERE nombreUsuario = ?";
		
		try {	
			
			statement =	connection.prepareStatement(consulta);
			statement.setString(1, miUsuario.getNombre());
			result = statement.executeQuery();	
			
			while(result.next()){
				
				usua = new Usuario();
				usua.setNombre(result.getString("nombreUsuario"));
				usua.setCorreo(result.getString("correoUsuario"));
				
			}
			
			} catch (SQLException e) {		
				System.out.println("Error en el method listaDpto");
				System.out.println(e.getMessage());
			}
		
		conexion.desconectar();

		return usua;		
	}
	
	
	public Usuario buscarUsuario(String nombreUsuario){
		
		iniciarConexion();
		connection = conexion.getConexion();
		Usuario miUsuario = null;
		
		String consulta = "SELECT nombreUsuario, passwUsuario FROM usuario"
				+ " WHERE nombreUsuario = ?";
		
		try {
		statement = connection.prepareStatement(consulta);
		statement.setString(1, nombreUsuario);
		result = statement.executeQuery();
		
		while(result.next()){
			miUsuario = new Usuario();
			miUsuario.setNombre(result.getString("nombreUsuario"));
			miUsuario.setContrasenia(result.getString("passwUsuario"));
			
		}

		} catch (SQLException e) {
			System.out.println("Error en el method buscarUsuario()");
			System.out.println(e.getMessage());
		}
		
		conexion.desconectar();
		
		return miUsuario;
		
	}
	
}
