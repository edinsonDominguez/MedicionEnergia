package ui;

/* 17 de Octubre del 2018 7:49 PM
 * Actualizacion con Base de datos.
 * Obtener las caracteristicas de un Componente de la casa
 * Actualizacion de Componente.
 * */

/* 18 de Octubre del 2018 8.50 pm
 * implementar las caracteristicas de un componente a la vista del usuario
 * eliminar la opcion de noticias*/


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import helpers.Componentes;
import helpers.FormatoPosicion;
import procesos.ProcesoCompo;
import procesos.ProcesoContenido;
import procesos.ProcesoFactura;
import procesos.ValidarCampos;
import vo.Domestico;
import vo.Factura;

public class UIContenido extends JFrame implements MouseListener, ActionListener{

	// clases logicas
	ProcesoContenido miProceso;
	ValidarCampos validar;
	ProcesoFactura procesoFactura;
	ProcesoCompo procesoCompo;

	//contenedor de paneles 
	private JPanel contentPane;

	//contenido inicio
	private JLabel lblFacturaActual, lblFacturaAnterior, lblFacturaProxima;
	private JButton btnMasFacturas; 
	
	// User interface 
	UIFacturas miInterfazFactura;
	UIComponente miInterfazCompo;
	
	// contenido registro Factura
	private JTextField txtConsumo, txtTarifa, txtSubsidio, txtAlumbrado, txtFecha;
	private JButton registro;
	private JLabel lblErrorSubsidio, lblErrorTarifa, lblErrorConsumo, 
	lblErrorAlumbrado, lblErrorFecha;
	
	
	// contenido utilidades
	
	private JLabel lblErrorNombre, lblErrorWatts, lblErrorHoras; 
	
	String resultadoNombre = "", resultadoWatts = "", resultadoHoras = "";
	
	// Componente JFreeChart
	JFreeChart diagramaBarras;
	
	// *******
	Domestico compoCaracter;
	private JButton registroCompo, cancelarRegistro, ingresarCompo, btnUIComponentes;
	private JPanel panelIngresoCompo, electro;
	private JTextField txtNombreCompo, txtVatioCompo, txtHoraCompo;
	private JLabel lblVatio, lblVatiosHora, lblPrecioDia, lblPrecioSemana,
	lblPrecioMes;
	double tarifa = 435.5;
	
	
	
	private JComboBox<String> listaCompo;
	ArrayList<String> componentesLista;
	
	// variables validaciones
	String resultadoConsumo = "", resultadoTarifa = "", 
			resultadoSubsidio = "", resultadoAlumbrado = "", resultadoFecha = "";
			
	
	// usuario
	private String nombreUsuario;
	
	// Variables de diseño
	Componentes com;
	FormatoPosicion pos;
	UIRegistroFactura miFactura;
	
	// Opciones de usuario.
	private JLabel opcInicio, opcRegistrarFactura, opcElementosCasa, opcInformacion;
	
	// contenidos del usuario
	private JPanel panelInicio, panelFactura, panelUtilidad, panelInformacion;

	public UIContenido(){
		
		
		// inicializamos las variables
		miProceso = new ProcesoContenido();
		procesoFactura = new ProcesoFactura();
		procesoCompo = new ProcesoCompo();
		
		
		com = new Componentes();
		pos = new FormatoPosicion();
	
		setSize(1260, 720);
		setTitle("Contenido.");
		setLocationRelativeTo(null);
	
		componentes();
	}
	
	private void componentes() {
	
		contentPane = com.panelPrincipal();
		add(contentPane);
		
		// este es el contenedor header
		JPanel header = new JPanel();		
		header.setLayout(null);
		header.setBackground(Color.decode("#424242"));
		header.setBounds(pos.colB, pos.row1, 1060, 60);
		contentPane.add(header);
		
		JLabel logo = new JLabel();
		logo.setBounds(0, 0, 600, 60);
		logo.setIcon(new ImageIcon(getClass().getResource("/ima/AppIcono60px.png")));
		header.add(logo);
		
		// contenido
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
	
	
		//PanelInformacion
		panelInformacion();
		
	}

