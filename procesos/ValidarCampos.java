package procesos;

public class ValidarCampos {
	
	// en esta clase estaran todos los metodos para validar las ui del programa
	
	//method constructor
	
	public ValidarCampos(){
		System.out.println("Estamos en la clase ValidarCampos");
	}
	
	
	public String validarCampos(String contenidoCampo){
		
		// esta variable contiene los estados de validacion
		String respuesta = "ok";
		
		// esta variable comprueba si en los campos no hay letras
		double comprobar = 0; 
		
		if(contenidoCampo.equals("")){
			respuesta = "campoVacio";
		}

		
		if(!(contenidoCampo.equals(""))){
			try {
				comprobar = Double.parseDouble(contenidoCampo);
				System.out.println("Varible comprobar == " + comprobar);
				
			} catch (Exception e) {
				respuesta = "letraCampo";
			}		
		}
		
		return respuesta;
		
	}
	
	public String CamposRegistroUsuario(String contenidoCampo){
		//este method validara los campos de la (ui) UIRegistroUsuario
		
		// esta variable contiene los estados de validacion
		String respuesta = "ok"; 
		
		if(contenidoCampo.equals("")){
			respuesta = "campoVacio";
		}
		
		return respuesta;
	}
	
	
	

}
