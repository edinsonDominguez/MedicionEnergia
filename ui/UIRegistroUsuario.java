package ui;

import javax.swing.*;

import helpers.Componentes;
import helpers.FormatoPosicion;

public class UIRegistroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario, txtCorreo, txtContrasenia;
	private JButton btnContinuar;
	// variables de diseño
	
	Componentes com;
	FormatoPosicion pos;
	
	// method constructor
	public UIRegistroUsuario(){
		
		System.out.println("Estamos en la clase UIRegistroUsuario");
		
		// inicializamos las varibles
		com = new Componentes();
		pos = new FormatoPosicion();
		
		setSize(1260, 720);
		setLocationRelativeTo(null);
		componentes();
	}

	private void componentes() {
		
		contentPane = com.panelPrincipal();
		add(contentPane);
		
		// este es el contenedor header
		JPanel header = com.header();
		header.setBounds(pos.colA, pos.row1, 1260, 120);
		contentPane.add(header);
	
		form();
		
		JButton btnSalir = com.botonSalir("Salir");
		contentPane.add(btnSalir);
		
	}

	private void form() {
		
		// este es el formulario
				JPanel form = com.form();
				form.setBounds(pos.colC, pos.row4, 540, 420);
				contentPane.add(form);
				
				JLabel tituloForm = com.tituloPrincipal("Registro usuario.");
				tituloForm.setBounds(pos.fColD, pos.fRow1, 240, 40);
				form.add(tituloForm);
				
				// Campo usuario
				JLabel lblUsuario = com.lblCampo("Usuario * ");
				lblUsuario.setBounds(pos.fColB, pos.fRow2, 90, 30);
				form.add(lblUsuario);
				
				txtUsuario = com.input();
				txtUsuario.setBounds(pos.fColB, pos.fRow3, 160, 30);
				form.add(txtUsuario);
				
				// Campo correo
				JLabel lblCorreo = com.lblCampo("Correo *");
				lblCorreo.setBounds(pos.fColB, pos.fRow4, 90, 30);
				form.add(lblCorreo);
				
				txtCorreo = com.input();
				txtCorreo.setBounds(pos.fColB, pos.fRow5, 200, 30);
				form.add(txtCorreo);
				
				// Select departamento
				JLabel lblDpto = com.lblCampo("Departamento * ");
				lblDpto.setBounds(pos.fColB, pos.fRow6, 150, 30);
				form.add(lblDpto);
				
				
				
				// Campo contraseña
				JLabel lblContrasenia = com.lblCampo("Contraseña *");
				lblContrasenia.setBounds(pos.fColB, pos.fRow8, 120, 30);
				form.add(lblContrasenia);
				
				txtContrasenia = com.input();
				txtContrasenia.setBounds(pos.fColB, pos.fRow9, 150, 30);
				form.add(txtContrasenia);
				
				// boton continuar
				btnContinuar = com.botonRegistro("Continuar");
				btnContinuar.setBounds(pos.fColG, pos.fRow11, 150, 40);
				form.add(btnContinuar);

	}
	
	
	
	
}
