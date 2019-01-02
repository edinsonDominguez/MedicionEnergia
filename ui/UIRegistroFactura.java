package ui;

import javax.swing.*;

import helpers.Componentes;
import helpers.FormatoPosicion;

import procesos.ProcesoFactura;
import procesos.ValidarCampos;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


	public class UIRegistroFactura extends JFrame implements MouseListener {

		private JPanel contentPane;
		private JTextField txtConsumo, txtTarifa, txtSubsidio, txtAlumbrado, txtFecha;
		private JButton registro;
		private JLabel lblErrorSubsidio, lblErrorTarifa, lblErrorConsumo, lblErrorAlumbrado, lblErrorFecha;
		
		// esta variable contiene el nombre del usuario registrado
		private String nombreUsuario;
		
		// Clases Logicas
		ProcesoFactura miProceso;
		ValidarCampos validar;
		
		// Clases de diseño
		FormatoPosicion pos;
		Componentes com;
		UIContenido miContenido;
		
		// variables validaciones
		String resultadoConsumo = "", resultadoTarifa = "", resultadoSubsidio = "", resultadoAlumbrado = "", resultadoFecha = "";
		
		
		public UIRegistroFactura() {
			System.out.println("Cargando la ventana UIRegistroFactura");
			
			// Inicializamos las variables 
			
			pos = new FormatoPosicion();
			com = new Componentes();
			
			setSize(1260,720);
			setTitle("Registro factura.");
			setLocationRelativeTo(null);
		
			componentes();
		}
			
		private void componentes(){
			
			contentPane = com.panelPrincipal();
			add(contentPane);
			
			JPanel header = com.header();
			header.setBounds(pos.colA, pos.row1, 1260, 120);
			contentPane.add(header);
		
			form();
			
			JButton continuar = com.botonSalir("Salir");
			contentPane.add(continuar);
			
		}
		
		private void form() {
		
			//este method contiene todos los componentes de el formulario
			JPanel form = com.form();
			form.setBounds(pos.colC, pos.row4, 540, 480);
			contentPane.add(form);
			
			JLabel lblTitulo = com.tituloPrincipal("Registro Factura.");
			lblTitulo.setBounds(pos.fColD, pos.fRow1, 400, 30);
			form.add(lblTitulo);
			
			// este componente contiene los simbolos de la app
			JLabel simboloConsumo;
			int logoPos = 370;
			int priPos = 30;
			int segPos = 200;
			int terPos = 260;
			
			// campo Consumo
			JLabel lblConsumo = com.lblCampo("Consumo *");
			lblConsumo.setBounds(priPos, pos.fRow2, 90, 30);
			form.add(lblConsumo);
			
			txtConsumo = com.input();
			txtConsumo.setBounds(priPos, pos.fRow3, 160, 30);
			form.add(txtConsumo);
			
			simboloConsumo = com.simbolo("kWh");
			simboloConsumo.setBounds(segPos, pos.fRow3, 60, 40);
			form.add(simboloConsumo);
			
			JLabel logo = com.logo("/ima/consumo.png");
			logo.setBounds(logoPos, 70, 160, 40);
			form.add(logo);
			
			lblErrorConsumo = com.lblValidacion("");
			lblErrorConsumo.setBounds(terPos, pos.fRow3, 160, 20);
			form.add(lblErrorConsumo);
			
			// campo Tarifa
			JLabel lblTarifa = com.lblCampo("Tarifa *");
			lblTarifa.setBounds(priPos, pos.fRow4, 90, 30);
			form.add(lblTarifa);
			
			txtTarifa = com.input();
			txtTarifa.setBounds(priPos, pos.fRow5, 160, 30);
			form.add(txtTarifa);
			
			simboloConsumo = com.simbolo("$/kWh");
			simboloConsumo.setBounds(segPos, pos.fRow5, 60, 40);
			form.add(simboloConsumo);
			
			logo = com.logo("/ima/tarifa.png");
			logo.setBounds(logoPos, 150, 160, 40);
			form.add(logo);
			
			lblErrorTarifa = com.lblValidacion("");
			lblErrorTarifa.setBounds(terPos, pos.fRow5, 160, 20);
			form.add(lblErrorTarifa);
			
			// campo Subsidio
			JLabel lblSubsidio = com.lblCampo("Subsidio *");
			lblSubsidio.setBounds(priPos, pos.fRow6, 90, 30);
			form.add(lblSubsidio);
			
			txtSubsidio = com.input();
			txtSubsidio.setBounds(priPos, pos.fRow7, 160, 30);
			form.add(txtSubsidio);
			
			simboloConsumo = com.simbolo("%");
			simboloConsumo.setBounds(segPos, pos.fRow7, 60, 40);
			form.add(simboloConsumo);
			
			logo = com.logo("/ima/subsidio.png");
			logo.setBounds(logoPos, 230, 160, 40);
			form.add(logo);
			
			lblErrorSubsidio = com.lblValidacion("");
			lblErrorSubsidio.setBounds(terPos, pos.fRow7, 160, 20);
			form.add(lblErrorSubsidio);
			
			// campo alumbradoPublico
			JLabel lblAlumbrado = com.lblCampo("Alumbrado publico");
			lblAlumbrado.setBounds(priPos, pos.fRow8, 180, 30);
			form.add(lblAlumbrado);
			
			txtAlumbrado = com.input();
			txtAlumbrado.setBounds(priPos, pos.fRow9, 160, 30);
			form.add(txtAlumbrado);
			
			lblErrorAlumbrado = com.lblValidacion("");
			lblErrorAlumbrado.setBounds(terPos, pos.fRow9, 160, 20);
			form.add(lblErrorAlumbrado);
			
			simboloConsumo = com.simbolo("$");
			simboloConsumo.setBounds(segPos, pos.fRow9, 60, 40);
			form.add(simboloConsumo);
			
			logo = com.logo("/ima/alumbrado.png");
			logo.setBounds(logoPos, 300, 160, 40);
			form.add(logo);
			
			//campo fechaPago
			JLabel lblFecha = com.lblCampo("Fecha de vencimiento *");
			lblFecha.setBounds(priPos, pos.fRow10, 180, 30);
			form.add(lblFecha);
			
			txtFecha = com.input();
			txtFecha.setBounds(priPos, pos.fRow11, 160, 30);
			form.add(txtFecha);
			
			simboloConsumo = com.simbolo("AA-MM-DD");
			simboloConsumo.setBounds(segPos, pos.fRow11, 80, 40);
			simboloConsumo.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));	
			form.add(simboloConsumo);
			
			logo = com.logo("/ima/fecha.png");
			logo.setBounds(logoPos, 360, 160, 40);
			form.add(logo);
			
			lblErrorFecha = com.lblValidacion("");
			lblErrorFecha.setBounds(terPos, pos.fRow11, 160, 20);
			form.add(lblErrorFecha);
			
			
			// boton registro 
			registro = com.botonRegistro("Continuar");
			registro.setBounds(pos.fColG, 430, 150, 40);
			registro.addMouseListener(this);
			form.add(registro);

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == registro){
			
				imprimirResultado();	
			}
			
		}

		private void imprimirResultado() {
			
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
				
			}else{
				
				// Mostrar mensajes del campo txtConsumo ...
				if(resultadoConsumo.equals("campoVacio")){
					lblErrorConsumo.setText("Campo vacio !!");
				}else{
					if(resultadoConsumo.equals("letraCampo")){
					lblErrorConsumo.setText("Hay letras en el campo !!");
					}else{
						if(resultadoConsumo.equals("ok")){
							System.out.println("Consumo correcto!!");
							lblErrorConsumo.setText("");		
						}
					}
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
					lblErrorSubsidio.setText("Campo vacio !!");
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
		
		private void crearVentanaContenido() {
			miContenido = new UIContenido();
			miContenido.recibirNombre(getNombreUsuario());;
			miContenido.setVisible(true);
			this.dispose();
				
		}
		
		private void conectarLogicaNegocio() {

			miProceso = new ProcesoFactura();
			
			try {

			// Se parsean los datos ingresados
			int consumo = Integer.parseInt(txtConsumo.getText());
			double tarifa = Double.parseDouble(txtTarifa.getText());
			double subsidio = Double.parseDouble(txtSubsidio.getText());
			int alumbrado = Integer.parseInt(txtAlumbrado.getText());
			
			// Conexion a la clase de logica de negocio de nuestra aplicacion
			miProceso.tomarDatos(consumo, tarifa, subsidio, alumbrado, getNombreUsuario(), txtFecha.getText());
			
			// muestra el total del valor de la factura a pagar
			miProceso.mostrarTotal();
			
			// pasamos a la ui contenido
			crearVentanaContenido();
		
			} catch (Exception errores) {
				System.out.println("Error en el sistema");
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
		
		// recibimos el usuario puesto en el login
		public void recibirNombre(String nombreUsuario){
			
			System.out.println("Nombre Usuario: " + nombreUsuario);
			/*setNombreUsuario(login.getNombreUsuario());
		*/
			
			// contenemos en el valor
			setNombreUsuario(nombreUsuario);
		}

		public String getNombreUsuario() {
			return nombreUsuario;
		}

		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}

		

	}
