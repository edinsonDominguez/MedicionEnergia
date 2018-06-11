package ui;

import javax.swing.*;

import helpers.Componentes;
import helpers.FormatoPosicion;

import procesos.ProcesoFactura;
import procesos.ValidarCampos;

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
			System.out.println("Esta en la clase uiFactura");
			
			
			// Inicializamos las variables 
			miContenido = new UIContenido();
			miProceso = new ProcesoFactura();
			validar = new ValidarCampos();
			pos = new FormatoPosicion();
			com = new Componentes();
			
			setSize(1260,720);
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
			registro = com.botonRegistro("Continuar");
			registro.setBounds(pos.fColG, pos.fRow12, 150, 40);
			registro.addMouseListener(this);
			form.add(registro);

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == registro){
				System.out.println("presiono en registro !!");
				
				imprimirResultado();	
			}
			
		}

		private void imprimirResultado() {
			
			// en las varibles asignamos el method de validacion del registro de factura
			 resultadoConsumo = validar.validarCampos(txtConsumo.getText().trim());
			 resultadoTarifa = validar.validarCampos(txtTarifa.getText().trim());
			 resultadoSubsidio = validar.validarCampos(txtSubsidio.getText().trim());
			 resultadoAlumbrado = validar.validarCampos(txtAlumbrado.getText().trim());
			 resultadoFecha = validar.validarCampos(txtFecha.getText().trim());
			 
			 // se imprimen el resultado de las variables en consola
			 System.out.println("nuevo valor estadoConsumo " + resultadoConsumo);
			 System.out.println("nuevo valor estadoTarifa " + resultadoTarifa);
			 System.out.println("nuevo valor estadoSubsidio " + resultadoSubsidio);
			 System.out.println("nuevo valor estadoAlumbrado " + resultadoAlumbrado);
			System.out.println("nuevo valor estadoFecha " + resultadoFecha); 
			 
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
					lblErrorConsumo.setText("Este campo esta vacio !!");
				}else{
					if(resultadoConsumo.equals("letraCampo")){
					lblErrorConsumo.setText("No pueden haber letras en el campo !!");
					}else{
						if(resultadoConsumo.equals("ok")){
							System.out.println("Consumo correcto!!");
							lblErrorConsumo.setText("");		
						}
					}
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
			miProceso.tomarDatos(consumo, tarifa, subsidio, alumbrado, getNombreUsuario(), txtFecha.getText());
			
			// esta varible mostrara el valor a pagar de la factura 
			int totalPagar = miProceso.mostrarTotal();
			
			// Se imprime el valor de toda la factura !!
			System.out.println("Factura = " + totalPagar);
			
			// pasamos a la ui contenido.
			System.out.println("Ventana UIContenido");
			miContenido.recibirNombre(getNombreUsuario());;
			miContenido.setVisible(true);
			this.dispose();
			
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
