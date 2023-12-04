package com.uce.edu.service;

import com.uce.edu.repository.modelo.Vehiculo;

public interface IVehiculoService {
	
	public Vehiculo seleccionar(String placa);

	public Vehiculo seleccionarEliminar(String placa);

	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);

}
