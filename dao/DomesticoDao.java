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
		String consulta = "INSERT INTO CompoCasa(nombreCompo, vatiosCompo, UsuarioCompo, horaCompo, precioDia, "
				+ "precioSemana, precioMes) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {	
			statement =	connection.prepareStatement(consulta);
			statement.setString(1, miCompo.getNombreCompo());
			statement.setDouble(2, miCompo.getVatios());
			statement.setString(3, miCompo.getUsuarioCompo());
			statement.setDouble(4, miCompo.getHorasConsumo());
			statement.setDouble(5, miCompo.getPrecioDia());
			statement.setDouble(6, miCompo.getPrecioSemana());
			statement.setDouble(7, miCompo.getPrecioMes());
			statement.execute();			
			
			respuesta = "ok";
			} catch (SQLException e) {			
					System.out.println("Error en el method IngresarCompo()");
					System.out.println(e.getMessage());
			}
		
			conexion.desconectar();
		return respuesta;
		
	}
	
	// Este metodo Obtiene todos los componentes del Usuario en la Base de Datos
	public ArrayList<String> obtenerCompo(String nombreUsuario){
		
		iniciarConexion();
		connection = conexion.getConexion();
		
		ArrayList<String> lista = null;
		
		String consulta = "SELECT nombreCompo FROM CompoCasa WHERE UsuarioCompo = ? "
				+ "ORDER BY idCompoCasa ASC";
		
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
	
	// Este metodo Obtiene las Caracteristicas del componente.
	public Domestico enviarComponente(String nombreComponente, String usuarioComponente){
		
		iniciarConexion();
		connection = conexion.getConexion();
		
		Domestico miDomestico = null;
		String consulta = "SELECT * FROM CompoCasa WHERE nombreCompo = ?"
				+ " and UsuarioCompo = ?";
		
		try {	
			statement =	connection.prepareStatement(consulta);
			statement.setString(1, nombreComponente);
			statement.setString(2, usuarioComponente);
			
			result = statement.executeQuery();			
			
			
			while(result.next()){
				
				miDomestico = new Domestico();
				miDomestico.setNombreCompo(result.getString("nombreCompo"));
				miDomestico.setVatios(result.getDouble("vatiosCompo"));
				miDomestico.setPrecioDia(result.getDouble("precioDia"));
				miDomestico.setPrecioSemana(result.getDouble("precioSemana"));
				miDomestico.setPrecioMes(result.getDouble("precioMes"));
				
				
			}
			
			} catch (SQLException e) {			
					System.out.println("Error en el method IngresarCompo()");
					System.out.println(e.getMessage());
			}
		
			conexion.desconectar();
		
		
		return miDomestico;
		
	}
	
	public ArrayList<Domestico> listaCompo(String nombreUsuario){
		
		iniciarConexion();
		connection = conexion.getConexion();
		
		Domestico miDomestico = null;
		ArrayList<Domestico> lista = null;
		
		String consulta = "SELECT * FROM compoCasa WHERE usuarioCompo = ?";	
		
		try {	
			statement =	connection.prepareStatement(consulta);
			statement.setString(1, nombreUsuario);
			
			lista = new ArrayList<>();
			result = statement.executeQuery();			
			
			
			while(result.next()){
				
				miDomestico = new Domestico();
				miDomestico.setNombreCompo(result.getString("nombreCompo"));
				miDomestico.setVatios(result.getDouble("vatiosCompo"));
				miDomestico.setHorasConsumo(result.getInt("horaCompo"));
				miDomestico.setPrecioDia(result.getDouble("precioDia"));
				miDomestico.setPrecioSemana(result.getDouble("precioSemana"));
				miDomestico.setPrecioMes(result.getDouble("precioMes"));
				
				lista.add(miDomestico);
			}
			
			} catch (SQLException e) {			
					System.out.println("Error en el method IngresarCompo()");
					System.out.println(e.getMessage());
			}
		
		
		conexion.desconectar();
		
		return lista;
	}
	
	
	public String eliminarElectro(String nombre, String usuario ){
		
		// elimina las facturas por medio de la fecha de vencimiento
			String estado = "";
			
			iniciarConexion();
			connection = conexion.getConexion();
			
			String consulta = "DELETE FROM compoCasa "
					+ "WHERE nombreCompo = ? AND usuarioCompo = ?;";
			
			try {	
				statement =	connection.prepareStatement(consulta);
				statement.setString(1, nombre);
				statement.setString(2, usuario);
				
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
