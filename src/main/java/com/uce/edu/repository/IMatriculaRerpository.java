package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;

public interface IMatriculaRerpository {

	public Matricula seleccionar(String cedula);

	public Matricula seleccionarEliminar(String cedula);

	public void insertar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminar(String cedula);
}
