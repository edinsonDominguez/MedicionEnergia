package procesos;

import dao.FacturaDao;
import vo.Factura;

public class ProcesoFactura {

	private double totalPagar;
	private double subsidioNacion;
	private double consumoActiva;

	
	// clases 
	AjustarNumeros ajuste;
	Factura miFactura;
	FacturaDao daoFactura;
	
	
	public ProcesoFactura(){
		System.out.println("esta en la clase ProcesoFactura");
		daoFactura = new FacturaDao();
		miFactura = new Factura();
		ajuste = new AjustarNumeros();
	}
																		//alumbrado publico
	public void tomarDatos(int consumo, double tarifa, double subsidio, int alumbrado, 
			String nombreUsuario, String fechaFactura){
		
		//consumoActiva
		consumoActiva = operarConsumoActiva(consumo, tarifa);
	
		//subsidioNacion
		subsidioNacion = operarSubsidioNacion(subsidio);
		
		System.out.println("Subsidio Nacion: " + subsidioNacion);
		
		// introducir los datos en el objecto factura
		miFactura.setAlumbradoPublico((int) alumbrado);
		miFactura.setNombreUsuario(nombreUsuario);
		miFactura.setFechaFactura(fechaFactura);
		
		//total a pagar
		totalPagar = (consumoActiva - subsidioNacion) + alumbrado;
		
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
		System.out.println("**************************************+++");
		
		total = ajuste.ajustarPrecioTotal(totalPagar);
		
		// enviar los datos a la Base de datos 
		
		//introducimos los datos en el objecto factura
		// hacemos un casting de double a int
			miFactura.setConsumoActivo((int) consumoActiva);
			miFactura.setSubsidioNacion((int) subsidioNacion);
			miFactura.setTotalPagar(total);
		
	
			daoFactura.registrarFactura(miFactura);
			

		System.out.println("Precio total con ajuste " + total);
	
		
		return total;
	}

	
}
