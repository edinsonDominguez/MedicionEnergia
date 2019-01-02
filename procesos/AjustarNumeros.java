package procesos;

public class AjustarNumeros {

	// Estaran los metodos correspondientes a el ajuste de precios de nuestra app
	
	
	// method constructor
	
	public AjustarNumeros(){

	}
	
	
	public int ajustarCuenta(double consumoActiva) {
		// Este metodo ajusta el numero en ceros 
		
		int numeroEgresado = 0;
		
		double ultimoNumero = consumoActiva % 10;

		// Hacemos un casting para eliminar los decimales
		int castingNumero = (int)ultimoNumero;
	
		
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

		
		// Se realiza el casting en el variable que recibimos para eliminar los decimales
		numeroEgresado = (int) consumoActiva; 
	
		return numeroEgresado;
	}

	
	
	
	public int ajustarPrecioTotal(double numero){
		
		// este method ajustara el valor total de la factura
		int numeroEgresado = 0;
		
		System.out.println("ingreso al method ajustarPrecioTotal ... ");
		
		
		double ultimosNumeros = numero % 100; 
		
		int castingNumero = (int) ultimosNumeros;
		System.out.println("Los ultimos numeros son " + castingNumero);
		
		
		switch (castingNumero) {
		case 10:
			numero = numero + 40; 
			break;
		case 20:
			numero = numero + 30; 
			break;
		case 30:
			numero = numero + 20; 
			break;
		case 40:
			numero = numero + 10; 
			break;
		case 60:
			numero = numero + 40; 
			break;
		case 70:
			numero = numero + 30; 
			break;
		case 80:
			numero = numero + 20; 
			break;
		case 90:
			numero = numero + 10; 
			break;
		
		default:
			System.out.println("El valor no necesita ser ajustado ");
			break;
		}
		
		// se realiza el casting en la variable numero
		numeroEgresado = (int)numero;
		
		return numeroEgresado;
	}
	
	
}
