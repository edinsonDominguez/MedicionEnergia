package ui;

	import javax.swing.*;

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
		
		// clases 
		ProcesoFactura miProceso;
		ValidarCampos validar;
		FormatoPosicion pos;
		
		// variables validaciones
		String resultadoConsumo = "", resultadoTarifa = "", resultadoSubsidio = "";
		
		
		public Factura() {
			System.out.println("Esta en la clase uiFactura");
			
			miProceso = new ProcesoFactura();
			validar = new ValidarCampos();
			pos = new FormatoPosicion();
			
			setSize(1000,1000);
			setLocationRelativeTo(null);
			componentes();
		}
			
		private void componentes(){
			
			
			contentPane = new JPanel();
			contentPane.setLayout(null);
				
			setContentPane(contentPane);
			
			JLabel lblTitulo = new JLabel("Registro factura: ");
			lblTitulo.setBounds(pos.colC, pos.row1, 400, 30);
			lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
			contentPane.add(lblTitulo);
			
			JLabel lblConsumo = new JLabel("Consumo: ");
			lblConsumo.setFont(new Font("Arial", Font.BOLD, 14));
			lblConsumo.setBounds(pos.colA, pos.row2, 120, 20);
			contentPane.add(lblConsumo);
			
			txtConsumo = new JTextField();
			txtConsumo.setBounds(pos.colB, pos.row2, 120, 20);
			contentPane.add(txtConsumo);
			
			
			lblErrorConsumo = new JLabel();
			lblErrorConsumo.setFont(new Font("Arial", Font.BOLD, 14));
			lblErrorConsumo.setBounds(pos.colC, pos.row2, 120, 20);
			contentPane.add(lblErrorConsumo);
			
			
			JLabel lblTarifa = new JLabel("Tarifa: ");
			lblTarifa.setFont(new Font("Arial", Font.BOLD, 14));
			lblTarifa.setBounds(pos.colA, pos.row3, 120, 20);
			contentPane.add(lblTarifa);
			
			txtTarifa = new JTextField();
			txtTarifa.setBounds(pos.colB, pos.row3, 120, 20);
			contentPane.add(txtTarifa);
			
			lblErrorTarifa = new JLabel();
			lblErrorTarifa.setFont(new Font("Arial", Font.BOLD, 14));
			lblErrorTarifa.setBounds(pos.colC, pos.row3, 120, 20);
			contentPane.add(lblErrorTarifa);
			
			JLabel lblSubsidio = new JLabel("Subsidio: ");
			lblSubsidio.setFont(new Font("Arial", Font.BOLD, 14));
			lblSubsidio.setBounds(pos.colA, pos.row4, 120, 20);
			contentPane.add(lblSubsidio);
			
			txtSubsidio = new JTextField();
			txtSubsidio.setBounds(pos.colB, pos.row4, 120, 20);
			contentPane.add(txtSubsidio);
			
			lblErrorSubsidio = new JLabel();
			lblErrorSubsidio.setFont(new Font("Arial", Font.BOLD, 14));
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
