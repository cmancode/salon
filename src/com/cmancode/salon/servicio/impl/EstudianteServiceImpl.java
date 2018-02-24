package com.cmancode.salon.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import com.cmancode.salon.modelo.Estudiante;
import com.cmancode.salon.servicio.IEstudianteService;

public class EstudianteServiceImpl implements IEstudianteService {

	private List<Estudiante> estudiantes;
	
	//Constructor
	public EstudianteServiceImpl() {
		this.estudiantes = new ArrayList<Estudiante>();
	}
	
	@Override
	public void save(Estudiante e) {
		estudiantes.add(e);
	}

	@Override
	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}



}
