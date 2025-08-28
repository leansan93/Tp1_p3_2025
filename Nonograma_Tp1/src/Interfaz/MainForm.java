package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import Negocio.Tabla;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm {

	private JFrame frame;
	 
	private JToggleButton[][] botones;
	private Tabla tabla ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nanograma");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel.setBounds(157, 11, 102, 50);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
		
		JPanel panelMatriz = new JPanel();
		panelMatriz.setBackground(new Color(255, 255, 240)); // agregado el setBackground 
		panelMatriz.setBounds(138, 95, 286, 155);
		frame.getContentPane().add(panelMatriz);
		panelMatriz.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnConfirmarTabla = new JButton("Confirmar ");
		btnConfirmarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnConfirmarTabla.setBounds(0, 227, 89, 23);
		frame.getContentPane().add(btnConfirmarTabla);
		
		JPanel pistasColumnas = new JPanel();
		pistasColumnas.setBounds(138, 74, 286, 23);
		frame.getContentPane().add(pistasColumnas);
		
		JPanel pistasFilas = new JPanel();
		pistasFilas.setBounds(118, 97, 21, 153);
		frame.getContentPane().add(pistasFilas);
		/// BOTON DE CREAR TABLA 5X5
		
		
		
		JButton btnTabla = new JButton("tabla 5x5");
		btnTabla.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
				Tabla tabla = new Tabla (5);
				int fila = tabla.getFila();
				int columna = tabla.getColumna();
				botones = new JToggleButton [fila][columna];
				panelMatriz.removeAll(); // limpia antes por si había otra tabla
			    panelMatriz.setLayout(new GridLayout(fila, columna, 2, 2));

			        for(int fil = 0; fil < fila; fil++) {
			            for(int col = 0; col < columna; col++) {
			                botones[fil][col] = new JToggleButton();
			                botones[fil][col].setOpaque(true);
			                 
			                botones[fil][col].setBackground(Color.WHITE);
			                panelMatriz.add(botones[fil][col]);
			                
			            }
			        }
			

			        panelMatriz.revalidate();
			        panelMatriz.repaint();
			    
						
			}
		});
		btnTabla.setBounds(10, 84, 89, 23);
		frame.getContentPane().add(btnTabla);
	
		
	}
}
