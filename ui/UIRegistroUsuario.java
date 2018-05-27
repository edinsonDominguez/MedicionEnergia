package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import helpers.Componentes;
import helpers.FormatoPosicion;
import procesos.ProcesoUsuario;
import procesos.ValidarCampos;
import vo.Usuario;

public class UIRegistroUsuario extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField txtUsuario, txtCorreo;
	private JButton btnContinuar;
	private JPasswordField txtContrasenia;
	// Lista Despegable de departamentos
	private JComboBox<String> comboDpto;
	
	// Variables de negocio
	ValidarCampos validar;
	ProcesoUsuario miProceso;
	
	// Campos de validacion
	private JLabel lblErrorUsuario, lblErrorCorreo, lblErrorPass;
	
	// Variables de validacion
	String estadoUsuario = "", estadoCorreo = "", estadoPass = ""; 
	
	// variables de diseño
	Componentes com;
	FormatoPosicion pos;
	UIRegistroFactura miFactura;
	
	// method constructor
	public UIRegistroUsuario(){
		
		System.out.println("Estamos en la clase UIRegistroUsuario");
		
		// inicializamos las varibles
		miFactura = new UIRegistroFactura();
		miProceso = new ProcesoUsuario();
		com = new Componentes();
		pos = new FormatoPosicion();
		validar = new ValidarCampos();
		
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
				
				lblErrorUsuario = com.lblValidacion("");
				lblErrorUsuario.setBounds(pos.fColE, pos.fRow3, 160, 20);
				form.add(lblErrorUsuario);
				
				// Campo correo
				JLabel lblCorreo = com.lblCampo("Correo *");
				lblCorreo.setBounds(pos.fColB, pos.fRow4, 90, 30);
				form.add(lblCorreo);
				
				txtCorreo = com.input();
				txtCorreo.setBounds(pos.fColB, pos.fRow5, 230, 30);
				form.add(txtCorreo);
			
				lblErrorCorreo = com.lblValidacion("");
				lblErrorCorreo.setBounds(pos.fColF, pos.fRow5, 160, 20);
				form.add(lblErrorCorreo);
			
				// Select departamento
				JLabel lblDpto = com.lblCampo("Departamento * ");
				lblDpto.setBounds(pos.fColB, pos.fRow6, 150, 30);
				form.add(lblDpto);
				
				// Este elemento sufrira cambios a futuro
				comboDpto = new JComboBox<>();
				comboDpto.addItem("Seleccionar");
				// este method contiene los departamentos
				componenteListaDesplegable();
				form.add(comboDpto);
				
				
				// Campo contraseña
				JLabel lblContrasenia = com.lblCampo("Contraseña *");
				lblContrasenia.setBounds(pos.fColB, pos.fRow8, 120, 30);
				form.add(lblContrasenia);
				
				txtContrasenia = new JPasswordField();
				txtContrasenia.setBounds(pos.fColB, pos.fRow9, 160, 30);
				form.add(txtContrasenia);
				
				lblErrorPass = com.lblValidacion("");
				lblErrorPass.setBounds(pos.fColE, pos.fRow9, 160, 20);
				form.add(lblErrorPass);
			
				// boton continuar
				btnContinuar = com.botonRegistro("Continuar");
				btnContinuar.setBounds(pos.fColG, pos.fRow11, 150, 40);
				btnContinuar.addMouseListener(this);
				form.add(btnContinuar);

	}

	private void componenteListaDesplegable() {
	
		comboDpto.setBounds(pos.fColB, pos.fRow7, 160, 30);
		
		ArrayList<String> listaDpto = miProceso.listaDptos();
		for (int i = 0; i < listaDpto.size(); i++) {
			comboDpto.addItem(listaDpto.get(i));
		}
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(btnContinuar == e.getSource()){
			System.out.println("Presiono en continuar");
			System.out.println("Select: " + comboDpto.getSelectedIndex());
			imprimirResultados();
		}
	}
	
	
	

	private void imprimirResultados() {
				
		
	// Asignamos en las variables de validacion el metodo que valida campos en registro usuario
		estadoUsuario = validar.CamposRegistroUsuario(txtUsuario.getText());
		estadoCorreo = validar.CamposRegistroUsuario(txtCorreo.getText());
		estadoPass = validar.CamposRegistroUsuario(txtContrasenia.getText());
		
	//imprimir resultados 
		
		System.out.println("campoUsuario: " + estadoUsuario);
		System.out.println("campoCorreo: " + estadoCorreo);
		System.out.println("campoPass: " + estadoPass);
		
	// Variable del jcombobox
		int estadoDpto = comboDpto.getSelectedIndex();
		
	if(estadoUsuario.equals("ok") && estadoCorreo.equals("ok") && estadoPass.equals("ok")
			&& !(estadoDpto == 0)){
		System.out.println("validaciones Correctas");	
		
		lblErrorUsuario.setText("");
		lblErrorCorreo.setText("");
		lblErrorPass.setText("");
		
		// Conectar con el metodo logica
		conectarLogica();
		
	}else{
		
		// validacionCampo Usuario 
		if(estadoUsuario.equals("campoVacio")){
			lblErrorUsuario.setText("campo vacio");
		}else{
			if(estadoUsuario.equals("ok")){
				lblErrorUsuario.setText("");
			}
		}
		
		// validacionCampo correo
		if(estadoCorreo.equals("campoVacio")){
			lblErrorCorreo.setText("campo vacio");	
		}else{
			if(estadoCorreo.equals("ok")){
				lblErrorCorreo.setText("");
			}
				
		}
		
		// validacionCampo contrasenia
		if(estadoPass.equals("campoVacio")){
			lblErrorPass.setText("campo vacio");	
		}else{
			if(estadoPass.equals("ok")){
				lblErrorPass.setText("");
			}
				
		}
		
	}
		
	}

	private void conectarLogica() {
		
		Usuario miUsuario = new Usuario();
		miUsuario.setNombre(txtUsuario.getText());
		miUsuario.setCorreo(txtCorreo.getText());
		miUsuario.setContrasenia(txtContrasenia.getText());
		// valor del codigo del departamento
		miUsuario.setDpto(comboDpto.getSelectedIndex());
		
		String respuesta = miProceso.procesoRegistro(miUsuario);
		
		if(respuesta.equals("ok")){
		
			System.out.println("Registro !!");
			miFactura.setVisible(true);
			this.dispose();
			
		}else{
			System.out.println("no registro");
		
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
