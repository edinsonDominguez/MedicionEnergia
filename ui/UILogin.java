package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import helpers.Componentes;
import helpers.FormatoPosicion;
import procesos.ProcesoLogin;
import procesos.ValidarCampos;
import vo.Usuario;

public class UILogin extends JFrame implements MouseListener {

	JPanel contenPane;
	
	// variables de diseño
	Componentes com;
	FormatoPosicion pos;
	UIRegistroUsuario miRegistroUsuario;
	
	//variables de logica
	ProcesoLogin miLogin;
	ValidarCampos validar;
	UIContenido miContenido;
	
	// elementos de la (ui)
	JTextField txtUsuario, txtPass;
	JButton btnRegistrar;
	JLabel desplazar;
	
	//componentes de validacion.
	private JLabel lblErrorUsuario, lblErrorPass;
	
	// mensajes de validacion
	String estadoUsuario = "", estadoPass = "";
	
	// method contructor
	public UILogin(){
		System.out.println("Estamos en la clase (ui) UILogin");

		
		// inicializamos las variables 
		miContenido = new UIContenido();
		com = new Componentes();
		pos = new FormatoPosicion();
		miRegistroUsuario = new UIRegistroUsuario();
		validar = new ValidarCampos();
		miLogin = new ProcesoLogin();
		
		setSize(1260, 720);
		setLocationRelativeTo(null);
	
		componentes();	
	}

	private void componentes() {
	
		// este es el contenedor principal
		contenPane = com.panelPrincipal();
		add(contenPane);
		
		// este es el header o cabecera del programa
		JPanel header = com.header();
		header.setBounds(pos.colA, pos.row1, 1260, 120);
		contenPane.add(header);
		
		// este el method de los componentes del formulario
		form();
		
		JButton salir = com.botonSalir("Salir");
		contenPane.add(salir);
		
	}

	private void form() {
		
		JPanel form = com.form();
		form.setBounds(pos.colC, pos.row4, 540, 420);
		contenPane.add(form);
		
		JLabel titulo = com.tituloPrincipal("Login");
		titulo.setBounds(pos.fColD, pos.fRow1, 240, 40);
		form.add(titulo);
		
		// campo Usuario
		JLabel lblUsuario = com.lblCampo("Usuario *");
		lblUsuario.setBounds(pos.fColB, pos.fRow2, 90, 30);
		form.add(lblUsuario);
		
		txtUsuario = com.input();
		txtUsuario.setBounds(pos.fColB, pos.fRow3, 160, 30);
		form.add(txtUsuario);
		
		lblErrorUsuario = com.lblValidacion("");
		lblErrorUsuario.setBounds(pos.fColE, pos.fRow3, 160, 20);
		form.add(lblErrorUsuario);
		
		// campo contraseña
		JLabel lblPass = com.lblCampo("Contraseña *");
		lblPass.setBounds(pos.fColB, pos.fRow4, 110, 30);
		form.add(lblPass);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(pos.fColB, pos.fRow5, 160, 30);
		form.add(txtPass);
		
		lblErrorPass = com.lblValidacion("");
		lblErrorPass.setBounds(pos.fColE, pos.fRow5, 160, 20);
		form.add(lblErrorPass);
		
		// boton de iniciar sesion
		btnRegistrar = com.botonRegistro("Iniciar Sesion");
		btnRegistrar.setBounds(pos.fColE, pos.fRow7, 150, 40);
		btnRegistrar.addMouseListener(this);
		form.add(btnRegistrar);
		
		JLabel lblMensaje = com.lblCampo("si no tienes cuenta ");
		lblMensaje.setBounds(pos.fColB, pos.fRow9, 400, 30);
		form.add(lblMensaje);
		
		desplazar = com.lblCampo("Registrate ");
		desplazar.setBounds(pos.fColE, pos.fRow9, 90, 30);
		desplazar.addMouseListener(this);
		form.add(desplazar);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(desplazar == e.getSource()){
			miRegistroUsuario.setVisible(true);
			this.dispose();
		}
		
		if(btnRegistrar == e.getSource()){
			System.out.println("Presiono en iniciar Sesion");
		
			imprimirResultados();
			
		}
		
	}

	private void imprimirResultados() {
		
		// asignamos las validaciones en los mensajes 
		estadoUsuario = validar.CamposRegistroUsuario(txtUsuario.getText());
		estadoPass = validar.CamposRegistroUsuario(txtPass.getText());		
		
		System.out.println("valor usuario: " + estadoUsuario);
		System.out.println("valor password: " + estadoPass);
	
		
		if(estadoUsuario.equals("ok") && estadoPass.equals("ok")){
			conectarLogica();
		}else{	
			
			//validacionCampo Usuario
			switch(estadoUsuario){
				case "campoVacio":
					lblErrorUsuario.setText("campoVacio");
					break;
				case "ok":
					lblErrorUsuario.setText("");	
					break;
			}
			
			//validacionCampo Pass
			switch (estadoPass) {
			case "campoVacio":
				lblErrorPass.setText("campo vacio");		
				break;
			case "ok":
				lblErrorPass.setText("");
				break;	
		}				
		}
	}

	private void conectarLogica() {
		
		Usuario miUsuario = miLogin.buscarUsuario(txtUsuario.getText());
		
		if(miUsuario != null){
				
			lblErrorUsuario.setText("");
			
			// esta varible contiene el texto del txtPass
			String password = txtPass.getText().trim();
			// esta varible contiene el password de la bd
			String passwordBD = miUsuario.getContrasenia().trim();
			
			// nos indica que si lo que hay en el password es igual a el passwordBD
			if(password.equals(passwordBD)){
				System.out.println("El usuario esta en el sistema");
				lblErrorPass.setText("");
				
				// ingreso a la ventana Contenido
				System.out.println("Ventana de Contenido");
				if(miUsuario.getNombre() == null){
					System.out.println("UIContenido no Generado");
				}else{
					miContenido.recibirNombre(miUsuario.getNombre());
					miContenido.setVisible(true);
					this.dispose();
						
				}
				
			}else{
				System.out.println("no es la contraseña correcta");
				lblErrorPass.setText("contraseña incorrecta");
			}
			
		}else{
			
			if(miUsuario == null){
				System.out.println("El usuario no existe ");
				lblErrorUsuario.setText("El usuario no exite");
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
