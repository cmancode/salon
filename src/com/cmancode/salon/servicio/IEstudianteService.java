package com.cmancode.salon.servicio;

import com.cmancode.salon.modelo.Estudiante;

public interface IEstudianteService {
	
	public void save(Estudiante estudiante);
	public String[][] estudiantes();
}
