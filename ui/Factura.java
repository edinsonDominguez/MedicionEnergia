package ui;

	import javax.swing.*;

import helpers.Componentes;
import helpers.FormatoPosicion;
import procesos.ProcesoFactura;
import procesos.ValidarCampos;

import java.awt.Font;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;

	public class Factura extends JFrame implements MouseListener {

		private JPanel contentPane;
		private JTextField txtConsumo, txtTarifa, txtSubsidio;
		private JButton registro;
		private JLabel lblErrorSubsidio, lblErrorTarifa, lblErrorConsumo;
		
		// Clases Logicas
		ProcesoFactura miProceso;
		ValidarCampos validar;
		
		// Clases de diseño
		FormatoPosicion pos;
		Componentes com;
		
		// variables validaciones
		String resultadoConsumo = "", resultadoTarifa = "", resultadoSubsidio = "";
		
		
		public Factura() {
			System.out.println("Esta en la clase uiFactura");
			
			// Inicializamos las variables 
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
			
			JLabel lblTitulo = com.tituloPrincipal("Registro Factura.");
			lblTitulo.setBounds(pos.colC, pos.row1, 400, 30);
			contentPane.add(lblTitulo);
			
			JLabel lblConsumo = com.lblCampo("Consumo *");
			lblConsumo.setBounds(pos.colA, pos.row2, 120, 20);
			contentPane.add(lblConsumo);
			
			txtConsumo = com.input();
			txtConsumo.setBounds(pos.colB, pos.row2, 120, 20);
			contentPane.add(txtConsumo);
			
			
			lblErrorConsumo = com.lblValidacion("");
			lblErrorConsumo.setBounds(pos.colC, pos.row2, 120, 20);
			contentPane.add(lblErrorConsumo);
			
			
			JLabel lblTarifa = com.lblCampo("Tarifa *");
			lblTarifa.setBounds(pos.colA, pos.row3, 120, 20);
			contentPane.add(lblTarifa);
			
			txtTarifa = com.input();
			txtTarifa.setBounds(pos.colB, pos.row3, 120, 20);
			contentPane.add(txtTarifa);
			
			lblErrorTarifa = com.lblValidacion("");
			lblErrorTarifa.setBounds(pos.colC, pos.row3, 120, 20);
			contentPane.add(lblErrorTarifa);
			
			JLabel lblSubsidio = com.lblCampo("Subsidio *");
			lblSubsidio.setBounds(pos.colA, pos.row4, 120, 20);
			contentPane.add(lblSubsidio);
			
			txtSubsidio = com.input();
			txtSubsidio.setBounds(pos.colB, pos.row4, 120, 20);
			contentPane.add(txtSubsidio);
			
			lblErrorSubsidio = com.lblValidacion("");
			lblErrorSubsidio.setBounds(pos.colC, pos.row4, 120, 20);
			contentPane.add(lblErrorSubsidio);
			
			
			registro = new JButton("Registrar");
			registro.setBounds(pos.colC, pos.row5, 120, 30);
			registro.setFont(new Font("Arial", Font.BOLD, 14));
			registro.addMouseListener(this);
			contentPane.add(registro);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == registro){
				System.out.println("presiono en registro !!");
				
				imprimirResultado();	
			}
			
		}

		private void imprimirResultado() {
			
			// inicializamos las varibles
			
			 resultadoConsumo = validar.validarCampos(txtConsumo.getText().trim());
			 resultadoTarifa = validar.validarCampos(txtTarifa.getText().trim());
			 resultadoSubsidio = validar.validarCampos(txtSubsidio.getText().trim());
			
			 // se imprimen el resultado de las variables en consola
			 System.out.println("nuevo valor estadoConsumo " + resultadoConsumo);
			 System.out.println("nuevo valor estadoTarifa " + resultadoTarifa);
			 System.out.println("nuevo valor estadoSubsidio " + resultadoSubsidio);
				
			if(resultadoConsumo.equals("ok") && resultadoTarifa.equals("ok") && resultadoSubsidio.equals("ok")){
				
				conectarLogicaNegocio();
				
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
				
				
			}

		}

		
		private void conectarLogicaNegocio() {

			try {
				
			// Se parsean los datos ingresados
			int consumo = Integer.parseInt(txtConsumo.getText());
			double tarifa = Double.parseDouble(txtTarifa.getText());
			double subsidio = Double.parseDouble(txtSubsidio.getText());
			
			// Conexion a la clase de logica de negocio de nuestra aplicacion
			miProceso.tomarDatos(consumo, tarifa, subsidio);
			
			// esta varible mostrara el valor a pagar de la factura 
			int totalPagar = miProceso.mostrarTotal();
			
			// Se imprime el valor de toda la factura !!
			System.out.println("Factura = " + totalPagar);
			
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

	}
