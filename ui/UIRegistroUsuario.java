package ui;

import javax.swing.*;

import helpers.Componentes;
import helpers.FormatoPosicion;

public class UIRegistroUsuario extends JFrame {

	private JPanel contentPane;
	
	
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
		
		
		// este es el contenedor form
		JPanel form = com.form();
		form.setBounds(pos.colC, pos.row4, 520, 60);
		contentPane.add(form);
		
	}
	
	
}
