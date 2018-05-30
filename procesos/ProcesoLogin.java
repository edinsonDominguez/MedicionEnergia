package procesos;

import dao.UsuarioDao;
import vo.Usuario;

public class ProcesoLogin {

	UsuarioDao daoUsuario;
	
	public ProcesoLogin(){
	
		daoUsuario = new UsuarioDao(); 
		
	}
	
	
	
	public Usuario buscarUsuario(String nombreUsuario){
		
		Usuario miUsuario = daoUsuario.buscarUsuario(nombreUsuario);
		
		
		return miUsuario;
		
	}
	
	
}
