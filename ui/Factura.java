package ui;

	import javax.swing.*;

import procesos.ProcesoFactura;

import java.awt.Font;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;

	public class Factura extends JFrame implements MouseListener {

		private JPanel contentPane;
		private JTextField txtConsumo, txtTarifa, txtSubsidio;
		private JButton registro;
		ProcesoFactura miProceso;
		
		public Factura() {
			
			miProceso = new ProcesoFactura();
			
			setSize(1000,1000);
			setLocationRelativeTo(null);
			componentes();
		}
			
		private void componentes(){
			
			/* Este sistema ayudara a organizar los componentes dentro de la ventana 
			 * */
			
			/*    1 2 3 4 5
			 *  A * * * * *
			 *  B * * * * *
			 *  C * * * * *
			 *  D * * * * * 
			 *  */
			
			/* Para esta interfaz usuario 
			 *    1 2 3 4 5
			 *  A * * *	* *
			 *  B * * * * *
			 *  C * * * * *
			 *  D * * * * *
			 *  E * * * * *
			 *  */
			
			// columna yPrimera A1, B1, C1, D1
			int yPrimera = 20;
			
			// columna ySegunda A2, B2, C2, D2
			int ySegunda = 160;
			
			// columna yTercera A3, B3, C3, D3
			int yTercera = 300;
			
			// columna yCuarta A4, B4, C4, D4
			int yCuarta = 440;
			
			//  columna yQuinta A5, B5, C5, D5
			int yQuinta = 580;
			
			
			// filas de la ui
			
			// fila xPrimera A1, A2, A3
			int xPrimera = 20;
			
			// fila xSegunda A2, B2, C2
			int xSegunda = 60;
			
			// fila xTercera A3, B3, C3
			int xTercera = 100;
			
			// fila xCuarta A4, B4, C4
			int xCuarta = 140;
			
			// fila xQuinta A5, B5, C5 ....
			int xQuinta = 180;
			
			contentPane = new JPanel();
			contentPane.setLayout(null);
				
			setContentPane(contentPane);
			
			JLabel lblTitulo = new JLabel("Registro factura: ");
			lblTitulo.setBounds(yTercera, xPrimera, 400, 30);
			lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
			contentPane.add(lblTitulo);
			
			JLabel lblConsumo = new JLabel("Consumo: ");
			lblConsumo.setFont(new Font("Arial", Font.BOLD, 14));
			lblConsumo.setBounds(yPrimera, xSegunda, 120, 20);
			contentPane.add(lblConsumo);
			
			txtConsumo = new JTextField();
			txtConsumo.setBounds(ySegunda, xSegunda, 120, 20);
			contentPane.add(txtConsumo);
			
			
			JLabel lblTarifa = new JLabel("Tarifa: ");
			lblTarifa.setFont(new Font("Arial", Font.BOLD, 14));
			lblTarifa.setBounds(yPrimera, xTercera, 120, 20);
			contentPane.add(lblTarifa);
			
			txtTarifa = new JTextField();
			txtTarifa.setBounds(ySegunda, xTercera, 120, 20);
			contentPane.add(txtTarifa);
			
			JLabel lblSubsidio = new JLabel("Subsidio: ");
			lblSubsidio.setFont(new Font("Arial", Font.BOLD, 14));
			lblSubsidio.setBounds(yPrimera, xCuarta, 120, 20);
			contentPane.add(lblSubsidio);
			
			txtSubsidio = new JTextField();
			txtSubsidio.setBounds(ySegunda, xCuarta, 120, 20);
			contentPane.add(txtSubsidio);
			
			
			registro = new JButton("Registrar");
			registro.setBounds(yTercera, xQuinta, 120, 30);
			registro.setFont(new Font("Arial", Font.BOLD, 14));
			registro.addMouseListener(this);
			contentPane.add(registro);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == registro){
			
				System.out.println("presiono en registro !!");
				String validacion = "";
			
				validacion = miProceso.validarCampos(txtConsumo.getText(), txtTarifa.getText(), txtSubsidio.getText());	
						
				
				
				if(validacion.equals("ok")){
					conectarLogicaNegocio();					
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
			double totalPagar = miProceso.mostrarTotal();
			
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
