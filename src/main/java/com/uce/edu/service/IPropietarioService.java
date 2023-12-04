package com.uce.edu.service;

import com.uce.edu.repository.modelo.Propietario;

public interface IPropietarioService {

	
	public Propietario seleccionar(String cedula);

	public Propietario seleccionarEliminar(String cedula);

	public void insertar(Propietario propietario);

	public void actualizar(Propietario propietario);

	public void eliminar(String cedula);
}
