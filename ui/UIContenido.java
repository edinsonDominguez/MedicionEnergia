package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import helpers.Componentes;
import helpers.FormatoPosicion;
import procesos.ProcesoCompo;
import procesos.ProcesoContenido;
import procesos.ProcesoFactura;
import procesos.ValidarCampos;
import vo.Domestico;

public class UIContenido extends JFrame implements MouseListener{

	// clases logicas
	ProcesoContenido miProceso;
	ValidarCampos validar;
	ProcesoFactura procesoFactura;
	ProcesoCompo procesoCompo;
	
	//componentes graficos
	private JPanel contentPane;

	//contenido inicio
	private JLabel lblFacturaActual, lblFacturaAnterior, lblFacturaProxima;
	private JButton btnMasFacturas; 
	
	// contenido registro Factura
	private JTextField txtConsumo, txtTarifa, txtSubsidio, txtAlumbrado, txtFecha;
	private JButton registro;
	private JLabel lblErrorSubsidio, lblErrorTarifa, lblErrorConsumo, 
	lblErrorAlumbrado, lblErrorFecha;
	
	// contenido utilidades
	private JButton registroCompo, cancelarRegistro, ingresarCompo;
	private JPanel panelIngresoCompo, electro;
	private JTextField txtNombreCompo, txtVatioCompo;
	private JLabel lblVatio, lblVatiosHora, lblPrecioHora, lblPrecioDia, lblPrecioSemana,
	lblPrecioMes;
	private JComboBox<String> listaCompo;
	ArrayList<String> componentes;
	
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
	private JLabel opcInicio, opcRegistrarFactura, opcElementosCasa, 
	opcNoticias, opcInformacion;
	
	// contenidos del usuario
	private JPanel panelInicio, panelFactura, panelUtilidad, 
	panelNoticia, panelInformacion;
	
	
	
	public UIContenido(){

		// inicializamos las variables
		miProceso = new ProcesoContenido();
		procesoFactura = new ProcesoFactura();
		procesoCompo = new ProcesoCompo();
		
		validar = new ValidarCampos(); 
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
		
		JLabel descripcion = com.subtituloSection("Conoce cuanto consumen tus electrodomesticos.");
		descripcion.setBounds(20, 60, 600, 30);
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
		 panelIngresoCompo.setBounds(5, 90, 1040, 190);
		 panelUtilidad.add(panelIngresoCompo);
		 
		 int espacioLabel = 10;
		 int espacioTxt = 250;
		 
		 JLabel nombreCompo = com.lblCampo("Nombre electrodomestico");
		 nombreCompo.setBounds(espacioLabel, 20, 200, 30);
		 panelIngresoCompo.add(nombreCompo);
		 
		 txtNombreCompo = com.input();
		 txtNombreCompo.setBounds(espacioTxt, 20, 150, 30);
		 panelIngresoCompo.add(txtNombreCompo);
		 
		 JLabel vatioCompo = com.lblCampo("Watts electrodomestico");
		 vatioCompo.setBounds(espacioLabel, 60, 200, 30);
		 panelIngresoCompo.add(vatioCompo);
		 
		 txtVatioCompo = com.input();
		 txtVatioCompo.setBounds(espacioTxt, 60, 150, 30);
		 panelIngresoCompo.add(txtVatioCompo);
		 
		 
		 ingresarCompo = com.botonRegistro("Ingresar ");
		 ingresarCompo.setBounds(10, 140, 150, 30);
		 ingresarCompo.addMouseListener(this);
		 panelIngresoCompo.add(ingresarCompo); 
		
		cancelarRegistro = com.botonRegistro("Cancelar ");
		cancelarRegistro.setBounds(170, 140, 150, 30);
		cancelarRegistro.addMouseListener(this);
		panelIngresoCompo.add(cancelarRegistro);
		
		
		panelIngresoCompo.setVisible(false);

	}

	private void panelElectro() {
		
		electro = new JPanel();
		electro.setLayout(null);
		electro.setBackground(Color.decode("#e0e0e0"));
		electro.setBounds(5, 90, 1040, 190);
		panelUtilidad.add(electro);
		
		// posicion de los titulos de la lista
		int posTitulo = 10; 
		
		JLabel nombreElectro = com.headerLista("Electrodomestico");
		nombreElectro.setBounds(20, posTitulo, 150, 30);
		electro.add(nombreElectro);
		
		JLabel wElectro = com.headerLista("W");
		wElectro.setBounds(200, posTitulo, 50, 30);
		electro.add(wElectro);
		
		JLabel kWhElectro = com.headerLista("kWh");
		kWhElectro.setBounds(300, posTitulo, 50, 30);
		electro.add(kWhElectro);
		
		JLabel precioHoraElectro = com.headerLista("Precio-hora");
		precioHoraElectro.setBounds(450, posTitulo, 100, 30);
		electro.add(precioHoraElectro);
		
		JLabel precioDiaElectro = com.headerLista("Precio-dia");
		precioDiaElectro.setBounds(600, posTitulo, 100, 30);
		electro.add(precioDiaElectro);
		
		JLabel precioSemanaElectro = com.headerLista("Precio-semana");
		precioSemanaElectro.setBounds(750, posTitulo, 120, 30);
		electro.add(precioSemanaElectro);
		
		JLabel precioMesElectro = com.headerLista("Precio-mes");
		precioMesElectro.setBounds(900, posTitulo, 120, 30);
		electro.add(precioMesElectro);
		
		listaCompo = new JComboBox<>();
		
		electro.add(listaCompo);
		
		registroCompo = com.botonRegistro("Registrar");
		registroCompo.setBounds(10, 140, 150, 30);
		registroCompo.addMouseListener(this);
		electro.add(registroCompo);
		
		
	}

