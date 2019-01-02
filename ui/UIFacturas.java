package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import helpers.Componentes;
import helpers.FormatoPosicion;
import procesos.ProcesoFactura;
import vo.Factura;

public class UIFacturas extends JDialog implements MouseListener {

	String fechaVenci = "";
	
	// elemento JTable
		JTable miTabla;
		JScrollPane miBarra;
		
	// Usuarios
	String nombreUsuario;
	ProcesoFactura procesoFactura;
	
	// Variables de Diseño
	Componentes com;
	FormatoPosicion pos;
	
	JButton btnEliminar;
	JPanel contentPane;
	
	public UIFacturas(){
		
	
		com = new Componentes();
		pos = new FormatoPosicion();
		procesoFactura = new ProcesoFactura();
		
		setSize(1050, 530);
		setTitle("Mas facturas.");
		setLocationRelativeTo(null);
	
	//	componentes();
	}
	
	
	private void componentes() {
		
		System.out.println("Estamos en el metodo componentes ");
		contentPane = com.section();
		add(contentPane);
		
		JLabel nombreFactura = com.lblCampo("Mis Facturas.");
		nombreFactura.setBounds(20, 20, 120, 30);
		contentPane.add(nombreFactura);
		
		btnEliminar = com.botonRegistro("Eliminar");
		btnEliminar.setBounds(400, 460, 150, 30);
		btnEliminar.addMouseListener(this);
		contentPane.add(btnEliminar);
		
		
		informacionFacturas();
	}


	private void informacionFacturas() {
		
		System.out.println("Estamos en el metodo informacion facturas");
		
		miBarra = new JScrollPane();
		miBarra.setBounds(20, 50, 1000, 400);
		contentPane.add(miBarra);
		
		contruirTabla();

			
	}
	

	private void contruirTabla() {
		
		String titulos [] = {"Fecha ", "Consumo_General", "Subsidio_Estado",
				"Alumbrado_Publico" , "Valor_Total "};
		
		String informacion [] [] = obtenerMatriz();
		
		miTabla = new JTable(informacion, titulos);
		miTabla.addMouseListener(this);
		miBarra.setViewportView(miTabla);
	
	}

	private String[][] obtenerMatriz() {

		/* Obtenemos la informacion de base de datos*/
		ArrayList<Factura> listaFacturas = procesoFactura.listaFacturas(getNombreUsuario());
		
		String matrizInfo [][] = new String[listaFacturas.size()][5];
		
		for (int i = 0; i < listaFacturas.size(); i++) {
			
			System.out.println("Factura UIFacturas " + listaFacturas.get(i).getFechaFactura());
			matrizInfo[i] [0] = listaFacturas.get(i).getFechaFactura();
			matrizInfo[i] [1] = listaFacturas.get(i).getConsumoActivo() + " $";
			matrizInfo[i] [2] = listaFacturas.get(i).getSubsidioNacion() + " $";
			matrizInfo[i] [3] = listaFacturas.get(i).getAlumbradoPublico() + " $";
			matrizInfo[i] [4] = listaFacturas.get(i).getTotalPagar() + " $";
		}
		
		
		return matrizInfo;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		/* La Accion de los botones o Labels*/
		
		if(miTabla == e.getSource()){
			System.out.println(miTabla.getSelectedRow());
			System.out.println(miTabla.getSelectedColumn());
			// se obtiene la fecha de vencimiento
			System.out.println(miTabla.getModel().getValueAt(miTabla.getSelectedRow(), 0));
		
			fechaVenci = miTabla.getModel().getValueAt(miTabla.getSelectedRow(), 0) + "";
			
		}
		
		if(btnEliminar == e.getSource()){
			System.out.println("fecha = " + fechaVenci);
			String estado = procesoFactura.eliminarFactura(fechaVenci);
			
			if(estado.equals("ok")){
				JOptionPane.showMessageDialog(null, "Factura eliminada !!");
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


	// Get and Set
	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	
	// recibimos el usuario puesto en el login
				public void recibirNombre(String nombreUsuario){
					
					
					System.out.println("Nombre Usuario: " + nombreUsuario + " en UIFacturas");
					/*setNombreUsuario(login.getNombreUsuario());
				*/
					// contenemos en el valor
					setNombreUsuario(nombreUsuario);
					
					
					//hace visible la lista de componentes
					componentes();
				}

}
