package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

import javax.swing.*;

import config.Conexion;
import helpers.Componentes;
import helpers.FormatoPosicion;

public class UIBaseDatos extends JFrame implements MouseListener{

	Conexion miConexion;
	UILogin miLogin;
	
	Componentes com;
	FormatoPosicion pos;
	
	
	JTextField txtPuerto, txtClave, txtUsuario;
	JButton btnIngresar;
	
	JPanel contenPane;
	
	// Variables por defecto;
	String nombreArchivo = "MediEnergia.txt";
	
	

	public UIBaseDatos(){
	
		com = new Componentes();
		pos = new FormatoPosicion();
		
		
		setSize(600, 500);
		setTitle("Conexion base de datos.");
		setLocationRelativeTo(null);
	
		componentes();
	}
	
	
	private void componentes() {
		
		System.out.println("Cargando la ventana UIBaseDatos ");
		
		
		contenPane = com.panelPrincipal();
		contenPane.setLayout(null);
		contenPane.setBounds(0, 0, 600, 500);
		add(contenPane);
		
		
		JPanel header = com.header();
		header.setBounds(0, 0, 600, 120);
		contenPane.add(header);
	
		JPanel seccion = com.section();
		seccion.setBounds(20, 130, 540, 300);
		contenPane.add(seccion);
		
		
		JLabel mensaje = com.lblCampo("Iniciar conexion con MySQL.");
		mensaje.setBounds(20, 20, 500, 30);
		seccion.add(mensaje);
		
		//////////////////////////////////////
		JLabel lblNombre = com.lblCampo("Puerto: ");
		lblNombre.setBounds(40, 70, 130, 30);
		seccion.add(lblNombre);
		
		txtPuerto = com.input();
		txtPuerto.setBounds(190, 70, 200, 30);
		seccion.add(txtPuerto);
		
		/////////////////////////////////
		lblNombre = com.lblCampo("Clave: ");
		lblNombre.setBounds(40, 120, 130, 30);
		seccion.add(lblNombre);
		
		txtClave = com.password();
		txtClave.setBounds(190, 120, 200, 30);
		seccion.add(txtClave);
	
		////////////////////////////////////
		lblNombre = com.lblCampo("Usuario: ");
		lblNombre.setBounds(40, 170, 130, 30);
		seccion.add(lblNombre);
		
		txtUsuario = com.input();
		txtUsuario.setText("root");
		txtUsuario.setBounds(190, 170, 200, 30);
		seccion.add(txtUsuario);
	
		////////////////////////////////////
		
		btnIngresar = com.botonRegistro("Iniciar");
		btnIngresar.setBounds(190, 230, 130, 30);
		btnIngresar.addMouseListener(this);
		seccion.add(btnIngresar);
		
		
	}


	public void escribirTxt(){
		
		File archivo;
		FileWriter lapiz;
		BufferedWriter bw;
		PrintWriter texto;
		
		try {
			
			archivo = new File(nombreArchivo);
			lapiz = new FileWriter(archivo);
			bw = new BufferedWriter(lapiz);
			texto = new PrintWriter(bw);
			
			texto.write(txtUsuario.getText() + "\n");
			texto.append(txtPuerto.getText() + "\n");
			texto.append(txtClave.getText() + "\n");
			
			
			texto.close();
			bw.close();
			
			
		} catch (Exception e) {
			System.out.println("Error");
			System.out.println(e.getMessage());
			
		}
		
	}


	public String leerTxt(){
		
		String comprobante = "";
		
		File archivo;
		FileReader fr;
		BufferedReader br;	
		
		try {
			
			archivo = new File(nombreArchivo);	
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			if(br.readLine() != null){
	
				System.out.println("Conectado correctamente a la base de datos ...");
			}
			else{
				comprobante ="archivoVacio";				
			}
				
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			System.out.println("Error ...");
			System.out.println(e.getMessage());
			comprobante = "noArchivo";
		}
		
		
		switch (comprobante) {
		case "noArchivo":
			comprobante = "noArchivo";		
			break;
		case "archivoVacio":
			comprobante ="archivoVacio";				
			break;

		default:
			comprobante = "archivoCorrecto";
			break;
		}

		return comprobante;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == btnIngresar){
		
			escribirTxt();
		
			miLogin = new UILogin();
			miLogin.setVisible(true);
			this.dispose();
			
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


