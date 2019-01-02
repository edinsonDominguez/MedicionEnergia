package procesos;

import java.util.ArrayList;

import dao.DomesticoDao;
import vo.Domestico;

public class ProcesoCompo {

	// Esta clase Procesara La informacion de los electrodomesticos 
	// ingresados por el usuario 
	DomesticoDao daoDomestico;
	
	private double valorMes, valorSemana, valorDia, consumoWhDia;
	
	
	
	
	public ProcesoCompo(){
		daoDomestico = new DomesticoDao();
	}
	
	public String ingresarDomestico(Domestico miCompo , Double tarifa){
		Domestico compoFull = new Domestico();
		// ingresarDatos
		compoFull.setNombreCompo(miCompo.getNombreCompo());
		compoFull.setVatios(miCompo.getVatios());
		compoFull.setHorasConsumo(miCompo.getHorasConsumo());
		compoFull.setUsuarioCompo(miCompo.getUsuarioCompo());
		
		// Primer calculo Consumo de vatios diarios
		consumoWhDia =  (miCompo.getVatios() * miCompo.getHorasConsumo()) / 1000;
		System.out.println("consumoDia == " + consumoWhDia);
		
		// segundo calculo el valor de ese consumo diario
		valorDia = consumoWhDia * tarifa;
		System.out.println("ValorDia == " + valorDia);
		compoFull.setPrecioDia(valorDia);
		
		// Tercer calculo el valor de la semana
		valorSemana = valorDia * 7;
		System.out.println("Valor de la semana == " + valorSemana);
		compoFull.setPrecioSemana(valorSemana);
		
		//Cuarto calculo el valor de l mes 
		valorMes = valorDia * 30;
		System.out.println("Valor del mes == " + valorMes);
		compoFull.setPrecioMes(valorMes);
		
		
		String estado = daoDomestico.ingresarCompo(compoFull);
		
		return estado;
	}
	
	
	
	public ArrayList<String> listaCompo(String nombreUsuario){
		
		ArrayList<String> componentes = null;
		
		componentes = daoDomestico.obtenerCompo(nombreUsuario);
		
		return componentes;
	}
	
	
	// este metodo recibira el dato de la clase grafica y lo enviara a la clase Dao
	public Domestico recibirNombreCompo(String nombreComponente, String nombreUsuario){
		
		// trae las caracteristicas del componente 
		
		return daoDomestico.enviarComponente(nombreComponente, nombreUsuario);
	}
	
	// este metodo recibe todos los electrodomesticos del usuario para el JTable
	public ArrayList<Domestico> listaComponentes(String nombreUsuario){
		
		return daoDomestico.listaCompo(nombreUsuario);
	}
	
	public String eliminarElectro(String nombre, String usuario){
		
		return daoDomestico.eliminarElectro(nombre, usuario);
	}
	
}
