package com.cmancode.salon.modelo;


public class Estudiante {
	
	
	private String nombre;
	private int fila;
	private int columna;
	
	
	public Estudiante() {}
	
	public Estudiante(String nombre, int fila, int columna) {
		this.nombre = nombre;
		this.fila = fila;
		this.columna = columna;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
		
}
