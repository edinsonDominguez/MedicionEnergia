package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import config.Conexion;
import ui.UIBaseDatos;
import ui.UILogin;

public class Aplicacion {
	
	
	UILogin miLogin;
	
	
	public Aplicacion(){
		System.out.println("Iniciar Programa ......");
		iniciarPrograma();	
	
	}


	private void iniciarPrograma() {
		
		System.out.println("Validando conexion con la base de datos ...");
		
		String conexionBD = iniciarConexion();	
		
		if(conexionBD.equals("ok")){

		UIBaseDatos baseDatos = new UIBaseDatos();
		
		String validacion = baseDatos.leerTxt();
			
			switch(validacion){
				case "archivoVacio":
					System.out.println("Recuperar datos ....");
					System.out.println("sigue en la ventana baseDatos");
					baseDatos.setVisible(true);
					break;
				case "noArchivo":
					baseDatos.setVisible(true);
					break;
				case "archivoCorrecto":
					miLogin = new UILogin();
					miLogin.setVisible(true);
					baseDatos.dispose();
					break;	
			}
			
		}else{
			
			System.out.println("No tienes los datos de conexion con MySQL");
			System.exit(0);
		}
	}

	private String iniciarConexion(){

		// iniciar una Conexion de prueba ......
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement statement = null;

	return "ok";
 
	}
	
	
	

	
}
