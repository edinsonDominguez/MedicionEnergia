package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;


import helpers.Componentes;
import helpers.FormatoPosicion;
import procesos.ProcesoCompo;
import vo.Domestico;

public class UIComponente extends JDialog implements MouseListener {

		String nombre;
	// elemento JTable
		JTable miTabla;
		JScrollPane miBarra;
		
		
		
		// Usuarios
		String nombreUsuario;
		ProcesoCompo procesoCompo;
		
		// Variables de Diseño
		Componentes com;
		FormatoPosicion pos;
		
		JButton btnEliminar;
		JPanel contentPane;
		
		
		public UIComponente(){
			
			com = new Componentes();
			pos = new FormatoPosicion();
			procesoCompo = new ProcesoCompo();
			
			setSize(1050, 530);
			setTitle("Mas electrodomestico.");
			setLocationRelativeTo(null);
		
			
		}
		
		private void componentes() {
			
			contentPane = com.section();
			add(contentPane);
			
			JLabel nombreFactura = com.lblCampo("Mis Electrodomesticos.");
			nombreFactura.setBounds(20, 20, 120, 30);
			contentPane.add(nombreFactura);
			
			btnEliminar = com.botonRegistro("Eliminar");
			btnEliminar.setBounds(400, 460, 150, 30);
			btnEliminar.addMouseListener(this);
			contentPane.add(btnEliminar);
		
			informacionComponente();
		}

		private void informacionComponente() {
			
			miBarra = new JScrollPane();
			miBarra.setBounds(20, 50, 1000, 400);
			contentPane.add(miBarra);
			
			construirTabla();
		}

		private void construirTabla() {
			String titulos [] = {"Nombre_Electrodomestico", "Watts (W)", "Horas_Consumo", 
					"Consumo_Dia ($) ", "Consumo_Semana ($)", "Consumo_Mes ($)" };
			
			String informacion [] [] = obtenerMatriz();
			
			miTabla = new JTable(informacion, titulos);
			miTabla.addMouseListener(this);
			miBarra.setViewportView(miTabla);

			
		}

		private String[][] obtenerMatriz() {

			/* Obtenemos la informacion de base de datos*/
			ArrayList<Domestico> listaCompo = procesoCompo.listaComponentes(getNombreUsuario());
			
			System.out.println("ListaCompo = " + listaCompo.size());
			
			String matrizInfo [][] = new String[listaCompo.size()][6];
			
			for (int i = 0; i < listaCompo.size(); i++) {
				
				System.out.println("Factura UIFacturas " + listaCompo.get(i).getNombreCompo());
				matrizInfo[i] [0] = listaCompo.get(i).getNombreCompo();
				matrizInfo[i] [1] = listaCompo.get(i).getVatios() + " W";
				matrizInfo[i] [2] = listaCompo.get(i).getHorasConsumo() + " Hrs";
				matrizInfo[i] [3] = listaCompo.get(i).getPrecioDia() + " $";
				matrizInfo[i] [4] = listaCompo.get(i).getPrecioSemana() + " $";
				matrizInfo[i] [5] = listaCompo.get(i).getPrecioMes() + " $";
				
			}
			
			return matrizInfo;
		}

		// Get and Set
		public String getNombreUsuario() {
			return nombreUsuario;
		}

		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}
		
		// recibimos el usuario puesto en el login
		public void recibirNombre(String nombreUsuario){
						
			System.out.println("Nombre Usuario: " + nombreUsuario + " en UIComponente");
			/*setNombreUsuario(login.getNombreUsuario()); */
			// contenemos en el valor
			setNombreUsuario(nombreUsuario);
						
			//hace visible la lista de componentes
			componentes();
						
			}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			if(miTabla == e.getSource()){
			
				System.out.println(miTabla.getSelectedRow());
				System.out.println(miTabla.getSelectedColumn());
				// se obtiene la fecha de vencimiento
				System.out.println(miTabla.getModel().getValueAt(miTabla.getSelectedRow(), 0));
			
				nombre = miTabla.getModel().getValueAt(miTabla.getSelectedRow(), 0) + "";
				
			}
			
			if(btnEliminar == e.getSource()){
				
				System.out.println("nombre Usuario = " + getNombreUsuario());
				
				String estado = procesoCompo.eliminarElectro(nombre, getNombreUsuario());
				
				if(estado.equals("ok")){
					JOptionPane.showMessageDialog(null, "Electrodomestico eliminado !!");
					System.out.println(miTabla.getSelectedRow());
					
					this.dispose();
				}
				
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
