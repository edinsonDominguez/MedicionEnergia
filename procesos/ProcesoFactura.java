package procesos;

public class ProcesoFactura {

	private double totalPagar;
	private double subsidioNacion;
	private double consumoActiva;
	
	// Esta varible contiene el valor del alumbrado publico
	private final int ALUMBRADO_PUBLICO = 5530;
	
	
	public void tomarDatos(int consumo, double tarifa, double subsidio){
			
		consumoActiva = operarConsumoActiva(consumo, tarifa);
	
		subsidioNacion = operarSubsidioNacion(subsidio);
		
		System.out.println("Subsidio Nacion: " + subsidioNacion);
		
		totalPagar = (consumoActiva - subsidioNacion) + ALUMBRADO_PUBLICO;
		
	}
	
	
	private double operarSubsidioNacion(double subsidio){
		
		double subsidioBruto = (consumoActiva * subsidio) / 100; 
		
		
	
		return subsidioBruto;
	}
	
	
	private double operarConsumoActiva(int consumo, double tarifa){
		
		double consumoActiva = 0;
				
		consumoActiva = consumo * tarifa;
		System.out.println("consumoActiva: " + consumoActiva);
		
		double numeroAjustado = ajustarCuenta(consumoActiva);
	
		System.out.println("consumoActiva con ajuste " + numeroAjustado);
		
		return consumoActiva;
	}
	
	
	private double ajustarCuenta(double consumoActiva) {
		// Este metodo ajusta el numero en ceros 
		
		double ultimoNumero = consumoActiva % 10;

		// Hacemos un casting para eliminar los decimales
		int castingNumero = (int)ultimoNumero;
		
		
		System.out.println("Ultimo numero " + castingNumero);
			
		if(castingNumero == 1){
			
			consumoActiva = consumoActiva - 1;
			
			
		}else{
			if(castingNumero == 2){
				consumoActiva = consumoActiva - 2;
					
			}else{
				
				if(castingNumero == 3){
					consumoActiva = consumoActiva - 3;
					
				}else{
					
					if(castingNumero == 4){
						consumoActiva = consumoActiva - 4;
							
					}else{
						if(castingNumero == 5){
							consumoActiva = consumoActiva - 5;
						}else{
							if(castingNumero == 6){
								consumoActiva = consumoActiva + 4;
								
							}else{
								if(castingNumero == 7){
									consumoActiva = consumoActiva + 3;
									
								}else{
									if(castingNumero == 8){
										consumoActiva = consumoActiva + 2;
										
									}else{
										if(castingNumero == 9){
											consumoActiva = consumoActiva + 1;
												
										}
										
									}
								}
							}
						}
						
					}
				}
			}
		}

		
		
		return consumoActiva;
	}


	public double mostrarTotal(){
		
		double total = 0;
		
		System.out.println("" + totalPagar);
		
		total = totalPagar;
		
		return total;
	}
	
	
	
	
	
	
	
	
	
	
	// validacion de campos ...
	
	public String validarCampos(String consumo, String tarifa, String subsidio){
		
		// esta variable contiene los estados de validacion
		String respuesta = "ok";
		
		// Esta variable buscara si en los campos hay una letra.
		double comprobar = 0;
		
		if(consumo.equals("")){
			respuesta = "consumoVacio";
		}else{
			
			try {
				comprobar = Double.parseDouble(consumo);
						
			} catch (Exception e) {
				System.out.println("hay una letra en txtConsumo");
				respuesta = "letraConsumo";
			}
		}
		
		if(tarifa.equals("")){
			respuesta = "tarifaVacia";
		}else{
			
			try {
				comprobar = Double.parseDouble(tarifa);	
			
			} catch (Exception e) {
				System.out.println("Hay una letra en txtTarifa");
				respuesta = "letraTarifa";
			}
		}
		
		if(subsidio.equals("")){
			respuesta = "subsidioVacio";
		
		}else{
			
			try {
				comprobar = Double.parseDouble(subsidio);	
					
			} catch (Exception e) {
				System.out.println("hay una letra en txtSubsidio");
				respuesta = "letraSubsidio";
			}
		}
		
		return respuesta;
	}
	
}
