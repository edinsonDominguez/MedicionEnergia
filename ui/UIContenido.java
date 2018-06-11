package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import helpers.Componentes;
import helpers.FormatoPosicion;

public class UIContenido extends JFrame implements MouseListener{

	//componentes graficos
	private JPanel contentPane;
	
	private JTextField txtConsumo, txtTarifa, txtSubsidio, txtAlumbrado, txtFecha;
	private JButton registro;
	private JLabel lblErrorSubsidio, lblErrorTarifa, lblErrorConsumo, 
	lblErrorAlumbrado, lblErrorFecha;
	

	// usuario
	private String nombreUsuario;
	
	// Variables de diseño
	Componentes com;
	FormatoPosicion pos;
	UIRegistroFactura miFactura;
	
	// Opciones de usuario.
	private JLabel opcInicio, opcRegistrarFactura, opcElementosCasa, 
	opcNoticias, opcInformacion;
	
	// contenidos del usuario
	private JPanel panelInicio, panelFactura, panelUtilidad, panelNoticia, panelInformacion;
	
	
	
	public UIContenido(){
	
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
		header.setBounds(pos.colB, pos.row1, 1080, 60);
		contentPane.add(header);

		// menu de opciones
		aside();
		
		section();
		
		JButton salir = com.botonSalir("Salir");
		contentPane.add(salir);
		
	}

	private void section() {
		
		// Sera el contenedor del Inicio de contenido
		
		//PanelInicio
		panelInicio();
		
		//PanelFactura
		panelFactura();
		
		//PanelUtilidades
		panelUtilidades();
	
		//PanelNoticias
		panelNoticias();
	
		//PanelInformacion
		panelInformacion();
		
	}

	private void panelInformacion() {
		
		panelInformacion = com.section();
		contentPane.add(panelInformacion);
		
		JLabel tituloInformacion = com.tituloSection("Informacion");
		panelInformacion.add(tituloInformacion);
		
		
		// la visibilidad del contenido
		panelInformacion.setVisible(false);
		
	}

	private void panelNoticias() {

		panelNoticia = com.section();
		contentPane.add(panelNoticia);
		
		JLabel tituloNoticia = com.tituloSection("Noticias");
		panelNoticia.add(tituloNoticia);
		
		
		// la visibilidad del contenido
		panelNoticia.setVisible(false);
				
	}

	private void panelUtilidades() {
	
		panelUtilidad = com.section();
		contentPane.add(panelUtilidad);
		
		JLabel tituloUtilidad = com.tituloSection("Utilidades");
		panelUtilidad.add(tituloUtilidad);
		
		
		// la visibilidad del contenido
		panelUtilidad.setVisible(false);
				
	}

