package procesos;

import java.util.ArrayList;

import dao.DomesticoDao;
import vo.Domestico;

public class ProcesoCompo {

	// Esta clase Procesara La informacion de los electrodomesticos 
	// ingresados por el usuario 
	DomesticoDao daoDomestico;
	
	private int valorMes, valorSemana, valorDia, consumoWhDia;
	
	
	
	public ProcesoCompo(){
		daoDomestico = new DomesticoDao();
	}
	
	public String ingresarDomestico(Domestico miCompo){
		
		String estado = daoDomestico.ingresarCompo(miCompo);
		
		return estado;
	}
	
	
	public ArrayList<String> listaCompo(String nombreUsuario){
		
		ArrayList<String> componentes = null;
		
		componentes = daoDomestico.obtenerCompo(nombreUsuario);
		
		return componentes;
	}
	
	
	
}
