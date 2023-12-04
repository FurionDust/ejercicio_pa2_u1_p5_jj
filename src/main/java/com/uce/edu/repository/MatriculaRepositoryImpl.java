package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRerpository {

	public List<Matricula> base = new ArrayList<Matricula>();

	@Override
	public Matricula seleccionar(String cedula) {
		// TODO Auto-generated method stub
		for (Matricula matricula : base) {
			if (matricula.getPropietario().getCedula().equals(cedula)) {
				Matricula mat = new Matricula();
				mat.setFechaMatricula(matricula.getFechaMatricula());
				mat.setPropietario(matricula.getPropietario());
				mat.setValorMatricula(matricula.getValorMatricula());
				mat.setVehiculo(matricula.getVehiculo());
				return mat;
			}
		}
		return null;
	}

	@Override
	public Matricula seleccionarEliminar(String cedula) {
		// TODO Auto-generated method stub
		for (Matricula matricula : base) {
			if (matricula.getPropietario().getCedula().equals(cedula)) {
				return matricula;
			}
		}
		return null;
	}

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		base.add(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.eliminar(matricula.getPropietario().getCedula());
		this.insertar(matricula);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Matricula matricula = this.seleccionarEliminar(cedula);
		base.remove(cedula);

	}

}
