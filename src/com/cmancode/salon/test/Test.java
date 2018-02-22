package com.cmancode.salon.test;

import com.cmancode.salon.modelo.Estudiante;
import com.cmancode.salon.servicio.impl.EstudianteServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		
		String[][] datos;
		
		Estudiante estudiante = new Estudiante("Carlos",1, 1);
		Estudiante estudiante1 = new Estudiante("José",2, 1);
		Estudiante estudiante2 = new Estudiante("Camilo",1, 5);
		EstudianteServiceImpl estudianteService = new EstudianteServiceImpl();
		
		estudianteService.save(estudiante);
		estudianteService.save(estudiante1);
		estudianteService.save(estudiante2);
		datos = estudianteService.estudiantes();
		
		System.out.println("Estudiante "+ datos[estudiante.getFila()][estudiante.getColumna()] +" Guardado");
		
		for(int i=0; i<6; i++) {
			for(int c=0; c<6; c++) {
				if(datos[i][c] == null) {
					System.out.print("0");
				}else {
					System.out.print(datos[i][c]+" ");
				}
			}
			System.out.println("");
		}
		
	}

}
