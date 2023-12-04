package com.uce.edu.service;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaService {
	
	public Matricula seleccionar(String cedula);

	public Matricula seleccionarEliminar(String cedula);

	public void insertar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminar(String cedula);
	
	public void crearMatricula(String cedula, String placa);

}
