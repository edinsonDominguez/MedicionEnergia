package procesos;

public class ProcesoFactura {

	private int totalPagar;
	private int subsidioNacion;
	private int consumoActiva;
	
	// Esta varible contiene el valor del alumbrado publico
	private final int ALUMBRADO_PUBLICO = 5530;
	
	
	public void tomarDatos(int consumo, int tarifa, int subsidio){
			
		consumoActiva = operarConsumoActiva(consumo, tarifa);
	
		subsidioNacion = operarSubsidioNacion(subsidio);
		
		System.out.println("Subsidio Nacion: " + subsidioNacion);
		
		totalPagar = (consumoActiva - subsidioNacion) + ALUMBRADO_PUBLICO;
		
	}
	
	
	private int operarSubsidioNacion(int subsidio){
		
		int subsidioBruto = (consumoActiva * subsidio) / 100; 
		
		System.out.println("Subsidio bruto: " + subsidioBruto);
		return subsidioBruto;
	}
	
	
	private int operarConsumoActiva(int consumo, int tarifa){
		
		int consumoActiva = 0;
				
		consumoActiva = consumo * tarifa;

		System.out.println("consumoActiva: " + consumoActiva);
		
		return consumoActiva;
	}
	
	public int mostrarTotal(){
		
		int total = 0;
		
		System.out.println("" + totalPagar);
		
		total = totalPagar;
		
		return total;
	}
	
	public String validarCampos(String consumo, String tarifa, String subsidio){
		
		String respuesta = "ok";
		
		// Esta variable buscara si en los campos hay una letra.
		
		int comprobar = 0;
		
		if(consumo.equals("")){
			respuesta = "consumoVacio";
		}else{
			
			try {
				comprobar = Integer.parseInt(consumo);
						
			} catch (Exception e) {
				System.out.println("letra en txtConsumo");
			}
		}
		
		if(tarifa.equals("")){
			respuesta = "tarifaVacia";
		}else{
			
			
			try {
				comprobar = Integer.parseInt(consumo);	
			
			} catch (Exception e) {
				System.out.println("letra en tarifa");
			}
		}
		
		if(subsidio.equals("")){
			respuesta = "subsidioVacio";
		
		}else{
		 
			try {
				comprobar = Integer.parseInt(subsidio);	
					
			} catch (Exception e) {
				System.out.println("letra en subsidio");
				
			}
		}
		
		return respuesta;
	}
	
}