	private void panelInformacion() {
		
		panelInformacion = com.section();
		contentPane.add(panelInformacion);
		
		
		JLabel tituloInformacion = com.tituloSection("Informacion");
		panelInformacion.add(tituloInformacion);
		
		//Linea Separadora.
		
		JSeparator linea = com.linea();
		linea.setBounds(10, 60, 500, 10);
		panelInformacion.add(linea);
		
		// Contenido de las noticias.
		
		JPanel noticias = new JPanel();
		noticias.setLayout(null);
		noticias.setBackground(Color.decode("#e0e0e0"));
		noticias.setBounds(10, 75,  1000, 160);
		panelInformacion.add(noticias);
		
		// Subtitulos de la seccion Informacion
		JLabel lblSubtitulo_Noticias = com.lblResultado();
		lblSubtitulo_Noticias.setText("Noticias");
		lblSubtitulo_Noticias.setBounds(10, 10, 150, 30);
		noticias.add(lblSubtitulo_Noticias);
		
		// Contenido del subtitulo noticias.
		JLabel lblTexto = com.lblCampo("Enterate de como Ahorrar Energia en el Blog de MediEnergia. ");
		lblTexto.setBounds(20, 50, 490, 30);
		noticias.add(lblTexto);
		
		lblTexto = com.lblLink("Sigueme ");
		lblTexto.setBounds(495, 50, 200, 30);
		noticias.add(lblTexto);
		
		linea = com.linea();
		linea.setBounds(10, 250, 500, 10);
		panelInformacion.add(linea);
		
		
		// Informacion del programador.
		
		JPanel infoDesarro = new JPanel();
		infoDesarro.setLayout(null);
		infoDesarro.setBackground(Color.decode("#e0e0e0"));
		infoDesarro.setBounds(10, 260, 1000, 160);
		panelInformacion.add(infoDesarro);
		
		// Subtitulos de la seccion Informacion
		JLabel lblSubtitulo_Programador = com.lblResultado();
		lblSubtitulo_Programador.setText("Datos del Desarrollador ");
		lblSubtitulo_Programador.setBounds(10, 10, 500, 30);
		infoDesarro.add(lblSubtitulo_Programador);
		
		lblTexto = com.lblCampo("Edinson Dominguez D. ");
		lblTexto.setBounds(20, 50, 500, 17);
		infoDesarro.add(lblTexto);
		
		lblTexto = new JLabel("Desarrollador de Software. ");
		lblTexto.setBounds(20, 65, 500, 30);
		lblTexto.setForeground(Color.decode("#424242"));
		lblTexto.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));	
		infoDesarro.add(lblTexto);
		
		
		lblTexto = com.lblCampo("E-MAIL: edinsondom@gmail.com ");
		lblTexto.setBounds(600, 40, 500, 30);
		infoDesarro.add(lblTexto);
		
		lblTexto = com.lblCampo("GITHUB: edinsondom");
		lblTexto.setBounds(600, 80, 500, 30);
		infoDesarro.add(lblTexto);
		
		
		
		// la visibilidad del contenido
		panelInformacion.setVisible(false);
		
	}

	private void panelUtilidades() {
	
		
		panelUtilidad = com.section();
		contentPane.add(panelUtilidad);
		
		JLabel tituloUtilidad = com.tituloSection("Utilidades");
		panelUtilidad.add(tituloUtilidad);
		
		JLabel descripcion = com.subtituloSection("Conoce cuanto consumen tus electrodomesticos.");
		descripcion.setBounds(20, 40, 600, 30);
		panelUtilidad.add(descripcion);
		
		
		panelIngresoCompo();
		
		panelElectro();
			 
		
		
		
		// la visibilidad del contenido
		panelUtilidad.setVisible(false);
				
	}

	private void panelIngresoCompo() {

		// Completar Visualizacion
		 panelIngresoCompo = new JPanel();
		 panelIngresoCompo.setLayout(null);
		 panelIngresoCompo.setBackground(Color.decode("#e0e0e0"));
		 panelIngresoCompo.setBounds(5, 65, 1040, 160);
		 panelUtilidad.add(panelIngresoCompo);
		 
		 int espacioLabel = 10;
		 int espacioTxt = 150;
		 int posVali = 350;
		 
		 JLabel nombreCompo = com.lblCampo("Nombre ");
		 nombreCompo.setBounds(espacioLabel, 20, 130, 15);
		 panelIngresoCompo.add(nombreCompo);

		 nombreCompo = com.lblCampo("electrodomestico");
		 nombreCompo.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		 nombreCompo.setBounds(espacioLabel, 35, 130, 10);
		 panelIngresoCompo.add(nombreCompo);
		 
		 
		 txtNombreCompo = com.input();
		 txtNombreCompo.setBounds(espacioTxt, 20, 150, 30);
		 panelIngresoCompo.add(txtNombreCompo);
		 
		 lblErrorNombre = com.lblValidacion("");
		 lblErrorNombre.setBounds(posVali, 20, 80, 30);
		 panelIngresoCompo.add(lblErrorNombre);
		 
		 
		 ///////////////////////////////////////////////////////////
		 
		 
		 // campo Watts
		 JLabel vatioCompo = com.lblCampo("Watts");
		 vatioCompo.setBounds(espacioLabel, 60, 130, 15);
		 panelIngresoCompo.add(vatioCompo);
		 
		 vatioCompo = com.lblCampo("electrodomestico");
		 vatioCompo.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		 vatioCompo.setBounds(espacioLabel, 75, 130, 10);
		 panelIngresoCompo.add(vatioCompo);
		 
		 txtVatioCompo = com.input();
		 txtVatioCompo.setBounds(espacioTxt, 60, 150, 30);
		 panelIngresoCompo.add(txtVatioCompo);
		 
		 JLabel simbolo = com.simbolo("W");
		 simbolo.setBounds(310, 60, 60, 30);
		 panelIngresoCompo.add(simbolo);
		 
		 lblErrorWatts = com.lblValidacion("");
		 lblErrorWatts.setBounds(posVali, 60, 80, 30);
		 panelIngresoCompo.add(lblErrorWatts);
		 
		 ////////////////////////////////////////////////////////////
		 
		 JLabel horaCompo = com.lblCampo("Horas");
		 horaCompo.setBounds(540, 20, 130, 15);
		 panelIngresoCompo.add(horaCompo);
		
		 horaCompo = com.lblCampo("de consumo");
		 horaCompo.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		 horaCompo.setBounds(540, 35, 130, 10);
		 panelIngresoCompo.add(horaCompo);
		 
		 txtHoraCompo = com.input();
		 txtHoraCompo.setBounds(650, 20, 150, 30);
		 panelIngresoCompo.add(txtHoraCompo);
		 
		 simbolo = com.simbolo("Hrs");
		 simbolo.setBounds(810, 20, 60, 30);
		 panelIngresoCompo.add(simbolo);
		
		 lblErrorHoras = com.lblValidacion("");
		 lblErrorHoras.setBounds(posVali, 20, 80, 30);
		 panelIngresoCompo.add(lblErrorHoras);
		
		 ////////////////////////////////////////////////////
		 
		 ingresarCompo = com.botonRegistro("Ingresar ");
		 ingresarCompo.setBounds(10, 120, 160, 30);
		 ingresarCompo.addMouseListener(this);
		 panelIngresoCompo.add(ingresarCompo); 
		
		cancelarRegistro = com.botonRegistro("Cancelar ");
		cancelarRegistro.setBounds(200, 120, 150, 30);
		cancelarRegistro.addMouseListener(this);
		panelIngresoCompo.add(cancelarRegistro);
		
		
		panelIngresoCompo.setVisible(false);

	}

	private void panelElectro() {
		
		electro = new JPanel();
		electro.setLayout(null);
		electro.setBackground(Color.decode("#e0e0e0"));
		electro.setBounds(5, 65, 1040, 160);
		panelUtilidad.add(electro);
		
		// posicion de los titulos de la lista
		int posTitulo = 10;
		int posResultado = 40;
		
		JLabel nombreElectro = com.headerLista("Electrodomestico");
		nombreElectro.setBounds(20, posTitulo, 150, 30);
		electro.add(nombreElectro);
		
		JLabel wElectro = com.headerLista("W");
		wElectro.setBounds(200, posTitulo, 50, 30);
		electro.add(wElectro);
		
		lblVatio = com.lblResultadoElectro();
		lblVatio.setBounds(200,posResultado,100, 30);
		electro.add(lblVatio);
		
		JLabel kWhElectro = com.headerLista("kWh");
		kWhElectro.setBounds(300, posTitulo, 50, 30);
		electro.add(kWhElectro);
		
		lblVatiosHora = com.lblResultadoElectro();
		lblVatiosHora.setBounds(300, posResultado, 100, 30);
		electro.add(lblVatiosHora);
		
		JLabel precioDiaElectro = com.headerLista("Precio-dia");
		precioDiaElectro.setBounds(450, posTitulo, 100, 30);
		electro.add(precioDiaElectro);
		
		lblPrecioDia = com.lblResultadoElectro();
		lblPrecioDia.setBounds(450, posResultado, 100, 30);
		electro.add(lblPrecioDia);
		
		JLabel precioSemanaElectro = com.headerLista("Precio-semana");
		precioSemanaElectro.setBounds(600, posTitulo, 120, 30);
		electro.add(precioSemanaElectro);
		
		lblPrecioSemana = com.lblResultadoElectro();
		lblPrecioSemana.setBounds(600, posResultado, 150, 30);
		electro.add(lblPrecioSemana);
		
		JLabel precioMesElectro = com.headerLista("Precio-mes");
		precioMesElectro.setBounds(750, posTitulo, 150, 30);
		electro.add(precioMesElectro);
		
		lblPrecioMes = com.lblResultadoElectro();
		lblPrecioMes.setBounds(750, posResultado, 100, 30);
		electro.add(lblPrecioMes);
		
		listaCompo = new JComboBox<>();
		listaCompo.addActionListener(this);
		
		electro.add(listaCompo);
		
		
		JSeparator linea = com.linea();
		linea.setBounds(5, 90, 1030, 10);
		electro.add(linea);
		
		registroCompo = com.botonRegistro("Registrar");
		registroCompo.setBounds(10, 120, 150, 30);
		registroCompo.addMouseListener(this);
		electro.add(registroCompo);
		
		btnUIComponentes = com.botonRegistro("Mas Electrodomesticos");
		btnUIComponentes.setBounds(700, 120, 250, 30);
		btnUIComponentes.addMouseListener(this);
		electro.add(btnUIComponentes);
		
		
	}

	private void listaCompo() {
		
		listaCompo.setBounds(10, 45, 150, 30);
		
		componentesLista = null;
		listaCompo.removeAllItems();
		
		componentesLista = procesoCompo.listaCompo(getNombreUsuario());
			
		for (int i = 0; i < componentesLista.size(); i++) {
			listaCompo.addItem(componentesLista.get(i));
		}
	
	}

	private void panelFactura() {
		// este method contiene los componentes del contenido de facturas
		
		panelFactura = com.section();
		contentPane.add(panelFactura);
		
		JLabel tituloFactura = com.tituloSection("Facturas");
		panelFactura.add(tituloFactura);

		// fomulario
		
		JPanel form = com.form();
		form.setBounds(100, 50, 600, 470);
		form.setBackground(Color.decode("#e0e0e0"));
		panelFactura.add(form);
		
		JLabel lblTitulo = com.subtituloSection("Registro Factura.");
		lblTitulo.setBounds(pos.fColB, 20, 400, 30);
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
		
		JLabel logo = com.logo("/ima/consumo.png");
		logo.setBounds(430, 70, 160, 40);
		form.add(logo);
		
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
		
		logo = com.logo("/ima/tarifa.png");
		logo.setBounds(430, 150, 160, 40);
		form.add(logo);
		
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
		
		logo = com.logo("/ima/subsidio.png");
		logo.setBounds(430, 230, 160, 40);
		form.add(logo);
		
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
		
		logo = com.logo("/ima/alumbrado.png");
		logo.setBounds(430, 300, 160, 40);
		form.add(logo);
		
		//campo fechaPago
		JLabel lblFecha = com.lblCampo("Fecha de vencimiento *");
		lblFecha.setBounds(pos.fColB, pos.fRow10, 180, 30);
		form.add(lblFecha);
		
		txtFecha = com.input();
		txtFecha.setBounds(pos.fColB, pos.fRow11, 160, 30);
		form.add(txtFecha);
		
		simboloConsumo = com.simbolo("AA-MM-DD");
		simboloConsumo.setBounds(pos.fColE, pos.fRow11, 120, 40);
		form.add(simboloConsumo);
		
		logo = com.logo("/ima/fecha.png");
		logo.setBounds(430, 360, 160, 40);
		form.add(logo);
		
		lblErrorFecha = com.lblValidacion("");
		lblErrorFecha.setBounds(340, pos.fRow11, 160, 20);
		form.add(lblErrorFecha);
		
		
		// boton registro 
		registro = com.botonRegistro("Registrar");
		registro.setBounds(380, 420, 150, 40);
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
		
		JPanel  componentesInicio= new JPanel();
		componentesInicio.setLayout(null);
		//
		componentesInicio.setBackground(Color.decode("#e0e0e0"));
		componentesInicio.setBounds(5, 50, 1040, 170);
		panelInicio.add(componentesInicio);
		
		
		int posicion = 30; 
		
		
		JLabel facAnterior = com.subtituloSection("Factura anterior:");
		facAnterior.setBounds(posicion, 5, 200, 20);
		componentesInicio.add(facAnterior);
		
		int posRes = 50;
		
		lblFacturaAnterior = com.lblResultado();
		lblFacturaAnterior.setBounds(posRes, 25, 120, 30);
		componentesInicio.add(lblFacturaAnterior);
		
		JLabel facActual = com.subtituloSection("Factura actual:");
		facActual.setBounds(posicion, 60, 200, 20);
		componentesInicio.add(facActual);
		
		lblFacturaActual = com.lblResultado();
		lblFacturaActual.setBounds(posRes, 80, 120, 30);
		componentesInicio.add(lblFacturaActual);
		
		JLabel facProxima = com.subtituloSection("Factura proxima:");
		facProxima.setBounds(posicion, 110, 200, 20);
		componentesInicio.add(facProxima);
		
		lblFacturaProxima = com.lblResultado();
		lblFacturaProxima.setBounds(posRes, 130, 120, 30);
		componentesInicio.add(lblFacturaProxima);
		
		btnMasFacturas = com.botonRegistro("Mas Facturas");
		btnMasFacturas.setBounds(820, 135, 200, 30);
		btnMasFacturas.addMouseListener(this);
		componentesInicio.add(btnMasFacturas);
		
		// determina la visibilidad del panel de inicio
		panelInicio.setVisible(true);
		
		
		
	}

	private void panelDiagrama() {
		// este method pertenece a el contenido del panel inicio
		// panel del diagrama de Componentes
				JPanel panelDiagrama = new JPanel();
				panelDiagrama.setBackground(Color.decode("#e0e0e0"));
				
				// Barra Scroll	
				JScrollPane scroll = new JScrollPane();
				scroll.setViewportView(panelDiagrama);
				scroll.setBounds(5, 230, 1040, 300);
				
				panelInicio.add(scroll);
				
				
				ArrayList<Factura> lista = procesoFactura.listaFacturas(getNombreUsuario());
				
				// fuente de datos
					DefaultCategoryDataset datosCompo = new DefaultCategoryDataset();
						
				for (int i = 0; i < lista.size(); i++) {	
					datosCompo.setValue(lista.get(i).getTotalPagar(), "Facturas", lista.get(i).getFechaFactura());
				}
				
				// creando el grafico
				diagramaBarras = ChartFactory.createBarChart3D("Facturas de Energia", 
						"Facturas", "Consumo Mensual", datosCompo, PlotOrientation.VERTICAL, 
						true, true, false);
						
				// imprimiendo grafico
				ChartPanel panel = new ChartPanel(diagramaBarras);
				
				panelDiagrama.add(panel);
				
	}

	private void aside() {
		
		
		// este method contiene el menu de opciones de usuario
		JPanel aside = com.aside();
		aside.setBounds(pos.colA, pos.row1, 180, 400);
		contentPane.add(aside);
	
		//Va ir la imagen de Usuario y el nombre del Usuario.
		
		JLabel logo = new JLabel();
		logo.setBounds(40, 20, 100, 100);
		logo.setIcon(new ImageIcon(getClass().getResource("/ima/imagen2.png")));
		logo.setHorizontalAlignment(JTextField.CENTER);
		aside.add(logo);
		
		JLabel nombreUsuario = new JLabel(getNombreUsuario().toUpperCase());
		nombreUsuario.setBounds(0, 120, 180, 30);
		nombreUsuario.setForeground(Color.decode("#ffffff"));
		nombreUsuario.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		nombreUsuario.setHorizontalAlignment(JTextField.CENTER);
		aside.add(nombreUsuario);
		
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
		
		opcInformacion = com.opcionUsuario("Informacion");
		opcInformacion.addMouseListener(this);
		opcInformacion.setBounds(pos.aColA, pos.aRow4, 180, 30);
		aside.add(opcInformacion);
		
		
	}

	
	private void panelDiagramaCompo(){
	
		
		// panel del diagrama de Componentes
		JPanel panelDiagrama = new JPanel();
		panelDiagrama.setBackground(Color.decode("#e0e0e0"));
		
		// Barra Scroll	
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(panelDiagrama);
		scroll.setBounds(5, 230, 1040, 300);
		
		panelUtilidad.add(scroll);
		
		
		ArrayList<Domestico> lista = procesoCompo.listaComponentes(getNombreUsuario());
		
		// fuente de datos
			DefaultCategoryDataset datosCompo = new DefaultCategoryDataset();
				
		for (int i = 0; i < lista.size(); i++) {	
			datosCompo.setValue(lista.get(i).getVatios(), "Componentes", lista.get(i).getNombreCompo());
		}
		
		// creando el grafico
		diagramaBarras = ChartFactory.createBarChart3D("Electrodomesticos de la Casa", 
				"Electrodomesticos", "Vatios (W)", datosCompo, PlotOrientation.VERTICAL, 
				true, true, false);
				
		// imprimiendo grafico
		ChartPanel panel = new ChartPanel(diagramaBarras);
		
		panelDiagrama.add(panel);
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		// manejo de vistas_contenidos
		if(opcInicio == e.getSource()){
			
			panelInicio.setVisible(true);
			panelFactura.setVisible(false);
			panelUtilidad.setVisible(false);
			panelInformacion.setVisible(false);
			
		}
		
		if(opcRegistrarFactura == e.getSource()){
			
			panelInicio.setVisible(false);
			panelFactura.setVisible(true);
			panelUtilidad.setVisible(false);
			panelInformacion.setVisible(false);
			
		}
		
		if(opcElementosCasa == e.getSource()){
			
			panelInicio.setVisible(false);
			panelFactura.setVisible(false);
			panelUtilidad.setVisible(true);
			panelInformacion.setVisible(false);
			
		}
		
		
		if(opcInformacion == e.getSource()){
			
			panelInicio.setVisible(false);
			panelFactura.setVisible(false);
			panelUtilidad.setVisible(false);
			panelInformacion.setVisible(true);
			
		}
		
		// manejo de formularios btn 
		
		if(registro == e.getSource()){
			System.out.println("Presiono en btnRegistro ");
			imprimirResultados();
			
		}
		
		// manejo de visibilidad de campos
		if(registroCompo == e.getSource()){
			panelIngresoCompo.setVisible(true);
			electro.setVisible(false);
		}
		
		if(cancelarRegistro == e.getSource()){
			panelIngresoCompo.setVisible(false);
			electro.setVisible(true);
		}
		
		if(ingresarCompo == e.getSource()){
			validarComponentes();;
		}
	
		
		if(btnUIComponentes == e.getSource()){
			
			miInterfazCompo = new UIComponente();
			miInterfazCompo.recibirNombre(getNombreUsuario());
			miInterfazCompo.setVisible(true);		
			
		}
		
		// boton para mostrar mas facturas 
		if(btnMasFacturas == e.getSource()){
			
			miInterfazFactura = new UIFacturas();	
			miInterfazFactura.recibirNombre(getNombreUsuario());
			miInterfazFactura.setVisible(true);
		}
		
		
	}

	// validacion de los campos de facturas
	private void imprimirResultados() {
		
		validar = new ValidarCampos(); 
		
		// en las varibles asignamos el method de validacion del registro de factura
		 resultadoConsumo = validar.validarCampos(txtConsumo.getText().trim());
		 resultadoTarifa = validar.validarCampos(txtTarifa.getText().trim());
		 resultadoSubsidio = validar.validarCampos(txtSubsidio.getText().trim());
		 resultadoAlumbrado = validar.validarCampos(txtAlumbrado.getText().trim());
		 resultadoFecha = validar.validarCampos(txtFecha.getText().trim());
		 
		 if(resultadoConsumo.equals("ok") && resultadoTarifa.equals("ok") && 
					resultadoSubsidio.equals("ok") 
					&& (resultadoAlumbrado.equals("ok") || resultadoAlumbrado.equals("campoVacio"))
					&& (resultadoFecha.equals("ok") || resultadoFecha.equals("letraCampo"))){
					
					conectarLogicaNegocio();
				
					lblErrorConsumo.setText("");
					lblErrorSubsidio.setText("");
					lblErrorTarifa.setText("");
					lblErrorAlumbrado.setText("");
					lblErrorFecha.setText("");
					
					JOptionPane.showMessageDialog(null, "Se registro la factura !!");
				}else{
					
					// Mostrar mensajes del campo txtConsumo ...
				switch(resultadoConsumo){
				case "campoVacio":
					System.out.println("consumo - Vacio");
					lblErrorConsumo.setText("Campo vacio !!");
					break;
				case "letraCampo":
					System.out.println("consumo - Hay una letra");
					lblErrorConsumo.setText("Hay letras en el campo !!");
					break;
				case "ok":
					System.out.println("consumo - no hay error");
					lblErrorConsumo.setText("");		
					break;
				}
			
					// mostrar mensajes del campo txtTarifa ...	
					if(resultadoTarifa.equals("campoVacio")){
						lblErrorTarifa.setText("Campo vacio !!");
					}else{
						if(resultadoTarifa.equals("letraCampo")){
							lblErrorTarifa.setText("Hay letras en el campo !!");
						}else{
							if(resultadoTarifa.equals("ok")){
								System.out.println("Consumo correcto!!");
								lblErrorTarifa.setText("");		
							}
						}
					}
					
					// mostrar mensajes del campo txtSubsidio ...
					if(resultadoSubsidio.equals("campoVacio")){
						lblErrorSubsidio.setText("Campo esta vacio !!");
					}else{
						if(resultadoSubsidio.equals("letraCampo")){
							lblErrorSubsidio.setText("Hay letras en el campo !!");
						}else{
							if(resultadoSubsidio.equals("ok")){
								System.out.println("Consumo correcto!!");
								lblErrorSubsidio.setText("");		
							}
						}
					}
					
					// mostrar mensaje del campo txtAlumbrado
					if(resultadoAlumbrado.equals("campoVacio")){
						System.out.println("no hay problema !!");
						lblErrorAlumbrado.setText("");		
					}else{
						if(resultadoAlumbrado.equals("letraCampo")){
							lblErrorAlumbrado.setText("Hay letras en el campo !!");
						}else{
							if(resultadoAlumbrado.equals("ok")){
								System.out.println("Consumo correcto!!");
								lblErrorAlumbrado.setText("");		
							}
						}
					}
					
					
					// mostrar mensajes del campo txtFecha ...
					if(resultadoFecha.equals("campoVacio")){
						lblErrorFecha.setText("Campo vacio !!");
					}else{
						if(resultadoFecha.equals("letraCampo")){
							lblErrorFecha.setText("");
						}else{
							if(resultadoFecha.equals("ok")){
								System.out.println("Consumo correcto!!");
								lblErrorFecha.setText("");		
							}
						}
					}
					
				}

		
	}
	

	private void conectarLogicaNegocio() {
		
		try {
			
			// Se parsean los datos ingresados
			int consumo = Integer.parseInt(txtConsumo.getText());
			double tarifa = Double.parseDouble(txtTarifa.getText());
			double subsidio = Double.parseDouble(txtSubsidio.getText());
			int alumbrado = Integer.parseInt(txtAlumbrado.getText());
				
			
			
			// Conexion a la clase de logica de negocio de nuestra aplicacion
			procesoFactura.tomarDatos(consumo, tarifa, subsidio, alumbrado, getNombreUsuario(), txtFecha.getText());
			
			// esta varible mostrara el valor a pagar de la factura 
			procesoFactura.mostrarTotal();
			
			resultadosFacturas();
			limpiarCampos();
			
		}catch (Exception errores) {
			System.out.println("Error en el sistema");
		}
		
	}

	private void limpiarCampos() {
		
		txtConsumo.setText("");
		txtTarifa.setText("");
		txtSubsidio.setText("");
		txtAlumbrado.setText("");
		txtFecha.setText("");
		 
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
		if(opcInformacion == e.getSource()){
			opcInformacion.setForeground(Color.decode("#ffffff"));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	// Este Metodo registra los Componentes
	public void registrarCompo(){
	
		Domestico miCompo = new Domestico();
		miCompo.setNombreCompo(txtNombreCompo.getText());
		miCompo.setVatios(Double.parseDouble(txtVatioCompo.getText()));
		miCompo.setHorasConsumo(Double.parseDouble(txtHoraCompo.getText()));
		miCompo.setUsuarioCompo(getNombreUsuario());
		
		String estado = procesoCompo.ingresarDomestico(miCompo, tarifa);
		
		if(estado.equals("ok")){
			
			JOptionPane.showMessageDialog(null, "El electrodomestico se registro\nCorrectamente !!");
			limpiarRegistro();
			
			// Imprime el nuevo componente registrado
			listaCompo();
			
		}else{
			System.out.println("No pudo registrarse el Compo !!");
			JOptionPane.showMessageDialog(null, "Error en la Base de datos");
		}	
		
		/////////////////////////////////////////////
		
		
	}
	
	
	private void validarComponentes() {
		
		validar = new ValidarCampos(); 
		
		// en las varibles asignamos el method de validacion del registro de factura
		 resultadoNombre = validar.validarCampos(txtNombreCompo.getText().trim());
		 resultadoWatts = validar.validarCampos(txtVatioCompo.getText().trim());
		 resultadoHoras = validar.validarCampos(txtHoraCompo.getText().trim());
		 
		 if(resultadoNombre.equals("ok") && resultadoWatts.equals("ok") && 
					resultadoHoras.equals("ok")){
					
			 	registrarCompo();
					
			 		lblErrorHoras.setText("");
					lblErrorNombre.setText("");
					lblErrorWatts.setText("");
				
					
					JOptionPane.showMessageDialog(null, "Se registro la factura !!");
				}else{
					
					// Mostrar mensajes del campo txtConsumo ...
				switch(resultadoNombre){
				case "campoVacio":
					System.out.println("consumo - Vacio");
					lblErrorNombre.setText("Campo vacio !!");
					break;
				case "letraCampo":
					System.out.println("No hay problema");
					lblErrorNombre.setText("");
					break;
				case "ok":
					System.out.println("consumo - no hay error");
					lblErrorNombre.setText("");		
					break;
				}
			
					// mostrar mensajes del campo txtTarifa ...	
					if(resultadoTarifa.equals("campoVacio")){
						lblErrorTarifa.setText("Campo vacio !!");
					}else{
						if(resultadoTarifa.equals("letraCampo")){
							lblErrorTarifa.setText("Hay letras en el campo !!");
						}else{
							if(resultadoTarifa.equals("ok")){
								System.out.println("Consumo correcto!!");
								lblErrorTarifa.setText("");		
							}
						}
					}
					
					// mostrar mensajes del campo txtSubsidio ...
					if(resultadoSubsidio.equals("campoVacio")){
						lblErrorSubsidio.setText("Campo esta vacio !!");
					}else{
						if(resultadoSubsidio.equals("letraCampo")){
							lblErrorSubsidio.setText("Hay letras en el campo !!");
						}else{
							if(resultadoSubsidio.equals("ok")){
								System.out.println("Consumo correcto!!");
								lblErrorSubsidio.setText("");		
							}
						}
					}
					
					// mostrar mensaje del campo txtAlumbrado
					if(resultadoAlumbrado.equals("campoVacio")){
						System.out.println("no hay problema !!");
						lblErrorAlumbrado.setText("");		
					}else{
						if(resultadoAlumbrado.equals("letraCampo")){
							lblErrorAlumbrado.setText("Hay letras en el campo !!");
						}else{
							if(resultadoAlumbrado.equals("ok")){
								System.out.println("Consumo correcto!!");
								lblErrorAlumbrado.setText("");		
							}
						}
					}
					
					
					// mostrar mensajes del campo txtFecha ...
					if(resultadoFecha.equals("campoVacio")){
						lblErrorFecha.setText("Campo vacio !!");
					}else{
						if(resultadoFecha.equals("letraCampo")){
							lblErrorFecha.setText("");
						}else{
							if(resultadoFecha.equals("ok")){
								System.out.println("Consumo correcto!!");
								lblErrorFecha.setText("");		
							}
						}
					}
					
				}

	}

	private void limpiarRegistro() {
		
		txtNombreCompo.setText("");
		txtVatioCompo.setText("");
		txtHoraCompo.setText("");
		
	}

	// recibimos el usuario puesto en el login
	public void recibirNombre(String nombreUsuario){
				// contenemos en el valor
				setNombreUsuario(nombreUsuario);
				
				resultadosFacturas();
				panelDiagramaCompo();
				panelDiagrama();
				
				// menu de opciones
				aside();
				
				//hace visible la lista de componentes
	
				listaCompo();
			
			}

	private void resultadosFacturas() {
				
				// asignamos valor a la factura Actual
				String facturaActual = miProceso.facturaActual(getNombreUsuario()); 
				lblFacturaActual.setText(facturaActual);
				
				// asignamos valor a la factura Anterior
				String facturaAnterior = miProceso.facturaAnterior(getNombreUsuario());
				lblFacturaAnterior.setText(facturaAnterior);
				
				// asignamos valor a la factura Proxima
				
				String facturaProxima = miProceso.fechaProxima(getNombreUsuario());
				lblFacturaProxima.setText(facturaProxima);
				
			}
			
			// set and get
	public String getNombreUsuario() {
				return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				// componentes
				if(e.getSource() == listaCompo){
					
					enviarNombreComponente(listaCompo.getSelectedItem().toString(), getNombreUsuario());									
					
				}
				
				
			}
			//Metodo Componentes
				
			
			// Este metodo enviara el nombre del componente a la Clase ProcesoCompo
			private void enviarNombreComponente(String nombreComponente, String nombreUsuario) {
				
				// Son las Caracteristicas del componente(Electrodomestico)
				compoCaracter =  procesoCompo.recibirNombreCompo(nombreComponente, nombreUsuario);
				
					imprimirDatosComponente();
				
			}

			private void imprimirDatosComponente() {
				
				lblVatio.setText(compoCaracter.getVatios() + " W");
				lblVatiosHora.setText(compoCaracter.getVatios() + " Wh");
				lblPrecioDia.setText(compoCaracter.getPrecioDia() + " $");
				lblPrecioSemana.setText(compoCaracter.getPrecioSemana() + " $");
				lblPrecioMes.setText(compoCaracter.getPrecioMes() + " $");
				
			}	
	
}