	private void panelFactura() {
		// este method contiene los componentes del contenido de facturas
		
		panelFactura = com.section();
		contentPane.add(panelFactura);
		
		JLabel tituloFactura = com.tituloSection("Facturas");
		panelFactura.add(tituloFactura);

		// fomulario
		
		JPanel form = com.form();
		form.setBounds(10, 60, 540, 480);
		panelFactura.add(form);
		
		JLabel lblTitulo = com.subtituloSection("Registro Factura.");
		lblTitulo.setBounds(pos.fColB, 30, 400, 30);
		form.add(lblTitulo);
		
		// este componente contiene los simbolos de la app
		JLabel simboloConsumo;
		
		// campo Consumo
		JLabel lblConsumo = com.lblCampo("Consumo *");
		lblConsumo.setBounds(pos.fColB, pos.fRow2, 90, 30);
		form.add(lblConsumo);
		
		
		txtConsumo = com.input();
		txtConsumo.setBounds(pos.fColB, pos.fRow3, 160, 30);
		form.add(txtConsumo);
		
		simboloConsumo = com.simbolo("kWh");
		simboloConsumo.setBounds(pos.fColE, pos.fRow3, 60, 40);
		form.add(simboloConsumo);
		
		
		lblErrorConsumo = com.lblValidacion("");
		lblErrorConsumo.setBounds(pos.fColF, pos.fRow3, 160, 20);
		form.add(lblErrorConsumo);
		
		// campo Tarifa
		JLabel lblTarifa = com.lblCampo("Tarifa *");
		lblTarifa.setBounds(pos.fColB, pos.fRow4, 90, 30);
		form.add(lblTarifa);
		
		txtTarifa = com.input();
		txtTarifa.setBounds(pos.fColB, pos.fRow5, 160, 30);
		form.add(txtTarifa);
		
		simboloConsumo = com.simbolo("$/kWh");
		simboloConsumo.setBounds(pos.fColE, pos.fRow5, 60, 40);
		form.add(simboloConsumo);
		
		lblErrorTarifa = com.lblValidacion("");
		lblErrorTarifa.setBounds(pos.fColF, pos.fRow5, 160, 20);
		form.add(lblErrorTarifa);
		
		// campo Subsidio
		JLabel lblSubsidio = com.lblCampo("Subsidio *");
		lblSubsidio.setBounds(pos.fColB, pos.fRow6, 90, 30);
		form.add(lblSubsidio);
		
		txtSubsidio = com.input();
		txtSubsidio.setBounds(pos.fColB, pos.fRow7, 160, 30);
		form.add(txtSubsidio);
		
		simboloConsumo = com.simbolo("%");
		simboloConsumo.setBounds(pos.fColE, pos.fRow7, 60, 40);
		form.add(simboloConsumo);
		
		lblErrorSubsidio = com.lblValidacion("");
		lblErrorSubsidio.setBounds(pos.fColF, pos.fRow7, 160, 20);
		form.add(lblErrorSubsidio);
		
		// campo alumbradoPublico
		JLabel lblAlumbrado = com.lblCampo("Alumbrado publico");
		lblAlumbrado.setBounds(pos.fColB, pos.fRow8, 180, 30);
		form.add(lblAlumbrado);
		
		txtAlumbrado = com.input();
		txtAlumbrado.setBounds(pos.fColB, pos.fRow9, 160, 30);
		form.add(txtAlumbrado);
		
		lblErrorAlumbrado = com.lblValidacion("");
		lblErrorAlumbrado.setBounds(pos.fColF, pos.fRow9, 160, 20);
		form.add(lblErrorAlumbrado);
		
		simboloConsumo = com.simbolo("$");
		simboloConsumo.setBounds(pos.fColE, pos.fRow9, 60, 40);
		form.add(simboloConsumo);
		
		//campo fechaPago
		JLabel lblFecha = com.lblCampo("Fecha de Pago *");
		lblFecha.setBounds(pos.fColB, pos.fRow10, 180, 30);
		form.add(lblFecha);
		
		txtFecha = com.input();
		txtFecha.setBounds(pos.fColB, pos.fRow11, 160, 30);
		form.add(txtFecha);
		
		simboloConsumo = com.simbolo("AA-MM-DD");
		simboloConsumo.setBounds(pos.fColE, pos.fRow11, 120, 40);
		form.add(simboloConsumo);
		
		lblErrorFecha = com.lblValidacion("");
		lblErrorFecha.setBounds(pos.fColG, pos.fRow11, 160, 20);
		form.add(lblErrorFecha);
		
		
		// boton registro 
		registro = com.botonRegistro("Registrar");
		registro.setBounds(pos.fColG, pos.fRow12, 150, 40);
		registro.addMouseListener(this);
		form.add(registro);

		
		// visibilidad del contenido de las facturas
		panelFactura.setVisible(false);
		
	}

	private void panelInicio() {
		// este method tiene los componentes del contenido de inicio
		
		panelInicio = com.section();
		contentPane.add(panelInicio);
		
		JLabel titulo = com.tituloSection("Inicio");
		panelInicio.add(titulo);
		
		int posicion = 50; 
		
		JLabel facAnterior = com.subtituloSection("Factura anterior:");
		facAnterior.setBounds(posicion, 70, 200, 30);
		panelInicio.add(facAnterior);
		
		JLabel facActual = com.subtituloSection("Factura actual:");
		facActual.setBounds(posicion, 140, 200, 30);
		panelInicio.add(facActual);
		
		JLabel facProxima = com.subtituloSection("Factura proxima:");
		facProxima.setBounds(posicion, 210, 200, 30);
		panelInicio.add(facProxima);
		
		JButton masFacturas = new JButton("Mas Facturas");
		masFacturas.setBounds(820, 280, 200, 30);
		panelInicio.add(masFacturas);
		
		// determina la visibilidad del panel de inicio
		panelInicio.setVisible(true);
		
		panelDiagrama();
		
		
	}

	private void panelDiagrama() {
		// este method pertenece a el contenido del panel inicio
		JPanel panelDiagrama = new JPanel();
		panelDiagrama.setLayout(null);
		panelDiagrama.setBackground(Color.decode("#e0e0e0"));
		panelDiagrama.setBounds(5, 330, 1040, 190);
		panelInicio.add(panelDiagrama);
		
		
	}

