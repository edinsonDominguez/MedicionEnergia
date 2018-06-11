package helpers;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Componentes implements MouseListener {

	// method Color.decode("") nos permite utilizar los colores hexadecimales 
	
	private JButton btnSalir;
	FormatoPosicion pos;
	
	// method constructor
	
	public Componentes(){
		
		pos = new FormatoPosicion();
		
	}
	
	public JPanel panelPrincipal(){
		// este componente es para el panel principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(Color.decode("#bdbdbd"));
		return panelPrincipal;
	}
	
	public JPanel form(){
		
		JPanel formulario = new JPanel();
		formulario.setLayout(null);
		formulario.setBackground(Color.decode("#ffffff"));
		return formulario;
	}
	
	public JPanel header(){
		
		JPanel header = new JPanel();		
		header.setLayout(null);
		header.setBackground(Color.decode("#424242"));
		
		return header;
	}
	
	
	public JLabel tituloPrincipal(String nombreLabel){
		// este componente es para el Titulo Principal 
		JLabel tituloPrincipal = new JLabel(nombreLabel);
		tituloPrincipal.setForeground(Color.decode("#424242"));
		tituloPrincipal.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
		return tituloPrincipal;
	}
	
	public JLabel lblValidacion(String nombre){
		//este componente es para las validaciones
		JLabel lblValidacion = new JLabel(nombre);
		lblValidacion.setForeground(Color.decode("#b71c1c"));
		lblValidacion.setFont(new Font("Arial", Font.ITALIC, 11));
		return lblValidacion;
	}
	
	
	public JLabel lblCampo(String nombre){
		// Este componente es para los campos de registro
		JLabel lblCampo = new JLabel(nombre);
		lblCampo.setForeground(Color.decode("#212121"));
		lblCampo.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		return lblCampo;
	}
	
	
	public JTextField input(){
		// Este componente es para los inputs o campos de Texto
		JTextField entrada = new JTextField();
		entrada.setForeground(Color.decode("#424242"));
		entrada.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		return entrada;
	}
	
	
	public JButton botonRegistro(String nombre){
		
		JButton botonRegistro = new JButton(nombre);
		
		
		return botonRegistro;
	}

	public JButton botonSalir(String nombre){
		btnSalir = new JButton(nombre);
		btnSalir.addMouseListener(this);
		btnSalir.setBounds(pos.colG, pos.row11, 120, 40);
		return btnSalir;
	}
	
	public JLabel simbolo(String simbolo){
		
		JLabel nuevo = new JLabel(simbolo);
		nuevo.setForeground(Color.decode("#424242"));
		nuevo.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));	
		return nuevo;
	}
	
	public JPasswordField password(){
		
		JPasswordField pass = new JPasswordField();
		pass.setForeground(Color.decode("#424242"));
		pass.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		return pass;
	}
	
	
	public JPanel aside(){
		
		JPanel aside = new JPanel();
		aside.setBackground(Color.decode("#616161"));
		aside.setLayout(null);
		return aside;
	}
	
	
	public JLabel opcionUsuario(String nombre){
		JLabel opcion = new JLabel(nombre);
		opcion.setFont(new Font("Arial", Font.BOLD, 16));
		opcion.setBackground(Color.decode("#424242"));		
		opcion.setForeground(Color.decode("#ffffff"));
		opcion.addMouseListener(this);
		
		return opcion;			
	}
	
	public JPanel section(){
		
		JPanel section = new JPanel();
		section.setBackground(Color.decode("#ffffff"));
		section.setLayout(null);
		section.setBounds(185, 65, 1050, 530);
		return section;
	}
	
	public JLabel tituloSection(String nombre){
		
		JLabel tituloSection = new JLabel(nombre);
		tituloSection.setForeground(Color.decode("#424242"));
		tituloSection.setFont(new Font("Arial", Font.CENTER_BASELINE, 26));
		tituloSection.setBounds(20,20, 200, 40);
		return tituloSection;
	}
	
	public JLabel subtituloSection(String nombre){
		
		JLabel subTitulo = new JLabel(nombre);
		subTitulo.setForeground(Color.decode("#424242"));
		subTitulo.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		return subTitulo;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(btnSalir == e.getSource()){
			System.exit(0);
		}
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
			
	}

	@Override
	public void mouseExited(MouseEvent e) {
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
