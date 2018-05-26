package procesos;

public class ProcesoFactura {

	private double totalPagar;
	private double subsidioNacion;
	private double consumoActiva;
	
	// Esta varible contiene el valor del alumbrado publico
	private final int ALUMBRADO_PUBLICO = 5530;
	
	// clases 
	
	AjustarNumeros ajuste;
	
	public ProcesoFactura(){
		System.out.println("esta en la clase ProcesoFactura");
		ajuste = new AjustarNumeros();
	}
	
	public void tomarDatos(int consumo, double tarifa, double subsidio){
			
		consumoActiva = operarConsumoActiva(consumo, tarifa);
	
		subsidioNacion = operarSubsidioNacion(subsidio);
		
		System.out.println("Subsidio Nacion: " + subsidioNacion);
		
		totalPagar = (consumoActiva - subsidioNacion) + ALUMBRADO_PUBLICO;
		
	}
	
	
	private int operarSubsidioNacion(double subsidio){
		
		double  numeroOperacion = (consumoActiva * subsidio) / 100; 
		
		// casting en el subsidio
		int subsidioBruto = (int)numeroOperacion;
		System.out.println("El valor del method operarSubsidioNacion es " + subsidioBruto);
		
		int precioAjustado = ajuste.ajustarCuenta(subsidioBruto);
		System.out.println("subsidio con ajuste == " + precioAjustado);
		
		return precioAjustado;
	}
	
	
	private int operarConsumoActiva(int consumo, double tarifa){
		
		
		double valor = 0;		
		valor = consumo * tarifa;
		
		int consumoActivaMethod = (int) valor;
		System.out.println("consumoActiva: " + consumoActivaMethod);
		
		// Este es valor del consumoActivaMethod pero con el precio ajustado..
		int numeroAjustado = ajuste.ajustarCuenta(consumoActivaMethod);
	
		System.out.println("consumoActiva con ajuste " + numeroAjustado);
		
		return numeroAjustado;
	}
	
	


	public int mostrarTotal(){
		
		int total = 0;
		
		System.out.println("Total a pagar: " + totalPagar);
		
		total = ajuste.ajustarPrecioTotal(totalPagar);
		
		System.out.println("Precio total con ajuste " + total);
		
		return total;
	}
	
}
