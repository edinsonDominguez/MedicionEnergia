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
	
	
	public JPasswordField password(){
		
		JPasswordField pass = new JPasswordField();
		pass.setForeground(Color.decode("#424242"));
		pass.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		return pass;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(btnSalir == e.getSource()){
			System.exit(0);
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
