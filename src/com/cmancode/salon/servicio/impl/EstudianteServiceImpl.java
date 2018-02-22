package com.cmancode.salon.servicio.impl;

import com.cmancode.salon.modelo.Estudiante;
import com.cmancode.salon.servicio.IEstudianteService;

public class EstudianteServiceImpl implements IEstudianteService {
	
	private String[][] sillas = new String[6][6];
	
	@Override
	public void save(Estudiante e) {
		this.sillas[e.getFila()][e.getColumna()] = e.getNombre();
	}

	@Override
	public String[][] estudiantes() {
		return this.sillas;
	}

}