	private void listaCompo() {
		
		listaCompo.setBounds(50, 60, 150, 30);
		
		ArrayList<String> componentes = null;
		listaCompo.removeAllItems();
		
		System.out.println("getNombreUsuario " + getNombreUsuario());
			
			componentes = procesoCompo.listaCompo(getNombreUsuario());
			
			System.out.println("Cantidad de componentes: " + componentes.size());
			
			for (int i = 0; i < componentes.size(); i++) {
				listaCompo.addItem(componentes.get(i));
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
		JLabel lblFecha = com.lblCampo("Fecha de vencimiento *");
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
		
		int posRes = 80;
		
		lblFacturaAnterior = com.lblResultado();
		lblFacturaAnterior.setBounds(posRes, 100, 120, 30);
		panelInicio.add(lblFacturaAnterior);
		
		JLabel facActual = com.subtituloSection("Factura actual:");
		facActual.setBounds(posicion, 140, 200, 30);
		panelInicio.add(facActual);
		
		lblFacturaActual = com.lblResultado();
		lblFacturaActual.setBounds(posRes, 170, 120, 30);
		panelInicio.add(lblFacturaActual);
		
		JLabel facProxima = com.subtituloSection("Factura proxima:");
		facProxima.setBounds(posicion, 210, 200, 30);
		panelInicio.add(facProxima);
		
		lblFacturaProxima = com.lblResultado();
		lblFacturaProxima.setBounds(posRes, 240, 120, 30);
		panelInicio.add(lblFacturaProxima);
		
		btnMasFacturas = new JButton("Mas Facturas");
		btnMasFacturas.setBounds(820, 280, 200, 30);
		panelInicio.add(btnMasFacturas);
		
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
		
		// manejo de formularios btn 
		
		if(registro == e.getSource()){
			System.out.println("Presiono en btnRegistro ");
			imprimirResultados();
			
		}
		
		// manejo de visibilidad de campos
		if(registroCompo == e.getSource()){
			
			System.out.println("Vista de registro de componentes");
			panelIngresoCompo.setVisible(true);
			electro.setVisible(false);
		}
		
		if(cancelarRegistro == e.getSource()){
			panelIngresoCompo.setVisible(false);
			electro.setVisible(true);
		}
		
		if(ingresarCompo == e.getSource()){
			registrarCompo();
		}
		
	}

	private void imprimirResultados() {
		
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
					
				}else{
					
					// Mostrar mensajes del campo txtConsumo ...
				switch(resultadoConsumo){
				case "campoVacio":
					System.out.println("consumo - Vacio");
					lblErrorConsumo.setText("Este campo esta vacio !!");
					break;
				case "letraCampo":
					System.out.println("consumo - Hay una letra");
					lblErrorConsumo.setText("No pueden haber letras en el campo !!");
					break;
				case "ok":
					System.out.println("consumo - no hay error");
					lblErrorConsumo.setText("");		
					break;
				}
			
					// mostrar mensajes del campo txtTarifa ...	
					if(resultadoTarifa.equals("campoVacio")){
						lblErrorTarifa.setText("Este campo esta vacio !!");
					}else{
						if(resultadoTarifa.equals("letraCampo")){
							lblErrorTarifa.setText("No pueden haber letras en el campo !!");
						}else{
							if(resultadoTarifa.equals("ok")){
								System.out.println("Consumo correcto!!");
								lblErrorTarifa.setText("");		
							}
						}
					}
					
					// mostrar mensajes del campo txtSubsidio ...
					if(resultadoSubsidio.equals("campoVacio")){
						lblErrorSubsidio.setText("Este campo esta vacio !!");
					}else{
						if(resultadoSubsidio.equals("letraCampo")){
							lblErrorSubsidio.setText("No pueden haber letras en el campo !!");
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
							lblErrorAlumbrado.setText("No pueden haber letras en el campo !!");
						}else{
							if(resultadoAlumbrado.equals("ok")){
								System.out.println("Consumo correcto!!");
								lblErrorAlumbrado.setText("");		
							}
						}
					}
					
					
					// mostrar mensajes del campo txtFecha ...
					if(resultadoFecha.equals("campoVacio")){
						lblErrorFecha.setText("Este campo esta vacio !!");
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
			
			// imprimir nombre usuario 
			System.out.println("####################################");
			System.out.println("nombre usuario: " + getNombreUsuario());
			
			
			
			// Conexion a la clase de logica de negocio de nuestra aplicacion
			procesoFactura.tomarDatos(consumo, tarifa, subsidio, alumbrado, getNombreUsuario(), txtFecha.getText());
			
			// esta varible mostrara el valor a pagar de la factura 
			int totalPagar = procesoFactura.mostrarTotal();
			
			// Se imprime el valor de toda la factura !!
			System.out.println("Factura = " + totalPagar);
			
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

	public void registrarCompo(){
	
		Domestico miCompo = new Domestico();
		miCompo.setNombreCompo(txtNombreCompo.getText());
		miCompo.setVatios(Integer.parseInt(txtVatioCompo.getText()));
		miCompo.setUsuarioCompo(getNombreUsuario());
		
		String estado = procesoCompo.ingresarDomestico(miCompo);
		
		if(estado.equals("ok")){
			System.out.println("Registro compo con exito !!");
			listaCompo();
			
		}else{
			System.out.println("NO pudo registrarse el Compo !!");
		}
	}
	
	
	// recibimos el usuario puesto en el login
			public void recibirNombre(String nombreUsuario){
				
				System.out.println("Nombre Usuario: " + nombreUsuario);
				/*setNombreUsuario(login.getNombreUsuario());
			*/
				// contenemos en el valor
				setNombreUsuario(nombreUsuario);
				
				resultadosFacturas();
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

			
	
			
			
			
			
	
	
}
