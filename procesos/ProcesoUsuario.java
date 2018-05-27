package procesos;

import java.util.ArrayList;

import dao.UsuarioDao;
import vo.Usuario;

public class ProcesoUsuario {
	
	// Varible que interactua con la Base de datos
	UsuarioDao daoUsuario;
	
	public ProcesoUsuario(){
		daoUsuario = new UsuarioDao();
	}
	
	public ArrayList<String> listaDptos(){
		
		// este metodo contiene todos los departamentos en colombia
		ArrayList<String> lista = daoUsuario.listaDpto();
		
		return lista;
	}
	
	public String procesoRegistro(Usuario miUsuario){
		
		String respuesta = daoUsuario.registrarUsuario(miUsuario);
		
		return respuesta;
	}
	
	
}
