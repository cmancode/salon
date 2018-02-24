package com.cmancode.salon.servicio;

import java.util.List;

import com.cmancode.salon.modelo.Estudiante;

public interface IEstudianteService {
	
	public void save(Estudiante estudiante);
	public List<Estudiante> getEstudiantes();
}
