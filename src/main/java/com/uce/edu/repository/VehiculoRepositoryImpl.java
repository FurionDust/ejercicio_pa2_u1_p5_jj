package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	public List<Vehiculo> base = new ArrayList<Vehiculo>();

	@Override
	public Vehiculo seleccionar(String placa) {
		// TODO Auto-generated method stub
		for (Vehiculo vehiculo : base) {
			if (vehiculo.getPlaca().equals(placa)) {
				Vehiculo carro = new Vehiculo();
				carro.setPlaca(vehiculo.getPlaca());
				carro.setMarca(vehiculo.getMarca());
				carro.setPrecio(vehiculo.getPrecio());
				carro.setTipo(vehiculo.getTipo());
				return carro;
			}
		}
		return null;
	}

	@Override
	public Vehiculo seleccionarEliminar(String placa) {
		// TODO Auto-generated method stub
		for (Vehiculo vehiculo : base) {
			if (vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		return null;
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		base.add(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = this.seleccionarEliminar(placa);
		base.remove(placa);

	}

}
