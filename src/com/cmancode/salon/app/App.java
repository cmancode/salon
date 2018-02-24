package com.cmancode.salon.app;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.cmancode.salon.modelo.Estudiante;
import com.cmancode.salon.servicio.impl.EstudianteServiceImpl;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class App extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtNombre;
	private JTextField txtFila;
	private JTextField txtColum;
	private JTable table;
	private JTextField txtFilaConsilta;
	private JTextField txtColConsulta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setTitle("Salón");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 480, 388);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estudiante");
		lblNewLabel.setBounds(24, 33, 95, 15);
		getContentPane().add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(137, 27, 235, 28);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtFila = new JTextField();
		txtFila.setBounds(137, 67, 54, 19);
		getContentPane().add(txtFila);
		txtFila.setColumns(10);
		
		txtColum = new JTextField();
		txtColum.setColumns(10);
		txtColum.setBounds(137, 93, 54, 19);
		getContentPane().add(txtColum);
		
		JLabel lblFila = new JLabel("Fila");
		lblFila.setBounds(24, 69, 95, 15);
		getContentPane().add(lblFila);
		
		JLabel lblColumna = new JLabel("Columna");
		lblColumna.setBounds(24, 95, 95, 15);
		getContentPane().add(lblColumna);
		
		
		Estudiante estudiante = new Estudiante();
		EstudianteServiceImpl eImpl = new EstudianteServiceImpl();
		
		JButton btnAsignar = new JButton("Asignar"); 
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Proceso para realizar la consulta de todos los estudiantes
				int fila, col;
				String nombre;
				nombre = txtNombre.getText();
				fila = Integer.parseInt(txtFila.getText());
				col = Integer.parseInt(txtColum.getText());
				
				estudiante.setNombre(nombre);
				estudiante.setFila(fila);
				estudiante.setColumna(col);
				eImpl.save(estudiante);
				
				//Expresión Lambda para llenar la tabla con estudiantes
				eImpl.getEstudiantes().forEach(
					estududiante ->  table.setValueAt(estudiante.getNombre(), estudiante.getFila(), estudiante.getColumna())
				);
				
			}
		});
		
		btnAsignar.setBounds(204, 64, 168, 48);
		getContentPane().add(btnAsignar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		table.setBounds(12, 167, 450, 80);
		getContentPane().add(table);
		
		JLabel lblEstudiantesSaln = new JLabel("Estudiantes - Salón de clases");
		lblEstudiantesSaln.setBounds(137, 140, 223, 15);
		getContentPane().add(lblEstudiantesSaln);
		
		JLabel label = new JLabel("Fila");
		label.setBounds(12, 271, 95, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Columna");
		label_1.setBounds(12, 300, 95, 15);
		getContentPane().add(label_1);
		
		txtFilaConsilta = new JTextField();
		txtFilaConsilta.setColumns(10);
		txtFilaConsilta.setBounds(82, 269, 54, 19);
		getContentPane().add(txtFilaConsilta);
		
		txtColConsulta = new JTextField();
		txtColConsulta.setColumns(10);
		txtColConsulta.setBounds(82, 298, 54, 19);
		getContentPane().add(txtColConsulta);
		
		JLabel lblEstudiante = new JLabel("-------");
		lblEstudiante.setBounds(269, 298, 70, 15);
		getContentPane().add(lblEstudiante);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int fila;
				int col;
				fila = Integer.parseInt(txtFilaConsilta.getText());
				col = Integer.parseInt(txtColConsulta.getText());
				
				eImpl.getEstudiantes().forEach(
						estudiante -> {
							if(estudiante.getFila() == fila && estudiante.getColumna() == col) {
								lblEstudiante.setText(estudiante.getNombre());
							}
						}
				);
				
				
			}
		});
		btnConsultar.setBounds(12, 321, 127, 25);
		getContentPane().add(btnConsultar);
		
	}
}
