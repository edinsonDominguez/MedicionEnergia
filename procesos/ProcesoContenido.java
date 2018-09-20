package procesos;

import java.util.ArrayList;

import dao.ContenidoDao;

public class ProcesoContenido {

	ContenidoDao daoContenido;
	AjustarNumeros ajuste;
	
	public ProcesoContenido(){
		daoContenido = new ContenidoDao();
		ajuste = new AjustarNumeros();
	}
	
	public String facturaActual(String nombreUsuario){
		
		// conectamos la clase dao 
		String valorFactura = daoContenido.extraerFacturaActual(nombreUsuario);
		
		if(valorFactura.equals("")){
			System.out.println("Factura Actual Vacia ..");
		}else{
			System.out.println("FacturaActual: " + valorFactura);
		}
		
		return valorFactura;
	}
	
	public String facturaAnterior(String nombreUsuario){
		
		//conectamos la clase dao
		String valorFactura = daoContenido.extraerFacturaAnterior(nombreUsuario);
		
		return valorFactura;	
	}
	
	public String fechaProxima(String nombreUsuario){
		
		/*
		 * este method promediara las facturas anteriores y sacara un promedio
			proximo para la siguiente factura;
		 * */
		
		ArrayList<String> listaFacturas = daoContenido.listaFacturas(nombreUsuario);
		
		int numeroSuma = 0;
		int numeroConversion = 0;
		String facturaProxima = "";
			
		for (int i = 0; i < listaFacturas.size(); i++) {
			
			numeroConversion = Integer.parseInt(listaFacturas.get(i));
			
			System.out.println("numeroLista: " + numeroConversion);
			numeroSuma += numeroConversion;
			
			System.out.println("Suma: " + numeroSuma);
		}
		
		System.out.println("Cantidad de pagos: " + listaFacturas.size());
		
		// esta variable promediara la factura proxima
		int promedioFactura = numeroSuma / listaFacturas.size();
		
		// esta variable hace un ajuste a la cuenta 
		int totalFactura = ajuste.ajustarPrecioTotal(promedioFactura);
		
		// guarda el resultado para enviar
		facturaProxima = totalFactura + "";

		return facturaProxima;
	}
}