	private void aside() {
		
		// este method contiene el menu de opciones de usuario
		JPanel aside = com.aside();
		aside.setBounds(pos.colA, pos.row1, 180, 400);
		contentPane.add(aside);
	
		opcInicio = com.opcionUsuario("Inicio");
		opcInicio.setBounds(pos.aColA, pos.aRow1, 180, 30);
		opcInicio.addMouseListener(this);
		aside.add(opcInicio);
		
		opcRegistrarFactura = com.opcionUsuario("Facturas");
		opcRegistrarFactura.addMouseListener(this);
		opcRegistrarFactura.setBounds(pos.aColA, pos.aRow2, 180, 30);
		aside.add(opcRegistrarFactura);
		
		opcElementosCasa = com.opcionUsuario("Utilidades");
		opcElementosCasa.addMouseListener(this);
		opcElementosCasa.setBounds(pos.aColA, pos.aRow3, 180, 30);
		aside.add(opcElementosCasa);
		
		opcNoticias = com.opcionUsuario("Noticias");
		opcNoticias.addMouseListener(this);
		opcNoticias.setBounds(pos.aColA, pos.aRow4, 180, 30);
		aside.add(opcNoticias);
		
		opcInformacion = com.opcionUsuario("Informacion");
		opcInformacion.addMouseListener(this);
		opcInformacion.setBounds(pos.aColA, pos.aRow5, 180, 30);
		aside.add(opcInformacion);
		
		
	}

	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		// manejo de vistas_contenidos
		if(opcInicio == e.getSource()){
			
			panelInicio.setVisible(true);
			panelFactura.setVisible(false);
			panelUtilidad.setVisible(false);
			panelNoticia.setVisible(false);
			panelInformacion.setVisible(false);
			
		}
		
		if(opcRegistrarFactura == e.getSource()){
			
			panelInicio.setVisible(false);
			panelFactura.setVisible(true);
			panelUtilidad.setVisible(false);
			panelNoticia.setVisible(false);
			panelInformacion.setVisible(false);
			
		}
		
		if(opcElementosCasa == e.getSource()){
			
			panelInicio.setVisible(false);
			panelFactura.setVisible(false);
			panelUtilidad.setVisible(true);
			panelNoticia.setVisible(false);
			panelInformacion.setVisible(false);
			
		}
		
		if(opcNoticias == e.getSource()){
			
			panelInicio.setVisible(false);
			panelFactura.setVisible(false);
			panelUtilidad.setVisible(false);
			panelNoticia.setVisible(true);
			panelInformacion.setVisible(false);
			
		}
		
		if(opcInformacion == e.getSource()){
			
			panelInicio.setVisible(false);
			panelFactura.setVisible(false);
			panelUtilidad.setVisible(false);
			panelNoticia.setVisible(false);
			panelInformacion.setVisible(true);
			
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(opcInicio == e.getSource()){
			opcInicio.setForeground(Color.decode("#000000"));
		}
		if(opcRegistrarFactura == e.getSource()){
			opcRegistrarFactura.setForeground(Color.decode("#000000"));
		}
		if(opcElementosCasa == e.getSource()){
			opcElementosCasa.setForeground(Color.decode("#000000"));
		}
		if(opcNoticias == e.getSource()){
			opcNoticias.setForeground(Color.decode("#000000"));
		}
		if(opcInformacion == e.getSource()){
			opcInformacion.setForeground(Color.decode("#000000"));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if(opcInicio == e.getSource()){
			opcInicio.setForeground(Color.decode("#ffffff"));		
		}
		if(opcRegistrarFactura == e.getSource()){
			opcRegistrarFactura.setForeground(Color.decode("#ffffff"));
		}
		if(opcElementosCasa == e.getSource()){
			opcElementosCasa.setForeground(Color.decode("#ffffff"));
		}
		if(opcNoticias == e.getSource()){
			opcNoticias.setForeground(Color.decode("#ffffff"));
		}
		if(opcInformacion == e.getSource()){
			opcInformacion.setForeground(Color.decode("#ffffff"));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	// recibimos el usuario puesto en el login
			public void recibirNombre(String nombreUsuario){
				
				System.out.println("Nombre Usuario: " + nombreUsuario);
				/*setNombreUsuario(login.getNombreUsuario());
			*/
				// contenemos en el valor
				setNombreUsuario(nombreUsuario);
				
				resultadosFacturas();
			}

			private void resultadosFacturas() {
				
				
			}

			public String getNombreUsuario() {
				return nombreUsuario;
			}

			public void setNombreUsuario(String nombreUsuario) {
				this.nombreUsuario = nombreUsuario;
			}

			
	// set and get
			
			
			
			
	
	
}
