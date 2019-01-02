package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Conexion {

	
	// Variables por defecto;
		String nombreArchivo = "MediEnergia.txt";
		
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	private String nombreBD = "medienergia";
	private String usuario;
	private String password;
	private String puerto;
	private String url;
	Connection conn = null;
	
	public Conexion(){
	
		System.out.println("Iniciando conexion con la base de datos");
		
		leerTxt();
		
		url = "jdbc:mysql://localhost:" + puerto + "/" + nombreBD;
		
		try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection(url,usuario,password);
					
				if(conn != null){
					System.out.println("Conexion con la base de datos exitosa !!");
					System.out.println();
				}
				
				
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
				
			}catch (SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Verifique si mysql esta encendido !!");

				JOptionPane.showMessageDialog(null, "ERROR DE CONEXIÓN.\n"
						+ "1. SI YA TIENES MYSQL INSTALADO, LEER MANUAL DE INSTALACION. ");
				
					}
		
	}
	
	
	public Connection getConexion(){
		return conn;
	}
	
	public void desconectar(){
		conn = null;
	}

	public void leerTxt(){
	
		File archivo;
		FileReader fr;
		BufferedReader br;
		
		try {
			
			archivo = new File(nombreArchivo);	
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;			
			String matriz[] = new String[3];
			int contador = 0;
			
			while((linea = br.readLine()) != null){
				
				matriz [contador] = linea;
				contador++;
			}
			
			usuario = matriz[0];
			puerto = matriz[1];
			password = matriz[2];
					
			br.close();
			fr.close();
			
		} catch (Exception e) {
			System.out.println("Error ...");
			System.out.println(e.getMessage());
		}
	
	}
	
	
}
